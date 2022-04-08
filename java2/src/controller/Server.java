package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server{	// fxml ������� �ʴ� Ŭ���� [ ���� ��Ʈ�� ��� ] 
	
	// ��ø Ŭ����  [ Ŭ���� �ȿ� Ŭ������ ����Ǹ� ] 
	public class Client { // ������ ���ӵ� Ŭ���̾�Ʈ�� Ŭ���� 
		public Socket socket; // 1. �ʵ� [ ���� ] 
		
		public Client( Socket socket ) { // 2.������ 
			this.socket = socket;
			recive(); // ������ ����� Ŭ���̾�Ʈ ��ü�� �����ɶ� �ޱ� �޼ҵ�(���ѷ���) 
		}
		
		// 3. ������ �޽��� �޴� �޼ҵ� [ �������� : ������ Ŭ���̾�Ʈ�� ����Ǿ����� ] 
		public void recive() {
			// ��Ƽ������ [ Thread Ŭ���� vs  Runnable �������̽� ] 	// run �޼ҵ带 �ʼ������� �����ؾ���.
			// �������̽��� �߻�޼ҵ尡 �����ϱ� ������ �����ʼ�[ Ŭ�������� implements vs  �͸� ��ü ]
			Runnable runnable = new Runnable() {
				@Override
				public void run() { // �߻�޼ҵ� ���� 
					// ��������� �޽��� �޴� ���� 
				
					while(true) {
						try {
							InputStream inputStream = socket.getInputStream(); // 1. �Է½�Ʈ�� 
							byte[] bytes = new byte[1000]; 	// 2. ����Ʈ �迭 ���� [ ��Ʈ���� ����Ʈ���� �̱� ������ ]
							inputStream.read( bytes ); 		// 3. �Է½�Ʈ������ ����Ʈ �о���� 
							String msg = new String(bytes);	// 4. ����Ʈ�� -> ���ڿ� ��ȯ
							// * ������ ���� �޽����� ���� ������ ���ӵ� ��� Ŭ���̾�Ʈ���� ���� �޽��� ������
							for( Client client   : clientlist ) {
								client.send( msg ); // ���� �޽����� ������ ���ӵ�[ clientlist ] ��� Ŭ���̾�Ʈ���� �޽��� ������
							}
					
						}catch( Exception e ) { }
					}
				}
			}; // ��Ƽ������ ���� �� 
			threadpool.submit(runnable);  // �ش� ��Ƽ�����带 ������Ǯ�� �־��ֱ� 
		}
		// 4. ������ �޽��� ������ �޼ҵ�  [ �������� : ������ �޽����� �޾����� ]
		public void send( String msg ) { 
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						OutputStream outputStream = socket.getOutputStream(); 	// 1. ��� ��Ʈ��
						outputStream.write( msg.getBytes() ); 					// 2. ��������
					}catch( Exception e ) { }
				}
			}; // ��Ƽ������  ���� �� 
			threadpool.submit(runnable); // �ش� ��Ƽ�����带 ������Ǯ�� �־��ֱ� 
		}
	}
	
	// ��ø Ŭ����end 
	
    // * ������ ����� Ŭ���̾�Ʈ�� �����ϴ� ����Ʈ 
    	// static : ���α׷� ���۵Ǹ� �޸� �Ҵ� / ���α׷� ����Ǹ� �޸� �ʱ�ȭ
    public Vector<Client> clientlist = new Vector<>();	
    		// Vector ����ϴ����� : ����ȭ ����(o)    // ����ȭ : ���� �����尡 �ϳ��� �޼ҵ������� ��� ��� ���� �����
    // * ��Ƽ�����带 �������ִ� ������Ǯ ����
    public ExecutorService threadpool ;
    	// ExecutorService : ������Ǯ ���� �������̽� [ ����Ŭ����(implements) vs ��������(�͸�ü)
    
    // 1. �������� ����
    ServerSocket serverSocket;
    
    // 2. �������� �޼ҵ� [ �μ��� ip �� port �޾Ƽ� ���� ip�� port �� �������� ���ε�(����) ] 
    public void serverstart( String ip , int port) {  
    	try {
	    	serverSocket = new ServerSocket(); // 1. �������� �޸��Ҵ�
	    	serverSocket.bind( new InetSocketAddress( ip , port ) ); 	// 2. �������� ���ε� [ ip �� port ���� ] 
    	}catch( Exception e ) { 
    		serverstop();
    		System.out.println("���� ���� ����:"+e); }
    		// 3. Ŭ���̾�Ʈ�� ��û ���  [ ��Ƽ������ ����ϴ����� : 1.���� 2.������ 3.�ޱ� ���� ó�� ] 
    	Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						Socket socket = serverSocket.accept(); // 1. ��û �����Ŀ� ������ ������ ����
						clientlist.add( new Client(socket) ); // 2. ����� Ŭ���̾�Ʈ( ����ȼ��� ) ������ �� ����Ʈ�� ���� 
					}
				}catch( Exception e ) {  }
			}
		};// ��Ƽ������ ���� ��
		threadpool = Executors.newCachedThreadPool(); 	// ������Ǯ�� �޸� �ʱ�ȭ[�Ҵ�]
		threadpool.submit(runnable); 					// ������ ������ ��Ƽ�����带 ������Ǯ�� �־��ֱ� 
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
    
}








