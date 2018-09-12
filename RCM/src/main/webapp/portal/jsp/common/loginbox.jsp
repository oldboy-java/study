<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
 <!--登录弹框-->
  <div  class="index-form-shade"></div>
  <div class="index-form">
    <form class="layui-form"  action="#" method="post">
      <p class="login-title"><span>用户登录</span></p><i class="layui-icon close-icon">&#x1006;</i>
      <input type="text" id="loginname" name="loginname" lay-verify="required" autocomplete="off" placeholder="请输入用户名" class="layui-input">
      <input type="password" id="password" name="password" lay-verify="required" autocomplete="off" placeholder="请输入密码" class="layui-input">
      <p class="login-reg">
        <!-- <input type="checkbox" name="like1[write]" lay-skin="primary" title="自动登录" checked="">
        <a href="">忘记密码</a> -->
       </p>
      <button class="layui-btn form-login" lay-submit="" id="doLogin" type="submit"  lay-filter="login">登录</button>
    </form>
  </div>
  <!--登录弹框 end-->
    <script src="<%=request.getContextPath()%>/portal/js/lib/layui/layui.all.js"></script>
     <script src="<%=request.getContextPath()%>/portal/js/lib/video.min.js"></script>
    <script src="<%=request.getContextPath()%>/portal/js/all.js"></script>
  </body>
  <script type="text/javascript">
  $(function(){
		
		$('#doLogin').on("click",function(e){
			e.preventDefault();
			var loginname = $('#loginname').val();
			var password = $('#password').val();
			doLogin(loginname,password);
		});
		
		$("#logoutbtn").click(function(){
			$.get("/${projectName}/portal/zygl/login/logout.action",function(data){
				document.location="/${projectName}/portal/index.action";
			});
		});
	})
	
	function doLogin(_loginname,_password){
	   $.ajax({
          type: 'post', 
          url: '/${projectName}/portal/zygl/login/login.action', 
          data: {
              'loginname':_loginname,
              'password':_password
          },
          success: function(data) {
          	//将Json字符串转JSON对象
            data = $.parseJSON(data);
             var code = data.code;
             var d=data.data;
             if(code==1&&d==null) {
            	 $(".index-form-shade").css("display","none");
            	 $(".index-form").css("display","none");
          	     window.location.reload();
          	     
             }else if(code==1&&d==2){
            	 $(".index-form-shade").css("display","none");
            	 $(".index-form").css("display","none");
            	 window.location.href = '/${projectName}/portal/space/main/phsd.action';
             }else{
            	 layer.msg(data.message,{icon:2});
          	    /*  alert(data.message); */
             }
          }
 		 }); 
  }

	function showResList(id,name,wjgs,type,zymc){
		if(type==undefined){
			type='';
		}
		if(wjgs==undefined){
			wjgs = '';
		}
		if(zymc==undefined){
			zymc = '';
		}
   		window.location.href  = '/${projectName}/portal/schSoftware.action?ssxkid='+id+'&name='+encodeURIComponent(encodeURIComponent(name))+'&wjgs='+wjgs+'&type='+type+'&zymc='+encodeURIComponent(encodeURIComponent(zymc));
   	}
	
	function doSearch(id,name,wjgs,type){
		var zymc = $('#zymc').val();
		zymc = $.trim(zymc);
		showResList(id,name,wjgs,type,zymc);
	}
	
	/*搜索框绑定回车查询事件--*/
	$('#zymc').on('keypress',function(e){  
	    if(e.keyCode == "13"){  
	    	var bt = $.trim($('#bt').val());
		    doSearch('${param.ssxkid}','${name }','${param.wjgs}','${param.type}');	           
	    }  
	});  
</script>
 
