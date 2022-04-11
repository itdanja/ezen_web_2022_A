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
	// 3. ��� �� ȣ�� �޼ҵ� [ tableview -> ObservableList ] 
	public ObservableList<Room> roomlist (){
		ObservableList<Room> roomlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from room order by ronum desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	// select -> executeQuery // insert,update,delete -> executeUpdate
			// rs = Resultset �������̽� ��ü : select�� ��� ��������
				// resultset ( �ʱⰪ null )
				// rs.next() : select ����� ���ڵ� 1�� ��������
				// rs(null)  -> rs.next() -> rs(�����ù��°���ڵ�) -> rs.next() -> rs(����ǵι�°���ڵ� )
			while( rs.next() ) {
				
				// ���ȣ�� ������ 
				String sql2 = "select count(*) from roomlive where ronum = "+ rs.getInt(1);
				// roomlive ���ڵ� ���� 
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
		}catch(Exception e ) { System.out.println( "[SQL ����]"+e  ); }
			return null;
	}
	
	// 4. ä�ù� ���� ��� �߰� 
	public boolean addroomlive( Roomlive roomlive ) {
		String sql ="insert into roomlive(ronum,mid)values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , roomlive.getRonum()  );
			ps.setString( 2 , roomlive.getMid() );
			ps.executeUpdate();
			return true;
		}catch(Exception e ) { System.out.println( "[SQL ����]"+e  ); }
			return false;
	}
	// 5. ä�ù� ���ӵ� ��� ��� ȣ��
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
		}catch(Exception e ) { System.out.println( "[SQL ����]"+e  ); }
			return null;
	}
	
	// 6. ä�ù� ���� ��� ���� 
	public boolean roomlivedelete( String mid ) {
		String sql = "delete from roomlive where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );
			ps.executeUpdate();
			return true;
		}catch(Exception e ) { System.out.println( "[SQL ����]"+e  ); }
			return false;
	}
	// 7. ä�ù� ���� [ ���� : �ش� ä�ù濡 ���Ӹ���� 0 �̸�= �ش� ä�ù濡 ���ڵ尡 ������ ]
	public boolean roomdelete( int ronum ) {
		String sql = "select * from roomlive where ronum =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , ronum);
			rs = ps.executeQuery();
			if( rs.next() ) { // ����� �����ϸ� �����X
				return false;
			}else { // ����� ������ �����ó��O
				String sql2 = "delete from room where ronum =? ";
				ps = con.prepareStatement(sql2);
				ps.setInt( 1 , ronum);
				ps.executeUpdate();
				return true; // ���� ����� ���� �� ���� ���� 
			}
		}catch(Exception e ) { System.out.println( "[SQL ����]"+e  ); }
		return false;
	}
	// rs.next() : ��ȯŸ�� [ ���� ���ڵ尡 ������ true ]
	//					  [ ���� ���ڵ尡 ������ false ] 
	
}




































