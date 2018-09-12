<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<div class="all-content">
      <span><a href="/${projectName}/portal/index.action" title="首页">教学资源平台</a></span>
      <!--未登录时-->
      <c:if test="${empty PORTAL_SESSION_USER}">
          <span class="login" onclick="login()">登录</span>
      </c:if>
      <!--未登录时end-->
       <!--登录后-->
       <c:if test="${not empty PORTAL_SESSION_USER}">
          <div class="login">
            <span class="icon-user"></span>
            <span><a href="/${projectName}/portal/space/main/schPerCenter.action?option=2" title="个人中心">${PORTAL_SESSION_USER.username}</a></span>
            <span><a onclick="passwordEdit()" title="修改密码">修改密码</a></span>
            <span><a id="logoutbtn" href="#" title="退出">退出</a></span>
      </div> 
       </c:if>
      <!--登录后end-->
</div>