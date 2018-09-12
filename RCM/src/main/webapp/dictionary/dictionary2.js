/****************************************
字典功能js包，实现职能匹配、弹出树方法。
包内变量及函数名：
变量：
dictModule_aiDictObj
函数名：
dictModule_initAIDictSelecter
css类：
dictInput:AiTree or AiList
dictMutiInput:checkboxInList
*****************************************/
var dict_projectName="";
//insertList/enu_radio
function DictRadio(target,_dictId){
	this.tar=target;
	this.dictId=_dictId;
	
	this.getValue=function(){
		return this.tar.filter(":checked").val();
	}
	this.getText=function(){
		return this.tar.filter(":checked").attr("text");
	}
	this.getJson=function(){
		var obj=this.tar.filter(":checked");
		return {"id":obj.val(),"text":obj.attr("text")};
	}
	this.select=function(v){
		this.tar.filter("[value='"+v+"']").prop("checked",true);
	}
	this.disable=function(v){
		return this.tar.prop('disabled',true);
	}
	this.enable=function(v){
		return this.tar.prop('disabled',false);
	}
	//method
	this.onClick=function(fun){
		this.tar.click(function(){fun({"id":$(this).val(),"text":$(this).attr("text")});});
	}
	this.onSelect=function(fun){
		this.onClick(fun);
	}
	this.onChange=function(changeFun){
		this.onClick(fun);
	}
}
//insertList/enu_checkbox
function DictCheckbox(target,_dictId){
	this.tar=target;
	this.dictId=_dictId;
	
	this.getValue=function(){
		var res="";
		this.tar.filter(":checked").each(function(){
			res+=$(this).val()+",";
		});
		if(res.length>0){res=res.substring(0,res.length-1);}
		return res;
	}
	this.getText=function(){
		var res="";
		this.tar.filter(":checked").each(function(){
			res+=$(this).attr('text')+",";
		});
		if(res.length>0){res=res.substring(0,res.length-1);}
		return res;
	}
	this.getJson=function(){
		var res="";
		this.tar.filter(":checked").each(function(){
			res+="{'id':'"+$(this).val()+"','text':'"+$(this).attr('text')+"'},";
		});
		if(res.length>0){res=res.substring(0,res.length-1);}
		return res;
	}
	this.select=function(v){
		if(v.indexOf(",")>0){
			var vs=v.split(",");
			for(var i=0;i<vs.length;i++){
				this.tar.filter("[value='"+vs[i]+"']").prop("checked",true);
			}
		}else{
			this.tar.filter("[value='"+v+"']").prop("checked",true);
		}
	}
	this.selectAll=function(v){
		this.tar.prop("checked",v);
	}
	this.disable=function(v){
		return this.tar.prop('disabled',true);
	}
	this.enable=function(v){
		return this.tar.prop('disabled',false);
	}
	//method
	this.onClick=function(fun){
		this.tar.click(function(){
			fun(	{"id":$(this).val(),"text":$(this).attr("text"),"checked":$(this).is(":checked")}	);
		});
	}
	this.onSelect=function(fun){
		this.onClick(fun);
	}
	this.onChange=function(fun){
		this.onClick(fun);
	}
}
//insertList/combo_normal,combo_group
function DictCombobox(target,multiple,_dictId){
	this.tar=target;
	this.dictId=_dictId;
	this.multi=multiple;
	this.runOnce=true;//select default value when load successful.
	this.defaultId="";//default id.(noRealize)
	this.defaultText="";//default text.
	
	this.getValue=function(){
		if(this.multi){
			return this.tar.combobox('getValues');
		}else{
			return this.tar.combobox('getValue');
		}
	}
	this.getText=function(){
		return this.tar.combobox('getText');
	}
	this.setValue=function(v){
		this.tar.combobox('setValue',v);
	}
	this.select=function(v){
		if(this.multi&&v.indexOf(",")>0){
			var vs=v.split(",");
			for(var i=0;i<vs.length;i++){
				this.tar.combobox('select',vs[i]);
			}
		}else{
			this.tar.combobox('select',v);
		}
	}
	this.disable=function(v){
		return this.tar.combobox('disable');
	}
	this.enable=function(v){
		return this.tar.combobox('enable');
	}
	this.showPanel=function(v){
		return this.tar.combobox('showPanel');
	}
	this.editable=function(bl){
		this.tar.combobox({editable:bl});
	}
	//method
	this.onClick=function(fun){
		this.tar.combobox({onChange:fun});
	}
	this.onSelect=function(fun){
		this.onClick(fun);
	}
	this.onChange=function(fun){
		this.onClick(fun);
	}
	//prototype
	this.combobox=function(cfg){
		this.tar.combobox(cfg);
	}
}
//insertList/combo_smart
function DictSmartCombobox(target,_dictId,_defaultValue){
	this.tar=target;
	this.dictId=_dictId;
	this.runOnce=true;//select default value when load successful.
	this.defaultId=_defaultValue;//default id.(noRealize)
	
	this.getValue=function(){
		if(this.multi){
			return this.tar.combobox('getValues');
		}else{
			return this.tar.combobox('getValue');
		}
	}
	this.getText=function(){
		return this.tar.combobox('getText');
	}
	this.setValue=function(id){
		var dict=this;
		$.get("/"+getProjectName()+"/dict?method=getDictById&dictId="+this.dictId+"&id="+id,function(data){
			if(data!=""){
				var dictJson=eval("("+data+")");
				dict.defaultId=dictJson.id;
				dict.runOnce=true;
				dict.tar.combobox("reload","/"+getProjectName()+"/dict?method=insertList_combSmart&dictId="+dict.dictId+"&default="+dictJson.text);
			}
		});
	}
	this.setText=function(text){
		var dict=this;
		$.get("/"+getProjectName()+"/dict?method=getDictByText&dictId="+this.dictId+"&text="+text,function(data){
			if(data!=""){
				var dictJson=eval("("+data+")");
				dict.defaultId=dictJson.id;
				dict.runOnce=true;
				dict.tar.combobox("reload","/"+getProjectName()+"/dict?method=insertList_combSmart&dictId="+dict.dictId+"&default="+text);
			}
		});
	}
	this.select=function(v){
		if(this.multi&&v.indexOf(",")>0){
			var vs=v.split(",");
			for(var i=0;i<vs.length;i++){
				this.tar.combobox('select',vs[i]);
			}
		}else{
			this.tar.combobox('select',v);
		}
	}
	this.disable=function(v){
		return this.tar.combobox('disable');
	}
	this.enable=function(v){
		return this.tar.combobox('enable');
	}
	this.showPanel=function(v){
		return this.tar.combobox('showPanel');
	}
	this.editable=function(bl){
		this.tar.combobox({editable:bl});
	}
	//method
	this.onClick=function(fun){
		this.tar.combobox({onChange:fun});
	}
	this.onSelect=function(fun){
		this.onClick(fun);
	}
	this.onChange=function(fun){
		this.onClick(fun);
	}
	//prototype
	this.combobox=function(cfg){
		this.tar.combobox(cfg);
	}
}
//insertList/combo_grid
function DictCombogrid(target,multiple,_dictId){
	this.tar=target;
	this.dictId=_dictId;
	this.multi=multiple;
	
	this.getValue=function(){
		if(this.multi){
			return this.tar.combogrid('getValues');
		}else{
			return this.tar.combogrid('getValue');
		}
	}
	this.getText=function(){
		return this.tar.combogrid('getText');
	}
	this.setValue=function(v){
		this.tar.combogrid('setValue',v);
	}
	this.select=function(v){
		if(this.multi&&v.indexOf(",")>0){
			this.tar.combogrid('setValues',v.split(","));
		}else{
			this.tar.combogrid('setValue',v);
		}
	}
	this.disable=function(v){
		return this.tar.combogrid('disable');
	}
	this.enable=function(v){
		return this.tar.combogrid('enable');
	}
	this.showPanel=function(v){
		return this.tar.combogrid('showPanel');
	}
	this.editable=function(bl){
		this.tar.combogrid({editable:bl});
	}
	//method
	this.onClick=function(fun){
		this.tar.combogrid({onChange:fun});
	}
	this.onSelect=function(fun){
		this.onClick(fun);
	}
	this.onChange=function(fun){
		this.onClick(fun);
	}
	//prototype
	this.combobox=function(cfg){
		this.tar.combobox(cfg);
	}
}
/***************************************************************************/
//includeList/bill_normal
function DictDatalist(target,multiple,_dictId){
	this.tar=target;
	this.dictId=_dictId;
	this.multi=multiple;
	
	this.getValue=function(){
		if(this.multi){
			var sels=this.tar.datalist('getSelections');
			var res="";
			for(var i=0;i<sels.length;i++){
				res+=sels[i].id+",";
			}
			return _cutTail(res);
		}else{
			return this.tar.datalist('getSelected').id;
		}
	}
	this.getText=function(){
		var sels=this.tar.datalist('getSelections');
		var res="";
		for(var i=0;i<sels.length;i++){
			res+=sels[i].text+",";
		}
		return _cutTail(res);
	}
	this.select=function(v){
		if(v==""||v==undefined){return;}
		if(this.multi&&(v+"").indexOf(",")>0){
			v=","+v+",";
			var rows=this.tar.datalist('getRows');
			for(var i=0;i<rows.length;i++){
				if(v.indexOf(","+rows[i].id+",")>=0){
					this.tar.datalist('selectRow',i);
				}
			}
		}else{
			var rows=this.tar.datalist('getRows');
			for(var i=0;i<rows.length;i++){
				if(rows[i].id==v){
					this.tar.datalist('selectRow',i);
					break;
				}
			}
		}
	}
	this.selectRow=function(v){
		if(v==""||v==undefined){return;}
		if(this.multi&&(v+"").indexOf(",")>0){
			var vs=v.split(",");
			for(var i=0;i<vs.length;i++){
				this.tar.datalist('selectRow',vs[i]);
			}
		}else{
			this.tar.datalist('selectRow',v);
		}
	}
	this.check=function(v){
		if(v==""||v==undefined){return;}
		if(this.multi&&(v+"").indexOf(",")>0){
			v=","+v+",";
			var rows=this.tar.datalist('getRows');
			for(var i=0;i<rows.length;i++){
				if(v.indexOf(","+rows[i].id+",")>=0){
					this.tar.datalist('checkRow',i);
				}
			}
		}else{
			var rows=this.tar.datalist('getRows');
			for(var i=0;i<rows.length;i++){
				if(rows[i].id==v){
					this.tar.datalist('checkRow',i);
					break;
				}
			}
		}
	}
	this.checkRow=function(v){
		if(v==""||v==undefined){return;}
		if(this.multi&&(v+"").indexOf(",")>0){
			var vs=v.split(",");
			for(var i=0;i<vs.length;i++){
				this.tar.datalist('checkRow',vs[i]);
			}
		}else{
			this.tar.datalist('checkRow',v);
		}
	}
	this.selectAll=function(v){
		if(v){this.tar.datalist("selectAll");
		}else{this.tar.datalist("unselectAll");}
	}
	//method
	this.onClick=function(fun){
		this.tar.datalist({onClickRow:fun});
	}
	this.onSelect=function(fun){
		this.tar.datalist({onSelect:fun});
	}
	this.onChange=function(fun){
		this.onSelect(fun);
	}
	//prototype
	this.datalist=function(cfg){
		this.tar.datalist(cfg);
	}
}
//includeList/bill_checkbox
function DictDatalist_checkbox(target,multiple,_dictId){
	this.tar=target;
	this.dictId=_dictId;
	this.multi=multiple;
	
	this.getValue=function(){
		if(this.multi){
			var sels=this.tar.datalist('getChecked');
			var res="";
			for(var i=0;i<sels.length;i++){
				res+=sels[i].id+",";
			}
			return _cutTail(res);
		}else{
			return this.tar.datalist('getChecked').id;
		}
	}
	this.getText=function(){
		var sels=this.tar.datalist('getChecked');
		var res="";
		for(var i=0;i<sels.length;i++){
			res+=sels[i].text+",";
		}
		return _cutTail(res);
	}
	this.select=function(v){
		this.tar.datalist('clearChecked');
		if(v==""||v==undefined){return;}
		if(this.multi&&(v+"").indexOf(",")>0){
			v=","+v+",";
			var rows=this.tar.datalist('getRows');
			for(var i=0;i<rows.length;i++){
				if(v.indexOf(","+rows[i].id+",")>=0){
					this.tar.datalist('checkRow',i);
				}
			}
		}else{
			var rows=this.tar.datalist('getRows');
			for(var i=0;i<rows.length;i++){
				if(rows[i].id==v){
					this.tar.datalist('checkRow',i);
					break;
				}
			}
		}
	}
	this.selectRow=function(v){
		if(v==""||v==undefined){return;}
		if(this.multi&&(v+"").indexOf(",")>0){
			var vs=v.split(",");
			for(var i=0;i<vs.length;i++){
				this.tar.datalist('checkRow',vs[i]);
			}
		}else{
			this.tar.datalist('checkRow',v);
		}
	}
	this.selectAll=function(v){
		if(v){this.tar.datalist("checkAll");
		}else{this.tar.datalist("uncheckAll");}
	}
	//method
	this.onClick=function(fun){
		this.tar.datalist({onClickRow:fun});
	}
	this.onCheck=function(fun){
		this.tar.datalist({onCheck:fun});
		this.tar.datalist({onUncheck:fun});
	}
	this.onSelect=function(fun){
		this.onCheck(fun);
	}
	this.onChange=function(fun){
		this.onCheck(fun);
	}
	//prototype
	this.datalist=function(cfg){
		this.tar.datalist(cfg);
	}
}
//************************************************************************
//insertTree
function DictCombotree(target,multiple,_dictId){
	this.tar=target;
	this.dictId=_dictId;
	this.multi=multiple;
	this.runOnce=true;//select default node when load successful.
	
	this.getValue=function(state){
		if(this.multi){
			var nodes=this.tar.combotree("tree").tree('getChecked',state);
			var res="";
			for(var i=0;i<nodes.length;i++){
				res+=nodes[i].id+",";
			}
			if(res!=""){res=_cutTail(res);}
			return res;
		}else{
			var node=this.tar.combotree("tree").tree('getSelected');
			if(node!=null){
				return node.id;
			}else{
				return "";
			}
		}
	}
	this.getText=function(state){
		if(this.multi){
			var nodes=this.tar.combotree("tree").tree('getChecked',state);
			var res="";
			for(var i=0;i<nodes.length;i++){
				res+=nodes[i].text+",";
			}
			if(res!=""){res=_cutTail(res);}
			return res;
		}else{
			var node=this.tar.combotree("tree").tree('getSelected');
			if(node!=null){
				return node.text;
			}else{
				return "";
			}
		}
	}
	//private
	this.noSelect=function(){
		if(this.multi){
			var nodes=this.tar.combotree("tree").tree('getChecked');
			if(nodes.length>0)return false;
			return true;
		}else{
			var node=this.tar.combotree("tree").tree('getSelected');
			if(nodes==null)return true;
			return false;
		}
	}
	this.expand=function(v){
		return this.tar.combotree("tree").tree('expand',this.getDom(v));
	}
	this.select=function(v){
		if(v==""||v==undefined){return;}
		if((v+"").indexOf(",")>=0){
			this.tar.combotree('setValues',v.split(","));
		}else{
			this.tar.combotree('setValue',v);
		}
	}
	this.showPanel=function(v){
		return this.tar.combotree('showPanel');
	}
	this.scrollTo=function(v){
		return this.tar.combotree("tree").tree('scrollTo',this.getDom(v));
	}
	this.disable=function(v){
		return this.tar.combotree('disable');
	}
	this.enable=function(v){
		return this.tar.combotree('enable');
	}
	this.getDom=function(v){
		return this.tar.combotree("tree").tree('find',v).target;
	}
	//method
	this.onCheck=function(fun){
		this.tar.combotree("tree").tree({onCheck:fun});
	}
	this.onClick=function(fun){
		this.tar.combotree("tree").tree({onClick:fun});
	}
	this.onSelect=function(fun){
		this.tar.combotree("tree").tree({onSelect:fun});
	}
	//prototype
	this.combotree=function(cfg){
		return this.tar.combotree(cfg);
	}
	this.tree=function(cfg){
		this.tar.combotree("tree").tree(cfg);
	}
}
//includeTree. node:{id,text,iconCls,checked,state:[open|closed],attributes,target:DOM}
function DictTree(target,multiple,_dictId){
	this.tar=target;
	this.dictId=_dictId;
	this.multi=multiple;
	this.runOnce=true;//select default node when load successful.
	
	this.getValue=function(state){
		if(multiple){
			var nodes=this.tar.tree('getChecked',state);
			var res="";
			for(var i=0;i<nodes.length;i++){
				res+=nodes[i].id+",";
			}
			if(res!=""){res=_cutTail(res);}
			return res;
		}else{
			var node=this.tar.tree('getSelected');
			if(node==null){
				return "";
			}else{
				return node.id;
			}
		}
	}
	this.getText=function(state){
		if(multiple){
			var nodes=this.tar.tree('getChecked',state);
			var res="";
			for(var i=0;i<nodes.length;i++){
				res+=nodes[i].text+",";
			}
			if(res!=""){res=_cutTail(res);}
			return res;
		}else{
			var node=this.tar.tree('getSelected');
			if(node==null){
				return "";
			}else{
				return node.text;
			}
		}
	}
	this.select=function(v){
		this.tar.tree('uncheck',this.tar.tree('getRoot').target);
		if(v==""||v==undefined){return;}
		if((v+"").indexOf(",")>=0){
			var vs=v.split(",");
			for(var i=0;i<vs.length;i++){
				this.tar.tree('check',this.getDom(vs[i]));
			}
		}else{
			if(this.multi){
				this.tar.tree('check',this.getDom(v));
			}else{
				this.tar.tree('select',this.getDom(v));
			}
		}
	}
	//private
	this.noSelect=function(){
		if(this.multi){
			var nodes=this.tar.tree('getChecked');
			if(nodes.length>0)return false;
			return true;
		}else{
			var node=this.tar.tree('getSelected');
			if(nodes==null)return true;
			return false;
		}
	}
	this.expand=function(v){
		return this.tar.tree('expand',this.getDom(v));
	}
	this.expandTo=function(v){
		return this.tar.tree('expandTo',this.getDom(v));
	}
	this.collapse=function(v){
		return this.tar.tree('collapse',this.getDom(v));
	}
	this.disable=function(v){
		return this.tar.tree('disable');
	}
	this.enable=function(v){
		return this.tar.tree('enable');
	}
	this.getDom=function(v){
		return this.tar.tree('find',v).target;
	}
	//method
	this.onCheck=function(fun){
		this.tar.tree({onCheck:fun});
	}
	this.onClick=function(fun){
		this.tar.tree({onClick:fun});
	}
	this.onSelect=function(fun){
		this.tar.tree({onSelect:fun});
	}
	this.onExpand=function(fun){
		this.tar.tree({onExpand:fun});
	}
	this.onCollapse=function(fun){
		this.tar.tree({onCollapse:fun});
	}
	//prototype
	this.tree=function(cfg){
		return this.tar.tree(cfg);
	}
}
function _cutTail(res) {
	if(res.length>0) return res.substring(0,res.length-1);
	return res;
}
//synchtree expand once
function _synchExpandTo(dict,id,node,data){
	dict.select(id);
}
//asynchtree expand step by step.
var TRACK_DICT,TRACK_TRACK,TRACK_INDEX=0,TRACK_LOCATE;//TRACK_LOCATE是否定位
function _asynchExpandTo(dict,id,node,data){
	if(dict.runOnce){
		TRACK_DICT=dict;
		$.get("/"+getProjectName()+"/dict?method=trackTree&dictId="+dict.dictId+"&id="+id,function(data){
			if(data==""){return;}
			var pids=data.split(",");
			TRACK_TRACK=pids;
			TRACK_INDEX=0;
			if(dict.tar.attr("tag")=="insert"){TRACK_LOCATE=false;
			}else{TRACK_LOCATE=true;}
			window.setTimeout(trackSmartTree,10);
			dict.runOnce=false;
		});
	}
}
//smart tree search
function bindSmartTree(dict){
	dict.tar.combotree("textbox").keydown(function(e){
		if(e.keyCode==8||e.keyCode==46){
			;
		}else if(e.keyCode==13){
			smartExpandTo(dict,$(this).val());
		}else{
			dict.showPanel();
		}
	});
}
function smartExpandTo(dict,text){
	TRACK_DICT=dict;
	$.get("/"+getProjectName()+"/dict?method=trackTreeText&dictId="+dict.dictId+"&text="+text,function(data){
		if(data==""){return;}
		var pids=data.split(",");
		TRACK_TRACK=pids;
		TRACK_INDEX=0;
		TRACK_LOCATE=true;
		window.setTimeout(trackSmartTree,10);
	});
}
function trackSmartTree(){
	if(TRACK_INDEX<TRACK_TRACK.length-1){
		TRACK_DICT.expand(TRACK_TRACK[TRACK_INDEX]);
		TRACK_INDEX++;
		window.setTimeout(trackSmartTree,200);
	}else{
		if(TRACK_LOCATE){
			TRACK_DICT.select(TRACK_TRACK[TRACK_TRACK.length-1]);
			TRACK_DICT.scrollTo(TRACK_TRACK[TRACK_TRACK.length-1]);
		}
	}
}
//smart combo search
function smartDefaultValue(dict){
	if(dict.runOnce&&dict.defaultId!=""){
		dict.tar.combobox('setValue',dict.defaultId);
		dict.runOnce=false;
	}
}
function getProjectName(){
	if(dict_projectName==""){
		var s=document.location+"";
		s=s.substring(s.indexOf("://")+3);
		s=s.substring(s.indexOf("/")+1);
		s=s.substring(0,s.indexOf("/"));
		dict_projectName=s;
	}
	return dict_projectName;
}