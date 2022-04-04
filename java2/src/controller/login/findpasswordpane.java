package controller.login;

import java.net.URL;
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
import javafx.scene.control.TextField;

public class findpasswordpane implements Initializable {

    @FXML
    private TextField txtid;

    @FXML
    private Button btnfindpassword;

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
    void findpassword(ActionEvent event) {
    	// 1. ��Ʈ�ѿ� �Էµ� ������ ��������
    	String id = txtid.getText();
    	String email = txtemail.getText();
    	// 2. db �޼ҵ� ȣ�� 
    	String password = MemberDao.memberDao.findpassword(id, email);
    	// 3. Ȯ�� 
    	if( password != null ) {
    		
    		// �̸��� ���� �޼ҵ� ȣ��
    		Member.sendmail(email, password);
    		
    		// �޽��� 
    		Alert alert = new Alert( AlertType.INFORMATION );
    			alert.setHeaderText("�ش� �̸��Ϸ� ��й�ȣ�� �����߽��ϴ�.");
    		alert.showAndWait();
    	}else {
    		lblconfirm.setText("�Է��� ������ ������ ȸ���� �����ϴ�.");
    	}
    	
    	

    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	

}









