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
    <title>农药管理页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>农药信息</small>
                </h1>
            </div>
        </div>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toLandMain">返回主页</a>
    <a class="btn btn-primary"
       href="${pageContext.request.contextPath}/toAddPesticide">新增农药</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toPesticideWarehousing">农药入库记录</a>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>农药名称</th>
                    <th>农药量</th>
                    <th>农资商名称</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.getPesticideName()}</td>
                        <td>${user.getInNum()}</td>
                        <td>${user.getSupplier().getSupplierName()}</td>

                        <td>
                            <a href="${pageContext.request.contextPath}/toUpdatePesticide/${user.getPesticideId()}">更改</a>
                            |
                            <a href="${pageContext.request.contextPath}/deletePesticideInformation/${user.getPesticideId()}">删除</a>
                            |
                            <a href="${pageContext.request.contextPath}/toUpdatPesticideWwarehousing/${user.getPesticideId()}">入库操作</a>
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
