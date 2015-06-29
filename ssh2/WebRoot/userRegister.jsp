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
	<div class="userlogin">
		<span class="myfilm">myfilm</span>
		<s:fielderror></s:fielderror>
		<form action="userRigisterAction" method="post">
			<s:fielderror fieldName="username"></s:fielderror>
			<span>注册myfilm账号</span><a href="index.jsp">首页<span
				class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
			<p>
				<label for="username">用户名</label> <input type="text"
					class="form-control" id="username" placeholder="请输入用户名"
					required="required" name="user.userName">
			<div id="tips1"></div>
			<script type="text/javascript">
				//这里是向后台请求该用户名是否已经存在
				$("#username")
						.blur(
								function() {
									$
											.ajax({
												data : {
													userName : $("#username")
															.val()
												},
												dataType : "JSON",
												success : function(date) {

													if (date == "false") {
														//该用户已存在
														$("#tips1")
																.html(
																		"<img width=\"25px\" height=\"25px\" src=\"img/false.png\">该用户以存在");
													} else {
														$("#tips1")
																.html(
																		"<img width=\"25px\" height=\"25px\" src=\"img/right.png\">");
													}

												},
												type : "post",
												url : "checkUserNameExistAction"
											})

								})
			</script>
			</p>
			<p>
				<label for="userDisplayName">显示名（昵称）</label> <input type="text"
					class="form-control" id="userDisplayName" placeholder="请输入显示名（昵称）"
					required="required" name="user.userDisplayName">
			<div id="tips2"></div>


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
																		"<img width=\"25px\" height=\"25px\" src=\"img/false.png\">该显示名（昵称）以存在");
													} else {
														$("#tips2")
																.html(
																		"<img width=\"25px\" height=\"25px\" src=\"img/right.png\">");
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
					required="required" name="user.userEmail">
			<div id="tips3"></div>


			<script type="text/javascript">
				$("#userEmail")
						.blur(
								function() {

									$
											.ajax({
												data : {
													userEmail : $("#userEmail")
															.val()
												},
												dataType : "JSON",
												success : function(date) {

													if (date == "false") {
														//该用户已存在
														$("#tips3")
																.html(
																		"<img width=\"25px\" height=\"25px\" src=\"img/false.png\">该电子邮件以存在");
													} else {
														$("#tips3")
																.html(
																		"<img width=\"25px\" height=\"25px\" src=\"img/right.png\">");
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
					class="form-control" id="exampleInputPassword1" placeholder="请输入密码"
					required="required" name="user.userPassword">
			</p>
			<p>
				<input type="radio" value="男" checked="checked" name="user.userSex">男
				<input type="radio" value="女" name="user.userSex">女<br>
			</p>
			<input type="submit" value="注册" class="btn btn-primary"> <input
				type="reset" value="重置" class="btn btn-warning">

		</form>

	</div>

</body>
</html>
