<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/4/4
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.jsdelivr.net/npm/echarts@5.4.1/dist/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/jquery.js"></script>
<html>
<head>
    <title>农产品收获进库微观分析页面</title>
</head>
<body>
<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main" style="width: 600px;height:400px; margin: auto"></div>
<script>
    $.get("product/agriculturalProductsMicrocosmic", function (data) {
        var updateTime = data.updateTime;
        var inNum = data.inNum;

        var myChart = echarts.init(document.getElementById("main"));
        var option = {
            title: {
                text: '进库记录的宏观分析'
            },
            tooltip: {},
            legend: {
                data: ['进库量']
            },
            xAxis: {
                data: updateTime,
                axisLabel: {
                    interval: 0,
                    rotate: 20
                }
            },
            yAxis: {},
            series: [
                {
                    name: '进库量',
                    type: 'bar',
                    data: inNum
                }
            ]
        };
        myChart.setOption(option)
    });


</script>
</body>
</html>

