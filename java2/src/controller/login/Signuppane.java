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
    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
    	Login.instance.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void signup(ActionEvent event) {
    	// * ��Ʈ�ѿ� �Էµ� ������ �������� [ fxid��.gettext() ]
    	String id = txtid.getText();
    	String password = txtpassword.getText();
    	String passwordconfirm = txtpasswordconfirm.getText();
    	String email = txtemail.getText();
    	String address = txtaddress.getText();
    	// ���糯¥ �������� [ SimpleDateFormat : ��¥ ���(����) ��ȯ Ŭ���� ]
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String cine = format.format( new Date() ); // ���糯¥�� ���� ��ȯ
    	// * ��ȿ���˻�[ ���� ] 
    		// 1. id �ߺ� üũ // 2. id ���� üũ // 3. ��й�ȣ ���� üũ// 4. ��й�ȣ ��ġ üũ // 5. �̸��� üũ // 6. �ּ� üũ 
    	// * ��� ��ȿ���˻� ����� DB�� ���� 
    		// 1. ��üȭ	[ ȸ����ȣ����=0 , id , password, email, address, ����Ʈ����=0 , cine ]
    		Member member = new Member(0, id, password, email, address, 0, cine);
    		// 2. DB ��ü�� �޼ҵ� ȣ�� 
    		boolean result = MemberDao.memberDao.signup(member);
    		// 3. Ȯ�� 
    		if( result ) {
    			System.out.println("���Լ���");
    		}else {
    			System.out.println("���Խ���");
    		}
    		
    	
    	
    }

}


















