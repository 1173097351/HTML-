<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/8
  Time: 11:29
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
                    <small>用户信息</small>
                </h1>
            </div>
        </div>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toMain">返回主页</a>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>用户名</th>
                    <th>园区名称</th>
                    <th>园区地址</th>
                    <th>联系人</th>
                    <th>联系方式</th>
                    <th>更新日期</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.getUserAccount().getUnick_name()}</td>
                        <td>${user.getParkInformation().getParkName()}</td>
                        <td>${user.getParkInformation().getParkAddress()}</td>
                        <td>${user.getParkInformation().getConcatPerson()}</td>
                        <td>${user.getParkInformation().getConcatMethod()}</td>
                        <td>
                            <fmt:formatDate value="${user.getParkInformation().getUpdateTime()}"
                                            pattern="yyyy-MM-dd"/>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/toUpdateUser/${user.getUserAccount().getUid()}">更改</a>
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

