<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/4/11
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>农药入库记录页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>农药入库记录</small>
                </h1>
            </div>
        </div>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/tooPesticide">返回</a>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>农药名称</th>
                    <th>入库量</th>
                    <th>入库时间</th>
                    <th>农资商</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.getPesticideName()}</td>
                        <td>${user.getInNum()}</td>
                        <td>
                            <fmt:formatDate value="${user.getUpdateTime()}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>${user.getSupplier().getSupplierName()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
