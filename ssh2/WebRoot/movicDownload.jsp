<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>电影下载</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  </head>
  
  <body>
   <s:fielderror></s:fielderror>
   <s:if test="isok==0">
   <a href="scanMovieAction?id=<%=request.getAttribute("movicOid") %>">返回</a>
   </s:if>
   <s:if test="isok!=0">
    <a href="scanMovieAction?id=<%=request.getAttribute("movicOid") %>">返回</a>
   <div style="margin: 0 auto; width: 980px;">
   <table class="table table-bordered" >
   <s:iterator value="mdl" status="s" id="mdl">
   <tr>
   <td>资源<s:property value="#s.count"/></td>
   <td>
   <form action="downLoadFileAction">
   <input type="submit" value="下载">
   <input type="hidden" name="downLoadFile" value="<s:property value="#mdl.filePath"/>">
   <input type="hidden" name="movicOid" value='<s:property value="movicOid"/>'>
   </form>
   </td>
   </tr>
   
   </s:iterator>
   </table>
   </div>
   
   </s:if>
   
  </body>
</html>
