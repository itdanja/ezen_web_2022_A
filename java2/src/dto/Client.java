package dto;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import controller.Server;

public class Client {
	// 서버에 접속된 클라이언트의 클래스 
	
	// 1. 필드 [ 소켓 ] 
	Socket socket;
	// 2.생성자 
	public Client( Socket socket ) {
		this.socket = socket;
	}
	// 3. 서버로 메시지 받는 메소드 
	public void recive() {
		// 멀티스레드 [ Thread 클래스 vs  Runnable 인터페이스 ] 	// run 메소드를 필수적으로 구현해야함.
		// 인터페이스는 추상메소드가 존재하기 때문에 구현필수[ 클래스에서 implements vs  익명 객체 ]
		Runnable runnable = new Runnable() {
			@Override
			public void run() { // 추상메소드 구현 
				// 계속적으로 메시지 받는 상태 
				try {
					while(true) {
						InputStream inputStream = socket.getInputStream(); // 1. 입력스트림 
						byte[] bytes = new byte[1000]; 	// 2. 바이트 배열 선언 [ 스트림은 바이트단위 이기 때문에 ]
						inputStream.read( bytes ); 		// 3. 입력스트림으로 바이트 읽어오기 
						String msg = new String(bytes);	// 4. 바이트열 -> 문자열 변환
						// * 서버가 받은 메시지를 현재 서버에 접속된 모든 클라이언트에게 받은 메시지 보내기
						for( Client client   : Server.clientlist ) {
							client.send( msg ); // 받은 메시지를 서버에 접속된[ clientlist ] 모든 클라이언트에게 메시지 보내기
						}
					}
				}catch( Exception e ) {}
			}
		}; // 멀티스레드 구현 끝 
		Server.threadpool.submit(runnable);  // 해당 멀티스레드를 스레드풀에 넣어주기 
	}
	// 4. 서버가 메시지 보내는 메소드 
	public void send( String msg ) { 
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					OutputStream outputStream = socket.getOutputStream(); 	// 1. 출력 스트림
					outputStream.write( msg.getBytes() ); 					// 2. 내보내기
				}catch( Exception e ) {}
			}
		}; // 멀티스레드  구현 끝 
		Server.threadpool.submit(runnable); // 해당 멀티스레드를 스레드풀에 넣어주기 
	}
	
	
}







