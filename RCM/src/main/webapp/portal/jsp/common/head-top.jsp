<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>教学资源平台</title>
    <meta name="keywords" content="教学资源平台">
	<meta name="description" content="教学资源平台">
	<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/portal/img/favicon.ico" media="screen" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/portal/js/lib/layui/css/layui.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/portal/fonts/fonts.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/portal/css/video-js.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/portal/css/style.css">
  	<script src="<%=request.getContextPath()%>/portal/js/lib/jquery.min.js"></script>
    <script type="text/javascript">
       <%-- 资源文件下载 --%>
    function downloadzy(id,_jf){
    	var _login = checkLogin();
    	if(_login.login==false){
    		$('.login').click();
    		return;
    	}
    	if(_login.jf < _jf){
    		layer.msg('您的积分不足'+_jf+'分，无法下载', {icon: 0});
    		return;
    	}
    	window.location.href="/${projectName}/portal/zygl/resource/download.action?id="+id+'&jf='+_jf;
    }

    /* 登录校验URL */
    var checkLoginUrl = '/${projectName}/portal/zygl/login/checkLogin.action';
    
    <%--资源收藏地址 --%>
    var favUrl = "/${projectName}/portal/zygl/resource/collectzy.action";
    
    <%--资源点赞地址 --%>
    var likeUrl = "/${projectName}/portal/zygl/resource/likezy.action";
    
    <%--资源评论地址 --%>
    var commentUrl = "/${projectName}/portal/space/zypl/updZypl.action";
    
    var applyUrl="/${projectName}/portal/space/zypl/replyZypl.action";
    </script>
