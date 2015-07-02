<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>找回密码</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    
  </head>
  
  <body>
	  <div style="width: 500px;margin: 0 auto;">
	  <p><s:fielderror></s:fielderror></p>
	  <form action="resetPasswordAction" method="post">
	  <label for="userEmail">找回密码邮箱：</label>
	  <input type="email" class="form-control" id="userEmail" placeholder="请输入您的注册邮箱" required="required" name="userEmail" >
	  <div id="tips1"></div>
	  <input type="button" id="get" class="btn btn-info" value="获取验证码">
		  <script type="text/javascript">
		  var count;
		  $("#get").stop(true,true).click(function(){
		  
		  
		 $.ajax({
			data:{
			userEmail:$("#userEmail").val()
			}
			,dataType:"JSON",success:function(date){
			
			
			if(date=="true")
			{
			//该用户已存在
			$("#tips1").html("<img width=\"25px\" height=\"25px\" src=\"img/right.png\">");
			}
			else if(date="false")
			{
			$("#tips1").html("<img width=\"25px\" height=\"25px\" src=\"img/false.png\">该邮箱无效");
			}
			else
			{
			  $("#tips1").html("<img width=\"25px\" height=\"25px\" src=\"img/false.png\">发送失败");
			}
			
			}
			,type:"post",url:"sendEmailAction"})
		  
		  
		  count = 60;
		  $("#get").attr("disabled", true);
		  var time=setInterval(function(){
		      
			  $("#get").val(count+"s后重新获取验证码");
			  if (count == 0) 
			  {
			     $("#get").val("获取验证码").removeAttr("disabled");
			     clearInterval(time);
			  }
			  else
			  {
			  count--;
			  }
		  }, 1000);
		  
		  
		  })

		  </script>
		<br>
		<label for="verificationCode">验证码</label> 
		<p>
		<input type="text"class="form-control" id="verificationCode" placeholder="请输入验证码" required="required" name="verificationCode">
		<span id="tips2"></span>
		</p>
		<script type="text/javascript">
		$("#verificationCode").blur(function(){
		
		$.ajax({data:{
		 userEmail:$("#userEmail").val(),
	     verificationCode:$("#verificationCode").val()
		
		},dataType:"JSON",success:function(date){
		
			if(date=="null")
			{
			  $("#tips2").html("<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>该验证不存在");
			}
		    if(date=="out of time")
			{
				$("#tips2").html("<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>该验证超时");
			}
			if(date=="false")
			{
			$("#tips2").html("<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>该验证重复");
			
			}
			if(date=="ok")
			{
				$("#tips2").html("<span class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"></span>");
			
			}
				
		}
		,type:"post",url:"checkEmailAndVerificationCodeAction"})
		
		
		})
		</script>
		
		<label for="Password">密码</label> 
	    <input type="password" class="form-control" id="Password" placeholder="请输入密码" required="required" name="Password"> 
		<label for="rePassword">重复密码</label> 
		<input type="password" class="form-control" id="rePassword" placeholder="请输入密码" required="required" name="rePassword"> 
	  	<div id="tips3"></div>
	  	<br>
	  	<input type="submit" id="submit"  class="btn btn-primary" value="提交">
	  	<script type="text/javascript">
	  	$("#submit").click(function(){
	  	
	  	
	  	
	  	if($("#Password").val().length>=6&&$("#Password").val().length<=15)
	  	{
	  		if($("#Password").val()==$("#rePassword").val())
		  	{
		  		$("#tip3").html("<img width=\"25px\" height=\"25px\" src=\"img/right.png\">");
				
		  		return true;
		  	}
		  	else
		  	{
		  	
		  	$("#tips3").html("<img width=\"25px\" height=\"25px\" src=\"img/false.png\">密码不一致");
				
		  	return false;
		  	}
	  	}
	  	else
	  	{
	  		$("#tips3").html("<img width=\"25px\" height=\"25px\" src=\"img/false.png\">密码必须为6-15位");
	  		return false;
	  	}
	  	
	  	})
	  	</script>
	  </form>
	  </div>
    
  </body>
</html>
