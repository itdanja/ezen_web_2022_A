package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import controller.login.Login;
import dao.RoomDao;
import dto.Room;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Chatting implements Initializable {

    @FXML
    private Button btnconnect;

    @FXML
    private TextArea txtcontent;

    @FXML
    private TextField txtmsg;

    @FXML
    private Button btnsend;

    @FXML
    private TableView<Room> roomtable;

    @FXML
    private TextField txtroomname;

    @FXML
    private Button btnadd;

    @FXML
    private TextArea txtmidlist;

    @FXML
    private Label lblselect;
    
  
    public Server server ;    // �������� ����  [ ��� �޼ҵ忡�� ��� ] 
    public Room selectroom;   // ���̺�信�� ���õ� �水ü
    
    public void show() {
    	// 1. DB���� ��� �� ��� ��������
    	ObservableList<Room> roomlist = RoomDao.roomDao.roomlist();
    	// 2. ���̺���� ù��° �ʵ带 �����ͼ� ���ȣ �ʵ�� ���� 
    	TableColumn tc = roomtable.getColumns().get(0);
    	tc.setCellValueFactory( new PropertyValueFactory<>("ronum"));
    	// 3. ���̺���� �ι�° �ʵ带 �����ͼ� ���̸� �ʵ�� ���� 
    	tc = roomtable.getColumns().get(1);
    	tc.setCellValueFactory( new PropertyValueFactory<>("roname"));
    	// 4. ���̺���� ����° �ʵ带 �����ͼ� ���ο� �ʵ�� ����
    	tc = roomtable.getColumns().get(2);
    	tc.setCellValueFactory( new PropertyValueFactory<>("mcount"));
    	// 5. ���̺�信 ����Ʈ�� �־��ֱ� 
    	roomtable.setItems( roomlist );
    	// 6. �ش� ���̺�並 Ŭ��������.
    	roomtable.setOnMouseClicked( e -> { 
    		// 7. Ŭ���� ��ü �����ͼ� ��ü�� ����
    		selectroom =  roomtable.getSelectionModel().getSelectedItem();
    		// 8. ���̺� ǥ�� �� �̸� ǥ�� 
    		lblselect.setText("���� ���õ� �� : "+selectroom.getRoname() );
    		// 9. ���� ��ư ��� Ȱ��ȭ
    		btnconnect.setDisable(false);
    	} );
    	
    	
    }
    
    @FXML
    void add(ActionEvent event) { // �� ���� ��ư�� ��������
    	// 1. ��Ʈ�ѿ� �Էµ� �� �̸� ��������
    	String roomname = txtroomname.getText();
    	if( roomname.length() < 4 ) { 
    		//���࿡ ���̸��� 4���� �̸��̸� �氳�� ����
    		txtroomname.setText("");// ������ ���̸� �Է�â ���� ó��
    		Alert alert = new Alert( AlertType.INFORMATION);
    		alert.setHeaderText("�� ���� ����[�� 4�����̻� �ۼ�]");
    		alert.showAndWait();
    		return;
    	}
    	// 2. �� ��ü
    	Room room = new Room( 0 , roomname, "127.0.0.1",0); 
    	// 3. db ó��
    	RoomDao.roomDao.roomadd(room);
    	// 4. �ش� �� ���� ����
    	server = new Server(); // �޸��Ҵ�
    	// ���� ���� [ �μ��� ip �� port �ѱ�� ]
    	server.serverstart( 
    			room.getRoip() , 
    			RoomDao.roomDao.getroomnum() 
    			); 
    	
    	txtroomname.setText("");// ������ ���̸� �Է�â ���� ó��
    	show();
    	
    	Alert alert = new Alert( AlertType.INFORMATION);
    		alert.setHeaderText("�� ������ �Ǿ����ϴ� ���ȣ : "
    						+ RoomDao.roomDao.getroomnum());
    		alert.showAndWait();
    		
    }

    @FXML
    void msg(ActionEvent event) {

    }
    
    Socket socket;   // 1. Ŭ���̾�Ʈ ���� ���� 
    
    // 2. Ŭ���̾�Ʈ ���� �޼ҵ�
    public void clientstart() {
    	Thread thread = new Thread() { // ��Ƽ������ 
    		@Override
    		public void run() {
    			try {
    				socket = new Socket("127.0.0.1",1234); // ������ ip�� ��Ʈ��ȣ �־��ֱ� [ ������ ���� ]
    				send( Login.member.getMid()+"�� �����߽��ϴ�\n"); // ���Ӱ� ���ÿ� ����޽��� ������ 
    				receive(); // ���Ӱ� ���ÿ� �ޱ� �޼ҵ�� ���ѷ���
    			}catch(Exception e ) {}
    		};
    	};// ��Ƽ������ ���� ��
    	thread.start(); // ��Ƽ������ ����
    }
    // 3. Ŭ���̾�Ʈ ���� �޼ҵ� 
    public void clientstop() {  try{ socket.close(); }catch(Exception e ) {} }
    
    // 4. �������� �޽��� ������ �޼ҵ� 
    public void send( String msg ) {
    	Thread thread = new Thread() { 
    		@Override
    		public void run() {
    			try {
    				OutputStream outputStream = socket.getOutputStream(); // 1. ��� ��Ʈ��
    				outputStream.write( msg.getBytes() ); // 2. ��������
    				outputStream.flush(); // 3. ��Ʈ�� �ʱ�ȭ [ ��Ʈ�� �� ����Ʈ ����� ]
    			}catch( Exception e ) {} 
    		}
    	};// ��Ƽ������ ���� �� 
    	thread.start();
    }
    // 5. �������� �޽��� �ޱ� �޼ҵ� 
    public void receive() {
    	try {
	    	while(true) {
	    		InputStream inputStream = socket.getInputStream(); // 1. �Է� ��Ʈ��
	    		byte[] bytes = new byte[1000]; 	// 2. ����Ʈ�迭 ���� 
	    		inputStream.read(bytes);		// 3. �о���� 
	    		String msg = new String(bytes);	// 4. ����Ʈ�� -> ���ڿ� ��ȯ
	    		txtcontent.appendText(msg); 	// 4. ���� ���ڿ��� �޽���â�� ���� 
	    	}
    	}catch( Exception e ) {}
    }
    
    @FXML
    void connect(ActionEvent event) {
    	if( btnconnect.getText().equals("ä�ù� ����") ) {// ���࿡ ��ư�� �ؽ�Ʈ�� "ä�ù� ����" �̸� 
    		
    		clientstart(); // Ŭ���̾�Ʈ ���� �޼ҵ� 
    		
    		txtcontent.appendText("---[ä�ù� ����]---\n");
    		btnconnect.setText("ä�ù� ������");
    		
    		txtmsg.setText("");				// ä���Է�â ��ĭ���� ����
    		txtmsg.setDisable(false); 		// ä���Է�â ��밡�� 
        	txtcontent.setDisable(false); 	// ä��â ��� ��밡��
        	btnsend.setDisable(false); 		// ���۹�ư ��밡��
        	txtmsg.requestFocus();  		// ä���Է�â���� ��Ŀ��[Ŀ��] �̵�
    		
    	}else {
    		clientstop(); // Ŭ���̾�Ʈ ���� �޼ҵ� 
    		
    		txtcontent.appendText("---[ä�ù� ����]---\n");
    		btnconnect.setText("ä�ù� ����");
    		
    		txtmsg.setText("ä�ù� ������ ��밡��");
        	txtmsg.setDisable(true); 		// ä���Է�â ������ 
        	txtcontent.setDisable(true); 	// ä��â ��� ������
        	btnsend.setDisable(true); 		// ���۹�ư ������
    	}
    }
    @FXML
    void send(ActionEvent event) { // ���� ��ư�� ��������
    	String msg = txtmsg.getText()+"\n"; // ���� �޽���
    	send( msg ); // �޽��� ������ 
    	txtmsg.setText(""); 	// ������ �� �޽����Է�â �����
    	txtmsg.requestFocus();	// ������ �� �޽����Է�â���� ��Ŀ��(Ŀ��) �̵�
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	// ä��fxml �������� �ʱⰪ �޼ҵ�  	// * ä�ù� �������� �Ʒ� fxid�� �����ϰ� ���� 
    	txtmsg.setText("ä�ù� ������ ��밡��");
    	txtmsg.setDisable(true); 		// ä���Է�â ������ 
    	txtcontent.setDisable(true); 	// ä��â ��� ������
    	btnsend.setDisable(true); 		// ���۹�ư ������
    	btnconnect.setDisable(true); 	// �����ư ������
    	txtmidlist.setDisable(true);  	// ������ȸ�� ��� ������ 
    	show();
    }
	
}


















