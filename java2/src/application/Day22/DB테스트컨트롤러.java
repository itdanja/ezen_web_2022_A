package application.Day22;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DB�׽�Ʈ��Ʈ�ѷ� implements Initializable {
							// Initializable : fxml�� ���� �������� �ʱⰪ[ó����] ���� �޼ҵ� ���� 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { // �ʱⰪ[ó����] ���� �޼ҵ�
		Day22_2 DB���� = new Day22_2(); // �����ڿ� db���� �ڵ带 �־��⶧���� ��ü ����� �������� 
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
    	System.out.println("DB�� �����͸� ȣ���մϴ�.");
    }

    @FXML
    void write(ActionEvent event) {
    	System.out.println("DB�� �����͸� �����մϴ�.");
    }


}
