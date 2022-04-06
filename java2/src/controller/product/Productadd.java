package controller.product;

import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

public class Productadd implements Initializable {


    @FXML
    private Button btnadd;

    @FXML
    private TextField txtpname;

    @FXML
    private TextArea txtpcontent;

    @FXML
    private TextField txtpprice;

    @FXML
    private Button btnimg;

    @FXML
    private RadioButton opt1;

    @FXML
    private ToggleGroup category;

    @FXML
    private RadioButton opt2;

    @FXML
    private RadioButton opt3;

    @FXML
    private RadioButton opt4;

    @FXML
    private ImageView img;

    @FXML
    private Button btnback;

    @FXML
    private Label txtpath;

    @FXML
    void add(ActionEvent event) {
    	// 1. ��Ʈ�ѿ� �Էµ� ������ ��������
    	String pname = txtpname.getText();
    	String pcontent = txtpcontent.getText();
    	int pprice = Integer.parseInt( txtpprice.getText() ) ;	// ���ڿ� -> ������ ��ȯ [ Integer.parseInt ]
    		// * ī�װ�
    	String pcategory = null;
    		if( opt1.isSelected() ) { // ���࿡ opt1��� fxid�� ��Ʈ��(������ư)�� ���õǾ�����
    			pcategory="�����Ƿ�";
    		}
    		if( opt2.isSelected() ) { pcategory ="�����Ƿ�";}
    		if( opt3.isSelected() ) { pcategory ="���ӱ��";}
    		if( opt4.isSelected() ) { pcategory ="��Ȱ��ǰ";}
    	int mnum = Login.member.getMnum();
    	// 2. ��üȭ
    	Product product = new Product(0, pname, null, pcontent, pcategory, pprice, 1, null, mnum);
    	// 3. DBó��
    	boolean result =  ProductDao.productDao.add(product);
    	// 4. ���ó��
    	if( result ) {
    		
    	}else {
    		
    	}
    	
    }

    @FXML
    void back(ActionEvent event) {
    	Home.home.loadpage("/view/product/product.fxml");
    }

    @FXML
    void imgadd(ActionEvent event) {

    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
}








