
$("#incontent").focus(); // 스크립트가 실행될때 입력창에 커서 두기
let websocket = null; // js 웹소켓 변수 

start(); // 소켓 실행 

/* 1.  엔터 입력했을때 이벤트 */
function enterkey(mid){    
	if( window.event.keyCode == 13 ){  
		if( mid == 'null' ){
			alert("로그인후 채팅입력이 가능합니다."); return;
		}
		send( mid ); // 메시지 전송
	} 
}
/* 2. 전송 버튼를 눌렀을때 이벤트 */
function sendbtn(mid){   
	if( mid == 'null' ){
			alert("로그인후 채팅입력이 가능합니다."); return;
	}
	send( mid );  // 메시지 전송
}

/* 3. 채팅 소켓 실행 메소드 */
function start(){
	//	js 에서 사용되는 웹소켓 클래스( ws:// IP번호/PORT번호/프로젝트명/서버소켓이름 )
	websocket = new WebSocket("ws://localhost:8081/jspweb/chatting");
	websocket.onopen = function( e ){ onOpen(e) }
	websocket.onmessage = function( e ){ onmessage(e) }
	websocket.onclose = function( e ){ onclose(e) }
	websocket.onerror = function( e ){ onerror(e) }
}

function onclose( e ){ alert("채팅방을 나갑니다.") + e;   }

function onerror( e ){ alert("서버소켓 오류 입니다." + e );  }

function onOpen( e ){
	alert("서버소켓으로 들어갑니다~ : "+ e );
	console.log( e );
}
function onmessage( e ){
	// e : 메소드 이벤트 실행정보가 담겨있는 객체
		// e.data : 메시지 내용이 담겨있는 필드 
	let msg = JSON.parse( e.data );	 // 문자열 -> json
	let from = msg["from"];	// json 키를 통한 value 호출
	let content = msg["content"];	// json 키를 통한 value 호출
	let img = msg["img"];	// json 키를 통한 value 호출
	let date = msg["date"];	// json 키를 통한 value 호출
	
	let html = $("#contentbox").html();	// 기존 html 가져오기
	if( from == $("#mid").val() ){ // 현재 로그인된 아이디와 보낸사람이 같으면
		// 내가 보냈을때 
		html +=
				'<div class="secontent my-3">'+
					'<span class="date"> '+date+' </span>'+
					'<span class="content"> '+content+' </span>'+
				'</div>';
	}else{
		// 다른 사람이 보냈을때 
		html +=	// 기존 html 추가 
			'<div class="row g-0 my-3"> '+
					'<div class="col-sm-1 mx-2">'+
						'<img alt="" src="../img/'+img+';" class="rounded-circle" width="100%" >'+
					'</div>'+
					'<div class="col-sm-9">'+
					'	<div class="recontent">	 '+
							'<div class="member_name"> '+from+' </div>'+
							'<span class="content"> '+content+' </span>'+
							'<span class="date"> '+date+' </span>'+
						'</div>'+
					'</div>'+
				'</div>';
	}
	
	$("#contentbox").html( html ); // 추가된 html 넣어주기
	// 스크롤 하단으로 내리기 
	$("#contentbox").scrollTop( $("#contentbox")[0].scrollHeight );
		// $("#contentbox").scrollTop : 현재 스크롤의 상단 위치 
		// $("#contentbox")[0].scrollHeight : 현재 스크롤의 전체 길이 
}
function send( mid ){
	
	let content = $("#incontent").val();
	
	// json 형식으로 통신
	let msg = { // js 객체화  // 객체명 = {  속성명(key) : 값(value) , 속성명(key) : 값(value)   }
		from : mid , 		// 보내는사람 명 
		content : content, 		// 채팅내용
		img : "프로필1.jpg" ,		// 프로필
		date : new Date().toLocaleTimeString() // 채팅 보낸 시간
	}

	// json 통신할때 json모양의 문자열 변환
		// JSON -> 문자열  :  JSON.stringify
		// 문자열 -> JSON  :  JSON.parse( ) 
	
	websocket.send(  JSON.stringify(msg)  ); // json -> 문자열
	$("#incontent").val(""); // 전송후 입력창 초기화
	$("#incontent").focus();	// 전송후 포커스(커서)
	
}



















