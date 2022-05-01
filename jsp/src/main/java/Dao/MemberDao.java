package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Dto.Member;

public class MemberDao {
	
	private Connection con;	// db연결 클래스 
	private PreparedStatement ps;  // db조작 인터페이스
	private ResultSet rs; // db결과 인터페이스
	
	public MemberDao() {
		// jdbc 
			// 1. 프로젝트내 build path 에 mysqljdbc.jar 추가
			// 2. 프로젝트내 webapp -> web-inf-lib -> mysqljdbc.jar 추가
		// 1. db 서버 연동 
		try { // 예외처리 => 자바외 외부통신할때 : 일반예외가 무조건 발생 
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jsptest?serverTimezone=UTC",
					"root","1234");
			System.out.println("연동 성공 ");
		}catch(Exception e ){ System.out.println("연동 실패 ");}
		
	}
	
	public boolean signup( Member member) {
		
		// 1. SQL 작성
		String sql = "insert into member( mid , mpassword, mname) values( ? , ? , ? )";
					// insert into 테이블( 필드명1 , 필드명2 , 필드명3 ) values( 값1 , 값2 , 값3);
					// insert into 테이블 values( 값1 , 값2 , 값3 , 값4 );
		// 2. 연결된 DB에 SQL 연결
		try {
			ps = con.prepareStatement(sql);
			// 3. 각 ? 에 데이터 대입
			ps.setString( 1 , member.getMid() );
			ps.setString( 2 , member.getMpassword() );
			ps.setString( 3 , member.getMname() );
			// 4. sql 실행
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println( "오류 : "+e );
		}
		return false;
	}
	
	public boolean login( String id , String password) {
		String sql = "select * from member where mid=? and mpassword=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , id ); ps.setString( 2 , password );  
			rs = ps.executeQuery();
			if( rs.next() )return true;
		}catch (Exception e) { System.out.println( e );} return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






