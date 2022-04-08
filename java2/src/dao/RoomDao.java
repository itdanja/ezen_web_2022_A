package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Room;

public class RoomDao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static RoomDao roomDao = new RoomDao();
	
	public RoomDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/javafx?serverTimezone=UTC",
					"root","1234");
		}catch(Exception e ) {}
	}
	
	// 1. �� ���� �޼ҵ� 
	public boolean roomadd( Room room ) {
		try {
			String sql="insert into room(roname,roip)values(?,?)";
			// ���̺� ���ڵ带 �߰��ϴ� ���� : insert into ���̺��(�ʵ��1,�ʵ��2)values( ��1 , ��2 )
			ps = con.prepareStatement(sql);
			ps.setString( 1 , room.getRoname() );
			ps.setString( 2 , room.getRoip() );
			ps.executeUpdate();
			return true;
		}catch(Exception e ) { System.out.println( "[SQL ����]"+e  ); }
			return false;
	}
	
	// 2. ���ȣ ȣ�� �޼ҵ� [ ���ȣ = ��Ʈ��ȣ�� ����� ���� ]
	public int getroomnum() {  // ���� �ֱ��� ��ϵ� �� ��ȣ ��������
		try {				// max( �ʵ�� ) : �ش� �ʵ��� ���� ū �� 
			String sql ="select max(ronum) from room";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() ) {
				return rs.getInt(1); // �ֱٿ� ��ϵ� ���ȣ ��ȯ
			}
		}catch(Exception e ) { System.out.println( "[SQL ����]"+e  ); }
		return 0;
	}
}




































