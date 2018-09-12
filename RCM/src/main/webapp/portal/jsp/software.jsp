<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
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
  <%@include file="/portal/jsp/common/checkbox.jsp" %>
  <!--内容-->
  <%String type = request.getParameter("type");
            %>
  <%String skid = request.getParameter("ssxkid");
            %>
  <%String name = request.getParameter("name");
            %>
  <%String wjgs = request.getParameter("wjgs");
            %>
  <div class="all-content">
   <span class="soft-nav">
           <a>当前位置：</a>
          <a href="/${projectName}/portal/index.action">首页 &gt;</a>
          <c:if test="${not empty name}">
              <a>${name}</a>
          </c:if>
          <c:if test="${empty name}">
              <a>全部</a>
          </c:if>
        </span>
     <div class="soft-top">
       
       <div class="soft-search">
       <span class="soft-search-title">资源类型：</span>
        <c:if test="${empty param.ssxkid}">
          <a href="javascript:showResList('','','${param.wjgs}','${param.type}','${zy.zymc}')" class="soft-this">全部</a>
        </c:if>
        <c:if test="${not empty param.ssxkid}">
           <a href="javascript:showResList('','','${param.wjgs}','${param.type}','${zy.zymc}')" >全部</a>
        </c:if>
         <c:forEach items="${xklbList}" var="x">
            <c:if test="${x.xkmc==name}">
                <a href="javascript:showResList('${x.id }','${x.xkmc }','${param.wjgs}','${param.type}','${zy.zymc}')" class="soft-this"><!-- <span class="icon-soft"></span> -->${x.xkmc }</a>
            </c:if>
             <c:if test="${x.xkmc!=name}">
                <a href="javascript:showResList('${x.id }','${x.xkmc }','${param.wjgs}','${param.type}','${zy.zymc}')"><!-- <span class="icon-soft"></span> -->${x.xkmc }</a>
            </c:if>
         </c:forEach>
       </div>
        <div id="wjgss" class="soft-search">
        	<span class="soft-search-title">资源格式：</span>
        	<c:if test="${empty param.wjgs}">
                <a href="javascript:showResList('${param.ssxkid}','${name}','','${param.type}','${zy.zymc}')" class="soft-this">全部</a>
            </c:if>
            <c:if test="${not empty param.wjgs}">
                <a href="javascript:showResList('${param.ssxkid}','${name}','','${param.type}','${zy.zymc}')">全部</a>
            </c:if>
            <c:forEach items="${gslist}" var="g">
               <c:if test="${not empty param.wjgs && g.label==param.wjgs}">
                  <a href="javascript:showResList($'{param.ssxkid}','${name}','${g.label}','${param.type}','${zy.zymc}')" class="soft-this">${g.label}</a>
               </c:if>
               <c:if test="${not empty param.wjgs && g.label!=param.wjgs}">
                  <a href="javascript:showResList('${param.ssxkid}','${name}','${g.label}','${param.type}','${zy.zymc}')" >${g.label}</a>
               </c:if>
               <c:if test="${empty param.wjgs && g.label!=param.wjgs}">
                  <a href="javascript:showResList('${param.ssxkid}','${name}','${g.label}','${param.type}','${zy.zymc}')" >${g.label}</a>
               </c:if>
            </c:forEach>
            
        </div>
        <c:if test="${param.type eq 'news'}">
                <span class="soft-new"><a  class="soft-navThis" href="javascript:showResList('${param.ssxkid}','${name}','${param.wjgs}','news','${zy.zymc}')">最新课程</a><a  href="javascript:showResList('${param.ssxkid}','${name}','${param.wjgs}','hot','${zy.zymc}')">最热课程</a></span>
             </c:if>
             <c:if test="${param.type eq 'hot'}">
                 <span class="soft-new"><a  href="javascript:showResList('${param.ssxkid}','${name}','${param.wjgs}','news','${zy.zymc}')">最新课程</a><a class="soft-navThis" href="javascript:showResList('${param.ssxkid}','${name}','${param.wjgs}','hot','${zy.zymc}')">最热课程</a></span>
             </c:if>
             <c:if test="${empty param.type}">
                 <span class="soft-new"><a  href="javascript:showResList('${param.ssxkid}','${name}','${param.wjgs}','news','${zy.zymc}')">最新课程</a><a  href="javascript:showResList('${param.ssxkid}','${name}','${param.wjgs}','hot','${zy.zymc}')">最热课程</a></span>
             </c:if>
     </div>
    <div class="soft-body">
        <div class="soft-left">
            
          <div class="index-ul">
            <c:forEach items="${zyList}" var="d">
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
          <c:if test="${empty zyList}"><div class="soft-body-no">找不到相关资源，请尝试更换其他条件进行搜索</div></c:if>
        </div>
        <div class="soft-right">
            <h1>推荐课程</h1>
            <c:forEach items="${recommendZyList}" var="r">
            <div class="soft-list">
              <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${r.id}">
                <c:if test="${ empty r.fmlj}">
             		 <c:if test="${r.wjgs =='DOCX' ||r.wjgs =='DOC'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/word-small-def.png">
             		</c:if>
             		 <c:if test="${r.wjgs =='XLSX' ||r.wjgs =='XLS'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/excel-small-def.png">
             		</c:if>
             		 <c:if test="${r.wjgs =='PPTX' ||r.wjgs =='PPT'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/ppt-small-def.png">
             		</c:if>
             		 <c:if test="${r.wjgs =='MP4'||r.wjgs =='FLV'||r.wjgs =='AVI'||r.wjgs =='MOV'||r.wjgs =='WMV'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/mp4-small-def.png">
             		</c:if>
             		 <c:if test="${r.wjgs =='PDF'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/pdf-small-def.png">
             		</c:if>
              </c:if>   
              <c:if test="${not  empty r.fmlj}">
                 <img  src="${fileServer}/file/${r.fmlj}"> 
              </c:if>
                  <div class="soft-h4">
                     <h4>${r.zymc }</h4>
                     <!-- <p>我们都知道HTTP是无状态协议，那在WEB开发中我……</p> -->
                    <span>
                    <!-- <i class="icon-geshi"></i> -->
                    <c:if test="${r.wjgs eq 'PDF'}"><img src="<%=request.getContextPath()%>/portal/img/pdf.png" style="width:16px;height:16px"></c:if>
                    <c:if test="${r.wjgs eq 'DOC'}"><img src="<%=request.getContextPath()%>/portal/img/word.png" style="width:16px;height:16px"></c:if>
                    <c:if test="${r.wjgs eq 'DOCX'}"><img src="<%=request.getContextPath()%>/portal/img/word.png" style="width:16px;height:16px"></c:if>
                    <c:if test="${r.wjgs =='MP4'||r.wjgs =='FLV'||r.wjgs =='AVI'||r.wjgs =='MOV'||r.wjgs =='WMV'}"><img src="<%=request.getContextPath()%>/portal/img/mp41.png" style="width:16px;height:16px"></c:if>
                    <c:if test="${r.wjgs eq 'PPT'}"><img src="<%=request.getContextPath()%>/portal/img/ppt.png" style="width:16px;height:16px"></c:if>
                    <c:if test="${r.wjgs eq 'PPTX'}"><img src="<%=request.getContextPath()%>/portal/img/ppt.png" style="width:16px;height:16px"></c:if>
                    <c:if test="${r.wjgs eq 'XLS'}"><img src="<%=request.getContextPath()%>/portal/img/excel.png" style="width:16px;height:16px"></c:if>
                    <c:if test="${r.wjgs eq 'XLSX'}"><img src="<%=request.getContextPath()%>/portal/img/excel.png" style="width:16px;height:16px"></c:if>
                    ${r.wjgs }</span> <span><i class="icon-eye"></i><c:if test="${r.llcs!=null }">${r.llcs}</c:if><c:if test="${r.llcs==null }">0</c:if>次</span>
                  </div>
              </a>
            </div>
            </c:forEach>
              <h1 class="margin50">热门排行</h1>
              <c:forEach items="${zyphList}" var="s">
              <div class="soft-list">
                <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${s.id}">
              
               <c:if test="${ empty s.fmlj}">
             		 <c:if test="${s.wjgs =='DOCX' ||s.wjgs =='DOC'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/word-small-def.png">
             		</c:if>
             		 <c:if test="${s.wjgs =='XLSX' ||s.wjgs =='XLS'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/excel-small-def.png">
             		</c:if>
             		 <c:if test="${s.wjgs =='PPTX' ||s.wjgs =='PPT'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/ppt-small-def.png">
             		</c:if>
             		 <c:if test="${s.wjgs =='MP4'||s.wjgs =='FLV'||s.wjgs =='AVI'||s.wjgs =='MOV'||s.wjgs =='WMV'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/mp4-small-def.png">
             		</c:if>
             		 <c:if test="${s.wjgs =='PDF'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/pdf-small-def.png">
             		</c:if>
              </c:if>  
                
              <c:if test="${not  empty s.fmlj}">
                 <img  src="${fileServer}/file/${s.fmlj}"> 
              </c:if>
                  <div class="soft-h4">
                    <h4>${s.zymc }</h4>
                    <!-- <p>我们都知道HTTP是无状态协议，那在WEB开发中我……</p> -->
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
                    ${s.wjgs }</span> <span><i class="icon-eye"></i><c:if test="${s.llcs!=null }">${s.llcs}</c:if><c:if test="${s.llcs==null }">0</c:if>次</span>
                  </div>
                </a>
              </div>
              </c:forEach>
        </div>
        <!--分页-->
        <div class="page">
           <%@ include file="/portal/jsp/common/pagenation.jsp"%>
        </div>
        <!--分页 end-->
    </div>
  </div>
  <!--内容 end-->
  <div class="height30"></div>
  <!--尾部-->
  	<%@include file="/portal/jsp/common/footer.jsp" %>
  <!--尾部 end-->
  <!--登录弹框-->
   	<%@include file="/portal/jsp/common/loginbox.jsp" %>
  <!--登录弹框 end-->
    <%-- <script src="<%=request.getContextPath()%>/portal/js/lib/jquery.min.js"></script> --%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/portal/js/lib/jquery.html5uploader.js"></script>
    <script src="<%=request.getContextPath()%>/portal/js/lib/layui/layui.all.js"></script>
    <script src="<%=request.getContextPath()%>/portal/js/all.js"></script>
    <script type="text/javascript">
    function GetQueryString(name) {
    	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    	var r = window.location.search.substr(1).match(reg);
    	if (r!=null) return (r[2]); return null;
    }
    var skid = GetQueryString("ssxkid");
    var n = GetQueryString("name");
    var type=GetQueryString("type");
    var wjgs=GetQueryString("wjgs");
    var zymc = '${zy.zymc}';
    if(skid==null){
    	var pageUrl  = '<%=request.getContextPath()%>/portal/schSoftware.action'+'?wjgs='+wjgs+'&type='+type+'&zymc='+encodeURIComponent(encodeURIComponent(zymc));
    }else{
    	var pageUrl  = '<%=request.getContextPath()%>/portal/schSoftware.action'+'?ssxkid='+skid+'&name='+encodeURIComponent(encodeURIComponent(n))+'&wjgs='+wjgs+'&type='+type+'&zymc='+encodeURIComponent(encodeURIComponent(zymc)); 
    }
        
    </script>

  </body>
</html>