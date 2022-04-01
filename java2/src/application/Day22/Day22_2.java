package application.Day22;

import java.sql.Connection;
import java.sql.DriverManager;

public class Day22_2 {
	
	// 1.필드
		private Connection connection; // DB연동 객체 선언 
	// 2.생성자
		public Day22_2 ( ) {
			try { // JAVA외 외부와 연결시 무조건 일반예외 발생 
				// 1. DB 드라이브 클래스 호출 [ DB 회사 마다 다르기때문에 암기X 정리O ]
				Class.forName("com.mysql.cj.jdbc.Driver");
				// 2. DB 연결 
				connection = DriverManager.getConnection(
						// JDBC : JAVA DABABASE CONNECTION
						// jdbc:mysql://IP주소(로컬[본인pc]이면localhost):port번호/DB이름?DB시간설정
						// , 계정명 , "DB비밀번호"
						"jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC" , 
						"root",
						"1234");
				// 3. 확인
				System.out.println("[DB 연동 성공]");
			}catch( Exception e ) {
				System.out.println("[DB연동 실패]");
			}
		}
	
	// 3.메소드 
	

}
