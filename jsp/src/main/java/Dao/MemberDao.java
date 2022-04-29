package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MemberDao {
	private Connection con;
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

	
	
	
}






