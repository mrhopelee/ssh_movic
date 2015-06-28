<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
</head>

<body>
	<div style="margin: 0 auto; width: 300px;">
	
		<form action="userRigisterAction" method="post">
			<s:fielderror fieldName="username"></s:fielderror>
			<table>
			<tr><td>
			<label for="username">用户名</label> </td></tr>
			<tr><td>
			<input type="text" class="form-control" id="username" placeholder="请输入用户名" required="required" name="user.userName" >
			</td>
			<td>
			<div id="tips1"></div>
			</td>
			</tr>
			</table>
			<script type="text/javascript">
			//这里是向后台请求该用户名是否已经存在
			$("#username").blur(function()
			{
			
			$.ajax({
			data:{
			userName:$("#username").val()
			}
			,dataType:"JSON",success:function(date){
			
			
			if(date=="false")
			{
			//该用户已存在
			$("#tips1").html("<img width=\"25px\" height=\"25px\" src=\"img/false.png\">该用户以存在");
			}
			else
			{
			$("#tips1").html("<img width=\"25px\" height=\"25px\" src=\"img/right.png\">");
			}
			
			}
			,type:"post",url:"checkUserNameExistAction"})
			
			
			})
			
			</script>
			
			<table>
			<tr><td><label for="userDisplayName">显示名（昵称）</label></td></tr>
		    <tr>
		    <td>
		    <input type="text"class="form-control" id="userDisplayName" placeholder="请输入显示名（昵称）" required="required" name="user.userDisplayName">
			</td>
			<td><div id="tips2"></div></td>
			</tr>
			</table>
			<script type="text/javascript">
			$("#userDisplayName").blur(function()
			{
			
			$.ajax({
			data:{
			userDisplayName:$("#userDisplayName").val()
			}
			,dataType:"JSON",success:function(date){
			
			
			if(date=="false")
			{
			//该用户已存在
			$("#tips2").html("<img width=\"25px\" height=\"25px\" src=\"img/false.png\">该显示名（昵称）以存在");
			}
			else
			{
			$("#tips2").html("<img width=\"25px\" height=\"25px\" src=\"img/right.png\">");
			}
			
			}
			,type:"post",url:"checkUserDisplayNameExist"})
			
			
			})
			</script>
			
			<table>
			<tr><td>
			<label for="userEmail">电子邮件</label> 
			</td></tr>
			<tr><td>
			<input type="email" class="form-control" id="userEmail" placeholder="请输入电子邮件" required="required" name="user.userEmail"> 
			</td>
			<td><div id="tips3"></div></td>
			</tr>
			</table>
			<script type="text/javascript">
			$("#userEmail").blur(function()
			{
			
			$.ajax({
			data:{
			userEmail:$("#userEmail").val()
			}
			,dataType:"JSON",success:function(date){
			
			
			if(date=="false")
			{
			//该用户已存在
			$("#tips3").html("<img width=\"25px\" height=\"25px\" src=\"img/false.png\">该电子邮件以存在");
			}
			else
			{
			$("#tips3").html("<img width=\"25px\" height=\"25px\" src=\"img/right.png\">");
			}
			
			}
			,type:"post",url:"checkUserEmailExistAction"})
			
			
			})
			</script>
			
			
			<s:fielderror fieldName="userpassowrd"></s:fielderror>
			<label for="exampleInputPassword1">密码</label> 
			<input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码" required="required" name="user.userPassword"> 
		
			<input type="radio" value="男" checked="checked" name="user.userSex">男
			<input type="radio" value="女" name="user.userSex">女<br>
			<input type="submit" value="注册" class="btn btn-primary"> 
			<input type="reset" value="重置" class="btn btn-warning">
			
		</form>
			<a href="index.jsp">返回首页</a>
	</div>
</body>
</html>
