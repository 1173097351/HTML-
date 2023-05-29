<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/4/10
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑农药信息页面</title>
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
                    <small>编辑农药信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/updatePesticideInformation" method="post">
        <input type="hidden" name="pesticideId" value="${list.getPesticideId()}"/>
        农药名称：<input type="text" name="pesticideName" value="${list.getPesticideName()}"/> <br><br>
        <label for="supplierName">选择农资商：</label>
        <select name="supplierName" id="supplierName">
            <option value="" selected>请选择</option>
            <c:forEach var="supplierName" items="${SeedInformation}">
                <option value="${supplierName.getSupplierName()}" }>${supplierName.getSupplierName()}</option>
            </c:forEach>
        </select>
        <br><br>
        <input type="submit" value="提交"/>
    </form>

</div>