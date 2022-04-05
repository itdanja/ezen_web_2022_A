package controller.board;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.home.Home;
import dao.BoardDao;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Board implements Initializable {
	
    @FXML
    private Button btnwrite;
    @FXML
    private TableView<dto.Board> boardtable; // ���̺� ���� �ڷ��� ���� [ ���̺� �Խù� ǥ���ϱ����� ]
    
    public static dto.Board board; // ���̺��� Ŭ���� ��ü�� �����ϴ� ��ü

    @FXML
    void accwrite(ActionEvent event) {
    	// * HomeŬ������ borderpane center ����
    	Home.home.loadpage("/view/board/boardwrite.fxml");
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	// * arraylist �� �ƴ� ObservableList ����ϴ� ���� [tableview�� ObservableList�� ��� ] 
    	// 1. db���� ��� �Խñ� ��������
    	ObservableList<dto.Board> boardlist = BoardDao.boardDao.list();
    	// 2. tableview �� �߰� 
    		// ���� ���̺� �� �� ���� ����Ʈ�� �ʵ� ���� 
    	TableColumn tc = boardtable.getColumns().get(0);	// ���̺��� ù��° �� �������� 
    	tc.setCellValueFactory( new PropertyValueFactory<>("bnum")); // 
    	//tc.setCellValueFactory( new PropertyValueFactory<>("����Ʈ�� �ڷ����� ǥ���� �ʵ��"));
    	
    	tc = boardtable.getColumns().get(1);	// ���̺��� �ι�° �� ��������
    	tc.setCellValueFactory( new PropertyValueFactory<>("btitle"));
    	
    	tc = boardtable.getColumns().get(2);	// ���̺��� ����° �� ��������
    	tc.setCellValueFactory( new PropertyValueFactory<>("bwrite"));
    	
    	tc = boardtable.getColumns().get(3);	// ���̺��� �׹�° �� ��������
    	tc.setCellValueFactory( new PropertyValueFactory<>("bdate"));
    	
    	tc = boardtable.getColumns().get(4);	// ���̺��� �ټ���° �� ��������
    	tc.setCellValueFactory( new PropertyValueFactory<>("bview"));
    	
    	// 3. tableview �� list ����
    	boardtable.setItems(boardlist);;
    		// ���̺��(fxid).setItems( ObservableList );  // ���̺� ǥ���� ����Ʈ(�Ϲ���arraylist X) ����
    	
    	
    	// * tableview ���� �ش� ���� Ŭ�������� �̺�Ʈ
    		//boardtable.setOnMouseClicked( �μ� -> { �����ڵ� } ) : ���̺��� Ŭ��������
    	boardtable.setOnMouseClicked( e -> { 
    		
    		// 1. ���̺��� Ŭ���� ��ü�� �ӽð�ü�� ���� 
    		board = boardtable.getSelectionModel().getSelectedItem() ; // Ŭ���� board ��ü ȣ��
    		// 2. ��ȸ�� ����
    		// 3. ������ ��ȯ
    		Home.home.loadpage("/view/board/boardview.fxml");
    	});
    	
    	//  [��ȸ��]  �μ� -> �����ڵ�   : ���ٽ� ( �͸��Լ� : �̸��� ���� �Լ� [ �μ� �� �����ڵ常 ���� ] ) 
    	//  vs
    	//  [��Ȱ��]  void �Լ���( �μ�1 ) {  �����ڵ� }  : �Լ�
    	
    }

}
















