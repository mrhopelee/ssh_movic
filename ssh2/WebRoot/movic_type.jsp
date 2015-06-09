<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>首页</title>


	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	
</head>

<body>
	<s:action name="movictypesetsession" flush="false" namespace="/">
	</s:action>
	<s:iterator value="#session.movictypelist" status="mt">
	
	<%-- ID: <s:property value="mtOid" /> --%>
	类型<s:property value="(#mt.count)" />: <s:property value="type" />
	
		<s:if test="#mt.count%3==0">
			<br/>
		</s:if>
	</s:iterator>
	电影类型增加
	<br />
	<s:form action="insertmovictype" namespace="/">
		<s:fielderror fieldName="type"></s:fielderror>
		<s:textfield name="movictype.type" label="电影类型" ></s:textfield>
		<s:submit value="添加"></s:submit>
	</s:form>
	<br /> 
	电影类型修改
	<br />
	<s:form action="updatemovictype" namespace="/">
		<s:textfield name="movictype.type" label="电影类型"></s:textfield>
		<s:submit value="添加"></s:submit>
	</s:form>
	<br />
</body>
</html>
