<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/20
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>施肥信息页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>施肥记录</small>
                </h1>
            </div>
        </div>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toCrop">返回主页</a>
    <a class="btn btn-primary"
       href="${pageContext.request.contextPath}/toFertilizeMacroAnalysis">宏观分析</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toFertilizeMicroscopicAnalysis">微观分析</a>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>化肥名称</th>
                    <th>使用量</th>
                    <th>使用时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.getFertilizerInformation().getFertilizerName()}</td>
                        <td>${user.getApplyNum()}</td>
                        <td>
                            <fmt:formatDate value="${user.getApplyTime()}"
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


