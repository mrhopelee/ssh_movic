<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.bean.UserInfo"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>更新个人信息</title>
<link rel="stylesheet" type="text/css" href="css/3.3.4bootstrap.min.css">
<link href="css/cc.css" rel="stylesheet" type="text/css" />
<script src="javascript/2.1.4jquery.js"></script>
<script src="javascript/3.3.4bootstrap.min.js"></script>
</style>
</head>

<body>

<div class="col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
	<hr color="gray" size="3">
	<br>
<%-- 	<s:action name="test" flush="true" namespace="/"></s:action> --%>
	<%
		session = request.getSession();
		UserInfo user1 = (UserInfo) session.getAttribute("user");
	%>

	<form id="form1" name="form1" method="post" action="updateUserMessage">
		<table align="center"  class="table table-hover table-bordered " >
			<tr  align="center">
				<p align="center" color="gray">
					<font size=" 3" color="gray">--------------------Update
						UserMessage Page--------------------</font>
				</p>
			</tr>
			<br>
			<tr  align="center">
				<td>用户：</td>
				<td><input name="userName" type="text"
					value="<%=user1.getUserName()%>" id="userName" readonly="readonly"/></td>
			</tr>
			<tr  align="center">
				<td>用户名：</td>
				<td><input name="userDisplayName" type="text"
					value="<%=user1.getUserDisplayName()%>" id="userDisplayName" /><s:fielderror fieldName="userDisplayName"/></td>
			</tr>
			<tr  align="center">
				<td>性别：</td>
				<td><label>&nbsp男<input name="userSex" type="radio" value="1"
						checked="checked" />  女<input type="radio" name="userSex" value="2" />
						
				</label></td>

			</tr>
		<%-- 	<tr>
				<td>性别：</td>
				<td><input name="sex" type="text"
					value="<%=user1.getUserSex()%>" id="sex" />
			</tr> --%>
			<tr  align="center">
				<td>邮箱</td>
				<td><input type="text" name="userEmail"
					value="<%=user1.getUserEmail()%>"/><s:fielderror fieldName="userEmail"/></td>
			</tr>
			<tr  align="center">
				<td>当前用户类型 ：</td>
				<td>(<%=user1.getUserType().getValue()%>)<%=user1.getUserType().getRemarks()%></td>
			</tr>
			<tr  align="center">
				<td><input class="btn btn-default buttom1"  type="submit" name="submit" value="提交" />
				<td><a href="index.jsp">返回主页</a></td>
			</tr>

		</table>
	</form>
</div>
</body>
</html>
