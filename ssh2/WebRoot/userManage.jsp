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

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
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
		if (arraylist!= null) {
	%>
	<br>
	<table align="center" class="altrowstable" id="alternatecolor">
	<tr><p align="center" color="gray">
		<font size=" 3" color="gray">--------------------User Manage Page--------------------</font>
	</p></tr>
	<br>
		<thead>
			<tr>
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
			for (int i = 0; i< arraylist.size(); i++) {
					UserInfo user = new UserInfo();
					user = (UserInfo) arraylist.get(i);
		%>
		<tr>
			<td><%=user.getUserOid()%></td>
			<td><%=user.getUserName()%></td>
			<%-- 	<td><%=user.getUserPassword()%></td> --%>
			<td><%=user.getUserDisplayName()%></td>
			<td>(<%=user.getUserType().getValue()%>)<%=user.getUserType().getRemarks()%></td>
			<td><%=user.getUserSex()%></td>
			<td><%=user.getUserEmail()%></td>
			<td>
				<form name="form" action="deleteUser" method="POST">
					<input type="submit" value="删除"
						onclick="return window.confirm('你确定要删除吗？')" /> <input
						type="hidden" name="userOid" value=<%=user.getUserOid()%>>
				</form>
			</td>
			<td>
				<form name="form1" action="updateType" method="POST">
					<input type="submit" value="修改 "> <input type="hidden"
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

	<hr color="gray" size="3">
</body>
</html>
