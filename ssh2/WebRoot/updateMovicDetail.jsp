<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>电影信息更新</title>
    <sx:head extraLocales="UTF-8" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <a href="adminFunction.jsp">返回管理页面</a><br>
   	<s:fielderror></s:fielderror>
	<div style="margin: 0 auto">
    <form action="updateMovicAction" method="post">
    <input type="text" value='<s:property value="movic.movicOid"/>' name="movic.movicOid" readonly="readonly" >
    <table border="1" >
    <tr>
    <td>电影名</td>
    <td colspan="3"><input type="text" required="required" name="movic.movicName" value='<s:property value="movic.movicName"/>'></td>
    </tr>
    
    <tr>
    <td>导演</td>
    <td colspan="3"><input type="text" required="required" name="movic.movicDirector"  value='<s:property value="movic.movicDirector"/>'></td>
    </tr>
    
    <tr>
    <td>演员</td>
    <td colspan="3"><input type="text" required="required" name="movic.movicActor" value='<s:property value="movic.movicActor"/>'></td>
    </tr>
    
    <tr><sx:datetimepicker name="movic.movicPlayDate" label="上映日期"
					displayFormat="yyyy-MM-dd" value="%{movic.movicPlayDate}" />

					</tr>
    
  
    <tr>
    <td>评分</td>
    <td colspan="3">
    <select name="score[0]" >
    <option value="0">0</option>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    </select>
    .
    <select name="score[1]">
    <option value="0">0</option>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    </select>
    <s:property value="movic.movicImdbScore"/>
    </td>
    </tr>
    
    <tr>
    <td>简介</td>
    <td colspan="3"><textarea rows="10" cols="40" required="required" name="movic.movicIntroduction" ><s:property value="movic.movicIntroduction"/></textarea></td>
    </tr>
    
    <!-- 获取出电影类型列表 -->
    <tr>
    <td>电影类型</td>
    <td> 
    <s:select name="mt[0]" list="movicType" listKey="mtOid" listValue="type" ></s:select>
   	<s:select name="mt[1]" list="movicType" listKey="mtOid" listValue="type" ></s:select>
   	<s:select name="mt[2]" list="movicType" listKey="mtOid" listValue="type"></s:select>
    <s:iterator status="s" value="movic.movicBeloneTypes" id="mbt">
    <s:property value="#mbt.movicType.type"/>
    </s:iterator>
    </td>
    
    </tr>
    
    <tr>
    <td>电影地区</td>
    
    <td>
    <s:select name="ma[0]" list="movicArea" listKey="areaOid" listValue="areaName" ></s:select>
    <s:select name="ma[1]" list="movicArea" listKey="areaOid" listValue="areaName" ></s:select>
    <s:iterator status="s" value="movic.movicBeloneAreas" id="mba">
    <s:property value="#mba.movicArea.areaName"/>
    </s:iterator>
    </td>
    </tr>
    
    <tr><td><input type="submit" value="修改"></td><td colspan="3"><input type="reset" value="重置"></td></tr>
    </table>
    </form>
    </div>
  </body>
</html>
