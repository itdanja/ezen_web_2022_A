
/* 칼라 select 목록이 변경 되었을때 */
$("#color_select").change( function(){
	
	let color = $("#color_select").val(); // 색상 
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

	// js 배열 
		// let 배열명 = [  ]
		// 추가 : push() 	-> 배열내 마지막인덱스에 뒤에 추가 
		// 제거 : pop() : > 배열내 마지막인덱스에 삭제 
let 선택한목록 = [ ];	// js 배열 
/* 사이즈 목록이 변경되었을때  */
$("#size_select").change( function(){
	let pname = $("#pname").html();	// 제품이름 
	let color = $("#color_select").val();// 선택한 색상 
	let size = $("#size_select").val(); // 선택한 사이즈
	let amount = $("#amount").val(); // 구매 수량
	if( $("#amount").val() == null ) amount = 1;	// input 생성되기전 이면 기본값 1 
	let pprice =  $("#pprice").val(); // 제품 가격 
	
	let 중복체크 = color+size; /* 옵션 - 식별용 */
	for( let i = 0 ; i<선택한목록.length ; i++ ){ // 만약에 배열에 이미있는 옵션이면 중지
		if( 선택한목록[i] == 중복체크 ) {  alert("이미 선택한 옵션입니다."); return; }
				// js = 문자열 비교 ==   // java =  문자열 비교 x -> equals 메소드 
	}
	선택한목록.push( 중복체크 ); // 배열 추가 
	$("#select_table").append(
		'<tr>'+
			'<td> <span>'+pname+'</span> <br>  <span class="pointbox">- '+color+'/'+size+'</span>'+
			'</td>'+
			'<td> <div class="row g-0">'+
					'<div class="col-md-7">'+
						'<input id="amount" value="1" type="text" class="form-control amount_input">'+
					'</div>'+
					'<div class="col-md-4">'+
						'<button class="amount_btn">▲</button>'+
						'<button class="amount_btn">▼</button>'+
					'</div>'+
					'<div class="col-md-1"> <button class="cancel_btn">x</button>'+
					'</div>'+
				'</div>'+
			'</td>'+
			'<td>'+
				'<span class="pricebox">'+(amount*pprice)+'</span> <br>' +
				'<span class="pointbox">(적)'+(amount*pprice)*0.01+'</span>'+
			'</td>'+
		'</tr>'
	);
});





