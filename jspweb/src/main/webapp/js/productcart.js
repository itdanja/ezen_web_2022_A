$( function(){  
	$.ajax({
		url : 'getcart' ,
		success : function( jsonarray ){
			for( let i = 0 ; i<jsonarray.length; i++ ){
				console.log( jsonarray[i] );
			}
		}
	});
});