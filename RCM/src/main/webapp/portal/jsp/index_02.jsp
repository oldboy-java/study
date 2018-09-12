<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.qtrmoon.dictionary.DictBuffer"%>
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
  <body style="background:#f2f2f2;">
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
      <h1>推荐资源</h1>
      <ul class="courses-ul">
      <c:forEach items="${recommendZyList}" var="d">
           <li class="courses-li">
            <div class="coursesLi-img">
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
              </a>
            </div>
            <div class="coursesLi-content">
               <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${d.id}"><h4>${d.zymc }</h4></a>
              <p class="liContent-num">
                 <c:set var="skid" scope="request" value="${d.ssxkid}" />
                 <%
                     String skid = String.valueOf(request.getAttribute("skid"));
                 %>
              	 <span class="liContent-num-title"><i class="icon-soft num-titleIcon"></i><%=DictBuffer.getLabel("ZD_XKLB", skid)%></span>
             	<%--  <span><i class="small_icon preview"></i><c:if test="${d.llcs!=null }">${d.llcs}</c:if><c:if test="${d.llcs==null }">0</c:if></span>
             	 <span><i class="small_icon record_review "></i><c:if test="${d.plcs!=null }">${d.plcs}</c:if><c:if test="${d.plcs==null }">0</c:if></span>
             	 <span><i class="small_icon record_down"></i><c:if test="${d.xzcs!=null }">${d.xzcs}</c:if><c:if test="${d.xzcs==null }">0</c:if></span>
             	 <span><i class="small_icon record_dianzan"></i><c:if test="${d.dzcs!=null }">${d.dzcs}</c:if><c:if test="${d.dzcs==null }">0</c:if></span> --%>
             	 <span><b><c:if test="${d.llcs!=null }">${d.llcs}</c:if><c:if test="${d.llcs==null }">0</c:if></b>&nbsp;个浏览</span><span><b><c:if test="${d.plcs!=null }">${d.plcs}</c:if><c:if test="${d.plcs==null }">0</c:if></b>&nbsp;个评论</span><span><b><c:if test="${d.xzcs!=null }">${d.xzcs}</c:if><c:if test="${d.xzcs==null }">0</c:if></b>&nbsp;个下载</span>
              <span><b><c:if test="${d.dzcs!=null }">${d.dzcs}</c:if><c:if test="${d.dzcs==null }">0</c:if></b>&nbsp;个点赞</span></p>
             	</p>
              <p class="liContent-source"></p>
            </div> 
               
         <!--  <div class="liContent-style"><i class="file-ico-small icon-pdf-small"></i></div> -->
          <div class="liposition">
          		<div class="liContent-style1">
	          		<span class="coursesLi-contype">
			              <c:if test="${d.wjgs eq 'PDF'}"><i class="file-ico-small icon-pdf-small"></i></c:if>
			              <c:if test="${d.wjgs eq 'DOC'}"><i class="file-ico-small icon-doc-small"></i></c:if>
			              <c:if test="${d.wjgs eq 'DOCX'}"><i class="file-ico-small icon-docx-small"></i></c:if>
			              <c:if test="${d.wjgs eq 'MP4'}"><i class="file-ico-small icon-mp4-small"></i></c:if>
			              <c:if test="${d.wjgs eq 'FLV'}"><i class="file-ico-small icon-flv-small"></i></c:if>
			              <c:if test="${d.wjgs eq 'AVI'}"><i class="file-ico-small icon-avi-small"></i></c:if>
			              <c:if test="${d.wjgs eq 'MOV'}"><i class="file-ico-small icon-mov-small"></i></c:if>
			              <c:if test="${d.wjgs eq 'WMV'}"><i class="file-ico-small icon-wmv-small"></i></c:if>
			              <c:if test="${d.wjgs eq 'PPT'}"><i class="file-ico-small icon-ppt-small"></i></c:if>
			              <c:if test="${d.wjgs eq 'PPTX'}"><i class="file-ico-small icon-pptx-small"></i></c:if>
			              <c:if test="${d.wjgs eq 'XLS'}"><i class="file-ico-small icon-xls-small"></i></c:if>
			              <c:if test="${d.wjgs eq 'XLSX'}"><i class="file-ico-small icon-xlsx-small"></i></c:if>
	             	 </span>
          		</div>
             <%--  <p class="zan-num"><i class="icon-dianzhang2"></i><b><c:if test="${d.dzcs!=null }">${d.dzcs}</c:if><c:if test="${d.dzcs==null }">0</c:if></b></p> --%>
              <p class="zan-date"><fmt:formatDate pattern="yyyy-MM-dd" value="${d.scrq}" />贡献</p>
            </div>
        </li>
        </c:forEach>
      </ul>
    </div>
    <div class="index-ul">
      <h1>热门资源</h1>
      <ul class="courses-ul">
      <c:forEach items="${rmzyList}" var="d">
           <li class="courses-li">
         
            <div class="coursesLi-img">
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
              </a>
            </div>
            <div class="coursesLi-content">
               <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${d.id}"><h4>${d.zymc }</h4></a>
              <p class="liContent-num">
              <c:set var="ssxkid" scope="request" value="${d.ssxkid}" />
                 <%
                      String ssxkid = String.valueOf(request.getAttribute("ssxkid"));
                 %>
              <span class="liContent-num-title"><i class="icon-soft num-titleIcon"></i><%=DictBuffer.getLabel("ZD_XKLB", ssxkid)%></span>
              <span><b><c:if test="${d.llcs!=null }">${d.llcs}</c:if><c:if test="${d.llcs==null }">0</c:if></b>&nbsp;个浏览</span><span><b><c:if test="${d.plcs!=null }">${d.plcs}</c:if><c:if test="${d.plcs==null }">0</c:if></b>&nbsp;个评论</span><span><b><c:if test="${d.xzcs!=null }">${d.xzcs}</c:if><c:if test="${d.xzcs==null }">0</c:if></b>&nbsp;个下载</span>
              <span><b><c:if test="${d.dzcs!=null }">${d.dzcs}</c:if><c:if test="${d.dzcs==null }">0</c:if></b>&nbsp;个点赞</span></p>
              <p class="liContent-source"></p>
            </div> 
              
           	<div class="liposition">
           		<span class="coursesLi-contype1">
		              <c:if test="${d.wjgs eq 'PDF'}"><i class="file-ico-small icon-pdf-small"></i></c:if>
		              <c:if test="${d.wjgs eq 'DOC'}"><i class="file-ico-small icon-doc-small"></i></c:if>
		              <c:if test="${d.wjgs eq 'DOCX'}"><i class="file-ico-small icon-docx-small"></i></c:if>
		              <c:if test="${d.wjgs eq 'MP4'}"><i class="file-ico-small icon-mp4-small"></i></c:if>
			          <c:if test="${d.wjgs eq 'FLV'}"><i class="file-ico-small icon-flv-small"></i></c:if>
			          <c:if test="${d.wjgs eq 'AVI'}"><i class="file-ico-small icon-avi-small"></i></c:if>
			          <c:if test="${d.wjgs eq 'MOV'}"><i class="file-ico-small icon-mov-small"></i></c:if>
			          <c:if test="${d.wjgs eq 'WMV'}"><i class="file-ico-small icon-wmv-small"></i></c:if>
		              <c:if test="${d.wjgs eq 'PPT'}"><i class="file-ico-small icon-ppt-small"></i></c:if>
		              <c:if test="${d.wjgs eq 'PPTX'}"><i class="file-ico-small icon-pptx-small"></i></c:if>
		              <c:if test="${d.wjgs eq 'XLS'}"><i class="file-ico-small icon-xls-small"></i></c:if>
		              <c:if test="${d.wjgs eq 'XLSX'}"><i class="file-ico-small icon-xlsx-small"></i></c:if>
             	  </span>
            <%--   <p class="zan-num"><i class="icon-dianzhang2"></i><b><c:if test="${d.dzcs!=null }">${d.dzcs}</c:if><c:if test="${d.dzcs==null }">0</c:if></b></p> --%>
              	<p class="zan-date"><fmt:formatDate pattern="yyyy-MM-dd" value="${d.scrq}" />贡献</p>
            </div>
        </li>
        </c:forEach>
      </ul>
    </div>
     <div class="index-ul index-zyuan">
        <ul class="index-left index-leftnew">
		   <h2 class="index-left-h2">最新资源</h2>
		    <c:forEach items="${zxZyList}" var="s" varStatus="go">
		    <c:if test="${go.index le 5}">
		        <li>
         <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${s.id}" class="index-left-anew">
         
           <c:if test="${s.wjgs eq 'PDF'}"><i class="file-ico-small icon-pdf-small"></i></c:if>
              <c:if test="${s.wjgs eq 'DOC'}"><i class="file-ico-small icon-doc-small"></i></c:if>
              <c:if test="${s.wjgs eq 'DOCX'}"><i class="file-ico-small icon-docx-small"></i></c:if>
              <c:if test="${s.wjgs eq 'MP4'}"><i class="file-ico-small icon-mp4-small"></i></c:if>
			  <c:if test="${s.wjgs eq 'FLV'}"><i class="file-ico-small icon-flv-small"></i></c:if>
			  <c:if test="${s.wjgs eq 'AVI'}"><i class="file-ico-small icon-avi-small"></i></c:if>
			  <c:if test="${s.wjgs eq 'MOV'}"><i class="file-ico-small icon-mov-small"></i></c:if>
			  <c:if test="${s.wjgs eq 'WMV'}"><i class="file-ico-small icon-wmv-small"></i></c:if>
              <c:if test="${s.wjgs eq 'PPT'}"><i class="file-ico-small icon-ppt-small"></i></c:if>
              <c:if test="${s.wjgs eq 'PPTX'}"><i class="file-ico-small icon-pptx-small"></i></c:if>
              <c:if test="${s.wjgs eq 'XLS'}"><i class="file-ico-small icon-xls-small"></i></c:if>
              <c:if test="${s.wjgs eq 'XLSX'}"><i class="file-ico-small icon-xlsx-small"></i></c:if>
          <div class="index-leftAzuo">
            <p class="index-leftAzuo-content"  title="${s.zymc }" >${s.zymc }</p>
            <p class="index-name"><span class="fabuname">发布者：${s.scr}</span><span>上传时间：<fmt:formatDate pattern="yyyy-MM-dd" value="${s.scrq }" /></span></p> 
          </div>
         </a>
         <span class="index-spans">积分：<b>${s.xzjf}</b></span>
       </li>
		    </c:if>
		   </c:forEach>
		</ul>
		<ul class="index-right index-rightnew">
			<h2 class="index-left-h2">上传排行</h2>
			<c:forEach items="${scphList}" var="s" varStatus="vs">
			<c:if test="${vs.index eq 0}">
			   <li> 
			       <span class="index-hui index-winone">${vs.index+1}</span>
			       <a  style="cursor:default" title="教师名称" class="index-right-anew"><img src="<%=request.getContextPath()%>/portal/img/face_80.jpg" title="教师头像">${s.SCR}</a>
			        <c:set var="SCS" scope="request" value="${s.SCS}" />
			        <%DecimalFormat df = new DecimalFormat("#,###"); 
			         String s=df.format(Integer.parseInt(request.getAttribute("SCS").toString()));
			         %>
			       <span class="index-right-span"><%=s %>份</span>
			   </li>
			</c:if>
			<c:if test="${vs.index eq 1}">
			<li> 
			   <span class="index-hui index-wintwo">${vs.index+1}</span>
			   <a  style="cursor:default" title="教师名称" class="index-right-anew"><img src="<%=request.getContextPath()%>/portal/img/face_80.jpg" title="教师头像">${s.SCR}</a>
			        <c:set var="SCS" scope="request" value="${s.SCS}" />
			        <%DecimalFormat df = new DecimalFormat("#,###"); 
			         String s=df.format(Integer.parseInt(request.getAttribute("SCS").toString()));
			         %>
			       <span class="index-right-span"><%=s %>份</span>
			</li>
			</c:if>
			<c:if test="${vs.index eq 2}">
			<li> 
			   <span class="index-hui index-winthree">${vs.index+1}</span>
			   <a  style="cursor:default" title="教师名称" class="index-right-anew"><img src="<%=request.getContextPath()%>/portal/img/face_80.jpg" title="教师头像">${s.SCR}</a>
			        <c:set var="SCS" scope="request" value="${s.SCS}" />
			        <%DecimalFormat df = new DecimalFormat("#,###"); 
			         String s=df.format(Integer.parseInt(request.getAttribute("SCS").toString()));
			         %>
			       <span class="index-right-span"><%=s %>份</span>
			</li>
			</c:if>
			<c:if test="${vs.index gt 2}">
			<li> 
			   <span class="index-hui">${vs.index+1}</span>
			   <a  style="cursor:default" title="教师名称" class="index-right-anew"><img src="<%=request.getContextPath()%>/portal/img/face_80.jpg" title="教师头像">${s.SCR}</a>
			        <c:set var="SCS" scope="request" value="${s.SCS}" />
			        <%DecimalFormat df = new DecimalFormat("#,###"); 
			         String s=df.format(Integer.parseInt(request.getAttribute("SCS").toString()));
			         %>
			       <span class="index-right-span"><%=s %>份</span>
			</li>
			</c:if>
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
