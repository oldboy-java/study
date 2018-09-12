<%@ page language="java" pageEncoding="GB2312"%>
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
			info("select:"+json.id+","+json.text);
		}
		function fun2(json){//{id:'',text:''}
			info("unselect:"+json.id+","+json.text);
		}
		</script>
	</head>
	<body>
		选择地区：
		<dc:insertList dictId="TEST_GROUP" name="dqbm" style="combo_normal_multi" cssWidth="300px" value="a,b,c" bind="select:fun,unselect:fun2"/>
		
		<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.select('5')">Select</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.showPanel()">showPanel</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getValue())">GetValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getText())">GetText</a>
			|
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.disable()">Disable</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.enable()">Enable</a>
			|
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.editable(true)">Editable</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.editable(false)">unEditable</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.setValue('资本论')">SetValue</a>
		</div>
	</body>
</html>
