package com.zcy.common;

import java.util.List;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.system.SystemUtil;
import com.alibaba.fastjson2.JSON;
import com.zcy.consumer.Client;
import com.zcy.domain.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.dubbo.common.profiler.Profiler;
import org.apache.dubbo.common.profiler.ProfilerEntry;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.springframework.boot.system.ApplicationHome;

public class Convert {

    public static final String FILE_PATH;

    public static final String TMP_PATH;

    public static final String JMH_FINAL_FILE;

    public static final String OUT_FINAL_FILE;

    public static final String PROFILER_FILE;

    static {
//        String path;
//        try {
//            path = ResourceUtils.getURL("classpath:").getPath();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        String path;
        if (SystemUtil.getOsInfo().isWindows()) {
            path = "C:/tmp/";
        } else {
            path = "/tmp/";
        }

        File upload = new File(path, "static/");
        if (!upload.exists()) {
            upload.mkdirs();
        }
        FILE_PATH = upload.getAbsolutePath();

        File tmp = new File(path, "jmh_result/");
        if (!tmp.exists()) {
            tmp.mkdirs();
        }
        TMP_PATH = tmp.getAbsolutePath();

        JMH_FINAL_FILE = FILE_PATH + File.separator + "jmh.json";
        File jmhFinalFile = new File(JMH_FINAL_FILE);
        if (!jmhFinalFile.exists()) {
            try {
                jmhFinalFile.createNewFile();
                FileUtil.writeUtf8String("[]", jmhFinalFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        OUT_FINAL_FILE = FILE_PATH + File.separator + "out.json";
        PROFILER_FILE = FILE_PATH + File.separator + "profiler.json";
        System.out.println("upload url:" + upload.getAbsolutePath());
    }

    private static final List<String> serializationList = ListUtil.toList("hession2", "fastjson2", "kryo");

    public static ConcurrentHashMap<String, ProfilerEntry> profilerEntryConcurrentHashMap = new ConcurrentHashMap<>();

    public static void execute() throws RunnerException {
        //执行jmh
        for (String serialization : serializationList) {
            runJmh(serialization);
        }



//        //合并
//        String jmh = FileUtil.readString(JMH_FINAL_FILE, StandardCharsets.UTF_8);
//        List<JMHResult> resultList = JSONUtil.toList(JSONUtil.parseArray(jmh), JMHResult.class);
//
//        for (File file : FileUtil.ls(TMP_PATH)) {
//            String tmpJmh = FileUtil.readString(file, StandardCharsets.UTF_8);
//            try {
//                List<JMHResult> tmpList = JSONUtil.toList(JSONUtil.parseArray(tmpJmh), JMHResult.class);
//                CollectionUtil.addAll(resultList, tmpList);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//
//            FileUtil.del(file);
//        }
//        FileUtil.writeUtf8String(JSON.toJSONString(resultList), JMH_FINAL_FILE);
//
//        //解析
//        Map<String, List<Item>> collect = resultList.stream()
//                .map(a -> Item.builder().time(Long.valueOf(a.getParams().get("time")))
//                        .score(a.getPrimaryMetric().getScore())
//                        .serialization(a.getParams().get("serialization"))
//                        .build())
//                .collect(Collectors.toMap(Item::getSerialization, ListUtil::toList,
//                        (List<Item> oldList, List<Item> newList) -> {
//                            oldList.addAll(newList);
//                            return oldList;
//                        }));
//
//        ArrayList<Template> templateList = new ArrayList<>(4);
//        ArrayList<ProfilerResult> profilerResultList = new ArrayList<>(4);
//
//        for (Map.Entry<String, List<Item>> entry : collect.entrySet()) {
//            List<Item> sortItemList = entry.getValue().stream().sorted(Comparator.comparing(Item::getTime)).collect(Collectors.toList());
//
//            Template template = new Template();
//            template.getValues().add(sortItemList.stream().map(a -> a.getTime().doubleValue()).collect(Collectors.toList()));
//            template.getValues().add(sortItemList.stream().map(Item::getScore).collect(Collectors.toList()));
//
//            ProfilerResult profilerResult = new ProfilerResult();
//            ProfilerEntry profilerEntry = profilerEntryConcurrentHashMap.get(entry.getKey());
//            buildProfiler(profilerEntry, "", profilerResult.getItemList());
//
//            switch (entry.getKey()) {
//                case "hession2":
//                    ListUtil.setOrPadding(templateList, 0, template, new Template());
//                    ListUtil.setOrPadding(profilerResultList, 0, profilerResult, new ProfilerResult());
//                    break;
//                case "fastjson2":
//                    ListUtil.setOrPadding(templateList, 1, template, new Template());
//                    ListUtil.setOrPadding(profilerResultList, 1, profilerResult, new ProfilerResult());
//                    break;
//                case "kryo":
//                    ListUtil.setOrPadding(templateList, 2, template, new Template());
//                    ListUtil.setOrPadding(profilerResultList, 2, profilerResult, new ProfilerResult());
//                    break;
//            }
//        }
//
//        profilerEntryConcurrentHashMap.clear();
//        FileUtil.writeUtf8String(JSON.toJSONString(templateList), OUT_FINAL_FILE);
//        FileUtil.writeUtf8String(JSON.toJSONString(profilerResultList), PROFILER_FILE);
    }

    private static void runJmh(String serialization) throws RunnerException {
        String jmhTempFilePath = TMP_PATH + File.separator + UUID.fastUUID().toString(true) + ".json";

        Options opt = new OptionsBuilder()
                .include(Client.class.getSimpleName())
                .warmupIterations(1)
                .warmupTime(TimeValue.seconds(1))
                .measurementIterations(1)
                .measurementTime(TimeValue.seconds(1))
                .param("serialization", serialization)
                .param("time", System.currentTimeMillis() + "")
                .forks(0)
                .threads(1)
                .resultFormat(ResultFormatType.JSON)
                .result(jmhTempFilePath)
                .build();

        new Runner(opt).run();
    }

    private static void buildProfiler(ProfilerEntry profilerEntry, String parent, List<ProfilerItem> itemList) {
        String message = profilerEntry.getMessage();
        long startTime = profilerEntry.getStartTime();
        long endTime = profilerEntry.getEndTime();
        String name = parseMessage(message);
        long totalUsageTime = profilerEntry.getFirst().getEndTime() - profilerEntry.getFirst().getStartTime();
        long offset = startTime - profilerEntry.getFirst().getStartTime();

        ProfilerItem profilerItem = new ProfilerItem();
        profilerItem.setName(name);
        profilerItem.setOffset(String.format("%.6f", offset / 1000_000.0));
        profilerItem.setPercent(String.format("%.2f", (endTime - startTime) * 100.0 / totalUsageTime));
        profilerItem.setUsage(String.format("%.6f", (endTime - startTime) / 1000_000.0));
        profilerItem.setParent(parent);

        itemList.add(profilerItem);

        List<ProfilerEntry> subList = profilerEntry.getSub();
        for (ProfilerEntry sub : subList) {
            buildProfiler(sub, name, itemList);
        }
    }

    private static String parseMessage(String message) {
        String name = "";
        List<String> split = StrUtil.split(message, " ");
        if ("Filter".equals(split.get(0))) {
            List<String> methodName = StrUtil.split(split.get(1), ".");
            name = methodName.get(methodName.size() - 1);
        } else if ("Router".equals(split.get(0))) {
            name = "Router";
        } else if ("Cluster".equals(split.get(0))) {
            List<String> methodName = StrUtil.split(split.get(1), ".");
            name = methodName.get(methodName.size() - 1);
        } else if ("Receive".equals(split.get(0))) {
            name = "Client-invoke-begin";
        } else if ("Invoker".equals(split.get(0))) {
            name = "Invoker";
        }
        return name;
    }

}