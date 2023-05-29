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
    <title>种苗管理页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>种苗信息</small>
                </h1>
            </div>
        </div>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toLandMain">返回主页</a>
    <a class="btn btn-primary"
       href="${pageContext.request.contextPath}/toAddSeedInformation">新增种苗</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toWarehousing">种苗入库记录</a>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>种苗名称</th>
                    <th>种苗量</th>
                    <th>农资商名称</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.getSeedName()}</td>
                        <td>${user.getInNum()}</td>
                        <td>${user.getSupplier().getSupplierName()}</td>

                        <td>
                            <a href="${pageContext.request.contextPath}/toUpdateSeedInformation/${user.getSeedId()}">更改</a>
                            |
                            <a href="${pageContext.request.contextPath}/deleteSeedInformationId/${user.getSeedId()}">删除</a>
                            |
                            <a href="${pageContext.request.contextPath}/toUpdatWwarehousing/${user.getSeedId()}">入库操作</a>
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
