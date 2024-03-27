// 获取JMH结果字符串
let jmh;
$.ajax({
    type: 'GET',
    async: false,
    url: 'https://raw.kkgithub.com/wxbty/jmh_result/main/test-results/fixed/rpc/merged_prop_results.json',
    success: function (res) {
        jmh = res;
    }
});

// let filterSerialization = ["hessian2"]

// let filterProtocol = ["dubbo"]

// filterSerialization = serialization.replace(/{/g, '').replace(/}/g, '').split(',')
// filterProtocol = rpc.replace(/{/g, '').replace(/}/g, '').split(',')

// console.log(jmh);
// 解析JMH结果字符串为JSON对象
let resultList;
try {
    resultList = JSON.parse(jmh);
} catch (error) {
    console.error('解析JMH结果字符串出错：', error);
}

// 转换数据结构，按serialization属性分类并收集Item对象
let collect = resultList
    .filter((a) => a.mode == 'avgt')
    .map((result) => {
        // 注意这里只用一个参数接收当前元素
        let protocol = result.params['dubbo.protocol.name'];
        return {
            score: Math.round(result.primaryMetric.score),
            protocol: protocol
        };
    });

let seriesDate = collect.map((result) => {
    // 注意这里只用一个参数接收当前元素
    return {
        type: 'bar'
    };
});

console.log(collect);
console.log(seriesDate);

return option = {
    title: {
        text: 'RPC对比',
        x: 'center'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'none'
        },
        formatter: function (params) {
            return params[0].data.score + 'ms';
        }
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    grid: {
        // top: '3%',
        left: '3%',
        right: '3%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'category'
    },
    yAxis: {
        type: 'value',
        name: '耗时(ms)'
    },
    dataset: {
        dimensions: ['protocol', 'score'],
        source: collect
    },
    series: [
        {
            type: 'bar',
            label: {
                //柱体上显示数值
                show: true, //开启显示
                position: 'top', //在上方显示
                textStyle: {
                    //数值样式
                    fontSize: '30px',
                    color: '#666'
                },
            }
        }
    ]
};
