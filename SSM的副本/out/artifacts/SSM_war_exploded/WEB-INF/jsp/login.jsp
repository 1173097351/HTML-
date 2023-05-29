<%--
  Created by IntelliJ IDEA.
  User: zhouquan
  Date: 2023/3/7
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<p style="color: red">${msg}</p>
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名：<input type="text" name="uaccount"> <br>
    密码：<input type="password" name="upassword"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
