<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/29 0029
  Time: 上午 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>学生列表</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>
<body>
<table class="table table-hover table-striped table-bordered">
    <thead>
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>性别</th>
        <th>院校</th>
        <th>行政班级</th>
        <th>电话</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${studentList}" var="eachStudent">
            <tr>
                <td>${eachStudent.id}</td>
                <td><a href="${pageContext.request.contextPath}/student/queryStudent?name=${eachStudent.name}">${eachStudent.name}</a></td>
                <td>${eachStudent.gender}</td>
                <td>${eachStudent.college}</td>
                <td>${eachStudent.adminclass}</td>
                <td>${eachStudent.mobile}</td>
            </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
