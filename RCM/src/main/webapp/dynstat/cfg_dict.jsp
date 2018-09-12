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
	var currType;
	function load(key,type){
		currTableName=key;
		currType=type;
		$.get("/${projectName}/dynstat/config/schCfgDict.action",{"key":key,"type":type},function(treedata){
			treedata=eval("("+treedata+")");
			$('#tt').tree({
			    data:eval(treedata.data),
			    method:'get',
			    animate:true,
			    checkbox:true
			});
		});
	}
	
	function submitForm(){
		var nodes = $('#tt').tree('getChecked');
		var s = '';
		for(var i=0; i<nodes.length; i++){
			if (s != '') s += ',';
			s += nodes[i].id;
		}
		$.get("/${projectName}/dynstat/config/cfgDict.action",{"key":currTableName,"type":currType,"dictConfig":s},function(treedata){
			parent.schTable();
		});
	}
	</script>
</head>
<body>
	<div class="easyui-panel" style="padding:5px">
		<ul id="tt"></ul>
	</div>
	<script type="text/javascript">
		function getChecked(){
			var nodes = $('#tt').tree('getChecked');
			var s = '';
			for(var i=0; i<nodes.length; i++){
				if (s != '') s += ',';
				s += nodes[i].text;
			}
			alert(s);
		}
	</script>
</body>
</html>
