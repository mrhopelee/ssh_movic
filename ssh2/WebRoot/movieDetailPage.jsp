<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%! String []effect={"{\"effect\": \"cubeUp\", \"slices\": 5, \"delay\": 200, \"delayDir\": \"last-first\"}",
"{\"effect\": \"cubeRight\", \"slices\": 5, \"delay\": 200, \"delayDir\": \"last-first\"}",
"{\"effect\": \"cubeLeft\", \"slices\": 5, \"delay\": 200, \"delayDir\": \"last-first\"}",
"{\"effect\": \"cubeDown\", \"slices\": 5, \"delay\": 200, \"delayDir\": \"last-first\"}"};
int count=0;
 %>
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>电影详情页面</title>
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<link href="css/bootstrap1.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!-- start plugins -->
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<!-- 梁泽民加的css样式 开始-->
	<link rel="stylesheet" href="css/reset1.css" />
	<link rel="stylesheet" href="css/ccslider1.css" />
	<link rel="stylesheet" href="css/style1.css" />
 	<style type="text/css">
		#slider {
			width: 980px;
			height: 450px;
			margin: 0 auto;
		}

		#slider .control-links {
			margin-top: -15px;
		}
	</style>
   <script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
	<script src="js/jquery-migrate-1.1.1.min.js"></script>
	<script src="js/jquery.ccslider-3.0.2.min.js"></script>
	<script>
		$(function(){
			$('#demo-nav').find('a').tooltip({effect: 'slide'});
		});

		$(window).load(function(){
			$('#slider').ccslider({
				_3dOptions: {
					imageWidth: 900,
					imageHeight: 350
				}
			});
		});
	</script>
	<!-- 梁泽民加的css样式 结束-->
  </head>
  
  <body>
  <s:include value="userFunction.jsp"></s:include>
 
  <!-- 电影显示区域  --------------------------------->
    <!-- 
  <div style="margin: 0 auto;width: 980px;">
  <table class="table table-bordered">
  <tr> 
  <td width="300px;">
  <img alt="无法显示" src='<s:property value="movic.movicPost"/>' width="300px" height="300px">
  </td>
  <td>
  
  <table class="table table-bordered">
  <tr><td>电影名：</td><td><s:property value="movic.movicName"/></td></tr>
  <tr><td>导演：</td><td><s:property value="movic.movicDirector"/></td></tr>
  <tr><td>演员：</td><td width="500px"><s:property value="movic.movicActor"/></td></tr>
  <tr><td>上映日期:</td><td><s:date format="yyyy-MM-dd" name="movic.movicPlayDate"></s:date></td></tr>
  <tr><td>电影类型：</td>
  <td>
   <s:iterator value="movic.movicBeloneTypes" id="mbt">
    <s:property value="#mbt.movicType.type"/>
    </s:iterator>

  </td>
  </tr>
   <tr><td>电影地区：</td>
  <td>
   <s:iterator  value="movic.movicBeloneAreas" id="mba">
    <s:property value="#mba.movicArea.areaName"/>
    </s:iterator>

  </td>
  </tr>
  <tr><td>评分：</td><td><s:property value="movic.movicImdbScore"/></td></tr>
  
  <tr><td>访问次数：</td>
  <td>
   <s:iterator  value="movic.movicVisiterNumbers" id="mv">
    <s:property value="#mv.visiterNumber"/>
    </s:iterator>

  </td>
  </tr>
  
  </table>
  
  </td>
   </tr>
   <tr>
   <td colspan="2">电影介绍：<s:property value="movic.movicIntroduction"/></td>
   </tr>
   <tr><td>
   <s:actionerror/>
   <form action="showDownloadListAction" method="post">
   <input type="submit" value="下载电影">
   <input type="hidden" value='<s:property value="movic.movicOid"/>' name="movicOid">
   </form>
   </td></tr>
  </table>
  </div>
     -->
  
   <!-- 电影显示区域 --------------------------------->  

   
   <!-- ==============电影显示优化界面开始==================== -->
   <div class="container">
	<div class="container_wrap">
		<div class="header_top">
		    <div class="col-sm-3 logo"><a href="index.html"><img src="images/logo.png" alt=""/></a></div>
			<div class="clearfix"> </div>
	      </div>
	   <div class="content">
      	   <div class="movie_top">
      	         <div class="col-md-9 movie_box">
                        <div class="grid images_3_of_2">
                        	<div class="movie_image">
                                <img src="<s:property value="movic.movicPost"/>" class="img-responsive" alt="无法显示"/>
                            </div>
                            <div class="movie_rate">
                            	<div class="rating_desc"><p>Your Vote :</p></div>
	                            	  <table>
										  	<tr>
										  		<td><img alt="" src="images/star5.png" height="30px" width="50px"></td>
										  		<td>：<s:property value="#session.userCountByScore[4]"/>人觉得力荐!</td>
										  	</tr>
										  	<tr>
										  		<td><img alt="" src="images/star4.png" height="30px" width="50px"></td>
										  		<td>：<s:property value="#session.userCountByScore[3]"/>人觉得推荐!</td>
										  	</tr>
										  	<tr>
										  		<td><img alt="" src="images/star3.png" height="30px" width="50px"></td>
										  		<td>：<s:property value="#session.userCountByScore[2]"/>人觉得还行!</td>
										  	</tr>
										  	<tr>
										  		<td><img alt="" src="images/star2.png" height="30px" width="50px"></td>
										  		<td>：<s:property value="#session.userCountByScore[1]"/>人觉得较差!</td>
										  	</tr>
										  	<tr>
										  		<td><img alt="" src="images/star1.png" height="30px" width="50px"></td>
										  		<td>：<s:property value="#session.userCountByScore[0]"/>人觉得很差!</td>
										  	</tr>
										 
									</table>
						  	   <div class="clearfix"> </div>
                            </div>
                        </div>
                        <div class="desc1 span_3_of_2">
                        	<p class="movie_option"><strong>电影名： </strong><s:property value="movic.movicName"/></p>
                        	<p class="movie_option"><strong>上映日期: </strong><s:date format="yyyy-MM-dd" name="movic.movicPlayDate"></s:date></p>
                        	<p class="movie_option"><strong>导演：</strong><s:property value="movic.movicDirector"/></p>
                        	<p class="movie_option"><strong>演员：</strong><s:property value="movic.movicActor"/></p>
                        	<p class="movie_option"><strong>电影类型： </strong>
                        		 <s:iterator value="movic.movicBeloneTypes" id="mbt">
								    <s:property value="#mbt.movicType.type"/>
								   </s:iterator>	
                        	</p>
                        	<p class="movie_option"><strong>电影地区： </strong>
                        		<s:iterator  value="movic.movicBeloneAreas" id="mba">
							    	<s:property value="#mba.movicArea.areaName"/>
							    </s:iterator>
                        	</p>
                            <p class="movie_option"><strong>评分： </strong><s:property value="movic.movicImdbScore"/></p> 
                            <p class="movie_option"><strong>访问次数： </strong>
								 <s:iterator  value="movic.movicVisiterNumbers" id="mv">
							    	<s:property value="#mv.visiterNumber"/>
							     </s:iterator>
							</p>
                            <div class="down_btn"><a class="btn1" href="showDownloadListAction?movicOid=<s:property value="movic.movicOid"/>"><span> </span>Download</a></div>
                         </div>
                        <div class="clearfix"> </div>
                        
                        <p class="m_4">
                        	<h3>电影介绍：</h3>
                        	<s:property value="movic.movicIntroduction"/>
                        </p>
                        
		                
		                <div class="single">
		                <h1>用户评论</h1>
		                 
		                <ul class="single_list">
		                <s:if test="#session.partCommentsList.size()!=0">
						  	<s:iterator value="#session.partCommentsList" var="mComments">

					        <li>
					            <div class="preview"><img src="<s:property value="#mComments.userInfo.userLogo" />" class="img-responsive" ></div>
					            <div class="data">
					                <div class="title"><s:property value="#mComments.userInfo.userName" />  /  <s:property value="#mComments.commentsDate" />  </div>
					                <p><s:property value="#mComments.commentsInfo" /></p>
					            </div>
					            <div class="clearfix"></div>
					        </li>
					         </s:iterator>
					    </s:if>
					    
					    <s:else>暂无数据</s:else>
					            <form action="scanCommentsAction">
					    					<input type="hidden" name="id" value='<s:property value="#session.nowMovieId"/>'>
						   					<div align="center" class="form-submit1">
								         		<input type="submit" value="更多评论"><br>
					        				</div>
						   		</form>
					    </ul>
					    </div>
					    </div>
  <!--  ====================右边图册区 在这里添加=======================================-->
					    
					    
                      <div class="col-md-3">
                      	<div class="movie_img"><div class="grid_2">
							<img src="images/pic6.jpg" class="img-responsive" alt="">
							<div class="caption1">
									<ul class="list_5 list_7">
							    		<li><i class="icon5"> </i><p>3,548</p></li>
							    	</ul>
							    	<i class="icon4 icon6 icon7"> </i>
							    	<p class="m_3">Guardians of the Galaxy</p>
							</div>
						    </div>
						   </div>
                      	  <div class="grid_2 col_1">
							<img src="images/pic2.jpg" class="img-responsive" alt="">
							<div class="caption1">
								<ul class="list_3 list_7">
						    		<li><i class="icon5"> </i><p>3,548</p></li>
						    	</ul>
						    	<i class="icon4 icon7"> </i>
						    	<p class="m_3">Guardians of the Galaxy</p>
							</div>
						   </div>
						    <div class="grid_2 col_1">
							<img src="images/pic9.jpg" class="img-responsive" alt="">
							<div class="caption1">
								<ul class="list_3 list_7">
						    		<li><i class="icon5"> </i><p>3,548</p></li>
						    	</ul>
						    	<i class="icon4 icon7"> </i>
						    	<p class="m_3">Guardians of the Galaxy</p>
							</div>
						   </div>
		               </div> 
                      <div class="clearfix"> </div>
                  </div>
           </div>
    </div>
