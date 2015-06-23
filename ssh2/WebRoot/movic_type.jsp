<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电影类型</title>


<link rel="stylesheet" type="text/css" href="css/normalize.css">

</head>

<body>
	<a href="adminFunction.jsp">返回管理页面</a><br/>
	<s:action name="movictypesetsession" flush="false" namespace="/"></s:action>

	<s:iterator value="#session.movictypelist" status="mt">
		<%-- ID: <s:property value="mtOid" /> --%>
	类型<s:property value="(#mt.count)" />: <s:property value="type" />

		<s:if test="#mt.count%3==0">
			<br />
		</s:if>
	</s:iterator>

	<p>电影类型增加</p>
	<s:form action="insertmovictype" namespace="/">
		<s:fielderror fieldName="insertmt"></s:fielderror>
		<s:textfield name="movictype.type" label="电影类型"></s:textfield>
		<s:submit value="添加"></s:submit>
	</s:form>
	<p>电影类型修改</p>
	<s:form action="updatemovictype" namespace="/">
		<s:fielderror fieldName="updatemt"></s:fielderror>
		<s:select name="movictype.type" label="电影类型" labelposition="left"
			list="#session.movictypelist.{type}"
			value="#session.movictypelist.{type}"></s:select>
		<s:textfield name="updateType" label="修改为"></s:textfield>
		<s:submit value="修改"></s:submit>
	</s:form>
	<p>电影类型删除</p>
	<s:form action="deletemovictype" namespace="/">
		<s:fielderror fieldName="deletemt"></s:fielderror>
		<s:select name="movictype.type" label="电影类型" labelposition="left"
			list="#session.movictypelist.{type}"
			value="#session.movictypelist.{type}"></s:select>
		<s:submit onclick="return window.confirm('你确定删除这一电影类型吗吗？')" value="删除"></s:submit>
		<!-- <input type="submit" onclick="return window.confirm('你确定删除吗？')" value="删除"></input> -->
	</s:form>

</body>
</html>
