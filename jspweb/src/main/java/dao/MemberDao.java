package dao;

import dto.Member;

public class MemberDao extends Dao {
	// 자식클래스로 객체 생성시 ( 부모 클래스의 생성자 호출 )	
	public MemberDao() {
		super(); // 부모클래스 생성자 호출 
	}
	public static MemberDao memberDao = new MemberDao(); 		// dao 호출시 반복되는 new 연산자 제거 
	public static MemberDao getmemberDao() { return memberDao; } 
	
	// 아이디 중복체크 메소드
	public boolean idcheck( String mid ) {
		String sql = "select * from member where mid="+mid;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			// 동일한 아이디가 존재하면 
			if( rs.next() ) { return true; } 
		}catch (Exception e) { } 
		// 동일한 아디디가 존재하지 않으면
		return false;
	}
	// 이메일 중복체크 메소드 
	public boolean emailcheck( String email ) {
		String sql = "select * from member where memail = "+email;
		try {  ps = con.prepareStatement(sql); rs= ps.executeQuery(); if( rs.next() ) return true;
		}catch (Exception e) {} return false;
	}
	// 회원가입 메소드 
	public boolean signup( Member member ) {
		String sql ="insert into member(mid,mpassword,mname,mphone,memail,maddress) "
				+ "value(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , member.getMid() ); 	ps.setString( 2 , member.getMpassword() ); 
			ps.setString( 3 , member.getMname() );	ps.setString( 4 , member.getMphone() ); 
			ps.setString( 5 , member.getMemail()); 	ps.setString( 6 , member.getMaddress());
			ps.executeUpdate(); return true;
		}catch (Exception e) {} return false;
	}
	
	
}













