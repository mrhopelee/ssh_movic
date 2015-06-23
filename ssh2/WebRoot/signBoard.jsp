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

<title>每日签到</title>

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
	<br>
	<br>
	<br>
	<hr color="gray" size="3">
	<br>
	
	
	<%
		
	UserInfo user1 = (UserInfo) request.getSession().getAttribute("user");
	%>

	<form id="form1" name="form1" method="post" action="signBoard" >
		<table align="center"  class="table table-hover table-bordered " >
			<tr  align="center">
				<p align="center" color="gray">
					<font size=" 3" color="gray">--------------------Sign Board
						Page--------------------</font>
				</p>
			</tr>
			<br>
			<tr  align="center">
				<td>用户：</td>
				<td><input name="userName" type="text"
					value="<%=user1.getUserName()%>" id="userName" readonly="readonly" /></td>
			</tr>
			<tr  align="center">
				<td>用户名：</td>
				<td><%=user1.getUserDisplayName()%></td>
			</tr>
			<tr  align="center">
				<td>性别：</td>
				<td><%=user1.getUserSex()%></td>
			</tr>
			<tr  align="center">
				<td>邮箱</td>
				<td><%=user1.getUserEmail()%></td>
			</tr>
			<tr  align="center">
				<td>当前用户类型 ：</td>
				<td>(<%=user1.getUserType().getValue()%>)<%=user1.getUserType().getRemarks()%></td>
			</tr >
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
			<tr  align="center">
				<td>当前用户积分 ：</td>
				<td><%=ui.getUserScore()%></td>
			</tr>

			<tr  align="center">
				<td><input class="btn btn-default buttom1"   type="submit" name="submit" value="每日签到" />
				<td><a href="index.jsp">返回主页</a></td>
			</tr>

		</table>
	</form>
</div>
</body>
</html>
