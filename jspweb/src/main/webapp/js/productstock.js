
/* 특정 select에 DB 데이터 넣기 */
$( function getcategory(){ 
	$.ajax({
		url : "getcategory" , 
		data : { "type" : "option" } ,
		success : function( re ){
			$("#categorybox").html( re );
		}
	});
});
/* 카테고리목록 select 값이 변경 될때마다 .*/
$("#categorybox").change( function(){
	let cno = $("#categorybox").val();
	$.ajax({
		url : "getproduct" ,
		data : { "type" : "option" , "cno" : cno } ,
		success : function( re ){
			if( re == ""){
				alert("해당 카테고리의 제품이 없습니다.");
				$("#productbox").html(" ");
			}else{ 
				$("#productbox").html( re );
			}
		}
	})
});

