<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/dictionary.tld" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<title>统计表创建向导</title><!--stat_wizard-->
	<%@include file="/common/include.jsp" %>
	<style>
	a.pin{
		transform: rotate(30deg);
	    display: inline-block;
	    color: RED;
	}
	input{height: 24px;line-height: 24px}
	</style>
	<script>
	var TABLENAME;
	$(function(){
		$(":radio[name='caculate']").click(function(){
			if($(this).val()=="sum"){
				$("#sumTr").show();
			}else{
				$("#sumTr").hide();
			}
		});
		$("input").blur(buildSql);
		$("#sql").focus(buildSql);
	})
	var COLS;
	function load(tableName,key){
		TABLENAME=tableName;
		$.get("/${projectName}/dyntable/query/schTableCols.action",{'tableName':tableName},function(data){
			var cols=eval("("+data+")");
			$('#classify').combobox({
			    data:cols,
			    valueField:'id',
			    textField:'text',
			    onSelect:function(param){
			    	$('#classifyDict').val(param.dict);
			    }
			});
			$('#collect').combobox({
			    data:cols,
			    valueField:'id',
			    textField:'text',
			    onSelect:function(param){
			    	$('#collectDict').val(param.dict);
			    }
			});
			$('#sumcol').combobox({
			    data:cols,
			    valueField:'id',
			    textField:'text'
			});
			COLS=cols;
			if(key!=undefined&&key!=""){
				$('#_form').form('load','/${projectName}/dynstat/config/vieStat.action?key='+key);
			}else{
				$("#enrol").val(tableName);
			}
		});
	}
	
	function buildSql(){
		var cac=$(":radio[name='caculate']:checked").val();
		var cacsql="";
		if(cac=="sum"){
			cacsql="sum("+$("#sumcol").combo("getValue")+")";
		}else{
			cacsql="count(1)";
		}
		var vcolloct=$("#collect").combo("getValue");
		var vclassify=$("#classify").combo("getValue");
		var sql="select "+vcolloct+" as collect,"+vclassify+" as classify,"+cacsql+" as amount from "+TABLENAME+" group by "+vcolloct+","+vclassify;
		$("#sql").val(sql);
	}

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
	<form id="_form" name="_form" method="post" action="/${projectName}/dynstat/config/updStat.action">
	<input id="key" name="key" type="hidden"/>
	<input id="enrol" name="enrol" type="hidden"/>
	<table id="functionGrid">
		<tr>
			<tr><td class='label'>统计名称：</td><td><input id="name" name="name" class="easyui-textbox" data-options="required:true"/></td></tr>
			
			<tr><td class='label'>分类列：</td><td><input id="classify" name="classify"/></td></tr>
			<tr><td class='label'>分类列字典：</td><td><input id="classifyDict" name="classifyDict"/></td></tr>
			
			<tr><td class='label'>汇总列：</td><td><input id="collect" name="collect"/></td></tr>
			<tr><td class='label'>汇总列字典：</td><td><input id="collectDict" name="collectDict"/></td></tr>

			<tr><td class='label'>计算方式：</td><td>
				<label><input type="radio" name="caculate" value="sum" checked="checked" style="vertical-align: middle;"/>求和</label>
				<label><input type="radio" name="caculate" value="count" style="vertical-align: middle;"/>计数</label>
			</td></tr>
			<tr id="sumTr"><td class='label'>求和字段：</td><td><input id="sumcol" name="sumcol"/></td></tr>
			<tr><td class='label'>sql语句：</td><td><textarea id="sql" name="sql" rows="8" style="width:300px"></textarea></td></tr>
		</tr>
	</table>
	</form>
</body>
</html>
