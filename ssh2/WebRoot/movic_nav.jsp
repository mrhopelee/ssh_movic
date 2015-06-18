<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="css/3.3.4bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/movic_nav.css">
<script src="javascript/2.1.4jquery.js"></script>
<script src="javascript/3.3.4bootstrap.min.js"></script>

<body class="container-fluid">
	<s:action name="movicareasetsession" flush="false" namespace="/"></s:action>
	<s:action name="movictypesetsession" flush="false" namespace="/"></s:action>
	<s:action name="moviciatmixsetsession" flush="false" namespace="/"></s:action>
	<div class="row">
		<div class="col-sm-12 col-md-12 iatborderline navbar-fixed-top">
			<div class="col-sm-6 col-sm-offset-1 col-md-6 col-md-offset-1 logo ">
				<div class="col-sm-4 col-md-4">myfilm</div>
				<!-- <h2 class="logo">My Film</h2> -->
				<div class="col-sm-8 col-md-8 iatsearch">
					<s:form cssClass="input-group " action="moviciatsetsearch"
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
						class="list-group-item" href="index.jsp">X</a>
				</div>
				<div class="col-xs-6 col-md-6 iatuser">
					<a class="userimg list-group-item" href="usermanager.jsp"> <img
						src="movic_picture/14.jpg" alt="username" /><span>&nbsp;</span>
					</a>
					<div class="list-group iatuserhidden">
						<a href="usermanager.jsp" class="list-group-item"> 用户中心 </a> <a
							href="out.jsp" class="list-group-item"> 退出</a>
					</div>
				</div>

				<!-- <div class="col-xs-6 col-md-6 iatuser">
					<a class="list-group-item" href="index.jsp">登陆</a> <a
						class="list-group-item" href="index.jsp">注册</a>
				</div> -->
				<!-- 登陆后要显示的 -->
			</div>
			<!-- <div class="col-xs-4 col-md-4" >
				 
				</div> -->
		</div>
	</div>

</body>
