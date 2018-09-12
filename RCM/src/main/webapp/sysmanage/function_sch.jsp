<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/dictionary.tld" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<title>功能查询</title>
	<%@include file="/common/include.jsp" %>
</head>
<body class="easyui-layout">
	<div region="west" split="true" title="功能结构" style="width:260px;">
		<dc:includeTree dictId="SYS_FUNCS_ALL" name="funcstree" style="synch_single" bind="select:openFunc"/>
	</div>
	<div id="content" region="center" style="border:0;">
		<table id="functionGrid" title="功能" class="easyui-datagrid" fitcolumns=true
			data-options="singleSelect:false,pagination:true,rownumbers:true,fit:true,striped:true,toolbar:'#functionGridToolbar',collapsible:true,url:'/${projectName}/sysmanage/function/schFunction.action',method:'get'">
			<thead>
				<tr>
					<th data-options="field:'checkbox',checkbox:true" ></th>
					<th data-options="field:'name',width:80,sortable:true">姓名</th>
					<th data-options="field:'link',sortable:true">链接</th>
					<th data-options="field:'info',sortable:true">说明</th>
		
					<th data-options="field:'_oper',align:'center',formatter:formatOper">操作</th>
				</tr>
			</thead>
		</table>
		<div id="functionGridToolbar">
			姓名：<input type="text" name="name" id="name" style="width:80px;"/>
			链接：<input type="text" name="link" id="link" style="width:80px;"/>
		
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">查询</a>
		</div>
	</div>

<script>
$(function(){
	var pager = $('#functionGrid').datagrid().datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		buttons:[{
			iconCls:'icon-add',
			text:'添加',
			handler:function(){
				updFunction(0);
			}
		},{
			iconCls:'icon-remove',
			text:'删除',
			handler:function(){
				var checkedItems = $('#functionGrid').datagrid('getChecked');
				var ids = [];
				$.each(checkedItems, function(index, item){
					ids.push(item.id);
				});
				$.messager.confirm('敬告','删除选定记录？',function(r){
					if(r){
						$.get("./function/delFunction.action",{ids:ids},function(data){
							$('#functionGrid').datagrid('reload');
						});
					}
				});
			}
		}],
	});			
})
function doSearch(){
	$('#functionGrid').datagrid('load',{
		name: $('#name').val(),
		email: $('#email').val()
	});
}

function formatOper(val,row,index){  
    return "<a href='javascript:updFunction("+val+")'>修改</a>";  
} 

function updFunction(id){
	$('#functionEditWin').dialog('open');
	$('#functionEditWin').get(0).contentWindow.load(id);
} 
function reloadData(){
	$('#functionEditWin').dialog('close');
	$('#functionGrid').datagrid('reload');
}
</script>
<iframe id="functionEditWin" src="/${projectName}/sysmanage/function_upd.jsp" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#functionEditButton'" title="修改功能" closed="true" style="width:500px;height:500px;padding:5px;" scrolling="no" frameborder="0"></iframe>
<div id="functionEditButton">
	<a href="javascript:$('#functionEditWin').get(0).contentWindow.submitForm()" class="easyui-linkbutton" iconCls="icon-ok">保 存</a>
	<a href="javascript:$('#functionEditWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-cancel" >取 消</a>
</div>
</body>
</html>
