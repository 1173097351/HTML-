<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/9
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑用户信息页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>编辑信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/updateUser" method="post">
        <input type="hidden" name="uid" value="${userInformation.getUserAccount().getUid()}"/>
        用户名：<input type="text" name="unick_name" value="${userInformation.getUserAccount().getUnick_name()}"/>
        密码：<input type="text" name="upassword" value="${userInformation.getUserAccount().getUpassword()}"/>
        园区名称：<input type="text" name="parkName" value="${userInformation.getParkInformation().getParkName()}"/>
        园区地址：<input type="text" name="parkAddress" value="${userInformation.getParkInformation().getParkAddress()}"/>
        联系人：<input type="text" name="concatPerson" value="${userInformation.getParkInformation().getConcatPerson()}"/>
        联系方式：<input type="text" name="concatMethod" value="${userInformation.getParkInformation().getConcatMethod()}"/>
        <input type="submit" value="提交"/>
    </form>


</div>

