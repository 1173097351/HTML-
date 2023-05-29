<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/8
  Time: 08:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<h1>首页</h1>
<h1>欢迎最可爱的小马女士！！！</h1>
<p>${msg}</p>

<a class="btn btn-primary" href="${pageContext.request.contextPath}/userInformation"/>用户信息
<a class="btn btn-primary" href="${pageContext.request.contextPath}/queryListParcel"/>地块信息
<a class="btn btn-primary" href="${pageContext.request.contextPath}/queryCrop"/>农作物信息
<a class="btn btn-primary" href="${pageContext.request.contextPath}/toAgriculturalProductInformation"/>农产品信息
<a class="btn btn-primary" href="${pageContext.request.contextPath}/toSupplier"/>农资商信息
<a class="btn btn-primary" href="${pageContext.request.contextPath}/toSeedInformation"/>种苗管理
<a class="btn btn-primary" href="${pageContext.request.contextPath}/toPesticide"/>农药管理
<a class="btn btn-primary" href="${pageContext.request.contextPath}/toFertilizer"/>化肥管理
<a class="btn btn-primary" href="${pageContext.request.contextPath}/toToolsInformation"/>农具管理
<a class="btn btn-primary" href="${pageContext.request.contextPath}/toAgency"/>农资商管理


<a class="btn btn-primary" href="${pageContext.request.contextPath}/zx"/>注销

</body>
</html>
