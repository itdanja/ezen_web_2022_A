package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	// 1. ��ǰ ��� 
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
		}catch(Exception e ) { System.out.println( "[SQL ����]"+e  ); }
		return false;
	}
	// 2. ��� ��ǰ ��� [ tableview ���x -> arraylist ���o ] 
	public ArrayList<Product> list(){
		ArrayList<Product> productlist = new ArrayList<>(); // ����Ʈ ���� 	
		try {
			String sql = "select * from product";	// SQL �ۼ�
			ps = con.prepareStatement(sql);			// SQL ���� 
			rs = ps.executeQuery();					// SQL ����  
			while( rs.next() ) {					// SQL ���[ ���ڵ� ���� ]
				Product product = new Product(  	// �ش� ���ڵ带 ��üȭ
						rs.getInt(1) ,
						rs.getString(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getString(8),
						rs.getInt(9));
				productlist.add(product);			// ����Ʈ�� ��ü ��� 
			}	
			return productlist;						// ����Ʈ ��ȯ
		}catch(Exception e ) { System.out.println( "[SQL ����]"+e  ); }
		return null; // ���࿡ ���н� NULL ��ȯ
	}
	// 3. ��ǰ ��ȸ
	
	// 4. ��ǰ ����
	
	// 5. ��ǰ ���� 
	
	
}


















