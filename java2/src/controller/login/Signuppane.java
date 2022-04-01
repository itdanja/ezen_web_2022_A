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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Signuppane implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText(""); // ó�� ����� ���� ���ֱ�
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
    	String since = format.format( new Date() ); // ���糯¥�� ���� ��ȯ
    	// * ��ȿ���˻�[ ���� ] 
    		// 1. id �ߺ� üũ 
    		boolean result2 = MemberDao.memberDao.idcheck(id);
    		if( result2 ) {
    			lblconfirm.setText(" [ ���� ] ������� ���̵��Դϴ�. ");
    			return; // ���� ���ϰ� [ �޼ҵ� ���� ]
    		}
    		// 2. id ���� üũ  [ ���̰� 4~10 ���� ]
    		if( id.length() < 4 || id.length() >10 ) {
    			lblconfirm.setText(" [ ���� ] ���̵� 4~10 ���̷� �Է����ּ���!");
    			return; // ���� ���ϰ� [ �޼ҵ� ���� ]
    		}
    		// 3. ��й�ȣ ���� üũ [ ���ڿ�.length() : ���ڿ����� ]  [ ���̰� 4~10 ���� ]
    		if( password.length() < 4 || password.length() > 10 
    				|| passwordconfirm.length() < 4 || passwordconfirm.length() > 10 ) {
    			lblconfirm.setText(" [ ���� ] �н������ 4~10 ���̷� �Է����ּ���!");
    			return; // ���� ���ϰ� [ �޼ҵ� ���� ]
    		}
    		// 4. ��й�ȣ ��ġ üũ 
    		if( ! password.equals(passwordconfirm)  ) { // �н������ �н�����˻� ��ġ���� ������ [ ! : ���� (�ݴ�) ] 
    			lblconfirm.setText(" [ ���� ] ��й�ȣ�� ��ġ���� �ʽ��ϴ�. ");
    			return; // ���� ���ϰ� [ �޼ҵ� ���� ]
    		}
    	// 5. �̸��� üũ [ ���ڿ�.indexOf("����") : �ش� ���ڿ��� ���ڰ� �����ϸ� �ش� ������ �ε��� ȣ�� / ���� ������ -1
    		if( email.indexOf("@") == -1 ) { // ���࿡ �Է��� �̸��Ͽ� @ �� ������
    			lblconfirm.setText(" [ ���� ] �̸��� ����[@����]���� �Է����ּ���. ");
    			return; // ���� ���ϰ� [ �޼ҵ� ���� ]
    		}
    	// 6. �ּ� üũ [ ���ڿ�.contains("����") : �ش� ���ڿ��� ���ڰ� �����ϸ� true / ������ false ] 
    		if( !( address.contains("��") && address.contains("��") && address.contains("��") ) ) {
    			lblconfirm.setText(" [ ���� ] �ּ� ����[��,��,�� ����]���� �Է����ּ��� ");
    			return; // ���� ���ϰ� [ �޼ҵ� ���� ]
    		}
    		// * ��� ��ȿ���˻� ����� DB�� ���� 
    		// 1. ��üȭ	[ ȸ����ȣ����=0 , id , password, email, address, ����Ʈ����=0 , since ]
    		Member member = new Member(0, id, password, email, address, 0, since);
    		// 2. DB ��ü�� �޼ҵ� ȣ�� 
    		boolean result = MemberDao.memberDao.signup(member);
    		// 3. Ȯ�� 
    		if( result ) {
    			// 1. �޽���â ��� [ Alert : �޽���(�˶�) Ŭ���� ]  
	    			Alert alert = new Alert( AlertType.INFORMATION ); // �޽��� ��ü
	    			alert.setTitle("�˸�"); // �޽��� ���� ����
	    			alert.setHeaderText("�Ȼ�� �߰�ŷ��� ������ �����մϴ�.");
	    			alert.setContentText("ȸ������ ����");
	    			alert.showAndWait(); // �޽��� ����;
    			// 2. ȭ�� ��ȯ [ �α��������� ��ȯ ]
	    			Login.instance.loadpage("/view/login/loginpane.fxml");
    		}else {
    			lblconfirm.setText(" [ ���� ] DB����[ �����ڿ��� ����] ");
    			return; // ���� ���ϰ� [ �޼ҵ� ���� ]
    		}
    }
}


















