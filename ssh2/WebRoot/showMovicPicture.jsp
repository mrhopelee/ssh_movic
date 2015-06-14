<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>电影海报维护</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  </head>
  
  <body>
    <a href="adminFunction.jsp">返回管理页面</a><br>
    <div style="width: 980px;margin: 0 auto;">
    <table class="table table-bordered">
    <s:iterator value="movicPictureList" id="l" status="s">
    <tr>
    <td>编号：</td>
    <td><s:property value="#s.count"/> </td>

    <td><img width="200px" height="200px" alt="无法显示" src='<s:property value="#l.picturePath"/>'></td>
 	<td>
 	<s:form action="deletePictureAction" method="post" namespace="/">
 	<input type="hidden" value='<s:property value="mpOid"/>' name="nowPicture.mpOid">
 	<input type="hidden" value='<s:property value="#l.picturePath"/>' name="nowPicture.picturePath">
 	<input type="submit" value="删除">
 	</s:form>
 	
 	</td>
    </tr>
    </s:iterator>
    </table>
    <s:form action="pictureUploadAction" enctype="multipart/form-data" method="post">
    <s:file name="upload" label="选择上传文件" ></s:file>
    <input type="hidden" name="movicOid" value='<s:property value="movicOid"/>'>
    <s:submit value="上传"></s:submit>
    </s:form>
    </div>
  </body>
</html>
