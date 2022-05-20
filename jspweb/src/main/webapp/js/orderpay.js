let jsonarray; // JSON 형식의 변수를 선언
let totalpay = 0; // 총주문액 변수 선언 
/* 1. 자바스크립트 열리면 무조건 실행되는 메소드 */
$( function(){  
	getcart();
});
/* 2.  장바구니 데이터 호출 메소드 */
function getcart(){
	$.ajax({
		url : 'getcart' ,
		success : function( json ){
			jsonarray = json;	/* 응답받은 데이터를 전역변수에 넣어주기 */
			
			for( let i = 0 ; i<jsonarray.length; i++ ){
				totalpay += jsonarray[i]["totalprice"];
			}
		}
	});
}
/* 아임포트 API = 결제API */
function payment(){
	var IMP = window.IMP; 
	IMP.init("imp35631338"); // [본인]관리자 식별코드 [ 관리자 계정마다 다름] 
    IMP.request_pay({ // 결제 요청변수 
	    pg: "html5_inicis",	// pg사 [ 아임포트 관리자페이지에서 선택한 pg사 ]
	    pay_method: 'card',	// 결제방식
	    merchant_uid: "ORD20180131-0000011", // 주문번호[별도]
	    name: "EZEN SHOP", // 결제창에 나오는 결제이름
	    amount: totalpay,	// 결제금액
	    buyer_email: "gildong@gmail.com",
	    buyer_name: '임시이름',
	    buyer_tel: '임시번호',
	    buyer_addr: '임시주소',
	    buyer_postcode: '임시우편번호',	// 우편번호
		  }, function (rsp) { // callback
		      if (rsp.success) { // 결제 성공했을때 -> 주문 완료 페이지로 이동 []
		      } else {
				saveorder(); // 결제 실패 했을때 -> 테스트 할시에는 이부분 활용
		      }
	  });
}
// 주문 처리 메소드 
function saveorder(){
	alert("DB처리시작");
	$.ajax({
		url : "saveorder",
		success : function( re ){
			alert("DB처리 성공")
		}
	});
}










