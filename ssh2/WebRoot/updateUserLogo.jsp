<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>更新用户头像</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>

</head>

<body>

	<div class="col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 ">
		<div style="max-width:500px; text-align: center; margin: 0 auto;">
			<%-- <s:property value="#session.user.userDisplayName" /> --%>
			<s:if test="#session.user.userLogo==null">
		<img width="200px" height="200px" alt="无法显示"
			src="img/user_large.jpg" class="img-circle">
			</s:if>
			<s:else>
			<img id="logo1" width="200px" height="200px" alt="无法显示"
			src='<s:property value="#session.user.userLogo"/>' class="img-circle">
			</s:else>

			<s:form action="updateUserLogoAction" enctype="multipart/form-data"
				method="post">
				<s:file cssStyle="display: inline-block;margin-top: 30px;"
					name="upload" label="选择上传文件" id="file1"></s:file>
					<script type="text/javascript">
					$("#file1").change(function()
					{
						alert("ok");
						var file = this.files[0]; 
    					if(!/image\/\w+/.test(file.type)){ 
       					alert("文件必须为图片！"); 
       					
    					}
    					else
    					{
    						var reader = new FileReader();
    						reader.readAsDataURL(this.files[0]);
    						 reader.onload = function(e){ 
    						 $("#logo1").attr("src", this.result);
    						 }
    					}
					})
					
				
					
					
					
					
					</script>
					
				<input style="display: inline-block;margin-top: 30px;"
					type="hidden" name="user.userOid"
					value='<s:property value="#session.user.userOid"/>'>
				<input style="display: inline-block;margin-top: 30px;"
					type="hidden" name="user.userLogo"
					value='<s:property value="#session.user.userLogo"/>'>
				<s:submit cssStyle="display: inline-block;margin-top: 30px;"
					value="上传"></s:submit>
			</s:form>
		</div>
	</div>
</body>
</html>
