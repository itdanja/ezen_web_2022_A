package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Home implements Initializable {
				// fxml 실행시 초기값 설정 인테페이스 
	
	@FXML
	private Label lblloginid;
	@FXML
	private Label lblpoint;
	@FXML
	private Label lbllogout;
	
	@Override // 실행 초기 메소드 
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginid.setText( Login.member.getMid()+" 님" );
		lblpoint.setText("포인트 : "+ Login.member.getMpoint()+" 점");
	}
	
	@FXML // 로그아웃 레이블를 클릭했을때 이벤트
	public void logout( MouseEvent e  ) {
		// 1. Login 정보 지우기
		Login.member = null;
		// 2. 페이지 전환
		Main.instance.loadpage("/view/login/login.fxml");
	}
}
