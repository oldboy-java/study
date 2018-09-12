<%@ page language="java" pageEncoding="GB2312"%>
<%@ taglib uri="/WEB-INF/tlds/PageFormat.tld" prefix="pageFmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>µ¥Ñ¡Ç¶ÈëÊ÷</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<pageFmt:import />
		<pageFmt:dictInit />
		<style>
		span{color:#ddd}
		#catalog{display:none;}
		</style>
		<script>
		function doNodeEvent(id,info,exp,leaf){
			alert(JsDictBuffer.getDictById("TEST_TREE_EXPAND",id).exp);
        }
		</script>
		<pageFmt:wakeJsDictBuffer dictId="TEST_TREE_EXPAND" />
	</head>
	<body>
		<div style="height:300px">
		<pageFmt:dictIncludeAjaxTree dictId="TEST_TREE_EXPAND" expand="1"/>
		</div>
	</body>
</html>
