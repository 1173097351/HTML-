<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/27
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增施药记录页面</title>
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
                    <small>新增施药记录</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/insertApplyMedicine" method="post">
        <input type="hidden" name="cropId" value="${crop}"/>
        <br><br>
        <label for="pesticideName">选择农药：</label>
        <select name="pesticideName" id="pesticideName">
            <c:forEach var="pesticideName" items="${list}">
                <option value="${pesticideName.getPesticideName()}">${pesticideName.getPesticideName()}</option>
            </c:forEach>
        </select>
        使用量：<input type="text" name="applyNum"><br><br>
        <input type="submit" value="添加">
    </form>

</div>