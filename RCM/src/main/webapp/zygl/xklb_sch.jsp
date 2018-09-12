<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<title>资源类型表查询</title><!--xklb-->
	<%@include file="/common/include.jsp" %>

<script>
var winToggle;
$(function(){
	winToggle=new QWinToggle().regist(["xklbEditWin","xklbViewWin"]);
	var pager = $('#xklbGrid').datagrid().datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		buttons:[],
	});			
})

<%-- 执行查询，点击查询按钮时调用 --%>
function doXklbSearch(){
	if(!$("#_form").form("validate")){
		return;
	}
	$('#xklbGrid').datagrid('load',{
		xkmc:$('#xkmc').val()/* ,
		xxid:$('#xxid').val() */
	});
}

<%-- 查询列表datagrid的"操作"列的内容渲染，若有其他操作请修改此方法 --%>
function formatXklbOper(val,row,index){  
    return "&emsp;<a href='javascript:void(0)' onclick='updXklb("+val+")' class='_oper' title='修改'>&nbsp;<i class='icon-edit'></i>&nbsp;</a>"
    			+"<a href='javascript:void(0)' onclick='vieXklb("+val+")' class='_oper' title='查看'>&nbsp;<i class='icon-info-sign'></i>&nbsp;</a>&emsp;"; 
} 

<%-- 打开修改页面，点击记录行的"修改"链接时调用 --%>
function updXklb(id){
	winToggle.open("xklbEditWin");
	$('#xklbEditWin').get(0).contentWindow.load(id);
} 

<%-- 打开查看页面，点击记录行的"查看"链接时调用 --%>
function vieXklb(id){
	winToggle.open("xklbViewWin");
	$('#xklbViewWin').get(0).contentWindow.load(id);
}

<%-- 删除记录 --%>
function delXklb(){
	var checkedItems = $('#xklbGrid').datagrid('getChecked');
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
			$.get("/${projectName}/zygl/xklb/delXklb.action",{ids:ids},function(data){
				$('#xklbGrid').datagrid('reload');
			});
		}
	});
}

<%-- 刷新数据，当添加或修改了数据后调用。从upd页中调用。 --%>
function reloadData(){
	$('#xklbEditWin').dialog('close');
	$('#xklbGrid').datagrid('reload');
}
</script>
</head>
<body>
<table id="xklbGrid" title="" fitcolumns=true
	data-options="singleSelect:false,pagination:true,rownumbers:true,fit:true,striped:true,toolbar:'#xklbGridToolbar',collapsible:true,url:'/${projectName}/zygl/xklb/schXklb.action',method:'get'">
	<thead>
		<tr>
			<th data-options="field:'checkbox',checkbox:true" ></th>
			<th data-options="field:'xkmc',width:80,sortable:true"> 资源类型名称</th>
			<!-- <th data-options="field:'xxid',sortable:true">学校ID</th> -->

			<th data-options="field:'_oper',align:'center',formatter:formatXklbOper">操作</th>
		</tr>
	</thead>
</table>
<%-- 查询条件设定栏 --%>
<div id="xklbGridToolbar">
	<div class="opline">
		<a href="javascript:updXklb(0)" class="btn btn-success"><span class="icon-plus" style="font-size:16px"></span> <span style="font-size:14px">添加</span></a>&emsp;
		<a href="javascript:delXklb()" class="btn btn-danger"><span class="icon-trash" style="font-size:16px"></span> <span style="font-size:14px">删除</span></a>
	</div>
	<form id="_form" class="shline">
	 资源类型名称：<input name='xkmc' id="xkmc" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
	<!-- 学校ID：<input name='xxid' id="xxid" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/> -->

	<a href="javascript:void(0)" onclick="doXklbSearch()" class="btn btn-info"><span class="icon-search" style="font-size:16px"></span> <span style="font-size:14px">查询</span></a>
	</form>
</div>


<%-- 修改or添加面板 --%>
<iframe id="xklbEditWin" src="/${projectName}/zygl/xklb/page.action?page=xklb_upd" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#xklbEditButton'" title="编辑资源类型" style="width:500px;height:200px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="xklbEditButton">
	<a href="javascript:void(0)" onclick="$('#xklbEditWin').get(0).contentWindow.submitForm()" class="easyui-linkbutton" iconCls="icon-ok">保 存</a>
	<a href="javascript:void(0)" onclick="$('#xklbEditWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >取 消</a>
</div>
<%-- 查看面板 --%>
<iframe id="xklbViewWin" src="/${projectName}/zygl/xklb/page.action?page=xklb_vie" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#xklbViewButton'" title="查看资源类型" style="width:500px;height:200px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="xklbViewButton">
	<a href="javascript:$('#xklbViewWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >关 闭</a>
</div>
</body>
</html>
