package application.Day22;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DB테스트컨트롤러 {
	
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
