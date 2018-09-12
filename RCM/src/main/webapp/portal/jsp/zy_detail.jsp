<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/portal/jsp/common/head-top.jsp" %>
  </head>
  <body class="huibg">
  <!--头部-->
  <div class="header-top">
    <%@include file="/portal/jsp/common/head.jsp" %>
  </div>
  <!--头部 end-->
  
  <!--内容-->
  <div class="all-content">
    <div class="details-left">
       <div class="details-top">
       		<input type="hidden" id='zyId' value="${zy.id }"/>
            <h1>${zy.zymc}</h1>
            <p>资源分类：<span>${zy.zyxk}</span></p>
             <span><i class="icon-eye"></i>${zy.llcs }</span>
             <span><i class="icon-shouchang"></i>${zy.sccs }</span>
             <span><i class="icon-dianzhang"></i>${zy.dzcs }</span>
             <span><i class="icon-huifu"></i>${zy.plcs }</span>
             <span><i class="icon-time"></i><fmt:formatDate value="${zy.scrq }" pattern="yyyy-MM-dd"/></span> 
        </div>
       <!--  视频播放 -->
        <div class="details-body-video" style="display:none">
          <div class="video-contenr">
            <video id="video_1" class="video-js vjs-default-skin vjs-big-play-centered" controls preload="none"  poster="<%=request.getContextPath()%>/portal/img/guodu.png">
            <!-- flv,mp4,avi,mov,wmv -->
             <c:set var="hzm" scope="request" value="${zy.hzm}" />
             <c:set var="zydz" scope="request" value="${zy.zydz}" />
            
            <%
            		String playUrl = (String)request.getAttribute("zydz");
            		playUrl = playUrl.substring(playUrl.lastIndexOf("/")+1,playUrl.lastIndexOf(".")).concat(".mp4");
            %>
            	<c:set var="zydz" scope="request" value="<%=playUrl %>" />
            
              <%-- <source src="${fileServer}/file/<%=request.getAttribute("zydz") %>" type='video/mp4' /> --%>
               <source src="${fileServer}/file/rcm/<%=request.getAttribute("zydz") %>" type='video/mp4' />
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
        
         <!-- 不支持预览 -->
        <div class="details-approve">
                          文件格式不支持预览，请下载使用
        </div>
        
        <div class="details-dian">
                   <span class="detailsNum">下载次数：${zy.xzcs }次</span>
                   <c:if test="${zy.xzjf > 0}"><span class="detailsNeed">所需：<b>${zy.xzjf}</b>积分</span></c:if>
                   <span class="detailsPerson">贡献者：${zy.scr }</span>
        </div>
        <div class="details-down">
        	<c:choose>
        		<c:when test="${isFav ==true}"> <a class="shou shou-this" title="收藏" onclick="fav(${zy.id},this);"><i class="icon-shouchang2"></i>收藏</a></c:when>
        		<c:when test="${isFav ==false}"> <a class="shou" title="收藏" onclick="fav(${zy.id},this);"><i class="icon-shouchang2"></i>收藏</a></c:when>
        	</c:choose>
          
          	<c:choose>
        		<c:when test="${isLike ==true}"> <a class="dian dian-this" title="点赞" onclick="like(${zy.id},this);"><i class="icon-dianzhang2"></i>点赞</a></c:when>
        		<c:when test="${isLike ==false}">  <a class="dian" title="点赞" onclick="like(${zy.id},this);"><i class="icon-dianzhang2"></i>点赞</a></c:when>
        	</c:choose>
           
            <a href="javascript:void(0)" onclick="downloadzy('${zy.id }',${zy.xzjf})" class="upload"><i class="icon-upload"></i>
            	<c:choose>
            		<c:when test="${zy.xzjf > 0}">积分下载</c:when>
            		<c:otherwise>免费下载</c:otherwise>
            	</c:choose>
            </a>

            <div class="bdsharebuttonbox">
                <a href="#" class="bds_more" data-cmd="more"></a>
                <a href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
                <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
                <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
                <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
                <p>赶快分享给好友吧</p>
            </div>
            <div class="details-ping">
                     <textarea class="layui-textarea" id="detailsPing" style="display: none"></textarea>
                     <button class="layui-btn form-ping" lay-submit="">评论</button>
            </div>
            <div class="details-content">
               <c:forEach items="${zyplList}" var="z" varStatus="status">
               <c:if test="${z.lx==1}">               
                <div class="details-list">
                    <img src="<%=request.getContextPath()%>/portal/img/face_80.jpg">
                    <div class="details-listR">
                        <h3 class="details-h3">${z.plrxm }</h3>
                        <div class="details-p">${z.plnr }</div>
                        <a class="huifu" title="回复"><i class="icon-huifu2"></i>回复</a>
                        <!-- <a class="dian2" title="点赞"><i class="icon-dianzhang2"></i>点赞</a> -->
                        <!--回复-->
                           <div class="details-huifu">
                                 
                                       <textarea class="layui-textarea" id="contentPing${status.index}" style="display: none"></textarea>
                                       <button class="layui-btn form-huifu" lay-submit=""  onclick="formHuifu('${status.index}','${z.plrxm }')">回复</button>
                                   
                           </div>
                        <!--回复 end-->
                    </div>
                </div>
                </c:if>
                <c:if test="${z.lx==2}">               
                <div class="details-list">
                    <img src="<%=request.getContextPath()%>/portal/img/face_80.jpg">
                    <div class="details-listR">
                        <h3 class="details-h3">${z.plrxm } 回复了 ${z.pls }</h3>
                        <div class="details-p">${z.plnr }</div>
                        <a class="huifu" title="回复"><i class="icon-huifu2"></i>回复</a>
                        <!-- <a class="dian2" title="点赞"><i class="icon-dianzhang2"></i>点赞</a> -->
                        <!--回复-->
                           <div class="details-huifu">
                                 
                                       <textarea class="layui-textarea" id="contentPing${status.index}" style="display: none"></textarea>
                                       <button class="layui-btn form-huifu" lay-submit=""  onclick="formHuifu('${status.index}','${z.plrxm }')">回复</button>
                                   
                           </div>
                        <!--回复 end-->
                    </div>
                </div>
                </c:if>
               </c:forEach>
                <%-- <div class="details-list">
                    <img src="<%=request.getContextPath()%>/portal/img/text.png">
                    <div class="details-listR">
                        <h3 class="details-h3">李某某</h3>
                        <div class="details-p">这个写的真好，点赞。这个写的真好，点赞这个写的真好，点赞这个写的真好，点赞这个写的真好，点赞这个写的真好，点赞这个写的真好，点赞</div>
                        <a class="huifu" title="回复"><i class="icon-huifu2"></i>回复</a>
                        <a class="dian2" title="点赞"><i class="icon-dianzhang2"></i>点赞</a>
                        <!--回复-->
                        <div class="details-huifu">
                                <textarea class="layui-textarea" id="contentPing1" style="display: none"></textarea>
                                <button class="layui-btn form-huifu" lay-submit="" onclick="formHuifu(1)">回复</button>
                        <!--回复 end-->
                    </div>
                </div> --%>
                <!--隐藏的评论-->
                <div class="details-none">
                    <c:forEach items="${moreList}" var="z" varStatus="status">
               <c:if test="${z.lx==1}">               
                <div class="details-list">
                    <img src="<%=request.getContextPath()%>/portal/img/face_80.jpg">
                    <div class="details-listR">
                        <h3 class="details-h3">${z.plrxm }</h3>
                        <div class="details-p">${z.plnr }</div>
                        <a class="huifu" title="回复"><i class="icon-huifu2"></i>回复</a>
                       <!--  <a class="dian2" title="点赞"><i class="icon-dianzhang2"></i>点赞</a> -->
                        <!--回复-->
                           <div class="details-huifu">
                                 
                                       <textarea class="layui-textarea" id="contentPing${status.index}" style="display: none"></textarea>
                                       <button class="layui-btn form-huifu" lay-submit=""  onclick="formHuifu('${status.index}','${z.plrxm }')">回复</button>
                                   
                           </div>
                        <!--回复 end-->
                    </div>
                </div>
                </c:if>
                <c:if test="${z.lx==2}">               
                <div class="details-list">
                    <img src="<%=request.getContextPath()%>/portal/img/face_80.jpg">
                    <div class="details-listR">
                        <h3 class="details-h3">${z.plrxm } 回复了 ${z.pls }</h3>
                        <div class="details-p">${z.plnr }</div>
                        <a class="huifu" title="回复"><i class="icon-huifu2"></i>回复</a>
                     <!--    <a class="dian2" title="点赞"><i class="icon-dianzhang2"></i>点赞</a> -->
                        <!--回复-->
                           <div class="details-huifu">
                                 
                                       <textarea class="layui-textarea" id="contentPing${status.index}" style="display: none"></textarea>
                                       <button class="layui-btn form-huifu" lay-submit=""  onclick="formHuifu('${status.index}','${z.plrxm }')">回复</button>
                                   
                           </div>
                        <!--回复 end-->
                    </div>
                </div>
                </c:if>
               </c:forEach>
                </div>
                <%-- <div class="details-list">
                        <img src="<%=request.getContextPath()%>/portal/img/text.png">
                        <div class="details-listR">
                            <h3 class="details-h3">李某某</h3>
                            <div class="details-p">这个写的真好，点赞。这个写的真好，点赞这个写的真好，点赞这个写的真好，点赞这个写的真好，点赞这个写的真好，点赞这个写的真好，点赞</div>
                            <a class="huifu" title="回复"><i class="icon-huifu2"></i>回复</a>
                            <a class="dian2" title="点赞"><i class="icon-dianzhang2"></i>点赞</a>
                            <!--回复-->
                            <div class="details-huifu">
                                <form>
                                    <textarea class="layui-textarea" id="contentPing2" style="display: none"></textarea>
                                    <button class="layui-btn form-huifu" lay-submit="" onclick="formHuifu(2)">回复</button>
                                </form>
                            </div>
                            <!--回复 end-->
                        </div>
                    </div> --%>
               
               <c:if test="${ not empty zyplList}">
               		 <!--隐藏的评论 end-->
               		 <c:if test="${fn:length(zyplList)>3}">
		                <div class="details-more" >  
		                    <span>更多评论</span>
		                </div>
	                </c:if>
               </c:if>
                
               
            </div>
        </div>
    </div>
    <div class="details-right">
        <div class="details-box">
            <div class="soft-right">
                <h1>相关资源</h1>
                <c:forEach items="${relatedZyList }" var="relatedZy">
                	 <div class="soft-list">
	                    <a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${relatedZy.id}">
                             <c:if test="${ empty relatedZy.fmlj}">
			             		 <c:if test="${relatedZy.wjgs =='DOCX' ||relatedZy.wjgs =='DOC'}">
			             			 <img  src="<%=request.getContextPath()%>/portal/img/word-small-def.png">
			             		</c:if>
			             		 <c:if test="${relatedZy.wjgs =='XLSX' ||relatedZy.wjgs =='XLS'}">
			             			 <img  src="<%=request.getContextPath()%>/portal/img/excel-small-def.png">
			             		</c:if>
			             		 <c:if test="${relatedZy.wjgs =='PPTX' ||relatedZy.wjgs =='PPT'}">
			             			 <img  src="<%=request.getContextPath()%>/portal/img/ppt-small-def.png">
			             		</c:if>
			             		 <c:if test="${relatedZy.wjgs =='MP4' || relatedZy.wjgs =='FLV' ||relatedZy.wjgs =='AVI'||relatedZy.wjgs =='MOV' ||relatedZy.wjgs =='WMV'}">
			             			 <img  src="<%=request.getContextPath()%>/portal/img/mp4-small-def.png">
			             		</c:if>
			             		 <c:if test="${relatedZy.wjgs =='PDF'}">
			             			 <img  src="<%=request.getContextPath()%>/portal/img/pdf-small-def.png">
			             		</c:if>
             				 </c:if>  
              
                            <c:if test="${not  empty relatedZy.fmlj}">
                                <img  src="${fileServer}/file/${relatedZy.fmlj}"> 
                            </c:if>
	                        <div class="soft-h4">
	                            <h4>${relatedZy.zymc }</h4>
	                           <!--  <p>我们都知道HTTP是无状态协议，那在WEB开发中我……</p> -->
	                            <span>
	                            <c:choose>
	                            	<c:when test="${relatedZy.wjgs == 'PDF'}"> <img src="/RCM/portal/img/pdf.png" style="width:16px;height:16px;margin-right:5px"></c:when>
	                            	<c:when test="${relatedZy.wjgs == 'DOC'}"> <img src="/RCM/portal/img/word.png" style="width:16px;height:16px;margin-right:5px"></c:when>
	                            	<c:when test="${relatedZy.wjgs == 'XLS' }"> <img src="/RCM/portal/img/excel.png" style="width:16px;height:16px;margin-right:5px"></c:when>
	                           		<c:when test="${relatedZy.wjgs == 'PPT' }"> <img src="/RCM/portal/img/ppt.png" style="width:16px;height:16px;margin-right:5px"></c:when>
	                           		<c:when test="${relatedZy.wjgs == 'DOCX'}"> <img src="/RCM/portal/img/word.png" style="width:16px;height:16px;margin-right:5px"></c:when>
	                            	<c:when test="${relatedZy.wjgs == 'XLSX' }"> <img src="/RCM/portal/img/excel.png" style="width:16px;height:16px;margin-right:5px"></c:when>
	                           		<c:when test="${relatedZy.wjgs == 'PPTX' }"> <img src="/RCM/portal/img/ppt.png" style="width:16px;height:16px;margin-right:5px"></c:when>
	                            	<c:when test="${relatedZy.wjgs == 'MP4'}"> <img src="/RCM/portal/img/mp41.png" style="width:16px;height:16px;margin-right:5px"></c:when>
	                            </c:choose>
	                           		 ${relatedZy.wjgs }</span> <span><i class="icon-eye"></i>${relatedZy.llcs }次
	                            </span>
	                        </div>
	                    </a>
               		 </div>
                </c:forEach>
            </div>
        </div>

      <div class="details-box">
            <div class="soft-right">
                <h1>大家都关注</h1>
                <div class="soft-title">
                	<c:forEach items="${followZyList}" var="followZy" varStatus="status">
                		  <c:if test="${status.index %2==0 }"><p class="soft-big"  ><a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${followZy.id}">${followZy.zymc }</a></p></c:if> 
                		   <c:if test="${status.index %2==1 }"><p class="soft-small"  ><a href="/${projectName}/portal/zygl/resource/detail.action?zyId=${followZy.id}">${followZy.zymc }</a></p></c:if> 
                	</c:forEach>
                </div>
            </div>
        </div> 
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
   
    
   <script src="<%=request.getContextPath()%>/portal/js/baidushar.js"></script>
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
        		$(".details-body").append("<iframe src='/${projectName}/js/pdfjs/web/viewer.html?file=${fileServer}/file/rcm/"+pdfUrl+"' id='iframe' name='iframe' style='width:100%;' frameborder='0' scrolling='no' height='730px' ></iframe> ");
	    	});
	    	
   		 </script>
   </c:when>  
   
    <c:when test="${zy.hzm!='.mp4' && zy.hzm!='.flv'&& zy.hzm!='.avi' && zy.hzm!='.wmv' && zy.hzm!='.mov'  && zy.shzt==1}"> 
   		<script type="text/javascript">
   			$('.details-body-video').hide();
   			$(".details-body").hide();
   			$('.details-worr').hide();
	    	$('.details-approve').show();
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
   
   
   <c:when test="${zy.hzm!='.doc' &&  zy.hzm!='.docx' && zy.hzm!='.ppt' && zy.hzm!='.pptx' && zy.hzm!='.xls' && zy.hzm!='.xlsx' && zy.hzm!='.mp4' && zy.shzt==1}"> 
   		<script type="text/javascript">
   			$('.details-body-video').hide();
   			$(".details-body").hide();
   			$('.details-worr').hide();
	    	$('.details-approve').show();
   		</script>	
   </c:when>  
   
   
    <c:when test="${zy.hzm=='.mp4' && zy.shzt==1}"> 
   		<script type="text/javascript">
   			$('.details-body-video').hide();
   			$(".details-body").hide();
   			$('.details-worr').hide();
	    	$('.details-approve').show();
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
