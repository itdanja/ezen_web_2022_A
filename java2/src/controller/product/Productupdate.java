package controller.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class Productupdate implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Product product = Productcontrol.select;
		txtpname.setText( product.getPname() );
		txtpcontent.setText( product.getPcontent() );
		txtpprice.setText( product.getPprice()+"" );
		txtpath.setText( product.getPimg() );
		if( product.getPcategory().equals("�����Ƿ�") ) { opt1.setSelected(true);}
		if( product.getPcategory().equals("�����Ƿ�") ) { opt2.setSelected(true);}
		if( product.getPcategory().equals("���ӱ��") ) { opt3.setSelected(true);}
		if( product.getPcategory().equals("��Ȱ��ǰ") ) { opt4.setSelected(true);}
	}
	
    @FXML
    private Button btnupdate;

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
    void back(ActionEvent event) {
    	Home.home.loadpage("/view/product/productview.fxml");
    }
    
    private String pimage = null;
    
    @FXML
    void imgadd(ActionEvent event) {
    	// 1. ���� ���� Ŭ���� 
    	FileChooser fileChooser = new FileChooser();
    	// 2. *���� ����[����] ���� 
    		fileChooser.getExtensionFilters().add( 
    				new ExtensionFilter("�̹�������:image file" , "*png" , "*jpeg" , "*jpg","*gif") );
    	// 3. ���ο� stage���� ���ϼ��� ȭ�� ���� 
    	File file = fileChooser.showOpenDialog( new Stage() );
    		// ���ϼ��ð�ü.showOpenDialog( �������� ) ;
    		// fileChooser ȭ�鿡�� ���õ� ������ file Ŭ������üȭ
    	// 4. ������ ������ ��� ǥ��
    	txtpath.setText("���� ��� : " + file.getPath() ); // ��� ���м� : \
    	// 5. ���ϰ�� 
    	pimage = file.toURI().toString(); // ��� ���м� : /
    	// 6. �̸����� �̹�����Ʈ�ѿ� ����
    	Image image = new Image( pimage ); // �ش� �̹����� ��� ���� ��  / ���� �Ǿ� �־���� 
    	img.setImage(image); // ImageView �� �ش� �̹��� �־��ֱ�
    	
    	// * ������ ������ ���� ������Ʈ ������ ����(�̵�) �ؿ���
    	try {
    	// 1. ���� �Է� ��Ʈ��[ �̵� ���� : ����Ʈ ]
    		FileInputStream inputStream = new FileInputStream(file); // file : fileChooser���� ���õ� ���� ��ü
    	// 2. ���� ��� ��Ʈ��
    		// 1. ���ο� ��� ����
    		File copyfile = new File("C:/Users/MSI/git/ezen_web_2022_A/java2/src/img/" +file.getName() );
    		FileOutputStream outputStream = new FileOutputStream( copyfile );
    	// 3. ����Ʈ �迭 ���� 
    		byte[] bytes = new byte[1024*1024*1024]; // 1����Ʈ -> 1024����Ʈ -> 1Ű�ι���Ʈ -> 1024Ű�ι���Ʈ-> 1�ް�����Ʈ
    	// 4. �ݺ����� �̿��� inputStream�� ���� ��Ʈ�� ��� �о���� 
    		int size;
    		while(  ( size = inputStream.read( bytes ) ) > 0 ) { // �о�� ����Ʈ�� 0���� ������ �ݺ��� ���� [ �о�� ����Ʈ�� ���������� �ݺ� ]
    			outputStream.write(bytes , 0 , size ); // �о�� ����Ʈ��ŭ ��������
    		}
    	// 5. �뷮 ū ��쿡�� ��Ʈ�� ���� �ʼ�!!!
    		inputStream.close();
    		outputStream.close();
    	// * ����� ������ ��θ� db ����
    		pimage = copyfile.toURI().toString();
    	}catch (Exception e) {System.out.println(e);}
    }

    @FXML
    void update(ActionEvent event) {
    	 // ���� ������ ������ ���� ���� ��� ���
    	if( pimage == null ) pimage = Productcontrol.select.getPimg();
    	
    	String pcategory = null; 
    	if( opt1.isSelected() ) pcategory="�����Ƿ�";
    	if( opt2.isSelected() ) pcategory="�����Ƿ�";
    	if( opt3.isSelected() ) pcategory="���ӱ��";
    	if( opt4.isSelected() ) pcategory="��Ȱ��ǰ";
    	
    	Product upproduct = new Product(
    			Productcontrol.select.getPnum() ,
    			txtpname.getText() ,
    			pimage ,
    			txtpcontent.getText() , 
    			pcategory , 
    			Integer.parseInt( txtpprice.getText() ) , 
    			0,
    			null,
    			0) ;
    	
    	boolean result = ProductDao.productDao.update(upproduct);
    	if( result ) {
    		Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(" ��ǰ ���� ����");
			alert.showAndWait();
    		Home.home.loadpage("/view/product/product.fxml");
    	}else {
    		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setHeaderText(" ��ǰ ���� ���� [�����ڿ��Թ���]");
    		alert.showAndWait();
    	}
    }


}






























