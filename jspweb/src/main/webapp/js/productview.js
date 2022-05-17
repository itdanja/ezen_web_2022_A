
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

 /* 사이즈 목록이 변경되었을때  */
$("#size_select").change( function(){
	let pname = $("#pname").html();	// 제품이름 
	let color = $("#color_select").val();// 선택한 색상 
	let size = $("#size_select").val(); // 선택한 사이즈
	let amount = $("#amount").val(); // 구매 수량
	if( $("#amount").val() == null ) amount = 1;	// input 생성되기전 이면 기본값 1 
	let pprice =  $("#pprice").val(); // 제품 가격 
	// 만약에 이미 있는 칼라/색상이면 중지
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





