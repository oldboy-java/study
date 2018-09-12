<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!-- <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script> -->
<link rel="stylesheet" href="/${projectName}/portal/css/jquery.pagination.css" />
<script src="/${projectName}/portal/js/jquery.pagination.min.js"></script>
<div class="box">
   <div id="pagination" class="page fl"></div>
</div>

<script>
/************分页处理*******************/
 
//当前页
var currentPage  = '${page}';
//总页数
var totalPages = '${totalPages}';




//页面加载时处理当前选中页码
$(function(){
	
	//初始化分页插件
	$("#pagination").pagination({
		   currentPage: currentPage,// 当前页数
		   totalPage: totalPages,// 总页数
		   isShow: true,// 是否显示首尾页
		   count: 7,// 显示个数
		   homePageText: "首页",// 首页文本
		   endPageText: "尾页",// 尾页文本
		   prevPageText: "上一页",// 上一页文本
		   nextPageText: "下一页",// 下一页文本
		   callback: function(current) {
		       // 回调,current(当前页数)
		       if(pageUrl.indexOf('?') >0) {
		    	   window.location.href = pageUrl+"&page="+current;
		       }else{
		    	   window.location.href = pageUrl+"?page="+current;
		       }
		      
		   }
	});
	
	var currLink = $('.ui-pagination-container').find('a[data-current="'+currentPage+'"]');
	for(var i = 0 ;i < currLink.length;i++){
		if($(currLink[i]).html().match(/\d+/g)!=null){
			$(currLink[i]).addClass("active");
			break;
		}
	}
})
</script>