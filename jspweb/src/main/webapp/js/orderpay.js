
let jsonarray; // JSON 형식의 변수를 선언

let sumprice = 0; // 상품 총가격 변수 선언 
let deliverypay = 0; // 배송비 변수 선언 
let totalpay = 0; // 총주문액 변수 선언 
let point = 0; // 포인트 변수 선언 

let member;	// 회원정보 json 객체 [ 비밀번호 제외한 ]
let mpoint; // 회원이 사용하는 포인트

/* 1. 자바스크립트 열리면 무조건 실행되는 메소드 */
$( function(){  // $(document).ready( function(){});  // 문서내에서 대기상태 이벤트
	
	// 회원 정보 출력  
	$.ajax({
		url : "/jspweb/member/getmember" , 
		success : function( json ){
			member = json;	
			getcart();	// 제품 출력 메소드 불러오기
		}
	});
	
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
			$("#carttable").html( tr );
			$("#mpoint").html( member["mpoint"] );
			$("#pointbox").html( mpoint );
			$("#totalpay").html( totalpay );
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
	    buyer_email: member["mid"],
	    buyer_name: member["mname"],
	    buyer_tel: member["mphone"],
	    buyer_addr: member["maddress"],
	    buyer_postcode: member["maddress"].split("_")[0],	// 우편번호
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

function pointbtn(){
	
	// 만약에 포인트가 5000이상이 아니면
	mpoint = $("#pointinput").val();
	if( mpoint == 0  ){
		mpoint = 0;
	}else if( mpoint < 5000 ){
		alert('최소 5000부터 사용가능합니다. ');
		mpoint = 0; 
		$("#pointinput").val(0);
		return;
	}else if( mpoint > member["mpoint"] ){
		alert('포인트가 부족합니다. ');
		mpoint = 0; 
		$("#pointinput").val(0);
		return;
	}
	
	cartview(); // 새로고침
}



































