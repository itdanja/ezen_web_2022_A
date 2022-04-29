package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dto.Board;
import Dto.Member;

public class Dao {
	
	private Connection con;	// db연결 클래스 
	private PreparedStatement ps;  // db조작 인터페이스
	private ResultSet rs; // db결과 인터페이스
	
	public Dao() {
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
	// 1. 회원가입
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
	// 로그인
	public boolean login( String id , String password) {
		String sql = "select * from member where mid=? and mpassword=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , id ); ps.setString( 2 , password );  
			rs = ps.executeQuery();
			if( rs.next() )return true;
		}catch (Exception e) { System.out.println( e );} return false;
	}
	// 글쓰기
	public boolean write( Board board ) {
		String sql = "insert into board( btitle,bcontent,bwriter,bdate)values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , board.getBtitle() );
			ps.setString( 2 , board.getBcontent() );
			ps.setString( 3 , board.getBwriter() );
			ps.setString( 4 , board.getBdate() );
			ps.executeUpdate(); // insert -> executeUpdate
			return true;
		}catch (Exception e) {} return false;
	}
	// 모든 글 조회
	public ArrayList<Board> list(){
		ArrayList<Board> boardlist = new ArrayList<Board>(); // 리스트 선언 [ 여러개 게시물 저장 ]
		String sql = "select * from board order by bno desc"; // 조건없는 모든 레코드 출력 
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				Board board = new Board(
						rs.getInt(1) , rs.getString(2) , 
						rs.getString(3) , rs.getString(4) , 
						rs.getString(5) 
						);
				boardlist.add(board);
			}
			return boardlist;
		}catch (Exception e) {} return null;
	}
	
	// 개별 글 조회
	public Board get( int bno ) {
		String sql = "select * from board "
				+ "where bno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , bno );
			rs = ps.executeQuery();
			if( rs.next() ) {
				Board board = new Board(
						rs.getInt(1), 
						rs.getString(2) , 
						rs.getString(3), 
						rs.getString(4) ,
						rs.getString(5));
				return board;
			}
		}catch (Exception e) {} return null;
	}
	
	// 게시물 삭제 ( 준비물 : 게시물번호 )
	public boolean ddelete( int bno ) {
		String sql = "delete from board where bno =? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1 , bno);
			ps.executeUpdate();
			return true; // 성공시
		}catch (Exception e) {} return false; // 실패시
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






