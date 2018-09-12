<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-dictionary" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
<title>资源表查询</title>
<!--zy-->
<%@include file="/common/include.jsp"%>

<script>
	var winToggle;
	$(function() {
		winToggle = new QWinToggle().regist([ "zyEditWin", "zyViewWin" ]);
		var pager = $('#zyGrid').datagrid().datagrid('getPager'); // get the pager of datagrid
		pager.pagination({
			buttons : [],
		});

		$("#downloadJfSetDialog").dialog("close");
	})
<%-- 执行查询，点击查询按钮时调用 --%>
	function doZySearch() {
		if (!$("#_form").form("validate")) {
			return;
		}
		$('#zyGrid').datagrid('load', {
			zymc : $('#zymc').val(),
			ssxkid : ssxkidDict.getValue(),
			wjgs : wjgsDict.getValue(),
			scr : $('#scr').val(),
			zyzt : zyztDict.getValue(),
			/* zyzt:$('#zyzt').val(),
			zydz:$('#zydz').val(), */
			zyly : $('#zyly').val(),
			zz : $('#zz').val(),
			shzt : shztDict.getValue()
		/* ,
				scrq:$('#scrq').val(),
				xzcs:$('#xzcs').val(),
				sccs:$('#sccs').val(),
				plcs:$('#plcs').val(),
				xxid:$('#xxid').val() */
		});
	}
<%-- 查询列表datagrid的"操作"列的内容渲染，若有其他操作请修改此方法 --%>
	function formatZyOper(val, row, index) {

		/* <a href='javascript:void(0)' onclick='updZy("+val+")' class='_oper' title='修改'>&nbsp;<i class='icon-edit'></i>&nbsp;</a> */
		return "&emsp;<a href='javascript:void(0)' onclick=zyzh('"
				+ row.zydz
				+ "','"
				+ row.wjgs
				+ "') class='_oper' title='资源格式转换'>&nbsp;<i class='icon-exchange'></i>&nbsp;</a>&emsp;";

	}
<%-- 资源文件下载 --%>
	function downloadzy(id) {
		window.location.href = "/${projectName}/zygl/zy/download.action?id="
				+ id;
	}

	function zyzh(zydz, wjgs) {
		if (wjgs == 'PDF' || wjgs == 'DOC' || wjgs == 'DOCX' || wjgs == 'PPT'
				|| wjgs == 'PPTX' || wjgs == 'XLS' || wjgs == 'XLSX') {
			$.ajax({
				type : 'GET',
				url : '/${projectName}/zygl/zy/wjzhByManual.action',
				data : {zydz:zydz},
				dataType : 'json',
				beforeSend : function() {
					load();
				},
				complete : function() {
					disLoad();
				},
				success : function(data) {
					var result = eval('(' + data + ')');
					if (result == true) {
						$.messager.alert('敬告', '转换成功！');
					} else {
						$.messager.alert('敬告', '转换失败！');
					}
					$('#zyGrid').datagrid('reload');
				}
			});
		} else if (wjgs == 'MP4' || wjgs == 'FLV' || wjgs == 'AVI'
				|| wjgs == 'MOV' || wjgs == 'WMV') {
			$.ajax({

				type : 'GET',
				url : '/${projectName}/zygl/zy/videoWjzhByManual.action',
				data : {zydz:zydz},
				dataType : 'json',
				beforeSend : function() {
					load();
				},
				complete : function() {
					disLoad();
				},
				success : function(data) {
					var result = eval('(' + data + ')');
					if (result == true) {
						$.messager.alert('敬告', '转换成功！');
					} else {
						$.messager.alert('敬告', '转换失败！');
					}
					$('#zyGrid').datagrid('reload');
				}
			});

		}

	}

	//弹出加载层
	function load() {
		$("<div class=\"datagrid-mask\"></div>").css({
			display : "block",
			width : "100%",
			height : $(window).height()
		}).appendTo("body");
		$("<div class=\"datagrid-mask-msg\"></div>").html("资源格式转换中，请稍候。。。")
				.appendTo("body").css({
					display : "block",
					left : ($(document.body).outerWidth(true) - 190) / 2,
					top : ($(window).height() - 45) / 2
				});
	}
	//取消加载层  
	function disLoad() {
		$(".datagrid-mask").remove();
		$(".datagrid-mask-msg").remove();
	}

	function previewzy(id) {

		window.open("/${projectName}/zygl/zy/previewzy.action?id=" + id,
				"_blank");

		/* $.get("/${projectName}/zygl/zy/previewzy.action?zydz="+zydz,function(data){
			window.open("/${projectName}/portal/jsp/space/documentView.jsp", "_blank");
			
		}); */
		/* window.location.href="/${projectName}/zygl/zy/previewzy.action?zydz="+zydz; */
	}
