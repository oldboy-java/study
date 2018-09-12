<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/portal/jsp/common/head-top.jsp" %>
  </head>
  <body class="huibg">
  <!--头部-->
  <div class="header-top header-center">
    <div class="all-content">
      <%@include file="/portal/jsp/common/head.jsp" %>
    </div>
  </div>
  <!--头部 end-->
 <div class="info-img"></div>
  <div class="all-content notice-details">
      <div class="notice-details-left">
          <div class="no-details-top">
               <a>当前位置：</a>
               <a href="/${projectName}/portal/index.action">首页 &gt;</a>
               <a href="/${projectName}/portal/space/main/schPerCenter.action?option=6">通知公告 &gt;</a>
                <a>内容页</a>
          </div>
          <div class="no-details-title">
              <h1>${tzbt }</h1>
              <span>来源：教学资源综合管理平台</span><span>时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${cjsj }" /></span>
          </div>
          <div class="no-details-body">
              <p>${tznr }</p>
              
          </div>
      </div>
      <div class="notice-details-right">
          <h2 class="no-details-right-title">最新通知 </h2>
          <c:forEach items="${tzggNewList}" var="t" varStatus="status">
          <div class="no-details-list no-details-hot">
              <a href="/${projectName}/portal/space/main/schTzggById.action?id=${t.id}">
                  <span class="no-details-span"><c:out value="${status.index+1}"/></span>
                  <div class="no-details-div">
                      <p>${t.tzbt }</p>
                      <span><i class="icon-time"></i> <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${t.cjsj }" /></span>
                  </div>
              </a>
          </div>
          </c:forEach>
      </div>
  </div>
  <div class="height30"></div>
  <!--尾部-->
  	<%@include file="/portal/jsp/common/footer.jsp" %>
  <!--尾部 end-->
   <!-- 登录框 -->
   	<%@include file="/portal/jsp/common/loginbox.jsp" %>
   <!-- 登录框 end -->
    <script src="<%=request.getContextPath()%>/portal/js/lib/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/portal/js/lib/layui/layui.all.js"></script>
    <script src="<%=request.getContextPath()%>/portal/js/all.js"></script>
  </body>
</html>