package application.Day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Day26_client {
	
	public static void main(String[] args) {
		
		// 1. ���� �����
		Socket socket = new Socket();
		try {
			while( true ) { // 2. ������������ �����ϱ� [ ���������� ip�� port ��ȣ �־��ֱ� ] 
				socket.connect( new InetSocketAddress( "127.168.102.50",5000));
				System.out.println("[[������ ���� ����]]");
				
				Scanner scanner = new Scanner(System.in);
				// 3. �������� ������ �۽��ϱ�[������] : ��Ʈ�� �̿��� �ܺ� ��Ʈ��ũ ���
					// 1. ������ �Է¹ޱ�
				System.out.print("�������� ���� �޽��� : "); 
				String msg = scanner.nextLine();
					// 2. ������ ��� ��Ʈ��(��Ŵ���:����Ʈ) ��������  
				OutputStream outputStream = socket.getOutputStream();
					// 3. �������� [ ���ڿ� -> ����Ʈ�� ] 
				outputStream.write( msg.getBytes() );
				
				// 4. �������� ������ ����[�ޱ�]�ϱ� 
					// 1. ������ �Է� ��Ʈ��
				InputStream inputStream = socket.getInputStream();
					// 2. ����Ʈ �迭 ���� 
				byte[] bytes = new byte[1000];
					// 3. �Է½�Ʈ������ ���� ����Ʈ ��������
				inputStream.read( bytes );
				System.out.println("������ ���� �޽��� : " + new String( bytes ));
				
			}
		}catch (Exception e) {}
		
		
	}

}









