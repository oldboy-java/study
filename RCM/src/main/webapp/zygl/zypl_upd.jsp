<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>编辑资源评论表</title><!--zypl-->
	<%@include file="/common/include.jsp" %>
<script>
<%-- 查询页点击修改时调用此方法加载记录详情 --%>
function load(id){
	$('#_form').form('load','/${projectName}/zygl/zypl/vieZypl.action?id='+id);
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
<form id="_form" method="post" action="/${projectName}/zygl/zypl/updZypl.action">
	<input type="hidden" name='id' id='id'/>
	<table>
		<tr><td class='label' style="width:120px">资源：</td><td><input id="zymc" name="zymc" class="easyui-textbox" data-options="required:true"/></td></tr>
		<tr><td class='label' >评论内容：</td><td><textarea id="plnr"  name="plnr" style="vertical-align: middle;width: 320px; height: 100px;resize: none; margin-top: 4px;"></textarea></td></tr>
		<tr><td class='label' >评论人姓名：</td><td><input id="plrxm" name="plrxm" class="easyui-textbox" data-options="required:true"/></td></tr>
		<tr><td class='label' >评论时间：</td><td><input id="plsjstr" name="plsjstr" class="easyui-datetimebox" data-options="required:true" /></td></tr>
		<tr><td class='label' >类型：</td><td><dc:insertList name="lx" dictId="ZD_PLLX" style="combo_normal" /></td></tr>
		<tr><td class='label' >回复谁：</td><td><input id="pls" name="pls" class="easyui-textbox" /></td></tr>
		<!-- <tr><td class='label' >学校ID：</td><td><input id="xxid" name="xxid" class="easyui-textbox" data-options="required:true"/></td></tr> -->
	</table>

</form>
</body>
</html>
