package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Board;

public class BoardDao {
	
	// �ʵ� 
	private Connection conn; // 1. DB ���� Ŭ����
	private PreparedStatement ps; // 2. ����� DB�� SQL ���� �������̽�
	private ResultSet rs; // 3. SQL ��� ���ڵ带 �������� �������̽�
	
	public static BoardDao boardDao = new BoardDao(); // db���� ��ü
	
	//������
	public BoardDao() { // �����ڿ��� �����ϴ� ���� : ��ü ������ �ٷ� db�����ϱ� ���� 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC ����̺� Ŭ���� ȣ��
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234");
		}catch( Exception e ) {}
	}
	// �޼ҵ�
		// 1. �۾��� �޼ҵ�
	public boolean write( Board board) {   return false;  }
		// 2. ��� �� ȣ�� �޼ҵ�
	public boolean list() { return false; }
		// 3. �� ���� �޼ҵ�
	public boolean delete( int bnum ) { return false; }
		// 4. �� ���� �޼ҵ�
	public boolean update( int bnum , String title , String content ) { return false; }
}


