<%-- 打开修改页面，点击记录行的"修改"链接时调用 --%>
	function updZy(id) {
		winToggle.open("zyEditWin");
		$('#zyEditWin').get(0).contentWindow.load(id);
	}
<%-- 打开查看页面，点击记录行的"查看"链接时调用 --%>
	function vieZy(id) {
		winToggle.open("zyViewWin");
		$('#zyViewWin').get(0).contentWindow.load(id);
	}
<%-- 删除记录 --%>
	function delZy() {
		var checkedItems = $('#zyGrid').datagrid('getChecked');
		var ids = [];
		$.each(checkedItems, function(index, item) {
			ids.push(item.id);
		});
		if (ids.length == 0) {
			$.messager.alert('敬告', '请选择删除的记录？');
			return;
		}
		$.messager.confirm('敬告', '删除选定记录？', function(r) {
			if (r) {
				$.get("/${projectName}/zygl/zy/delZy.action", {
					ids : ids
				}, function(data) {
					$('#zyGrid').datagrid('reload');
				});
			}
		});
	}
<%-- 审核通过记录 --%>
	function shZyTg() {
		var checkedItems = $('#zyGrid').datagrid('getChecked');
		var ids = [];
		var b = false;
		$.each(checkedItems, function(index, item) {
			if (item.shzt == "审核通过") {
				b = true;
			}
			ids.push(item.id);
		});
		if (b == true) {
			$.messager.alert('敬告', '选择中存在已通过审核的资源！');
			return;
		}
		if (ids.length == 0) {
			$.messager.alert('敬告', '请选择审核通过的记录！');
			return;
		}
		$.messager.confirm('敬告', '审核通过选定记录？', function(r) {
			if (r) {
				$.get("/${projectName}/zygl/zy/shZysTg.action", {
					ids : ids
				}, function(data) {
					$('#zyGrid').datagrid('reload');
				});
			}
		});
	}
<%-- 审核不通过记录 --%>
	function shZysBtg() {
		var checkedItems = $('#zyGrid').datagrid('getChecked');
		var ids = [];
		var b = false;
		var b2 = false;
		$.each(checkedItems, function(index, item) {
			if (item.shzt == "未通过") {
				b = true;
			}
			if (item.shzt == "审核通过") {
				b2 = true;
			}
			ids.push(item.id);
		});
		if (b == true) {
			$.messager.alert('敬告', '选择中存在审核未通过的资源！');
			return;
		}
		if (b2 == true) {
			$.messager.alert('敬告', '审核通过的资源不可以做此操作！');
			return;
		}
		if (ids.length == 0) {
			$.messager.alert('敬告', '请选择审核不通过的记录？');
			return;
		}
		$.messager.confirm('敬告', '审核不通过选定记录？', function(r) {
			if (r) {
				$.get("/${projectName}/zygl/zy/shZysBtg.action", {
					ids : ids
				}, function(data) {
					$('#zyGrid').datagrid('reload');
				});
			}
		});
	}
<%-- 刷新数据，当添加或修改了数据后调用。从upd页中调用。 --%>
	function reloadData() {
		$('#zyEditWin').dialog('close');
		$('#zyGrid').datagrid('reload');
	}

	var ids = [];
