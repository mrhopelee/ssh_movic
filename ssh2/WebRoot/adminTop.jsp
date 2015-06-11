<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div>
<table>
<caption>电影管理功能</caption>
<tr>
<td><form action="movic_area.jsp" ><input type="submit" value="电影地区维护"></form></td>
<td><form action="movic_type.jsp"><input type="submit" value="电影类型维护"></form></td>
<td><form action="goToAddMovicPageAction"><input type="submit" value="电影添加"></form></td>
<td>
<form action="getAllMovicDAction"><input type="submit" value="电影删除">
<input type="hidden" value="1" name="paging.pageNow">
</form>
</td>
<td>
<form action="getAllMovicUAction"><input type="submit" value="电影修改">
<input type="hidden" value="1" name="paging.pageNow">
</form>
</td>
<td><form ><input type="submit" value="更新电影海报"></form></td>
<td><form ><input type="submit" value="电影图册维护"></form></td>
</tr>
</table>
</div>

<div>
<table >
<caption>用户管理功能</caption>
<tr>
<td><form ><input type="submit" value="用户删除"></form></td>
</tr>
</table>
</div>

<div>
<table>
<caption>广告管理功能</caption>
<tr>
<td><form ><input type="submit" value="添加广告"></form></td>
<td><form ><input type="submit" value="设置广告位置"></form></td>
</tr>
</table>
</div>

<div>
<table>
<caption>评论管理功能</caption>
<tr>
<td><form ><input type="submit" value="删除评论"></form></td>
</tr>
</table>
</div>
 