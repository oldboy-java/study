<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>编辑文件转换表</title><!--wjzh-->
	<%@include file="/common/include.jsp" %>
<script>
<%-- 查询页点击修改时调用此方法加载记录详情 --%>
function load(id){
	$('#_form').form('load','/${projectName}/zygl/wjzh/vieWjzh.action?id='+id);
};

<%-- 点击保存按钮时调用此方法。(注:保存按钮在查询列表页) --%>
function submitForm(){
	if(!$("#_form").form("validate")){
		return;
	}
	$('#_form').form('submit',{
      success:function(data) {
      	parent.reloadData();
      }
   });
}
</script>
</head>
<body>
<form id="_form" method="post" action="/${projectName}/zygl/wjzh/updWjzh.action">
	<input type="hidden" name='id' id='id'/>
	<table>
		<tr><td class='label' style="width:120px">文件Id：</td><td><input id="wjid" name="wjid" class="easyui-textbox" data-options="required:true"/></td></tr>
		<tr><td class='label' >文件名称：</td><td><input id="wjmc" name="wjmc" class="easyui-textbox" data-options="required:true"/></td></tr>
		<tr><td class='label' >转换结果：</td><td><input id="zhjg" name="zhjg" class="easyui-textbox" data-options="required:true"/></td></tr>
		<tr><td class='label' >转换时间：</td><td><input id="zhsjstr" name="zhsjstr" class="easyui-datebox" data-options="required:true"/></td></tr>
	</table>

</form>
</body>
</html>
