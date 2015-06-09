<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>删除电影</title>


	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <a href="adminFunction.jsp">返回管理页面</a><br>
    <table border="1">
    <s:iterator value="movicInfo" id="m">
    <tr>
    <td><s:property value="#m.movicName"/></td>
    <td><s:date name="#m.movicPlayDate" format="yyyy/mm/yy"/></td>
    <td><img src="<s:property value="#m.movicPost"/>" alt="无法显示"></td>
    <td>
    <form action="deleteMovicAction"><input type="submit" value="删除">
    <input type="hidden" name="movic.movicOid" value='<s:property value="#m.movicOid"/>'>
    </form>
    </td>
    </tr>
    </s:iterator>
    </table>


	<table>
	<tr>
	<td>一共：<s:property value="paging.pageCount"/>页</td>
	<td>当前为：第<s:property value="paging.pageNow"/>页</td>
	</tr>
	<tr>
	
	<td>
	<s:form action="getAllMovicDAction" namespace="/"><input type="submit" value="<s:property value="paging.pageNow-1"/>">
	<input type="hidden" value="<s:property value="paging.pageNow-1"/>" name="paging.pageNow">
	</s:form>
	</td>
	
	<td>
	<s:form action="getAllMovicDAction" namespace="/"><input type="submit" value="<s:property value="paging.pageNow"/>">
	<input type="hidden" value="<s:property value="paging.pageNow"/>" name="paging.pageNow">
	</s:form>
	</td>
	
	<td>
	<s:form action="getAllMovicDAction" namespace="/"><input type="submit" value="<s:property value="paging.pageNow+1"/>">
	<input type="hidden" value="<s:property value="paging.pageNow+1"/>" name="paging.pageNow">
	</s:form>
	</td>
	
	
	</tr>
	</table>

  </body>
</html>
