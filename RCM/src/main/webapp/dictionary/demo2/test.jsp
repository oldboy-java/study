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
		</script>
	</head>
	<body>
		<input id="xx" class="easyui-textbox" data-options="blue:function(e){alert(e)}"/>
		<script>
		$(function(){
			alert($("#xx").textbox("textbox"))
			$("#xx").textbox("textbox").keydown(function(e){alert(5)});
		});
		</script>
	</body>
</html>
