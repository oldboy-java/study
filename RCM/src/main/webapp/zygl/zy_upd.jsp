<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>编辑资源表</title><!--zy-->
	<%@include file="/common/include.jsp" %>
<script>
<%-- 查询页点击修改时调用此方法加载记录详情 --%>
function load(id){
	$('#_form').form('load','/${projectName}/zygl/zy/vieZy.action?id='+id);
};

<%-- 点击保存按钮时调用此方法。(注:保存按钮在查询列表页) --%>
function submitForm(){
	if(!$("#_form").form("validate")){
		return;
	}
	$('#_form').form('submit',{
      success:function(data) {
      	parent.reloadData();
      }
   });
}
</script>
</head>
<body>
<form id="_form" method="post" action="/${projectName}/zygl/zy/updZy.action">
	<input type="hidden" name='id' id='id'/>
	<table>
		<tr><td class='label' style="width:120px">资源名称：</td><td><input id="zymc" name="zymc" class="easyui-textbox" data-options="required:true"/></td></tr>
		<tr><td class='label' >所属学科：</td><td><dc:insertList name="ssxkid" dictId="ZD_XKLB" style="combo_normal" /></td></tr>
		<tr><td class='label' >文件格式：</td><td><input id="wjgs" name="wjgs" class="easyui-textbox" data-options="required:true"/></td></tr>		
		<tr><td class='label' >资源状态：</td><td><dc:insertList name="zyzt" dictId="ZD_ZYZT" style="combo_normal" /></td></tr>
		<tr><td class='label' >资源地址：</td><td><input id="zydz" name="zydz" class="easyui-textbox" data-options="required:true"/></td></tr>
		<tr><td class='label' >资源来源：</td><td><input id="zyly" name="zyly" class="easyui-textbox" data-options="required:true"/></td></tr>
		<tr><td class='label' >作者：</td><td><input id="zz" name="zz" class="easyui-textbox" data-options="required:true"/></td></tr>
		<tr><td class='label' >上传日期：</td><td><input id="scrqstr" name="scrqstr" class="easyui-datebox" data-options="required:true" /></td></tr>
		<tr><td class='label' >浏览次数：</td><td><input id="llcs" name="llcs" class="easyui-textbox" data-options="required:true"/></td></tr>
		<tr><td class='label' >下载次数：</td><td><input id="xzcs" name="xzcs" class="easyui-textbox" data-options="required:true"/></td></tr>
		<tr><td class='label' >收藏次数：</td><td><input id="sccs" name="sccs" class="easyui-textbox" data-options="required:true"/></td></tr>
		<tr><td class='label' >评论次数：</td><td><input id="plcs" name="plcs" class="easyui-textbox" data-options="required:true"/></td></tr>
		<tr><td class='label' >文件大小：</td><td><input id="wjdx" name="wjdx" class="easyui-textbox" data-options="required:true"/></td></tr>
		<!-- <tr><td class='label' >学校ID：</td><td><input id="xxid" name="xxid" class="easyui-textbox" data-options="required:true"/></td></tr> -->
	</table>

</form>
</body>
</html>
