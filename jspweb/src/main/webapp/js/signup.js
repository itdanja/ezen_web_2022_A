// jquery(제이쿼리) : js 프레임워크
	// $ : 제이쿼리 ( 라이브러리 설치 : header파일 body 태그에 cdn 추가 )
// $( function() { 실행문; } ) : 문서 실행시 무조건 실행되는 함수
	// js식		id불러오기  .getElementById( id명 )
	// jquery식	id불러오기  $("#id명")
		// keyup(  ) : 해당 id에 키보드가 눌렸을때 [ 입력 되었을때 ] 
		
$( function(){  // 문서 열리면 해당 코드가 실행 
	// 아이디 체크
	$("#mid").keyup( function(){	// mid 가 입력될때마다 해당 함수 실행
		// 1. HTML 태그내 값 가져오기 
		let mid=document.getElementById("mid").value;
		// 2. HTML 태그id 가져오기
		let idchack = document.getElementById("idchack");
		// 정규표현식 : 특정한 규칙을 가지는 문자열의 집합 언어
		let idj = /^[a-zA-Z0-9]{5,15}$/;	// 한글을 제외한 영문+숫자 5~15 사이 문자열
			// /^ : 정규표현식 시작
			// $/ : 정규표현식 끝 
			// [a-z] : 소문자 찾음
			// [A-Z] : 대문자 찾음
			// [0-9] : 숫자 찾음
			// { 최소길이 , 최대길이 } : 문자 최소길이~최대길이 까지만 입력
				// 정규표현식.test( 변수 ) : 해당 변수가 정규표현식에 동일하면 true 다르면 false
		if( idj.test( mid) ){ // 정규표현식과 같으면
			idchack.innerHTML = "가능한 아이디 입니다."
		}else{
			idchack.innerHTML = "영문 , 숫자 포함 5~15길이로 입력해주세요.";
		}
	}); // keyup end 
	
	// 비밀번호 체크 
	$("#mpassword").keyup( function(){  // 비밀번호 입력할때마다
		// let mpassword = document.getElementById("mpassword").value;  // js식
		let mpassword = $("#mpassword").val();  // jquery 식
		let mpasswordcheck = $("#mpasswordcheck").val();
		
		let passswordj = /^[a-zA-Z0-9]{5,15}$/; // 정규표현식
		
		if( passswordj.test( mpassword ) ){ // 정규표현식 같으면
			if( mpassword != mpasswordcheck ){ // 비밀번호 와 비밀번호체크 와 다르면
				// equals(x)  //  != ( o )
			$("#passwordchack").html("패스워드가 서로 다릅니다.");
			}else{
				$("#passwordchack").html("사용 가능한 비밀번호 입니다.");
			}
		}else{ // 정규현식 다르면
			$("#passwordchack").html("영소문자 5~15 사이로 입력해주세요!");
		}
	}); // keyup end 
	
}); // 문서 열리면 해당 코드가 종료 












