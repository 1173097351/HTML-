<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/22
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.jsdelivr.net/npm/echarts@5.4.1/dist/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/jquery.js"></script>
<html>
<head>
    <title>施肥宏观分析页面</title>
</head>
<body>
<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main" style="width: 600px;height:400px; margin: auto"></div>
<script>
    $.get("fertilizeMacroAnalysis", function (data) {
        var bts = data.btArr;
        var nums = data.numArr;
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '施肥记录的宏观分析'
            },
            tooltip: {},
            legend: {
                data: ['使用量']
            },
            xAxis: {
                data: bts
            },
            yAxis: {},
            series: [
                {
                    name: '使用量',
                    type: 'bar',
                    data: nums
                }
            ]
        };
        myChart.setOption(option)
    });

</script>
</body>
</html>

