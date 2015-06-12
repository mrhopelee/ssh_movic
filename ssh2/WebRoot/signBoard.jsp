<%@page import="java.awt.Window"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.bean.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'signBoard.jsp' starting page</title>

<script type="text/javascript">
	function altRows(id) {
		if (document.getElementsByTagName) {

			var table = document.getElementById(id);
			var rows = table.getElementsByTagName("tr");

			for (i = 0; i < rows.length; i++) {
				if (i % 2 == 0) {
					rows[i].className = "evenrowcolor";
				} else {
					rows[i].className = "oddrowcolor";
				}
			}
		}
	}

	window.onload = function() {
		altRows('alternatecolor');
	}
</script>


<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
table.altrowstable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #a9c6c9;
	border-collapse: collapse;
}

table.altrowstable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

table.altrowstable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

.oddrowcolor {
	background-color: #d4e3e5;
}

.evenrowcolor {
	background-color: #c3dde0;
}
</style>

</head>

<body>

	<br>
	<p align="center" color="gray">
		<font size=" 3" color="gray">--------------------Welcome--------------------</font>
	</p>
	<br>
	<br>
	<br>
	<hr color="gray" size="3">
	<br>
	<%-- <s:action name="test" flush="true" namespace="/"></s:action> --%>
	<%
		session = request.getSession();
		UserInfo user1 = (UserInfo) session.getAttribute("user");
	%>

	<form id="form1" name="form1" method="post" action="signBoard" >
		<table align="center" class="altrowstable" id="alternatecolor">
			<tr>
				<p align="center" color="gray">
					<font size=" 3" color="gray">--------------------Sign Board
						Page--------------------</font>
				</p>
			</tr>
			<br>
			<tr>
				<td>用户：</td>
				<td><input name="userName" type="text"
					value="<%=user1.getUserName()%>" id="userName" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><%=user1.getUserDisplayName()%></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><%=user1.getUserSex()%></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><%=user1.getUserEmail()%></td>
			</tr>
			<tr>
				<td>当前用户类型 ：</td>
				<td>(<%=user1.getUserType().getValue()%>)<%=user1.getUserType().getRemarks()%></td>
			</tr>
			<%
				Iterator<UserIntegral> it = user1.getUserIntegrals().iterator();
				UserIntegral ui = null;
				while (it.hasNext())

				{
					ui = (UserIntegral) it.next();
					System.out.println(ui.getUintegralOid());
					System.out.println(ui.getUserInfo().getUserOid());
					System.out.println(ui.getUserScore());

				}
			%>
			<tr>
				<td>当前用户积分 ：</td>
				<td><%=ui.getUserScore()%></td>
			</tr>

			<tr>
				<td><input type="submit" name="submit" value="每日签到" />
				<td><a href="index.jsp">返回主页</a></td>
			</tr>

		</table>
	</form>

</body>
</html>
