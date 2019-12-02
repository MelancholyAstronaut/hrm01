<%--
  Created by IntelliJ IDEA.
  User: Hao
  Date: 2019/11/27
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <style>
        p{
            font-size: 30px;
            color: purple;
        }
    </style>
</head>
<body>
<p>欢迎你 &nbsp&nbsp&nbsp ${student.name}</p>
<table class="table table-hover table-striped table-bordered">
    <thead>
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>性别</th>
        <th>院校</th>
        <th>行政班级</th>
        <th>电话</th>
        <th>课程</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.gender}</td>
        <td>${student.college}</td>
        <td><a href="${pageContext.request.contextPath}/student/queryAllStudents?adminclass=${student.adminclass}">${student.adminclass}</a></td>
        <td>${student.mobile}</td>
        <td><a href="${pageContext.request.contextPath}/student/querypersonallearn?id=${student.id}">${student.id}111</a></td>
    </tr>
    </tbody>
</table>
</body>
</html>
