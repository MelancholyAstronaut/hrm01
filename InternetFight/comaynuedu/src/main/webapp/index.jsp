<%--
  Created by IntelliJ IDEA.
  User: Hao
  Date: 2019/11/27
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/login">
    id<input type="text" name="userId"/><br>
    姓名<input type="text" name="username"/><br>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
