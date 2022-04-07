package controller.home;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import dao.BoardDao;
import dao.MemberDao;
import dto.Board;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Home implements Initializable {
				// fxml ����� �ʱⰪ ���� �������̽�
	
	public static Home home; // ��ü 
	
	// * this : ���� Ŭ������ �޸� ȣ��
	public Home() { home = this; }
	
	
	@FXML
	private Label lblloginid;
	@FXML
	private Label lblpoint;
	@FXML
	private Label lbllogout;
	@FXML
	private Label lbldelete; // fxid��������
	@FXML
	private Label lblinfo; // fxid��������
	@FXML
	private Label lblupdate; // fxid��������
	@FXML
	private Label lblboard; // fxid��������
	@FXML
	private Label lblproduct1; // fxid��������
	@FXML
	private Label lblproduct2; // fxid��������
	@FXML
	private Label lblproduct3; // fxid��������
	@FXML
	private Label lblproduct4; // fxid��������
	
	@FXML
	private BorderPane borderpane;
	
	public static String category;
	
	@FXML// �����Ƿ� ���̺��� Ŭ�������� �̺�Ʈ
	public void accproduct1( MouseEvent e ) { 
		loadpage("/view/product/product.fxml"); 
		category="�����Ƿ�";
	}
	@FXML// �����Ƿ� ���̺��� Ŭ�������� �̺�Ʈ
	public void accproduct2( MouseEvent e ) { 
		loadpage("/view/product/product.fxml"); 
		category="�����Ƿ�";
	}
	@FXML// ���ӱ�� ���̺��� Ŭ�������� �̺�Ʈ
	public void accproduct3( MouseEvent e ) { 
		loadpage("/view/product/product.fxml"); 
		category="���ӱ��";
	}
	@FXML// ��Ȱ��ǰ ���̺��� Ŭ�������� �̺�Ʈ
	public void accproduct4( MouseEvent e ) { 
		loadpage("/view/product/product.fxml"); 
		category="��Ȱ��ǰ";
	}
	
	@FXML// �����Խ� ���̺��� Ŭ�������� �̺�Ʈ
	public void accboard( MouseEvent e ) { loadpage("/view/board/board.fxml"); }
	
	@FXML// ȸ������ ���̺��� Ŭ�������� �̺�Ʈ
	public void accinfo( MouseEvent e ) { loadpage("/view/home/info.fxml"); }
	
	@FXML// ȸ������ ���̺��� Ŭ�������� �̺�Ʈ
	public void accupdate( MouseEvent e ) { loadpage("/view/home/update.fxml"); }
	
	
	public void loadpage( String page ) {
		try {
			Parent parent = FXMLLoader.load( getClass().getResource(page));
			borderpane.setCenter(parent);
		}catch( Exception e ) {}
	}
	
	@Override // ���� �ʱ� �޼ҵ� 
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadpage("/view/chatting.fxml");
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
	@FXML// ȸ��Ż�� ���̺��� Ŭ�������� �̺�Ʈ
	public void delete( MouseEvent e ) {
		
		// 1. �޽��� ���� 
		Alert alert = new Alert( AlertType.CONFIRMATION ); // Ȯ��,��� ��ư Ÿ�� 
			alert.setHeaderText("���� Ż�� �Ͻðڽ��ϱ�?");
		// 2. ��ư Ȯ�� [ Optional : Ŭ���� 
		Optional<ButtonType> optional = alert.showAndWait(); // ����
		if( optional.get() == ButtonType.OK ) { // Ȯ�� ��ư�� �������� 
			// ȸ��Ż�� ���� 
			boolean result= MemberDao.memberDao.delete( Login.member.getMnum() );
								// ���� �α������� ȸ���� ��ȣ ȣ��
			if( result ) { // Ż�� ���� 
				// �α׾ƿ� [ Login Ŭ������ Member ��ü null ���� ���� ] 
				Login.member = null;
				// ��������ȯ
				Main.instance.loadpage("/view/login/login.fxml");
			}else { // Ż�� ����
				
			}
		}
		// �ƴϸ� 
	}

	
}













