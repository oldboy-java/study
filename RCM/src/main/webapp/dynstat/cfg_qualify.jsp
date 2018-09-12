<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/dictionary.tld" prefix="dc"%>
<!DOCTYPE html>
<html>
<head>
	<title>统计项配置</title><!--cfg_dict-->
	<%@include file="/common/include.jsp" %>
	<script>
	var currTableName;
	function load(key){
		currTableName=key;
		var models=parent.conditionJson;
		if(models=="")return;
		var res="";
		for(var i in models){
			var domjson=models[i];
			res+=domjson.info+":<input id='qlf"+domjson.name+"' name='"+domjson.name+"'/><br/>";
		}
		$("#conditionPane").html("");
		$("#conditionPane").append(res);
		for(var i in models){
			var domjson=models[i];
			if(domjson.type=="date"){
				$("#qlf"+domjson.name).datebox();
			}
		}
	}
	
	function submitForm(){
		var data={};
		data.key=currTableName;
		var models=parent.conditionJson;
		for(var i in models){
			var domjson=models[i];
			if(domjson.type=="date"){
				data[domjson.name]=$("#qlf"+domjson.name).datebox("getValue");
			}
		}
		
		$.get("/${projectName}/dynstat/config/cfgDict.action",data,function(treedata){
			parent.caculate(data);
		});
	}
	</script>
</head>
<body>
	<div class="easyui-panel" id="conditionPane" style="padding:5px">
		
	</div>
</body>
</html>
