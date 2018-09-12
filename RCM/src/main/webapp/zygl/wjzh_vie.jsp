<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>查看文件转换表</title><!--wjzh-->
	<%@include file="/common/include.jsp" %>
<script>
function load(id){
	$('#_form').form('load','/${projectName}/zygl/wjzh/vieWjzh.action?toL=true&id='+id);
};
</script>
</head>
<body>
<form id="_form">
	<input type="hidden" name='id' value=""/>
	<table>
		<tr><td class='label'>文件Id：</td><td><input type='text' name='wjid' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>文件名称：</td><td><input type='text' name='wjmc' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>转换结果：</td><td><input type='text' name='zhjg' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>转换时间：</td><td><input type='text' name='zhsj' class='viewbox' readonly='readonly'/></td></tr>
	</table>

</form>
</body>
</html>
