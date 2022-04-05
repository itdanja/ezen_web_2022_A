package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Board;

public class BoardDao {
	
	// 필드 
	private Connection conn; // 1. DB 연결 클래스
	private PreparedStatement ps; // 2. 연결된 DB내 SQL 조작 인터페이스
	private ResultSet rs; // 3. SQL 결과 레코드를 가져오는 인터페이스
	
	public static BoardDao boardDao = new BoardDao(); // db연동 객체
	
	//생성자
	public BoardDao() { // 생성자에서 연동하는 이유 : 객체 생성시 바로 db연동하기 위해 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC 드라이브 클래스 호출
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234");
		}catch( Exception e ) {}
	}
	// 메소드
		// 1. 글쓰기 메소드
	public boolean write( Board board) {   return false;  }
		// 2. 모든 글 호출 메소드
	public boolean list() { return false; }
		// 3. 글 삭제 메소드
	public boolean delete( int bnum ) { return false; }
		// 4. 글 수정 메소드
	public boolean update( int bnum , String title , String content ) { return false; }
}


















