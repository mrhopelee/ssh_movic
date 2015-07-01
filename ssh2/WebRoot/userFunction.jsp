<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.4-dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/userFunction.css">
<script src="javascript/2.1.4jquery.js"></script>
<script src="bootstrap-3.3.4-dist/js/bootstrap.js"></script>
<title>用户个人中心</title>

<script type="text/javascript">
function navInit(){
	$("#userfun_nav input").removeClass("active");
}
	$(document).ready(
		
		/* navInit(); */
		/* $("#b6").addClass("active"); */
		$.ajax({
			data : null,
			dataType : "HTML",
			success : function(date) {
				$("#page").html(date);
				$("#admin").html("");
				$("#b6").addClass("active");
			},
			type : "post",
			url : "findUserComments"
		})
	);
	
</script>
<style>
.btn-primary {
    background-color: #48A8F9 !important;
}
.btn-primary.active, .btn-primary.focus, .btn-primary:active, .btn-primary:focus, .btn-primary:hover, .open > .dropdown-toggle.btn-primary {

    background-color: #286090 !important;
    }
</style>
</head>
<body class="container-fluid">
	<!--  
    <div class="top">
	<form class="topform" action="index.jsp">
		<input type="submit" value="首页" class="btn btn-info" >
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
	<form class="topform" action="findUserComments">
		<input type="submit" value="查看我的评论" class="btn btn-primary">
	</form>

</div>-->
	<!-- 
<a href="index.jsp" target="_self" >首页</a>
<a href="updateUserLogo.jsp" target="showframe">更新头像</a>
<a href="updateUserPassword.jsp" target="showframe">修改密码</a>
<a href="updateUserMessage.jsp" target="showframe">修改个人信息</a>
<a href="signBoard.jsp" target="showframe">每日签到</a>
<a href="upgradeToVip.jsp" target="showframe">升级会员</a>
<a href="findUserComments" target="showframe">查看我的评论</a>
<a href="userLogoutAction" target="showframe">退出</a>
-->
	<div
		class="col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 userfun_middle">
		<div id="userfun_nav" class="userfun_nav">
			<!-- <form  action="index.jsp">
		<input type="submit" value="首页" class="btn btn-info" >
	    </form> -->

			<s:if test="#session.user.userType.value>=3">
				<form action="adminFunction.jsp">
					<input type="submit" value="管理中心" class="btn btn-info" id="b7">
				</form>
				<%-- <script type="text/javascript">
					$("#b7").click(function() {
						navInit();
						$("#b7").addClass("active");
						$.ajax({
							data : null,
							dataType : "HTML",
							success : function(date) {
								$("#page").html("");
								$("#admin").html(date);
							},
							type : "post",
							url : "adminFunction.jsp"
						})
					})
				</script> --%>
			</s:if>

			<input type="submit" value="查看我的评论" class="btn btn-primary" id="b6">
			<script type="text/javascript">
				$("#b6").click(function() {
					navInit();
					$("#b6").addClass("active");
					$.ajax({
						data : null,
						dataType : "HTML",
						success : function(date) {
							$("#page").html(date);
							$("#admin").html("");
						},
						type : "post",
						url : "findUserComments"
					})
				})
			</script>

			<input type="submit" value="更新头像" class="btn btn-primary" id="b1">
			<script type="text/javascript">
				$("#b1").click(function() {
					navInit();
					$("#b1").addClass("active");
					$.ajax({
						data : null,
						dataType : "HTML",
						success : function(date) {
							$("#page").html(date);
							$("#admin").html("");
						},
						type : "post",
						url : "updateUserLogo.jsp"
					})
				})
			</script>

			<input type="submit" value="修改密码" class="btn btn-primary" id="b2">
			<script type="text/javascript">
				$("#b2").click(function() {
					navInit();
					$("#b2").addClass("active");
					$.ajax({
						data : null,
						dataType : "HTML",
						success : function(date) {
							$("#page").html(date);
							$("#admin").html("");
						},
						type : "post",
						url : "updateUserPassword.jsp"
					})
				})
			</script>

			<input type="submit" value="修改个人信息" class="btn btn-primary" id="b3">
			<script type="text/javascript">
				$("#b3").click(function() {
					navInit();
					$("#b3").addClass("active");
					$.ajax({
						data : null,
						dataType : "HTML",
						success : function(date) {
							$("#page").html(date);
							$("#admin").html("");
						},
						type : "post",
						url : "updateUserMessage.jsp"
					})
				})
			</script>

			<s:if test="#session.user.userType.value<3">
				<input type="submit" value="每日签到" class="btn btn-primary" id="b4">
				<script type="text/javascript">
					$("#b4").click(function() {
						navInit();
						$("#b4").addClass("active");
						$.ajax({
							data : null,
							dataType : "HTML",
							success : function(date) {
								$("#page").html(date);
								$("#admin").html("");
							},
							type : "post",
							url : "signBoard.jsp"
						})
					})
				</script>


				<input type="submit" value="升级会员" class="btn btn-primary" id="b5">
				<script type="text/javascript">
					$("#b5").click(function() {
						navInit();
						$("#b5").addClass("active");
						$.ajax({
							data : null,
							dataType : "HTML",
							success : function(date) {
								$("#page").html(date);
								$("#admin").html("");
							},
							type : "post",
							url : "upgradeToVip.jsp"
						})
					})
				</script>
			</s:if>



			<!-- <form  action="userLogoutAction">
		<input type="submit" value="退出" class="btn btn-danger">
	    </form> -->
		</div>
		<div id="page" class="userfun_page"></div>

	</div>
<s:include value="movic_nav.jsp"></s:include>
<s:include value="movic_bottom.jsp"></s:include>
</body>

</html>
