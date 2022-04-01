package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Loginpane implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText(""); // ó�� ����� ���� �����
	}
	
    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnlogin;

    @FXML
    private Button btnsignup;

    @FXML
    private Button btnfindid;

    @FXML
    private Button btnfindpassword;

    @FXML
    private Label lblconfirm;

    @FXML
    void accfindid(ActionEvent event) {
    	System.out.println(" ���̵�ã�� �������� �̵� ");
    }

    @FXML
    void accfindpassword(ActionEvent event) {
    	System.out.println(" �н�����ã�� �������� �̵� ");
    }

    @FXML
    void accsignup(ActionEvent event) {
    	// *ȸ������ ��ư�� ������ login��Ʈ��Ŭ���� �� borderpane �����̳� center ������ ����
    	// ���� : �ٸ� Ŭ������ �����̳� ȣ�� 
//    		Login login = new Login(); // ���ο� �����̳� ���� [ x ]
//    		login.loadpage("/view/signuppane.fxml"); // [ x ]
    	// �ذ��� : ���� �����̳� �������� ��� !!!! -> this
    	Login.instance.loadpage("/view/login/signuppane.fxml");
    }

    @FXML
    void login(ActionEvent event) {
    	//1. ��Ʈ��[fxid]�� �Էµ� �� ��������
    	String id = txtid.getText();
    	String password = txtpassword.getText();
    	//2. db��ü�� �޼ҵ� ȣ�� 
    	boolean result = MemberDao.memberDao.login(id, password);
    	//3. ��� Ȯ�� 
    	if( result ) {
    		// ������ ��ȯ [ �����ð� ] 
    		// * �׽�Ʈ 
    		lblconfirm.setText("�α��μ���");
    	}else {
    		lblconfirm.setText("������ ȸ�������� �����ϴ�.");
    	}
    	
    }
	
	
}



























