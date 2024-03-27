// 获取JMH结果字符串
let jmh;
$.ajax({
    type: "GET",
    async: false,
    url: "https://raw.githubusercontent.com/dyjjack/jmh_result/main/test-results_scheduled/merged_results.json",
    success: function (res) {
        jmh = res
    }
});

let filterSerialization =  ["hessian2", "fastjson2", "protobuf", "fastjson", "avro", "fst", "gson", "kryo", "msgpack"]

let filterProtocol = ["dubbo", "tri"]

console.log(jmh);
// 解析JMH结果字符串为JSON对象
let resultList;
try {
    resultList = JSON.parse(jmh);
} catch (error) {
    console.error("解析JMH结果字符串出错：", error);
    return
}

// 转换数据结构，按serialization属性分类并收集Item对象
let collect = resultList
    .filter(a => filterSerialization.includes(a.params.serialization) && filterProtocol.includes(a.params.protocol))
    .reduce((acc, result) => {
        let { time, serialization, protocol} = result.params;
        let item = {
            time: Number(time),
            score: Math.round(result.primaryMetric.score),
            serialization: serialization,
            protocol: protocol
        };
        let key = serialization + "-" + protocol;
        if (!acc[key]) {
            acc[key] = [];
        }
        acc[key].push(item);
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
});

// 使用时间类型的轴
let xAxisData = Array.from(new Set([].concat(...Object.values(templateList).map(obj => obj.time)))).sort((a, b) => a - b);

// 自定义时间轴的标签格式
function formatDate(timestamp) {
    var date = new Date(timestamp);
    return date.toLocaleDateString("en-US") + " " + date.toLocaleTimeString("en-US");
}

// 生成ECharts所需的series数据结构
let seriesData = Object.keys(templateList).map((key) => {
    let data = templateList[key].time.map((time, index) => {
        return {
            name: formatDate(time),
            value: [time, templateList[key].score[index]]
        };
    });
    return {
        name: key,
        type: 'line',
        showSymbol: true, // 显示标记点
        hoverAnimation: true, // 关闭hover动画
        symbolSize: 10, // 设置点的直径大小为10
        markPoint: {
            data: [
                { type: 'max', name: 'Max' },
                { type: 'min', name: 'Min' }
            ]
        },
        markLine: {
            data: [{ type: 'average', name: 'Avg' }]
        },
        data: data
    };
});

// ECharts配置对象
option = {
    title: {
        text: 'GitHub PR 性能耗时监控'
    },
    tooltip: {
        trigger: 'axis',
        //q: 这个formatter是在做什么
        //a:
        formatter: function (params) {
            let res = params[0].axisValueLabel + '<br/>';
            params.forEach(item => {
                res += item.marker + " " + item.seriesName + ': ' + (item.data.value[1] !== null ? item.data.value[1].toFixed(2) : '-') + '<br/>';
            });
            return res;
        }
    },
    legend: {
        data: Object.keys(templateList)
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'time',
        boundaryGap: false
    },
    yAxis: {
        type: 'value',
        name: '耗时(ms)'
    },
    series: seriesData
};