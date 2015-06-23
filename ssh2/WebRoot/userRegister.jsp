<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>

<body>
	<div style="margin: 0 auto; width: 250px;">
		<form action="userRigisterAction" method="post">
			<s:fielderror fieldName="username"></s:fielderror>
			<label for="exampleInputName2">用户名</label> <input type="text"
				class="form-control" id="exampleInputName2" placeholder="请输入用户名"
				required="required" name="user.userName"> <label
				for="exampleInputName2">显示名（昵称）</label> <input type="text"
				class="form-control" id="exampleInputName2" placeholder="请输入显示名（昵称）"
				required="required" name="user.userDisplayName">
			<s:fielderror fieldName="userpassowrd"></s:fielderror>
			<label for="exampleInputPassword1">密码</label> <input type="password"
				class="form-control" id="exampleInputPassword1" placeholder="请输入密码"
				required="required" name="user.userPassword"> <label
				for="exampleInputEmail1">电子邮件</label> <input type="email"
				class="form-control" id="exampleInputEmail1" placeholder="请输入电子邮件"
				required="required" name="user.userEmail"> <input
				type="radio" value="男" checked="checked" name="user.userSex">男
			<input type="radio" value="女" name="user.userSex">女<br>
			<input type="submit" value="注册" class="btn btn-primary"> <input
				type="reset" value="重置" class="btn btn-warning">
		</form>
			<a href="index.jsp">返回首页</a>
	</div>
</body>
</html>
