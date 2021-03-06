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
		function fun2(json){//{id:'',text:''}
			info(json.id+","+json.text+","+json.state);
		}
		function fun3(json){//{id:'',text:''}
			info(json.id+","+json.text+","+json.state);
		}
		</script>
	</head>
	<body>
		选择地区：
		<dc:includeTree dictId="TEST_TREE" name="dqbm" style="synch_single" value="130108" dynroot="130100" cssWidth="200px" bind="select:fun,expand:fun2,collapse:fun3"/>
		
		<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.select('130104')">Select</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getValue())">GetValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getText())">GetText</a>
			|
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.expand('130100')">Expand</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.collapse('130100')">Collapse</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.expandTo('130101')">ExpandTo</a>
			|
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.disable()">Disable</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.enable()">Enable</a>
		</div>
	</body>
</html>
