package dao;

import java.util.ArrayList;

import controller.board.rereplywrite;
import dto.Category;
import dto.Product;
import dto.Stock;

public class ProductDao extends Dao {
	// 부모클래스의 생성자 호출 -> db 연결 
	public ProductDao() {  super(); }
	// 외부클래스에서 접근 객체 
	private static ProductDao productDao = new ProductDao();
	public static ProductDao getProductDao() { return productDao; }
	
	// 메소드는 반환타입 에 따른 return 값 설정
			// 반환타입이 클래스이면 -> null , 객체명
			// 반환타입이 기본자료형이면 -> false , 0  , 2 , 0.1  
///////////////////////////////////  카테고리 ////////////////////////
	// 1. 카테고리 등록 [ C ]
	public boolean csave( String cname) { 
		String sql = "insert into category(cname)values('"+cname+"')";
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate(); return true;
		}catch (Exception e) {} return false;
	}
	// 2. 카테고리 호출 [ R ] 
	public ArrayList<Category> getcategorylist(){ 
		ArrayList<Category> list = new ArrayList<Category>();
		String sql = "select * from category";
		try {
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { // 1개 호출시 if // 여러개 호출시 while
				Category category = new Category( rs.getInt(1) , rs.getString(2) );
				list.add(category);
			}
			return list;
		}catch (Exception e) {} return null; 
	}
	// 3. 카테고리 수정 [ U ] 
	// 4. 카테고리 삭제 [ D ]
///////////////////////////////////  제품 ////////////////////////////////	
	// 1. 제품 등록 
	public boolean psave( Product product ) {
		String sql = "insert into product(pname,pprice,pdiscount,pimg,cno ) "
				+ "values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , product.getPname() );		ps.setInt( 2 , product.getPprice() );
			ps.setFloat( 3 , product.getPdiscount() );	ps.setString( 4 , product.getPimg() );
			ps.setInt( 5 , product.getCno() );ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}return false; 
	}
	// 2. 제품 모든 호출
	public ArrayList<Product> getproductlist() { 
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "select * from product";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product(
						rs.getInt(1),rs.getString(2), 
						rs.getInt(3), rs.getFloat(4), 
						rs.getInt(5), rs.getString(6), rs.getInt(7) );
				products.add(product);
			} return products;
		}catch(Exception e ) {} return null;
	}
	// 3. 제품 개별 호출 
	public Product getproduct() { return null; }
	// 4. 제품 수정
	// 4-2 제품 상태 변경 
	public boolean activechange( int pno , int active  ) {
		String sql = "update product set pactive = "+active+" where pno="+pno;
		try { ps=con.prepareStatement(sql); ps.executeUpdate(); return true; }
		catch (Exception e) {} return false;
	}
	// 5. 제품 삭제 
///////////////////////////////////  재고 ////////////////////////////////	
	// 1. 제품의 재고 등록 
	public boolean ssvae() { return false; }
	// 2. 제품의 재고 호출 
	public Stock getStock() { return null; }
	// 3. 제품의 재고 수정 
	// 4. 제품의 재고 삭제
//////////////////////////////////////////////////////////////////////////
	
}







