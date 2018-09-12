<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>编辑网站设置</title><!--wzsz-->
	<%@include file="/common/include.jsp" %>
<script>
<%-- 查询页点击修改时调用此方法加载记录详情 --%>
$(function(){
	//加载表单
	$('#_form').form('load','/${projectName}/zygl/wzsz/getWzsz.action');
	//表单加载成功
	$('#_form').form({'onLoadSuccess':function(){
		var idx = parseInt($('#mb').val())-1;
		$(".mb span:eq("+idx+")").addClass('cur');
	}});
	
});
function doWzsz(_value,obj){
	$('#mb').val(_value);
	$(".mb span").removeClass('cur');
	$(obj).addClass('cur');
	$('#_form').form('submit',{
	      success:function(data) {
	      	
	      }
	 });
}
</script>

<style>
  .mb{height:40px;text-align: center;}
  .mb span {border:1px solid #aaa;padding:8px 20px;border-radius:5px;}
  .mb .cur {background:#3498db;color:#fff}
</style>
</head>
<body>
<form id="_form" method="post" action="/${projectName}/zygl/wzsz/updWzsz.action">
	<input type="hidden" name='id' id='id'/>
	<table>
		<tr>
			<input type="hidden" name="mb" id="mb"/>
			<td class='label' style="width:120px">网站模板：</td>
			<td class="mb"><span onclick="doWzsz(1,this);">模板一</span></td>
			<td class="mb"><span onclick="doWzsz(2,this);">模板二</span></td>
		</tr>
		<tr>
			<td class='label' style="width:120px;"></td>
			<td><img src="/${projectName}/img/site-template-1.png"/></td>
			<td><img src="/${projectName}//img/site-template-2.png"/></td>
		</tr>
	</table>

</form>
</body>
</html>
