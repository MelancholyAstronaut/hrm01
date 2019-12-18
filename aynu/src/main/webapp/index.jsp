<%--
  Created by IntelliJ IDEA.
  User: Hao
  Date: 2019/12/12
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>移动OA管理系统</title>
</head>

<frameset rows="89,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="/html/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
    <frameset cols="200,10,*" frameborder="no" border="0" framespacing="0" id="oa_frame">
        <frame src="/html/left.jsp" name="leftFrame" scrolling="yes" noresize="noresize" id="leftFrame" title="leftFrame" />
        <frame src="/html/middle.jsp" name="middleFrame" scrolling="No" noresize="noresize" id="middleFrame" title="middleFrame" />
        <frame src="/html/main.jsp" name="mainFrame" scrolling="yes" id="mainFrame" title="mainFrame" />
    </frameset>
</frameset>
<noframes><body>
</body>
</noframes></html>
