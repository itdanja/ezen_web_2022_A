package controller.product;

import java.net.URL;
import java.util.ResourceBundle;

import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Productview implements Initializable {
	

    @FXML
    private Button btnback;

    @FXML
    private ImageView img;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btndelete;

    @FXML
    private TextField txtpname;

    @FXML
    private TextArea txtpcontent;

    @FXML
    private Label txtpprice;

    @FXML
    private Label txtpactivation;

    @FXML
    private Label txtpdate;

    @FXML
    private Label txtmid;

    @FXML
    void back(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		// 1. ��Ͽ��� ���õ� ��ǰ�� ��ü�� ȣ�� 
		Product product = Productcontrol.select;
		// 2. �� ��Ʈ�ѿ� �� �ֱ� 
		img.setImage( new Image( product.getPimg() ));
		txtpname.setText( product.getPname() );
		txtpcontent.setText( product.getPcontent() );
		txtpprice.setText( "���� : "+product.getPprice() );
		
	}
	

}































