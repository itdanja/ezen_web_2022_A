
function passwordcheck(  mid  ){
	
	// * 제이쿼리식 
	let mpassword =  $("#mpassword").val();
	// * 자바스크립트식
	// let mpassword document.getElementById("mpassword").value;
	
	// 비통기 통신 = 제이쿼리 제공해주는 통신 메소드
		// [js(view) ---> java(controller) ]
	//  $.ajax({ 속성명 = 속성값 , 속성명2 = 속성값2 });
	$.ajax({
		url : "../passswordcheck",	// 어디로
		data : { "mid": mid , "mpassword" : mpassword }, // 보낼 데이터 
		type : "POST" , // HTTP요청방식 정의 [ GET=기본값 , POST ]
		success : function( result ){ // 받을 데이터 
			alert("하하하" + result )
			if( result == 1 ){
				alert("같다");
				$("#checkmsg").html("정말 탈퇴하시겠습니까?");
				$("#mpassword").css("display" , "none"); // 제이쿼리 css 적용  [ .css( "속성명" , "속성값") ]
				$("#btndelete").css("display" , "block");
			}else{
				alert("다르다");
				$("#checkmsg").html("동일한 패스워드가 아닙니다.");
			}
		}
	});	
}





