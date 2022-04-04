package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.login.Login;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Info implements Initializable {
	
	@FXML
	private Label lblid;
	@FXML
	private Label lblemail;
	@FXML
	private Label lbladdress;
	@FXML
	private Label lblpoint;
	@FXML
	private Label lblsince;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblid.setText( Login.member.getMid() );
		lblemail.setText( Login.member.getMemail() );
		lbladdress.setText( Login.member.getMaddress() );
		lblpoint.setText( Login.member.getMpoint()+" Á¡" );
		lblsince.setText( Login.member.getMsince() );
	}
	
}
