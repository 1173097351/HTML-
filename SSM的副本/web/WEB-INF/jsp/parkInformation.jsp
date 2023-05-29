<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/13
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户信息页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>地块信息</small>
                </h1>
            </div>
        </div>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toLandMain">返回主页</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toInsertLand">新增地块信息</a>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>地块名称</th>
                    <th>地块位置东</th>
                    <th>地块位置南</th>
                    <th>地块位置西</th>
                    <th>地块位置北</th>
                    <th>地块大小</th>
                    <th>种植的农产品</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.getLandName()}</td>
                        <td>${user.getLande()}</td>
                        <td>${user.getLands()}</td>
                        <td>${user.getLandw()}</td>
                        <td>${user.getLandn()}</td>
                        <td>${user.getLandSize()}</td>
                        <td>${user.getAgriculturalProductInformation().getUsername()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/toQueryLandId/${user.getLandId()}">更改</a>
                            |
                            <a href="${pageContext.request.contextPath}/deleteLand/${user.getLandId()}">删除</a>
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


