
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
					.innerHTML ="해당 태그에 넣을 데이터" 		: 해당 태그에 데이터 넣기 
					.textContent = "해당 태그에 넣을 데이터"		: 해당 태그에 데이터 넣기 
					.style.css속성명	= 속성값					: 해당 태그에 css 속성 적용
					.value									: 해당 태그에 value 값 가져오기 [ value 속성이 있는 태그만 가능 ]
			3. console.log()	: 브라우저(F12)내 console창에 출력 [ 테스트목적 ]	
		4. 반복문 / 제어문 = java 동일
			1. for( 초기값 ; 조건식 ; 증감식 ){  }
			2. if( 논리식 ){   }		
		5. 함수 선언 
			1. function 함수명(  ) { 실행문; }				: 인수가 없을때 
			2. function 함수명( 인수명 , 인수명 ){ 실행문; }	: 인수가 있을때	
*/

var 메시지1 = "js var변수";		//alert( 메시지1 ); console.log( 메시지1 );
var 메시지1 = "js var중복변수";		//alert( 메시지1 );
// 변수 var : 변수명 중복 가능 , 메모리 초기화 가능

const 메시지4 = "js const변수";		//alert(메시지4);
//메시지4 = "js const변수 값 변경 ";	alert(메시지4 );	
// 변수 const : 변수명 중복 불가능 , 메모리 초기화 불가능 = 상수

let 메시지5 = "js let변수";			//alert(메시지5);
//let 메시지5 = "js let중복변수"; 	alert(메시지5);
메시지5 = "js let변수 값 변경";  	//alert(메시지5);
 // 변수 let : 변수명 중복 불가능 
 
let tag1 = document.getElementById( "spantag1" );
tag1.innerHTML = "js에서 작성된 문자";

let 가격 = 500;	// 변수 선언 
let 개수 = 10;	// 변수 선언 
let 총가격 = 가격 * 개수 ; // 변수 연산 
let tag2 = document.getElementById( "spantag2");
tag2.innerHTML = 총가격;

// 함수 = 메소드
	// js : function 함수명( 인수 ){ 실행문 }
	// java : void 함수명( 인수 ){ 실행문 }
function 함수1(){	// html 태그내 이벤트 태그에서 함수호출 해야 실행 가능 
	let 색상배열 = [ 'red' , 'white' , 'black'] ;
	// 배열선언 :  let 배열명 = [ 값1 , 값2 , 값3 ~~~ ];
	// 배열호출 : 배열명[인덱스번호];
	let tag3 =  document.getElementById("spantag3");
	tag3.textContent = 색상배열[0];
	tag3.style.color = 색상배열[0];
	// body 태그에 css 배경색변경
	document.body.style.backgroundColor = "#eeeeee";
}
function 함수2(){ // 메소드 선언 
	// while
	let i = 1 ;	// 변수선언 
	while( i <= 10  ){ // 반복문  : 10회 반복 
		let tag4 = document.getElementById("orderlist1");
		tag4.innerHTML += "<li>반복횟수 : "+i+"</li>";
		//   += (대입연산자) 기존 html에 추가 
		i++;
	}
	// for 
	let j = 0 ; // 변수 선언 
	let 제품배열 = ["갤럭시" , "아이폰" , "엘지폰"]; // 배열 선언
	for( j ; j<제품배열.length ; j++ ){
		let tag5 = document.getElementById("orderlist2"); 
		tag5.innerHTML +="<li> 제품명 : " + 제품배열[j] + "</li>";
	}
}
function 함수3(){ // 메소드선언 
	// let 제품명 = "콜라";
	let 제품명 = document.getElementById("input1").value; // input에서 입력된 값 가져오기
	document.getElementById("orderlist3").innerHTML 
		+= "<li>"+제품명+"</li>"
}
function 함수4(){
	document.getElementById("orderlist3").innerHTML="";
}
function 함수5( 이름 , 성별  ){
	document.writeln("입력하신 이름 : " + 이름 );
	document.writeln("입력하신 성별 : " + 성별 );
}

















