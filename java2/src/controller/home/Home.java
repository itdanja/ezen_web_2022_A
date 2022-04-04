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
				// fxml ����� �ʱⰪ ���� �������̽� 
	
	@FXML
	private Label lblloginid;
	@FXML
	private Label lblpoint;
	@FXML
	private Label lbllogout;
	
	@Override // ���� �ʱ� �޼ҵ� 
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginid.setText( Login.member.getMid()+" ��" );
		lblpoint.setText("����Ʈ : "+ Login.member.getMpoint()+" ��");
	}
	
	@FXML // �α׾ƿ� ���̺� Ŭ�������� �̺�Ʈ
	public void logout( MouseEvent e  ) {
		// 1. Login ���� �����
		Login.member = null;
		// 2. ������ ��ȯ
		Main.instance.loadpage("/view/login/login.fxml");
	}
}
