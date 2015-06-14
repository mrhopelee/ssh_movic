<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>电影海报更新页面</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">

  </head>
  
  <body>
  <!-- 根据电影id显示电影海报 并提供上传海报选项 -->
  <a href="adminFunction.jsp">返回管理页面</a><br>
  <div style="width: 980px;margin: 0 auto;">
    <table class="table table-bordered">
  <tr><td>电影名</td><td><s:property value="movic.movicName"/></td></tr>
  <tr><td>电影编号</td><td><s:property value="movic.movicOid"/></td></tr>
  <tr><td>电影海报</td><td><img height="200px" alt="无法显示" src="<s:property value="movic.movicPost"/>"></td></tr>
  </table>
    
    <s:form action="postUploadAction" enctype="multipart/form-data" method="post">
    <s:file name="upload" label="选择上传文件" ></s:file>
    <s:hidden name="movic.movicOid" value="%{movic.movicOid}"></s:hidden>
    <s:submit value="上传"></s:submit>
    </s:form>
    </div>
  </body>
</html>
