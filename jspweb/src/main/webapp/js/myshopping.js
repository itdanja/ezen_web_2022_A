// $ : jquery 문법

// 현재 page 로드 되는 메소드 
// $( function(){}); 

$( function(){
	
	$.ajax({
		url : "../product/getorder" , 
		success : function( jsonarray ){
			alert( jsonarray );
		}
	});
}); 