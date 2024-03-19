

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.zcy.domain.Item;
import com.zcy.domain.JMHResult;
import com.zcy.domain.Template;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyUtil {

    public static void main(String[] args) {
        String JMH_RESULT_FILE = args[0];
        String OUT_FINAL_FILE = args[1];
        File jmhResultFile = new File(JMH_RESULT_FILE);
        if (!jmhResultFile.exists()) {
            try {
                jmhResultFile.createNewFile();
                FileUtil.writeUtf8String("[]", jmhResultFile);
            } catch (IOException var14) {
                throw new RuntimeException(var14);
            }
        }

        String jmh = FileUtil.readString(JMH_RESULT_FILE, StandardCharsets.UTF_8);
        System.out.println(jmh);
        List<JMHResult> resultList = JSONUtil.toList(JSONUtil.parseArray(jmh), JMHResult.class);
        Map<String, List<Item>> collect = resultList.stream()
                .map(a -> Item.builder().time(Long.valueOf(a.getParams().get("time"))).score(a.getPrimaryMetric().getScore()).serialization(a.getParams().get("serialization")).build())
                .collect(Collectors.toMap(Item::getSerialization, ListUtil::toList, (oldList, newList) -> {
                    oldList.addAll(newList);
                    return oldList;
                }));

        ArrayList<Template> templateList = new ArrayList<>(4);

        for (Map.Entry<String, List<Item>> entry : collect.entrySet()) {
            //按时间升序
            List<Item> sortItemList = entry.getValue().stream().sorted(Comparator.comparing(Item::getTime)).collect(Collectors.toList());

            Template template = new Template();
            //时间
            template.getValues().add(sortItemList.stream().map((a) -> a.getTime().doubleValue()).collect(Collectors.toList()));
            //分数
            template.getValues().add(sortItemList.stream().map(Item::getScore).collect(Collectors.toList()));

            switch (entry.getKey()) {
                case "hession2":
                    //相应位置插入
                    ListUtil.setOrPadding(templateList, 0, template, new Template());
                    break;
                case "fastjson2":
                    ListUtil.setOrPadding(templateList, 1, template, new Template());
                    break;
                case "kryo":
                    ListUtil.setOrPadding(templateList, 2, template, new Template());
            }

        }

        //输出到文件
        FileUtil.writeUtf8String(JSONUtil.toJsonStr(templateList), OUT_FINAL_FILE);
    }
}
