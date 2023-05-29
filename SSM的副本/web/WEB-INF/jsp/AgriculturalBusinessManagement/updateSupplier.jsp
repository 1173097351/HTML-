<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/4/10
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑农资商页面</title>
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
                    <small>编辑农资商</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/updateSupplier" method="post">
        <input type="hidden" name="supplierId" value="${list.getSupplierId()}"/>
        农资商名称：<input type="text" name="supplierName" value="${list.getSupplierName()}"/> <br><br>
        地址：<input type="text" name="supplierAddress" value="${list.getSupplierAddress()}"/> <br><br>
        联系人：<input type="text" name="concatPerson" value="${list.getConcatPerson()}"/> <br><br>
        联系方式：<input type="text" name="concatMethod" value="${list.getConcatMethod()}"/> <br><br>
        <input type="submit" value="提交"/>
    </form>

</div>

