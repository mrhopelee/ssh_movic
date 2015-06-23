<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>更新用户头像</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>

<body>

	<div>
		<s:property value="#session.user.userDisplayName" />
		<s:if test="#session.user.userLogo==null">
		<img width="200px" height="200px" alt="无法显示"
			src="img/user_large.jpg" class="img-circle">
			</s:if>
			<s:else>
			<img width="200px" height="200px" alt="无法显示"
			src='<s:property value="#session.user.userLogo"/>' class="img-circle">
			</s:else>

		<s:form action="updateUserLogoAction" enctype="multipart/form-data"
			method="post">
			<s:file name="upload" label="选择上传文件"></s:file>
			<input type="hidden" name="user.userOid"
				value='<s:property value="#session.user.userOid"/>'>
			<input type="hidden" name="user.userLogo"
				value='<s:property value="#session.user.userLogo"/>'>
			<s:submit value="上传"></s:submit>
		</s:form>
	</div>
</body>
</html>
