
let jsonarray; // JSON 형식의 변수를 선언 	= ajax 이용한 회원정보를 가져와서 저장되는 변수 

let sumprice = 0; // 상품 총가격 변수 선언 	= jsonarray 에 있는 제품들의 총가격을 합산 
let deliverypay = 0; // 배송비 변수 선언  	= jsonarray 에 있는 제품들의 총가격이 7만원 이상이면 0 아니면 2500원 배송비
let totalpay = 0; // 총주문액 변수 선언 		= 상품 총가격에 배송비를 더하고 포인트를 뺀 총 가격
let point = 0; // 포인트 변수 선언 			= 적립 예정 포인트

let member;	// 회원정보 json 객체 [ 비밀번호 제외한 ]	= 회원정보를 가지고 있는 객체
let mpoint = 0; // 회원이 사용하는 포인트				= 회원이 사용할 예정인 포인트 변수 

let pay_method;	// 결제수단을 저장하는 변수 			= 회원이 선택한 결제수단 변수 

/* 1. 자바스크립트 열리면 무조건 실행되는 메소드 */
$( function(){  // $(document).ready( function(){});  // 문서내에서 대기상태 이벤트
	
	// 회원 정보 출력  
	$.ajax({
		url : "/jspweb/member/getmember" , 
		success : function( json ){
			member = json;	
			getcart();	// 제품 호출 메소드 불러오기	= getcart에서 member 객체 사용하므로 member객체 호출후 메소드 실행
		}
	});
	
	// getcart();	// 제품 호출 메소드 불러오기		= getcart에서 member 객체 사용하므로 member객체 호출후 메소드 실행
		// getcart() -> ajax결과 [ x ]
		// ajax결과 -> getcart() [ 0 ]
	
	// 받는사람 정보가 기존 회원과 동일 버튼눌렀을때
	$("#checkbox").change( function(){	
		// 체크박스가 변경 되었을때 이벤트 
		if( $("#checkbox").is(":checked") ){
			//만약에 체크박스가 체크가 되어 있으면
			$("#ordername").val( member['mname']);
			$("#orderphone").val(member['mphone']);
			$("#sample4_postcode").val(member['maddress'].split('_')[0] );
			$("#sample4_roadAddress").val(member['maddress'].split('_')[1]);
			$("#sample4_jibunAddress").val(member['maddress'].split('_')[2]);
			$("#sample4_detailAddress").val(member['maddress'].split('_')[3]);
		}else{
			$("#ordername").val("");
			$("#orderphone").val("");
			$("#orderaddress").val("");
			$("#sample4_postcode").val("");
			$("#sample4_roadAddress").val("");
			$("#sample4_jibunAddress").val("");
			$("#sample4_detailAddress").val("");
		}
	});
	
});

/* 2.  장바구니 데이터 호출 메소드 */
function getcart(){
	$.ajax({
		url : 'getcart' ,
		success : function( json ){
			jsonarray = json;	/* 응답받은 데이터를 전역변수에 넣어주기 */
			cartview();
		}
});
}
/* 3. js내 존재하는 json 객체를 table 에 데이터 출력  */
function cartview(){
			sumprice = 0; /*상품 총가격 */
			deliverypay = 0; // 배송비 
			totalpay = 0; // 총주문액 
			
			let tr = '<tr> <!-- 헤더 -->'+
'					<th width="60%">상품정보</th>'+
'					<th width="20%">수량</th> 		'+
'					<th width="20%">가격</th> '+
'				</tr>'
			
			for( let i = 0 ; i<jsonarray.length; i++ ){
				
				sumprice += jsonarray[i]["totalprice"]; // 누적합계
				
				tr += 
				'<tr>'+
'					<td> <!--  상품정보 열 -->'+
'						<div class="row"> <!-- row(b) : 하위 태그를 가로배치   -->'+
'							<div class="col-sm-2"> <!-- col-sm-2(b) : 12그리드 중 2그리드 사용 -->'+
'								<img alt="" src="/jspweb/admin/productimg/'+jsonarray[i]["pimg"]+'" width="70%"> '+
'							</div>'+
'							<div class="col-sm-10">'+
'								<div class="pnamebox"> '+jsonarray[i]["pname"]+' </div>'+
'								<div class="optionbox">'+jsonarray[i]["scolor"]+' / '+jsonarray[i]["ssize"]+'</div>'+
'							</div>'+
'						</div>   '+
'						<br>'+
'					</td> '+
'					<td class="align-middle">'+
'						<div class="row g-0"> '+
'							<div class="col-sm-5 offset-3">'+ jsonarray[i]["samount"] +' 개 </div>'+
'						</div>'+
'					</td>'+
'					<td class="align-middle">'+
'						<div class="row g-0">'+
'							<div class="col-md-8 pricebox">'+jsonarray[i]["totalprice"].toLocaleString()+'원</div>'+
'						</div>'+
'					</td>'+
'				</tr>';
			}
			// 만약에 총가격이 7만원 이상이면 배송비 무료
			if( sumprice >= 70000 ){ deliverypay = 0;}
			else{ deliverypay = 2500; }
			
			// 만약에 장바구니에 상품이 없으면 
			if( jsonarray.length == 0 ){
				tr += '<td style="text-align: center" colspan="3">'+ 
						'상품이 없습니다. '+
						'</td>';
				deliverypay = 0; 
			}
			// 총주문금액 = 총가격 + 배송비 - 사용포인트 
			totalpay = sumprice + deliverypay - mpoint;
			// 포인트 
			point = parseInt( sumprice * 0.01 ); /* js : parseInt( 데이터 ) : -> 정수형 변환 */
			// 출력 
			$("#carttable").html( tr );	// 테이블 상품 출력 
			$("#mpoint").html( member["mpoint"] ); // 사용가능 포인트 출력 
			$("#pointbox").html( mpoint );	// 사용할 포인트 출력 
			$("#totalpay").html( totalpay ); // 총주문금액 출력 
			$("#sumprice").html( sumprice );	// 총상품 출력 
			$("#deliverypay").html( deliverypay ); // 배송비 출력 
}

