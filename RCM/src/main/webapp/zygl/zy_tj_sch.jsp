<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<title>资源表查询</title><!--zy-->
	<%@include file="/common/include.jsp" %>

<script>
var winToggle;
$(function(){
	winToggle=new QWinToggle().regist(["zyEditWin","zyViewWin"]);
	var pager = $('#zyGrid').datagrid().datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		buttons:[],
	});			
})

<%-- 执行查询，点击查询按钮时调用 --%>
function doZySearch(){
	if(!$("#_form").form("validate")){
		return;
	}
	$('#zyGrid').datagrid('load',{
		ssxkid:ssxkidDict.getValue(),
		zyzt:zyztDict.getValue(),
		zymc:$('#zymc').val(),
		wjgs:wjgsDict.getValue(),
		zz:$('#zz').val(),
		scr:$('#scr').val(),
		zyly:$('#zyly').val(),
		scrqBeg:$('#scrqBeg').datetimebox("getValue"), 
		scrqEnd:$('#scrqEnd').datetimebox("getValue"), 
		/* zyzt:$('#zyzt').val(),
		zydz:$('#zydz').val(), */
		
		
		shzt:shztDict.getValue()/* ,
		scrq:$('#scrq').val(),
		xzcs:$('#xzcs').val(),
		sccs:$('#sccs').val(),
		plcs:$('#plcs').val(),
		xxid:$('#xxid').val() */
	});
}

<%-- 查询列表datagrid的"操作"列的内容渲染，若有其他操作请修改此方法 --%>
function formatZyOper(val,row,index){ 

	/* <a href='javascript:void(0)' onclick='updZy("+val+")' class='_oper' title='修改'>&nbsp;<i class='icon-edit'></i>&nbsp;</a> */
    return "&emsp;"
    			+"<a href='javascript:void(0)' onclick='vieZy("+val+")' class='_oper' title='查看'>&nbsp;<i class='icon-info-sign'></i>&nbsp;</a>" 
                     +"<a href='javascript:void(0)' onclick='downloadzy("+val+")' class='_oper' title='资源文件下载'>&nbsp;<i class='icon-download'></i>&nbsp;</a>"
                     +"<a href='javascript:void(0)' onclick='previewzy(\""+row.id+"\")' class='_oper' title='预览'>&nbsp;<i class='icon-eye-open'></i>&nbsp;</a>&emsp;";
} 

<%-- 资源文件下载 --%>
function downloadzy(id){
	window.location.href="/${projectName}/zygl/zy/download.action?id="+id;
}

function previewzy(id){
	
		window.open("/${projectName}/zygl/zy/previewzy.action?id="+id, "_blank");
		

	/* $.get("/${projectName}/zygl/zy/previewzy.action?zydz="+zydz,function(data){
		window.open("/${projectName}/portal/jsp/space/documentView.jsp", "_blank");
		
	}); */
	/* window.location.href="/${projectName}/zygl/zy/previewzy.action?zydz="+zydz; */
}
<%-- 打开修改页面，点击记录行的"修改"链接时调用 --%>
function updZy(id){
	winToggle.open("zyEditWin");
	$('#zyEditWin').get(0).contentWindow.load(id);
} 

<%-- 打开查看页面，点击记录行的"查看"链接时调用 --%>
function vieZy(id){
	winToggle.open("zyViewWin");
	$('#zyViewWin').get(0).contentWindow.load(id);
}

<%-- 删除记录 --%>
function delZy(){
	var checkedItems = $('#zyGrid').datagrid('getChecked');
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
			$.get("/${projectName}/zygl/zy/delZy.action",{ids:ids},function(data){
				$('#zyGrid').datagrid('reload');
			});
		}
	});
}

<%-- 刷新数据，当添加或修改了数据后调用。从upd页中调用。 --%>
function reloadData(){
	$('#zyEditWin').dialog('close');
	$('#zyGrid').datagrid('reload');
}

