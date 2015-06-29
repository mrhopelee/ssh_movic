<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户登录</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.4-dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/userLogin.css">
<script src="javascript/2.1.4jquery.js"></script>
<script src="bootstrap-3.3.4-dist/js/bootstrap.js"></script>
</head>
<body>
	<s:include value="background.jsp"></s:include>
	
	<div class="userlogin">
	<span class="myfilm">myfilm</span>
		<s:fielderror></s:fielderror>
		<s:form action="userLoginAction" namespace="/">
			<span>登陆myfilm</span><a href="index.jsp">首页<span class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
			<!-- <label for="exampleInputName2">用户名:</label> -->
			<input name="user.userName" type="text" class="form-control"
				id="exampleInputName2" placeholder="请输入用户名" required="required">
			<!-- <label for="exampleInputPassword1">密码</label> -->
			<input name="user.userPassword" type="password" class="form-control"
				id="exampleInputPassword1" placeholder="请输入密码" required="required">
			<input type="reset" class="btn" value="重置">
			<input type="submit" class="btn" value="登录">
			
		</s:form>
		
	</div>
</body>
</html>