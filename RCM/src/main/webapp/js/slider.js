function imgReload() {
	var imgHeight = 0;
	var wtmp = $("body").width();

	$("#b06 ul li").each(function(){
		$(this).css({width:wtmp + "px"});
	});

	$(".sliderimg").each(function(){
		$(this).css({width:wtmp + "px"});
		imgHeight = $(this).height();
	});
}

$(window).resize(function(){imgReload();});

$(document).ready(function(e) {
	imgReload();
	var unslider06 = $('#b06').unslider({
			dots: true,
			fluid: true
		}),
		data06 = unslider06.data('unslider');

	$('.unslider-arrow06').click(function() {
		var fn = this.className.split(' ')[1];
		data06[fn]();
	});
});