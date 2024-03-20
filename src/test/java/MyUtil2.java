

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.zcy.domain.Item;
import com.zcy.domain.JMHResult;
import com.zcy.domain.Template;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyUtil2 {

    public static void main(String[] args) {

        List<String> filterSerialization = ListUtil.toList(args[0]);
        List<String> filterProtocol = ListUtil.toList(args[1]);

        String jmh = args[0];
        System.out.println(jmh);

        List<JMHResult> resultList = JSONUtil.toList(JSONUtil.parseArray(jmh), JMHResult.class);
        Map<String, List<Item>> collect = resultList.stream()
                .map(a -> Item.builder().time(Long.valueOf(a.getParams().get("time"))).score(a.getPrimaryMetric().getScore()).serialization(a.getParams().get("serialization")).build())
                .filter(a -> filterSerialization.contains(a.getSerialization()) && filterProtocol.contains(a.getProtocol()))
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

        //转为json
        System.out.println(JSONUtil.toJsonStr(templateList));
    }
}
