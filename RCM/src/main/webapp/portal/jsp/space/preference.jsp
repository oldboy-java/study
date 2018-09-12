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
  <div class="wrap">
  <div class="innerhtml">
  <!--头部-->
  <div class="header-top">
    <div class="all-content">
      <span><a href="">教学资源平台</a></span>
      <!--未登录时-->
      <c:if test="${empty PORTAL_SESSION_USER}">
          <span class="login" onclick="login()">登录</span>
      </c:if>
      <!--未登录时end-->
       <!--登录后-->
       <c:if test="${not empty PORTAL_SESSION_USER}">
          <div class="login">
            <span class="icon-user"></span>
            <span><a href="" >${PORTAL_SESSION_USER.username}</a></span>
            <span><a onclick="passwordEdit()" title="修改密码">修改密码</a></span>
            <span><a id="logoutbtn" href="#" title="退出">退出</a></span>
      </div> 
       </c:if>
      <!--登录后end-->
</div>
  </div>
  <!--头部 end-->
  <!--资源查询-->
  <%@include file="/portal/jsp/common/checkbox.jsp" %>
  <!--资源查询end-->
  <!--内容-->
  <div class="all-content">
      <p class="prefer-top">设定偏好</p>
      <form class="layui-form">
        <div class="prefer-choose">
            <input type="checkbox" name="zylxIds" lay-skin="primary" lay-filter="allChoose" autocomplete="off"><span>全选</span>
            <a href="javascript:void(0)" onclick="phsd()">完成</a>
        </div>
        <div class="prefer-body">
         <c:forEach items="${zylbList}" var="d">
          <div class="prefer-item">
             <span>${d.xkmc}</span>
             <input type="checkbox" name="zylxIds" value="${d.id }" lay-skin="primary" class="prefer-input" autocomplete="off">
             <i class="icon-gou"></i>
          </div>
          </c:forEach>
        </div>
      </form>
      
  </div>
  </div>
  </div>
  <!--内容 end-->
  <!--尾部-->
  	<%@include file="/portal/jsp/common/footer.jsp" %>
  <!--尾部 end-->
  <!--登录弹框-->

  <!--登录弹框 end-->
    <script src="<%=request.getContextPath()%>/portal/js/lib/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/portal/js/lib/layui/layui.all.js"></script>
    <script src="<%=request.getContextPath()%>/portal/js/lib/jquery.html5uploader.js"></script>
    <script src="<%=request.getContextPath()%>/portal/js/all.js"></script>
  </body>
  <script type="text/javascript">
  $(function(){
	  $("#logoutbtn").click(function(){
			$.get("/${projectName}/portal/zygl/login/logout.action",function(data){
				document.location="/${projectName}/portal/index.action";
			});
		});
  })
  
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
	    	  $.get("/${projectName}/portal/space/main/setPhsd.action",{zylxIds:zylxIds},function(data){
	        	  layer.msg('设定成功', {icon: 1});
	        	  document.location="/${projectName}/portal/index.action";
					});
	          
	      }
	      , function(index){
	          layer.close(index);
	      });

  }
  
  </script>
  
  
</html>