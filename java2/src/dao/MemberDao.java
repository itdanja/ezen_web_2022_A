package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;

public class MemberDao { // DB 접근객체
	
	private Connection con; // DB연동시 사용되는 클래스 : DB연동클래스
	private PreparedStatement ps; // 연결된 DB내 SQL 조작 할때 사용되는 인터페이스 : DB조작인터페이스
	private ResultSet rs; // 결과물을 조작하는 인터페이스 
	
	public static MemberDao memberDao = new MemberDao(); // DB 연동 객체;
	
	public MemberDao() {
		try {
			// DB연동 
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. DB 드라이버 가져오기
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234"); // 2. DB 주소 연결 
		}
		catch(Exception e ) { System.out.println( "[DB 연동 오류]"+e  ); }
	}
	// 메소드 
		// 1. 회원가입 메소드 ( 인수 : db에 넣을 아이디,비밀번호,이메일,주소 )
	public boolean signup( Member member ) { 
		try {
			// 1. SQL 작성  [ 회원번호(자동번호=auto) 제외한 모든 필드 삽입 ]
			String sql = "insert into member(mid,mpassword,memail,maddress,mpoint,msince)values(?,?,?,?,?,?)";
			// 2. SQL 조작
			ps = con.prepareStatement(sql); // PreparedStatement 인터페이스내 연결된 db에 sql 넣기
			ps.setString( 1 , member.getMid() ); // 1번 ? 에 아이디 넣어주기
			ps.setString( 2 , member.getMpassword() ); // 2번 ? 에 비밀번호 넣어주기
			ps.setString( 3 , member.getMemail() ); // 3번 ? 에 이메일 넣어주기
			ps.setString( 4 , member.getMaddress() ); // 4번 ? 에 주소 넣어주기
			ps.setInt( 5 , member.getMpoint() ); // 5번 ? 에 포인트 넣어주기
			ps.setString( 6 , member.getMcince() ); // 6번 ? 에 가입일 넣어주기
			// 3. SQL 실행 
			ps.executeUpdate(); // insert 실행
			return true; // * 성공시 
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return false; // * 실패시
	}
		// 2. 로그인 메소드 ( 인수 : 로그인시 필요한 아이디,비밀번호 )
	public boolean login( String id , String password ) { return false;}
		// 3. 아이디찾기 메소드 ( 인수 : 아이디찾기 시 필요한 이메일 )
	public String findid( String email ) { return null;}
		// 4. 비밀번호찾기 메소드 ( 인수 : 비밀번호찾기 시 필요한 아이디, 이메일 )
	public String findpassword( String id , String email ) { return null;}
	
	

}