<%-- 下载设置 --%>
	function setResourceDownloadAuth(qx) {
		var checkedItems = $('#zyGrid').datagrid('getChecked');

		var freeDownloadZy = [];
		var nofreeDownloadZy = [];

		$.each(checkedItems, function(index, item) {
			if (qx == 0) {
				if (item.xzqx == 0) {
					freeDownloadZy.push(item.id);
				}
			}
			ids.push(item.id);
		});

		if (ids.length == 0) {
			$.messager.alert('敬告', '请选择操作记录？');
			return;
		} else {
			if (qx == 0 && freeDownloadZy.length > 0) {
				$.messager.alert('敬告', '请选择积分下载的资源记录');
				return;
			}

		}

		$.messager.confirm('敬告', '确定设置选定的记录？', function(r) {
			if (r) {
				if (qx == 1) {
					$("#downloadJfSetDialog").dialog("open");
				} else {
					updateZyDownloadAuth(ids, qx, 0);
				}

			}
		});
	}
<%-- 更新下载权限 --%>
	function updateZyDownloadAuth(ids, qx, jf) {
		$.get("/${projectName}/zygl/zy/updateZyDownloadAuth.action", {
			zyIds : ids,
			auth : qx,
			jf : jf
		}, function(data) {
			$('#zyGrid').datagrid('reload');
		});
	}
<%-- 设置下载积分 --%>
	function setDownloadJf() {
		if (!$("#downloadJfSetform").form("validate")) {
			return;
		}
		var jf = $("#jf").val();
		jf = $.trim(jf);
		updateZyDownloadAuth(ids, 1, jf);
		//关闭弹层
		$("#downloadJfSetDialog").dialog("close");
		//重置表单
		$('#downloadJfSetform').form("reset")
	}
<%-- 查询列表datagrid的"操作"列的内容渲染，若有其他操作请修改此方法 --%>
	function formatZyXzqx(val, row, index) {
		var xzqx = row.xzqx;
		if (xzqx == 0) {
			return "免费下载";
		} else {
			return "需" + row.xzjf + "积分";
		}
	}
</script>
</head>
<body>
	<table id="zyGrid" title="" fitcolumns=true
		data-options="singleSelect:false,pagination:true,rownumbers:true,fit:true,striped:true,toolbar:'#zyGridToolbar',collapsible:true,url:'/${projectName}/zygl/zy/schZyWjs.action',method:'get'">
		<thead>
			<tr>
				<!-- <th data-options="field:'checkbox',checkbox:true"></th> -->
				<th data-options="field:'zymc',width:80,sortable:true">资源名称</th>
				<th data-options="field:'ssxkid',sortable:true">资源类型</th>
				<th data-options="field:'wjgs',sortable:true">文件格式</th>
				<th data-options="field:'scr',sortable:true">上传人</th>
				<th data-options="field:'zyzt',sortable:true">资源状态</th>
				<th data-options="field:'zydz',sortable:true">资源地址</th>
				<!-- <th data-options="field:'zyly',sortable:true">资源来源</th>
			<th data-options="field:'zz',sortable:true">作者</th> -->
				<th data-options="field:'scrq',sortable:true">上传日期</th>
				<th data-options="field:'shzt',sortable:true">审核状态</th>
				<!-- <th data-options="field:'llcs',sortable:true">浏览次数</th>
			<th data-options="field:'xzcs',sortable:true">下载次数</th>
			<th data-options="field:'sccs',sortable:true">收藏次数</th>
			<th data-options="field:'plcs',sortable:true">评论次数</th>
			<th data-options="field:'wjdx',sortable:true">文件大小</th>
			<th data-options="field:'xzqx',sortable:true,formatter:formatZyXzqx">下载权限</th> -->
				<!-- <th data-options="field:'xxid',sortable:true">学校ID</th> -->

				<th
					data-options="field:'_oper',align:'center',formatter:formatZyOper">操作</th>
			</tr>
		</thead>
	</table>
	<%-- 查询条件设定栏 --%>
	<div id="zyGridToolbar">
		<div class="opline">
			<!-- <a href="javascript:delZy()" class="btn btn-danger"><span class="icon-trash" style="font-size:16px"></span> <span style="font-size:14px">删除</span></a>&emsp;
		<a href="javascript:shZyTg()" class="btn btn-success"><span class=" icon-ok" style="font-size:16px"></span> <span style="font-size:14px">审核通过</span></a>&emsp;
		<a href="javascript:shZysBtg()" class="btn btn-danger"><span class=" icon-remove" style="font-size:16px"></span> <span style="font-size:14px">审核不通过</span></a>
		<a href="javascript:setResourceDownloadAuth(0);" class="btn btn-info"><span class="icon-ok" style="font-size:16px"></span> <span style="font-size:14px">免费下载</span></a>
		<a href="javascript:setResourceDownloadAuth(1);" class="btn btn-info"><span class="icon-ok" style="font-size:16px"></span> <span style="font-size:14px">积分下载</span></a> -->
		</div>
		<form id="_form" class="shline">
			资源名称：<input name='zymc' id="zymc" class='easyui-textbox' value=''
				data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]" />
			所属学科：
			<dc:insertList name="ssxkid" dictId="ZD_XKLB" style="combo_normal" />
			文件格式：
			<dc:insertList name="wjgs" dictId="ZD_ZYGS" style="combo_normal" />
			上传人：<input name='scr' id="scr" class='easyui-textbox' value=''
				data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]" />
			资源状态:
			<dc:insertList name="zyzt" dictId="ZD_ZYZT" style="combo_normal" />
			<!-- 	资源状态：<input name='zyzt' id="zyzt" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
	资源地址：<input name='zydz' id="zydz" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/> -->
			<!-- 资源来源：<input name='zyly' id="zyly" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/> -->
			<!-- 作者：<input name='zz' id="zz" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/> -->
			审核状态：
			<dc:insertList name="shzt" dictId="ZD_SHZT" style="combo_normal" />
			<!-- 	上传日期：<input name='scrq' id="scrq" class='easyui-textbox' value='' data-options="iconWidth:16,
icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('setValue', '');}
}]"/>
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

			<a href="javascript:void(0)" onclick="doZySearch()"
				class="btn btn-info"><span class="icon-search"
				style="font-size: 16px"></span> <span style="font-size: 14px">查询</span></a>
		</form>
	</div>


	<%-- 修改or添加面板 --%>
	<iframe id="zyEditWin"
		src="/${projectName}/zygl/zy/page.action?page=zy_upd"
		class="easyui-dialog"
		data-options="iconCls:'icon-save',buttons: '#zyEditButton'"
		title="编辑资源表"
		style="width: 500px; height: 500px; padding: 5px; top: 5000px"
		scrolling="auto" frameborder="0"></iframe>
	<div id="zyEditButton">
		<a href="javascript:void(0)"
			onclick="$('#zyEditWin').get(0).contentWindow.submitForm()"
			class="easyui-linkbutton" iconCls="icon-ok">保 存</a> <a
			href="javascript:void(0)" onclick="$('#zyEditWin').dialog('close');"
			class="easyui-linkbutton" iconCls="icon-remove">取 消</a>
	</div>
	<%-- 查看面板 --%>
	<iframe id="zyViewWin"
		src="/${projectName}/zygl/zy/page.action?page=zy_vie"
		class="easyui-dialog"
		data-options="iconCls:'icon-save',buttons: '#zyViewButton'"
		title="查看资源表"
		style="width: 500px; height: 500px; padding: 5px; top: 5000px"
		scrolling="auto" frameborder="0"></iframe>
	<div id="zyViewButton">
		<a href="javascript:$('#zyViewWin').dialog('close');"
			class="easyui-linkbutton" iconCls="icon-remove">关 闭</a>
	</div>


	<div id="downloadJfSetDialog" class="easyui-dialog"
		style="width: 400px; height: 200px"
		data-options="title:'设置下载积分',buttons:'#tb',modal:true">
		<form id="downloadJfSetform" method="post"
			action="/${projectName}/zygl/xklb/updXklb.action">
			<table>
				<tr>
					<td class='label' style="width: 80px">积分(分)：</td>
					<td><input id="jf" name="jf" class="easyui-numberbox"
						data-options="required:true,min:1,max:10000" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="tb">
		<a href="javascript:void(0)" onclick="javascript:setDownloadJf()"
			class="easyui-linkbutton" iconCls="icon-ok">保 存</a> <a
			href="javascript:void(0)"
			onclick="$('#downloadJfSetDialog').dialog('close');"
			class="easyui-linkbutton" iconCls="icon-remove">取 消</a>
	</div>
</body>
</html>
