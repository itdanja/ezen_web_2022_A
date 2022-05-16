
/* 선택 제품의 제품번호를 모달로 이동 */
function pnomove( pno ){
	$("#modelinput").val(pno);
}

/* ----------------------------------*/
/* -------------- 상태변경 비동식 처리 --------------------*/
function activechange( active ){
	let pno = $("#modelinput").val();
	$.ajax({
		url : "activechange",
		data : { "pno":pno,"active":active },
		success : function( re ){
			if( re == 1 ){
				alert("상태변경 성공");
				// 특정태그 새로고침 //$('#producttable').load(location.href+' #producttable');
				$("#modalclosebtn").click(); // [특정버튼 강제클릭] 모달내 취소 버튼 클릭 이벤트
				$("#mainbox").load( "productlist.jsp"); // 해당 div에 해당 페이지 로드
			}
			else{ alert("상태변경 실패");}
		}
	});
};
/* ----------------------------------*/

// 제품번호 , 색상 , 사이즈 동일한 경우의 재고 호출    
function getamount( pno ){
	let scolor = $("#colorbox"+pno).val();	// 선택된 색상 가져오기 
	let ssize  = $("#sizebox"+pno).val();	// 선택된 사이즈 가져오기
	$.ajax({ 
		url : 'getstock' , 
		data : { 'field' : 'amount' , "pno" : pno , 
					"scolor" : scolor , "ssize" : ssize } ,
		success : function( re ){
			if( re == ""){ 
				$("#amountbox"+pno).html('재고없음');
			}
			else{ $("#amountbox"+pno).html( re +'개' ); }
		}
	});
};















