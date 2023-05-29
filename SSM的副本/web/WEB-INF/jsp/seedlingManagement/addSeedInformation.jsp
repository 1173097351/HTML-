<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/4/10
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增种苗信息页面</title>
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
                    <small>新增种苗</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/insertSeedInformation" method="post">
        种苗名称：<input type="text" name="seedName"/> <br><br>
        <input type="submit" value="添加">
    </form>

</div>

