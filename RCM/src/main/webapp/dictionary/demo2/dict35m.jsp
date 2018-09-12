<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/dictionary.tld" prefix="dc"%>

<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<jsp:include flush="true" page="_import.jsp"></jsp:include>
		<script>
		function fun(json){//{id:'',text:''}
			info(json.id+","+json.text+","+json.checked);
		}
		</script>
	</head>
	<body>
		选择地区：
		<dc:insertTree dictId="TEST_TREE" name="dqbm" style="smart_multi" cssWidth="200px" value="130102,140202" bind="select:fun"/>
		
		<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.select('130000,140000')">Select</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getValue())">GetValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getText())">GetText</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getText(['checked','indeterminate']))">GetAllText</a>
			|
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.expand('140000')">Expand</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.collapse('140000')">Collapse</a>
			|
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.disable()">Disable</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.enable()">Enable</a>
			<br/><br/>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.tree({onlyLeafCheck:true})">onlyLeafCheck:true</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.tree({onlyLeafCheck:false})">onlyLeafCheck:<span style="color:#f60;">false</span></a>
			<br/><br/>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.tree({cascadeCheck:true})">cascadeCheck:<span style="color:#f60;">true</span></a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.tree({cascadeCheck:false})">cascadeCheck:false</a>
		</div>
	</body>
</html>
