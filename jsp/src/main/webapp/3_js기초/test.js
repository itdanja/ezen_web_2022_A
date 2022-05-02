
/*
	js [ 사용목적 : 유효성검사 , 비동기통신(화면전환없는통신) 등 ]
	js문법
		1. 주석 : java 동일 
		2. 변수선언 
			1. var : 변수명 중복O , 메모리 초기화O 
			2. const : 변수명 중복X , 메모리 초기화X
			3. let : 변수명 중복X , 메모리 초기화O 
		3. 내장객체/메소드
			1. alert("알림내용")	: 알림창 메소드
			2. document			: 문서 객체 [ 현 html 객체화 ]
				1. .write("html작성")		: html쓰기
				2. .getElementById("html 해당 태그의 id명") : 해당 태그 가져오기
					.innerHTML("해당 태그에 넣을 데이터") : 해당 태그에 html 넣기 
			3. console.log()	: 브라우저(F12)내 console창에 출력 [ 테스트목적 ]	
		4. 반복문 / 제어문 = java 동일
			1. for( 초기값 ; 조건식 ; 증감식 ){  }
			2. if( 논리식 ){   }			
*/

var 메시지1 = "js var변수";		alert( 메시지1 ); console.log( 메시지1 );
var 메시지1 = "js var중복변수";	alert( 메시지1 );
// 변수 var : 변수명 중복 가능 , 메모리 초기화 가능

const 메시지4 = "js const변수";		alert(메시지4);
//메시지4 = "js const변수 값 변경 ";	alert(메시지4 );	
// 변수 const : 변수명 중복 불가능 , 메모리 초기화 불가능 = 상수

let 메시지5 = "js let변수";			alert(메시지5);
//let 메시지5 = "js let중복변수"; 	alert(메시지5);
메시지5 = "js let변수 값 변경";  	alert(메시지5);
 // 변수 let : 변수명 중복 불가능 
 
let tag1 = document.getElementById( "spantag1" );
tag1.innerHTML = "js에서 작성된 문자";

 
 
 
 
 
 
 
 
 

 
 