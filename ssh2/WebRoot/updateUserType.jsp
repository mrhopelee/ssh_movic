
<%@page import="java.awt.Window"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.bean.UserInfo"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'updateUserType.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	<%
		session = request.getSession();
		UserInfo user1 = (UserInfo) session.getAttribute("updateTypeUser");
	%>

	<form id="form1" name="form1" method="post" action="updateTypePage">
		<table align="center" class="altrowstable" id="alternatecolor">
			<tr>
				<p align="center" color="gray">
					<font size=" 3" color="gray">--------------------Update
						UserType Page--------------------</font>
				</p>
			</tr>
			<br>
			<tr>
				<td>用户：</td>
				<td><%=user1.getUserName()%></td>
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
			<tr>
				<td colspan="2">--1(普通用户),2(会员),3(普通管理员),4(高级管理员)--</td>

			</tr>
			<tr>
				<td>--请输入对应的用户类型数字--</td>
				<td><input name="type" type="text" id="type" /><s:fielderror fieldName="type" /></td>
				
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="提交" />
				<td><a href="userManage.jsp">返回管理用户界面</a></td>
			</tr>
			<tr>
				<input type="hidden" name="userName"
					value="<%=user1.getUserName()%>">
			</tr>
		</table>
	</form>
</body>
</html>
