package controller;

import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;

import dto.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Server implements Initializable {
    @FXML
    private Button btnserver;
    @FXML
    private TextArea txtserver;
    // * 서버에 연결된 클라이언트를 저장하는 리스트 
    public static Vector<Client> clientlist = new Vector<>();	
    		// Vector 사용하는이유 : 동기화 지원(o)    // 동기화 : 여러 스레드가 하나의 메소드접근할 경우 대기 상태 만들기
    // * 멀티스레드를 관리해주는 스레드풀
    public static ExecutorService threadpool;
    	// ExecutorService : 스레드풀 구현 인터페이스 
    
    // 1. 서버소켓 선언
    ServerSocket serverSocket;
    // 2. 서버실행 메소드
    public void serverstart() { }
    // 3. 서버종료 메소드
    public void serverstop() { }
    
    @FXML
    void server(ActionEvent event) { // 서버 실행 버튼
    	if( btnserver.getText().equals("서버 실행") ) { // 만약에 버튼의 텍스트가 "서버 실행" 이면
    		txtserver.appendText("[[ 서버 실행합니다.]]\n"); // 텍스트목록에 내용추가
    		btnserver.setText("서버 중지"); // 버튼의 텍스트 변경
    	}else { // 버튼의 텍스트가 "서버 중지" 이면
    		txtserver.appendText("[[ 서버 중지합니다.]]\n");
    		btnserver.setText("서버 실행");
    	}
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	txtserver.setDisable(true); // 해당 fxid 사용금지
    }

}








