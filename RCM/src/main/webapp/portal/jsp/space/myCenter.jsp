<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/portal/jsp/common/head-top.jsp" %>
  </head>
  <body class="huibg">
  <!--头部-->
  <div class="wrap">
  	<div class="innerhtml">
  <div class="header-top">
    <%@include file="/portal/jsp/common/head.jsp" %>
  </div>
  <!--头部 end-->
 <div class="info-img">
   <div class="info-img-center">
     <div class="info-img-left">
        <span class="infoLeft-head"><img src="<%=request.getContextPath()%>/portal/img/info-head.jpg" alt="${PORTAL_SESSION_USER.username}"></span>
        <span class="infoLeft-name">${PORTAL_SESSION_USER.username}</span>
        <span class="yhdj" title="当前用户等级：${djxx.djmc }">
        	<c:forEach begin="1" end="${djxx.djmc }" step="1">
        		<img  src="<%=request.getContextPath()%>/portal/img/dl_primary.png" alt="">
        	</c:forEach>
        </span>
     </div>
     <div class="info-img-right">
       <span class="infoRight-money">
         <p class="infoRight-num">${jf}分</p>
         <p class="infoRight-word">我的积分</p>
       </span>
       <span class="infoRight-resource">
         <p class="infoRight-num">${fn:length(myZyList) }份</p>
         <p class="infoRight-word">贡献资源</p>
       </span>
     </div>
   </div>
 </div>
  <div class="all-content my-body">
    <div class="info-nav">
      <ul class="info-ul">
            <c:if test="${option==2}">
               <li class="info-this"><a href="/${projectName}/portal/space/main/schPerCenter.action?option=2" title="我的资源"><i class="icon-all"></i>我的资源</a></li>
            </c:if>
             <c:if test="${option!=2}">
               <li><a href="/${projectName}/portal/space/main/schPerCenter.action?option=2" title="我的资源"><i class="icon-all"></i>我的资源</a></li>
            </c:if>
           
            <c:if test="${option==3}">
               <li class="info-this"><a href="/${projectName}/portal/space/main/schPerCenter.action?option=3" title="我的收藏"><i class="icon-shouchang2"></i>我的收藏</a></li>
            </c:if>
             <c:if test="${option!=3}">
               <li><a href="/${projectName}/portal/space/main/schPerCenter.action?option=3" title="我的收藏"><i class="icon-shouchang2"></i>我的收藏</a></li>
            </c:if>
            <c:if test="${option==4}">
              <li class="info-this"><a href="/${projectName}/portal/space/main/schPerCenter.action?option=4" title="浏览记录"><i class="icon-eye2"></i>浏览记录</a></li>
            </c:if>
             <c:if test="${option!=4}">
              <li><a href="/${projectName}/portal/space/main/schPerCenter.action?option=4" title="浏览记录"><i class="icon-eye2"></i>浏览记录</a></li>
            </c:if>
            <c:if test="${option==5}">
              <li class="info-this"><a href="/${projectName}/portal/space/main/schPerCenter.action?option=5" title="我的评论"><i class="icon-pinglun"></i>我的评论</a></li>
            </c:if>
             <c:if test="${option!=5}">
              <li><a href="/${projectName}/portal/space/main/schPerCenter.action?option=5" title="我的评论"><i class="icon-pinglun"></i>我的评论</a></li>
            </c:if>
            <c:if test="${option==6}">
              <li class="info-this"><a href="/${projectName}/portal/space/main/schPerCenter.action?option=6" title="通知公告"><i class="icon-message3"></i>通知公告</a></li>
            </c:if>
             <c:if test="${option!=6}">
              <li><a href="/${projectName}/portal/space/main/schPerCenter.action?option=6" title="通知公告"><i class="icon-message3"></i>通知公告</a></li>
            </c:if>
            <c:if test="${option==7}">
              <li class="info-this"><a href="/${projectName}/portal/space/main/schPerCenter.action?option=7" title="下载日志"><i class="icon-upload"></i>下载日志</a></li>
            </c:if>
             <c:if test="${option!=7}">
              <li><a href="/${projectName}/portal/space/main/schPerCenter.action?option=7" title="下载日志"><i class="icon-upload"></i>下载日志</a></li>
            </c:if>
            
             <c:if test="${option==1}">
               <li class="info-this"><a href="/${projectName}/portal/space/main/schPerCenter.action?option=1" title="我的偏好"><i class="icon-prefer"></i>偏好设置</a></li>
            </c:if>
             <c:if test="${option!=1}">
               <li><a href="/${projectName}/portal/space/main/schPerCenter.action?option=1" title="我的偏好"><i class="icon-prefer"></i>偏好设置</a></li>
            </c:if>
      </ul>
    </div>
      <c:if test="${option==1}">
      <div class="info-body myPrefer">
          <form class="layui-form">
              <div class="prefer-body">
              <c:forEach items="${myphs}" var="z">
                  <div class="prefer-item">
                      <span>${z.xkmc}</span>
                      <input type="checkbox" name="zylxIds" value="${z.id }" lay-skin="primary" class="prefer-input" autocomplete="off" checked="checked">
                      <i class="icon-gou"></i>
                  </div>
               </c:forEach>       
               <c:forEach items="${phs}" var="p">
                  <div class="prefer-item">
                      <span>${p.xkmc}</span>
                      <input type="checkbox" name="zylxIds" value="${p.id }" lay-skin="primary" class="prefer-input" autocomplete="off">
                      <i class="icon-gou"></i>
                  </div>
               </c:forEach>             
              </div>
              <div class="myprefer-button"><button type="button" class="layui-btn" onclick="phsd()">保存</button></div>
          </form>
      </div>    
      </c:if>
      <c:if test="${option==2}">
         <div class="info-body">
          <div class="resource-ul">
              <li class="resource-up" onclick="resourceAdd(0)" ><i class="icon-uploads"></i>上传资源</li>
          </div>
        <div class="myresour-ul">
        <c:forEach items="${myzys}" var="z">
          <div class="myresour-li">
             <div  class="myCenter-hover">
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
	              		 <c:if test="${z.wjgs =='MP4'||z.wjgs =='FLV'||z.wjgs =='AVI'||z.wjgs =='MOV'||z.wjgs =='WMV'}">
	              			 <img  src="<%=request.getContextPath()%>/portal/img/mp4-large-def.png">
	              		</c:if>
	              		 <c:if test="${z.wjgs =='PDF'}">
	              			 <img  src="<%=request.getContextPath()%>/portal/img/pdf-large-def.png">
	              		</c:if>
	              </c:if>  
	              
	              <c:if test="${not  empty z.fmlj}">
	                 <img  src="${fileServer}/file/${z.fmlj}"> 
	              </c:if>
	               <div class="caption">
	              <a href="javascript:;">
		              <c:if test="${z.shjg=='审核通过' }">
		                <span class="myresour-tong">${z.shjg }</span>
		              </c:if>
		              <c:if test="${z.shjg=='待审核' }">
		                <span class="myresour-tong">${z.shjg }</span>
		                <span class="myresour-del" onclick="del(${z.id })" title="删除"><i class="icon-del"></i></span>
		                <span onclick="resourceAdd(${z.id})"  class="myresour-edit" title="编辑"><i class="icon-edit"></i></span>
		              </c:if>
		              <c:if test="${z.shjg=='未通过' }">
		                <span class="myresour-wei">${z.shjg }</span>
		                <span class="myresour-del" onclick="del(${z.id })" title="删除"><i class="icon-del"></i></span>
		                <span onclick="resourceAdd(${z.id})"  class="myresour-edit" title="编辑"><i class="icon-edit"></i></span>
		              </c:if> 
	                </a>                         
              </div>
	          </div>
	         <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${z.id}">
		          <c:if test="${z.wjgs eq 'PDF'}"><img class="imgIcon" src="<%=request.getContextPath()%>/portal/img/pdf.png"></c:if>
	              <c:if test="${z.wjgs eq 'DOC'}"><img class="imgIcon" src="<%=request.getContextPath()%>/portal/img/word.png"></c:if>
	              <c:if test="${z.wjgs eq 'DOCX'}"><img class="imgIcon" src="<%=request.getContextPath()%>/portal/img/word.png"></c:if>
	              <c:if test="${z.wjgs =='MP4'||z.wjgs =='FLV'||z.wjgs =='AVI'||z.wjgs =='MOV'||z.wjgs =='WMV'}"><img class="imgIcon" src="<%=request.getContextPath()%>/portal/img/mp41.png"></c:if>
	              <c:if test="${z.wjgs eq 'PPT'}"><img class="imgIcon" src="<%=request.getContextPath()%>/portal/img/ppt.png"></c:if>
	              <c:if test="${z.wjgs eq 'PPTX'}"><img class="imgIcon" src="<%=request.getContextPath()%>/portal/img/ppt.png"></c:if>
	              <c:if test="${z.wjgs eq 'XLS'}"><img class="imgIcon" src="<%=request.getContextPath()%>/portal/img/excel.png"></c:if>
	              <c:if test="${z.wjgs eq 'XLSX'}"><img class="imgIcon" src="<%=request.getContextPath()%>/portal/img/excel.png"></c:if>
		          <h3 title="${z.zymc}">${z.zymc }</h3>
              </a>
              <a style="cursor: default;">
              <p>资源类型：${z.zyxk }</p>
              <p>作者：${z.zz }</p>
              <p>上传日期：<fmt:formatDate pattern="yyyy-MM-dd" value="${z.scrq }" /></p>
             </a>
            </a>
          </div>
          </c:forEach>
           <c:if test="${empty myzys }"><div class="mycollect-delWords">你还没有上传任何资源，赶紧上传资源获取积分吧~</div></c:if>	
          <!--分页-->
          <div class="page">
            <%@ include file="/portal/jsp/common/pagenation.jsp"%>
          </div>
          <!--分页 end-->
        </div>
    </div>      
      </c:if>
      <c:if test="${option==3}">
         <div class="info-body">
       <div class="myresour-ul collection">
       <c:forEach items="${myzysc}" var="s">
      <div class="myresour-li">
         <div class="myCenter-hover">
          <c:if test="${ empty s.zy.fmlj}">
           		 <c:if test="${s.zy.wjgs =='DOCX' ||s.zy.wjgs =='DOC'}">
           			 <img  src="<%=request.getContextPath()%>/portal/img/word-large-def.png">
           		</c:if>
           		 <c:if test="${s.zy.wjgs =='XLSX' ||s.zy.wjgs =='XLS'}">
           			 <img  src="<%=request.getContextPath()%>/portal/img/excel-large-def.png">
           		</c:if>
           		 <c:if test="${s.zy.wjgs =='PPTX' ||s.zy.wjgs =='PPT'}">
           			 <img  src="<%=request.getContextPath()%>/portal/img/ppt-large-def.png">
           		</c:if>
           		 <c:if test="${s.zy.wjgs =='MP4'||s.zy.wjgs =='FLV'||s.zy.wjgs =='AVI'||s.zy.wjgs =='MOV'||s.zy.wjgs =='WMV'}">
           			 <img  src="<%=request.getContextPath()%>/portal/img/mp4-large-def.png">
           		</c:if>
           		 <c:if test="${s.zy.wjgs =='PDF'}">
           			 <img  src="<%=request.getContextPath()%>/portal/img/pdf-large-def.png">
           		</c:if>
	        </c:if> 
          
          
          
           <c:if test="${not  empty s.zy.fmlj}">
              <img  src="${fileServer}/file/${s.zy.fmlj}"> 
            </c:if>
             <div class="caption">         
             <span class="mycollect-del" title="取消收藏" onclick="cancel('${s.zyid }')">取消收藏</span>
          </div>
           </div>
          <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${s.zyid}" title="资源详情">
	         <c:if test="${s.zy.wjgs eq 'PDF'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/pdf.png"></c:if>
	          <c:if test="${s.zy.wjgs eq 'DOC'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/word.png"></c:if>
	          <c:if test="${s.zy.wjgs eq 'DOCX'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/word.png"></c:if>
	          <c:if test="${s.zy.wjgs =='MP4'||s.zy.wjgs =='FLV'||s.zy.wjgs =='AVI'||s.zy.wjgs =='MOV'||s.zy.wjgs =='WMV'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/mp41.png"></c:if>
	          <c:if test="${s.zy.wjgs eq 'PPT'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/ppt.png"></c:if>
	          <c:if test="${s.zy.wjgs eq 'PPTX'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/ppt.png"></c:if>
	          <c:if test="${s.zy.wjgs eq 'XLS'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/excel.png"></c:if>
	          <c:if test="${s.zy.wjgs eq 'XLSX'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/excel.png"></c:if>
	          <h3 title="${s.zy.zymc}">${s.zy.zymc }</h3>
          </a>
          <a style="cursor: default;">
          <p>资源类型：${s.zy.zyxk }</p>
          <p>作者：${s.zy.zz }</p>
          <p>收藏时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${s.scsj }" /></p>
         
         </a>
      </div>
      </c:forEach>
      
      <c:if test="${empty myzysc }"><div class="mycollect-delWords">你还没有收藏资源~</div></c:if>
      <div class="page">
        <%@ include file="/portal/jsp/common/pagenation.jsp"%>
      </div>
      <!--分页 end-->
    </div>
    </div>      
      </c:if>
      <c:if test="${option==4}">
        <div class="info-body">
        <div class="myresour-ul collection">
        <c:forEach items="${myzyll}" var="s">
      <div class="myresour-li mybrowse">
        <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${s.zyid}">
          <c:if test="${ empty s.zy.fmlj}">
           		 <c:if test="${s.zy.wjgs =='DOCX' ||s.zy.wjgs =='DOC'}">
           			 <img  src="<%=request.getContextPath()%>/portal/img/word-large-def.png">
           		</c:if>
           		 <c:if test="${s.zy.wjgs =='XLSX' ||s.zy.wjgs =='XLS'}">
           			 <img  src="<%=request.getContextPath()%>/portal/img/excel-large-def.png">
           		</c:if>
           		 <c:if test="${s.zy.wjgs =='PPTX' ||s.zy.wjgs =='PPT'}">
           			 <img  src="<%=request.getContextPath()%>/portal/img/ppt-large-def.png">
           		</c:if>
           		 <c:if test="${s.zy.wjgs =='MP4'||s.zy.wjgs =='FLV'||s.zy.wjgs =='AVI'||s.zy.wjgs =='MOV'||s.zy.wjgs =='WMV'}">
           			 <img  src="<%=request.getContextPath()%>/portal/img/mp4-large-def.png">
           		</c:if>
           		 <c:if test="${s.zy.wjgs =='PDF'}">
           			 <img  src="<%=request.getContextPath()%>/portal/img/pdf-large-def.png">
           		</c:if>
	        </c:if>
           <c:if test="${not  empty s.zy.fmlj}">
              <img  src="${fileServer}/file/${s.zy.fmlj}"> 
            </c:if>
            <c:if test="${s.zy.wjgs eq 'PDF'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/pdf.png"></c:if>
          <c:if test="${s.zy.wjgs eq 'DOC'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/word.png"></c:if>
          <c:if test="${s.zy.wjgs eq 'DOCX'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/word.png"></c:if>
          <c:if test="${s.zy.wjgs =='MP4'||s.zy.wjgs =='FLV'||s.zy.wjgs =='AVI'||s.zy.wjgs =='MOV'||s.zy.wjgs =='WMV'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/mp41.png"></c:if>
          <c:if test="${s.zy.wjgs eq 'PPT'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/ppt.png"></c:if>
          <c:if test="${s.zy.wjgs eq 'PPTX'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/ppt.png"></c:if>
          <c:if test="${s.zy.wjgs eq 'XLS'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/excel.png"></c:if>
          <c:if test="${s.zy.wjgs eq 'XLSX'}"><img class="imgIcon"  src="<%=request.getContextPath()%>/portal/img/excel.png"></c:if>
          <h3 title="${s.zy.zymc}">${s.zy.zymc }
         
          </h3>
          <p>资源类型：${s.zy.zyxk }</p>
          <p>作者：${s.zy.zz }</p>
          <p>浏览时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${s.llsj }" /></p>
        </a>
      </div>
      </c:forEach>
       <c:if test="${empty myzyll }"><div class="mycollect-delWords">你还没有浏览资源~</div></c:if>	
      <div class="page">
        <%@ include file="/portal/jsp/common/pagenation.jsp"%>
      </div>
      <!--分页 end-->
    </div>
    </div>       
      </c:if>
      <c:if test="${option==5}">
         <div class="info-body">
          <div class="comment-ul">
          <c:forEach items="${myzypl}" var="s">
         <div class="comment-li">
             <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${s.zyid}">
                 <div class="comment-left">
                	<c:if test="${ empty s.zy.fmlj}">
		           		 <c:if test="${s.zy.wjgs =='DOCX' ||s.zy.wjgs =='DOC'}">
		           			 <img  src="<%=request.getContextPath()%>/portal/img/word-large-def.png">
		           		</c:if>
		           		 <c:if test="${s.zy.wjgs =='XLSX' ||s.zy.wjgs =='XLS'}">
		           			 <img  src="<%=request.getContextPath()%>/portal/img/excel-large-def.png">
		           		</c:if>
		           		 <c:if test="${s.zy.wjgs =='PPTX' ||s.zy.wjgs =='PPT'}">
		           			 <img  src="<%=request.getContextPath()%>/portal/img/ppt-large-def.png">
		           		</c:if>
		           		 <c:if test="${s.zy.wjgs =='MP4'||s.zy.wjgs =='FLV'||s.zy.wjgs =='AVI'||s.zy.wjgs =='MOV'||s.zy.wjgs =='WMV'}">
		           			 <img  src="<%=request.getContextPath()%>/portal/img/mp4-large-def.png">
		           		</c:if>
		           		 <c:if test="${s.zy.wjgs =='PDF'}">
		           			 <img  src="<%=request.getContextPath()%>/portal/img/pdf-large-def.png">
		           		</c:if>
	        		</c:if>
                    <c:if test="${not  empty s.zy.fmlj}">
                          <img  src="${fileServer}/file/${s.zy.fmlj}"> 
                     </c:if>
                     <p>${s.zy.zymc }</p>
                 </div>
                 <div class="comment-right">
                     <p class="comment-ping"><span>最新评论：</span>${s.plnr }</p>
                     <p class="comment-time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${s.plsj }" /></p>
                 </div>
             </a>
         </div>
         </c:forEach>
          <c:if test="${empty myzypl }"><div class="mycollect-delWords">你还没有评论任何资源~</div></c:if>	
          <div class="page">
              <%@ include file="/portal/jsp/common/pagenation.jsp"%>
          </div>
          <!--分页 end-->
     </div>
      </div>      
      </c:if>
      <c:if test="${option==6}">
        <div class="info-body">
      <div class="notice-ul">
      <c:forEach items="${tzggs}" var="t">
         <div class="notice-li">
            <div class="notice-left">
                <i class="icon-gonggao"></i>
            </div>
             <div class="notice-right">
                 <h2><a href="/${projectName}/portal/space/main/schTzggById.action?id=${t.id}">${t.tzbt }</a><span><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${t.cjsj }" /></span></h2>
                 <p class="notice-title">${t.tznr }</p>
                 <!-- <p class="notice-del"><span>已读</span></p> -->
             </div>
         </div>
         </c:forEach>
          <div class="page">
              <%@ include file="/portal/jsp/common/pagenation.jsp"%>
          </div>
          <!--分页 end-->
     </div>
   </div>       
      </c:if>
      <c:if test="${option==7}">
        <div class="info-body">
          <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
      <ul class="layui-tab-title">
        <li class="layui-this"><a href="/${projectName}/portal/space/main/schPerCenter.action?option=7">我的下载日志</a></li>
        <!-- <li>我的资源下载日志</li> -->
        <li><a href="/${projectName}/portal/space/main/schPerCenter.action?option=8">我的资源下载日志</a></li>
      </ul>
      <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
           <ul class="download-ul">
                <li class="download-title">
                     <span class="download-title1">资源信息</span>
                     <span class="download-title2">下载信息</span>
                     <span class="download-title3">操作</span>
                </li>
                <c:forEach items="${mydows}" var="s">
               <li class="download-li">
                   <div class="download1">
                        <div class="download1-left">
                            <c:if test="${empty s.zy.fmlj}">
                            	<c:if test="${ empty s.zy.fmlj}">
					           		 <c:if test="${s.zy.wjgs =='DOCX' ||s.zy.wjgs =='DOC'}">
					           			 <img  class="downliad1-img" src="<%=request.getContextPath()%>/portal/img/word-large-def.png">
					           		</c:if>
					           		 <c:if test="${s.zy.wjgs =='XLSX' ||s.zy.wjgs =='XLS'}">
					           			 <img  class="downliad1-img" src="<%=request.getContextPath()%>/portal/img/excel-large-def.png">
					           		</c:if>
					           		 <c:if test="${s.zy.wjgs =='PPTX' ||s.zy.wjgs =='PPT'}">
					           			 <img class="downliad1-img" src="<%=request.getContextPath()%>/portal/img/ppt-large-def.png">
					           		</c:if>
					           		 <c:if test="${s.zy.wjgs =='MP4'||s.zy.wjgs =='FLV'||s.zy.wjgs =='AVI'||s.zy.wjgs =='MOV'||s.zy.wjgs =='WMV'}">
					           			 <img class="downliad1-img" src="<%=request.getContextPath()%>/portal/img/mp4-large-def.png">
					           		</c:if>
					           		 <c:if test="${s.zy.wjgs =='PDF'}">
					           			 <img class="downliad1-img" src="<%=request.getContextPath()%>/portal/img/pdf-large-def.png">
					           		</c:if>
	       						 </c:if>
                          </c:if>
                            
                            <c:if test="${not  empty s.zy.fmlj}">
                               <img class="downliad1-img" src="${fileServer}/file/${s.zy.fmlj}"> 
                            </c:if>
                            <%-- <img class="download1-type" src="<%=request.getContextPath()%>/portal/img/video.png"> --%>
                            <c:if test="${s.zy.wjgs eq 'PDF'}"><img class="download1-type"  src="<%=request.getContextPath()%>/portal/img/pdf2.png"></c:if>
                            <c:if test="${s.zy.wjgs eq 'DOC'}"><img class="download1-type"  src="<%=request.getContextPath()%>/portal/img/word2.png"></c:if>
                            <c:if test="${s.zy.wjgs eq 'DOCX'}"><img class="download1-type"  src="<%=request.getContextPath()%>/portal/img/word2.png"></c:if>
                            <c:if test="${s.zy.wjgs =='MP4'||s.zy.wjgs =='FLV'||s.zy.wjgs =='AVI'||s.zy.wjgs =='MOV'||s.zy.wjgs =='WMV'}"><img class="download1-type"  src="<%=request.getContextPath()%>/portal/img/mp42.png"></c:if>
                            <c:if test="${s.zy.wjgs eq 'PPT'}"><img class="download1-type" src="<%=request.getContextPath()%>/portal/img/ppt2.png"></c:if>
                            <c:if test="${s.zy.wjgs eq 'PPTX'}"><img  class="download1-type" src="<%=request.getContextPath()%>/portal/img/ppt2.png"></c:if>
                            <c:if test="${s.zy.wjgs eq 'XLS'}"><img class="download1-type" src="<%=request.getContextPath()%>/portal/img/excel2.png"></c:if>
                            <c:if test="${s.zy.wjgs eq 'XLSX'}"><img class="download1-type" src="<%=request.getContextPath()%>/portal/img/excel2.png"></c:if>
                        </div>
                        <div class="download1-right">
                            <h2><a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${s.zyid}">${s.zy.zymc }</a></h2>
                            <p>资源上传人：${s.zy.scr }</p>
                        </div>
                   </div>
                  <div class="download2">
                     <p>时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${s.xzsj }" /></p>
                     <p>大小：${s.zy.wjdx }</p>
                  </div>
                  <div class="download3">
                      <a href="javascript:void(0)" onclick="downloadzy('${s.zyid }')" title="重新下载">重新下载</a>
                  </div>
               </li>
               </c:forEach>
               <c:if test="${empty mydows }"><div class="mycollect-delWords">你还没有下载任何资源~</div></c:if>	
             <div class="page">
               <%@ include file="/portal/jsp/common/pagenation.jsp"%>
             </div>
             <!--分页 end-->
           </ul>
        </div>
      </div>
    </div>
      </div>       
      </c:if>
      <c:if test="${option==8}">
        <div class="info-body">
          <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
      <ul class="layui-tab-title">
        <li><a href="/${projectName}/portal/space/main/schPerCenter.action?option=7">我的下载日志</a></li>
        <!-- <li>我的资源下载日志</li> -->
        <li  class="layui-this"><a href="/${projectName}/portal/space/main/schPerCenter.action?option=8">我的资源下载日志</a></li>
      </ul>
      <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <ul class="download-ul">
                <li class="download-title">
                    <span class="download-title1">资源信息</span>
                    <span class="download-title2">浏览信息</span>
                    <span class="download-title3">操作</span>
                </li>
                <c:forEach items="${dowsmy}" var="d">
                <li class="download-li">
                    <div class="download1">
                        <div class="download1-left">
                        <c:if test="${empty d.zy.fmlj}">
                            	<c:if test="${ empty d.zy.fmlj}">
					           		 <c:if test="${d.zy.wjgs =='DOCX' ||d.zy.wjgs =='DOC'}">
					           			 <img  class="downliad1-img" src="<%=request.getContextPath()%>/portal/img/word-large-def.png">
					           		</c:if>
					           		 <c:if test="${d.zy.wjgs =='XLSX' ||d.zy.wjgs =='XLS'}">
					           			 <img  class="downliad1-img" src="<%=request.getContextPath()%>/portal/img/excel-large-def.png">
					           		</c:if>
					           		 <c:if test="${d.zy.wjgs =='PPTX' ||d.zy.wjgs =='PPT'}">
					           			 <img class="downliad1-img" src="<%=request.getContextPath()%>/portal/img/ppt-large-def.png">
					           		</c:if>
					           		 <c:if test="${d.zy.wjgs =='MP4'||d.zy.wjgs =='FLV'||d.zy.wjgs =='AVI'||d.zy.wjgs =='MOV'||d.zy.wjgs =='WMV'}">
					           			 <img class="downliad1-img" src="<%=request.getContextPath()%>/portal/img/mp4-large-def.png">
					           		</c:if>
					           		 <c:if test="${d.zy.wjgs =='PDF'}">
					           			 <img class="downliad1-img" src="<%=request.getContextPath()%>/portal/img/pdf-large-def.png">
					           		</c:if>
	       						 </c:if>
                          
                          </c:if>  
                            <c:if test="${not  empty d.zy.fmlj}">
                               <img class="downliad1-img" src="${fileServer}/file/${d.zy.fmlj}"> 
                            </c:if>
                            <%-- <img class="download1-type" src="<%=request.getContextPath()%>/portal/img/video.png"> --%>
                            <c:if test="${d.zy.wjgs eq 'PDF'}"><img class="download1-type"  src="<%=request.getContextPath()%>/portal/img/pdf2.png"></c:if>
                            <c:if test="${d.zy.wjgs eq 'DOC'}"><img class="download1-type"  src="<%=request.getContextPath()%>/portal/img/word2.png"></c:if>
                            <c:if test="${d.zy.wjgs eq 'DOCX'}"><img class="download1-type"  src="<%=request.getContextPath()%>/portal/img/word2.png"></c:if>
                            <c:if test="${d.zy.wjgs =='MP4'||d.zy.wjgs =='FLV'||d.zy.wjgs =='AVI'||d.zy.wjgs =='MOV'||d.zy.wjgs =='WMV'}"><img class="download1-type"  src="<%=request.getContextPath()%>/portal/img/mp42.png"></c:if>
                            <c:if test="${d.zy.wjgs eq 'PPT'}"><img class="download1-type" src="<%=request.getContextPath()%>/portal/img/ppt2.png"></c:if>
                            <c:if test="${d.zy.wjgs eq 'PPTX'}"><img  class="download1-type" src="<%=request.getContextPath()%>/portal/img/ppt2.png"></c:if>
                            <c:if test="${d.zy.wjgs eq 'XLS'}"><img class="download1-type" src="<%=request.getContextPath()%>/portal/img/excel2.png"></c:if>
                            <c:if test="${d.zy.wjgs eq 'XLSX'}"><img class="download1-type" src="<%=request.getContextPath()%>/portal/img/excel2.png"></c:if>
                        </div>
                        <div class="download1-right">
                            <h2><a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${d.zyid}">${d.zy.zymc }</a></h2>
                            <p>时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${d.xzsj }" /></p>
                            <p>大小：${d.zy.wjdx }</p>
                        </div>
                    </div>
                    <div class="download2">
                        <p>下载量：${d.zy.xzcs }</p>
                        <p>浏览量：${d.zy.llcs }</p>
                    </div>
                    <div class="download3">
                        <a href="javascript:void(0)" onclick="downloadzy('${d.zyid }')" title="重新下载">重新下载</a>
                    </div>
                </li>
                </c:forEach>
                   <c:if test="${empty dowsmy }"><div class="mycollect-delWords">你的资源还没有被下载~</div></c:if>	
                <!--分页-->
                <div class="page">
                    <%@ include file="/portal/jsp/common/pagenation.jsp"%>
                </div>
                <!--分页 end-->
            </ul>
        </div>
      </div>
    </div>
      </div>       
      </c:if>
  </div>
  <div class="height30"></div>
  </div>
  </div>
  <!--尾部-->
  	<%@include file="/portal/jsp/common/footer.jsp" %>
  <!--尾部 end-->
  <!-- 登录框 -->
   	<%@include file="/portal/jsp/common/loginbox.jsp" %>
   <!-- 登录框 end -->
  <!--尾部 end-->

    <script type="text/javascript">
    function del(id){
 	   var ids = [];
 	   ids.push(id);
 	  layer.confirm('确定删除', {icon: 3, title:'提示'}
      ,function(){
          $.get("/${projectName}/portal/space/main/delZy.action",{ids:ids},function(data){
        	  layer.msg('删除成功', {icon: 1});
	 		   window.location.reload();
				});
          
      }
      , function(index){
          layer.close(index);
      });
    }
    function phsd(){
		var zylxIds="";
		var checkAll = $(".prefer-body input[type=checkbox]:checkbox");
		var flay = false;
		for(var i=0;i<checkAll.length;i++){
			if(checkAll[i].checked){
				if(zylxIds!=""){
					zylxIds += ",";
				}
				flay=true;
				zylxIds += checkAll.get(i).value;
			}
		}
		if(!flay){
			layer.msg('请选择偏好！',{icon:2});
			return false;
		}
		layer.confirm('确认选择？', {icon: 3, title:'提示'}
	      ,function(){
	    	  $.get("/${projectName}/portal/space/main/updPhsdByUser.action",{zylxIds:zylxIds},function(data){
	        	  layer.msg('设定成功', {icon: 1});
		 		   window.location.reload();
					});
	          
	      }
	      , function(index){
	          layer.close(index);
	      });

  }
    <%-- 取消收藏 --%>
    function cancel(id){
    	layer.confirm('确认选择？', {icon: 3, title:'提示'}
	      ,function(){
	    	  $.get("/${projectName}/portal/zygl/resource/collectzy.action",{'id':id,fav:0},function(data){
	        	  layer.msg('设定成功', {icon: 1});
		 		   window.location.reload();
					});
	          
	      }
	      , function(index){
	          layer.close(index);
	      });
    }
    
    function GetQueryString(name) {
    	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    	var r = window.location.search.substr(1).match(reg);
    	if (r!=null) return (r[2]); return null;
    }
    var opt = GetQueryString("option");
    if(opt==2){
    	var pageUrl='<%=request.getContextPath()%>/portal/space/main/schPerCenter.action?option=2'
    }if(opt==3){
    	var pageUrl='<%=request.getContextPath()%>/portal/space/main/schPerCenter.action?option=3'
    }if(opt==4){
    	var pageUrl='<%=request.getContextPath()%>/portal/space/main/schPerCenter.action?option=4'
    }if(opt==5){
    	var pageUrl='<%=request.getContextPath()%>/portal/space/main/schPerCenter.action?option=5'
    }if(opt==6){
    	var pageUrl='<%=request.getContextPath()%>/portal/space/main/schPerCenter.action?option=6'
    }if(opt==7){
    	var pageUrl='<%=request.getContextPath()%>/portal/space/main/schPerCenter.action?option=7'
    }if(opt==8){
    	var pageUrl='<%=request.getContextPath()%>/portal/space/main/schPerCenter.action?option=8'
    }
    </script>
  </body>
</html>
