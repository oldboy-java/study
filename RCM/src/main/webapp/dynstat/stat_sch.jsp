<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/dictionary.tld" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<title>统计查询</title><!--tablesInDb-->
	<%@include file="/common/include.jsp" %>
	<script src="/${projectName}/dynstat/js/echarts.min.js"></script>
	<script src="/${projectName}/dynstat/js/themeEssos.js"></script>
	<script src="/${projectName}/dynstat/js/qct.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'west',split:true" style="width:20%;padding:0px;" id="menu">
	<script>
	var conditionJson="";//条件面板JSON
	var currTableName;
	$(function(){
		$('#statTableGrid').datagrid();
	})
	
	<%-- 执行查询，点击查询按钮时调用 --%>
	function doSearch(){
		$('#statTableGrid').datagrid('load');
	}
	
	<%-- 查询列表datagrid的"操作"列的内容渲染，若有其他操作请修改此方法 --%>
	function formatname(val,row,index){
	    return "&emsp;<a href='javascript:void(0)' onclick=\"schTable('"+row.key+"')\" class='_oper' title='查看'><i class='icon-table'></i> "+val+"</a>&emsp;";
	}
	
	<%-- 删除记录 --%>
	function delStatTable(){
		var checkedItems = $('#statTableGrid').datagrid('getChecked');
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
				$.get("/${projectName}/dynstat/config/delDatas.action",{ids:ids},function(data){
					$('#statTableGrid').datagrid('reload');
				});
			}
		});
	}
	
	<%-- 刷新数据，当添加或修改了数据后调用。从upd页中调用。 --%>
	function reloadData(){
		$('#tablesInDbEditWin').dialog('close');
		$('#statTableGrid').datagrid('reload');
	}
	
	<%-- 查询统计表数据。点统计列表调用 --%>
	function schTable(id){
		if(id==undefined)id=currTableName;
		currTableName=id;
		$.get("/${projectName}/dynstat/query/getHead.action",{key:id},function(data){
			data=eval("("+data+")");
			var frozen=data.frozen;
			var head=data.head;
			//重新加载表格
	        $('#datasGrid').datagrid({
	            singleSelect:true,
	            pagination:false,
	            //rownumbers:true,
	            fit: true,
	            striped:true,
	            url: '/${projectName}/dynstat/query/schData.action?key='+id,
	            singleSelect: true,
	            collapsible:true,
	            toolbar: '#datasGridToolbar',
	            method: 'get',
	            columns:head,
	            frozenColumns:[[{ title:frozen, field: 'collect'}]],
	            onClickRow: clickRow,//单击事件
	        });
	        window.setTimeout(function() {
	        	$(".datagrid-cell").click(clickColumn);
	        }, 2000);
		});
		$.get("/${projectName}/dynstat/config/schConditionPane.action",{"key":currTableName},function(data){
			if(data==""){
				conditionJson="";
				$("#conditionBtn").hide();
			}else{
				conditionJson=eval("("+data+")");
				$("#conditionBtn").show();
			}
		});
		$('#cfgDictWin').dialog('close');
		$('#cfgQualifyWin').dialog('close');
	}
	
	<%-- 重新计算统计数据 --%>
	function caculate(data){
		if(data==undefined)data={};
		data.key=currTableName;
		$.get("/${projectName}/dynstat/query/caculate.action",data,function(){
			schTable(currTableName);
		});
	}
	
	<%-- 统计报表 --%>
	function report(){
		document.location="/${projectName}/dynstat/query/report.action?key="+currTableName;
	}
	
	<%-- 统计配置 --%>
	function cfgQualify(){
		QMoveDialog($("#cfgQualifyWin"));
		$('#cfgQualifyWin').dialog('open');
		$('#cfgQualifyWin').get(0).contentWindow.load(currTableName);
		
	}
	
	<%-- 统计分类或汇总配置 --%>
	function cfg(tp){
		QMoveDialog($("#cfgDictWin"));
		$('#cfgDictWin').dialog('open');
		$('#cfgDictWin').get(0).contentWindow.load(currTableName,tp);
		if(tp=="classify"){
		}else{//collect
			
		}
	}
	
	<%-- 更新统计配置 --%>
	function refreshCfg(){
		$.get("/${projectName}/dynstat/query/refreshCfg.action",{key:currTableName},function(data){
			schTable(currTableName);
		});
	}
	</script>
	<style>
	#refresh{position: absolute;top:45px;left:7px;color:#999;width:30px;height:30px;text-align:center;line-height:30px;}
	#refresh:hover{color:#333;}
	</style>
	<table id="statTableGrid" title="统计目录" fitcolumns=true
		data-options="iconCls:'icon-table',singleSelect:true,rownumbers:true,fit:true,striped:true,collapsible:false,url:'/${projectName}/dynstat/config/schStat.action',method:'get',tools:'#tt'">
		<thead>
			<tr>
				<th data-options="field:'checkbox',checkbox:true" ></th>
				<th data-options="field:'name',sortable:false,width:80,formatter:formatname">统计表</th>
			</tr>
		</thead>
	</table>
	<%-- 查询条件设定栏 --%>
	<div id="statTableGridToolbar">
		<div style="padding:0 20px;">
			<a href="javascript:delStatTable()" class="btn btn-danger"><span class="icon-check" style="font-size:16px"></span> <span style="font-size:14px">删除</span></a>&emsp;
		</div>
	</div>
	
	<div id="tt">
		<i class="icon-trash" onclick="javascript:delStatTable()" title="删除" style="cursor:pointer;"></i>
	</div>
