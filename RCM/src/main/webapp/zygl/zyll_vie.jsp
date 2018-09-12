<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>查看资源浏览表</title><!--zyll-->
	<%@include file="/common/include.jsp" %>
<script>
function load(id){
	$('#_form').form('load','/${projectName}/zygl/zyll/vieZyll.action?toL=true&id='+id);
};
</script>
</head>
<body>
<form id="_form">
	<input type="hidden" name='id' value=""/>
	<table>
		<tr><td class='label'>资源：</td><td><input type='text' name='zyid' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>浏览人：</td><td><input type='text' name='llrid' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>浏览时间：</td><td><input type='text' name='llsj' class='viewbox' readonly='readonly'/></td></tr>
		<!-- <tr><td class='label'>学校ID：</td><td><input type='text' name='xxid' class='viewbox' readonly='readonly'/></td></tr> -->
	</table>

</form>
</body>
</html>
