<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/29
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.jsdelivr.net/npm/echarts@5.4.1/dist/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

<html>
<head>
    <title>灌溉记录微观分析页面</title>
</head>
<body>
<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main" style="width: 600px;height:400px; margin: auto"></div>
<script>
    $.get("fertilizeMicroscopicAnalysis", function (data) {

        var fertilizerName = data.fertilizerName;
        var applyTime = data.applyTime;
        var chart = echarts.init(document.getElementById("main"));
        var option = {
            title: {
                text: "灌溉记录-使用时间"
            },
            tooltip: {},
            legend: {
                data: ['使用量']
            },
            xAxis: {
                type: "category",
                data: fertilizerName
            },
            yAxis: {type: 'time'},
            series: [{
                name: "使用时间",
                type: "scatter",
                data: applyTime
            }]
        };
        chart.setOption(option);
    });

</script>
</body>
</html>