// 4. 결제수단 선택 메소드 
function paymethod( method ){
	$("#paymethod").html( method ); // html에 인수 출력 
	pay_method = method; // 결제수단 변수에 인수 넣기
}

// 5. 아임포트 실행 메소드 /* 아임포트 API = 결제API */
function payment(){
	
	if( pay_method == null ){ // 만약에 결제수단을 선택를 안했으면
		alert('결제수단을 선택해주세요.!'); return;
	}
	
	var IMP = window.IMP; 
	IMP.init("imp35631338"); // [본인]관리자 식별코드 [ 관리자 계정마다 다름] 
    IMP.request_pay({ // 결제 요청변수 
	    pg: "html5_inicis",	// pg사 [ 아임포트 관리자페이지에서 선택한 pg사 ]
	    pay_method: pay_method,	// 결제방식
	    merchant_uid: "ORD20180131-0000011", // 주문번호[별도]
	    name: "EZEN SHOP", // 결제창에 나오는 결제이름
	    amount: totalpay,	// 결제금액
	    buyer_email: member["mid"],
	    buyer_name: member["mname"],
	    buyer_tel: member["mphone"],
	    buyer_addr: member["maddress"],
	    buyer_postcode: member["maddress"].split("_")[0],	// 우편번호
		  }, function (rsp) { // callback
		      if (rsp.success) { // 결제 성공했을때 -> 주문 완료 페이지로 이동 []
		      	alert("주문 취소");
		      } else {	// 결제 실패했을때 
				saveorder(); // 결제 실패 했을때 -> 테스트 할시에는 이부분 활용
		      }
	  });
}
// 6. 주문 처리 메소드 
function saveorder(){
	// 주문 정보 호출 
	let ordername = $("#ordername").val();
	let orderphone = $("#orderphone").val();
	let orderaddress = 
			$("#sample4_postcode").val() + "_"+
			$("#sample4_roadAddress").val() + "_"+
			$("#sample4_jibunAddress").val() + "_"+
			$("#sample4_detailAddress").val();
	let ordertotalpay = totalpay;
	let orderrequest = $("#orderrequest").val();
	
	let orderjson = {	// 주문 정보 객체화 
		ordername : ordername  ,
		orderphone : orderphone , 
		orderaddress : orderaddress ,
		ordertotalpay : ordertotalpay , 
		orderrequest : orderrequest 
	}
	
	$.ajax({
		url : "saveorder",		
		data : { 'orderjson' : JSON.stringify(orderjson) } , // 객체 -> json형 변환
		success : function( re ){
			// request , response 객체는 별다른 타입 설정이 없으면 문자열 타입 
			if( re == "true") { // 만약에 주문db처리 성공이면 성공페이지 이동
				location.href = "/jspweb/product/ordersuccess.jsp" ;
			}else{
				alert("오류 발생 [ 관리자에게 문의 ]")
			}
		}
	});
}

// 7.포인트 사용 메소드  
function pointbtn(){
	
	mpoint = $("#pointinput").val();
	if( mpoint == 0  ){ // 만약에 포인트가 0 이 아니면
		mpoint = 0;
	}else if( mpoint < 5000 ){ // 만약에 포인트가 5000미만 이 아니면
		alert('최소 5000부터 사용가능합니다. ');
		mpoint = 0; 
		$("#pointinput").val(0);
		return;
	}else if( mpoint > member["mpoint"] ){  // 만약에 포인트가 보유 포인트보다 많으면
		alert('포인트가 부족합니다. ');
		mpoint = 0; 
		$("#pointinput").val(0);
		return;
	}
	cartview(); // 새로고침
}



































