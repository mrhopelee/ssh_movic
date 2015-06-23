
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

<title>修改用户权限</title>
<link rel="stylesheet" type="text/css" href="css/3.3.4bootstrap.min.css">
<link href="css/cc.css" rel="stylesheet" type="text/css" />
<script src="javascript/2.1.4jquery.js"></script>
<script src="javascript/3.3.4bootstrap.min.js"></script>
</head>

<body>

	<div class="col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">

		<br>
		<p align="center" color="gray">
			<font size=" 3" color="gray">--------------------Welcome--------------------</font>
		</p>
		<br> <br> <br>
		<hr color="gray" size="3">
		<br>
		<%
		session = request.getSession();
		UserInfo user1 = (UserInfo) session.getAttribute("updateTypeUser");
	%>

		<form id="form1" name="form1" method="post" action="updateTypePage">
			<table align="center" class="table table-hover table-bordered ">
				<tr align="center">
					<p align="center" color="gray">
						<font size=" 3" color="gray">--------------------Update
							UserType Page--------------------</font>
					</p>
				</tr>
				<br>
				<tr align="center">
					<td>用户：</td>
					<td><%=user1.getUserName()%></td>
				</tr>
				<tr align="center">
					<td>用户名：</td>
					<td><%=user1.getUserDisplayName()%></td>
				</tr>
				<tr align="center">
					<td>性别：</td>
					<td><%=user1.getUserSex()%></td>
				</tr>
				<tr align="center">
					<td>邮箱</td>
					<td><%=user1.getUserEmail()%></td>
				</tr>
				<tr align="center">
					<td>当前用户类型 ：</td>
					<td>(<%=user1.getUserType().getValue()%>)<%=user1.getUserType().getRemarks()%></td>
				</tr>
				<tr align="center">
					<td colspan="2">--1(普通用户),2(会员),3(普通管理员),4(高级管理员)--</td>

				</tr>
				<tr align="center">
					<td>--请输入对应的用户类型数字--</td>
					<td><input name="type" type="text" id="type" />
					<s:fielderror fieldName="type" /></td>

				</tr>
				<tr align="center">
					<td><input class="btn btn-default buttom1" type="submit"
						name="submit" value="提交" />
					<td><a href="userManage.jsp">返回管理用户界面</a></td>
				</tr>
				<tr align="center">
					<input type="hidden" name="userName"
						value="<%=user1.getUserName()%>">
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
