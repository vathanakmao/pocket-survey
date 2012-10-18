$(function() {
	var isScale = ($(window).height() - $("#login_box").height()) >= $("#buttons").height();
	updateScreen();
	if (isScale) {
		$('#login_box').css("height", $(window).height() + "px");
		$("#signin_msg_below").css("position", "absolute");
		$("#signin_msg_below").css("bottom", "2%");
	}
	$("#loginButton").button().click(function(e) {
		$("#f").submit();
	});
});
// handle rotation screen
var supportsOrientationChange = "onorientationchange" in window;
var orientationEvent = supportsOrientationChange ? "orientationchange" : "resize";
window.addEventListener(orientationEvent, function() {
		setTimeout("updateScreen()",400);
}, false);

// update screen
function updateScreen(){
	var inputFieldContainerWidth =  window.innerWidth * 0.98;
	var inputWidth = inputFieldContainerWidth - ((inputFieldContainerWidth * 0.1) + 118);
	$(".input_fields>input").css("width", inputWidth + "px");
}