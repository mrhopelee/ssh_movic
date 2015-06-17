<%@page import="java.awt.Window"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.bean.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upgradeToVip.jsp' starting page</title>
<link rel="stylesheet" type="text/css" href="css/3.3.4bootstrap.min.css">
<link href="css/cc.css" rel="stylesheet" type="text/css" />
<script src="javascript/2.1.4jquery.js"></script>
<script src="javascript/3.3.4bootstrap.min.js"></script>


</head>

<body>
<div class="col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
	<br>
	<p align="center" color="gray">
		<font size=" 3" color="gray">--------------------Welcome--------------------</font><br><br>

	~~~~~~~~~~~~~~~尊贵的用户你好~~~~~~~~~~<br>
	~~~~~~~~~~~~~~~~~~~~~~升级为VIP用户可无限下载电影资源喔~~~~~~~~~~~~~~~~~~~~~~<br>
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~精彩电影，等你来下~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
	<font size=" 3" color="red">--------------------积分够999分才可升级为尊贵会员喔亲--------------------</font><br><br>
		<font size=" 5" color="red">--------------------9 9 9--------------------</font><br><br>
		</p>
	<hr color="gray" size="3">
	<br>
<%-- 	<s:action name="test" flush="true" namespace="/"></s:action> --%>
<%! UserInfo user1;%>
	<%
		
	user1 = (UserInfo) request.getSession().getAttribute("user");
	%>
	<p align="center" color="gray">
					<font size=" 3" color="gray">--------------------Upgrade To Vip--------------------</font>
				</p>
	<form id="form1" name="form1" method="post" action="upgradeToVip" >
		<table class="table table-hover table-bordered " align="center" >

			<br>
			<tr  align="center">
				<td>用户：</td>
				<td><input name="userName" type="text"
					value="<%=user1.getUserName()%>" id="userName" readonly="readonly" /></td>
			</tr>
			<tr  align="center">
				<td>用户名：</td>
				<td><%=user1.getUserDisplayName()%></td>
			</tr>
			
			<tr  align="center">
				<td>当前用户类型 ：</td>
				<td>(<%=user1.getUserType().getValue()%>)<%=user1.getUserType().getRemarks()%></td>
			</tr>
			<%
				Iterator<UserIntegral> it = user1.getUserIntegrals().iterator();
				UserIntegral ui = null;
				while (it.hasNext())

				{
					ui = (UserIntegral) it.next();
					System.out.println(ui.getUintegralOid());
					//System.out.println(ui.getUserInfo().getUserOid());
					System.out.println(ui.getUserScore());

				}
			%>
			<tr  align="center">
				<td>当前用户积分 ：</td>
				<td> <input name="userScore" type="text"
					value="<%=ui.getUserScore()%>" id="userScore" readonly="readonly" />
					<s:fielderror fieldName="score"/></td>
			</tr>

			<tr  align="center">
				<td><input class="btn btn-default buttom1"  type="submit" name="submit" value="点击升级为VIP" />
				<td><a href="index.jsp">返回主页</a></td>
			</tr>

		</table>
	</form>
</div>
</body>
</html>