</div>

<!-- ============================输写评论区 （开始） ===================================================== -->
 <h2 align="center">
		<a href="editComments.jsp">我也要评论！</a>
</h2>

 <!-- ============================输写评论区 （结束） ===================================================== --> 
					    
   
 
<!-- =======================可以插入广告 ，友情连接，也可以不要============== -->
<div class="container"> 
 <footer id="footer">
 	<div id="footer-3d">
		<div class="gp-container">
			<span class="first-widget-bend"> </span>
		</div>		
	</div>
    <div id="footer-widgets" class="gp-footer-larger-first-col">
		<div class="gp-container">
            <div class="footer-widget footer-1">
            	<div class="wpb_wrapper">
					<img src="images/f_logo.png" alt=""/>
				</div> 
	          <br>
	          <p>It is a long established fact that a reader will be distracted by the readable content of a page.</p>
			  <p class="text">There are many variations of passages of Lorem Ipsum available, but the majority have suffered.</p>
			 </div>
			 <div class="footer_box">
			  <div class="col_1_of_3 span_1_of_3">
					<h3>Categories</h3>
					<ul class="first">
						<li><a href="#">Dance</a></li>
						<li><a href="#">History</a></li>
						<li><a href="#">Specials</a></li>
					</ul>
		     </div>
		     <div class="col_1_of_3 span_1_of_3">
					<h3>Information</h3>
					<ul class="first">
						<li><a href="#">New products</a></li>
						<li><a href="#">top sellers</a></li>
						<li><a href="#">Specials</a></li>
					</ul>
		     </div>
		     <div class="col_1_of_3 span_1_of_3">
					<h3>Follow Us</h3>
					<ul class="first">
						<li><a href="#">Facebook</a></li>
						<li><a href="#">Twitter</a></li>
						<li><a href="#">Youtube</a></li>
					</ul>
					<div class="copy">
				      <p>&copy; 2015 Template by <a href="http://w3layouts.com" target="_blank"> w3layouts</a></p>
			        </div>
		     </div>
		    <div class="clearfix"> </div>
	        </div>
	        <div class="clearfix"> </div>
		</div>
	</div>
  </footer>
