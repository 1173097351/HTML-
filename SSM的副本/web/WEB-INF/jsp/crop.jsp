<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/17
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>农作物信息页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>农作物信息</small>
                </h1>
            </div>
        </div>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toLandMain">返回主页</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toInsertCrop">新增农作物信息</a>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>农作物名称</th>
                    <th>种植地块</th>
                    <th>种苗</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.getCropName()}</td>
                        <td>${user.getParcelInformation().getLandName()}</td>
                        <td>${user.getSeedInformation().getSeedName()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/toUpdateCrop/${user.getCropId()}">更改</a>
                            |
                            <a href="${pageContext.request.contextPath}/deleteCrop/${user.getCropId()}">删除</a>
                            |
                            <a href="${pageContext.request.contextPath}/queryFertilize/${user.getCropId()}">施肥记录</a>
                            <a href="${pageContext.request.contextPath}/toInsertFertilize/${user.getCropId()}">新增施肥记录</a>
                            ｜
                            <a href="${pageContext.request.contextPath}/queryApplyMedicine/${user.getCropId()}">施药记录</a>
                            <a href="${pageContext.request.contextPath}/toInsertApplyMedicine/${user.getCropId()}">新增施药记录</a>
                            |
                            <a href="${pageContext.request.contextPath}/queryIrrigationInformation/${user.getCropId()}">灌溉记录</a>
                            |
                            <a href="${pageContext.request.contextPath}/toInsertIrrigationInformation/${user.getCropId()}">新增灌溉记录</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

