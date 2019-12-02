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
<p>欢迎你 &nbsp&nbsp&nbsp ${personallearn.studentname}</p>
<table class="table table-hover table-striped table-bordered">
    <thead>
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>性别</th>
        <th>行政班级</th>
        <th>课程名</th>
        <th>平时成绩</th>
        <th>期末成绩</th>
        <th>总成绩</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${personallearn.studentid}</td>
        <td>${personallearn.studentname}</td>
        <td>${personallearn.gender}</td>
        <td>${personallearn.adminclass}</td>
        <td>${personallearn.coursename}</td>
        <td>${personallearn.peacescore}</td>
        <td>${personallearn.finalscore}</td>
        <td>${personallearn.totalscore}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
