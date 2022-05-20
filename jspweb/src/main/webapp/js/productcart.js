
/* JSON 형식의 변수를 선언 */
let jsonarray;


/* 테이블에 데이터를 넣어주는 함수 */
function tableview(){
		// js : json 객체내 key값 이용한 value 추출 
				// 객체명[key] -> value 호출 
				// jsonarray[i][key] -> json배열내 i번째 객체의 key 값 호출 
			let tr = '<tr> <!-- 헤더 -->'+
'					<th width="60%">상품정보</th> 	<!-- width속성 : 가로길이  -->'+
'					<th width="20%">수량</th> 		'+
'					<th width="20%">가격</th> '+
'				</tr>';
			for( let i = 0 ; i<jsonarray.length; i++ ){
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
'								<button class="amount_btn"> ▲ </button>'+
'								<button class="amount_btn"> ▼ </button>'+
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
			$("#carttable").html( tr );
}

/* json배열내 특정 인덱스 삭제 */
function cancel( i ){
	jsonarray.splice( i , 1 ); // i번째 부터 1개를 삭제 
	tableview();	// 테이블 새로고침
}

/* 자바스크립트 열리면 무조건 실행되는 메소드 */
$( function(){  
	$.ajax({
		url : 'getcart' ,
		success : function( json ){
			jsonarray = json;	/* 응답받은 데이터를 전역변수에 넣어주기 */
			tableview();	/* 테이블 출력 메소드 호출  */
		}
	});
});
















