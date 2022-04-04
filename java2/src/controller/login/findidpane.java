package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class findidpane implements Initializable {
	
    @FXML
    private Button btnfindid;

    @FXML
    private Button btnback;

    @FXML
    private Label lblconfirm;

    @FXML
    private TextField txtemail;

    @FXML
    void back(ActionEvent event) {
    	Login.instance.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void findid(ActionEvent event) { // 아이디찾기 버튼 눌렀을때 
    	// 1. 컨트롤에 입력된 이메일 가져오기 
    	String email = txtemail.getText();
    	// 2. DB 연동 객체에서 아이찾기 메소드 실행
    	String id = MemberDao.memberDao.findid(email);
    	// 3. 확인
    	if( id != null ) { // id가 존재하면 db에서 아이디찾기 성공 
    		// 1. 메시지 [ 알람 ] 
    		Alert alert = new Alert( AlertType.INFORMATION ); // 메시지 객체 선언 
    			alert.setHeaderText("회원님의 아이디는 : "+id);
    		alert.showAndWait(); // 실행 
    		
    	}else { // null 이면 db 오류 혹은 찾은 아이디가 없다.
    		lblconfirm.setText("입력한 정보와 동일한 회원이 없습니다.");
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
	
	
}










