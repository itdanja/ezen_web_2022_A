package dao;

import java.util.ArrayList;

import dto.Board;
import dto.Reply;
import teamchatting.도시;
import teamchatting.접속유저;

public class BoardDao extends Dao {
	
	public BoardDao() {
		super(); // 슈퍼클래스 호출 ( db연동 )
			// super.메소드()  super.필드명	   super() : 생성자
	}
	public static BoardDao boardDao = new BoardDao();
	public static BoardDao getBoardDao() { return boardDao; }
	
	// 1. 게시물 쓰기 메소드 	[ 인수 : 작성된 데이터들 = dto  ]
	public boolean write( Board board ) { 
		
		String sql = "insert into board( btitle , bcontent , mno , bfile )values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , board.getBtitle() );	ps.setString( 2 , board.getBcontent() );
			ps.setInt( 3 , board.getMno() );		ps.setString( 4 , board.getBfile() );
			ps.executeUpdate(); return true;
		}catch (Exception e) { System.out.println( e ); }	return false; 
	}
	// 2-2 게시물 전체/검색 개수 출력 메소드 
	public int gettotalrow( String key , String keyword  ) {
		
		// 만약에 작성자 요청이면 
		if( key.equals("mid") ) { key = "mno"; keyword = MemberDao.getmemberDao().getmno(keyword)+""; }
		
		String sql = null;
		if( key.equals("") && keyword.equals("") ) { sql ="select count(*) from board";} //검색이 없을경우 
		else { sql ="select count(*) from board where "+key+" like '%"+keyword+"%'";} // 검색이 있을경우
		
		try { ps = con.prepareStatement(sql); rs = ps.executeQuery(); 
			if( rs.next() ) return rs.getInt(1); 
		}
		catch( Exception e ) { System.out.println( e );} return 0;
	}
	
	// 2. 모든 게시물 출력 메소드 [ 인수 : x  // 추후기능 = 검색 : 조건 ]
	public ArrayList<Board> getboardlist(int startrow , int listsize , String key , String keyword ) { 
		ArrayList<Board> boardlist = new ArrayList<Board>();
		String sql =  null;
		
		if( key.equals("mid") ) { key = "mno"; keyword = MemberDao.getmemberDao().getmno(keyword)+""; }
		
		if( key.equals("") && keyword.equals("") ) { //검색이 없을경우 
			sql = "select * from board order by bno desc limit "+startrow+","+listsize; /* limit 시작 인덱스 , 표시 개수 */
		}else {
			sql ="select * from board where "+key+" like '%"+keyword+"%' order by bno desc limit "+startrow+","+listsize;
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				Board board = new Board( 
						rs.getInt(1),rs.getString(2), 
						rs.getString(3),rs.getInt(4),
						rs.getString(5), rs.getInt(6),
						rs.getString(7), null );
				boardlist.add(board);
			}
			return boardlist;
		}catch (Exception e) { System.out.println( e );} return null; 
		
	}
	// 3. 개별 게시물 출력 메소드 [ 인수 : 게시물번호 ]
	public Board getboard( int bno ) { 
		String sql ="select * from board where bno="+bno;	// 1. SQL 작성 
		try {
			ps = con.prepareStatement(sql);	// 2.연결된DB( con ) 에 SQL문 설정  
			rs = ps.executeQuery(); 		// 3.조작된 SQL를 실행
			if( rs.next() ) { // 4. 검색 결과 [ rs.next() 할 때 마다 결과물에서 레코드 1개씩 호출 ]  
				Board board = new Board( 
					rs.getInt(1),rs.getString(2), 
					rs.getString(3),rs.getInt(4),
					rs.getString(5), rs.getInt(6),
					rs.getString(7), null 
				);
				return board;
			}
		}catch (Exception e) {} return null;
		
		
	}
	// 4. 게시물 수정 메소드 	[ 인수 : 수정할 게시물번호  / 수정된 내용 ]
	public boolean update( Board board ) { 
		String sql = "update board set btitle=? , bcontent=? , bfile=? where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , board.getBtitle() );
			ps.setString( 2 , board.getBcontent() );
			ps.setString( 3 , board.getBfile() );
			ps.setInt( 4 , board.getBno() );
			ps.executeUpdate(); return true;
		}
		catch (Exception e) { System.out.println( e );} return false;
	}
	
	// 5. 게시물 삭제 메소드 	[ 인수 : 삭제할 게시물번호 
	public boolean delete( int bno ) { 
		String sql = "delete from board where bno="+bno;
		try { ps = con.prepareStatement(sql); ps.executeUpdate(); return true;}
		catch (Exception e) {} return false;
	}
	// 5-2 첨부파일만 삭제( null로 변경 ) 메소드 
	public boolean filedelete( int bno ) {
		String sql = "update board set bfile = null where bno = "+bno;
		try { ps = con.prepareStatement(sql); ps.executeUpdate(); return true; }
		catch (Exception e) {} return false;
	}
	
	// 6. 게시물 조회 증가 메소드 	[ 인수 : 증가할 게시물번호 ]
	public boolean increview( int bno ) { 
		String sql ="update board set bview = bview+1 where bno = "+bno;
		try { ps=con.prepareStatement(sql); ps.executeUpdate(); return true; } 
		catch (Exception e) {}	return false; 
		
	}
	// 7. 댓글 작성 메소드 		[ 인수 : 작성된 데이터들 = dto ]
	public boolean replywrite( Reply reply ) { 
		String sql = "insert into reply( rcontent,rindex,bno,mno ) values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , reply.getRcontent() );
			ps.setInt( 2 , reply.getRindex() );
			ps.setInt( 3 , reply.getBno() );
			ps.setInt( 4 , reply.getMno() );
			ps.executeUpdate(); return true;
		}catch (Exception e) { System.out.println( e ); } return false;
	}
	// 8. 댓글 출력 메소드 		[ 인수 : 현재 게시물번호 ]
	public ArrayList<Reply> replylist( int bno ) { 
		ArrayList<Reply> replylist = new ArrayList<Reply>();
		String sql = "select * from reply where bno = "+bno+" and rindex = 0"; // rindex = 0  : 댓글만 출력 [ 대댓글 제외 ] 
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while( rs.next() ) { 
				Reply reply = new Reply( 
						rs.getInt(1) , rs.getString(2) , 
						rs.getString(3) , rs.getInt(4) , 
						rs.getInt(5), rs.getInt(6), null);
				replylist.add(reply);
			}
			return replylist;
		}catch (Exception e) { System.out.println( e ); } return null; 
	}
	// 8-2 대댓글 출력 메소드 
	public ArrayList<Reply> rereplylist( int bno , int  rno ){
		ArrayList<Reply> rereplylist = new ArrayList<Reply>();
		String sql = "select * from reply where bno = "+bno+" and rindex = "+rno;
		try { 
			ps = con.prepareStatement(sql); rs= ps.executeQuery();
			while( rs.next() ) {
				Reply reply = new Reply(
						rs.getInt(1) , rs.getString(2),
						rs.getString(3), rs.getInt(4), 
						rs.getInt(5), rs.getInt(6), null);
				rereplylist.add(reply);
			}
			return rereplylist;
		}catch (Exception e) { System.out.println(e); } return null;
		
	}
	// 9. 댓글 수정 메소드 		[ 인수 : 수정할 댓글 번호 ]
	public boolean replyupdate() { return false; }
	// 10. 댓글 삭제 메소드 		[ 인수 : 삭제할 댓글 번호 ] 
	public boolean replydelete( int rno) { 
		String sql ="delete from reply "
				+ "where rno = "+rno+" or rindex = "+rno;
		try { 
			ps = con.prepareStatement(sql); 
			ps.executeUpdate();
			return true;
		}
		catch( Exception e ) {} return false;
	}
	
