<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<title>资源浏览表查询</title><!--zyll-->
	<%@include file="/common/include.jsp" %>

<script>
var winToggle;
$(function(){
	winToggle=new QWinToggle().regist(["zyllEditWin","zyllViewWin"]);
	var pager = $('#zyllGrid').datagrid().datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		buttons:[],
	});			
})

<%-- 执行查询，点击查询按钮时调用 --%>
function doZyllSearch(){
	if(!$("#_form").form("validate")){
		return;
	}
	$('#zyllGrid').datagrid('load',{
		zyid:zyidDict.getValue(),
		llrid:$('#llrid').val(),
		llsjBeg:$('#llsjBeg').datetimebox("getValue"), 
		llsjEnd:$('#llsjEnd').datetimebox("getValue")/* ,
		xxid:$('#xxid').val() */
	});
}

<%-- 查询列表datagrid的"操作"列的内容渲染，若有其他操作请修改此方法 --%>
function formatZyllOper(val,row,index){  
    return "&emsp;<a href='javascript:void(0)' onclick='updZyll("+val+")' class='_oper' title='修改'>&nbsp;<i class='icon-edit'></i>&nbsp;</a>"
    			+"<a href='javascript:void(0)' onclick='vieZyll("+val+")' class='_oper' title='查看'>&nbsp;<i class='icon-info-sign'></i>&nbsp;</a>&emsp;"; 
} 

<%-- 打开修改页面，点击记录行的"修改"链接时调用 --%>
function updZyll(id){
	winToggle.open("zyllEditWin");
	$('#zyllEditWin').get(0).contentWindow.load(id);
} 

<%-- 打开查看页面，点击记录行的"查看"链接时调用 --%>
function vieZyll(id){
	winToggle.open("zyllViewWin");
	$('#zyllViewWin').get(0).contentWindow.load(id);
}

<%-- 删除记录 --%>
function delZyll(){
	var checkedItems = $('#zyllGrid').datagrid('getChecked');
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
			$.get("/${projectName}/zygl/zyll/delZyll.action",{ids:ids},function(data){
				$('#zyllGrid').datagrid('reload');
			});
		}
	});
}

<%-- 刷新数据，当添加或修改了数据后调用。从upd页中调用。 --%>
function reloadData(){
	$('#zyllEditWin').dialog('close');
	$('#zyllGrid').datagrid('reload');
}
</script>
</head>
<body>
<table id="zyllGrid" title="" fitcolumns=true
	data-options="singleSelect:false,pagination:true,rownumbers:true,fit:true,striped:true,toolbar:'#zyllGridToolbar',collapsible:true,url:'/${projectName}/zygl/zyll/schZyll.action',method:'get'">
	<thead>
		<tr>
			<th data-options="field:'checkbox',checkbox:true" ></th>
			<th data-options="field:'zyid',width:80,sortable:true">资源</th>
			<th data-options="field:'llrid',sortable:true">浏览人</th>
			<th data-options="field:'llsj',sortable:true">浏览时间</th>
			<!-- <th data-options="field:'xxid',sortable:true">学校ID</th> -->

			<th data-options="field:'_oper',align:'center',formatter:formatZyllOper">操作</th>
		</tr>
	</thead>
</table>
<%-- 查询条件设定栏 --%>
<div id="zyllGridToolbar">
	<div class="opline">
		<a href="javascript:updZyll(0)" class="btn btn-success"><span class="icon-plus" style="font-size:16px"></span> <span style="font-size:14px">添加</span></a>&emsp;
		<a href="javascript:delZyll()" class="btn btn-danger"><span class="icon-trash" style="font-size:16px"></span> <span style="font-size:14px">删除</span></a>
	</div>
	<form id="_form" class="shline">
	资源：<dc:insertList name="zyid" dictId="ZD_ZYMC" style="combo_normal" />
	浏览人：<input name='llrid' id="llrid" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>

浏览时间：<input name="llsjBeg" id="llsjBeg" class="easyui-datetimebox" style="width:100px;" data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
&gt;&gt;
	<input name="llsjEnd" id="llsjEnd" class="easyui-datetimebox" style="width:100px;" data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}}],
validType:['compareDate[llsjBeg]']"/>
	<!-- 学校ID：<input name='xxid' id="xxid" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/> -->

	<a href="javascript:void(0)" onclick="doZyllSearch()" class="btn btn-info"><span class="icon-search" style="font-size:16px"></span> <span style="font-size:14px">查询</span></a>
	</form>
</div>


<%-- 修改or添加面板 --%>
<iframe id="zyllEditWin" src="/${projectName}/zygl/zyll/page.action?page=zyll_upd" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#zyllEditButton'" title="编辑资源浏览表" style="width:500px;height:500px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="zyllEditButton">
	<a href="javascript:void(0)" onclick="$('#zyllEditWin').get(0).contentWindow.submitForm()" class="easyui-linkbutton" iconCls="icon-ok">保 存</a>
	<a href="javascript:void(0)" onclick="$('#zyllEditWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >取 消</a>
</div>
<%-- 查看面板 --%>
<iframe id="zyllViewWin" src="/${projectName}/zygl/zyll/page.action?page=zyll_vie" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#zyllViewButton'" title="查看资源浏览表" style="width:500px;height:500px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="zyllViewButton">
	<a href="javascript:$('#zyllViewWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >关 闭</a>
</div>
</body>
</html>
