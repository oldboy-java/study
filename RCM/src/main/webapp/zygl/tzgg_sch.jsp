<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<title>通知公告表查询</title><!--tzgg-->
	<%@include file="/common/include.jsp" %>

<script>
var winToggle;
$(function(){
	winToggle=new QWinToggle().regist(["tzggEditWin","tzggViewWin"]);
	var pager = $('#tzggGrid').datagrid().datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		buttons:[],
	});			
})

<%-- 执行查询，点击查询按钮时调用 --%>
function doTzggSearch(){
	if(!$("#_form").form("validate")){
		return;
	}
	$('#tzggGrid').datagrid('load',{
		tzbt:$('#tzbt').val(),
		tznr:$('#tznr').val(),
		cjsjBeg:$('#cjsjBeg').datetimebox("getValue"), 
		cjsjEnd:$('#cjsjEnd').datetimebox("getValue")/* ,
		xxid:$('#xxid').val() */
	});
}

<%-- 查询列表datagrid的"操作"列的内容渲染，若有其他操作请修改此方法 --%>
function formatTzggOper(val,row,index){  
    return "&emsp;<a href='javascript:void(0)' onclick='updTzgg("+val+")' class='_oper' title='修改'>&nbsp;<i class='icon-edit'></i>&nbsp;</a>"
    			+"<a href='javascript:void(0)' onclick='vieTzgg("+val+")' class='_oper' title='查看'>&nbsp;<i class='icon-info-sign'></i>&nbsp;</a>&emsp;"; 
} 

<%-- 打开修改页面，点击记录行的"修改"链接时调用 --%>
function updTzgg(id){
	winToggle.open("tzggEditWin");
	$('#tzggEditWin').get(0).contentWindow.load(id);
} 

<%-- 打开查看页面，点击记录行的"查看"链接时调用 --%>
function vieTzgg(id){
	winToggle.open("tzggViewWin");
	$('#tzggViewWin').get(0).contentWindow.load(id);
}

<%-- 删除记录 --%>
function delTzgg(){
	var checkedItems = $('#tzggGrid').datagrid('getChecked');
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
			$.get("/${projectName}/zygl/tzgg/delTzgg.action",{ids:ids},function(data){
				$('#tzggGrid').datagrid('reload');
			});
		}
	});
}

<%-- 刷新数据，当添加或修改了数据后调用。从upd页中调用。 --%>
function reloadData(){
	$('#tzggEditWin').dialog('close');
	$('#tzggGrid').datagrid('reload');
}
</script>
</head>
<body>
<table id="tzggGrid" title="" fitcolumns=true
	data-options="singleSelect:false,pagination:true,rownumbers:true,fit:true,striped:true,toolbar:'#tzggGridToolbar',collapsible:true,url:'/${projectName}/zygl/tzgg/schTzgg.action',method:'get'">
	<thead>
		<tr>
			<th data-options="field:'checkbox',checkbox:true" ></th>
			<th data-options="field:'tzbt',width:80,sortable:true">通知标题</th>
			<th data-options="field:'tznr',sortable:true">通知内容</th>
			<th data-options="field:'cjsj',sortable:true">创建时间</th>
			<!-- <th data-options="field:'xxid',sortable:true">学校ID</th> -->

			<th data-options="field:'_oper',align:'center',formatter:formatTzggOper">操作</th>
		</tr>
	</thead>
</table>
<%-- 查询条件设定栏 --%>
<div id="tzggGridToolbar">
	<div class="opline">
		<a href="javascript:updTzgg(0)" class="btn btn-success"><span class="icon-plus" style="font-size:16px"></span> <span style="font-size:14px">添加</span></a>&emsp;
		<a href="javascript:delTzgg()" class="btn btn-danger"><span class="icon-trash" style="font-size:16px"></span> <span style="font-size:14px">删除</span></a>
	</div>
	<form id="_form" class="shline">
	通知标题：<input name='tzbt' id="tzbt" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
	通知内容：<input name='tznr' id="tznr" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>

创建时间：<input name="cjsjBeg" id="cjsjBeg" class="easyui-datetimebox" style="width:100px;" data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
&gt;&gt;
	<input name="cjsjEnd" id="cjsjEnd" class="easyui-datetimebox" style="width:100px;" data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}}],
validType:['compareDate[cjsjBeg]']"/>
	<!-- 学校ID：<input name='xxid' id="xxid" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/> -->

	<a href="javascript:void(0)" onclick="doTzggSearch()" class="btn btn-info"><span class="icon-search" style="font-size:16px"></span> <span style="font-size:14px">查询</span></a>
	</form>
</div>


<%-- 修改or添加面板 --%>
<iframe id="tzggEditWin" src="/${projectName}/zygl/tzgg/page.action?page=tzgg_upd" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#tzggEditButton'" title="编辑通知公告表" style="width:500px;height:500px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="tzggEditButton">
	<a href="javascript:void(0)" onclick="$('#tzggEditWin').get(0).contentWindow.submitForm()" class="easyui-linkbutton" iconCls="icon-ok">保 存</a>
	<a href="javascript:void(0)" onclick="$('#tzggEditWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >取 消</a>
</div>
<%-- 查看面板 --%>
<iframe id="tzggViewWin" src="/${projectName}/zygl/tzgg/page.action?page=tzgg_vie" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#tzggViewButton'" title="查看通知公告表" style="width:500px;height:500px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="tzggViewButton">
	<a href="javascript:$('#tzggViewWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >关 闭</a>
</div>
</body>
</html>
