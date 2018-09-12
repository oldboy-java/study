/***
 * 检测上传图片格式、大小插件
 * 调用：
 * var ret = new imagePlugin('fileId','2','jpg,png,jpeg').valid();
 * var result = ret.result;
 * var error = ret.error;
 * 
 * @param win
 * @param doc
 * @param $
 */
(function(win,doc,$){
	
	/***
	 * fileId:上传图片的inputId
	 * maxImageSizeMB:允许的最大文件大小（MB）
	 * imagePatternString:图片格式字符串如jpg,jpeg,png中间用逗号隔开
	 */
	//定义构造方法
	var imagePlugin = function(fileId,maxImageSizeMB,imagePatternString){
		this.fileId = fileId;
		this.maxImageSizeMB = maxImageSizeMB;
		this.imagePatternString = imagePatternString;
		this.error = '';
		this.init();
	}
	
	
	//定义其它方法
	imagePlugin.prototype = {
	   
	   //初始化方法
	   init:function(){
		  // this.validateImageExtension();
	   },
	   
	   //校验
	   valid:function(){
		   var result = this.validateImageExtension();
		   if(result){
			   result = this.validateImageSize();
		   }
		   return {'result':result,'error':this.error};
	   },
	
	   //验证图片扩展名
	   validateImageExtension:function(){
		   var imageValue = doc.getElementById(this.fileId).value;
		   var imageExtension  = this.getImageExtension(imageValue);
		   if (this.imagePatternString.indexOf(imageExtension.toLowerCase()) == -1) {
			   this.error= "图片格式不对，只能上传"+this.imagePatternString+"格式图像";
			   return false;
			}
		   return true;
	   },
	   
	   //验证图片大小
	   validateImageSize:function(){
		   var imageSize = this.getFileSize(this.fileId);
		   if(imageSize> this.maxImageSizeMB ) {
			   this.error= "图片大小超过限制,请限制在" + this.maxImageSizeMB + "MB以内";
			   return false;
			} 
		    
		   return true;
	   },
	   
	   //根据路径获取文件扩展名
	   getImageExtension:function(path){
		   return path.substring(path.lastIndexOf(".")+1, path.length); 
	   },
	   
	   //获取文件大小
	   getFileSize:function(fileid){
			try {
				var fileSize = 0;
				//for IE
				if ($.support.msie) {
					//before making an object of ActiveXObject, 
					//please make sure ActiveX is enabled in your IE browser
					var objFSO = new ActiveXObject("Scripting.FileSystemObject");
					var filePath = $("#" + fileid)[0].value;
					var objFile = objFSO.getFile(filePath);
					var fileSize = objFile.size; //size in kb
					fileSize = fileSize / 1048576; //size in mb 
				}
				//for FF, Safari, Opeara and Others
				else {
					fileSize = $("#" + fileid)[0].files[0].size //size in kb
					fileSize = fileSize / 1048576; //size in mb 
				}
				//alert("Uploaded File Size is" + fileSize + "MB");
				return fileSize;
			} catch (e) {
				alert("Error is :" + e);
			}
		},
			
	}
	
	win.imagePlugin = imagePlugin; //注册对象
	
}(window,document,jQuery));