//////////////////////// day49_teamchatting /////////////////////////////////
	public boolean send( String nicname , String content , String ip , String file  )  {
		String sql = "insert into teamchatting(cnicname , ccontent ,ip,file )values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , nicname ); ps.setString( 2 , content );  
			ps.setString( 3 , ip );		ps.setString( 4 , file );
			ps.execute(); return true;
		}catch (Exception e) {} return false;
	}
	public String receive(  )  {
		String receive = "";
		String sql = "select * from teamchatting;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				receive += rs.getString( 6 ) +"^"+
						rs.getString( 5 ) +"^"+
						rs.getString( 4 ) +"^"+
						rs.getString( 2 ) +"^"+
						rs.getString( 3 )+",";
			}
			return receive;
		}catch (Exception e) {} return null;
	}
////////////////////////////////////////////////// /////////////////////////////////

	public ArrayList<도시> get도시(){
		ArrayList<도시> list = new ArrayList<도시>();
		String sql = "select * from 도시";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				도시 도시 = new 도시();
				도시.도시번호 = rs.getInt(1);
				도시.도시명 = rs.getString(2);
				도시.구매자 = rs.getString(3);
				도시.건축비 = rs.getInt(4);
				도시.위치 = rs.getInt(5);
				list.add(도시);
			}
			return list;
		}catch (Exception e) {} return null;
	}
	
	public boolean 게임접속( String mid) {
		String sql = "insert into 플레이어(돈,턴,현재위치,회원아이디) values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , 10000 );
			ps.setInt( 2 , 0 );
			ps.setInt( 3 , 1 );
			ps.setString( 4 , mid ); ps.executeUpdate();
		}catch (Exception e) {
			System.out.println( e );
		}
		return false;
	}
	
	public ArrayList<접속유저> 접속명단호출( ) {
		
		ArrayList<접속유저> list = new ArrayList<접속유저>();
		String sql = "select * from 플레이어";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				접속유저 접속유저 = new 접속유저();
				접속유저.플레이어번호 = rs.getInt(1);
				접속유저.돈 = rs.getInt(2);
				접속유저.턴 = rs.getInt(3);
				접속유저.현재위치 = rs.getInt(4);
				접속유저.회원아이디 = rs.getString(5);
				list.add(접속유저);
			}
			return list;
		}catch (Exception e) {System.out.println( e );} return null;
		
	}

}










