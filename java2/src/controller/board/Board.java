package controller.board;

import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class Board implements Initializable {
	
    @FXML
    private TableView<?> boardtable;

    @FXML
    private Button btnwrite;

    @FXML
    void accwrite(ActionEvent event) {
    	// * Home클래스내 borderpane center 변경
    	Home.home.loadpage("/view/board/boardwrite.fxml");
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    }

}
