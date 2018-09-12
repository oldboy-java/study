<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/dictionary.tld" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<title>用户表查询</title>
	<%@include file="/common/include.jsp" %>
</head>
<body class="easyui-layout">
	>
	<div id="content" region="center" style="border:0;">
		<table id="userGrid" title="用户表" class="easyui-datagrid" fitcolumns=true
			data-options="singleSelect:false,pagination:true,rownumbers:true,fit:true,striped:true,toolbar:'#userGridToolbar',collapsible:true,url:'/${projectName}/sysmanage/user/schUser.action',method:'get'">
			<thead>
				<tr>
					<th data-options="field:'checkbox',checkbox:true" ></th>
					<th data-options="field:'loginname',width:80,sortable:true">登录名</th>
					<th data-options="field:'username',sortable:true">姓名</th>
					<!-- <th data-options="field:'organname',sortable:true">单位部门</th> -->
					<!-- <th data-options="field:'qyid',sortable:true">企业</th>
					<th data-options="field:'xsid',sortable:true">学生</th>
					<th data-options="field:'birthday',sortable:true">生日</th> -->
		
					<th data-options="field:'_oper',align:'center',formatter:formatOper">操作</th>
				</tr>
			</thead>
		</table>
	</div>
<div id="userGridToolbar">
	姓名：<input class="easyui-textbox" name="username" id="username" style="width:160px;" data-options="
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
	var pager = $('#userGrid').datagrid().datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		buttons:[{
			iconCls:'icon-add',
			text:'添加',
			handler:function(){
				updUser(0);
			}
		},{
			iconCls:'icon-remove',
			text:'删除',
			handler:function(){
				var checkedItems = $('#userGrid').datagrid('getChecked');
				var ids = [];
				$.each(checkedItems, function(index, item){
					ids.push(item.id);
				});
				$.messager.confirm('敬告','删除选定记录？',function(r){
					if(r){
						$.get("/${projectName}/sysmanage/user/delUser.action",{ids:ids},function(data){
							$('#userGrid').datagrid('reload');
						});
					}
				});
			}
		}],
	});
	//注册回车查询
	$('#username').textbox('textbox').keydown(function (e) {
       if (e.keyCode == 13) {
          doSearch();
       }
   });
})

   
function doSearch(single){
	var orgs=currOrganId;
	var treeOrgs=organtreeDict.getValue();
	if(!single&&treeOrgs!=""){
		orgs=treeOrgs;
	}
	$('#userGrid').datagrid('load',{
		username: $('#username').val(),
		organids:orgs
	});
}
function formatOper(val,row,index){  
    return "<span onclick='updUser("+val+")' style='text-decoration:underline;cursor:pointer;'>修改</span> "
    			+"<span onclick='vieUser("+val+")' style='text-decoration:underline;cursor:pointer;'>查看</span>";  
} 

function updUser(id){
	$('#userViewWin').dialog('close');
	$('#userEditWin').dialog('open');
	$('#userEditWin').get(0).contentWindow.load(id,currOrganId);
} 
function vieUser(id){
	$('#userEditWin').dialog('close');
	$('#userViewWin').dialog('open');
	$('#userViewWin').get(0).contentWindow.load(id);
}
function reloadData(){
	$('#userEditWin').dialog('close');
	$('#userGrid').datagrid('reload');
}
var currOrganId;
function openOrgan(json){//{id:'',text:''}
	currOrganId=json.id;
	doSearch(true);
}
</script>
<iframe id="userEditWin" src="/${projectName}/sysmanage/user/page.action?page=user_upd" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#userEditButton'" title="修改用户" closed="true" style="width:500px;height:80%;padding:5px;" scrolling="auto" frameborder="0"></iframe>
<div id="userEditButton">
	<a href="javascript:$('#userEditWin').get(0).contentWindow.submitForm()" class="easyui-linkbutton" id="saveBtn" iconCls="icon-ok">保 存</a>
	<a href="javascript:$('#userEditWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-cancel" >关 闭</a>
</div>

<iframe id="userViewWin" src="/${projectName}/sysmanage/user/page.action?page=user_vie" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#userViewButton'" title="查看用户" closed="true" style="width:500px;height:80%;padding:5px;" scrolling="auto" frameborder="0"></iframe>
<div id="userViewButton">
	<a href="javascript:$('#userViewWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-cancel" >关 闭</a>
</div>
</body>
</html>
