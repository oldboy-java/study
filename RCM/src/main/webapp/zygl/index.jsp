<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title></title>
	<%@include file="/common/include.jsp" %>
	<script>
	function addTab(title, url){
		if ($('#tabdiv').tabs('exists', title)){
			$('#tabdiv').tabs('select', title);
		} else {
			var content = '<iframe scrolling="no" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
			$('#tabdiv').tabs('add',{
				title:title,
				content:content,
				closable:true
			});
		}
	}
	</script>
	<style>
	.panel-body{overflow:hidden}
	</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'west',split:true" style="width:200px;padding:0px;">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div title="Title1"  data-options="selected:true"  style="padding:10px;">
				<a href="javascript:addTab('测试资源表','/${projectName}/zygl/zy/page.action?page=zy_sch')">测试资源表</a><br/>

				<a href="javascript:addTab('测试资源评论表','/${projectName}/zygl/zypl/page.action?page=zypl_sch')">测试资源评论表</a><br/>

<a href="javascript:addTab('测试资源评论回复表','/${projectName}/zygl/zyplhf/page.action?page=zyplhf_sch')">测试资源评论回复表</a><br/>

<a href="javascript:addTab('测试资源收藏表','/${projectName}/zygl/zysc/page.action?page=zysc_sch')">测试资源收藏表</a><br/>

<a href="javascript:addTab('测试资源下载表','/${projectName}/zygl/zyxz/page.action?page=zyxz_sch')">测试资源下载表</a><br/>

<a href="javascript:addTab('测试资源浏览表','/${projectName}/zygl/zyll/page.action?page=zyll_sch')">测试资源浏览表</a><br/>

<a href="javascript:addTab('测试通知公告表','/${projectName}/zygl/tzgg/page.action?page=tzgg_sch')">测试通知公告表</a><br/>

<a href="javascript:addTab('测试学科类别表','/${projectName}/zygl/xklb/page.action?page=xklb_sch')">测试学科类别表</a><br/>

<a href="javascript:addTab('测试资源点赞表','/${projectName}/zygl/zydz/page.action?page=zydz_sch')">测试资源点赞表</a><br/>

<a href="javascript:addTab('测试文件转换表','/${projectName}/zygl/wjzh/page.action?page=wjzh_sch')">测试文件转换表</a><br/>

<a href="javascript:addTab('测试用户等级','/${projectName}/zygl/yhdj/page.action?page=yhdj_sch')">测试用户等级</a><br/>

<a href="javascript:addTab('测试等级信息','/${projectName}/zygl/djxx/page.action?page=djxx_sch')">测试等级信息</a><br/>

<a href="javascript:addTab('测试网站设置','/${projectName}/zygl/wzsz/page.action?page=wzsz_sch')">测试网站设置</a><br/>

<!--insert-->
			</div>
		</div>
	</div>
	<div data-options="region:'center'">
		<div id="tabdiv" class="easyui-tabs" data-options="fit:true,border:false,plain:true" fit="true">
		</div>
	</div>
</body>
</html>
