<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>查看等级信息</title><!--djxx-->
	<%@include file="/common/include.jsp" %>
<script>
function load(id){
	$('#_form').form('load','/${projectName}/zygl/djxx/vieDjxx.action?toL=true&id='+id);
};
</script>
</head>
<body>
<form id="_form">
	<input type="hidden" name='id' value=""/>
	<table>
		<tr><td class='label'>等级名称：</td><td><input type='text' name='djmc' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>最小积分数(分)：</td><td><input type='text' name='zxjf' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>最大积分数(分)：</td><td><input type='text' name='zdjf' class='viewbox' readonly='readonly'/></td></tr>
	</table>

</form>
</body>
</html>
