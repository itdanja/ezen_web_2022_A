package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Record implements Initializable {
	
	@FXML
	private Label lblmtotal; // fxid ��üȭ
	@FXML
	private Label lblptotal; // fxid ��üȭ
	@FXML
	private Label lblbtotal; // fxid ��üȭ
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// ��ü ȸ���� 
		int mtotal = MemberDao.memberDao.counttotal("member");
		lblmtotal.setText( mtotal+" ��");
		// ��ü ��ǰ�� 
		int ptotal = MemberDao.memberDao.counttotal("product");
		lblptotal.setText( ptotal+" ��");
		// ��ü �Խù��� 
		int btotal = MemberDao.memberDao.counttotal("board");
		lblbtotal.setText( btotal+" ��");
		
	}
}









