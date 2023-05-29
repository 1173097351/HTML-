<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/4/4
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>销售记录页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>销售记录</small>
                </h1>
            </div>
        </div>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toApi">返回</a>
    <a class="btn btn-primary"
       href="${pageContext.request.contextPath}/toSalesRecordMacroAnalysis">宏观分析</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toSalesRecordMicroscopicAnalysis">微观分析</a>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>农产品名称</th>
                    <th>销售量</th>
                    <th>经营商</th>
                    <th>销售时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.getAgriculturalProductInformation().getUsername()}</td>
                        <td>${user.getOutNum()}</td>
                        <td>${user.getAgency().getDistributoridName()}</td>
                        <td>
                            <fmt:formatDate value="${user.getUpdateTime()}"
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

