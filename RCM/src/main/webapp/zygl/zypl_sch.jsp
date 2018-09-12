<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<title>资源评论表查询</title><!--zypl-->
	<%@include file="/common/include.jsp" %>

<script>
var winToggle;
$(function(){
	winToggle=new QWinToggle().regist(["zyplEditWin","zyplViewWin"]);
	var pager = $('#zyplGrid').datagrid().datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		buttons:[],
	});			
})

<%-- 执行查询，点击查询按钮时调用 --%>
function doZyplSearch(){
	if(!$("#_form").form("validate")){
		return;
	}
	$('#zyplGrid').datagrid('load',{
		zymc:$('#zymc').val(),
		plnr:$('#plnr').val(),
		plrid:$('#plrid').val(),
		plrxm:$('#plrxm').val(),
		/* plsjBeg:$('#plsjBeg').datetimebox("getValue"), 
		plsjEnd:$('#plsjEnd').datetimebox("getValue"), */
		lx:lxDict.getValue()/* , 
		xxid:$('#xxid').val() */
	});
}

<%-- 查询列表datagrid的"操作"列的内容渲染，若有其他操作请修改此方法 --%>
function formatZyplOper(val,row,index){  
	/* &emsp;<a href='javascript:void(0)' onclick='updZypl("+val+")' class='_oper' title='修改'>&nbsp;<i class='icon-edit'></i>&nbsp;</a> */
    return "<a href='javascript:void(0)' onclick='vieZypl("+val+")' class='_oper' title='查看'>&nbsp;<i class='icon-info-sign'></i>&nbsp;</a>&emsp;"; 
} 

<%-- 打开修改页面，点击记录行的"修改"链接时调用 --%>
function updZypl(id){
	winToggle.open("zyplEditWin");
	$('#zyplEditWin').get(0).contentWindow.load(id);
} 

<%-- 打开查看页面，点击记录行的"查看"链接时调用 --%>
function vieZypl(id){
	winToggle.open("zyplViewWin");
	$('#zyplViewWin').get(0).contentWindow.load(id);
}

<%-- 删除记录 --%>
function delZypl(){
	var checkedItems = $('#zyplGrid').datagrid('getChecked');
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
			$.get("/${projectName}/zygl/zypl/delZypl.action",{ids:ids},function(data){
				$('#zyplGrid').datagrid('reload');
			});
		}
	});
}

<%-- 刷新数据，当添加或修改了数据后调用。从upd页中调用。 --%>
function reloadData(){
	$('#zyplEditWin').dialog('close');
	$('#zyplGrid').datagrid('reload');
}
</script>
</head>
<body>
<table id="zyplGrid" title="" fitcolumns=true
	data-options="singleSelect:false,pagination:true,rownumbers:true,fit:true,striped:true,toolbar:'#zyplGridToolbar',collapsible:true,url:'/${projectName}/zygl/zypl/schZypl.action',method:'get'">
	<thead>
		<tr>
			<th data-options="field:'checkbox',checkbox:true" ></th>
			<th data-options="field:'zymc',width:10,sortable:true">资源名称</th>
			<th data-options="field:'plnr',width:10,sortable:true">评论内容</th>
			<th data-options="field:'plrxm',width:4,sortable:true">评论人姓名</th>
			<th data-options="field:'plsj',sortable:true">评论时间</th>
			<th data-options="field:'lx',sortable:true">类型</th>
			<th data-options="field:'pls',sortable:true">回复谁</th>
			<!-- <th data-options="field:'xxid',sortable:true">学校ID</th> -->

			<!-- <th data-options="field:'_oper',align:'center',formatter:formatZyplOper">操作</th> -->
		</tr>
	</thead>
</table>
<%-- 查询条件设定栏 --%>
<div id="zyplGridToolbar">
	<div class="opline">
		<!-- <a href="javascript:updZypl(0)" class="btn btn-success"><span class="icon-plus" style="font-size:16px"></span> <span style="font-size:14px">添加</span></a>&emsp; -->
		<a href="javascript:delZypl()" class="btn btn-danger"><span class="icon-trash" style="font-size:16px"></span> <span style="font-size:14px">删除</span></a>
	</div>
	<form id="_form" class="shline">
	资源名称：<input name='zymc' id="zymc" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
	评论内容：<input name='plnr' id="plnr" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
	评论人姓名：<input name='plrxm' id="plrxm" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
	<!-- 评论时间：<input name='plsj' id="plsj" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/> -->
<!-- 评论时间：<input name="plsjBeg" id="plsjBeg" class="easyui-datetimebox" style="width:100px;" data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
&gt;&gt;
	<input name="plsjEnd" id="plsjEnd" class="easyui-datetimebox" style="width:100px;" data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}}],
validType:['compareDate[plsjBeg]']"/> -->
	<!-- 学校ID：<input name='xxid' id="xxid" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/> -->
类型：<dc:insertList name="lx" dictId="ZD_PLLX" style="combo_normal" />
	<a href="javascript:void(0)" onclick="doZyplSearch()" class="btn btn-info"><span class="icon-search" style="font-size:16px"></span> <span style="font-size:14px">查询</span></a>
	</form>
</div>


<%-- 修改or添加面板 --%>
<iframe id="zyplEditWin" src="/${projectName}/zygl/zypl/page.action?page=zypl_upd" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#zyplEditButton'" title="编辑资源评论表" style="width:500px;height:500px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="zyplEditButton">
	<a href="javascript:void(0)" onclick="$('#zyplEditWin').get(0).contentWindow.submitForm()" class="easyui-linkbutton" iconCls="icon-ok">保 存</a>
	<a href="javascript:void(0)" onclick="$('#zyplEditWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >取 消</a>
</div>
<%-- 查看面板 --%>
<iframe id="zyplViewWin" src="/${projectName}/zygl/zypl/page.action?page=zypl_vie" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#zyplViewButton'" title="查看资源评论表" style="width:500px;height:500px;padding:5px;top:5000px" scrolling="auto" frameborder="0"></iframe>
<div id="zyplViewButton">
	<a href="javascript:$('#zyplViewWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >关 闭</a>
</div>
</body>
</html>
