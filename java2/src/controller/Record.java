package controller;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.ProductDao;
import dto.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class Record implements Initializable {
	
	@FXML
	private Label lblmtotal; // fxid 객체화
	@FXML
	private Label lblptotal; // fxid 객체화
	@FXML
	private Label lblbtotal; // fxid 객체화
	@FXML
	private BarChart mbc; // fxid 객체화
	@FXML
	private BarChart bbc; // fxid 객체화
	@FXML
	private BarChart pbc; // fxid 객체화
    @FXML
    private PieChart ppc;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 전체 회원수 
		int mtotal = MemberDao.memberDao.counttotal("member");
		lblmtotal.setText( mtotal+" 명");
		// 전체 제품수 
		int ptotal = MemberDao.memberDao.counttotal("product");
		lblptotal.setText( ptotal+" 개");
		// 전체 게시물수 
		int btotal = MemberDao.memberDao.counttotal("board");
		lblbtotal.setText( btotal+" 개");
		
		// 날짜별로 회원 가입 수 
		// 1. xy축 계열 생성
		XYChart.Series series = new XYChart.Series<>(); 
			// XYChart.Series : 계열 클래스
				// XYChart.Data : 계열데이터 클래스 [ x축의 값 , y축의값 ]
		// 2. DB에서 데이터 가져오기 
			// 날짜별로 회원가입 수체크 [ 2022-04-11  ,  3 ]
			// Map 컬렉션 => 키(날짜) , 값(가입자 수) 으로 하나의 엔트리 구성 
			Map<String, Integer> map = MemberDao.memberDao.datetotal("member" , "msince");
		// 3. 데이터를 계열에 추가 
			for( String key : map.keySet() ) { // 반목문 
				// 3-1 : 데이터 계열 선언 ( 생성자 : key=날짜 , value=가입자수 )
				XYChart.Data data = new XYChart.Data<>( key , map.get(key) );
				// 3-2 : 해당 데이터 객체를 계열에 추가
				series.getData().add(data);
			}
		// 4. 해당 계열을 막대차트에 추가 
		mbc.getData().add(series);
		
		// 1. 계열 생성
		XYChart.Series series2 = new XYChart.Series<>();
		Map<String, Integer> map2 
					= MemberDao.memberDao.datetotal( "board" , "bdate" );
		for( String key : map2.keySet() ) {
			// 2. 데이터 생성 
			XYChart.Data data 
				= new XYChart.Data<>( key , map2.get(key) );
			// 3. 계열에 데이터 추가 
			series2.getData().add(data);
		}
		// 4. 차트에 계열 추가 
		bbc.getData().add(series2);
	
		

		// 1. 계열 생성 
		XYChart.Series series3 = new XYChart.Series<>();
		
			series3.setName("국어점수"); // * 계열명 
		
			// 2. 데이터 선언 ( x축값 , y축값 )
			XYChart.Data data = new XYChart.Data<>("신동엽" , 10);
			// 3. 계열에 데이터 추가
			series3.getData().add(data);
			
			XYChart.Data data2 = new XYChart.Data<>("강호동" , 20);
			series3.getData().add(data2);
			
			XYChart.Data data3 = new XYChart.Data<>("유재석" , 15);
			series3.getData().add(data3);
			
		// 4. 차트에 계열추가
		pbc.getData().add(series3);
			
		XYChart.Series series4 = new XYChart.Series<>();
			series4.setName("영어점수");

			XYChart.Data data4 = new XYChart.Data<>("신동엽" , 25); // 2. 데이터 선언 ( x축값 , y축값 )
			series4.getData().add(data4); // 3. 계열에 데이터 추가
			
			XYChart.Data data5 = new XYChart.Data<>("강호동" , 40);
			series4.getData().add(data5);
			
			XYChart.Data data6 = new XYChart.Data<>("유재석" , 50);
			series4.getData().add(data6);
	
		pbc.getData().add(series4);
		
		// 원형차트 : 카테고리별 개수
			// *  ObservableList 사용이유 : 원형차트에 리스트를 추가시
		// 1. ObservableList< 원형차트 데이터 자료형 > 리스트명  선언 
		ObservableList< PieChart.Data > list 
			= FXCollections.observableArrayList();
			
		// 2. db에서 카테고리별 개수  
		Map< String , Integer > map3 
			= MemberDao.memberDao.countcategory();
		
		for( String key : map3.keySet() ) {
			// 3. 원형차트 데이터 추가 
			PieChart.Data temp 
				= new PieChart.Data( key , map3.get(key) );
			// * 데이터를 리스트에 추가 
			list.add(temp);
		}
		// 4. 리스트를 원형차트에 추가
		ppc.setData( list );
		
		
		
		
	}
		
	
}









