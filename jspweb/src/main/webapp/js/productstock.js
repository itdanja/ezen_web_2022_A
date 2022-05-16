
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
				document.getElementById('stockaddform').attr('display' ,'none');
				/* js -> attr   vs   jquery -> css */
			}else{ 
				$("#productbox").html( re );
				$("#stockaddform").css('display' ,'block');
				getstock();
			}
		}
	})
});

/* 제품 재고 추가 */
function stockadd(){
	let pno = $("#productbox").val(); // 제품번호 
	let scolor = $("#scolor").val(); // 제품번호 
	let ssize = $("#ssize").val(); // 제품번호 
	let samount = $("#samount").val(); // 제품번호 
	$.ajax({
		url : "stockadd",
		data : { "pno" : pno , 
				 "scolor" : scolor ,
				 "ssize" : ssize ,
				 "samount" : samount } , 
		success : function( re ){
			if( re == 1 ){
				alert("재고 등록 성공");
				$("#mainbox").load('productstock.jsp');
			}else{
				alert("재고 등록 실패");
			}
		}
	});
}
/* 제품명 목록 select 값이 변경 될때마다 .*/
$("#productbox").change( function(){
	getstock();
});

function getstock(){
	let pno = $("#productbox").val();
	$.ajax({
		url : 'getstock' ,
		data : { "pno" : pno } ,
		success : function( re ){
			$("#stocklistbox").html(re);
		}
	});
}





















