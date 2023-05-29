<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/29
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>农产品信息页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>农产品信息</small>
                </h1>
            </div>
        </div>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toLandMain">返回主页</a>
    <a class="btn btn-primary"
       href="${pageContext.request.contextPath}/toInsertAgriculturalProductInformation">新增农产品信息</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toInsertAgrin">新增进库记录</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toInsertSalesRecord">新增销售记录</a>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>农产品名称</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.getUsername()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/toUpdateAgriculturalProductInformation/${user.getAgrId()}">更改</a>
                            |
                            <a href="${pageContext.request.contextPath}/deleteProductMap/${user.getAgrId()}">删除</a>
                            |
                            <a href="${pageContext.request.contextPath}/queryAgrinList/${user.getAgrId()}">查询进库记录</a>
                            |
                            <a href="${pageContext.request.contextPath}/toSalesRecord/${user.getAgrId()}">查询销售记录</a>
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

