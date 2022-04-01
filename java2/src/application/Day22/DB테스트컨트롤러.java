package application.Day22;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DB테스트컨트롤러 implements Initializable {
							// Initializable : fxml이 새로 열렸을때 초기값[처음값] 설정 메소드 제공 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { // 초기값[처음값] 설정 메소드
		Day22_2 DB연동 = new Day22_2(); // 생성자에 db연동 코드를 넣었기때문에 객체 선언시 연동실행 
	}
	
    @FXML
    private TextField txtwriter;

    @FXML
    private TextField txtcontent;

    @FXML
    private Button btnget;

    @FXML
    private Button btnwrite;

    @FXML
    private TextArea txtcontentlist;

    @FXML
    void get(ActionEvent event) {
    	System.out.println("DB내 데이터를 호출합니다.");
    }

    @FXML
    void write(ActionEvent event) {
    	System.out.println("DB내 데이터를 저장합니다.");
    }


}
