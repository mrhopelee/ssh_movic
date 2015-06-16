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
<script type="text/javascript">
	function altRows(id) {
		if (document.getElementsByTagName) {

			var table = document.getElementById(id);
			var rows = table.getElementsByTagName("tr");

			for (i = 0; i < rows.length; i++) {
				if (i % 2 == 0) {
					rows[i].className = "evenrowcolor";
				} else {
					rows[i].className = "oddrowcolor";
				}
			}
		}
	}

	window.onload = function() {
		altRows('alternatecolor');
	}
</script>


<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
table.altrowstable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #a9c6c9;
	border-collapse: collapse;
}

table.altrowstable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

table.altrowstable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

.oddrowcolor {
	background-color: #d4e3e5;
}

.evenrowcolor {
	background-color: #c3dde0;
}
</style>

</head>

<body>

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

	<form id="form1" name="form1" method="post" action="upgradeToVip" >
		<table align="center" class="altrowstable" id="alternatecolor">
			<tr>
				<p align="center" color="gray">
					<font size=" 3" color="gray">--------------------Upgrade To Vip--------------------</font>
				</p>
			</tr>
			<br>
			<tr>
				<td>用户：</td>
				<td><input name="userName" type="text"
					value="<%=user1.getUserName()%>" id="userName" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><%=user1.getUserDisplayName()%></td>
			</tr>
			
			<tr>
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
			<tr>
				<td>当前用户积分 ：</td>
				<td> <input name="userScore" type="text"
					value="<%=ui.getUserScore()%>" id="userScore" readonly="readonly" />
					<s:fielderror fieldName="score"/></td>
			</tr>

			<tr>
				<td><input type="submit" name="submit" value="点击升级为VIP" />
				<td><a href="index.jsp">返回主页</a></td>
			</tr>

		</table>
	</form>

</body>
</html>
