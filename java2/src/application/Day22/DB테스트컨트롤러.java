package application.Day22;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DB�׽�Ʈ��Ʈ�ѷ� {
	
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
    	System.out.println("DB�� �����͸� ȣ���մϴ�.");
    }

    @FXML
    void write(ActionEvent event) {
    	System.out.println("DB�� �����͸� �����մϴ�.");
    }


}
