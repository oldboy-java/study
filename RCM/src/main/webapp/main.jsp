<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>教学资源综合管理平台</title>
	<%@include file="/common/include.jsp" %>
	<style>
	.panel-body{overflow:hidden}
	
	.logo{
		background:url('/${projectName}/common/img/huatang.png') no-repeat 0 center;
		width:220px;
		height: 70px;
		float:left;
	}
	
	#module {
		margin:0px;
		height: 70px;
		padding:0 0 0 10px;
		display: inline-block;
		justify-content:flex-start;
	}
	.telBar{
		display: inline-block;
   		margin: 10px;
    	height: 50px;
    	background: #fff;
    	border-radius: 6px;
	}
	.telBar .barList {
    	text-align: center;
    	float: left;
    	cursor: pointer;
    	margin: 10px 8px 0;
    	overflow:hidden;
	}
	.telBar .barList div {
		margin: 0 8px;
	}
	#telBar img {
		width:22px;
		height: 22px;
	}
	#module li {
		padding: 0 8px;
		text-align:center;
		float:left;
		cursor:pointer;
		border-top-color:#293c55;
		border-top-style:solid;
		border-top-width:5px;
		list-style-type:none;
		background:#293c55;
		transition: background 1s,border-top-color 1s;
		-moz-transition: background 1s,border-top-color 1s;	/* Firefox 4 */
		-webkit-transition: background 1s,border-top-color 1s;	/* Safari 和 Chrome */
		-o-transition: background 1s,border-top-color 1s;	/* Opera */
	}
	#module li:hover{background:#162436;border-top-color:#e43c59;}
	#module li a {
		display: block;
		padding-top: 13px;
    	height: 52px;
    	color: white;
    	line-height: 18px;
    	text-decoration: none;
    }
	#module img{
		width:25px;
		height: 25px;
	}	
	#menu{background:#293c55;border:0;}
	#menu div{background:#293c55;line-height:50px;height:50px;width:100%;display:block;padding-left:30px;font-size:14px;
		border-left-color:#293c55;border-left-style:solid;border-left-width:5px;cursor:pointer;
		transition: background 1s,border-left-color 1s;
		-moz-transition: background 1s,border-left-color 1s;	/* Firefox 4 */
		-webkit-transition: background 1s,border-left-color 1s;	/* Safari 和 Chrome */
		-o-transition: background 1s,border-left-color 1s;	/* Opera */
	}
	#menu div a{color:#cccccc;text-decoration:none;}
	#menu div:hover{background:#162436;border-left-color:#e43c59;}
	#menu img{width:20px;vertical-align:middle;margin-right:5px;}
	#menu i{color: white;padding: 0 10px 0 0;font-size:16px;}
	
	#mover{position:absolute;top:-30px;right:5px;width:150px;height:20px;z-index:999;
	    background: white;
	    font-weight: bold;
	    text-align: center;
	    line-height: 20px;
	    border-radius: 5px;
	    opacity:0;}
	#info-display {
		position:absolute;
		top: 2px;
		right: 5px;
		z-index:9;
		color: #fff;
		overflow: hidden;
	}
	#info-display li{
		list-style: none;
		float: left;
		margin: 0 4px;
		text-align: center;
		display: block;
	}
	#info-display li:last-child{
		cursor: pointer;
	}
	
	/*2017-11-21*/
	.sprites_photoss{float:left;}
	/*.panel-body {
    	padding: 0 !important;
    	height: 70px !important;
	}*/
	
	
