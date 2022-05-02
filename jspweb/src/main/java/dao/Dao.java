package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// dao : DB 접근 객체
public class Dao {
	
	protected Connection con;	// 패키지가 달라도 상속받으면 접근가능 // public , private , protected , default
	protected ResultSet rs;
	protected PreparedStatement ps;
	
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jspweb?serverTimezone=UTC",
					"root","1234");
			System.out.println("연동 성공");
		}catch (Exception e) { System.out.println("연동 실패"+e);}
	}
}
