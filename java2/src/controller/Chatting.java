package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import controller.login.Login;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private TextField txtname;

    @FXML
    private TextField txtip;

    @FXML
    private TextField txtport;
    
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
    	// ä��fxml �������� �ʱⰪ �޼ҵ� 
    		// * ä�ù� �������� �Ʒ� fxid�� �����ϰ� ���� 
    	txtmsg.setText("ä�ù� ������ ��밡��");
    	txtmsg.setDisable(true); 		// ä���Է�â ������ 
    	txtcontent.setDisable(true); 	// ä��â ��� ������
    	btnsend.setDisable(true); 		// ���۹�ư ������
    }
	
}


















