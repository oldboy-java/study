<html:html>
<%@ page language="java" pageEncoding="GB2312"%>
<jsp:directive.page import="com.qtrmoon.dictionary.DictBuffer"/>
<%@ taglib uri="/WEB-INF/tlds/PageFormat.tld" prefix="pageFmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
	<title>��ѡ��</title>
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
	if("true".equals(cfg)){DictBuffer.updCfgCache(dictid);}//ˢ����
	request.setAttribute("info",dictid + "ˢ�³ɹ���");
}
%>
<form name="dictForm">
�ֵ��ʶ��<input type="text" name="dictid" value="${param.dictid}"/>
ˢ���ֵ����ã�
<input type="radio" name="cfg" value="true"/>��
<input type="radio" name="cfg" value="false" checked="checked"/>��
<input type="submit" value="ˢ ��" id="updCache"/>
</form>
${info}
</body>
</html:html>
