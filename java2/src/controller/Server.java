package controller;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dto.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Server implements Initializable {
    @FXML
    private Button btnserver;
    @FXML
    private TextArea txtserver;
    // * ������ ����� Ŭ���̾�Ʈ�� �����ϴ� ����Ʈ 
    public static Vector<Client> clientlist = new Vector<>();	
    		// Vector ����ϴ����� : ����ȭ ����(o)    // ����ȭ : ���� �����尡 �ϳ��� �޼ҵ������� ��� ��� ���� �����
    // * ��Ƽ�����带 �������ִ� ������Ǯ ����
    public static ExecutorService threadpool ;
    	// ExecutorService : ������Ǯ ���� �������̽� [ ����Ŭ����(implements) vs ��������(�͸�ü)
    
    // 1. �������� ����
    ServerSocket serverSocket;
    
    // 2. �������� �޼ҵ�
    public void serverstart() { 
    	try {
	    	serverSocket = new ServerSocket(); // 1. �������� �޸��Ҵ�
	    	serverSocket.bind( new InetSocketAddress( "127.0.0.1" , 1234 ) ); 	// 2. �������� ���ε� [ ip �� port ���� ] 
    	}catch( Exception e ) {}
    		// 3. Ŭ���̾�Ʈ�� ��û ���  [ ��Ƽ������ ����ϴ����� : 1.���� 2.������ 3.�ޱ� ���� ó�� ] 
    	Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						Socket socket = serverSocket.accept(); // 1. ��û �����Ŀ� ������ ������ ����
						clientlist.add( new Client(socket) ); // 2. ����� Ŭ���̾�Ʈ( ����ȼ��� ) ������ �� ����Ʈ�� ���� 
					}
				}catch( Exception e ) {}
			}
		};// ��Ƽ������ ���� ��
		
		threadpool = Executors.newCachedThreadPool(); // ������Ǯ�� �޸� �ʱ�ȭ[�Ҵ�]
		threadpool.submit(runnable); // ������ ������ ��Ƽ�����带 ������Ǯ�� �־��ֱ� 
    }
    // 3. �������� �޼ҵ�
    public void serverstop() { 
    	try {
	    	// 1. ���ӵ� ��� Ŭ���̾�Ʈ���� ���� �ݱ� 
	    	for( Client client :  clientlist) {
	    		client.socket.close();
	    	}
	    	// 2. �������� �ݱ�
	    	serverSocket.close();
	    	// 3. ������Ǯ �ݱ�
	    	threadpool.shutdown();
    	}catch( Exception e ) {}
    }
    
    @FXML
    void server(ActionEvent event) { // ���� ���� ��ư
    	if( btnserver.getText().equals("���� ����") ) { // ���࿡ ��ư�� �ؽ�Ʈ�� "���� ����" �̸�
    		
    		serverstart(); // ���� ���� �޼ҵ� ȣ��
    		
    		txtserver.appendText("[[ ���� �����մϴ�.]]\n"); // �ؽ�Ʈ��Ͽ� �����߰�
    		btnserver.setText("���� ����"); // ��ư�� �ؽ�Ʈ ����
    		
    	}else { // ��ư�� �ؽ�Ʈ�� "���� ����" �̸�
    		
    		serverstop(); // ���� ���� �޼ҵ� ȣ��
    		
    		txtserver.appendText("[[ ���� �����մϴ�.]]\n");
    		btnserver.setText("���� ����");
    	}
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	txtserver.setDisable(true); // �ش� fxid ������
    }

}








