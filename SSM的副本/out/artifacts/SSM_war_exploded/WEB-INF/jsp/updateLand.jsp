<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/13
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑土地信息页面</title>
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
                    <small>编辑地块信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/updateLand" method="post">
        <input type="hidden" name="landId" value="${crop.getLandId()}"/>
        地块名称：<input type="text" name="landName" value="${crop.getLandName()}"/> <br><br>
        地块位置东：<input type="text" name="lande" value="${crop.getLande()}"/> <br><br>
        地块位置南：<input type="text" name="lands" value="${crop.getLands()}"/> <br><br>
        地块位置西：<input type="text" name="landw" value="${crop.getLandw()}"/> <br><br>
        地块位置北：<input type="text" name="landn" value="${crop.getLandn()}"/> <br><br>
        地块大小：<input type="text" name="landSize" value="${crop.getLandSize()}"/>
        <br><br>
        <label for="username">农产品：</label>
        <select name="username" id="username">
            <c:forEach var="username" items="${list}">
                <option value="${username.getUsername()}" ${username.getUsername() eq crop.getAgriculturalProductInformation().getUsername()?'selected':''}>
                        ${username.getUsername()}</option>
            </c:forEach>
        </select>

        <br><br>
        <input type="submit" value="提交"/>
    </form>


</div>


