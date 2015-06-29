<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户注册</title>

<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.4-dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/userRegister.css">
<script src="javascript/2.1.4jquery.js"></script>
<script src="bootstrap-3.3.4-dist/js/bootstrap.js"></script>
</head>

<body>
	<s:include value="background.jsp"></s:include>
	<span class="myfilm">myfilm</span>
	<div class="userlogin">

		
		<form action="userRigisterAction" method="post">
			<s:fielderror fieldName="username"></s:fielderror>
			<span>注册<span class="rf">myfilm</span>账号
			</span><a href="index.jsp">首页<span class="glyphicon glyphicon-home"
				aria-hidden="true"></span></a>
			<p>
				<label for="username">用户名</label> <input type="text"
					class="form-control" id="username" placeholder="请输入用户名"
					required="required" name="user.userName" /> <span id="tips1"></span>
				<script type="text/javascript">
					/* 这里是向后台请求该用户名是否已经存在 */
					$("#username")
							.blur(
									function() {
										$
												.ajax({
													data : {
														userName : $(
																"#username")
																.val()
													},
													dataType : "JSON",
													success : function(date) {

														if (date == "false") {
															//该用户已存在
															$("#tips1")
																	.html(
																			"<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>该用户用户以存在");
														} else {
															$("#tips1")
																	.html(
																			"<span class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"></span>");
														}

													},
													type : "post",
													url : "checkUserNameExistAction"
												})

									})
				</script>
			</p>
			<p>
				<label for="userDisplayName">昵称</label> <input type="text"
					class="form-control" id="userDisplayName" placeholder="请输入昵称（显示名）"
					required="required" name="user.userDisplayName" /> <span
					id="tips2"></span>


				<script type="text/javascript">
					$("#userDisplayName")
							.blur(
									function() {

										$
												.ajax({
													data : {
														userDisplayName : $(
																"#userDisplayName")
																.val()
													},
													dataType : "JSON",
													success : function(date) {

														if (date == "false") {
															//该用户已存在
															$("#tips2")
																	.html(
																			"<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>该昵称已存在");
														} else {
															$("#tips2")
																	.html(
																			"<span class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"></span>");
														}

													},
													type : "post",
													url : "checkUserDisplayNameExist"
												})

									})
				</script>
			</p>
			<p>


				<label for="userEmail">电子邮件</label> <input type="email"
					class="form-control" id="userEmail" placeholder="请输入电子邮件"
					required="required" name="user.userEmail" /> <span id="tips3"></span>


				<script type="text/javascript">
					$("#userEmail")
							.blur(
									function() {

										$
												.ajax({
													data : {
														userEmail : $(
																"#userEmail")
																.val()
													},
													dataType : "JSON",
													success : function(date) {

														if (date == "false") {
															//该用户已存在
															$("#tips3")
																	.html(
																			"<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>该电子邮件以存在");
														} else {
															$("#tips3")
																	.html(
																			"<span class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"></span>");
														}

													},
													type : "post",
													url : "checkUserEmailExistAction"
												})

									})
				</script>


				<s:fielderror fieldName="userpassowrd"></s:fielderror>
			</p>
			<p>
				<label for="exampleInputPassword1">密码</label> <input type="password"
					class="form-control" id="Password" placeholder="请输入密码"
					required="required" name="user.userPassword" />
			</p>
			<p>
				<label for="exampleInputPassword1">重复密码</label> <input type="password"
					class="form-control" id="rePassword" placeholder="请输入密码"
					required="required" name="user.userPassword" />
			</p>
			<div id="tips4"></div>
			<p>
				<label>性别</label> <label><input type="radio" value="男"
					checked="checked" name="user.userSex" />男</label> <label><input
					type="radio" value="女" name="user.userSex" />女</label><br>
			</p>
			<input type="submit" value="注册" class="btn" id="submit"> 
			<script type="text/javascript">
			$("#submit").click(function(){
			if($("#Password").val()!=$("#rePassword").val())
				{	
					$("#tips4").html("<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>密码不一致");
				
					return false;
				}
				else
				{
				return true;
				}
			
			})
			
		
			</script>
			<input type="reset" value="重置" class="btn">

		</form>

	</div>

</body>
</html>
