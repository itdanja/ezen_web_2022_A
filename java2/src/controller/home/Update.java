package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Update implements Initializable {
	
	@FXML
	private TextField txtemail;
	@FXML
	private TextField txtaddress;
	@FXML
	private Button btnupdate;
	
	@FXML // 버튼클릭 -> ActionEvent  // 레이블클릭 -> MouseEvent
	public void update( ActionEvent e ) {
		// 1. 컨트롤러 입력한 데이터 가져오기
		String email = txtemail.getText();
		String address = txtaddress.getText();
		// 2. 업데이트처리[ 회원번호 = Login.member
		boolean result = MemberDao.memberDao.update( Login.member.getMnum() , email, address);
		if( result ) {
			Alert alert = new Alert( AlertType.INFORMATION ); // 메시지 출력
				alert.setHeaderText("회원정보가 수정되었습니다 [ 다시 로그인해주세요 ] ");
			alert.showAndWait();	
			Main.instance.loadpage("/view/login/login.fxml"); // 페이지 전환
			Login.member = null; // 로그인정보 null
		}else {
			Alert alert = new Alert( AlertType.INFORMATION ); // 메시지 출력
				alert.setHeaderText("회원정보가 수정 실패 [ 관리자에게 문의 ]");
			alert.showAndWait();
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtemail.setText( Login.member.getMemail() );
		txtaddress.setText( Login.member.getMaddress() );
	}

}






