<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/15
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增地块页面</title>
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
                    <small>新增地块信息</small>
                </h1>
            </div>
        </div>
    </div>
    <p style="color: #ff2620">${msg}</p>
    <form action="${pageContext.request.contextPath}/insertLand" method="post">
        地块名称：<input type="text" name="landName"><br><br>
        地块位置东：<input type="text" name="lande"><br><br>
        地块位置南：<input type="text" name="lands"><br><br>
        地块位置西：<input type="text" name="landw"><br><br>
        地块位置北：<input type="text" name="landn"><br><br>
        地块大小：<input type="text" name="landSize"><br><br>
        <label for="username">种植的农产品：</label>
        <select name="username" id="username">
            <option value="${username.getUsername()}"selected>请选择</option>
            <c:forEach var="username" items="${list}">
                <option value="${username.getUsername()}">${username.getUsername()}</option>
            </c:forEach>
        </select>
        <br><br>
        <input type="submit" value="添加">
    </form>
</div>
