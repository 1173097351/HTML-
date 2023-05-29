<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/4/3
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑农作品信息</title>
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
                    <small>编辑农作品信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/updateAgriculturalProductInformation" method="post">
        <input type="hidden" name="agrId" value="${list.getAgrId()}"/>
        农作品名称：<input type="text" name="username" value="${list.getUsername()}"/> <br><br>
        库存量：<input type="text" name="storageNum" value="${list.getStorageNum()}"/> <br><br>
        进库量：<input type="text" name="inNum" value="${list.getInNum()}"/> <br><br>
        <input type="submit" value="提交"/>
    </form>

</div>

