var carousel = layui.carousel
    ,form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate
    ,element = layui.element
    ,upload = layui.upload;

//首页轮播
carousel.render({
    elem: '#indexBanner'
    ,interval: 1800
    ,anim: 'fade'
    ,arrow:'none'
    ,width: '100%'
    ,height: '360px'
});
//首页登录
function login(){
    $(".index-form-shade").css("display","block");
    $(".index-form").css("display","block");
}
$(".close-icon").click(function(){
    $(".index-form-shade").css("display","none");
    $(".index-form").css("display","none");
});
//首页更多
$(".nav-more").mouseout(function(){
    $(".nav-none").css("display","block");
    $(".nav-more").css("display","none");
});
$(".nav-none").mouseleave(function(){
    $(".nav-none").css("display","none");
    $(".nav-more").css("display","block");
});

//大家关注-颜色随机
$(".soft-title p").each(function(){
    var parr =["sfot-color1","sfot-color2","sfot-color3","sfot-color4","sfot-color5"];//将4个不同的class组成一个数组
    var index = Math.floor((Math.random()*parr.length));//从数组中随机获取一个数
    $(this).addClass(parr[index]);//将随机获取的class赋值给不同的div
});

//视频播放
if($("#video_1").length>0){
    videojs("video_1", {}, function(){
        var myPlayer = videojs('video_1');
        videojs("video_1").ready(function(){
            var myPlayer = this;
            //myPlayer.play();
            if($(".news-video").length>0){
                myPlayer.pause();
            }
            //视频点击暂停
            myPlayer.on("pause", function(){
                $(".vjs-big-play-button").css("display","block");
                $(".vjs-poster").css("display","block");
            });
            //视频点击播放
            myPlayer.on("play", function(){
                $(".vjs-big-play-button").css("display","none");
                $(".vjs-poster").css("display","none");
            });
        });
    });
}


//收藏
function fav(id,obj){
	var _login = checkLogin();
	if(_login.login==false){
		$('.login').click();
		return;
	}
    var thisLi = $(obj);
    if (thisLi.hasClass('shou-this')) {
        $.post(favUrl+'?fav=0',{id:id},function(data){
        	 layer.msg('取消收藏', {icon: 1});
        	 thisLi.removeClass('shou-this');
		});
        
    } else {
        $.post(favUrl+'?fav=1',{id:id},function(data){
        	 thisLi.addClass('shou-this');
        	 layer.msg('收藏成功', {icon: 1});
		});
       
    }
}

//点赞
function like(id,obj){
	var _login = checkLogin();
	if(_login.login==false){
		$('.login').click();
		return;
	}
    var thisLi = $(obj);
    if (thisLi.hasClass('dian-this')) {
        $.post(likeUrl+'?like=0',{id:id},function(data){
        	layer.msg('取消点赞', {icon: 1});
        	 thisLi.removeClass('dian-this');
		});
        
    } else {
        $.post(likeUrl+'?like=1',{id:id},function(data){
        	 thisLi.addClass('dian-this');
        	 layer.msg('点赞成功', {icon: 1});
		});
       
    }
}

$(".dian2").click(function(){
    var thisLi = $(this);
    if (thisLi.hasClass('dian2-this')) {
        thisLi.removeClass('dian2-this');
        layer.msg('取消点赞', {icon: 1});
    } else {
        thisLi.addClass('dian2-this');
        layer.msg('点赞成功', {icon: 1});
    }
});

//评论编辑器
var dateailsPing = layedit.build('detailsPing', {
    tool: ['face', 'left', 'center', 'right']
    ,height: 160
});

$(".form-ping").click(function(){
	var _login = checkLogin();
	if(_login.login==false){
		$('.login').click();
		return;
	}
    
    var plnr=layedit.getContent(dateailsPing);
    if($.trim(plnr)==''){
    	layer.msg('评论内容不能为空', {icon: 2});
    	return;
    }
	$.post(commentUrl,{'zyid':$('#zyId').val(),'plnr':plnr},function(data){
		window.location.reload();
	});
});

//回复
$(".huifu").click(function(){
    //回复点击事件
	var _login = checkLogin();
	if(_login.login==false){
		$('.login').click();
		return;
	}
    $(this).parent().children(".details-huifu").toggle();
});

function formHuifu(j,pls){
	var plnr=layedit.getContent(index[j]);
	if($.trim(plnr)==''){
    	layer.msg('评论内容不能为空', {icon: 2});
    	return;
    }
	$.get(applyUrl,{'plnr':plnr,'zyid':$('#zyId').val(),'pls':pls},function(data){
		window.location.href='/RCM/portal/zygl/resource/detail.action?zyId='+$('#zyId').val();
	});
}

var listlength = $(".huifu").size();
var index = new Array();
for(var i=0;i<listlength;i++){
    index[i] = layedit.build('contentPing'+i, {
        tool: ['face', 'left', 'center', 'right']
        ,height: 88
    });
}

//更多评论
$(".details-more span").click(function(){
    $(".details-none").css("display","block");
    $(".details-more").css("display","none");
    var listlength = $(".huifu").size();
    for(var i=0;i<listlength;i++){
        index[i] = layedit.build('contentPing'+i, {
            tool: ['face', 'left', 'center', 'right']
            ,height: 88
        });
    }
});

