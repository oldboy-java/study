<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>查看资源表</title><!--zy-->
	<%@include file="/common/include.jsp" %>
<script>
function load(id){
	$('#_form').form('load','/${projectName}/zygl/zy/vieZy.action?toL=true&id='+id);
};
</script>
</head>
<body>
<form id="_form">
	<input type="hidden" name='id' value=""/>
	<table>
		<tr><td class='label'>资源名称：</td><td><input type='text' name='zymc' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>所属学科：</td><td><input type='text' name='ssxkid' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>文件格式：</td><td><input type='text' name='wjgs' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>上传人：</td><td><input type='text' name='scrid' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>资源状态：</td><td><input type='text' name='zyzt' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>资源地址：</td><td><input type='text' name='zydz' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>资源来源：</td><td><input type='text' name='zyly' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>作者：</td><td><input type='text' name='zz' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>上传日期：</td><td><input type='text' name='scrq' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>浏览次数：</td><td><input type='text' name='llcs' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>下载次数：</td><td><input type='text' name='xzcs' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>收藏次数：</td><td><input type='text' name='sccs' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>评论次数：</td><td><input type='text' name='plcs' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>文件大小：</td><td><input type='text' name='wjdx' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>审核状态：</td><td><input type='text' name='shzt' class='viewbox' readonly='readonly'/></td></tr>
		<!-- <tr><td class='label'>学校ID：</td><td><input type='text' name='xxid' class='viewbox' readonly='readonly'/></td></tr> -->
	</table>

</form>
</body>
</html>
