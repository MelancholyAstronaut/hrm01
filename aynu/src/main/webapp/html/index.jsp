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
            <title>111</title>
        </head>

        <frameset rows="89,*" cols="*" frameborder="no" border="0" framespacing="0">
            <frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
            <frameset cols="200,10,*" frameborder="no" border="0" framespacing="0" id="oa_frame">
                <frame src="left.jsp" name="leftFrame" scrolling="yes" noresize="noresize" id="leftFrame" title="leftFrame" />
                <frame src="middle.jsp" name="middleFrame" scrolling="No" noresize="noresize" id="middleFrame" title="middleFrame" />
                <frame src="main.jsp" name="mainFrame" scrolling="yes" id="mainFrame" title="mainFrame" />
    </frameset>
</frameset>
<noframes><body>
</body>
</noframes></html>
