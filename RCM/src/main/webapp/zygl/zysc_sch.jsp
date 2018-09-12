<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<title>资源收藏表查询</title><!--zysc-->
	<%@include file="/common/include.jsp" %>

<script>
var winToggle;
$(function(){
	winToggle=new QWinToggle().regist(["zyscEditWin","zyscViewWin"]);
	var pager = $('#zyscGrid').datagrid().datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		buttons:[],
	});			
})

<%-- 执行查询，点击查询按钮时调用 --%>
function doZyscSearch(){
	if(!$("#_form").form("validate")){
		return;
	}
	$('#zyscGrid').datagrid('load',{
		zyid:zyidDict.getValue(),
		scrid:scridDict.getValue(),
		scsjBeg:$('#scsjBeg').datetimebox("getValue"), 
		scsjEnd:$('#scsjEnd').datetimebox("getValue")/* ,
		xxid:$('#xxid').val() */
	});
}

<%-- 查询列表datagrid的"操作"列的内容渲染，若有其他操作请修改此方法 --%>
function formatZyscOper(val,row,index){  
    return "&emsp;<a href='javascript:void(0)' onclick='updZysc("+val+")' class='_oper' title='修改'>&nbsp;<i class='icon-edit'></i>&nbsp;</a>"
    			+"<a href='javascript:void(0)' onclick='vieZysc("+val+")' class='_oper' title='查看'>&nbsp;<i class='icon-info-sign'></i>&nbsp;</a>&emsp;"; 
} 

<%-- 打开修改页面，点击记录行的"修改"链接时调用 --%>
function updZysc(id){
	winToggle.open("zyscEditWin");
	$('#zyscEditWin').get(0).contentWindow.load(id);
} 

<%-- 打开查看页面，点击记录行的"查看"链接时调用 --%>
function vieZysc(id){
	winToggle.open("zyscViewWin");
	$('#zyscViewWin').get(0).contentWindow.load(id);
}

<%-- 删除记录 --%>
function delZysc(){
	var checkedItems = $('#zyscGrid').datagrid('getChecked');
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
			$.get("/${projectName}/zygl/zysc/delZysc.action",{ids:ids},function(data){
				$('#zyscGrid').datagrid('reload');
			});
		}
	});
}

<%-- 刷新数据，当添加或修改了数据后调用。从upd页中调用。 --%>
function reloadData(){
	$('#zyscEditWin').dialog('close');
	$('#zyscGrid').datagrid('reload');
}
</script>
</head>
<body>
<table id="zyscGrid" title="" fitcolumns=true
	data-options="singleSelect:false,pagination:true,rownumbers:true,fit:true,striped:true,toolbar:'#zyscGridToolbar',collapsible:true,url:'/${projectName}/zygl/zysc/schZysc.action',method:'get'">
	<thead>
		<tr>
			<th data-options="field:'checkbox',checkbox:true" ></th>
			<th data-options="field:'zyid',width:80,sortable:true">资源</th>
			<th data-options="field:'scrid',sortable:true">收藏人</th>
			<th data-options="field:'scsj',sortable:true">收藏时间</th>
			<!-- <th data-options="field:'xxid',sortable:true">学校ID</th> -->

			<th data-options="field:'_oper',align:'center',formatter:formatZyscOper">操作</th>
		</tr>
	</thead>
</table>
<%-- 查询条件设定栏 --%>
<div id="zyscGridToolbar">
	<div class="opline">
		<a href="javascript:updZysc(0)" class="btn btn-success"><span class="icon-plus" style="font-size:16px"></span> <span style="font-size:14px">添加</span></a>&emsp;
		<a href="javascript:delZysc()" class="btn btn-danger"><span class="icon-trash" style="font-size:16px"></span> <span style="font-size:14px">删除</span></a>
	</div>
	<form id="_form" class="shline">
	资源：<dc:insertList name="zyid" dictId="ZD_ZYMC" style="combo_normal" />
	收藏人：<dc:insertList cssWidth="157px" name="scrid" dictId="ZD_USERNAME" style="combo_normal" />

收藏时间：<input name="scsjBeg" id="scsjBeg" class="easyui-datetimebox" style="width:100px;" data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
&gt;&gt;
	<input name="scsjEnd" id="scsjEnd" class="easyui-datetimebox" style="width:100px;" data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}}],
validType:['compareDate[scsjBeg]']"/>
	<!-- 学校ID：<input name='xxid' id="xxid" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/> -->

	<a href="javascript:void(0)" onclick="doZyscSearch()" class="btn btn-info"><span class="icon-search" style="font-size:16px"></span> <span style="font-size:14px">查询</span></a>
	</form>
</div>


<%-- 修改or添加面板 --%>
<iframe id="zyscEditWin" src="/${projectName}/zygl/zysc/page.action?page=zysc_upd" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#zyscEditButton'" title="编辑资源收藏表" style="width:500px;height:500px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="zyscEditButton">
	<a href="javascript:void(0)" onclick="$('#zyscEditWin').get(0).contentWindow.submitForm()" class="easyui-linkbutton" iconCls="icon-ok">保 存</a>
	<a href="javascript:void(0)" onclick="$('#zyscEditWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >取 消</a>
</div>
<%-- 查看面板 --%>
<iframe id="zyscViewWin" src="/${projectName}/zygl/zysc/page.action?page=zysc_vie" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#zyscViewButton'" title="查看资源收藏表" style="width:500px;height:500px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="zyscViewButton">
	<a href="javascript:$('#zyscViewWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >关 闭</a>
</div>
</body>
</html>
