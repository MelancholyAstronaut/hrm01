<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Hao
  Date: 2019/12/12
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>allChildInfo</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="${pageContext.request.contextPath}/js/util.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/jQuery.js"></script>

    <script>
        function ajaxFunction(value) {
            let id = value
            let href =  "${pageContext.request.contextPath}/newsLabel/ajaxParentFlash/?id="+id+"&pageNum=1";
            window.location.href = href
        }

    </script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td height="25" align="center" valign="bottom" class="td06">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="2%" valign="middle" background="../../images/bg_03.gif">&nbsp;</td>
                        <td width="2%" valign="middle" background="../../images/bg_03.gif"><img
                                src="../../images/main_28.gif" width="9" height="9" align="absmiddle"></td>
                        <td height="30" valign="middle" background="../../images/bg_03.gif">
                            <div align="left"><font color="#FFFFFF">栏目管理</font></div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <form name="form1" method="post" action="">
        <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
            <tr>
                <td colspan="2" class="td_02"><SPAN class=td_title>根据栏目名称查询</SPAN></td>
            </tr>
            <tr>
                <td width="14%" class="td_02">栏目名称</td>
                <td width="86%" class="td_02">
                    <select name="select" class="input" style="width:99%" onchange="ajaxFunction(this.value)"
                            id="selectId">
                        <option value="0" selected>------</option>
                        <c:forEach var="eachParentLabel" items="${allParentLabel}">
                            <option value="${eachParentLabel.ID}"
                                    <c:if test="${id==eachParentLabel.ID}">selected</c:if>>${eachParentLabel.label_name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <!--  <tr>
               <td class="td_02">二级栏目名称</td>
               <td class="td_02">
                 <select name="select" class="input" style="width:99% ">
                   <option value="1" selected>--请选择--</option>
                   <option value="2">天下足球</option>
                   <option value="3">我猜</option>
                 </select>
               </td>
             </tr> -->
        </table>
        <br>
        <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td class="td_page" align="left">
                    <div align="right">
                        <a href="${pageContext.request.contextPath}/newsLabel/toAddLabel">添加栏目</a>
                    </div>
                </td>
            </tr>
        </table>
        <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">

            <tr>
                <td colspan="5" align="right" class="td07">
            <tr>
                <td colspan="5" align="right" class="td07"><img src="../../images/1.gif" width="4" height="5"
                                                                align="absmiddle">
                    <a href="/newsLabel/ajaxParentFlash/?id=${id}&pageNum=${page.navigateFirstPage}"> 首页</a>　
                    <img src="../../images/2.gif" width="3" height="5" align="absmiddle">
                    <a href="/newsLabel/ajaxParentFlash/?id=${id}&pageNum=${page.prePage}">上一页</a>
                    <img src="../../images/2-2.gif" width="3" height="5" align="absmiddle">
                    <a href="/newsLabel/ajaxParentFlash/?id=${id}&pageNum=${page.nextPage}">下一页</a>
                    <img src="../../images/3.gif" width="4" height="5" align="absmiddle">
                    <a href="/newsLabel/ajaxParentFlash/?id=${id}&pageNum=${page.navigateLastPage}">末页</a>　　
                    共${page.pageNum}/${page.pages}页 ${page.total} 条记录
                </td>
            </tr>
            </td>
            </tr>
            <tr>
                <td width="17%" class="td_top">栏目名称</td>
                <td width="15%" class="td_top">上级栏目名称</td>
                <td width="44%" class="td_top">栏目描述</td>
                <td width="12%" class="td_top">删除</td>
                <td width="12%" class="td_top">修改</td>
            </tr>
            <c:forEach items="${allChild}" var="eachLabel">
                <tr>
                    <td class="td07">${eachLabel.label_name}</td>
                    <td class="td07">${eachLabel.parent.label_name}</td>
                    <td class="td07">${eachLabel.label_content}</td>
                    <td class="td07"><a href="${pageContext.request.contextPath}/newsLabel/deleteIt/${eachLabel.ID}">删除</a></td>
                        <%--                    如何小窗实现--%>
                    <td class="td07"><a href="${pageContext.request.contextPath}/newsLabel/queryById/${eachLabel.ID}"
                                        target="_self">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p>&nbsp;</p>
    </form>
</center>
</body>
</html>
