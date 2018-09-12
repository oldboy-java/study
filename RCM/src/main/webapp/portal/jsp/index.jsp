<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/portal/jsp/common/head-top.jsp" %>
    <script type="text/javascript">
    $(document).ready(function(){
    	$.ajax({
 		   async:false,
 		   type:"POST",
 		   url:"/${projectName}/portal/zygs.action", 
 		   dataType:"json",
 		   data:{
 			  wjgs:$("#wjgs").val()
 		   },
 		   success: function (data) {
 			   for (var i = 0; i < data.length; i++) {
 			       $("#wjgs").append("<option value="+data[i].id+">" + data[i].label + "</option>");
 			       
 			   }
 			   
 		   }
 	      
 	   });
    });
    </script>
</head>
  <body>
  <!--头部-->
  <div class="header-top">
    <%@include file="/portal/jsp/common/head.jsp" %>
  </div>
  <!--头部 end-->
  <!--资源查询-->
  <%@include file="/portal/jsp/common/checkbox.jsp" %>
  <!--资源查询end-->
  <!--banner-->
  <div class="layui-carousel" id="indexBanner">
    <div carousel-item="">
      <div class="index-bannerImg" style="background: url(<%=request.getContextPath()%>/portal/img/banner1.png)"></div>
      <div class="index-bannerImg" style="background: url(<%=request.getContextPath()%>/portal/img/banner2.png)"></div>
      <div class="index-bannerImg" style="background: url(<%=request.getContextPath()%>/portal/img/banner3.png)"></div>
      <div class="index-bannerImg" style="background: url(<%=request.getContextPath()%>/portal/img/banner4.png)"></div>
    </div>
  </div>
  <div class="all-content">
    <c:if test="${xklbSize le 9}">
     <ul class="index-nav">
         <c:forEach items="${xklbList}" var="x">
            <li><a href="javascript:showResList(${x.id },'${x.xkmc }')"><span class="icon-soft"></span>${x.xkmc }</a></li>
         </c:forEach>
     </ul>
    </c:if>
    <c:if test="${xklbSize gt 9}">
         <ul class="index-nav">
            <c:forEach items="${xklbList2}" var="x">
                <li><a href="javascript:showResList(${x.id },'${x.xkmc }')"><span class="icon-soft"></span>${x.xkmc }</a></li>
            </c:forEach>
            <li class="nav-more"><a><span class="icon-gengduo"></span>更多</a></li>
            <ul class="nav-none">
            <c:forEach items="${xklbMoreList}" var="x">
                <li><a href="javascript:showResList(${x.id },'${x.xkmc }')"><span class="icon-soft"></span>${x.xkmc }</a></li>
            </c:forEach>
           </ul>
        </ul>
    </c:if>
  </div>
  <!--banner end-->
  <!--内容-->
  <div class="all-content">
     <div class="index-ul">
         <h1>推荐资源 </h1>
         <c:forEach items="${recommendZyList}" var="d">
             <div class="index-li">
             <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${d.id}">
            
              <c:if test="${ empty d.fmlj}">
             		 <c:if test="${d.wjgs =='DOCX' ||d.wjgs =='DOC'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/word-large-def.png">
             		</c:if>
             		 <c:if test="${d.wjgs =='XLSX' ||d.wjgs =='XLS'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/excel-large-def.png">
             		</c:if>
             		 <c:if test="${d.wjgs =='PPTX' ||d.wjgs =='PPT'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/ppt-large-def.png">
             		</c:if>
             		 <c:if test="${d.wjgs =='MP4'||d.wjgs =='FLV'||d.wjgs =='AVI'||d.wjgs =='MOV'||d.wjgs =='WMV'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/mp4-large-def.png">
             		</c:if>
             		 <c:if test="${d.wjgs =='PDF'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/pdf-large-def.png">
             		</c:if>
            </c:if>  
            
              
              <c:if test="${not  empty d.fmlj}">
                 <img  src="${fileServer}/file/${d.fmlj}"> 
              </c:if>
              <h3>${d.zymc }</h3>
              <!-- <p>简介：我们都知道HTTP是无状态协议，那在WEB开发中我……</p> -->
              <span>
              <!-- <i class="icon-geshi"></i> -->
              <c:if test="${d.wjgs eq 'PDF'}"><img src="<%=request.getContextPath()%>/portal/img/pdf.png" style="width:16px;height:16px"></c:if>
              <c:if test="${d.wjgs eq 'DOC'}"><img src="<%=request.getContextPath()%>/portal/img/word.png" style="width:16px;height:16px"></c:if>
              <c:if test="${d.wjgs eq 'DOCX'}"><img src="<%=request.getContextPath()%>/portal/img/word.png" style="width:16px;height:16px"></c:if>
              <c:if test="${d.wjgs =='MP4'||d.wjgs =='FLV'||d.wjgs =='AVI'||d.wjgs =='MOV'||d.wjgs =='WMV'}"><img src="<%=request.getContextPath()%>/portal/img/mp41.png" style="width:16px;height:16px"></c:if>
              <c:if test="${d.wjgs eq 'PPT'}"><img src="<%=request.getContextPath()%>/portal/img/ppt.png" style="width:16px;height:16px"></c:if>
              <c:if test="${d.wjgs eq 'PPTX'}"><img src="<%=request.getContextPath()%>/portal/img/ppt.png" style="width:16px;height:16px"></c:if>
              <c:if test="${d.wjgs eq 'XLS'}"><img src="<%=request.getContextPath()%>/portal/img/excel.png" style="width:16px;height:16px"></c:if>
              <c:if test="${d.wjgs eq 'XLSX'}"><img src="<%=request.getContextPath()%>/portal/img/excel.png" style="width:16px;height:16px"></c:if>
              ${d.wjgs }</span> <span><i class="icon-eye"></i><c:if test="${d.llcs!=null }">${d.llcs}</c:if><c:if test="${d.llcs==null }">0</c:if>次</span> <span><i class="icon-message"></i><c:if test="${d.plcs!=null }">${d.plcs}</c:if><c:if test="${d.plcs==null }">0</c:if>条</span>
             </a>
             </div>
         </c:forEach>
     </div>
    <div class="index-ul">
      <h1>热门资源</h1>
      <c:forEach items="${rmzyList}" var="s">
             <div class="index-li">
             <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${s.id}">
              
              <c:if test="${ empty s.fmlj}">
             		 <c:if test="${s.wjgs =='DOCX' ||s.wjgs =='DOC'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/word-large-def.png">
             		</c:if>
             		 <c:if test="${s.wjgs =='XLSX' ||s.wjgs =='XLS'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/excel-large-def.png">
             		</c:if>
             		 <c:if test="${s.wjgs =='PPTX' ||s.wjgs =='PPT'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/ppt-large-def.png">
             		</c:if>
             		 <c:if test="${s.wjgs =='MP4'||s.wjgs =='FLV'||s.wjgs =='AVI'||s.wjgs =='MOV'||s.wjgs =='WMV'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/mp4-large-def.png">
             		</c:if>
             		 <c:if test="${s.wjgs =='PDF'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/pdf-large-def.png">
             		</c:if>
            </c:if>  
	              
              <c:if test="${not  empty s.fmlj}">
                 <img  src="${fileServer}/file/${s.fmlj}"> 
              </c:if>
              <h3>${s.zymc }</h3>
              <!-- <p>简介：我们都知道HTTP是无状态协议，那在WEB开发中我……</p> -->
              <span>
              <!-- <i class="icon-geshi"></i> -->
              <c:if test="${s.wjgs eq 'PDF'}"><img src="<%=request.getContextPath()%>/portal/img/pdf.png" style="width:16px;height:16px"></c:if>
              <c:if test="${s.wjgs eq 'DOC'}"><img src="<%=request.getContextPath()%>/portal/img/word.png" style="width:16px;height:16px"></c:if>
              <c:if test="${s.wjgs eq 'DOCX'}"><img src="<%=request.getContextPath()%>/portal/img/word.png" style="width:16px;height:16px"></c:if>
              <c:if test="${s.wjgs =='MP4'||s.wjgs =='FLV'||s.wjgs =='AVI'||s.wjgs =='MOV'||s.wjgs =='WMV'}"><img src="<%=request.getContextPath()%>/portal/img/mp41.png" style="width:16px;height:16px"></c:if>
              <c:if test="${s.wjgs eq 'PPT'}"><img src="<%=request.getContextPath()%>/portal/img/ppt.png" style="width:16px;height:16px"></c:if>
              <c:if test="${s.wjgs eq 'PPTX'}"><img src="<%=request.getContextPath()%>/portal/img/ppt.png" style="width:16px;height:16px"></c:if>
              <c:if test="${s.wjgs eq 'XLS'}"><img src="<%=request.getContextPath()%>/portal/img/excel.png" style="width:16px;height:16px"></c:if>
              <c:if test="${s.wjgs eq 'XLSX'}"><img src="<%=request.getContextPath()%>/portal/img/excel.png" style="width:16px;height:16px"></c:if>
              ${s.wjgs }</span> <span><i class="icon-eye"></i><c:if test="${s.llcs!=null }">${s.llcs}</c:if><c:if test="${s.llcs==null }">0</c:if>次</span> <span><i class="icon-message"></i><c:if test="${s.plcs!=null }">${s.plcs}</c:if><c:if test="${s.plcs==null }">0</c:if>条</span>
             </a>
             </div>
         </c:forEach>
    </div>
	
	 <div class="index-ul index-zyuan">
        <ul class="index-left">
		   <h2 class="index-left-h2">最新资源<!-- <a href="" class="index-h1More">更多</a> --></h2>
		    <c:forEach items="${zxZyList}" var="s">
		   <li>
			   <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${s.id}" title="${s.zymc }" class="index-left-a">
			   <c:if test="${s.wjgs eq 'PDF'}"><img src="<%=request.getContextPath()%>/portal/img/pdf.png"></c:if>
              <c:if test="${s.wjgs eq 'DOC'}"><img src="<%=request.getContextPath()%>/portal/img/word.png"></c:if>
              <c:if test="${s.wjgs eq 'DOCX'}"><img src="<%=request.getContextPath()%>/portal/img/word.png"></c:if>
              <c:if test="${s.wjgs =='MP4'||s.wjgs =='FLV'||s.wjgs =='AVI'||s.wjgs =='MOV'||s.wjgs =='WMV'}"><img src="<%=request.getContextPath()%>/portal/img/mp41.png"></c:if>
              <c:if test="${s.wjgs eq 'PPT'}"><img src="<%=request.getContextPath()%>/portal/img/ppt.png"></c:if>
              <c:if test="${s.wjgs eq 'PPTX'}"><img src="<%=request.getContextPath()%>/portal/img/ppt.png"></c:if>
              <c:if test="${s.wjgs eq 'XLS'}"><img src="<%=request.getContextPath()%>/portal/img/excel.png"></c:if>
              <c:if test="${s.wjgs eq 'XLSX'}"><img src="<%=request.getContextPath()%>/portal/img/excel.png"></c:if>
			   ${s.zymc }</a>
			   <span class="index-span"> <fmt:formatDate pattern="yyyy-MM-dd" value="${s.scrq }" /></span>
		   </li>
		   </c:forEach>
		</ul>
		<ul class="index-right">
			<h2 class="index-left-h2">上传排行<!-- <a href="" class="index-h1More">更多</a> --></h2>
			<c:forEach items="${scphList}" var="s" varStatus="vs">
			<li> 
			<c:if test="${vs.index eq 0}">
			  <span class="index-hui index-winone">${vs.index+1}</span>
			   <a  style="cursor:default" title="上传人" class="index-right-a"><img src="<%=request.getContextPath()%>/portal/img/face_80.jpg">${s.SCR}</a>
			  <c:set var="SCS" scope="request" value="${s.SCS}" />
			   <%DecimalFormat df = new DecimalFormat("#,###"); 
			     String s=df.format(Integer.parseInt(request.getAttribute("SCS").toString()));
			   %>
			   <span class="index-right-span"><%=s %>份</span>
			</c:if>
			<c:if test="${vs.index eq 1}">
			  <span class="index-hui index-wintwo">${vs.index+1}</span>
			   <a  style="cursor:default" title="上传人" class="index-right-a"><img src="<%=request.getContextPath()%>/portal/img/face_80.jpg">${s.SCR}</a>
			   <span class="index-right-span">${s.SCS}份</span>
			</c:if>
			<c:if test="${vs.index eq 2}">
			  <span class="index-hui index-winthree">${vs.index+1}</span>
			   <a  style="cursor:default" title="上传人" class="index-right-a"><img src="<%=request.getContextPath()%>/portal/img/face_80.jpg">${s.SCR}</a>
			   <span class="index-right-span">${s.SCS}份</span>
			</c:if>    
			<c:if test="${vs.index gt 2}">
			  <span class="index-hui index-hui">${vs.index+1}</span>
			   <a  style="cursor:default" title="上传人" class="index-right-a"><img src="<%=request.getContextPath()%>/portal/img/face_80.jpg">${s.SCR}</a>
			   <span class="index-right-span">${s.SCS}份</span>
			</c:if> 
			</li>
			</c:forEach>
		</ul>
     </div>
     
  </div>
  <!--内容 end-->
  <div class="height30"></div>
  
  <!--尾部-->
  	<%@include file="/portal/jsp/common/footer.jsp" %>
  <!--尾部 end-->
  
   <!-- 登录框 -->
   	<%@include file="/portal/jsp/common/loginbox.jsp" %>
   <!-- 登录框 end -->
   
</html>