<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>教学资源综合管理平台</title>
	<meta name="keywords" content="教学资源综合管理平台">
	<meta name="description" content="教学资源综合管理平台">
	<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/portal/favicon.ico" media="screen" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/portal/js/lib/layui/css/layui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/portal/fonts/fonts.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/portal/css/style.css">
  </head>
   <body class="xiaobg">
   <div class="manageform">
       <form class="layui-form resource-form" action="/${projectName}/portal/zygl/login/updPass.action">
		  <div class="layui-form-item">
			   <label class="layui-form-label">密码：</label>
			   <div class="layui-input-block">
				   <input type="password" name="password"  placeholder="密码" autocomplete="off" class="layui-input" lay-verify="required">
			   </div>
		   </div>
		   <div class="layui-form-item">
			   <label class="layui-form-label">重复密码：</label>
			   <div class="layui-input-block">
				   <input type="password" name="repassword" placeholder="重复密码(必须与第一次输入密码一致)" autocomplete="off" class="layui-input"  lay-verify="rePassword">
			   </div>
		   </div>
		   <div class="policy-button">
			   <button class="layui-btn info-submit" lay-submit="" lay-filter="info">确定</button>
			   <button class="layui-btn policy-qu" onclick="infoclose()">取消</button>
		   </div>
       </form>
   </div>
   <script src="<%=request.getContextPath()%>/portal/js/lib/jquery.min.js"></script>
   <script src="<%=request.getContextPath()%>/portal/js/lib/layui/layui.all.js"></script>
   <script src="<%=request.getContextPath()%>/portal/js/all.js"></script>
   </body>
</html>