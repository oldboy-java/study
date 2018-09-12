<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/dictionary.tld" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改功能</title>
	<%@include file="/common/include.jsp" %>
<script>
$(function(){
	$('#funcstree').tree("enableDnd");
	$('#funcstree').tree({
		onDrop: function(target,source,point){
			/*节点被放置之前触发，返回 false 则禁止放置。
			target：DOM 对象，放置的目标节点。
			source：源节点。
			point：表示放置操作，可能的值是：'append'、'top' 或 'bottom'。*/
			$.get("/${projectName}/sysmanage/function/dropFunction.action",{
					'source':source.id,
					'target':$('#funcstree').tree('getData',target).id,
					'point':point
				},function(data){
					
			});
		},
		// right click node and then display the context menu
		onContextMenu: function(e, node){
			e.preventDefault();
			// select the node
			$('#funcstree').tree('select', node.target);
			// display context menu
			$('#mm').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
		}
	});
	
	$('#_form').form({
		onLoadSuccess:function(){
			$("#picico").attr("src",$("input[name='icon']").val());
		}
	});
	
	$('#saveBtn').linkbutton('disable');
});
function load(id){
	$('#_form').form('load',"/${projectName}/sysmanage/function/vieFunction.action?id="+id);
};
function submitForm(){
	$('#_form').form('submit',{
      success:function(data) {
      	//$.messager.alert('您好','修改成功');
      	$('#funcstree').tree('reload');
      }
   });
}
function openFunc(json){//{id:'',text:''}
	load(json.id);
	$('#saveBtn').linkbutton('enable');
}
//预添加
function preAdd(){
	var pid=$("#_form input[name='id']").val();
	$('#_form').form('load','/${projectName}/sysmanage/function/vieFunction.action?pid='+pid);
}
//删除
function del(){
	$.messager.confirm('敬告','删除选定记录？',function(r){
		if(r){
			var ids = [];
			ids.push(funcstreeDict.getValue());
			$.get("/${projectName}/sysmanage/function/delFunction.action",{ids:ids},function(data){
				$('#funcstree').tree('reload');
			});
		}
	});
}
</script>
</head>
<body class="easyui-layout">
	<div region="west" split="true" title="功能结构" style="width:260px;">
		<dc:includeTree dictId="SYS_FUNCS_ALL" name="funcstree" style="synch_single" bind="select:openFunc"/>
	</div>
	<div id="content" region="center" style="border:0;padding:20px;">
		<form id="_form" method="post" action="/${projectName}/sysmanage/function/updFunction.action" style="width:500px;"  enctype="multipart/form-data">
			<input type="hidden" name="from" value="submit"/>
			<input type="hidden" name='id' value=""/>
			<input type="hidden" name='pid' value=""/>
			<input type="hidden" name='picimg' value=""/>
			<input type="hidden" name='ord' value=""/>
			<input type="hidden" name='treetrack' value=""/>
			<input type="hidden" name='modulename' value=""/>
			<table>
				<tr><td class='label'>名称：</td><td><input name='name' class='easyui-textbox' data-options='required:true' value=''/></td></tr>
				<tr><td class='label'>链接/权限：</td><td><input name='link' class='easyui-textbox' data-options='required:true' value='' style="width:300px;"/></td></tr>
				<tr><td class='label'>显示：</td><td><dc:insertList name="isshow" dictId="SYS_FUNC_TYPE" style="enu_radio"/></td></tr>
				<tr><td class='label'>说明：</td><td><input name='info' class='easyui-textbox' data-options='multiline:true' value='' style="width:300px;height:100px;"/></td></tr>
				<tr><td class='label'>图标：</td><td>
					<input type="hidden" name="picico"/>
					<img id='icon' src=''/><Br/>
					<input class="easyui-filebox" name="file" style="width:80%;height:30px;">
				</td></tr>
			</table>
			<div style="text-align:center">
				<a href="javascript:submitForm()" class="easyui-linkbutton" id="saveBtn" iconCls="icon-ok">保 存</a>
			</div>
		</form>
	</div>
	
	<div id="mm" class="easyui-menu" style="width:120px;">
		<div onclick="preAdd()" data-options="iconCls:'icon-add'">添加功能</div>
		<div onclick="del()" data-options="iconCls:'icon-remove'">删除功能</div>
	</div>
</body>
</html>
