package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Product;

public class ProductDao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static ProductDao productDao = new ProductDao();
	
	public ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234");
		}catch(Exception e ) {}
	}
	
	// 1. 力前 殿废 
	public boolean add( Product product ) {
		try {
			String sql = "insert into product(pname,pimg,pcontent,pcategory,pprice,pactivation,mnum) values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString( 1 , product.getPname() );
			ps.setString( 2 , product.getPimg() );
			ps.setString( 3 , product.getPcontent() );
			ps.setString( 4 , product.getPcategory() );
			ps.setInt( 5 , product.getPprice() );
			ps.setInt( 6 , product.getPactivation() );
			ps.setInt( 7 , product.getMnum() );
			ps.executeUpdate();
			return true;
		}catch(Exception e ) { System.out.println( "[SQL 坷幅]"+e  ); }
		return false;
	}
	// 2. 葛电 力前 免仿 
	
	// 3. 力前 炼雀
	
	// 4. 力前 昏力
	
	// 5. 力前 荐沥 
	
	
}


















