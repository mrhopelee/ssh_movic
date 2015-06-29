<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css" href="css/movic_nav.css">

<body class="container-fluid">
	<!-- <div class="row"> -->
	<div class="col-sm-12 col-md-12 iatborderline navbar-fixed-top">
		<div class="col-sm-6 col-sm-offset-1 col-md-6 col-md-offset-1 ">
			<div class="col-sm-4 col-md-4 nav_left">
				<a href="index.jsp" class=""><span class="nav_logo">myfilm</span></a>
			</div>
			<!-- <h2 class="logo">My Film</h2> -->
			<div class="col-sm-8 col-md-8 iatsearch">
				<s:form cssClass="input-group" action="moviciatsetsearch"
					namespace="/">
					<s:textfield cssClass="form-control" name="search"
						value="%{#session.moviciatsearch}" placeholder="我的电影">
					</s:textfield>
					<span class="input-group-btn"> <s:submit
							cssClass="btn btn-default" value="搜索"></s:submit>
					</span>
				</s:form>
			</div>
		</div>
		<div class="col-sm-4 col-md4 iatnava">
			<div class="col-xs-6 col-md-6 iatnavlink">
				<a class="list-group-item" href="index.jsp">首页</a> <a
					class="list-group-item" href="index.jsp"> </a>
			</div>
			<s:if test="#session.user!=null">
				<div class="col-xs-6 col-md-6 iatuser">
					<a class="userimg list-group-item" href="usermanager.jsp"> <%-- <img src="<s:property value="#session.user.userLogo"/>" alt="username" /> --%>

						<s:if test="#session.user.userLogo==null">
							<img alt="无法显示" src="img/user_large.jpg">
						</s:if> <s:else>
							<img id="logo1" alt="无法显示"
								src='<s:property value="#session.user.userLogo"/>'>
						</s:else> <span>&nbsp;</span>
					</a>
					<div class="list-group iatuserhidden">
						<a href="userFunction.jsp" class="list-group-item"> 个人中心 </a> <a
							href="userLogoutAction" class="list-group-item"> 退出</a>
					</div>
				</div>
			</s:if>
			<s:else>
				<div class="col-xs-6 col-md-6 iatuser">
					<a class="list-group-item" href="userLogin.jsp">登陆</a> <a
						class="list-group-item" href="userRegister.jsp">注册</a>
				</div>
			</s:else>
		</div>
		<!-- <div class="col-xs-4 col-md-4" >
				 
				</div> -->
	</div>
	<!-- </div> -->

</body>
