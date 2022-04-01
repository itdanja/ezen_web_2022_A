package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;

public class MemberDao { // DB ���ٰ�ü
	
	private Connection con; // DB������ ���Ǵ� Ŭ���� : DB����Ŭ����
	private PreparedStatement ps; // ����� DB�� SQL ���� �Ҷ� ���Ǵ� �������̽� : DB�����������̽�
	private ResultSet rs; // ������� �����ϴ� �������̽� 
	
	public static MemberDao memberDao ; // DB ���� ��ü;
	
	public MemberDao() {
		memberDao = this;
		try {
			// DB���� 
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. DB ����̹� ��������
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234"); // 2. DB �ּ� ���� 
		}
		catch(Exception e ) {}
	}
	// �޼ҵ� 
		// 1. ȸ������ �޼ҵ� ( �μ� : db�� ���� ���̵�,��й�ȣ,�̸���,�ּ� )
	public boolean signup( Member member ) { 
		try {
			// 1. SQL �ۼ�  [ ȸ����ȣ(�ڵ���ȣ=auto),����Ʈ(���Խ�0) ������ ��� �ʵ� ���� ]
			String sql = "insert into member( mid ,mpassword,memail,maddress,mcince)values(?,?,?,?,?)";
			// 2. SQL ����
			ps = con.prepareStatement(sql); // PreparedStatement �������̽��� ����� db�� sql �ֱ�
			ps.setString( 1 , member.getMid() ); // 1�� ? �� ���̵� �־��ֱ�
			ps.setString( 2 , member.getMpassword() ); // 2�� ? �� ��й�ȣ �־��ֱ�
			ps.setString( 3 , member.getMemail() ); // 3�� ? �� �̸��� �־��ֱ�
			ps.setString( 4 , member.getMaddress() ); // 4�� ? �� �ּ� �־��ֱ�
			ps.setString( 5 , member.getMcince() ); // 5�� ? �� ������ �־��ֱ�
			// 3. SQL ���� 
			ps.executeUpdate(); // insert ����
		}catch( Exception e ) {
			System.out.println( e );
		}
		
		return false;
	}
		// 2. �α��� �޼ҵ� ( �μ� : �α��ν� �ʿ��� ���̵�,��й�ȣ )
	public boolean login( String id , String password ) { return false;}
		// 3. ���̵�ã�� �޼ҵ� ( �μ� : ���̵�ã�� �� �ʿ��� �̸��� )
	public String findid( String email ) { return null;}
		// 4. ��й�ȣã�� �޼ҵ� ( �μ� : ��й�ȣã�� �� �ʿ��� ���̵�, �̸��� )
	public String findpassword( String id , String email ) { return null;}
	
	

}








