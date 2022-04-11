package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Board;
import dto.Reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
	public boolean write( Board board) {   
		try {
		// 1. SQL 작성
			String sql = "insert into board(btitle , bcontent , bwrite) values(?,?,?)";
		// 2. SQL 조작
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , board.getBtitle() ); 
			ps.setString( 2 , board.getBcontent() ); 
			ps.setString( 3 , board.getBwrite() );
		// 3. SQL 실행
			ps.executeUpdate(); // insert , update, delete <----> ps.executeQuery(); // select
		// 4. SQL 결과
			return true;
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return false;  
	}
		// 2. 모든 글 호출 메소드 [ 반환타입 : ObservableList
	public ObservableList<Board> list() {
		// * 리스트 선언 
		ObservableList<Board> boardlist = FXCollections.observableArrayList();
		try {
		// 1. SQL 작성
				// 정렬 : order by 필드명 asc   [ 해당 필드명 기준으로 오름차순 ]
				//		 order by 필드명 desc	 [ 해당 필드명 기준으로 내림차순 ] 
			String sql = "select * from board order by bnum desc";
		// 2. SQL 조작
			ps = conn.prepareStatement(sql);
		// 3. SQL 실행
			rs = ps.executeQuery(); //select
		// 4. SQL 결과
			// rs : 검색 결과의 레코드를 하나씩 순회[가져오기=next()]
				// rs.next() : 검색결과의 다음 레코드 
				// rs.get자료형( 해당필드순서번호 ) : 현 레코드에서 해당 필드의 데이터 가져오기
			while( rs.next() ) { // 다음 레코드가 없을때까지 반복
				// 1. 객체화
				Board board = new Board( rs.getInt(1) ,
						rs.getString(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6));
				// 2. 해당 객체를 리스트에 담기 
				boardlist.add(board); 
			}
			// 성공시 리스트 반환 
			return boardlist;
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return null; // 실패시 null
	}
		// 3. 글 삭제 메소드
	public boolean delete( int bnum ) { 
		try {
			String sql = "delete from board where bnum=?"; // 1. SQL 작성
			ps = conn.prepareStatement(sql); // 2. SQL 조작
			ps.setInt( 1 , bnum);
			ps.executeUpdate(); // 3. SQL 실행 
			return true; // 4. SQL 결과
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return false; 
	}
		// 4. 글 수정 메소드
	public boolean update( int bnum , String title , String content ) {
		try {
		// 1. SQL 작성
			String sql = "update board set btitle=? , bcontent=? where bnum=?";
		// 2. SQL 조작
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , title );
			ps.setString( 2 , content );
			ps.setInt( 3 , bnum );
		// 3. SQL 실행
			ps.executeUpdate();
		// 4. SQL 결과
			return true;
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return false; 
	}
	
	// 5. 댓글 작성 메소드[ 회원가입, 글쓰기 유사 ]
	public boolean rwrite( Reply reply ) {
		try {
			String sql = "insert into reply(rcontent,rwrite,bnum)values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , reply.getRcontent() );
			ps.setString( 2 , reply.getRwrite() );
			ps.setInt( 3 , reply.getBnum() );
			ps.executeUpdate();
			return true;
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return false;
	}
	
	// 6. 해당 게시물의 댓글들 호출 메소드 
	public ObservableList<Reply> replylist( int bnum ){
		
		ObservableList<Reply> replylist = FXCollections.observableArrayList();
		
		try {
			String sql = "select * from reply where bnum =? order by rnum desc";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bnum);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				Reply reply = new Reply(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5));
				replylist.add(reply);
			}
			
			return replylist;
			
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
			return null;
	}
}





































