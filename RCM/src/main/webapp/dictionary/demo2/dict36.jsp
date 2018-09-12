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
			info(json.id+","+json.text);
		}
		function setValue(text){
			dqbmDict.tar.combobox("reload","/LABDICT/dict?method=insertList_combSmart&dictId=TEST_CORP&q="+text);
			dqbmDict.setValue('3q')
		}
		</script>
	</head>
	<body>
		<dc:insertList dictId="TEST_CORP" name="dqbm" style="combo_smart" cssWidth="200px" value="3m" bind="select:fun"/>
		
		<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.select('8')">Select</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.showPanel()">showPanel</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getValue())">GetValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getText())">GetText</a>
			|
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.setValue('3p')">setValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.setText('北京青亮日用品经营部')">setText</a>
			|
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.disable()">Disable</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.enable()">Enable</a>
		</div>
	</body>
</html>
