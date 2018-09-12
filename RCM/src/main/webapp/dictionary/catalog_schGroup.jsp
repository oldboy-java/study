<%@ page language="java" pageEncoding="GB2312"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-pagefmt" prefix="pageFmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	

	<title>listDictCatalog.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<pageFmt:import />
	<style>
	ul{margin:0px;padding:0px;}
	ul li{line-height:25px;list-style:none;width:100%;padding-left:15px;background:url(imgs/bk_schgroup0.gif) no-repeat;margin:1px;}
	ul li a{text-decoration:none;color:blue;}
	ul li a:hover{color:#f60};
	</style>
	<script>
	var curr;
	function loadPage(){
		$("a").click(function(){
			if(curr!=undefined){
				curr.css("background","url(imgs/bk_schgroup0.gif) no-repeat");
			}
			curr=$(this).parent();
			$(this).parent().css("background","url(imgs/bk_schgroup1.gif) no-repeat");
			parent.dictFrame.document.location="/${projectName}/dictEditor/dict.do?method=schCatalog&group="+$(this).attr("group");
		}).focus(function(){
			$(this).blur();
		});
	}
	</script>
</head>
<body>
	<ul>
		<logic:iterate id="row" name="list">
		<li>
			<a href="javascript:void(0)" group="${row.id}">&nbsp;${row.label}</a>
		</li>
		</logic:iterate>
	</ul>
</body>
</html:html>
