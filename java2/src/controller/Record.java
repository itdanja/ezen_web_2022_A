package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Record implements Initializable {
	
	@FXML
	private Label lblmtotal; // fxid 객체화
	@FXML
	private Label lblptotal; // fxid 객체화
	@FXML
	private Label lblbtotal; // fxid 객체화
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 전체 회원수 
		int mtotal = MemberDao.memberDao.counttotal("member");
		lblmtotal.setText( mtotal+" 명");
		// 전체 제품수 
		int ptotal = MemberDao.memberDao.counttotal("product");
		lblptotal.setText( ptotal+" 개");
		// 전체 게시물수 
		int btotal = MemberDao.memberDao.counttotal("board");
		lblbtotal.setText( btotal+" 개");
		
	}
}









