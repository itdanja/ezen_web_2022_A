package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.login.Login;
import dao.RoomDao;
import dto.Room;
import dto.Roomlive;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Chatting implements Initializable {

    @FXML
    private Button btnconnect;

    @FXML
    private TextArea txtcontent;

    @FXML
    private TextField txtmsg;

    @FXML
    private Button btnsend;

    @FXML
    private TableView<Room> roomtable;

    @FXML
    private TextField txtroomname;

    @FXML
    private Button btnadd;

    @FXML
    private TextArea txtmidlist;

    @FXML
    private Label lblselect;
    
    public Server server ;    // 서버소켓 선언  [ 모든 메소드에서 사용 ] 
    public static Room selectroom;   // 테이블뷰에서 선택된 방 객체
    
    public void show() { // 사용되는 곳 [ initialize , add 메소드 ]
    	// 1. DB에서 모든 방 목록 가져오기
    	ObservableList<Room> roomlist = RoomDao.roomDao.roomlist();
    	// 2. 테이블뷰의 첫번째 필드를 가져와서 방번호 필드로 설정 
    	TableColumn tc = roomtable.getColumns().get(0);
    	tc.setCellValueFactory( new PropertyValueFactory<>("ronum"));
    	// 3. 테이블뷰의 두번째 필드를 가져와서 방이름 필드로 설정 
    	tc = roomtable.getColumns().get(1);
    	tc.setCellValueFactory( new PropertyValueFactory<>("roname"));
    	// 4. 테이블뷰의 세번째 필드를 가져와서 방인원 필드로 설정
    	tc = roomtable.getColumns().get(2);
    	tc.setCellValueFactory( new PropertyValueFactory<>("mcount"));
    	// 5. 테이블뷰에 리스트를 넣어주기 
    	roomtable.setItems( roomlist );
    	// 6. 해당 테이블뷰를 클릭했을때.
    	roomtable.setOnMouseClicked( e -> { 
    		// 7. 클릭된 객체(방) 가져와서 객체(방)에 저장
    		selectroom =  roomtable.getSelectionModel().getSelectedItem();
    		// 8. 레이블 표시 방 이름 표시 
    		lblselect.setText("현재 선택된 방 : "+selectroom.getRoname() );
    		// 9. 접속 버튼 사용 활성화
    		btnconnect.setDisable(false);
    	} );
    }
    
    @FXML
    void add(ActionEvent event) { // 방 개설 버튼을 눌렀을때
    	// 1. 컨트롤에 입력된 방 이름 가져오기
    	String roomname = txtroomname.getText();
    	if( roomname.length() < 4 ) { 
    		//만약에 방이름이 4글자 미만이면 방개설 실패
    		txtroomname.setText("");// 개설후 방이름 입력창 공백 처리
    		Alert alert = new Alert( AlertType.INFORMATION);
    		alert.setHeaderText("방 개설 실패[방 4글자이상 작성]");
    		alert.showAndWait();
    		return;
    	}
    	// 2. 방 객체
    	Room room = new Room( 0 , roomname, "127.0.0.1",0); 
    	// 3. db 처리
    	RoomDao.roomDao.roomadd(room);
    	// 4. 해당 방 서버 실행
    	server = new Server(); // 메모리할당
    		// **서버 실행 [ 인수로 ip 와 port=방번호 넘기기 ]
    	server.serverstart(  room.getRoip() ,  RoomDao.roomDao.getroomnum() ); 
    	
    	txtroomname.setText("");// 개설후 방이름 입력창 공백 처리
    	
    	show(); // 테이블 새로고침
    	
    	// 메시지 띄우기
    	Alert alert = new Alert( AlertType.INFORMATION);
    		alert.setHeaderText("방 개설이 되었습니다 방번호 : "
    						+ RoomDao.roomDao.getroomnum());
    		alert.showAndWait();
    }

    Socket socket;   // 1. 클라이언트 소켓 선언 
    
    // 2. 클라이언트 실행 메소드 // ip와 port번호를 인수로 받기
    public void clientstart( String ip , int port ) { 
    	Thread thread = new Thread() { // 멀티스레드 
    		@Override
    		public void run() {
    			try {
    				socket = new Socket( ip , port ); // 서버의 ip와 포트번호 넣어주기 [ 서버와 연결 ]
    				send( Login.member.getMid()+"님 입장했습니다\n"); // 접속과 동시에 입장메시지 보내기 
    				receive(); // 접속과 동시에 받기 메소드는 무한루프
    			}catch(Exception e ) { }
    		};
    	};// 멀티스레드 구현 끝
    	thread.start(); // 멀티스레드 실행
    }
    // 3. 클라이언트 종료 메소드 
    public void clientstop() {  try{ socket.close(); }catch(Exception e ) { } }
    
    // 4. 서버에게 메시지 보내기 메소드 
    public void send( String msg ) {
    	Thread thread = new Thread() { 
    		@Override
    		public void run() {
    			try {
    				OutputStream outputStream = socket.getOutputStream(); // 1. 출력 스트림
    				outputStream.write( msg.getBytes() ); // 2. 내보내기
    				outputStream.flush(); // 3. 스트림 초기화 [ 스트림 내 바이트 지우기 ]
    			}catch( Exception e ) { } 
    		}
    	};// 멀티스레드 구현 끝 
    	thread.start();
    }
    // 5. 서버에게 메시지 받기 메소드 
    public void receive() {
    	
    	while(true) {
    		try {
	    		InputStream inputStream = socket.getInputStream(); // 1. 입력 스트림
	    		byte[] bytes = new byte[1000]; 	// 2. 바이트배열 선언 
	    		inputStream.read(bytes);		// 3. 읽어오기 
	    		String msg = new String(bytes);	// 4. 바이트열 -> 문자열 변환
	    		txtcontent.appendText(msg); 	// 4. 받은 문자열을 메시지창에 띄우기 
    		}
	    	catch( Exception e ) { }
    	}
    }
    
    
    public void midshow() { // msg메소드:입력창에서 엔터 쳤을때 // send메소드 : 전송버튼 눌렀을때
    	// 1. 테이블뷰에서 선택된 방 번호의 접속된 회원명단 가져오기 
    	ArrayList<Roomlive> roomlivelist 
			= RoomDao.roomDao.getRoomlivelist( selectroom.getRonum() );
		txtmidlist.setText(""); // 2.명단 초기화
		int i = 1; 
		for( Roomlive temp : roomlivelist ) { // 3.리스트내 모든 객체를 하나씩 명단에 추가
			txtmidlist.appendText( i +"번 "+ temp.getMid() +"\n");
			i++;
		}
    }
    @FXML
    void msg(ActionEvent event) { // 입력창에서 입력후 엔터를 눌렀을때
    	String msg = Login.member.getMid()+" : "+ txtmsg.getText()+"\n";
    	send( msg );
    	txtmsg.setText("");
    	txtmsg.requestFocus();
    	midshow();
    }
    @FXML
    void send(ActionEvent event) { // 전송 버튼을 눌렀을때
    	String msg = Login.member.getMid()+" : "+ txtmsg.getText()+"\n"; // 보낼 메시지
    	send( msg ); // 메시지 보내기 
    	txtmsg.setText(""); 	// 보내기 후 메시지입력창 지우기
    	txtmsg.requestFocus();	// 보내기 후 메시지입력창으로 포커스(커서) 이동
    	midshow();
    }
    
    @FXML
    void connect(ActionEvent event) { // 접속 버튼을 눌렀을떄
    	
    	if( btnconnect.getText().equals("채팅방 입장") ) {// 만약에 버튼의 텍스트가 "채팅방 입장" 이면 
    		// 테이블뷰에서 선택된 방의 ip 와 port 를 클라이언트시작 메소드에 넣어주기
    		clientstart( selectroom.getRoip() , selectroom.getRonum() );
    		
    			// 현재 방 접속명단 추가  
    			Roomlive roomlive 
    				= new Roomlive( 0, 
    						selectroom.getRonum() , 
    						Login.member.getMid() );
    			// db처리
    			RoomDao.roomDao.addroomlive(roomlive);
    			
    		txtcontent.appendText("---[채팅방 입장]---\n");
    		btnconnect.setText("채팅방 나가기");
    		
    		txtmsg.setText("");				// 채팅입력창 빈칸으로 설정
    		txtmsg.setDisable(false); 		// 채팅입력창 사용가능 
        	txtcontent.setDisable(false); 	// 채팅창 목록 사용가능
        	btnsend.setDisable(false); 		// 전송버튼 사용가능
        	txtmsg.requestFocus();  		// 채팅입력창으로 포커스[커서] 이동
        	
        	txtroomname.setDisable(true); 	// 채팅방이름 입력창 사용금지
        	btnadd.setDisable(true); 		// 채팅 개설 버튼 사용금지
        	roomtable.setDisable(true);   	// 채팅방 목록 사용금지 
        	
    	}else {
    		
    		clientstop(); // 클라이언트 종료 메소드 
    		
    		txtcontent.appendText("---[채팅방 퇴장]---\n");
    		btnconnect.setText("채팅방 입장");
    		
    		txtmsg.setText("채팅방 입장후 사용가능");
        	txtmsg.setDisable(true); 		// 채팅입력창 사용금지 
        	txtcontent.setDisable(true); 	// 채팅창 목록 사용금지
        	btnsend.setDisable(true); 		// 전송버튼 사용금지
        	btnconnect.setDisable(true);
        	
        	txtroomname.setDisable(false); 	// 채팅방이름 사용
        	btnadd.setDisable(false);  		// 방개설 버트 사용 
        	roomtable.setDisable(false); 	// 채팅방 목록 사용
        	
        	// 1. 방 접속 명단에서 제외[삭제] 하기
        	RoomDao.roomDao.roomlivedelete( 
        			Login.member.getMid()    
        			);
        	// 2. 만약에 방 접속 명단이 0명이면 방삭제 
        		// 2-2. 만약에 방이 삭제되면서버소켓 종료
        	boolean result = RoomDao.roomDao.roomdelete(  
        			selectroom.getRonum()
        			);
        	System.out.println( result );
        	if( result ) { server.serverstop(); } 
        	
        	// * 테이블뷰에서 선택된 방객체 초기화
        	selectroom = null;
        	// * 선택된 방 레이블 초기화
        	lblselect.setText("현재 선택된 방 : ");
        	
        	show(); // 방목록 테이블 새로고침
        	
        	// 방 나갈때 서버소켓내 접속된 소켓 리스트에서 소켓 제거 
        	
    	}
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	// 채팅fxml 열렸을때 초기값 메소드  	// * 채팅방 입장전에 아래 fxid를 사용못하게 금지 
    	txtmsg.setText("채팅방 입장후 사용가능");
    	txtmsg.setDisable(true); 		// 채팅입력창 사용금지 
    	txtcontent.setDisable(true); 	// 채팅창 목록 사용금지
    	btnsend.setDisable(true); 		// 전송버튼 사용금지
    	btnconnect.setDisable(true); 	// 입장버튼 사용금지
    	txtmidlist.setDisable(true);  	// 방접속회원 목록 사용금지 
    
    	Thread thread = new Thread() { // 채팅방 목록 실시간 화면 처리
			@Override
			public void run() {
				while( true ) { 
					try {
						show();
						Thread.sleep(1000);
					}catch( Exception e ) {} 
				}
			}
		}; 
		thread.start();
    }
}


















