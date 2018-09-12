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
    <script src="<%=request.getContextPath()%>/portal/js/lib/jquery.1.8.3.min.js"></script>
 	<script type="text/javascript" src="<%=request.getContextPath()%>/portal/js/lib/image.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/portal/js/lib/ajaxfileupload.js"></script>
  
  </head>
  <body class="resource-bg">
    <form class="layui-form resource-form" action="#" method="post" enctype="multipart/form-data" id="form" onsubmit="return false;">
    	<input type="hidden" name="id" id="id" value="${zy.id }"/>
       <div class="layui-form-item">
           <label class="layui-form-label">资源名称<font color=red>*</font>：</label>
           <div class="layui-input-inline">
             <input type="text" name="zymc"  autocomplete="off"  class="layui-input" lay-verify="required" value="${zy.zymc }">
           </div>
           <label class="layui-form-label">资源类型<font color=red>*</font>：</label>
           <div class="layui-input-inline">
             <select id="ssxkid" name="ssxkid" lay-filter="aihao" lay-verify="required">
               <option value="">-请选择-</option>
               <c:forEach items="${xklbs}" var="x">
               	<option value="${x.id}" <c:if test="${zy.ssxkid==x.id}"> selected</c:if>    >${x.xkmc}</option>
               </c:forEach>
             </select>
           </div>
       </div>  
       <div class="layui-form-item">
         <label class="layui-form-label">作者：</label>
         <div class="layui-input-inline">
           <input type="text" name="zz"  autocomplete="off"  class="layui-input" value="${zy.zz }" >
         </div>
         <label class="layui-form-label">资源来源：</label>
         <div class="layui-input-inline">
           <input type="text" name="zyly" lay-verify="title" autocomplete="off"  class="layui-input" value="${zy.zyly }">
         </div>
       </div>
       <div class="layui-form-item">
         <label class="layui-form-label">共享与否<font color=red>*</font>：</label>
         <div class="layui-input-inline">
           <input  type="radio" name="zyzt" value="3" title="共享"  <c:if test="${zy.zyzt==3}"> checked</c:if>  >
           <input  type="radio" name="zyzt" value="1" title="不共享" <c:if test="${zy.zyzt==1}"> checked</c:if>>
         </div>
       </div>
       
        <div class="layui-form-item">
         <label class="layui-form-label">标签(tag)：</label>
         <div class="layui-input-inline" style="width:80%">
           <input type="text"  id="tag" name="tag"  autocomplete="off"  class="layui-input" value="${zy.tag }" >
         </div>
       </div>
        <div id="upload" class="resource-upload">
           <a href="javascript:void(0)" class="uploadfilebtn" onclick="upload();">选择文件</a> 
             <ul class="filelist">
                              
             </ul>
       </div>
       
       <div class="upload-xuzhi">
       		<p><b>上传须知</b></p>
       		<dd>* 资源格式仅支持pdf、doc、docx、ppt、pptx、xls、xlsx、mp4、flv、avi、mov、wmv</dd>
       		<dd>* 资源文件大小不超过500M</dd>
       		<dd>* 多个标签之间用空格隔开，不超过50个字符</dd>
       		<dd>* 上传一份资源，审核通过后可获得5积分</dd>
       </div>
       
       <div class="policy-button">
         <button class="layui-btn info-submit" type="submit" lay-submit="" lay-filter="resourceAdd">保存</button>
         <button class="layui-btn policy-qu" onclick="infoclose()">取消</button>
       </div>
     </form>
     
     <script src="<%=request.getContextPath()%>/portal/js/lib/layui/layui.all.js"></script>
    <%--  <script type="text/javascript" src="<%=request.getContextPath()%>/portal/js/lib/jquery.html5uploader.js"></script> --%>
    <script src="<%=request.getContextPath()%>/portal/js/all.js"></script>
    <script src="<%=request.getContextPath()%>/js/way-upload/way-upload.js" type="text/javascript"></script>
  </body>
  
  
<c:if test="${not empty zy}">
	<script>
	$(function(){
 		var liHtml = createFileLi('${zy.zydz}','${zy.wjmc}','${zy.hzm}','${zy.wjdx}','${zy.fmlj}');
 		$('.filelist').html(liHtml);
 	});
	</script>