</script>
</head>
<body>
<table id="zyGrid" title="" fitcolumns=true
	data-options="singleSelect:false,pagination:true,rownumbers:true,fit:true,striped:true,toolbar:'#zyGridToolbar',collapsible:true,url:'/${projectName}/zygl/zy/schZys.action',method:'get'">
	<thead>
		<tr>
			<th data-options="field:'checkbox',checkbox:true" ></th>
			
			<th data-options="field:'ssxkid',width:80,sortable:true">资源类型</th>
			<th data-options="field:'zyzt',sortable:true">资源状态</th>
			<th data-options="field:'zymc',sortable:true">资源名称</th>
			<th data-options="field:'wjgs',sortable:true">文件格式</th>
			<th data-options="field:'zz',sortable:true">作者</th>
			<th data-options="field:'scr',sortable:true">上传人</th>
			<th data-options="field:'zyly',sortable:true">资源来源</th>
			<th data-options="field:'scrq',sortable:true">上传日期</th>
			<th data-options="field:'shzt',sortable:true">审核状态</th>
		</tr>
	</thead>
</table>
<%-- 查询条件设定栏 --%>
<div id="zyGridToolbar">
	<div class="opline">
		<!-- <a href="javascript:delZy()" class="btn btn-danger"><span class="icon-trash" style="font-size:16px"></span> <span style="font-size:14px">删除</span></a>&emsp;
		<a href="javascript:shZyTg()" class="btn btn-success"><span class=" icon-ok" style="font-size:16px"></span> <span style="font-size:14px">审核通过</span></a>&emsp;
		<a href="javascript:shZysBtg()" class="btn btn-danger"><span class=" icon-remove" style="font-size:16px"></span> <span style="font-size:14px">审核不通过</span></a>
		<a href="javascript:setResourceDownloadAuth(0);" class="btn btn-info"><span class="icon-ok" style="font-size:16px"></span> <span style="font-size:14px">设置免费下载</span></a>
		<a href="javascript:setResourceDownloadAuth(1);" class="btn btn-danger"><span class="icon-remove" style="font-size:16px"></span> <span style="font-size:14px">禁止免费下载</span></a> -->
	</div>
	<form id="_form" class="shline">
	资源类型：<dc:insertList name="ssxkid" dictId="ZD_XKLB" style="combo_normal" />
	资源状态:<dc:insertList  name="zyzt" dictId="ZD_ZYZT" style="combo_normal" />
	资源名称：<input name='zymc' id="zymc" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
	文件格式：<dc:insertList name="wjgs" dictId="ZD_ZYGS" style="combo_normal" />
	作者：<input name='zz' id="zz" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
	上传人：<input name='scr' id="scr" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
	资源来源：<input name='zyly' id="zyly" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
          上传日期：<input name="scrqBeg" id="scrqBeg" class="easyui-datetimebox" style="width:100px;" data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
     &gt;&gt;
	<input name="scrqEnd" id="scrqEnd" class="easyui-datetimebox" style="width:100px;" data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}}],
validType:['compareDate[scrqBeg]']"/>
          审核状态：<dc:insertList name="shzt" dictId="ZD_SHZT" style="combo_normal" />
<!-- 	资源状态：<input name='zyzt' id="zyzt" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
	资源地址：<input name='zydz' id="zydz" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/> -->
	
	<!-- 作者：<input name='zz' id="zz" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/> -->
      
<!-- 	
	浏览次数：<input name='llcs' id="llcs" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
	下载次数：<input name='xzcs' id="xzcs" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
	收藏次数：<input name='sccs' id="sccs" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
	评论次数：<input name='plcs' id="plcs" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/> 
	学校ID：<input name='xxid' id="xxid" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>-->

	<a href="javascript:void(0)" onclick="doZySearch()" class="btn btn-info"><span class="icon-search" style="font-size:16px"></span> <span style="font-size:14px">查询</span></a>
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
