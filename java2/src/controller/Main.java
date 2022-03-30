package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable {
				// Initializable : view�� �������� �ʱⰪ ���� �޼ҵ� ����
	
    @FXML
    private BorderPane boaderpane; // ���������� ���� �����̳� ��ü 
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(" Main �䰡 ����( view <---> controller ) �Ǿ����ϴ�. ");
		// 1. 
		loadpage("/view/login");
	}
	
	public void loadpage( String page ) {
		try {
			// ������(fxml) ��üȭ 
			Parent parent = FXMLLoader.load( getClass().getResource(page+".fxml") ); // ������ ����ó��
			boaderpane.setCenter(parent); // �����̳�(fxml) ����� ������ �ֱ� 
		}catch( Exception e ) { System.out.println("������ ���� ����");}
		
	}
	
}
