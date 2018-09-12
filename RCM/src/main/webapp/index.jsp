<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>教学资源综合管理平台-登录</title>
	<link rel="stylesheet" type="text/css" href="/${projectName}/easyui1_5/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/${projectName}/easyui1_5/themes/style/login.css">
		
	<script type="text/javascript" src="/${projectName}/easyui1_5/jquery.min.js"></script>
	<script type="text/javascript" src="/${projectName}/easyui1_5/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="/${projectName}/easyui1_5/jquery.easyui.min.js"></script>
</head>

<body>
	<div class="header">
		<h2>教学资源综合管理平台</h2>
	</div>
	<div class="easyui-panel">
		<img src="/${projectName}/easyui1_5/themes/style/image/login-bg.png" />
		<div class="loginbox">
			<h3>教学资源综合管理平台</h3>
			<ul class="switcher">
				<li class="selected"><a href="###">登 录</a></li>
				<li id="error" style="display:none;color:#f66"></li> 
			</ul>
			<div id="login">
				<!-- 登录 -->
				<form method="post" action="/${projectName}/sysmanage/login/login.action">
					<div class="item">
						<span class="name-img"><img src="/${projectName}/easyui1_5/themes/style/image/mail.png"></span>
						<input type="text"  id="loginname" name="loginname"  class="name" value="javamao" />
					</div>
					<div class="item">
						<span class="password-img"><img src="/${projectName}/easyui1_5/themes/style/image/pwd.png"></span>
						<input type="password"  id="password" name="password"  class="pwd" value="123456" />
					</div>
					<input type="submit" value="登 录" id="login-button">
				</form>
			</div>
			<div id="signup">
				<!-- 注册 -->
				<form method="post" action="">
				    <input class="easyui-textbox" name="username" value=""/>
					<input type="text" name="loginname1" value="javamao" class="name" placeholder="Email地址" />
					<input type="text" name="loginpassword1" value="yzx1201" class="pwd" placeholder="密码" />
					<input type="submit" value="注 册">
				</form>
			</div>
		</div>
	</div>
	<div class="footer">Copyright 2013-2017 北京华唐中科科技集团股份有限公司 www.cnccss.cn</div>
</body>

<script>
	$(function(){
		
		$('#login-button').click(function (event) {
			event.preventDefault();
			var loginname=$.trim($('#loginname').val());
			var password=$.trim($('#password').val());
			
			if(loginname==""||loginname=="用户名"){
				$('#error').html("请输入用户名").css("display","block");
				return;
			}
			if(password==""){
				$('#error').text("请输入密码").css("display","block");
				return;
			}
			
			$.post("/${projectName}/sysmanage/login/login.action",{'loginname':loginname,'password':password},function(data){
			    data = $.parseJSON(data);
				if(data.code==1){
					document.location.href="/${projectName}/main.jsp";
				}else{
					$('#error').text(data.message).css("display","block");
				}
			});
		});
	});
	</script>
</html>