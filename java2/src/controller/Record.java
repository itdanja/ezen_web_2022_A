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
	private Label lblmtotal; // fxid ��üȭ
	@FXML
	private Label lblptotal; // fxid ��üȭ
	@FXML
	private Label lblbtotal; // fxid ��üȭ
	@FXML
	private BarChart mbc; // fxid ��üȭ
	@FXML
	private BarChart bbc; // fxid ��üȭ
	@FXML
	private BarChart pbc; // fxid ��üȭ
    @FXML
    private PieChart ppc;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// ��ü ȸ���� 
		int mtotal = MemberDao.memberDao.counttotal("member");
		lblmtotal.setText( mtotal+" ��");
		// ��ü ��ǰ�� 
		int ptotal = MemberDao.memberDao.counttotal("product");
		lblptotal.setText( ptotal+" ��");
		// ��ü �Խù��� 
		int btotal = MemberDao.memberDao.counttotal("board");
		lblbtotal.setText( btotal+" ��");
		
		// ��¥���� ȸ�� ���� �� 
		// 1. xy�� �迭 ����
		XYChart.Series series = new XYChart.Series<>(); 
			// XYChart.Series : �迭 Ŭ����
				// XYChart.Data : �迭������ Ŭ���� [ x���� �� , y���ǰ� ]
		// 2. DB���� ������ �������� 
			// ��¥���� ȸ������ ��üũ [ 2022-04-11  ,  3 ]
			// Map �÷��� => Ű(��¥) , ��(������ ��) ���� �ϳ��� ��Ʈ�� ���� 
			Map<String, Integer> map = MemberDao.memberDao.datetotal("member" , "msince");
		// 3. �����͸� �迭�� �߰� 
			for( String key : map.keySet() ) { // �ݸ� 
				// 3-1 : ������ �迭 ���� ( ������ : key=��¥ , value=�����ڼ� )
				XYChart.Data data = new XYChart.Data<>( key , map.get(key) );
				// 3-2 : �ش� ������ ��ü�� �迭�� �߰�
				series.getData().add(data);
			}
		// 4. �ش� �迭�� ������Ʈ�� �߰� 
		mbc.getData().add(series);
		
		// 1. �迭 ����
		XYChart.Series series2 = new XYChart.Series<>();
		Map<String, Integer> map2 
					= MemberDao.memberDao.datetotal( "board" , "bdate" );
		for( String key : map2.keySet() ) {
			// 2. ������ ���� 
			XYChart.Data data 
				= new XYChart.Data<>( key , map2.get(key) );
			// 3. �迭�� ������ �߰� 
			series2.getData().add(data);
		}
		// 4. ��Ʈ�� �迭 �߰� 
		bbc.getData().add(series2);
	
		

		// 1. �迭 ���� 
		XYChart.Series series3 = new XYChart.Series<>();
		
			series3.setName("��������"); // * �迭�� 
		
			// 2. ������ ���� ( x�ప , y�ప )
			XYChart.Data data = new XYChart.Data<>("�ŵ���" , 10);
			// 3. �迭�� ������ �߰�
			series3.getData().add(data);
			
			XYChart.Data data2 = new XYChart.Data<>("��ȣ��" , 20);
			series3.getData().add(data2);
			
			XYChart.Data data3 = new XYChart.Data<>("���缮" , 15);
			series3.getData().add(data3);
			
		// 4. ��Ʈ�� �迭�߰�
		pbc.getData().add(series3);
			
		XYChart.Series series4 = new XYChart.Series<>();
			series4.setName("��������");

			XYChart.Data data4 = new XYChart.Data<>("�ŵ���" , 25); // 2. ������ ���� ( x�ప , y�ప )
			series4.getData().add(data4); // 3. �迭�� ������ �߰�
			
			XYChart.Data data5 = new XYChart.Data<>("��ȣ��" , 40);
			series4.getData().add(data5);
			
			XYChart.Data data6 = new XYChart.Data<>("���缮" , 50);
			series4.getData().add(data6);
	
		pbc.getData().add(series4);
		
		// ������Ʈ : ī�װ��� ����
			// *  ObservableList ������� : ������Ʈ�� ����Ʈ�� �߰���
		// 1. ObservableList< ������Ʈ ������ �ڷ��� > ����Ʈ��  ���� 
		ObservableList< PieChart.Data > list 
			= FXCollections.observableArrayList();
			
		// 2. db���� ī�װ��� ����  
		Map< String , Integer > map3 
			= MemberDao.memberDao.countcategory();
		
		for( String key : map3.keySet() ) {
			// 3. ������Ʈ ������ �߰� 
			PieChart.Data temp 
				= new PieChart.Data( key , map3.get(key) );
			// * �����͸� ����Ʈ�� �߰� 
			list.add(temp);
		}
		// 4. ����Ʈ�� ������Ʈ�� �߰�
		ppc.setData( list );
		
		
		
		
	}
		
	
}









