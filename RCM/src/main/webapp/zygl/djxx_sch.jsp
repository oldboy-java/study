<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<title>等级信息查询</title><!--djxx-->
	<%@include file="/common/include.jsp" %>

<script>
var winToggle;
$(function(){
	winToggle=new QWinToggle().regist(["djxxEditWin","djxxViewWin"]);
	var pager = $('#djxxGrid').datagrid().datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		buttons:[],
	});			
})

<%-- 执行查询，点击查询按钮时调用 --%>
function doDjxxSearch(){
	if(!$("#_form").form("validate")){
		return;
	}
	$('#djxxGrid').datagrid('load',{
		djmc:$('#djmc').val()
	});
}

<%-- 查询列表datagrid的"操作"列的内容渲染，若有其他操作请修改此方法 --%>
function formatDjxxOper(val,row,index){  
    return "&emsp;<a href='javascript:void(0)' onclick='updDjxx("+val+")' class='_oper' title='修改'>&nbsp;<i class='icon-edit'></i>&nbsp;</a>"
    			+"<a href='javascript:void(0)' onclick='vieDjxx("+val+")' class='_oper' title='查看'>&nbsp;<i class='icon-info-sign'></i>&nbsp;</a>&emsp;"; 
} 

<%-- 打开修改页面，点击记录行的"修改"链接时调用 --%>
function updDjxx(id){
	winToggle.open("djxxEditWin");
	$('#djxxEditWin').get(0).contentWindow.load(id);
} 

<%-- 打开查看页面，点击记录行的"查看"链接时调用 --%>
function vieDjxx(id){
	winToggle.open("djxxViewWin");
	$('#djxxViewWin').get(0).contentWindow.load(id);
}

<%-- 删除记录 --%>
function delDjxx(){
	var checkedItems = $('#djxxGrid').datagrid('getChecked');
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
			$.get("/${projectName}/zygl/djxx/delDjxx.action",{ids:ids},function(data){
				$('#djxxGrid').datagrid('reload');
			});
		}
	});
}

<%-- 刷新数据，当添加或修改了数据后调用。从upd页中调用。 --%>
function reloadData(){
	$('#djxxEditWin').dialog('close');
	$('#djxxGrid').datagrid('reload');
}
</script>
</head>
<body>
<table id="djxxGrid" title="" fitcolumns=true
	data-options="singleSelect:false,pagination:true,rownumbers:true,fit:true,striped:true,toolbar:'#djxxGridToolbar',collapsible:true,url:'/${projectName}/zygl/djxx/schDjxx.action',method:'get'">
	<thead>
		<tr>
			<th data-options="field:'checkbox',checkbox:true" ></th>
			<th data-options="field:'djmc',width:80,sortable:true">等级名称</th>
			<th data-options="field:'zxjf',sortable:true">最小积分数(分)</th>
			<th data-options="field:'zdjf',sortable:true">最大积分数(分)</th>

			<th data-options="field:'_oper',align:'center',formatter:formatDjxxOper">操作</th>
		</tr>
	</thead>
</table>
<%-- 查询条件设定栏 --%>
<div id="djxxGridToolbar">
	<div class="opline">
		<a href="javascript:updDjxx(0)" class="btn btn-success"><span class="icon-plus" style="font-size:16px"></span> <span style="font-size:14px">添加</span></a>&emsp;
		<a href="javascript:delDjxx()" class="btn btn-danger"><span class="icon-trash" style="font-size:16px"></span> <span style="font-size:14px">删除</span></a>
	</div>
	<form id="_form" class="shline">
	等级名称：<input name='djmc' id="djmc" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>

	<a href="javascript:void(0)" onclick="doDjxxSearch()" class="btn btn-info"><span class="icon-search" style="font-size:16px"></span> <span style="font-size:14px">查询</span></a>
	</form>
</div>


<%-- 修改or添加面板 --%>
<iframe id="djxxEditWin" src="/${projectName}/zygl/djxx/page.action?page=djxx_upd" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#djxxEditButton'" title="编辑等级信息" style="width:500px;height:280px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="djxxEditButton">
	<a href="javascript:void(0)" onclick="$('#djxxEditWin').get(0).contentWindow.submitForm()" class="easyui-linkbutton" iconCls="icon-ok">保 存</a>
	<a href="javascript:void(0)" onclick="$('#djxxEditWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >取 消</a>
</div>
<%-- 查看面板 --%>
<iframe id="djxxViewWin" src="/${projectName}/zygl/djxx/page.action?page=djxx_vie" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#djxxViewButton'" title="查看等级信息" style="width:500px;height:280px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="djxxViewButton">
	<a href="javascript:$('#djxxViewWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >关 闭</a>
</div>
</body>
</html>
