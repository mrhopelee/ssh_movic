<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.bean.UserInfo"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'UpdateUserPassword.jsp' starting page</title>
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
	<br>
	
<%-- <s:action name="test" flush="true" namespace="/"></s:action>	 --%>
<%
session=request.getSession();
UserInfo user=(UserInfo)session.getAttribute("user");
//System.out.println(user.getEmail());  
%>
<form method="POST" action="updateUserPassword" namespace="/">
<table align="center" class="altrowstable" id="alternatecolor">
	<tr><p align="center" color="gray">
		<font size=" 3" color="gray">--------------------Update UserMessage Page--------------------</font>
	</p></tr>
	<br>
    <tr>
      <td ">用户名：</td>
      <td ><label>
        <input name="userName" type="text" id="userName" value="<%=user.getUserName()%>"  readonly="readonly"/>
      </label></td>
    </tr>
    <tr>
      <td>新密码：</td>
      <td><label>
        <input name="userPassword" type="password" id="userPassword"/>
      </label>
      <s:fielderror fieldName="password"/></td>
    </tr>   
   
  <tr>
      <td>确认密码：</td>
      <td><label>
        <input name="rePassword" type="password" id="rePassword" />
      </label><s:fielderror fieldName="rePassword"/></td>
    </tr>  

    <tr>
      <td><label>
        <input type="submit" name="Submit" value="提交" />
      </label></td>
      <td><label>
      
 <a href="index.jsp">返回主页</a>
      </label></td>
    </tr>
</table>
</form>

 
   
  </body>
</html>
