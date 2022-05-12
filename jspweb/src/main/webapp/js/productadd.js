/* -------- 카테고리 버튼 눌렀을때 함수(이벤트) ------- */
function categorybtn(){
	// 특정태그의 HTML 넣기 
	$("#categotyinput").html(
		'<input type="text" id="cname">'+
		'<button onclick="categoryadd()" type="button">등록</button>'
	)
}
/* -----------------------------------------*/
/* -------- 카테고리 등록 눌렀을때 함수(이벤트) ------- */
function categoryadd(){
	let cname = $("#cname").val();		/* 해당 입력값 가져오기 */ 
	$.ajax({							/* 비동기 통신 */
		url : "categoryadd" , 			/* 서블릿 URL 매핑 */
		data : { "cname" : cname } ,	/* 보내는 데이터 : 카테고리명 */
		success : function( result ){	/* 통신 성공시 받는 데이터 */
			if( result == 1 ){  
				alert("카테고리추가"); 
				$("#categotyinput").html("");
			}
			else{ alert("카테고리실패"); }
		}
	});
}
/* -------- -------------------------- ------- */
