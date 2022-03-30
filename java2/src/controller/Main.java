package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable {
				// Initializable : view가 열렸을때 초기값 설정 메소드 제공
	
    @FXML
    private BorderPane boaderpane; // 씬빌더에서 만든 컨테이너 객체 
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(" Main 뷰가 실행( view <---> controller ) 되었습니다. ");
		// 1. 
		loadpage("/view/login");
	}
	
	public void loadpage( String page ) {
		try {
			// 페이지(fxml) 객체화 
			Parent parent = FXMLLoader.load( getClass().getResource(page+".fxml") ); // 무조건 예외처리
			boaderpane.setCenter(parent); // 컨테이너(fxml) 가운데에 페이지 넣기 
		}catch( Exception e ) { System.out.println("페이지 연결 실패");}
		
	}
	
}
