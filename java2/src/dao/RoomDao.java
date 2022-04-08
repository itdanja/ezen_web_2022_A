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
	
	// 1. 방 저장 메소드 
	public boolean roomadd( Room room ) {
		try {
			String sql="insert into room(roname,roip)values(?,?)";
			// 테이블에 레코드를 추가하는 문법 : insert into 테이블명(필드명1,필드명2)values( 값1 , 값2 )
			ps = con.prepareStatement(sql);
			ps.setString( 1 , room.getRoname() );
			ps.setString( 2 , room.getRoip() );
			ps.executeUpdate();
			return true;
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
			return false;
	}
	
	// 2. 방번호 호출 메소드 [ 방번호 = 포트번호로 사용할 예정 ]
	public int getroomnum() {  // 가장 최근의 등록된 방 번호 가져오기
		try {				// max( 필드명 ) : 해당 필드의 가장 큰 값 
			String sql ="select max(ronum) from room";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() ) {
				return rs.getInt(1); // 최근에 등록된 방번호 반환
			}
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return 0;
	}
}




































