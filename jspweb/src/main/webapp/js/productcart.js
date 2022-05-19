$( function(){  
	$.ajax({
		url : 'getcart' ,
		success : function( re ){
			alert( re );
		}
	});
});