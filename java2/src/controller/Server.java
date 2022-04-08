package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server{	// fxml 사용하지 않는 클래스 [ 서버 컨트롤 사용 ] 
	
	// 중첩 클래스  [ 클래스 안에 클래스가 선언되면 ] 
	public class Client { // 서버에 접속된 클라이언트의 클래스 
		public Socket socket; // 1. 필드 [ 소켓 ] 
		
		public Client( Socket socket ) { // 2.생성자 
			this.socket = socket;
			recive(); // 서버와 연결된 클라이언트 객체가 생성될때 받기 메소드(무한루프) 
		}
		
		// 3. 서버로 메시지 받는 메소드 [ 실행조건 : 서버와 클라이언트가 연결되었을때 ] 
		public void recive() {
			// 멀티스레드 [ Thread 클래스 vs  Runnable 인터페이스 ] 	// run 메소드를 필수적으로 구현해야함.
			// 인터페이스는 추상메소드가 존재하기 때문에 구현필수[ 클래스에서 implements vs  익명 객체 ]
			Runnable runnable = new Runnable() {
				@Override
				public void run() { // 추상메소드 구현 
					// 계속적으로 메시지 받는 상태 
				
					while(true) {
						try {
							InputStream inputStream = socket.getInputStream(); // 1. 입력스트림 
							byte[] bytes = new byte[1000]; 	// 2. 바이트 배열 선언 [ 스트림은 바이트단위 이기 때문에 ]
							inputStream.read( bytes ); 		// 3. 입력스트림으로 바이트 읽어오기 
							String msg = new String(bytes);	// 4. 바이트열 -> 문자열 변환
							// * 서버가 받은 메시지를 현재 서버에 접속된 모든 클라이언트에게 받은 메시지 보내기
							for( Client client   : clientlist ) {
								client.send( msg ); // 받은 메시지를 서버에 접속된[ clientlist ] 모든 클라이언트에게 메시지 보내기
							}
					
						}catch( Exception e ) { }
					}
				}
			}; // 멀티스레드 구현 끝 
			threadpool.submit(runnable);  // 해당 멀티스레드를 스레드풀에 넣어주기 
		}
		// 4. 서버가 메시지 보내는 메소드  [ 실행조건 : 서버가 메시지를 받았을때 ]
		public void send( String msg ) { 
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						OutputStream outputStream = socket.getOutputStream(); 	// 1. 출력 스트림
						outputStream.write( msg.getBytes() ); 					// 2. 내보내기
					}catch( Exception e ) { }
				}
			}; // 멀티스레드  구현 끝 
			threadpool.submit(runnable); // 해당 멀티스레드를 스레드풀에 넣어주기 
		}
	}
	
	// 중첩 클래스end 
	
    // * 서버에 연결된 클라이언트를 저장하는 리스트 
    	// static : 프로그램 시작되면 메모리 할당 / 프로그램 종료되면 메모리 초기화
    public Vector<Client> clientlist = new Vector<>();	
    		// Vector 사용하는이유 : 동기화 지원(o)    // 동기화 : 여러 스레드가 하나의 메소드접근할 경우 대기 상태 만들기
    // * 멀티스레드를 관리해주는 스레드풀 선언
    public ExecutorService threadpool ;
    	// ExecutorService : 스레드풀 구현 인터페이스 [ 구현클래스(implements) vs 직접구현(익명객체)
    
    // 1. 서버소켓 선언
    ServerSocket serverSocket;
    
    // 2. 서버실행 메소드 [ 인수로 ip 와 port 받아서 받은 ip와 port 로 서버소켓 바인딩(생성) ] 
    public void serverstart( String ip , int port) {  
    	try {
	    	serverSocket = new ServerSocket(); // 1. 서버소켓 메모리할당
	    	serverSocket.bind( new InetSocketAddress( ip , port ) ); 	// 2. 서버소켓 바인딩 [ ip 와 port 설정 ] 
    	}catch( Exception e ) { 
    		serverstop();
    		System.out.println("서버 생성 실패:"+e); }
    		// 3. 클라이언트의 요청 대기  [ 멀티스레드 사용하는이유 : 1.연결 2.보내기 3.받기 동시 처리 ] 
    	Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						Socket socket = serverSocket.accept(); // 1. 요청 수락후에 수락된 소켓을 저장
						clientlist.add( new Client(socket) ); // 2. 연결된 클라이언트( 연결된소켓 ) 생성후 에 리스트에 저장 
					}
				}catch( Exception e ) {  }
			}
		};// 멀티스레드 구현 끝
		threadpool = Executors.newCachedThreadPool(); 	// 스레드풀에 메모리 초기화[할당]
		threadpool.submit(runnable); 					// 위에서 구현된 멀티스레드를 스레드풀에 넣어주기 
    }
    // 3. 서버종료 메소드
    public void serverstop() { 
    	try {
	    	// 1. 접속된 모든 클라이언트들의 소켓 닫기 
	    	for( Client client :  clientlist) {
	    		client.socket.close();
	    	}
	    	// 2. 서버소켓 닫기
	    	serverSocket.close();
	    	// 3. 스레드풀 닫기
	    	threadpool.shutdown();
    	}catch( Exception e ) {}
    }
    
}








