package controller.board;

import java.net.URL;
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

public class Board implements Initializable {
	
    @FXML
    private Button btnwrite;
    @FXML
    private TableView<dto.Board> boardtable; // 테이블에 넣을 자료형 선택 [ 테이블에 게시물 표시하기위해 ]

    @FXML
    void accwrite(ActionEvent event) {
    	// * Home클래스내 borderpane center 변경
    	Home.home.loadpage("/view/board/boardwrite.fxml");
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	// * arraylist 가 아닌 ObservableList 사용하는 이유 [tableview가 ObservableList를 사용 ] 
    	// 1. db에서 모든 게시글 가져오기
    	ObservableList<dto.Board> boardlist = BoardDao.boardDao.list();
    	// 2. tableview 에 추가 
    		// 현재 테이블 각 열 마다 리스트내 필드 설정 
    	TableColumn tc = boardtable.getColumns().get(0);	// 테이블에서 첫번째 열 가져오기 
    	tc.setCellValueFactory( new PropertyValueFactory<>("bnum")); // 
    	//tc.setCellValueFactory( new PropertyValueFactory<>("리스트내 자료형의 표시할 필드명"));
    	
    	tc = boardtable.getColumns().get(1);	// 테이블에서 두번째 열 가져오기
    	tc.setCellValueFactory( new PropertyValueFactory<>("btitle"));
    	
    	tc = boardtable.getColumns().get(2);	// 테이블에서 세번째 열 가져오기
    	tc.setCellValueFactory( new PropertyValueFactory<>("bwrite"));
    	
    	tc = boardtable.getColumns().get(3);	// 테이블에서 네번째 열 가져오기
    	tc.setCellValueFactory( new PropertyValueFactory<>("bdate"));
    	
    	tc = boardtable.getColumns().get(4);	// 테이블에서 다섯번째 열 가져오기
    	tc.setCellValueFactory( new PropertyValueFactory<>("bview"));
    	
    	// 3. tableview 에 list 연결
    	boardtable.setItems(boardlist);;
    		// 테이블명(fxid).setItems( ObservableList );  // 테이블에 표시할 리스트(일반적arraylist X) 설정
    	
    }

}
















