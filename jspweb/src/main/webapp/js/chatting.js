
$("#incontent").focus(); // 스크립트가 실행될때 입력창에 커서 두기
let websocket = null; // js 웹소켓 변수 

/* 1.  엔터 입력했을때 이벤트 */
function enterkey(){    if( window.event.keyCode == 13 ){  send();  }  }
/* 2. 전송 버튼를 눌렀을때 이벤트 */
function sendbtn(){   send();  }

start();
/* 채팅 소켓 실행 */
function start(){
	//	js 에서 사용되는 웹소켓 클래스( ws:// IP번호/PORT번호/프로젝트명/서버소켓이름 )
	websocket = new WebSocket("ws://localhost:8081/jspweb/chatting");
	websocket.onopen = function( e ){ onOpen(e) }
	websocket.onmessage = function( e ){ onmessage(e) }
}
function onOpen(){
	alert("서버소켓으로 들어갑니다~ : "+ e );
	console.log( e );
}
function onmessage( e ){
	alert("메시지를 받습니다." + e +" 내용물 : " + e.data );
	console.log( e );
}
function send(){
	alert("메시지를 보냅니다.");
	
	let msg = $("#incontent").val();
	
	websocket.send(  msg  );
	
	$("#incontent").val(""); // 전송후 입력창 초기화
	$("#incontent").focus();	// 전송후 포커스(커서)
}







