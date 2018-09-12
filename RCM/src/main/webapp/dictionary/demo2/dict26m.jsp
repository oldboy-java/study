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
		function fun(index,json){//
			info("select:"+index+":"+json.id+","+json.text);
		}
		function fun2(index,json){//{id:'',text:''}
			info("unselect:"+index+":"+json.id+","+json.text);
		}
		</script>
	</head>
	<body>
		<dc:includeList dictId="TEST_GROUP" name="dqbm" title="Ñ¡ÔñÊé¼®" style="bill_normal_multi" cssWidth="200px" value="8,9" bind="select:fun,unselect:fun2"/>
		
		<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.select('2,a,b')">Select</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.selectRow('5,6,8')">SelectRow</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.selectAll(true)">SelectAll</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dqbmDict.selectAll(false)">unSelectAll</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getValue())">GetValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="info(dqbmDict.getText())">GetText</a>
		</div>
	</body>
</html>
