package application.Day22;

import java.sql.Connection;
import java.sql.DriverManager;

public class Day22_2 {
	
	// 1.�ʵ�
		private Connection connection; // DB���� ��ü ���� 
	// 2.������
		public Day22_2 ( ) {
			try { // JAVA�� �ܺο� ����� ������ �Ϲݿ��� �߻� 
				// 1. DB ����̺� Ŭ���� ȣ�� [ DB ȸ�� ���� �ٸ��⶧���� �ϱ�X ����O ]
				Class.forName("com.mysql.cj.jdbc.Driver");
				// 2. DB ���� 
				connection = DriverManager.getConnection(
						// JDBC : JAVA DABABASE CONNECTION
						// jdbc:mysql://IP�ּ�(����[����pc]�̸�localhost):port��ȣ/DB�̸�?DB�ð�����
						// , ������ , "DB��й�ȣ"
						"jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC" , 
						"root",
						"1234");
				// 3. Ȯ��
				System.out.println("[DB ���� ����]");
			}catch( Exception e ) {
				System.out.println("[DB���� ����]");
			}
		}
	
	// 3.�޼ҵ� 
	

}
