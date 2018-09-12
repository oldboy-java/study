<html:html>
<%@ page language="java" pageEncoding="GB2312"%>
<jsp:directive.page import="com.qtrmoon.dictionary.DictBuffer"/>
<%@ taglib uri="/WEB-INF/tlds/PageFormat.tld" prefix="pageFmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
	<title>请选择</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
	function loadPage(){
	}
	</script>
</head>
<body>
<%
String dictid = request.getParameter("dictid");
String cfg = request.getParameter("cfg");
if (dictid != null && !dictid.equals("")) {
	DictBuffer.updCache(dictid);
	if("true".equals(cfg)){DictBuffer.updCfgCache(dictid);}//刷配置
	request.setAttribute("info",dictid + "刷新成功！");
}
%>
<form name="dictForm">
字典标识：<input type="text" name="dictid" value="${param.dictid}"/>
刷新字典配置：
<input type="radio" name="cfg" value="true"/>是
<input type="radio" name="cfg" value="false" checked="checked"/>否
<input type="submit" value="刷 新" id="updCache"/>
</form>
${info}
</body>
</html:html>
