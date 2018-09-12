<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/dictionary.tld" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改用户表</title>
	<%@include file="/common/include.jsp" %>
<script>
function load(id){
	$('#_form').form('load','/${projectName}/sysmanage/user/vieUser.action?toL=true&id='+id);
};
</script>
<style>
.viewbox{border:0;}
</style>
</head>
<body>
<form id="_form">
	<input type="hidden" name="from" value="submit"/>
	<input type="hidden" name='id' value=""/>
	<input type="hidden" name='state' value=""/>
	<input type="hidden" name='organid' value=""/>
	<input type="hidden" name='classify' value=""/>
	<input type="hidden" name='modulename' value=""/>
	<input type="hidden" name="roles" id="roles"/>
	<table>
		<tr><td class='label'>姓名：</td><td><input type='text' name='username' id='username' class='viewbox' readonly="readonly"/></td></tr>
		<tr><td class='label'>登录名：</td><td><input type='text' name='loginname' id='loginname' class='viewbox' readonly="readonly"/></td></tr>
		<tr><td class='label'>密码：</td><td><input type='text' name='password' id='password' class='viewbox' readonly="readonly"/></td></tr>
		<!-- <tr><td class='label'>生日：</td><td><input type='text' name='birthdaystr' id='birthdaystr' class='viewbox' readonly="readonly"/></td></tr> -->
		<tr><td class='label'>角色：</td><td><input type='text' name='roles' id='roles' class='viewbox' readonly="readonly"/></td></tr>
	</table>

</form>
</body>
</html>
