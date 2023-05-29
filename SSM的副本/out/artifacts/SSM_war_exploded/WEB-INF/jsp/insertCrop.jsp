<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/17
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增农作物信息页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增农作物信息</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/insertCrop" method="post">
        农作物名称：<input type="text" name="cropName"><br><br>
        <label for="list">选择种植地块：</label>
        <select name="list" id="list">
            <c:forEach var="list" items="${list}">
                <option value="${list.getLandName()}">${list.getLandName()}</option>
            </c:forEach>
        </select>
        <br><br>
        <label for="seed">选择种苗：</label>
        <select name="seed" id="seed">
            <c:forEach var="seed" items="${seed}">
                <option value="${seed.getSeedName()}">${seed.getSeedName()}</option>
            </c:forEach>
        </select>
        <br><br>
        <input type="submit" value="添加">
    </form>

</div>

