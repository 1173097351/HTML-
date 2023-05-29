<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/4/10
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>农具管理页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>农具信息</small>
                </h1>
            </div>
        </div>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toLandMain">返回主页</a>
    <a class="btn btn-primary"
       href="${pageContext.request.contextPath}/toAddToolsInformation">新增农具</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toToolsInformationWarehousing">农具入库记录</a>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>农具名称</th>
                    <th>农具量</th>
                    <th>农资商名称</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.getToolName()}</td>
                        <td>${user.getInNum()}</td>
                        <td>${user.getSupplier().getSupplierName()}</td>

                        <td>
                            <a href="${pageContext.request.contextPath}/toUpdateToolsInformation/${user.getToolId()}">更改</a>
                            |
                            <a href="${pageContext.request.contextPath}/deleteToolsInformation/${user.getToolId()}">删除</a>
                            |
                            <a href="${pageContext.request.contextPath}/toUpdatToolsInformationWwarehousing/${user.getToolId()}">入库操作</a>
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
