<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/29
  Time: 08:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.jsdelivr.net/npm/echarts@5.4.1/dist/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/jquery.js"></script>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<html>
<head>
    <title>灌溉记录宏观分析页面</title>
</head>
<body>
<div class="row clearfix">
    <div class="col-md-12 column">
        <div class="page-header">
            <h1>
                <small>灌溉记录宏观分析</small>
            </h1>
        </div>
    </div>
</div>

<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
<script>
    $.get("irrigationMacroscopical", function (data) {
        var time = data.time;
        var quantity = data.quantity;

        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '施药记录的宏观分析'
            },
            tooltip: {},
            legend: {
                data: ['灌溉量']
            },
            xAxis: {
                data: time,
                axisLabel: {
                    interval: 0,
                    rotate: 20
                }
            },
            yAxis: {},
            series: [
                {
                    name: '灌溉量',
                    type: 'bar',
                    data: quantity,
                }
            ]
        };
        myChart.setOption(option)
    });

</script>
</body>
</html>
