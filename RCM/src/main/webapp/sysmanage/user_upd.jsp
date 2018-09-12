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
$(function(){
	$('#_form').form({
		onLoadSuccess:function(){
			roleListDict.select($('#roles').val());
		}
	});
});
function load(id,organid){
	if(organid==undefined)organid="";
	$('#_form').form('load','/${projectName}/sysmanage/user/vieUser.action?id='+id+'&organid='+organid);
};

function submitForm(){
	if(!$("#_form").form("validate")){
		return;
	}
	$('#roles').val(roleListDict.getValue());
	$('#_form').form('submit',{
      success:function(data) {
      	parent.reloadData();
      }
   });
}
</script>
</head>
<body>
<form id="_form" method="post" action="/${projectName}/sysmanage/user/updUser.action">
	<input type="hidden" name="from" value="submit"/>
	<input type="hidden" name='id' value=""/>
	<input type="hidden" name='state' value=""/>
	<!-- <input type="hidden" name='organid' value=""/> -->
	<input type="hidden" name='classify' value=""/>
	<input type="hidden" name='modulename' value=""/>
	<input type="hidden" name="roles" id="roles"/>
	<table>
		<tr><td class='label'>姓名：</td><td><input type='text' name='username' id='username' class='easyui-textbox' data-options='required:true' value=''/></td></tr>
		<tr><td class='label'>登录名：</td><td><input type='text' name='loginname' id='loginname' class='easyui-textbox' data-options="required:true" value=''/></td></tr>
		<tr><td class='label'>密码：</td><td><input type='text' name='password' id='password' class='easyui-textbox' data-options='required:true' value=''/></td></tr>
<!-- 		<tr><td class='label'>生日：</td><td><input type='text' name='birthdaystr' id='birthdaystr' class='easyui-datebox' value=''/></td></tr> -->
		<tr><td class='label'>角色：</td><td>
			<dc:includeList name="roleList" dictId="SYS_ROLE" style="bill_checkbox"/>
		</td></tr>
	</table>

</form>
</body>
</html>
