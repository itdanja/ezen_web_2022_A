package controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
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
			Map<String, Integer> map = MemberDao.memberDao.datetotal();
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
					= MemberDao.memberDao.datetotal2();
		for( String key : map2.keySet() ) {
			// 2. ������ ���� 
			XYChart.Data data 
				= new XYChart.Data<>( key , map2.get(key) );
			// 3. �迭�� ������ �߰� 
			series2.getData().add(data);
		}
		// 4. ��Ʈ�� �迭 �߰� 
		bbc.getData().add(series2);
	}
	
	
}









