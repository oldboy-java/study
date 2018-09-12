<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/tlds/PageFormat.tld" prefix="pageFmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />
	<title>listDictCatalog.jsp</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
	li{line-height:25px;list-style-type:decimal;}
	h1{font-size:14px;margin:2px;padding:0px;margin-left:-30px;}
	a{color:blue}
	a:hover{color:#f60}
	</style>
	<script>
	</script>
</head>
<body>
<ul>
	<li><a href="dictCa.jsp" target="demoFrame">概述</a></li>
	<li><a href="../updCache.jsp?dictid=DQBM" target="demoFrame">刷新字典</a></li>
	<h1>插入列表(dc:insertList)</h1>
	<li><a href="dict03.jsp" target="demoFrame">enu_radio</a></li>
	<li><a href="dict02.jsp" target="demoFrame">enu_checkbox</a></li>
	<li><a href="dict01.jsp" target="demoFrame">combo_normal</a></li>
	<li><a href="dict01m.jsp" target="demoFrame">combo_normal_multi</a></li>
	<li><a href="dict23.jsp" target="demoFrame">combo_group</a></li>
	<li><a href="dict23m.jsp" target="demoFrame">combo_group_multi</a></li>
	<li><a href="dict24.jsp" target="demoFrame">combo_info</a></li>
	<li><a href="dict24m.jsp" target="demoFrame">combo_info_multi</a></li>
	<li><a href="dict25.jsp" target="demoFrame">combo_grid</a></li>
	<li><a href="dict25m.jsp" target="demoFrame">combo_grid_multi</a></li>
	<li><a href="dict36.jsp" target="demoFrame">combo_smart</a></li>
	<li><a href="dict37.jsp" target="demoFrame">combo_rein</a></li>
	
	<h1>嵌入列表(includeList)</h1>
	<li><a href="dict26.jsp" target="demoFrame">bill_normal</a></li>
	<li><a href="dict26m.jsp" target="demoFrame">bill_normal_multi</a></li>
	<li><a href="dict28.jsp" target="demoFrame">bill_group</a></li>
	<li><a href="dict28m.jsp" target="demoFrame">bill_group_multi</a></li>
	<li><a href="dict29.jsp" target="demoFrame">bill_info</a></li>
	<li><a href="dict29m.jsp" target="demoFrame">bill_info_multi</a></li>
	<li><a href="dict27.jsp" target="demoFrame">bill_grid</a></li>
	<li><a href="dict27m.jsp" target="demoFrame">bill_grid_multi</a></li>
	<li><a href="dict30.jsp" target="demoFrame">bill_checkbox</a></li>
	
	<h1>插入树(dc:insertTree)</h1>
	<li><a href="dict31.jsp" target="demoFrame">synch_single</a></li>
	<li><a href="dict31m.jsp" target="demoFrame">synch_muti</a></li>
	<li><a href="dict34.jsp" target="demoFrame">asynch_single</a></li>
	<li><a href="dict34m.jsp" target="demoFrame">asynch_muti</a></li>
	<li><a href="dict35.jsp" target="demoFrame">smart_single</a></li>
	<li><a href="dict35m.jsp" target="demoFrame">smart_muti</a></li>
	<h1>嵌入树(dc:includeTree)</h1>
	<li><a href="dict32.jsp" target="demoFrame">synch_single</a></li>
	<li><a href="dict32m.jsp" target="demoFrame">synch_muti</a></li>
	<li><a href="dict33.jsp" target="demoFrame">asynch_single</a></li>
	<li><a href="dict33m.jsp" target="demoFrame">asynch_muti</a></li>
	
	<!-- <h1>-----------------------</h1>
	<h1>嵌入树</h1>
	<li><a href="dict14.jsp" target="demoFrame">多选下拉</a></li>
	
	<li><a href="dict10.jsp" target="demoFrame">分离树</a></li>
	<li><a href="dict11.jsp" target="demoFrame">约束树</a></li>
	
	<li><a href="dict16.jsp" target="demoFrame">多选嵌入树的右键操作</a></li>
	
	<h1>其他</h1>
	<li><a href="dict09.jsp" target="demoFrame">智能匹配树</a></li>
	<li><a href="dict19.jsp" target="demoFrame">动态根嵌入树</a></li>
	<li><a href="dict20.jsp" target="demoFrame">扩展信息</a></li>
	
	<h1>维护</h1>
	<li><a href="../dict.do?method=schTreeDict&dictId=TEST_TREE_EDIT&group=_catalog_demo.xml" target="demoFrame">库字典维护</a></li>
	<li><a href="../dict.do?method=schTreeDict&dictId=sex&group=_catalog_demo.xml" target="demoFrame">XML字典维护</a></li>
	<li><a href="test.jsp" target="demoFrame">TEST</a></li> -->
</ul>
</body>
</html:html>
