<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>编辑资源类型</title><!--xklb-->
	<%@include file="/common/include.jsp" %>
<script>
<%-- 查询页点击修改时调用此方法加载记录详情 --%>
function load(id){
	$('#_form').form('load','/${projectName}/zygl/xklb/vieXklb.action?id='+id);
};

<%-- 点击保存按钮时调用此方法。(注:保存按钮在查询列表页) --%>
function submitForm(){
	if(!$("#_form").form("validate")){
		return;
	}
	$('#_form').form('submit',{
      success:function(data) {
    	  if("该资源类型已存在！"==data){
    		  $.messager.alert('敬告','该资源类型已存在！');
    	  }else{
    		  parent.reloadData();
    	  }
      }
   });
}
</script>
</head>
<body>
<form id="_form" method="post" action="/${projectName}/zygl/xklb/updXklb.action">
	<input type="hidden" name='id' id='id'/>
	<table>
		<tr><td class='label' style="width:120px"> 资源类型名称：</td><td><input id="xkmc" name="xkmc" class="easyui-textbox" data-options="required:true"/></td></tr>
		<!-- <tr><td class='label' >学校ID：</td><td><input id="xxid" name="xxid" class="easyui-textbox" data-options="required:true"/></td></tr> -->
	</table>

</form>
</body>
</html>
