package controller.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

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
    	Product product = new Product(0, pname, pimage, pcontent, pcategory, pprice, 1, null, mnum);
    	// 3. DBó��
    	boolean result =  ProductDao.productDao.add(product);
    	if( result ) {
    		Alert alert = new Alert(AlertType.INFORMATION ); // �޽��� 
    			alert.setHeaderText("��ǰ ��� �Ϸ�");
    		alert.showAndWait();	
    		Home.home.loadpage("/view/product/product.fxml"); // ȭ����ȭ
    		
    	}else {
    		Alert alert = new Alert(AlertType.INFORMATION );
				alert.setHeaderText("��ǰ ��� ���� [ �����ڿ��� ����]");
			alert.showAndWait();
    	}
    }
    private String pimage = null; // �޼ҵ� �ۿ��� �����ϴ� ����  : imgadd�޼ҵ�� add �޼ҵ� ���� ����ϱ� ����
    
    @FXML
    void imgadd(ActionEvent event) { // �̹������ ��ư Ŭ��������
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
    void back(ActionEvent event) {
    	Home.home.loadpage("/view/product/product.fxml");
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
}