</c:if>

<script>
  function upload(){
	 var li_count = $(".filelist").find("li").length;
	 if(li_count == 1) {
		 layer.msg('只能添加单个资源!', {icon: 2});
		 return;
	 } 
	  var setting = {
	  	'path' : '/RCM/js/way-upload/',
	  	'fileType' : ['xls','xlsx','ppt','pptx','doc','docx','mp4','pdf','flv','avi','mov','wmv'],
	  	'maxSize':'500',
	  	'url' : '/RCM/file/upload.action',
	  	'count' : 1
	  };
	 
     WAYUPLOAD.show(setting);
  }
  //此方法会在点击完成的时候被调用，data返回的是数组
  WAYUPLOAD.callback = function(data) {
	var html='';
  	for(var i =0;i<data.length;i++){
  		var zydz = data[i].filePath;
  		var wjmc = data[i].fileName;
  		var hzm = data[i].fileType;
  		var wjdx = data[i].fileSize;
  		html+=createFileLi(zydz, wjmc, hzm, wjdx,'');
  	}
  	$(".filelist").html($(".filelist").html()+html);
  	
  }
  
//删除文件
function delFile(obj){
  $(obj).parent().parent().parent().remove();
}
 
//创建资源上传Li
function createFileLi(zydz,wjmc,hzm,wjdx,fmlj){
	var html='';
	var li_id = zydz.substring(zydz.lastIndexOf("/")+1,zydz.lastIndexOf("."));
	html+='<li id="'+li_id+'"><input type="hidden"  name="fmlj" value="'+fmlj+'"/><input type="hidden"  name="zydz" value="'+zydz+'"/><input type="hidden"  name="wjmc" value="'+wjmc+'"/><input type="hidden"  name="hzm" value="'+hzm+'"/><input type="hidden"  name="wjdx" value="'+wjdx+'"/><div class="upload-img">';
	if(fmlj!=undefined && fmlj!=''){
		html+='<img src="${fileServer}/file/'+fmlj+'" class="upload-bg">';	
	}else {
		html+='<img src="/RCM/portal/img/fm.png" class="upload-bg">';
	}
    html+='</div><div class="upload-right">';
    html+='<p class="filename">'+wjmc+'<span class="progressnum">（'+wjdx+'）</span></p>';
    html+='<div class="upload-p"><span class="upload-input"><a class="upload-fm">上传封面</a><input type="file" name="file" id="file" onchange=coverUpload("'+li_id+'") accept="image/jpeg,image/jpg,image/png"></span><a class="delfilebtn" onclick="delFile(this);">删除</a></div></div> </li>';
	return html;
}

//上传封面
function coverUpload(li_id){
	var uploadUrl = '<%=request.getContextPath()%>/file/upload.action?fm=true';
		 var file = $('#file').val();
		 if(file=='') return ;
		 var ret = new imagePlugin( 'file',2,'jpg,jpeg,png').valid();
		 if(ret.result){
		 	 $.ajaxFileUpload({
                  url: uploadUrl, 
                  secureuri: false, 
                  fileElementId: 'file',  
                  dataType: 'html', 
                  success: function (data, status)  { 
					    var start = data.indexOf("{");    
					    if(start != -1) {    
					       var end = data.indexOf("}", start + 1);    
					       if(end != -1) {    
					      	 data = data.substring(start, end + 1);    
					       }    
					    }
					    start = data.indexOf('>');
					     if(start != -1) {    
					       var end = data.lastIndexOf("<");    
					       if(end != -1) {    
					      	 data = data.substring(start+1, end);    
					       }    
					    }
					    
					//json字符串转JSON对象  
                  	data = $.parseJSON(data);
					 //封面地址
                  	var coverPath = data.filePath;
                  	
                  	//设置图像
                   var eleUploadImg =  $("#"+li_id).find('.upload-img');
                   $(eleUploadImg).find('.upload-bg').attr("src", '${fileServer}/file/'+coverPath);
                      
                  	//设置隐藏图像
                    $("#"+li_id).find('input[name="fmlj"]').val(coverPath);
                  },
                  error: function (data, status, e){//服务器响应失败处理函数
                      alert(e);
                  }
              });
		 }
		
      }
  </script>
</html>