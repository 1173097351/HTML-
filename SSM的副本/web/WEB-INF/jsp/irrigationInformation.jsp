<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/28
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>灌溉记录页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>灌溉记录</small>
                </h1>
            </div>
        </div>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toCrop">返回主页</a>
    <a class="btn btn-primary"
       href="${pageContext.request.contextPath}/toIrrigationMacroscopical">宏观分析</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toIrrigationmicrocosmic">微观分析</a>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>灌溉量</th>
                    <th>灌溉时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.getIrrigationNum()}</td>
                        <td>
                            <fmt:formatDate value="${user.getIrrigationTime()}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>
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

