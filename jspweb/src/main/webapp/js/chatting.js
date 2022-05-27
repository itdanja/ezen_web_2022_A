
$("#incontent").focus(); // 스크립트가 실행될때 입력창에 커서 두기
let websocket = null; // js 웹소켓 변수 

/* 엔터 입력했을때 이벤트 */
function enterkey(){
	
	if( window.event.keyCode == 13 ){
		$("#incontent").val(""); // 전송후 입력창 초기회
		$("#incontent").focus();	// 전송후 포커스(커서)
	}
	
}
/* 전송 버튼를 눌렀을때 이벤트 */
function sendbtn(){
	$("#incontent").val(""); // 전송후 입력창 초기회
	$("#incontent").focus();	// 전송후 포커스(커서)
}


/* 채팅 소켓 실행 */
function start(){
	//	js 에서 사용되는 웹소켓 클래스( ws:// IP번호/PORT번호/프로젝트명/서버소켓이름 )
	websocket = new WebSocket("ws://localhost:8081/jspweb/chatting");
	websocket.onopen = function( e ){ onOpen(e) }
}
function onOpen(){
	alert("서버소켓으로 들어왔습니다. : "+ e );
	console.log( e );
}
