<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Basic Panel - jQuery EasyUI Demo</title>
	<%@include file="/common/include.jsp" %>
	<script>
	function addTab(title, url){
		if ($('#tabdiv').tabs('exists', title)){
			$('#tabdiv').tabs('select', title);
		} else {
			var content = '<iframe scrolling="no" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
			$('#tabdiv').tabs('add',{
				title:title,
				content:content,
				closable:true
			});
		}
	}
	</script>
	<style>
	.panel-body{overflow:hidden}
	.easyui-accordion a.qtrmenu{background:#fafafa;border-bottom:#eee 1px dashed;border-top:#eee 1px dashed;line-height:30px;height:30px;width:100%;display:block;padding-left:30px;color:black;text-decoration:none;}
	.easyui-accordion a.qtrmenu:hover{background:#c1dfff;}
	</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'west',split:true" style="width:200px;padding:0px;">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div title="系统管理"  data-options="selected:true"  style="padding:0;">
			
				<a class="qtrmenu" href="javascript:addTab('测试用户表','/${projectName}/sysmanage/user/page.action?page=user_sch')">测试用户表</a>
				<a class="qtrmenu" href="javascript:addTab('测试机构','/${projectName}/sysmanage/organ/page.action?page=organ_sch')">测试机构</a>
				<a class="qtrmenu" href="javascript:addTab('测试角色','/${projectName}/sysmanage/role/page.action?page=role_sch')">测试角色</a>
				<a class="qtrmenu" href="javascript:addTab('测试功能单元','/${projectName}/sysmanage/functionunit/page.action?page=functionunit_sch')">测试功能单元</a>
				<a class="qtrmenu" href="javascript:addTab('测试功能','/${projectName}/sysmanage/function/page.action?page=function_upd')">测试功能</a>
				<a class="qtrmenu" href="javascript:addTab('测试功能2','/${projectName}/sysmanage/function/page.action?page=functi')">测试功能2</a>
			</div>
		</div>
	</div>
	<div data-options="region:'center'">
		<div id="tabdiv" class="easyui-tabs" data-options="fit:true,border:false,plain:true" fit="true">
		</div>
	</div>
</body>
</html>
