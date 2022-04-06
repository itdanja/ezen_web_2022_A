package controller.product;

import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class Productcontrol implements Initializable {
						// 인터페이스=구현하다
    @FXML
    private Button btnadd;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private VBox vbox;

    @FXML
    void accadd(ActionEvent event) {
    	Home.home.loadpage("/view/product/productadd.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}












