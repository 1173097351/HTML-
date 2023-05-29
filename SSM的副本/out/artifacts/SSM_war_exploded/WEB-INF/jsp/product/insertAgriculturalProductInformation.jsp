<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/4/3
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增农产品信息页面</title>
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
                    <small>新增农产品信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/insertProduct" method="post">
        <label for="cropId">选择农作物：</label>
        <select name="cropId" id="cropId">
            <c:forEach var="list" items="${list}">
                <option value="${list.getCropId()}">${list.getCropName()}</option>
            </c:forEach>
        </select>
        <br><br>
        农作品名称：<input type="text" name="username"/> <br><br>
        库存量：<input type="text" name="storageNum"/> <br><br>
        进库量：<input type="text" name="inNum"/> <br><br>
        <input type="submit" value="添加">
    </form>

</div>