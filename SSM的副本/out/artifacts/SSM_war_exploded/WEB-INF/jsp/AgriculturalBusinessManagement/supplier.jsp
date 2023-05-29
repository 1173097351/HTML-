<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/4/6
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>农资商页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>农资商</small>
                </h1>
            </div>
        </div>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toLandMain">返回主页</a>
    <a class="btn btn-primary"
       href="${pageContext.request.contextPath}/toAddSupplier">新增农资商</a>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>农资商名称</th>
                    <th>地址</th>
                    <th>联系人</th>
                    <th>联系方式</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.getSupplierName()}</td>
                        <td>${user.getSupplierAddress()}</td>
                        <td>${user.getConcatPerson()}</td>
                        <td>${user.getConcatMethod()}</td>

                        <td>
                            <a href="${pageContext.request.contextPath}/toUpdateSupplier/${user.getSupplierId()}">更改</a>
                            |
                            <a href="${pageContext.request.contextPath}/deleteSupplierId/${user.getSupplierId()}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

