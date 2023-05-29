<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/4/11
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>农具入库操作页面</title>
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
                    <small>农具入库操作</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/updatToolsInformationWwarehousing" method="post">
        <input type="hidden" name="toolId" value="${list.getToolId()}"/>
        入库量：<input type="text" name="inNum" value="${list.getInNum()}"/> <br><br>
        <label for="supplierName">选择农资商：</label>
        <select name="supplierName" id="supplierName">
            <c:forEach var="supplierName" items="${SeedInformation}">
                <option value="${supplierName.getSupplierName()}" ${supplierName.getSupplierName()
                        eq list.getSupplier().getSupplierName()?'selected':''}>${supplierName.getSupplierName()}</option>
            </c:forEach>
        </select>
        <input type="submit" value="提交"/>
    </form>

</div>
