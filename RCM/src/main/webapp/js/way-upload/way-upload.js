/***
 * @author	王亚飞
 * @email	ew.yafei@gmail.com
 * @version	1.2
 * @date	13/11/08
 *  
 *  使用方法：
 *  		WAYUPLOAD.show({'xxx':'yyy'});
 *  		WAYUPLOAD.hide();
 *  String[]	fileType	文件类型					例：['jpg','zip']
 *  String		url			上传服务器地址			例：'/upload'
 *  Integer		maxSize		文件大小限制（MB）		例：'100'
 *  String		path		way-upload目录地址		例：'/way-upload/'
 *  Integer		count		文件上传个数				例：1
 *  Object		data		传输数据					例：{'a':'b','c':'c'}
 */
var WAYUPLOAD={};WAYUPLOAD.show=function(b){var c="/way-upload/upload.html?";if(typeof b.path!="undefined"){c=b.path+"upload.html?"}c+="domain="+document.domain+"&";if(typeof b.fileType!="undefined"){c+="fileType="+b.fileType+"&"}if(typeof b.count!="undefined"){c+="count="+b.count+"&"}if(typeof b.url!="undefined"){c+="url="+b.url+"&"}if(typeof b.maxSize!="undefined"){c+="maxSize="+b.maxSize+"&"}if(typeof b.data!="undefined"){c+="data={";for(var a in b.data){c+=a+":"+b.data[a]+","}c=c.substring(0,c.length-1);c+="}"}WAYUPLOAD.box.show(c)};WAYUPLOAD.hide=function(){WAYUPLOAD.box.hide()};WAYUPLOAD.callback=function(a){};WAYUPLOAD.box=(function(){var d,b,a=0,e,c;return{show:function(f){c={topsplit:3,iframe:0};c.iframe=f;d=document.createElement("div");b=document.createElement("div");a=document.createElement("div");e=document.createElement("div");b.innerHTML='<iframe frameborder="0" src="'+c.iframe+'" width="670" height="315" scrolling="no"></iframe>';d.appendChild(b);d.appendChild(e);document.body.appendChild(d);document.body.appendChild(a);window.onresize=WAYUPLOAD.box.resize;WAYUPLOAD.box.addMove();d.style.zIndex="9999";d.style.position="absolute";e.style.width="626px";e.style.height="35px";e.style.backgroundColor="transparent";e.style.position="absolute";e.style.left=0;e.style.top=0;e.style.cursor="move";a.style.zIndex="9998";a.style.position="absolute";a.style.top=e.style.left=0;a.style.backgroundColor="white";a.style.opacity=0.01;a.style.filter="alpha(opacity=1)";b.style.height="315px";b.style.width="670px";WAYUPLOAD.box.resize()},addMove:function(){WAYUPLOAD.util.bind(e,"mousedown",f);var i,h;function f(l){l=WAYUPLOAD.util.getEvent(l);i=l.clientX-WAYUPLOAD.util.delPx(d.style.left),h=l.clientY-WAYUPLOAD.util.delPx(d.style.top);WAYUPLOAD.util.bind(document,"mousemove",g);WAYUPLOAD.util.bind(document,"mouseup",j)}function j(){WAYUPLOAD.util.unbind(document,"mousemove",g);WAYUPLOAD.util.unbind(document,"mouseup",j)}function g(l){k=WAYUPLOAD.util.getEvent(l);d.style.left=l.clientX-i+"px";d.style.top=l.clientY-h+"px"}},removeMove:function(){e.onmousedown=null;e.onmouseup=null},resize:function(){WAYUPLOAD.box.pos();WAYUPLOAD.box.remask()},remask:function(){a.style.width=WAYUPLOAD.page.swidth()+"px";a.style.height=WAYUPLOAD.page.sheight()+"px"},pos:function(){var f=/*WAYUPLOAD.page.height()/c.topsplit-d.offsetHeight/2*/100;f=(f<20?20:f)+WAYUPLOAD.page.top();d.style.top=f+"px";d.style.left=(WAYUPLOAD.page.width()-d.offsetWidth)/2+"px"},hide:function(){this.removeMove();d.parentNode.removeChild(d);a.style.display="none"}}})();WAYUPLOAD.page=(function(){var b,d,a;function c(){b=document,d=b.documentElement,a=b.body;return b.compatMode=="BackCompat"}return{top:function(){c();return Math.max(a.scrollTop,d.scrollTop)},width:function(){return c()?a.clientWidth:d.clientWidth},height:function(){c();var e=window.innerHeight;if(typeof e=="number"){return e}if(b.compatMode=="CSS1Compat"){return d.clientHeight}else{return a.clientHeight}},swidth:function(){return c()?Math.max(a.clientWidth,a.scrollWidth):Math.max(d.clientWidth,d.scrollWidth)},sheight:function(){return c()?Math.max(a.clientHeight,a.scrollHeight):Math.max(d.clientHeight,d.scrollHeight)}}})();WAYUPLOAD.util=(function(){return{delPx:function(a){return parseInt(a.substring(0,a.length-2))},getEvent:function(a){return a||window.event},bind:function(c,b,a){if(c.addEventListener){c.addEventListener(b,a,false)}else{if(c.attachEvent){c.attachEvent("on"+b,a)}else{c["on"+b]=a}}},unbind:function(c,b,a){if(c.removeEventListener){c.removeEventListener(b,a,false)}else{if(c.detachEvent){c.detachEvent("on"+b,a)}else{c["on"+b]=null}}}}})();