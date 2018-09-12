<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/dictionary.tld" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<title>查询</title><!--jlcx-->
	<%@include file="/common/include.jsp" %>

<script>
$(function(){
	var pager = $('#jlcxGrid').datagrid().datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		buttons:[],
	});			
})

<%-- 执行查询，点击查询按钮时调用 --%>
function doSearch(){
	if(!$("#_form").form("validate")){
		return;
	}
	$('#jlcxGrid').datagrid('load',{
		ssxkid:ssxkidDict.getValue()
	});
}

<%-- 查询列表datagrid的"操作"列的内容渲染，若有其他操作请修改此方法 --%>
function formatOper(val,row,index){  
    return "&emsp;<a href='javascript:void(0)' onclick='updJlcx("+val+")' class='_oper' title='修改'>&nbsp;<i class='icon-edit'></i>&nbsp;</a>"
    			+"<a href='javascript:void(0)' onclick='vieJlcx("+val+")' class='_oper' title='查看'>&nbsp;<i class='icon-info-sign'></i>&nbsp;</a>&emsp;"; 
} 

<%-- 打开修改页面，点击记录行的"修改"链接时调用 --%>
function updJlcx(id){
	QMoveDialog($("#jlcxEditWin"));
	$('#jlcxViewWin').dialog('close');
	$('#jlcxEditWin').dialog('open');
	$('#jlcxEditWin').get(0).contentWindow.load(id);
} 

<%-- 打开查看页面，点击记录行的"查看"链接时调用 --%>
function vieJlcx(id){
	QMoveDialog($("#jlcxViewWin"));
	$('#jlcxEditWin').dialog('close');
	$('#jlcxViewWin').dialog('open');
	$('#jlcxViewWin').get(0).contentWindow.load(id);
}

<%-- 删除记录 --%>
function delJlcx(){
	var checkedItems = $('#jlcxGrid').datagrid('getChecked');
	var ids = [];
	$.each(checkedItems, function(index, item){
		ids.push(item.id);
	});
	if(ids.length==0){
		$.messager.alert('敬告','请选择删除的记录？');
		return;
	}
	$.messager.confirm('敬告','删除选定记录？',function(r){
		if(r){
			$.get("/${projectName}/company/jlcx/delJlcx.action",{ids:ids},function(data){
				$('#jlcxGrid').datagrid('reload');
			});
		}
	});
}

<%-- 刷新数据，当添加或修改了数据后调用。从upd页中调用。 --%>
function reloadData(){
	$('#jlcxEditWin').dialog('close');
	$('#jlcxGrid').datagrid('reload');
}
</script>
</head>
<body>
<table id="jlcxGrid" title="" fitcolumns=true
	data-options="singleSelect:false,pagination:true,rownumbers:true,fit:true,striped:true,toolbar:'#jlcxGridToolbar',collapsible:true,url:'/${projectName}/zygl/zy/schZydxsl.action',method:'get'">
	<thead>
		<tr>
			<th data-options="field:'checkbox',checkbox:true" ></th>
			<th data-options="field:'ssxkid',width:80,sortable:true">资源类别</th>
			<th data-options="field:'amount',sortable:true">资源数量</th>
			<th data-options="field:'scale',sortable:true">资源大小</th>		
			


			<!-- <th data-options="field:'_oper',align:'center',formatter:formatOper">操作</th> -->
		</tr>
	</thead>
</table>
<%-- 查询条件设定栏 --%>
<div id="jlcxGridToolbar">
	<div style="padding:0 20px;">
		<!-- <a href="javascript:updJlcx(0)" class="btn btn-success"><span class="icon-plus" style="font-size:16px"></span> <span style="font-size:14px">添加</span></a>&emsp;
		<a href="javascript:delJlcx()" class="btn btn-danger"><span class="icon-trash" style="font-size:16px"></span> <span style="font-size:14px">删除</span></a> -->
	</div>
	<form id="_form" style="padding:0 20px 6px 20px;">
	资源类别：<dc:insertList name="ssxkid" dictId="ZD_XKLB" style="combo_normal" />
	
	<a href="javascript:void(0)" onclick="doSearch()" class="btn btn-info"><span class="icon-search" style="font-size:16px"></span> <span style="font-size:14px">查询</span></a>
	</form>
</div>


<%-- 修改or添加面板 --%>
<iframe id="zyEditWin" src="/${projectName}/zygl/zy/page.action?page=zy_upd" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#zyEditButton'" title="编辑资源表" style="width:500px;height:500px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="zyEditButton">
	<a href="javascript:void(0)" onclick="$('#zyEditWin').get(0).contentWindow.submitForm()" class="easyui-linkbutton" iconCls="icon-ok">保 存</a>
	<a href="javascript:void(0)" onclick="$('#zyEditWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >取 消</a>
</div>
<%-- 查看面板 --%>
<iframe id="zyViewWin" src="/${projectName}/zygl/zy/page.action?page=zy_vie" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#zyViewButton'" title="查看资源表" style="width:500px;height:500px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="zyViewButton">
	<a href="javascript:$('#zyViewWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >关 闭</a>
</div>
</body>
</html>
