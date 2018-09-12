<%@ page language="java" pageEncoding="GB2312"%>
		<link rel="stylesheet" type="text/css" href="../../easyui1_5/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="../../easyui1_5/themes/icon.css">
		<script type="text/javascript" src="../../easyui1_5/jquery.min.js"></script>
		<script type="text/javascript" src="../../easyui1_5/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../dictionary2.js"></script>
		<script>
		$(function(){
			$("body").append("<div id='info' style='position:absolute;bottom:5px;right:5px;width:300px;height:100px;background:#eef;border:#005 1px dashed;border-radius:5px;padding:20px; -moz-transition:background-color .3s ease-in;-webkit-transition:background-color .3s ease-in;-o-transition:background-color .3s ease-in;-ms-transition:background-color .3s ease-in;transition:background-color .3s ease-in;'></div>");
		});
		function info(v){
			$("#info").text(v);
			$("#info").css("background","#ccf");
			window.setTimeout("$('#info').css('background','#eef')",350);
		}
		</script>
		<style>
		*{
			font-size:12px;
		}
		body {
		    font-family:verdana,helvetica,arial,sans-serif;
		    padding:20px;
		    font-size:12px;
		    margin:0;
		}
		h2 {
		    font-size:18px;
		    font-weight:bold;
		    margin:0;
		    margin-bottom:15px;
		}
		.demo-info{
			padding:0 0 12px 0;
		}
		.demo-tip{
			display:none;
		}
		</style>