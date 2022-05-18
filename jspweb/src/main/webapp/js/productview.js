


/* 칼라 select 목록이 변경 되었을때 */
$("#color_select").change( function(){
	
	let color = $("#color_select").val(); // 색상 
	if( color == ""){ return; }	// 색상이 선택이 없으면
	
	let pno = $("#pno").val(); // 제품번호 
	
	$.ajax({ // 통신시 사용되는 데이터 타입 -> 문자열 / 첨부파일
		url : 'getstocksize' , 
		data : { 'pno' : pno , 'color': color } ,
		success : function( re ){
			
			let list =re.replace( "{","");
			let itemlist = list.split(",");
			let html ="";
				html +="<option value=''>-[필수]옵션 선택-</option>";
			for( let item of itemlist ){
				let color = item.split("=")[0];
				let amount = item.split("=")[1];
					html += "<option value='"+color+"'>"+color+" - "+amount+"</option>";
			}
			$("#size_select").html(html);	// id.html( )  : 새로운 데이터 
			// $("#size_select").append('<option>asdasd</option>'); // id.append( ) : 데이터 추가
		}
	});
});

	// js 메모리는 스크립트파일 재호출시[F5] 메모리 초기화
	
	// js 자료형  -> x 
		// let=변수 const=상수 
	// js 배열 
		// let 배열명 = [  ]
		// 추가 : push() 	-> 배열내 마지막인덱스에 뒤에 추가 
		// 제거 : pop() : 	-> 배열내 마지막인덱스에 삭제 
		// 특정인덱스 삭제 : splice( 시작인덱스 , 개수 ) -> 특정 시작인덱스부터 개수만큼 삭제 
			// 배열내 중간인덱스 삭제시 빈공간 인덱스 당기기  -> java 리스트 클래스 동일 
				// 예) 3번 인덱스 삭제시 : 4번 인덱스-> 3번인덱스 당겨짐 
	// js 객체 선언 -> object = {   }
		// let 객체명 = {  필드명1 : 값  , 필드명2 : 값 , 필드명3 : 값  }
		// 호출 [ .연산자 ] 
			// 객체명.필드명 
			
let selectlist = [ ];	// js 배열 

/* 사이즈 목록이 변경되었을때 선택값을 객체화해서 배열에 저장   */
$("#size_select").change( function(){
	let pname = $("#pname").html();	// 제품이름 
	
	let color = $("#color_select").val();// 선택한 색상 
		if( color == ""){ return; }	// 색상이 선택이 없으면
	
	let size = $("#size_select").val(); // 선택한 사이즈
		if( size == ""){ return; }	// 사이즈 선택이 없으면
	
	let amount = $("#amount").val(); // 구매 수량
		if( $("#amount").val() == null ) amount = 1;	// input 생성되기전 이면 기본값 1 
	let pprice =  $("#pprice").val(); // 제품 가격 
	let overcheck = color+size; /* 옵션 - 식별용 */
	
	let product = {  	// js 객체 선언 
		pname : pname , 	// 필드명(속성명) : 데이터 
		color : color ,  
		size : size , 
		amount : amount , 
		pprice : pprice ,
		overcheck : overcheck 
	}
	
	for( let i = 0 ; i<selectlist.length ; i++ ){ // 만약에 배열에 이미있는 옵션이면 중지
		if( selectlist[i].overcheck == overcheck ) {  alert("이미 선택한 옵션입니다."); return; }
		// 배열내 i번째 객체의 필드[중복체크]호출 
				// js = 문자열 비교 ==   // java =  문자열 비교 x -> equals 메소드 
	}
	selectlist.push( product ); // 배열에 객체 추가 
	
	optionprint();
	
});

/* 배열내 모든 객체를 테이블에 출력하는 함수 */
function optionprint(){
	 /* 테이블에 추가할 내용물 */
	let html ='<tr><th width="60%"> 상품명 </th> <th width="25%"> 상품수 </th> <th width="15%"> 가격 </th> </tr>';
	/* 배열내 모든 객체의 정보를 html 화 하기 */
	for( let i = 0 ; i<selectlist.length ; i++ ){
		html += 
		'<tr>'+
			'<td> <span>'+selectlist[i].pname+'</span> <br> <span class="pointbox">- '+selectlist[i].color+'/'+selectlist[i].size+'</span>'+
			'</td>'+
			'<td> <div class="row g-0">'+
					'<div class="col-md-7">'+
						// 수량 입력상자-> readonly : 읽기전용 //  값 : 객체내 수량 
						'<input readonly id="amount" value='+selectlist[i].amount+' type="text" class="form-control amount_input">'+
					'</div>'+
					'<div class="col-md-4">'+
						// 구매수량 증가/감소 버튼 -> 클릭이벤트 -> i번째 인덱스 전달 
						'<button onclick="amountincre('+i+')" class="amount_btn">▲</button>'+
						'<button onclick="amountdecre('+i+')" class="amount_btn">▼</button>'+
					'</div>'+
					'<div class="col-md-1"> <button onclick="optioncancel('+i+')" class="cancel_btn">x</button>'+
									// x 버튼을 눌렀을때 이벤트 -> 클릭한 인덱스 i값 인수 전달 => i : 배열내 객체 인덱스 
					'</div>'+
				'</div>'+
			'</td>'+
			'<td>'+
				'<span class="pricebox">'+(selectlist[i].amount*selectlist[i].pprice)+'</span> <br>' +
				'<span class="pointbox">(적)'+(selectlist[i].amount*selectlist[i].pprice)*0.01+'</span>'+
			'</td>'+
		'</tr>'
	}
	$("#select_table").html( html );
	/* 객체내 총합계 */
	let total_price = 0;
	let total_amount =  0;
	for( let i = 0 ; i<selectlist.length; i++  ){
		total_price += (selectlist[i].amount*selectlist[i].pprice);
		total_amount += selectlist[i].amount;
	}
	$("#total_price").html( total_price + '('+ total_amount +'개)' );
	
}

/* 해당 인덱스를 배열내 제거 함수  */
function optioncancel( i ){
	selectlist.splice( i , 1 ); // i번째 인덱스부터 1개의 인덱스 삭제 
	optionprint();	// 삭제후 옵션목록 다시 출력
}
/* 해당 인덱스의 상품수 증가 함수  */
function amountincre( i ) {
	// 만약에 재고보다 상품수 더 크면 함수 종료 
	let pno = $("#pno").val();
	$.ajax({
		url : "getamount", 
		data : { 'pno' : pno , 'color' : selectlist[i].color , 'size' : selectlist[i].size },
		success : function( maxamount ){
			if( selectlist[i].amount >= maxamount ){ alert('재고가 부족합니다.'); return; }
			selectlist[i].amount++; // 선택한 객체들이 모여있는 배열 // 해당 인덱스의 객체내 수량 1증가 
			optionprint();	// 변경후 옵션목록 새로고침
		}
	});
}
/* 해당 인덱스의 상품수 감소 함수 */
function amountdecre( i ){
	// 만약에 수량이 1 이면 함수 종료 
	if( selectlist[i].amount == 1 ) { alert('최소 수량 입니다.');  return; }
	selectlist[i].amount --; // 해당 인덱스의 객체내 수량 1감소 
	optionprint();	// 변경후 옵션목록 새로고침
}