//偏好 全选
var rethis = "false";
form.on('checkbox(allChoose)', function(data){
    if(rethis == "false"){
        $("input[type='checkbox']").attr("checked","checked");//添加选中
        $(".layui-form-checkbox").addClass("layui-form-checked");//添加选中样式
        $(".icon-gou").css("display","block");
        rethis ="true";
    }else{
        $("input:checkbox").removeAttr("checked");
        $(".layui-form-checkbox").removeClass("layui-form-checked");
        $(".icon-gou").css("display","none");
        rethis ="false";
    }
});
//单选
$(".prefer-item").click(function(){
    var reinput = $(this).children('input');
    if(reinput.attr("checked")){
        reinput.removeAttr("checked");
        $(this).children(".icon-gou").css("display","none");
        reinput.parent().children('.layui-form-checkbox').removeClass("layui-form-checked");
    }else{
        reinput.attr("checked","checked");//添加选中
        $(this).children(".icon-gou").css("display","block");
    }
});
//偏好-颜色随机
$(".prefer-item").each(function(){
    var parr =["preferColor1","preferColor2","preferColor3","preferColor4","preferColor5","preferColor6","preferColor7","preferColor8","preferColor9"];//将4个不同的class组成一个数组
    var index = Math.floor((Math.random()*parr.length));//从数组中随机获取一个数
    $(this).addClass(parr[index]);//将随机获取的class赋值给不同的div
});
//默认选中
$(function(){
    $("input[checked=checked]").parent().children(".icon-gou").css("display","block");
});
//我的资源
$(function(){
    $(".myCenter-hover").hover(
        function(){
            var that=this;
           // item2Timer=setTimeout(function(){
                $(that).find('div.caption').slideDown();
           // },100);
        },
        function(){
            var that=this;
            //clearTimeout(item2Timer);
            $(that).find('div.caption').slideUp();
        }
    );
});


//批量上传
function resourceAdd(id){
    layer.open({
        type: 2,
        shadeClose: true, //点击遮罩关闭
        skin: 'myresoure-lan', //样式类名
        closeBtn: 1, //不显示关闭按钮
        area: ['790px', '57%'],
        anim: 1,
        title: ['上传资源', 'font-size:16px;'],
        content: '/RCM/portal/space/zy/addResourcePage.action?zyId='+id
    });
}
//批量上传点击提交时
form.on('submit(resourceAdd)', function(data){
	var li_count = $(".filelist").find("li").length;
	var tag = $('#tag').val();
	
	var zyztCheckedLen = $('input[type="radio"]:checked').length; 
	if(zyztCheckedLen == 0) {
		layer.msg('请选择共享与否', {icon: 5});
		return;
	}
	
	tag = $.trim(tag);
	if(tag!=''){
		if(tag.length > 50){
			layer.msg('标签长度不能超过50个字符', {icon: 5});
			return;
		}
	}
	
	if(li_count==0){
		layer.msg('请上传资源', {icon: 5});
		return;
	}
	
    $.ajax({
		dataType : 'json',
		url : '/RCM/portal/space/zy/updZy.action',
		type : 'post', 
		async : false,
		data: $("#form").serialize(),
		success : function(response) {
			if(response.data == 1) {
				var classindex = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(classindex);
				parent.window.location.reload();
			}else{
				layer.msg('上传资源失败', {icon: 2});
			}
		}
    });
   
   
});

//修改密码
function passwordEdit(){
    layer.open({
        type: 2,
        shadeClose: true, //点击遮罩关闭
        skin: 'myresoure-lan', //样式类名
        closeBtn: 1, //不显示关闭按钮
        area: ['500px', '300px'],
        anim: 1,
        title: ['修改密码', 'font-size:16px;'],
        content: '/RCM/portal/zygl/login/toUpdPass.action'
    });
}
//修改密码点击提交时
form.on('submit(info)', function(data){
    var mypost = JSON.stringify(data.field);//提交的资料
    var classindex = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(classindex);
});
//修改密码2次密码一致
form.verify({
    rePassword: function(value) {
        if (value === "")
            return "请输入第二次的密码！";
        var pwd = $('input[name=password]').val();
        if (pwd !== value)
            return "两次输入的密码不一致！";
    }
});
//关闭弹框
function infoclose(){
    var classindex = parent.layer.getFrameIndex(window.name);
    parent.layer.close(classindex);
}
//修改密码2
function passwordEdit2(){
    layer.open({
        type: 2,
        shadeClose: true, //点击遮罩关闭
        skin: 'myresoure-lan', //样式类名
        closeBtn: 1, //不显示关闭按钮
        area: ['500px', '300px'],
        anim: 1,
        title: ['修改密码', 'font-size:16px;'],
        content: '/RCM/portal/zygl/login/toLogin.action'
    });
}


		
function checkLogin(){
	var result = [];
	 $.ajax({
          type: 'post', 
          url: checkLoginUrl, 
          async:false,
          success: function(_data) {
            var mm = $.parseJSON(_data).data;
            if(mm==0){
            	result.login= false;
            }else{
            	result.login= true;
            	result.jf = mm.jf;
            }
          }
 	});
	return result;
}
	
