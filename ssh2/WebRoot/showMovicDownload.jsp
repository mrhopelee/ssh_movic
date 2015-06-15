<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  taglib  prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>电影下载管理</title>
	  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  </head>
  
  <body>
  <a href="adminFunction.jsp">返回管理页面</a>
    <div style="margin: 0 auto; width: 980px;">
    <table class="table table-bordered" >
    <s:iterator value="mdl" id="l" status="s">
    <tr>
    <td><s:property value="#s.count" /></td>
    <td><s:property value="#l.filePath" /></td>
    <td>
    <form action="movicDownloadDeleteAction" method="post">
    <input type="submit" value="删除下载文件">
    <input type="hidden" name="mdOid" value='<s:property value="#l.mdOid" />'>
    <input type="hidden" name="movicOid" value="<s:property value="movicOid" />">
    </form>
    </td>
    </tr>
    
    </s:iterator>
    </table>
    <s:fielderror></s:fielderror>
    <s:form action="movicFileUploadAction" enctype="multipart/form-data" method="post">
    <s:file name="upload" label="选择上传文件" ></s:file>
    <s:hidden name="movicOid" value="%{movicOid}"></s:hidden>
    <s:submit value="上传"></s:submit>
    </s:form>
    </div>
    
    
  </body>
</html>
