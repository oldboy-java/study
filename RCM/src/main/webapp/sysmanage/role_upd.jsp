<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/dictionary.tld" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改角色</title>
	<%@include file="/common/include.jsp" %>
<script>
$(function(){
	$('#_form').form({
		onLoadSuccess:function(){
			funcsTreeDict.select($('#funcs').val());
		}
	});
});
function load(id){
	$('#_form').form('load','./role/updRole.action?id='+id);
};
function submitForm(){
	$('#funcs').val(funcsTreeDict.getValue());
	$('#_form').form('submit',{
      success:function(data) {
      	parent.reloadData();
      }
   });
}
</script>
</head>
<body>
<form id="_form" method="post" action="./role/updRole.action">
	<input type="hidden" name="from" value="submit"/>
	<input type="hidden" name='id' value=""/>
	<input type="hidden" name='ord' value=""/>
	<input type="hidden" name='classify' value=""/>
	<input type="hidden" name='organid' value=""/>
	<input type="hidden" name='modulename' value=""/>
	<input type="hidden" name='islocal' value=""/>
	<input type="hidden" name='funcs' id="funcs" value=""/>
	<table style='width:100%' class="view">
		<tr><td class='label'>角色名称：</td><td><input name='name' class='easyui-textbox' data-options='required:true' value=''/></td></tr>
		<tr><td class='label'>说明：</td><td><input name='info' class='easyui-textbox' data-options='multiline:true' style='width:100%;height:50px;' value=''/></td></tr>
		<tr><td class='label'>功能：</td><td>
			<div class='easyui-panel' style='padding:5px;overflow-y:scroll;height:320px;width:100%;'>
			<dc:includeTree name="funcsTree" dictId="SYS_FUNCS_MENU" style="synch_multi"/>
			</div>
		</td></tr>
	</table>

</form>
</body>
</html>
