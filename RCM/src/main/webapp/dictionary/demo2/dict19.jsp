<%@ page language="java" pageEncoding="GB2312"%>
<jsp:directive.page import="com.qtrmoon.dictionary.DictBuffer"/>
<%@ taglib uri="/WEB-INF/tlds/PageFormat.tld" prefix="pageFmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>��ѡǶ�������Ҽ�����</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<pageFmt:import />
		<pageFmt:dictInit/>
		<style>
		span{color:#ddd}
		#catalog{display:none;}
		</style>
		<script>
		function feedBack(id,label){
            alert(id+" "+label);
        }
		</script>
	</head>
	<body>
		��̬����ѡǶ����
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		��̬��Ajax��ѡǶ����
		<div style="height:300px;width:300px;float:left;">
		<pageFmt:dictIncludeAjaxTree dictId="TEST_TREE" expand="1" root="150100"/>
		</div>
		<div style="height:300px;width:300px;float:left;">
		<pageFmt:dictIncludeAjaxTree dictId="TEST_TREE_AJAX"  expand="1" root="150200"/>
		</div>
		<div style="clear:both;"></div>
		
	</body>
</html>
