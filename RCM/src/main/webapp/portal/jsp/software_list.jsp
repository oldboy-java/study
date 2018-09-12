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
 				   if(data[i].label=="${zywjgs}"){
 					  $("#wjgs").append("<option value="+data[i].id+" selected=selected>" + data[i].label + "</option>"); 
 				   }else{
 					  $("#wjgs").append("<option value="+data[i].id+">" + data[i].label + "</option>");
 				   }			       
 			       
 			   }
 			   
 		   }
 	      
 	   });
    });
    </script>
  </head>
  <body>
  <div class="wrap">
  <div class="innerhtml">
  <!--头部-->
  <div class="header-top">
    <%@include file="/portal/jsp/common/head.jsp" %>
  </div>
  <!--头部 end-->
  <!--资源查询-->
  <div class="all-content index-logo">
     <img src="<%=request.getContextPath()%>/portal/img/logo.png" title="教学资源平台">
    <form class="search-form" action="/${projectName}/portal/schZyWeb.action" method="post">
     <!--  <select class="index-select" id="wjgs" name="wjgs">
         <option value="">格&nbsp;&nbsp;式</option>
      </select> -->
      <div class="layui-form-item">
        <div class="layui-input-inline">
          <input type="text" id="zymc" name="zymc" class="layui-input" placeholder="请输入关键字" autocomplete="off" value=${zy.zymc }>
        </div>
        <button class="layui-btn"  type="submit"><span class="icon-seach"></span></button>
      </div>
    </form>
  </div>
  <!--资源查询end-->
  <!--内容-->
  <div class="all-content">
   <span class="soft-nav">
           <a>当前位置：</a>
          <a href="/${projectName}/portal/index.action">首页 &gt;</a><a>资源搜索</a>
        </span>
    <div class="soft-top">
       <div class="soft-search">
       <span class="soft-search-title">资源类型：</span>
        <c:if test="${empty param.type && empty param.ssxkid || not empty param.type && empty param.ssxkid}">
          <a href="/${projectName}/portal/schSoftware.action" class="soft-this"><!-- <span class="icon-all"></span> -->全部</a>
        </c:if>
        <c:if test="${not empty param.ssxkid}">
           <a href="/${projectName}/portal/schSoftware.action" ><!-- <span class="icon-all"></span> -->全部</a>
        </c:if>
         <c:forEach items="${xklbList}" var="x">
            <c:if test="${x.xkmc==name}">
                <a href="/${projectName}/portal/schSoftware.action?ssxkid=${x.id }&name=${x.xkmc }" class="soft-this"><!-- <span class="icon-soft"></span> -->${x.xkmc }</a>
            </c:if>
             <c:if test="${x.xkmc!=name}">
                <a href="/${projectName}/portal/schSoftware.action?ssxkid=${x.id }&name=${x.xkmc }"><!-- <span class="icon-soft"></span> -->${x.xkmc }</a>
            </c:if>
         </c:forEach>
       </div>
        <div class="soft-search">
        	<span class="soft-search-title">资源格式：</span>
        	<a href="#" class="soft-this">全部</a><a href="#">DOC</a><a href="#">MP4</a><a href="#">PDF</a>
        </div>
        <span class="soft-new"><a  class="soft-navThis" href="/${projectName}/portal/schSoftware.action?ssxkid=${param.ssxkid}&name=${param.name}&type=news">最新课程</a><a href="/${projectName}/portal/schSoftware.action?ssxkid=${param.ssxkid}&name=${param.name}&type=hot">最热课程</a></span>
     </div>
    <div class="soft-body">
        <div class="soft-left soft-content">
          <div class="index-ul">
          <c:forEach items="${myzys}" var="z">
            <div class="index-li">
              <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${z.id}">
               <c:if test="${ empty z.fmlj}">
             		 <c:if test="${z.wjgs =='DOCX' ||z.wjgs =='DOC'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/word-large-def.png">
             		</c:if>
             		 <c:if test="${z.wjgs =='XLSX' ||z.wjgs =='XLS'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/excel-large-def.png">
             		</c:if>
             		 <c:if test="${z.wjgs =='PPTX' ||z.wjgs =='PPT'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/ppt-large-def.png">
             		</c:if>
             		 <c:if test="${z.wjgs =='MP4'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/mp4-large-def.png">
             		</c:if>
             		 <c:if test="${z.wjgs =='PDF'}">
             			 <img  src="<%=request.getContextPath()%>/portal/img/pdf-large-def.png">
             		</c:if>
            	</c:if>   
              <c:if test="${not  empty z.fmlj}">
                 <img  src="${fileServer}/file/${z.fmlj}"> 
              </c:if>
                <h3>${z.zymc }</h3>
                <!-- <p>简介：我们都知道HTTP是无状态协议，那在WEB开发中我……</p> -->
                <span>
                <!-- <i class="icon-geshi"></i> -->
                <c:if test="${z.wjgs eq 'PDF'}"><img src="<%=request.getContextPath()%>/portal/img/pdf.png" style="width:16px;height:16px"></c:if>
                <c:if test="${z.wjgs eq 'DOC'}"><img src="<%=request.getContextPath()%>/portal/img/word.png" style="width:16px;height:16px"></c:if>
                <c:if test="${z.wjgs eq 'DOCX'}"><img src="<%=request.getContextPath()%>/portal/img/word.png" style="width:16px;height:16px"></c:if>
                <c:if test="${z.wjgs eq 'MP4'}"><img src="<%=request.getContextPath()%>/portal/img/mp4.png" style="width:16px;height:16px"></c:if>
                <c:if test="${z.wjgs eq 'PPT'}"><img src="<%=request.getContextPath()%>/portal/img/ppt.png" style="width:16px;height:16px"></c:if>
                <c:if test="${z.wjgs eq 'PPTX'}"><img src="<%=request.getContextPath()%>/portal/img/ppt.png" style="width:16px;height:16px"></c:if>
                <c:if test="${z.wjgs eq 'XLS'}"><img src="<%=request.getContextPath()%>/portal/img/excel.png" style="width:16px;height:16px"></c:if>
                <c:if test="${z.wjgs eq 'XLSX'}"><img src="<%=request.getContextPath()%>/portal/img/excel.png" style="width:16px;height:16px"></c:if>
                ${z.wjgs }</span> <span><i class="icon-eye"></i><c:if test="${z.llcs!=null }">${z.llcs}</c:if><c:if test="${z.llcs==null }">0</c:if>次</span> <span><i class="icon-message"></i><c:if test="${z.plcs!=null }">${z.plcs}</c:if><c:if test="${z.plcs==null }">0</c:if>条</span>
              </a>
            </div>
            </c:forEach>
          </div>
        </div>

        <!--分页-->
        <div class="page">
           <%@ include file="/portal/jsp/common/pagenation.jsp"%>
        </div>
        <!--分页 end-->
    </div>
    <!-- 搜索无结果时 -->
    <c:if test="${empty myzys}"><div class="soft-body-no">找不到相关资源，请尝试更换其他条件进行搜索</div></c:if>
  </div>
  <!--内容 end-->
  <div class="height30"></div>
  </div>
  </div>
  <!--尾部-->
  	<%@include file="/portal/jsp/common/footer.jsp" %>
  <!--尾部 end-->
  <!--登录弹框-->
  <%@include file="/portal/jsp/common/loginbox.jsp" %>
  <!--登录弹框 end-->
   
    <script type="text/javascript">
       var pageUrl='<%=request.getContextPath()%>/portal/space/main/schZy.action'
    </script>
  </body>
</html>