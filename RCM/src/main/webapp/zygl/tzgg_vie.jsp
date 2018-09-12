<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>查看通知公告表</title><!--tzgg-->
	<%@include file="/common/include.jsp" %>
<script>
function load(id){
	$('#_form').form('load','/${projectName}/zygl/tzgg/vieTzgg.action?toL=true&id='+id);
};
</script>
</head>
<body>
<form id="_form">
	<input type="hidden" name='id' value=""/>
	<table>
		<tr><td class='label'>通知标题：</td><td><input type='text' name='tzbt' class='viewbox' readonly='readonly'/></td></tr>
		<tr><td class='label'>通知内容：</td><td><textarea  name='tznr' style="vertical-align: middle;width: 300px; height: 100px;resize: none; margin-top: 4px; " readonly='readonly'></textarea></td></tr>
		<tr><td class='label'>创建时间：</td><td><input type='text' name='cjsj' class='viewbox' readonly='readonly'/></td></tr>
		<!-- <tr><td class='label'>学校ID：</td><td><input type='text' name='xxid' class='viewbox' readonly='readonly'/></td></tr> -->
	</table>

</form>
</body>
</html>
