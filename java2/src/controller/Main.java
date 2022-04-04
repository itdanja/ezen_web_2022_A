package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable {
				// Initializable : �ش� fxml�� �������� �ʱⰪ �޼ҵ� ���� 
	public static Main instance;
	public Main() {
		instance = this;
	}
	
	@FXML
    private BorderPane borderpane; // fx:id 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { // �ش� fxml�� �������� �ʱⰪ ����
		loadpage("/view/login/login.fxml");	// loadpage �޼ҵ� ȣ��� ( ���ϰ�� )
	}
	
	public void loadpage( String page ) { // loadpage( ���ϰ�� ) 
		try { // ����ó�� 
			Parent parent = FXMLLoader.load( getClass().getResource(page)); // �ش� ���� �ҷ����� 
			borderpane.setCenter(parent); // main.fxml�� �����ϴ� borderpane��ü�� center�� �ش� ���Ϸ� ���� 
		}catch( Exception e ) { System.out.println("������ �ҷ����� ���� ����: "+ e);} // ���࿡ ������ �������� ������ ���� �߻� 
		
	}
	
}
