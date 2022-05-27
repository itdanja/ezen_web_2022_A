package controller.board;

import javax.servlet.annotation.WebServlet;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

// @WebServlet : URL 매핑
// @WebServlet(" HTTP 클래스내로 들어오는 경로 정의");
// @ServerEndpoint("서버소켓 클래스로 들어오는 경로 정의")
@ServerEndpoint("/chatting")
public class Chatting {	// 서버소켓 사용할 클래스 
	
	// 1. 소켓 오픈
	@OnOpen
	public void OnOpen( Session session ) {
		System.out.println(" 서버소켓에 유저가 들어왔습니다. : "+session.toString() );
	}
	// 2. 소켓 닫기 
	@OnClose
	public void OnClose() {
		
	}
	// 3. 소켓 메시지 보내기 
	@OnMessage
	public void OnMessage() {
		
	}
}







