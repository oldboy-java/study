<%@ page language="java" pageEncoding="GB2312"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-pagefmt" prefix="pageFmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	
	<title>树型字典维护页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="zTree/zTreeStyle/zTreeStyle.css" type="text/css">
	<link rel="stylesheet" href="/${projectName}/dictEditor/dictionary.css" type="text/css">
	
	<script type="text/javascript" src="/${projectName}/script/jquery2_6.js"></script>
	<script type="text/javascript" src="zTree/jquery.ztree-2.6.js"></script>
	
	<script type="text/javascript" src="js/ui.core.js"></script>
	<script type="text/javascript" src="js/ui.draggable.js"></script>
	<script type="text/javascript">
	var zTreeObj;
	var id = 0;
	var pid = 0;
	var isList=${isList};
	var dummyRootId="${dummyRootId}";
	var hasSort=false;
	$(document).ready(function(){
		var simpleNodes =[];
		var setting1 = {
			fontCss: {},
			showLine: true,
			expandSpeed: "",
			editable: false,
			dragCopy : true,
			dragMove : true,
			keepLeaf : isList,
			rootPID : "",
			treeNodeKey : "id",
			treeNodeParentKey : "pid",
			nameCol : "label",
			isSimpleData : true,
			callback: {
				drop: zTreeOnDrop,
				rename: zTreeOnRename,
				remove: zTreeOnRemove
			},
			async : true,
			asyncUrl : "/${projectName}/dictEditor/dict.do?method=schTreeSub&dictId=${param.dictId}",
			asyncParam : ["id"],
			removeHoverDom: removeHoverDom
		};
		zTreeObj = $("#treeDemo").zTree(setting1, simpleNodes);
		//window.setTimeout("zTreeObj.expandNode(zTreeObj.getNodes()[0], true, false);",5000);
		//锁定字典
		$("#lock").click(function(){
			if($(this).attr("lock")==1){
				$.get("/${projectName}/dictEditor/dict.do?method=lock&dictId=${param.dictId}",function(data){
					if(data=="true"){
						var setting=zTreeObj.getSetting();
						setting.editable=true;
						setting.addHoverDom=addHoverDom;
						//开锁后重载
						zTreeObj = $("#treeDemo").zTree(setting, simpleNodes);
						window.setTimeout("zTreeObj.expandNode(zTreeObj.getNodes()[0], true, false);",500);
						$("#lock").attr("src","imgs/lock_2.png");
						$("#lock").attr("lock",2);
					}else{
						alert("字典已被其他用户锁定，请等待。");
					}
				});
			}else{
				var setting=zTreeObj.getSetting();
				setting.editable=false;
				setting.addHoverDom=null;
				zTreeObj.updateSetting(setting);
				$("#lock").attr("src","imgs/lock_1.png");
				$("#lock").attr("lock",1);
				updSort();//该方法负责更新并后台解锁。
			}
		});
		//字典面板方法
		$(".delTr").click(function(){
			var index = $("#insert").find("input[name='id']:first").val();
			$(this).parent().remove();
			ids = $("#insert").find("input[name='id']");
			if(ids.length>0){
				for(var i=0;i<ids.length;i++){
					ids.eq(i).val(index++);
				}
			}
			id = index;
		});
		$("#addTr").click(function(){
			var tr = $("#model").clone(true);
			tr.attr("id","");
			tr.find("input[name='id']").val(id++);
			tr.find("input[name='pid']").val(pid);
			$("#insert").append(tr);
			tr.find(".inputLabel").focus();
		});
		$(".inputLabel").blur(function(){
			if($("#auto")[0].checked&&$(this).val()!=""){//&&$(this).parent().prev().find(".readonly").val()==id-1
				$("#addTr").click();
			}
		});
		$("#submitAddDictBtn").click(function(){
			var ids=$("#addPanel input[name='id']");
			var pids=$("#addPanel input[name='pid']");
			var labels=$("#addPanel input[name='label']");
			var res="",dataRes="";
			for(var i=0;i<ids.length;i++){
				labels.eq(i).val($.trim(labels.eq(i).val()));
				if(labels.eq(i).val()==""){
					alert("请填写字典内容");
					labels.eq(i).focus();
					return;
				}
				res+="{id:'"+ids.eq(i).val()+"',pid:'"+pids.eq(i).val()+"',label:'"+labels.eq(i).val()+"'},";
				dataRes+=ids.eq(i).val()+"@"+pids.eq(i).val()+"@"+labels.eq(i).val()+"@@@"
			}
			if(res!=""){
				res=res.substring(0,res.length-1);
				res="["+res+"]";
				dataRes=dataRes.substring(0,dataRes.length-3);
				$.get("/${projectName}/dictEditor/dict.do?method=addDictTree&dictId=${param.dictId}&from=submit&data="+dataRes,function(data){
					zTreeObj.addNodes(zTreeObj.getSelectedNode(), eval(res));
					$("#insert").empty();
					$("#addPanel").hide();
				});
			}else{
				alert("请添加字典记录");
			}
		});
		$("#addTr").click();
		$(function() {
			$("#addPanel").draggable();
		});
	});

	function zTreeOnRename(event, treeId, treeNode) {
		$.get("/${projectName}/dictEditor/dict.do?method=updDictTree&dictId=${param.dictId}&id="+treeNode.id+"&label="+treeNode.label);
	}
	function zTreeOnRemove(event, treeId, treeNode) {
		$.get("/${projectName}/dictEditor/dict.do?method=delDictTree&dictId=${param.dictId}&id="+treeNode.id);
	}
	function zTreeOnDrop(event, treeId, treeNode, targetNode, moveType) {
		zTreeObj.expandNode(targetNode, true, false);
		hasSort=true;
		if(moveType=="inner"){
			treeNode.pid=targetNode.id;
			$.get("/${projectName}/dictEditor/dict.do?method=updDictTree&dictId=${param.dictId}&id="+treeNode.id+"&pid="+targetNode.id);
		}
	}
	//自定义添加按钮
	function addHoverDom(treeId, treeNode) {
		if((isList&&treeNode.id==dummyRootId)||!isList){//列表且为根or树形 then 注册添加按钮
			var aObj = $("#" + treeNode.tId + "_a");
			if ($("#diyBtn_"+treeNode.id).length>0) return;
			var editStr = "<button type='button' class='add' id='diyBtn_" + treeNode.id 
				+ "' onfocus='this.blur();'></button>";
			aObj.append(editStr);
			var btn = $("#diyBtn_"+treeNode.id);
			if (btn) btn.bind("click",
				function(){
					zTreeObj.expandNode(treeNode, true, false);
					$.get("/${projectName}/dictEditor/dict.do?method=addDictTree&dictId=${param.dictId}&group=${param.group}&id="+treeNode.id+"&from=",function(data){
						id=data;
						pid=treeNode.id;
						$("#insert").empty();
						$("#addTr").click();
						$("#addPanel").show();
					});
				});
		}
	}
	function removeHoverDom(treeId, treeNode) {
		$("#diyBtn_"+treeNode.id).unbind().remove();
	}
	//更新排序
	function updSort(){
		var res="";
		if(hasSort){
			var treeNodes = zTreeObj.getNodes();
			var simpleTreeNodes = zTreeObj.transformToArray(treeNodes);
			for(var i=0;i<simpleTreeNodes.length;i++){
				res+=simpleTreeNodes[i].id+",";
			}
			if(res!=""){
				res=res.substring(0,res.length-1);
			}
		}
		$.get("/${projectName}/dictEditor/dict.do?method=updSort&hasSort="+hasSort+"&dictId=${param.dictId}&ids="+res);
		hasSort=false;
	}
	window.onunload=updSort;
	</script>
</head>
<body>
	<img src="imgs/lock_1.png" id="lock" lock="1" style="margin-left:150px;"/>
	<ul id="treeDemo" class="tree" style="margin-top:-22px;"></ul>
	
	<div id="addPanel" style="position:absolute;top:0px;left:300px;width:400px;display:none;" action="/dict.do?method=addDictTree&catId=${param.catId}&type=${param.type}">
		${tabledesc}记录添加
		<input type='checkbox' id='auto' checked="checked"/>自动增行
		<input type="button" value=" ＋ " id="addTr" style="height:20px;margin:0px;padding:0px;"/>
			<div>
				序列
				名称
			</div>
			<div id="insert">
			</div>
		<input type="button" value="提 交" id="submitAddDictBtn"/>
	</div>
	<div style="display:none;">
		<div id="model">
			<input type="text" name="id" readonly="readonly" class="readonly" />
			<input type="hidden" name="pid"/>
			<input type="text" name="label" class="inputLabel"/>
			<input type="button" value="×" class="delTr" style="height:20px;margin:0px;padding:0px;"/>
		</div>
	</div>
</body>
</html:html>
