<%@ page language="java" import="java.util.*,com.bean.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管理员页面</title>
<link rel="stylesheet" type="text/css" href="css/adminfunction.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<style type="text/css">
#circularMenu {
	padding: 0;
	margin: 0 auto;
	list-style: none;
	position: relative;
	width: 300px;
	height: 300px;
	background: #fff url(images/background.gif) no-repeat;
}

#circularMenu li {
	display: block;
	width: 60px;
	height: 60px;
	position: absolute;
}

#circularMenu li.home {
	width: 48px;
	height: 48px;
	left: 120px;
	top: 4px;
	background: url(images/marea1.png) no-repeat center center;
}

#circularMenu li.chat {
	width: 48px;
	height: 48px;
	left: 200px;
	top: 40px;
	background: url(images/userManage.png) no-repeat center center;
}

#circularMenu li.upload {
	width: 48px;
	height: 48px;
	left: 35px;
	top: 40px;
	background: url(images/mtype.png) no-repeat center center;
}

#circularMenu li.email {
	width: 48px;
	height: 48px;
	left: 230px;
	top: 115px;
	background: url(images/mdelete.png) no-repeat center center;
}

#circularMenu li.address {
	width: 48px;
	height: 48px;
	left: 5px;
	top: 115px;
	background: url(images/commentsManage.png) no-repeat center center;
}

#circularMenu li.shop {
	width: 48px;
	height: 48px;
	left: 200px;
	top: 190px;
	background: url(images/madd.png) no-repeat center center;
}

#circularMenu li.search {
	width: 48px;
	height: 48px;
	left: 35px;
	top: 190px;
	background: url(images/mupdate.png) no-repeat center center;
}

#circularMenu li.delivery {
	left: 120px;
	top: 225px;
	background: url(images/delivery.gif) no-repeat center center;
}

#circularMenu li a b {
	display: none;
}

#circularMenu li a {
	display: block;
	width: 60px;
	height: 60px;
	text-align: center;
}

#circularMenu li a:hover {
	background: url(images/circle.gif);
	text-decoration: none;
	font-family: georgia, serif;
}

#circularMenu li a:hover b {
	position: absolute;
	display: block;
	width: 100px;
	height: 100px;
	font-size: 16px;
	color: #63352c;
	background: #fff;
}

#circularMenu li a:hover b span {
	display: block;
	font-size: 12px;
	color: #888;
	font-weight: normal;
	margin-top: 15px;
}

#circularMenu li.home a:hover b {
	left: -22px;
	top: 100px;
}

#circularMenu li.chat a:hover b {
	left: -102px;
	top: 64px;
}

#circularMenu li.upload a:hover b {
	left: 63px;
	top: 64px;
}

#circularMenu li.email a:hover b {
	left: -132px;
	top: -11px;
}

#circularMenu li.address a:hover b {
	left: 93px;
	top: -11px;
}

#circularMenu li.shop a:hover b {
	left: -102px;
	top: -87px;
}

#circularMenu li.search a:hover b {
	left: 63px;
	top: -87px;
}

#circularMenu li.delivery a:hover b {
	left: -22px;
	top: -121px;
}
</style>
</head>

<body>
<s:include value="movic_nav.jsp"></s:include>
<div id="admin">
	<!-- =============================试验效果================== -->

	<%! UserInfo user; %>
	<%
 
  
  if(request.getSession().getAttribute("user")==null)
  {
  	response.sendRedirect("index.jsp");
  	return ;
  }
  
  user=(UserInfo) request.getSession().getAttribute("user");
  
  if(user.getUserType().getValue()<3)
  {
  	response.sendRedirect("index.jsp");
  	return ;
  }
  
   %>
	<ul id="circularMenu">
		<%if(user.getUserType().getValue()>=3)
	{
	%>

		<li class="home"><a href="movic_area.jsp"><b>电影地区维护<br />
				<span>点击进入管理</span></b></a></li>
		<li class="upload"><a href="movic_type.jsp"><b>电影类型维护<br />
				<span>点击进入管理</span></b></a></li>
		<li class="email"><a href="getAllMovicDAction?paging.pageNow=1"><b>电影删除<br />
				<span>删除你不想要的电影^.^</span></b></a></li>
		<li class="chat"><a href="goToAddMovicPageAction"><b>电影添加<br />
				<span>点击进入管理</span></b></a></li>
		<!--<li class="delivery"><a href="#"><b>DELIVERY<br /><span>track your deliveries</span></b></a></li>-->
		<li class="address"><a href="getAllMovicUAction?paging.pageNow=1"><b>电影修改<br />
				<span>点击进入管理</span></b></a></li>

		<%
		}
	 	%>
		<%if(user.getUserType().getValue()==4)
	{
	%>

		<li class="shop"><a href="userManage.jsp"><b>用户管理功能<br />
				<span>点击进入管理</span></b></a></li>
		<li class="search"><a href="commentsManage.action"><b>评论管理功能<br />
				<span>删除评论</span></b></a></li>

		<%
		}
	 %>
	</ul>
	<br />
	<br />
	</div>
	<!-- ==========================/试验效果================== -->
</body>
</html>
