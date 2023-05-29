<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/4/4
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增销售记录页面</title>
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
                    <small>新增销售记录</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/insertSalesRecord" method="post">
        <label for="agrId">农产品名称：</label>
        <select name="agrId" id="agrId">
            <c:forEach var="list" items="${list}">
                <option value="${list.getAgrId()}">${list.getUsername()}</option>
            </c:forEach>
        </select>
        <br><br>
        销售量：<input type="text" name="outNum"><br><br>
        <label for="distributorId">经营商：</label>
        <select name="distributorId" id="distributorId">
            <c:forEach var="agency" items="${agency}">
                <option value="${agency.getDistributorId()}">${agency.getDistributoridName()}</option>
            </c:forEach>
        </select>
        <br><br>
        <input type="submit" value="添加">
    </form>

</div>