</div>
<div data-options="region:'center'">
	<script>
	$(function(){
		$('#datasGrid').datagrid();
	})
	</script>
	<table id="datasGrid" title="数据" fitcolumns=true
		data-options="iconCls:'icon-list',singleSelect:true,rownumbers:true,fit:true,striped:true,toolbar:'#datasGridToolbar',collapsible:true,url:'',method:'get'">
		<thead>
			<tr>
				<th rowspan="2" field="itemid" width="80">Item ID</th>
				<th rowspan="2" field="productid" width="80">Product ID</th>
				<th colspan="4">Item Details</th>
			</tr>
			<tr>
				<th field="listprice" width="80" align="right">List Price</th>
				<th field="unitcost" width="80" align="right">Unit Cost</th>
				<th field="attr1" width="100">Attribute</th>
				<th field="status" width="60" align="center">Stauts</th>
			</tr>
		</thead>
	</table>
	<%-- 查询条件设定栏 --%>
	<div id="datasGridToolbar">
		<div style="padding:0 20px;">
			<a href="javascript:caculate()" class="btn btn-info"><span class="icon-check" style="font-size:16px"></span> <span style="font-size:14px">更新统计</span></a>
			<a href="javascript:report()" class="btn btn-success"><span class="icon-check" style="font-size:16px"></span> <span style="font-size:14px">报表</span></a>
			<a href="javascript:cfgQualify()" class="btn btn-success" id="conditionBtn"><span class="icon-check" style="font-size:16px"></span> <span style="font-size:14px">条件配置</span></a>
			<a href="javascript:cfg('classify')" class="btn btn-success"><span class="icon-check" style="font-size:16px"></span> <span style="font-size:14px">分类配置</span></a>
			<a href="javascript:cfg('collect')" class="btn btn-success"><span class="icon-check" style="font-size:16px"></span> <span style="font-size:14px">汇总配置</span></a>
			<a href="javascript:refreshCfg()" class="btn btn-success"><span class="icon-check" style="font-size:16px"></span> <span style="font-size:14px">更新配置</span></a>
		</div>
	</div>
</div>




<%-- 字典配置面板 --%>
<iframe id="cfgDictWin" src="/${projectName}/dynstat/config/page.action?page=cfg_dict" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#cfgDictButton'" title="统计项配置" style="width:500px;height:500px;padding:5px;top:5000px;z-index:999" scrolling="auto" frameborder="0"></iframe>
<div id="cfgDictButton">
	<a href="javascript:void(0)" onclick="$('#cfgDictWin').get(0).contentWindow.submitForm()" class="easyui-linkbutton" iconCls="icon-ok">确 定</a>
	<a href="javascript:void(0)" onclick="parent.$('#mask').fadeOut('fast');$('#cfgDictWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >取 消</a>
</div>

<%-- 统计数据条件配置面板 --%>
<iframe id="cfgQualifyWin" src="/${projectName}/dynstat/config/page.action?page=cfg_qualify" class="easyui-dialog" data-options="iconCls:'icon-save',buttons: '#cfgQualifyButton'" title="统计条件配置" style="width:500px;height:500px;padding:5px;top:5000px;z-index:999" scrolling="auto" frameborder="0"></iframe>
<div id="cfgQualifyButton">
	<a href="javascript:void(0)" onclick="$('#cfgQualifyWin').get(0).contentWindow.submitForm()" class="easyui-linkbutton" iconCls="icon-ok">确 定</a>
	<a href="javascript:void(0)" onclick="parent.$('#mask').fadeOut('fast');$('#cfgQualifyWin').dialog('close');" class="easyui-linkbutton" iconCls="icon-remove" >取 消</a>
</div>


<div class="easyui-dialog" title="统计图" id="qtrchartPane" style="width:630px;height:430px;top:5000px;">
	<div id="qtrchart" style="width:600px;height:380px;">
	</div>
</div>

<script type="text/javascript">
function clickColumn(){
	if($(this).parents(".datagrid").find("#datasGrid").length==0)return;
	var dg=$('#datasGrid');
	var field=$(this).parents("td").attr("field");
	var rows=dg.datagrid("getRows");
	var title=$(this).find("span").eq(0).text();
	var json={};
	json.title=title;
	json.legend=json.title;
	var xAxis=[],data=[];
	for(var i=0;i<rows.length;i++){
		xAxis.push(rows[i].collect);
		if(rows[i][field]==undefined){
			data.push(0);
		}else{
			data.push(rows[i][field]);
		}
	}
	json.xAxis=xAxis;
	json.series=[{name:title,data:data}];
	_openChart(json);
}
function clickRow(index,field,value){
	var dg=$('#datasGrid');
	var json={};
	json.title=field.collect;
	json.legend=field.collect;
	var xAxis=[],data=[];
	for(var key in field){
		if(key=="collect")continue;
		var opt=$('#datasGrid').datagrid('getColumnOption',key);
		if(opt.hidden)continue;
		xAxis.push(opt.title);//{field: "1", title: "20-25岁", rowspan: 1, colspan: 1, id: "datagrid-td-group3-0-0", …}
		data.push(field[key]);
	}
	json.xAxis=xAxis;
	json.series=[{name:field.collect,data:data}];
	_openChart(json);
}
function _openChart(json){
	json.dom=$('#qtrchart').get(0);
	json.theme="essos";
	new bar1(json);
	QMoveDialog($("#qtrchartPane"));
	$('#qtrchartPane').dialog('open');
}
</script>
</body>
</html>
