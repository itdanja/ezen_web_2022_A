$( function(){  
	$.ajax({
		url : 'getcart' ,
		success : function( re ){
			for( let i = 0 ; i<re.length; i++ ){
				alert( re[i] );
				alert(  Object.keys(re[i] ) ); /* Object.keys( json객체 ) -> 객체내 모든 키 반환 */
				alert(  re[i]['size'] ); /* json객체[key] -> 객체내 key에 해당하는 value 호출 */
			}
		}
	});
});