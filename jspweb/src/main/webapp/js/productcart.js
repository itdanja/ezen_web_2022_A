

let jsonarray; // JSON 형식의 변수를 선언
	
let sumprice = 0; //상품 총가격 변수 선언 
let deliverypay = 0; // 배송비 변수 선언 
let totalpay = 0; // 총주문액 변수 선언 
let point = 0; // 포인트 변수 선언 

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
			tableview();	/* 테이블 출력 메소드 호출  */
		}
	});
}


/* 3. 테이블에 데이터를 넣어주는 함수 */
function tableview(){

		// js : json 객체내 key값 이용한 value 추출 
				// 객체명[key] -> value 호출 
				// jsonarray[i][key] -> json배열내 i번째 객체의 key 값 호출 
			let tr = '<tr> <!-- 헤더 -->'+
'					<th width="60%">상품정보</th> 	<!-- width속성 : 가로길이  -->'+
'					<th width="20%">수량</th> 		'+
'					<th width="20%">가격</th> '+
'				</tr>';

			sumprice = 0; /*상품 총가격 */
			deliverypay = 0; // 배송비 
			totalpay = 0; // 총주문액 
			
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
'					<td class="align-middle"> <!-- 수량 --> <!-- align-middle(b) : 수직 중앙배치 -->'+
'						<div class="row g-0"> <!-- g-0(b) : 그리드 간 여백 제거 -->'+
'							'+
'							<div class="col-sm-5 offset-3">'+
'								<!-- form-control(b) : 입력상자 형식 꾸미기 -->'+
'								<input readonly id="" value="'+jsonarray[i]["samount"]+'" type="text" class="form-control" style="background-color: white;">'+
'							</div>'+
'							'+
'							<div class="col-sm-2">'+
'								<button onclick="amountincre('+i+')" class="amount_btn"> ▲ </button>'+
'								<button onclick="amountdecre('+i+')" class="amount_btn"> ▼ </button>'+
'							</div>'+
'						</div>'+
'					</td>'+
'					<td class="align-middle"> <!--  가격 -->'+
'						<div class="row g-0">'+
'							<div class="col-md-8 pricebox">'+jsonarray[i]["totalprice"].toLocaleString()+'원</div>'+
'							<div class="col-md-4 deletebox"><button onclick="cancel('+i+')">X</button></div>'+
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
			// 총주문금액 = 총가격 + 배송비 
			totalpay = sumprice + deliverypay;
			// 포인트 
			point = parseInt( sumprice * 0.01 ); /* js : parseInt( 데이터 ) : -> 정수형 변환 */
			// 출력 
			$("#sumprice").html( sumprice.toLocaleString()+'원' );
			$("#deliverypay").html( deliverypay.toLocaleString()+'원' );
			$("#totalpay").html( totalpay.toLocaleString()+'원' );
			$("#point").html( point.toLocaleString() );
			
			$("#carttable").html( tr );
}
/* 4. json상태 업데이트 처리 메소드 */
function updatecart(){
	$.ajax({
		url : "updatecart" ,
		data : { "json" : JSON.stringify(jsonarray) } , // 현재 jsonarray 상태 전송
		success : function ( json ){
			getcart();
		}
	});
}
/* 8. 장바구니 삭제 처리 메소드 */
function deletecart( i ){
	$.ajax({
		url :'deletecart',
		data : { 'cartno' : jsonarray[i]["cartno"] } ,
		success : function( re ){
			getcart();
		}
	});
}

/* 5. 수량 증가 메소드 */
function amountincre(i){
	// 재고의 최대값 가져오기 -> productview.js 사용된 서블릿 재사용 
	$.ajax({
		url : "getamount" , 
		data : { "pno" : jsonarray[i]['pno'] ,
		 "color" :  jsonarray[i]['scolor'] , 
		 "size" : jsonarray[i]['ssize'] } ,
		success : function ( maxamount ){
			if( jsonarray[i]['samount'] >= maxamount ){ alert("재고가 부족합니다. "); return; }
			// 총금액 업데이트 
			let price = parseInt ( (  jsonarray[i]['totalprice'] / jsonarray[i]['samount'] ) ); // 제품 하나의 금액
			jsonarray[i]['samount']++; // 수량증가 
			jsonarray[i]['totalprice'] = price * jsonarray[i]['samount']; // 증가된 수량의 총금액 업데이트
			updatecart();
		}
	});
}
/* 6. 수량 감소 메소드 */
function amountdecre(i){
	if( jsonarray[i]["samount"] == 1  ){ alert("최소 수량입니다."); return }
	let price = parseInt ( (  jsonarray[i]['totalprice'] / jsonarray[i]['samount'] ) ); // 제품 하나의 금액
	jsonarray[i]['samount']--; // 수량감소 
	jsonarray[i]['totalprice'] = price * jsonarray[i]['samount']; // 증가된 수량의 총금액 업데이트
	updatecart();
}

/* 7. json배열내 특정 인덱스 / 전체 인덱스=-1 삭제 */
function cancel( i ){
	if( i == -1 ){  // 만약에 i가 -1 이면 전체 삭제 
		if( confirm('전체 삭제하시겠습니까?') ){
			// confirm("내용") : 확인/취소 버튼 알림창  // 만약에 확인 눌렀을떄 - true  // 취소 -> false;
			for( let j = 0 ; j<jsonarray.length; j++ ){
				deletecart( j ); // 삭제  DB처리 
			}
		}
		return;
	}
	deletecart( i ); // 삭제  DB처리 
}















