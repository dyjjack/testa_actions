// 获取JMH结果字符串（通常是通过命令行参数传入）
const jmh = "[\n" +
    "  {\n" +
    "    \"jmhVersion\": \"1.35\",\n" +
    "    \"benchmark\": \"org.apache.dubbo.benchmark.demo.test.ConsumerIT.MyBenchmark.getUser\",\n" +
    "    \"mode\": \"avgt\",\n" +
    "    \"threads\": 16,\n" +
    "    \"forks\": 1,\n" +
    "    \"jvm\": \"/usr/local/openjdk-8/jre/bin/java\",\n" +
    "    \"jvmArgs\": [\n" +
    "      \"-javaagent:/usr/local/dubbo/jacocoagent.jar=destfile=/usr/local/dubbo/target-jacoco/1-1710847200904-jacoco.exec\",\n" +
    "      \"-Dzookeeper.address=zookeeper\"\n" +
    "    ],\n" +
    "    \"jdkVersion\": \"1.8.0_342\",\n" +
    "    \"vmName\": \"OpenJDK 64-Bit Server VM\",\n" +
    "    \"vmVersion\": \"25.342-b07\",\n" +
    "    \"warmupIterations\": 1,\n" +
    "    \"warmupTime\": \"1 s\",\n" +
    "    \"warmupBatchSize\": 1,\n" +
    "    \"measurementIterations\": 1,\n" +
    "    \"measurementTime\": \"1 s\",\n" +
    "    \"measurementBatchSize\": 1,\n" +
    "    \"params\": {\n" +
    "      \"serialization\": \"hession2\",\n" +
    "      \"time\": \"1710847222771\"\n" +
    "    },\n" +
    "    \"primaryMetric\": {\n" +
    "      \"score\": 68.39145953244046,\n" +
    "      \"scoreError\": \"NaN\",\n" +
    "      \"scoreConfidence\": [\n" +
    "        \"NaN\",\n" +
    "        \"NaN\"\n" +
    "      ],\n" +
    "      \"scorePercentiles\": {\n" +
    "        \"0.0\": 68.39145953244046,\n" +
    "        \"50.0\": 68.39145953244046,\n" +
    "        \"90.0\": 68.39145953244046,\n" +
    "        \"95.0\": 68.39145953244046,\n" +
    "        \"99.0\": 68.39145953244046,\n" +
    "        \"99.9\": 68.39145953244046,\n" +
    "        \"99.99\": 68.39145953244046,\n" +
    "        \"99.999\": 68.39145953244046,\n" +
    "        \"99.9999\": 68.39145953244046,\n" +
    "        \"100.0\": 68.39145953244046\n" +
    "      },\n" +
    "      \"scoreUnit\": \"ms/op\",\n" +
    "      \"rawData\": [\n" +
    "        [\n" +
    "          68.39145953244046\n" +
    "        ]\n" +
    "      ]\n" +
    "    },\n" +
    "    \"secondaryMetrics\": {}\n" +
    "  },\n" +
    "  {\n" +
    "    \"jmhVersion\": \"1.35\",\n" +
    "    \"benchmark\": \"org.apache.dubbo.benchmark.demo.test.ConsumerIT.MyBenchmark.getUser\",\n" +
    "    \"mode\": \"avgt\",\n" +
    "    \"threads\": 16,\n" +
    "    \"forks\": 1,\n" +
    "    \"jvm\": \"/usr/local/openjdk-8/jre/bin/java\",\n" +
    "    \"jvmArgs\": [\n" +
    "      \"-javaagent:/usr/local/dubbo/jacocoagent.jar=destfile=/usr/local/dubbo/target-jacoco/1-1710841467268-jacoco.exec\",\n" +
    "      \"-Dzookeeper.address=zookeeper\"\n" +
    "    ],\n" +
    "    \"jdkVersion\": \"1.8.0_342\",\n" +
    "    \"vmName\": \"OpenJDK 64-Bit Server VM\",\n" +
    "    \"vmVersion\": \"25.342-b07\",\n" +
    "    \"warmupIterations\": 1,\n" +
    "    \"warmupTime\": \"1 s\",\n" +
    "    \"warmupBatchSize\": 1,\n" +
    "    \"measurementIterations\": 1,\n" +
    "    \"measurementTime\": \"1 s\",\n" +
    "    \"measurementBatchSize\": 1,\n" +
    "    \"params\": {\n" +
    "      \"serialization\": \"hession2\",\n" +
    "      \"time\": \"1710841490040\"\n" +
    "    },\n" +
    "    \"primaryMetric\": {\n" +
    "      \"score\": 13.601807488916137,\n" +
    "      \"scoreError\": \"NaN\",\n" +
    "      \"scoreConfidence\": [\n" +
    "        \"NaN\",\n" +
    "        \"NaN\"\n" +
    "      ],\n" +
    "      \"scorePercentiles\": {\n" +
    "        \"0.0\": 13.601807488916137,\n" +
    "        \"50.0\": 13.601807488916137,\n" +
    "        \"90.0\": 13.601807488916137,\n" +
    "        \"95.0\": 13.601807488916137,\n" +
    "        \"99.0\": 13.601807488916137,\n" +
    "        \"99.9\": 13.601807488916137,\n" +
    "        \"99.99\": 13.601807488916137,\n" +
    "        \"99.999\": 13.601807488916137,\n" +
    "        \"99.9999\": 13.601807488916137,\n" +
    "        \"100.0\": 13.601807488916137\n" +
    "      },\n" +
    "      \"scoreUnit\": \"ms/op\",\n" +
    "      \"rawData\": [\n" +
    "        [\n" +
    "          13.601807488916137\n" +
    "        ]\n" +
    "      ]\n" +
    "    },\n" +
    "    \"secondaryMetrics\": {}\n" +
    "  },\n" +
    "  {\n" +
    "    \"jmhVersion\": \"1.35\",\n" +
    "    \"benchmark\": \"org.apache.dubbo.benchmark.demo.test.ConsumerIT.MyBenchmark.getUser\",\n" +
    "    \"mode\": \"avgt\",\n" +
    "    \"threads\": 16,\n" +
    "    \"forks\": 1,\n" +
    "    \"jvm\": \"/usr/local/openjdk-8/jre/bin/java\",\n" +
    "    \"jvmArgs\": [\n" +
    "      \"-javaagent:/usr/local/dubbo/jacocoagent.jar=destfile=/usr/local/dubbo/target-jacoco/1-1710843603495-jacoco.exec\",\n" +
    "      \"-Dzookeeper.address=zookeeper\"\n" +
    "    ],\n" +
    "    \"jdkVersion\": \"1.8.0_342\",\n" +
    "    \"vmName\": \"OpenJDK 64-Bit Server VM\",\n" +
    "    \"vmVersion\": \"25.342-b07\",\n" +
    "    \"warmupIterations\": 1,\n" +
    "    \"warmupTime\": \"1 s\",\n" +
    "    \"warmupBatchSize\": 1,\n" +
    "    \"measurementIterations\": 1,\n" +
    "    \"measurementTime\": \"1 s\",\n" +
    "    \"measurementBatchSize\": 1,\n" +
    "    \"params\": {\n" +
    "      \"serialization\": \"hession2\",\n" +
    "      \"time\": \"1710843625867\"\n" +
    "    },\n" +
    "    \"primaryMetric\": {\n" +
    "      \"score\": 14.407897816654721,\n" +
    "      \"scoreError\": \"NaN\",\n" +
    "      \"scoreConfidence\": [\n" +
    "        \"NaN\",\n" +
    "        \"NaN\"\n" +
    "      ],\n" +
    "      \"scorePercentiles\": {\n" +
    "        \"0.0\": 14.407897816654721,\n" +
    "        \"50.0\": 14.407897816654721,\n" +
    "        \"90.0\": 14.407897816654721,\n" +
    "        \"95.0\": 14.407897816654721,\n" +
    "        \"99.0\": 14.407897816654721,\n" +
    "        \"99.9\": 14.407897816654721,\n" +
    "        \"99.99\": 14.407897816654721,\n" +
    "        \"99.999\": 14.407897816654721,\n" +
    "        \"99.9999\": 14.407897816654721,\n" +
    "        \"100.0\": 14.407897816654721\n" +
    "      },\n" +
    "      \"scoreUnit\": \"ms/op\",\n" +
    "      \"rawData\": [\n" +
    "        [\n" +
    "          14.407897816654721\n" +
    "        ]\n" +
    "      ]\n" +
    "    },\n" +
    "    \"secondaryMetrics\": {}\n" +
    "  },\n" +
    "  {\n" +
    "    \"jmhVersion\": \"1.35\",\n" +
    "    \"benchmark\": \"org.apache.dubbo.benchmark.demo.test.ConsumerIT.MyBenchmark.getUser\",\n" +
    "    \"mode\": \"avgt\",\n" +
    "    \"threads\": 16,\n" +
    "    \"forks\": 1,\n" +
    "    \"jvm\": \"/usr/local/openjdk-8/jre/bin/java\",\n" +
    "    \"jvmArgs\": [\n" +
    "      \"-javaagent:/usr/local/dubbo/jacocoagent.jar=destfile=/usr/local/dubbo/target-jacoco/1-1710845029232-jacoco.exec\",\n" +
    "      \"-Dzookeeper.address=zookeeper\"\n" +
    "    ],\n" +
    "    \"jdkVersion\": \"1.8.0_342\",\n" +
    "    \"vmName\": \"OpenJDK 64-Bit Server VM\",\n" +
    "    \"vmVersion\": \"25.342-b07\",\n" +
    "    \"warmupIterations\": 1,\n" +
    "    \"warmupTime\": \"1 s\",\n" +
    "    \"warmupBatchSize\": 1,\n" +
    "    \"measurementIterations\": 1,\n" +
    "    \"measurementTime\": \"1 s\",\n" +
    "    \"measurementBatchSize\": 1,\n" +
    "    \"params\": {\n" +
    "      \"serialization\": \"hession2\",\n" +
    "      \"time\": \"1710845050565\"\n" +
    "    },\n" +
    "    \"primaryMetric\": {\n" +
    "      \"score\": 14.449381819554553,\n" +
    "      \"scoreError\": \"NaN\",\n" +
    "      \"scoreConfidence\": [\n" +
    "        \"NaN\",\n" +
    "        \"NaN\"\n" +
    "      ],\n" +
    "      \"scorePercentiles\": {\n" +
    "        \"0.0\": 14.449381819554553,\n" +
    "        \"50.0\": 14.449381819554553,\n" +
    "        \"90.0\": 14.449381819554553,\n" +
    "        \"95.0\": 14.449381819554553,\n" +
    "        \"99.0\": 14.449381819554553,\n" +
    "        \"99.9\": 14.449381819554553,\n" +
    "        \"99.99\": 14.449381819554553,\n" +
    "        \"99.999\": 14.449381819554553,\n" +
    "        \"99.9999\": 14.449381819554553,\n" +
    "        \"100.0\": 14.449381819554553\n" +
    "      },\n" +
    "      \"scoreUnit\": \"ms/op\",\n" +
    "      \"rawData\": [\n" +
    "        [\n" +
    "          14.449381819554553\n" +
    "        ]\n" +
    "      ]\n" +
    "    },\n" +
    "    \"secondaryMetrics\": {}\n" +
    "  }\n" +
    "]\n";