</div>
   
   

     <!-- ==============电影显示优化界面结束==================== -->
	  
  <!-- ==============================显示用户评价区    ( 开始)========================================== -->
  <!--  

            
  <table>
  	<tr>
  		<td><img alt="" src="images/star5.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[4]"/>人觉得力荐!</td>
  	</tr>
  	<tr>
  		<td><img alt="" src="images/star4.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[3]"/>人觉得推荐!</td>
  	</tr>
  	<tr>
  		<td><img alt="" src="images/star3.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[2]"/>人觉得还行!</td>
  	</tr>
  	<tr>
  		<td><img alt="" src="images/star2.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[1]"/>人觉得较差!</td>
  	</tr>
  	<tr>
  		<td><img alt="" src="images/star1.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[0]"/>人觉得很差!</td>
  	</tr>
 
  </table>
  
  -->
  <!-- ==============================显示用户评价区     (结束)========================================== -->  
  

         
  <!-- ===========================电影详情页面显示部分评论区  (开始)========================================== -->
  <!--  
  <hr>
    <s:if test="#session.partCommentsList.size()!=0">
	   	<table border="0" align="center">
	   		<tr>
      			<td width="300px"><div align="center">评论日期</div></td>
      			<td width="100px"><div align="center">评论用户</div></td>
      			<td width="300px"><div align="center">评论内容</div></td>
      		</tr>
	   		<s:iterator value="#session.partCommentsList" var="mComments">
	   			<tr>
		   			<td width="300px" align="center"><s:property value="#mComments.commentsDate" /></td>
		   			<td width="100px" align="center"><s:property value="#mComments.userInfo.userName" /></td>
		   			<td width="300px" align="center"><s:property value="#mComments.commentsInfo" /></td>
	   			</tr>
	   		</s:iterator>
	   		<tr><td colspan='3' align="center">...</td></tr>
	   		<tr>
	   			<td align="center" colspan='3'>
	   				<form action="scanCommentsAction" namespace="/">
	   					<input type="submit" value="更多评论">
    					<input type="hidden" name="id" value='<s:property value="#session.nowMovieId"/>'>
	   				</form>
	   			</td>
	   		</tr>
	   	</table>
   	</s:if>
   	<s:else>暂无数据</s:else>
   	<hr>   
   	-->	
<!-- ===========================/电影详情页面显示部分评论区  (结束)========================================== -->
<!-- 电影海报-->
 <div id="slider">
     <s:iterator  value="movic.movicPictures" id="mp">
     <img width="980px" src="<s:property value="#mp.picturePath"/>"  data-transition='<%=effect[count++%4] %>' />
     </s:iterator>
 </div>

  </body>
</html>
