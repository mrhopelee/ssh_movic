<%@page import="java.awt.Window"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.bean.UserInfo"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'userManage.jsp' starting page</title>


<link rel="stylesheet" type="text/css" href="css/3.3.4bootstrap.min.css">
<link href="css/cc.css" rel="stylesheet" type="text/css" />
<script src="javascript/2.1.4jquery.js"></script>
<script src="javascript/3.3.4bootstrap.min.js"></script>

</head>

<body>
<div class="col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">


	<br>
	<p align="center" color="gray">
		<font size=" 3" color="gray">--------------------Welcome--------------------</font>
	</p>

	<br>
	<br>
	<br>
	<hr color="gray" size="3">
	<s:action name="allUser" flush="true" namespace="/"></s:action>
	<%
		session = request.getSession();
		ArrayList arraylist = (ArrayList<UserInfo>) session
				.getAttribute("allUser");
		if (arraylist != null) {
	%>
	<br>
	<table align="center" class="table table-hover table-bordered "  >
		<tr>
			<p align="center" color="gray">
				<font size=" 3" color="gray">--------------------User Manage
					Page--------------------</font>
			</p>
		</tr>
		<br>
		<thead align="center">
			<tr  >
				<th>id</th>
				<th>name</th>
				<!-- 	<th>pwd</th> -->
				<th>disName</th>
				<th>type</th>
				<th>sex</th>
				<th>email</th>
				<th>Delete</th>
				<th>Modify</th>
			</tr>
		</thead>
		<%
			for (int i = 0; i < arraylist.size(); i++) {
					UserInfo user = new UserInfo();
					user = (UserInfo) arraylist.get(i);
		%>
		<tr align="center">
			<td><%=user.getUserOid()%></td>
			<td><%=user.getUserName()%></td>
			<%-- 	<td><%=user.getUserPassword()%></td> --%>
			<td ><%=user.getUserDisplayName()%></td>
			<td>(<%=user.getUserType().getValue()%>)<%=user.getUserType().getRemarks()%></td>
			<td><%=user.getUserSex()%></td>
			<td><%=user.getUserEmail()%></td>
			<td>
				<form name="form" action="deleteUser" method="POST">
					<input class="btn btn-default buttom1"  type="submit" value="删除"
						onclick="return window.confirm('你确定要删除吗？')" /> <input
						type="hidden" name="userOid" value=<%=user.getUserOid()%>>
				</form>
			</td>
			<td>
				<form name="form1" action="updateType" method="POST">
					<input class="btn btn-default buttom1"  type="submit" value="修改 "> <input type="hidden"
						name="userOid" value=<%=user.getUserOid()%> />
				</form>
			</td>
		</tr>
		<%
			}
		%>

	</table>
	<%
		}
	%>
</div>
	<hr color="gray" size="3">
</body>
</html>
