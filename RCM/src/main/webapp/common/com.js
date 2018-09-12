function QMoveDialog(dia){
	if(dia.dialog("options").top>=5000){
		dia.dialog("move", { top:$(document).scrollTop() + ($(window).height()-dia.height()) * 0.3});
	}
}
function QWinToggle(){
	this.regist=function(wins){
		this.windows=[];
		for(var i in wins){
			this.windows.push($(this.fmtId(wins[i])));
		}
		return this;
	}
	this.open=function(winid){
		winid=this.fmtId(winid);
		var $win;//jquery object.
		for(var i in this.windows){
			if(this.windows[i].selector==winid){
				$win=this.windows[i];
			}else{
				this.windows[i].dialog('close');
			}
		}
		QMoveDialog($win);
		$win.dialog('open');
	}
	this.fmtId=function(id){
		id=$.trim(id);
		if(id.charAt(0)!='#'){id="#"+id;}
		return id;
	}
}