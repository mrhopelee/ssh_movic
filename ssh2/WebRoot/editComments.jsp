<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="http://localhost:8080/ssh2/">

<title>发表评论</title>

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap1.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- start plugins -->
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>



</head>


<body>

	<!--  

               
    <form  method="POST" name="lzform" action="subCommentsAction" >
        <table align="center">
            <tr>
                <td>评价:
                        <label><input type="radio" name="score" value="1"  checked="checked"/>很差</label>
                        <label><input type="radio" name="score" value="2"  />较差</label>
                        <label><input type="radio" name="score" value="3"  />还行</label>
                        <label><input type="radio" name="score" value="4"  />推荐</label>
                        <label><input type="radio" name="score" value="5"  />力荐</label>
                </td>
            </tr>
            <tr>
                <td>
                    <textarea required="required" name="comments_text" style="width:448px;height:337px"></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <br/>
                    <input type="hidden" name="nowMovieId" value='0'>
                    

                    <input name="rev_submit" type="submit" value="好了，添加评论"/>&nbsp;&nbsp;&nbsp;
                    <a href="scanMovieAction?id=0">取消</a>
                </td>
            </tr>
        </table>
    </form>
-->
<br><br><br><br><br><br><br><br><br>
			<s:fielderror></s:fielderror>
 
	           <form method="post" action="subCommentsAction" >
	           <div align="center">
	           <table align="center">
            	<tr>
                	<td style="color:#fff">评价:
	           		<label><input type="radio" name="score" value="1"  checked="checked"/>很差</label>
                    <label><input type="radio" name="score" value="2"  />较差</label>
                    <label><input type="radio" name="score" value="3"  />还行</label>
                    <label><input type="radio" name="score" value="4"  />推荐</label>
                    <label><input type="radio" name="score" value="5"  />力荐</label>
                    </td>
           	 	</tr>
           	 	</table>
	           </div>
				
					<div class="text" align="center">
		               <textarea required="required" name="comments_text"   placeholder="Message:"></textarea>
		            </div>
		            <div align="center" class="form-submit1">
		         		<input type="submit" value="好了，添加评论"><br>
		         		<a href="scanMovieAction?id= <s:property value="#session.nowMovieId"/>">取消</a>
			        </div>
					<div class="clearfix"></div>
	          	</form>
 


</body>

</html>
