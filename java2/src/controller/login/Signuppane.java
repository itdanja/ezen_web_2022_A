package controller.login;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import dao.MemberDao;
import dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Signuppane implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnsignup;

    @FXML
    private Button btnback;

    @FXML
    private Label lblconfirm;

    @FXML
    private PasswordField txtpasswordconfirm;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtaddress;

    @FXML
    void back(ActionEvent event) {
    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
    	Login.instance.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void signup(ActionEvent event) {
    	// * 컨트롤에 입력된 데이터 가져오기 [ fxid명.gettext() ]
    	String id = txtid.getText();
    	String password = txtpassword.getText();
    	String passwordconfirm = txtpasswordconfirm.getText();
    	String email = txtemail.getText();
    	String address = txtaddress.getText();
    	// 현재날짜 가져오기 [ SimpleDateFormat : 날짜 모양(형식) 변환 클래스 ]
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String cine = format.format( new Date() ); // 현재날짜를 형식 변환
    	// * 유효성검사[ 제한 ] 
    		// 1. id 중복 체크 // 2. id 형식 체크 // 3. 비밀번호 형식 체크// 4. 비밀번호 일치 체크 // 5. 이메일 체크 // 6. 주소 체크 
    	// * 모든 유효성검사 통과시 DB에 저장 
    		// 1. 객체화	[ 회원번호없음=0 , id , password, email, address, 포인트없음=0 , cine ]
    		Member member = new Member(0, id, password, email, address, 0, cine);
    		// 2. DB 객체내 메소드 호출 
    		boolean result = MemberDao.memberDao.signup(member);
    		// 3. 확인 
    		if( result ) {
    			System.out.println("가입성공");
    		}else {
    			System.out.println("가입실패");
    		}
    		
    	
    	
    }

}


















