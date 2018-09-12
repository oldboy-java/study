<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>编辑等级信息</title><!--djxx-->
	<%@include file="/common/include.jsp" %>
<script>
<%-- 查询页点击修改时调用此方法加载记录详情 --%>
var _id = 0;
function load(id){
	_id = id;
	$('#_form').form('load','/${projectName}/zygl/djxx/vieDjxx.action?id='+id);
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

$(function(){
	$.extend($.fn.validatebox.defaults.rules, {  
       /*  等级名称验证存在 */
		checkDjmcExists: {  
            validator: function(value, param) { 
            	var ret = false;
                $.ajax({
                	url:'/${projectName}/zygl/djxx/checkDjmcExists.action',
                	dataType:'json',
                	async:false,
                	data:{djmc:$.trim(value),id:_id},
                	type:'POST',
                	success:function(response){
                		ret = response.data
                	}
                });
                return !ret;
            },  
            message: '等级名称已存在'  
        } ,
       /*  验证最大积分数大于最小积分数 */
        bigger:{
        	 validator: function(value, param) { 
             	return value-$(param[0]).val() > 0 ? true :false;
             },  
             message: '最大积分数必须大于最小积分数' 
        }
        
    });  
})
</script>
</head>
<body>
<form id="_form" method="post" action="/${projectName}/zygl/djxx/updDjxx.action">
	<input type="hidden" name='id' id='id' value="0"/>
	<table>
		<!-- 通过validType属性绑定自定义验证规则 -->
		<tr><td class='label' style="width:120px">等级名称：</td><td><input id="djmc" name="djmc" validType="checkDjmcExists" class="easyui-numberbox" data-options="required:true,min:1,max:10000"/></td></tr>
		<tr><td class='label' >最小积分数(分)：</td><td><input id="zxjf" name="zxjf" class="easyui-numberbox" data-options="required:true,min:0,max:10000"/></td></tr>
		<tr><td class='label' >最大积分数(分)：</td><td><input id="zdjf" name="zdjf" validType="bigger['#zxjf']"  class="easyui-numberbox" data-options="required:true,min:1,max:10000"/></td></tr>
	</table>
	
	<div style="margin-left:40px;margin-top:20px;">
		<dd style="margin-bottom:10px;">* 等级名称、最小积分数、最大积分数只能填写数字</dd>
		<dd>* 最小积分数最小值为0分、最大积分数最大值为1000</dd>
	</div>
</form>
</body>
</html>
