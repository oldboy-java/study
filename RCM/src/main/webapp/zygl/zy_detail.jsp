<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>教学资源平台</title>
	<meta name="keywords" content="教学资源平台">
	<meta name="description" content="教学资源平台">
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" media="screen" />
    <!--<link rel="stylesheet" href="js/lib/layui/css/layui.css">-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/portal/css/video-js.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/portal/css/style.css">
  </head>
  <body class="huibg">
  <!--内容-->
  <div class="all-content" style="text-align:center">
    <div class="details-left" style="margin-top:50px;">
       <!--  视频播放 -->
        <div class="details-body-video" style="display:none">
          <div class="video-contenr">
            <video id="video_1" class="video-js vjs-default-skin vjs-big-play-centered" controls preload="none"  poster="<%=request.getContextPath()%>/portal/img/guodu.png">
              <source src="<%=request.getContextPath()%>/file/getFileBinnary.action?filename=${zy.zydz}" type='video/mp4' />
              <p class="vjs-no-js">
                	 您的浏览器版本过低，请使用ie9以上浏览器、火狐浏览器或者谷歌浏览器查看该页面
              </p>
            </video>
          </div>
          </div>
         <!-- 文档预览   -->
        <div class="details-body"> </div>
        
        <!-- 不支持预览 -->
        <div class="details-worr">
                          文件格式不支持预览，请下载使用
        </div>
        
 </div>
  <!--内容 end-->
    <script src="<%=request.getContextPath()%>/portal/js/lib/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/portal/js/lib/layui/layui.all.js"></script>
    <script src="<%=request.getContextPath()%>/portal/js/lib/video.min.js"></script>
    <script src="<%=request.getContextPath()%>/portal/js/all.js"></script>
  </body>

<!-- 文档、视频在线观看处理 -->
<c:choose>  
   <c:when test="${zy.hzm!='.mp4'&& zy.hzm!='.flv'&& zy.hzm!='.avi' && zy.hzm!='.wmv' && zy.hzm!='.mov' && zy.zhcg ==1}"> 
   		<script type="text/javascript">
   			$('.details-body-video').hide();
   			$('.details-worr').hide();
   			$('.details-approve').hide();
	    	$(function(){
	    		var zydz = '${zy.zydz}';	
        		var pdfUrl = zydz.substring(zydz.lastIndexOf("/")+1,zydz.lastIndexOf(".")).concat(".pdf");
	    		/* $(".details-body").append("<iframe src='/${projectName}/portal/zygl/resource/getPdf.action?filename=${zy.zydz}' id='iframe' name='iframe' style='width:100%;' frameborder='0' scrolling='no' height='730px' onreadystatechange='myLoad(this)'></iframe> "); */
        		 //$(".details-body").append("<iframe src='${rrsHost}/zy/"+pdfUrl+"' id='iframe' name='iframe' style='width:100%;' frameborder='0' scrolling='no' height='730px' onreadystatechange='myLoad(this)'></iframe> "); */
        		$(".details-body").append("<iframe src='/${projectName}/js/pdfjs/web/viewer.html?file=/${projectName}/portal/zygl/resource/getPdfStream/"+pdfUrl+".action' id='iframe' name='iframe' style='width:100%;' frameborder='0' scrolling='no' height='730px' onreadystatechange='myLoad(this)'></iframe> ");
	    	});
	    	
   		 </script>
   </c:when>  
   
   
   <c:when test="${zy.hzm!='.mp4' && zy.hzm!='.flv'&& zy.hzm!='.avi' && zy.hzm!='.wmv' && zy.hzm!='.mov' && zy.zhcg ==0}"> 
   		<script type="text/javascript">
   			$('.details-body-video').hide();
   			$(".details-body").hide();
   			$('.details-approve').hide();
	    	$('.details-worr').show();
   		</script>	
   </c:when>  
   
   
    <c:when test="${zy.hzm!='.doc' &&  zy.hzm!='.docx' && zy.hzm!='.ppt' && zy.hzm!='.pptx' && zy.hzm!='.xls' && zy.hzm!='.xlsx' && zy.hzm!='.mp4' && zy.zhcg==0 }"> 
   		<script type="text/javascript">
   			$('.details-body-video').hide();
   			$(".details-body").hide();
   			$('.details-worr').show();
	    	$('.details-approve').hide();
   		</script>	
   </c:when>
   
   <c:otherwise>
     <script type="text/javascript">
     	 $(function(){
     		$('.details-body-video').show();
     		$(".details-body").hide();
     		$('.details-worr').hide();
     		$('.details-approve').hide();
     	 }); 
     </script>  
   </c:otherwise>  
</c:choose>  
</html>