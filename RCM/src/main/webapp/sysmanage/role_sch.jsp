<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>角色查询</title>
	<%@include file="/common/include.jsp" %>
</head>
<body>
<table id="roleGrid" title="角色" class="easyui-datagrid" fitcolumns=true
	data-options="singleSelect:false,pagination:true,rownumbers:true,fit:true,striped:true,toolbar:'#roleGridToolbar',collapsible:true,url:'/${projectName}/sysmanage/role/schRole.action',method:'get'">
	<thead>
		<tr>
			<th data-options="field:'checkbox',checkbox:true" ></th>
			<th data-options="field:'name',width:80,sortable:true">角色名称</th>
			<th data-options="field:'info',sortable:true">说明</th>
			<th data-options="field:'_oper',align:'center',formatter:formatOper">操作</th>
		</tr>
	</thead>
</table>
<div id="roleGridToolbar">
	角色名称：<input class="easyui-textbox" name="name" id="name" style="width:160px;" data-options="
							iconWidth:16,
							icons: [{iconCls:'icon-clear',
								handler: function(e){$(e.data.target).textbox('setValue', '');}
							},{iconCls:'icon-search',
								handler: function(e){
									doSearch();
								}
						}]"/>
</div>


<script>
$(function(){
	var pager = $('#roleGrid').datagrid().datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		buttons:[{
			iconCls:'icon-add',
			text:'添加',
			handler:function(){
				updRole(0);
			}
		},{
			iconCls:'icon-remove',
			text:'删除',
			handler:function(){
				var checkedItems = $('#roleGrid').datagrid('getChecked');
				var ids = [];
				$.each(checkedItems, function(index, item){
					ids.push(item.id);
				});
				$.messager.confirm('敬告','删除选定记录？',function(r){
					if(r){
						$.get("/${projectName}/sysmanage/role/delRole.action",{ids:ids},function(data){
							$('#roleGrid').datagrid('reload');
						});
					}
				});
			}
		}],
	});			
})
function doSearch(){
	$('#roleGrid').datagrid('load',{
		name: $('#name').val(),
		email: $('#email').val()
	});
}
function formatOper(val,row,index){  
    return "<span onclick='updRole("+val+")' style='text-decoration:underline;cursor:pointer;'>修改</span>";  
} 

function updRole(id){
	$('#roleEditWin').dialog('open');
	$('#roleEditWin').get(0).contentWindow.load(id);
} 
function reloadData(){
	$('#roleEditWin').dialog('close');
	$('#roleGrid').datagrid('reload');
}
</script>
<iframe id="roleEditWin" src="/${projectName}/sysmanage/role_upd.jsp" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#roleEditButton'" title="修改角色" closed="true" style="width:500px;height:500px;padding:5px;" scrolling="no" frameborder="0"></iframe>
<div id="roleEditButton">
	<a href="javascript:$('#roleEditWin').get(0).contentWindow.submitForm()" class="easyui-linkbutton" iconCls="icon-ok">保 存</a>
	<a href="javascript:$('#roleEditWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-cancel" >取 消</a>
</div>
</body>
</html>
