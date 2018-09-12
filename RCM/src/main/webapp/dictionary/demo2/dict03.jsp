<%@ page language="java" pageEncoding="GB2312"%>
<%@ taglib uri="/WEB-INF/tlds/dictionary.tld" prefix="dc"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
		</script>
	</head>
	<body>
		<table>
			<tr>
				<td>Ñ¡Ôñ£º</td>
				<td><dc:insertList dictId="TEST_LIST" name="dqbm" style="enu_radio" value="3" bind="select:fun"/></td>
			</tr>
		</table>
		<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.select('1')">Select</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getValue())">GetValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getText())">GetText</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getJson())">GetJson</a>
			|
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.disable()">Disable</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.enable()">Enable</a>
		</div>
	</body>
</html>