/* 	#telpanel { */
/* 		position:absolute;width:300px;height:60px;top:0px;left:240px;z-index:9;line-height: 60px; */
/* 	} */
/* 	#telpanel a{ */
/* 		color: white; */
/* 	    font-size: 20px; */
/* 	    /* margin: 10px; */ */
/* 	    margin: 10px 10px 10px; */
/* 	} */
	#info-display{ }
	</style>
	<script>
	$(function(){
		//加载Module
		$.get("/${projectName}/sysmanage/module/schMyModule.action",function(data){
			if(data!=""){
				var list=eval("("+data+")").rows;
				var res="";
				for(var i=0;i<list.length;i++){
					res+="<li onclick=\"javascript:openModule("+list[i].id+",this)\"><a><img src='/${projectName}"+list[i].icon+"'/><br/>"+list[i].name+"</a></li>";
				}
				$("#module").html(res);
			}
			window.setTimeout(function() {
				$("#module li").eq(0).click();
			}, 500);
		});
		$("#tabdiv").bind('contextmenu',function(e){
			e.preventDefault();
			$('#mm').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
		});
		//
		$("#logoutbtn").click(function(){
			$.get("/${projectName}/sysmanage/login/logout.action",function(data){
				document.location="/${projectName}/index.jsp";
			});
		});
	});
	var currTopMenu;
	function openModule(moduleid,topMenu){
		$.get("/${projectName}/sysmanage/module/schMenuByModule.action",{id:moduleid},function(data){
			if(data!=""){
				var list=eval("("+data+")").rows;
				var res="";
				for(var i=0;i<list.length;i++){
					var fun=list[i];
					var img="";
					if(fun.picico!=""){
						if(fun.picico.indexOf("class:")==0){
							img="<i class='"+fun.picico.substring(6)+"'></i>";
						}else{
							img="<img src='/${projectName}"+fun.picico+"'/>";
						}
					}
					res+="<div info='"+fun.name+"' onclick=\"javascript:addTab('"+fun.name+"','/${projectName}/"+fun.link+"',this)\">"+img+"<a>"+fun.name+"</a></div>";
				}
				$("#menu").html(res);
				
				//高亮顶部菜单
				if(currTopMenu!=undefined)currTopMenu.css({"background":"","border-top-color":""});
				currTopMenu=$(topMenu);
				currTopMenu.css({"background":"#000","border-top-color":"#e43c59"});
				
				window.setTimeout(function() {
					$("#menu div").eq(0).click();
				}, 500);
			}
		});
	}
	
	function addTab(title, url,leftMenu){
		if ($('#tabdiv').tabs('exists', title)){
			$('#tabdiv').tabs('select', title);
		} else {
			var content = '<iframe scrolling="no" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
			$('#tabdiv').tabs('add',{
				title:title,
				content:content,
				closable:true
			});
		}
	}
	//高亮左侧菜单
	var currLeftMenu;
	function hlLeftMenu(leftMenu){
		if(currLeftMenu!=undefined)currLeftMenu.css({"background":"","border-left-color":""});
		currLeftMenu=$(leftMenu);
		currLeftMenu.css({"background":"#000","border-left-color":"#e43c59"});
	}
	//关闭所有的tab  
    function closeTbs(tp){
		var tab = $('#tabdiv').tabs('getSelected');
		var title = tab.panel('options').title;
		if(tp=="c"){
			$('#tabdiv').tabs('close', title);
		}else{
			var tiles = new Array();
			var tabs = $('#tabdiv').tabs('tabs');
			var len =  tabs.length;
			if(len>0){
				for(var j=0;j<len;j++){
				    var a = tabs[j].panel('options').title;
				    tiles.push(a);
				}
				if(tp=="o"){
					for(var i=0;i<tiles.length;i++){
						if(title!=tiles[i]){
						    $('#tabdiv').tabs('close', tiles[i]);
						}
					}
				}else{
					for(var i=0;i<tiles.length;i++){
					    $('#tabdiv').tabs('close', tiles[i]);
					}
				}
			}
		}
    }
    function cd() {
        var $easyuiTheme = $('#easyuiTheme');
        var url = $easyuiTheme.attr('href');
        $easyuiTheme.attr('href', '/${projectName}/easyui1_5/themes/default/easyui.css');
    };
    
    //点击tab头
    function tabclick(title,index){
    	var leftMenu=$("div[info='"+title+"']");
    	if(leftMenu.length>0)hlLeftMenu(leftMenu);
    }
	
	// 根据手机号查询ID
	function showOrderByPhone(phone){
		var id = 0;
		$.ajax({
			type:"POST",
			url:'/${projectName}/crm/trainBill/schTrainBill.action',
			data:{contact:phone},
			async : false,
			success:function(data){
				if(data!=""){
					var list=eval("("+data+")").rows;
					alert(list);
					var res="";
					for(var i=0;i<list.length;i++){
						if(id == 0){
							id = list[i]._oper;
						}
					}
				}
			}
		});
		alert(id);
		// 展示客户弹出页面
		updTrainBill(id,phone);
	}
	
<%-- 打开修改页面，点击记录行的"修改"链接时调用 --%>
	function updTrainBill(id,phone){
		QMoveDialog($("#trainBillEditWin"));
		$('#trainBillViewWin').dialog('close');
		$('#sendMailWin').dialog('close');
		$('#trainBillEditWin').dialog('open');
		$('#trainBillEditWin').get(0).contentWindow.load(id);
// 		$('#trainBillEditWin').get(0).contentWindow.setPhone(phone);
	} 
	
	// 保存弹框信息
	function saveOrder(){
		$.messager.confirm('提示','确定保存吗？',function(r){
			if(r){
				$('#customerServiceEditWin').get(0).contentWindow.submitForm();
				$('#customerServiceEditWin').dialog('close');
			}
		});
	}
	
	</script>
	
	<script type="text/javascript">
	    var urlIp="http://192.168.1.161:8080";
	    var number=1014;
		function busy(){
			command(urlIp+"/fsser/fscfg/softTel.action?command=busy&number="+number);
		}
		function unbusy(){
			command(urlIp+"/fsser/fscfg/softTel.action?command=unbusy&number="+number);
		}
		function command(url){
			$.ajax(url,{
				dataType:'jsonp',
				crossDomain:true,
				//jsonp:'callback',
				success:function(data) {
					
				}
			});
			
		}
	</script>
	
	
</head>
<body class="easyui-layout">
	
	<div data-options="region:'north',border:false" style="height:70px;background:#293c55;padding:0;">
		<div class="logo"></div>
		<ul id="module"></ul>
	</div>
	<div id="info-display">
		<ul>
			<li id="logoutbtn"><i class="icon-signout"></i>退出</li>
		</ul>
	</div>
	
	<div data-options="region:'west',split:true" style="width:200px;padding:0px;border-right:0;" id="menu"></div>
	
<!-- 	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div> -->
	<div data-options="region:'south',border:false" style="height:30px;line-height:30px;padding-left:30px;text-align:center;background:#EEE;padding:0px;">Copyright 2013-2017 北京华唐中科科技集团股份有限公司  <a href="www.cnccss.cn" target="_blank">www.cnccss.cn</a>
	</div>
	<div data-options="region:'center'">
		<div id="tabdiv" class="easyui-tabs" data-options="fit:true,border:false,plain:true" fit="true">
		</div>
	</div>
</body>
</html>
