package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Room;
import dto.Roomlive;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

public class RoomDao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static RoomDao roomDao = new RoomDao();
	
	public RoomDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
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
	// 3. 모든 방 호출 메소드 [ tableview -> ObservableList ] 
	public ObservableList<Room> roomlist (){
		ObservableList<Room> roomlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from room order by ronum desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	// select -> executeQuery // insert,update,delete -> executeUpdate
			// rs = Resultset 인터페이스 객체 : select의 결과 가져오기
				// resultset ( 초기값 null )
				// rs.next() : select 결과의 레코드 1개 가져오기
				// rs(null)  -> rs.next() -> rs(결과의첫번째레코드) -> rs.next() -> rs(결과의두번째레코드 )
			while( rs.next() ) {
				
				// 방번호를 가지고 
				String sql2 = "select count(*) from roomlive where ronum = "+ rs.getInt(1);
				// roomlive 레코드 세기 
				ps = con.prepareStatement(sql2);
				ResultSet rs2  = ps.executeQuery();
				int count = 0 ;
				if( rs2.next() ) {  count = rs2.getInt(1); }
				Room room = new Room( rs.getInt( 1 ),
						rs.getString(2),
						rs.getString(3),
						count );
				roomlist.add(room);
			}
			return roomlist;
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
			return null;
	}
	
	// 4. 채팅방 접속 명단 추가 
	public boolean addroomlive( Roomlive roomlive ) {
		String sql ="insert into roomlive(ronum,mid)values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , roomlive.getRonum()  );
			ps.setString( 2 , roomlive.getMid() );
			ps.executeUpdate();
			return true;
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
			return false;
	}
	// 5. 채팅방 접속된 모든 명단 호출
	public ArrayList<Roomlive> getRoomlivelist( int ronum ){
		ArrayList<Roomlive> roomlivelist = new ArrayList<>();
		try {
			String sql = "select * from roomlive where ronum=?";
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , ronum );
			rs= ps.executeQuery();
			while( rs.next() ) {
				Roomlive roomlive = new Roomlive(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3));
				roomlivelist.add(roomlive);
			}
			return roomlivelist;
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
			return null;
	}
	
	// 6. 채팅방 접속 명단 삭제 
	public boolean roomlivedelete( String mid ) {
		String sql = "delete from roomlive where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );
			ps.executeUpdate();
			return true;
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
			return false;
	}
	// 7. 채팅방 삭제 [ 조건 : 해당 채팅방에 접속명단이 0 이면= 해당 채팅방에 레코드가 없으면 ]
	public boolean roomdelete( int ronum ) {
		String sql = "select * from roomlive where ronum =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , ronum);
			rs = ps.executeQuery();
			if( rs.next() ) { // 결과가 존재하면 방삭제X
				return false;
			}else { // 결과가 없으면 방삭제처리O
				String sql2 = "delete from room where ronum =? ";
				ps = con.prepareStatement(sql2);
				ps.setInt( 1 , ronum);
				ps.executeUpdate();
				return true; // 접속 명단이 없는 방 삭제 성공 
			}
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return false;
	}
	// rs.next() : 반환타입 [ 다음 레코드가 있으면 true ]
	//					  [ 다음 레코드가 없으면 false ] 
	
}




































