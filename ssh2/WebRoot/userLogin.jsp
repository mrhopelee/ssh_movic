<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>

	<div style="margin: 0 auto; width: 250px">
	
		<s:fielderror></s:fielderror>
		<s:form action="userLoginAction" namespace="/">
			<label for="exampleInputName2">用户名:</label>
			<input name="user.userName" type="text" class="form-control"
				id="exampleInputName2" placeholder="请输入用户名" required="required">
			<label for="exampleInputPassword1">密码</label>
			<input name="user.userPassword" type="password" class="form-control"
				id="exampleInputPassword1" placeholder="请输入密码" required="required">
			<input type="submit" class="btn btn-success" value="登录">
			<input type="reset" class="btn btn-warning" value="重置">
		</s:form>
		<a href="index.jsp">返回首页</a>
	</div>
</body>
</html>
