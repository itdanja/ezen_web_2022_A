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
		// * 아이디 중복체크 메소드 ( 인수 : 아이디를 인수로 받아 db에 존재하는지 체크 )
	public boolean idcheck( String id) {
		try {
			// 1. SQL 작성
				// 검색 : select * from 테이블명 where 조건( 필드명=값 )
			String sql = "select * from member where mid=?";
			// 2. SQL 조작 
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			// 3. SQL 실행 
			rs = ps.executeQuery(); // select 실행 -> 검색은 결과물 존재 -> resultset O
			// resultset 처음 기본 값은 : null ---next()---> 결과 레코드
			// 4. SQL 결과
			if( rs.next() ){ // 만약에 다음 결과물이 존재하면 => 해당 아이디가 존재 -> 중복O 
				return true; // 해당 아이디는 중복이 존재
			}
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return false; // 해당 아이디는 중복이 없음 
	}
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
			ps.setString( 6 , member.getMsince() ); // 6번 ? 에 가입일 넣어주기
			// 3. SQL 실행 
			ps.executeUpdate(); // insert 실행 -> 삽입 결과물 X -> resultset X
			return true; // * 성공시 
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return false; // * 실패시
	}
		// 2. 로그인 메소드 ( 인수 : 로그인시 필요한 아이디,비밀번호 )
	public boolean login( String id , String password ) { 
		try {
		// 1. sql 작성
			//  and : 조건1 and 조건2     이면서  
			//  or : 조건1 or 조건2		이거나 
			String sql = "select * from member where mid=? and mpassword=?";
			// 2. sql 조작
			ps = con.prepareStatement(sql);
			ps.setString(1, id);		// 첫번째 ? 에 id 변수 넣기 
			ps.setString(2, password); // 두번째 ? 에 password 변수 넣기
			// 3. sql 실행 
			rs = ps.executeQuery(); // select 실행 -> resultset  
			// 4. sql 결과
			if( rs.next() ) { // select 시 결과물이 있으면 
				return true; // 아이디와 비밀번호가 동일 -> 로그인 성공 
			}
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return false; // 로그인 실패
	}
		// 3. 아이디찾기 메소드 ( 인수 : 아이디찾기 시 필요한 이메일 )
	public String findid( String email ) { 
		try {
			// 1. SQL 작성
			String sql = "select * from member where memail=?";
			// 2. SQL 조작
			ps = con.prepareStatement(sql);
			ps.setString( 1 , email );
			// 3. SQL 실행 
			rs =  ps.executeQuery(); // select 실행문 -> rs  
			// 4. SQL 결과
			if( rs.next() ) { // 실행 결과의 다음 레코드(가로) 가져오기 
				return rs.getString(2); // 필드(세로) 번호 
				//rs.getString(가져올필드순서번호);
			}
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return null;
	}
		// 4. 비밀번호찾기 메소드 ( 인수 : 비밀번호찾기 시 필요한 아이디, 이메일 )
	public String findpassword( String id , String email ) { 
		try {
			// 1. SQL 작성
			String sql = "select * from member where mid=? and memail=?";
			// 2. SQL 조작
			ps = con.prepareStatement(sql);
			ps.setString(1, id );	ps.setString(2, email );
			// 3. SQL 실행
			rs = ps.executeQuery();
			// 4. SQL 결과
			if( rs.next() ) {
				return rs.getString(3); // 패스워드는 db테이블내 3번째 필드 이므로 3 
			}
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return null;
	}
	
	// 5. 아이디 인수 로 회원정보 호출 
	public Member getmember( String id ) {
		try {
		// 1. SQL 작성
			String sql = "select * from member where mid=?";
		// 2. SQL 조작
			ps = con.prepareStatement(sql);
			ps.setString( 1 , id);
		// 3. SQL 실행
			rs = ps.executeQuery();
		// 4. SQL 결과
			if( rs.next() ) {
				// 1. 객체 선언
				Member member = new Member(
						rs.getInt(1) ,
						rs.getString(2),
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6), 
						rs.getString(7) );
				// rs.next() : 결과내 다음 레코드(줄,가로)
				// rs.getInt( 필드순서번호 ) : 해당 필드의 자료형이 정수형으로 가져오기
				// rs.getString( 필드순서번호 ) : 해당 필드의 자료형이 문자열로 가져오기
				// 2. 반환
				return member;
			}
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); } 
		return null;
	}
	// 6. 회원탈퇴 [ 회원번호를 인수로 받아 해당 회원번호의 레코드 삭제 ]
	public boolean delete( int mnum ) {
		try {
				// 레코드삭제 : delete from 테이블명 where 조건 
			String sql = "delete from member where mnum = ?"; // 1.SQL 작성
			ps = con.prepareStatement(sql); // 2.SQL 조작
			ps.setInt(1, mnum);
			ps.executeUpdate(); // insert , update , delete 실행 // 3.SQL 실행
			return true; // 4.SQL 결과
			
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return false;
	}
	
	// 7. 회원수정 [ 회원번호 , 이메일 , 주소 를 인수로 받아서 회원수정 처리 ]
	public boolean update( int mnum , String email , String address ) {
		try {
			// 1.SQL 작성  // 수정 : update 테이블명 set 필드명1=수정값1 , 필드명2=수정값2 where 조건 
			String sql = "update member set memail=? , maddress=? where mnum =?";
			ps = con.prepareStatement(sql); 	// 2.SQL 조작
			ps.setString( 1 , email ); ps.setString(2, address); ps.setInt( 3 , mnum );
			ps.executeUpdate(); // 3.SQL 실행
			return true; // 4.SQL 결과
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return false;
	}
	// 8. 해당 회원번호로 해당 id 찾기
	public String getmid( int mnum ) {
		try {
			String sql ="select mid from member where mnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, mnum);
			rs = ps.executeQuery();
			if( rs.next() ) {
				return rs.getString(1);// 찾은 id 반환
			}
		}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return null;
	}
	
}






























