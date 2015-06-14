<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <head>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/userFunction.css">
  </head>
  <%
  	if(request.getSession().getAttribute("user")==null)
  	{
  	//登录 注册
  	%>
  	
 
  	<div class="top">
  	<form class="topform" action="index.jsp">
  	<input type="submit" value="首页" class="btn btn-info">
  	</form>
  	<form class="topform" action="userLogin.jsp">
  	<input type="submit" value="登录" class="btn btn-primary">
  	</form>
  	<form class="topform" action="userRegister.jsp">
  	<input type="submit" value="注册" class="btn btn-primary">
  	</form>
  	</div>
  	<%
  	}
  	else
  	{
  	  %>
  	    <div class="top">
  	    <form class="topform" action="index.jsp">
  		<input type="submit" value="首页" class="btn btn-info">
  		</form>
	  	<form class="topform" action="updateUserLogo.jsp">
	  	<input type="submit" value="更新头像" class="btn btn-primary">
	  	</form>
	  	<form class="topform" action="updateUserPassword.jsp">
	  	<input type="submit" value="修改密码" class="btn btn-primary">
	  	</form>
	  	<form class="topform" action="updateUserMessage.jsp">
	  	<input type="submit" value="修改个人信息" class="btn btn-primary">
	  	</form>
	  	<form class="topform" action="signBoard.jsp">
	  	<input type="submit" value="每日签到" class="btn btn-primary">
	  	</form>
	  	
	  	<form class="topform" action="upgradeToVip.jsp">
	  	<input type="submit" value="升级会员" class="btn btn-primary">
	  	</form>
	  	<form class="topform" action="userLogoutAction">
	  	<input type="submit" value="退出" class="btn btn-danger">
	  	</form>
	  	</div>

  	  <%
  	
  	}
  	
   %>