// 解析JMH结果字符串为JSON对象
let resultList;
try {
    resultList = JSON.parse(jmh);
} catch (error) {
    console.error("解析JMH结果字符串出错：", error);
    process.exit(1);
}

// 转换数据结构，按serialization属性分类并收集Item对象
let collect = resultList.reduce((acc, result) => {
    let {time, serialization} = result.params;
    let item = {
        time: Number(time),
        score: result.primaryMetric.score,
        serialization: serialization
    };
    if (!acc[serialization]) {
        acc[serialization] = [];
    }
    acc[serialization].push(item);
    return acc;
}, {});

// 创建一个存储Template对象的数组
let templateList = {};

Object.entries(collect).forEach(([key, items]) => {
    // 按时间升序排序
    let sortedItems = items.sort((a, b) => a.time - b.time);

    templateList[key] = {
        time: sortedItems.map(i => i.time),
        score: sortedItems.map(i => i.score)
    };
    // switch (key) {
    //     case 'hessian2':
    //         templateList[0] = template;
    //         break;
    //     case 'fastjson2':
    //         templateList[1] = template;
    //         break;
    //     case 'kryo':
    //         templateList[2] = template;
    //         break;
    //     default:
    //         templateList.push(template); // 其他情况直接添加到数组末尾
    // }
});

// 确保所有索引位置都已填充
// for (let i = 0; i < templateList.length; i++) {
//     templateList[i] = templateList[i] || { values: [] };
// }

// 转换为JSON字符串并打印
console.log(JSON.stringify(templateList, null, 4));
