package controller.board;

import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dto.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Boardview implements Initializable {
	

    @FXML
    private Button btnrewrite;

    @FXML
    private TextField txttitle;

    @FXML
    private TextArea txtcontent;

    @FXML
    private Button btnback;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;

    @FXML
    private Label lblwrite;

    @FXML
    private Label lbldate;

    @FXML
    private Label lblview;

    @FXML
    private TextArea txtrecontent;

    @FXML
    private TableView<?> replytable;

 
    @FXML
    void rewrite(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }
    @FXML
    void back(ActionEvent event) {
    	Home.home.loadpage("/view/board/board.fxml");
    }

    @FXML
    void delete(ActionEvent event) {
    	
    	// 1. 경고 메시지 알림
    	// 2. 확인 버튼 눌렀을때
    	// 3. 삭제 처리
    	
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Board board = controller.board.Board.board; // board컨트롤내 테이블에서 선택된 객체 호출 
		
		// 각 컨트롤에 선택된 board의 데이터 설정하기 
		lblwrite.setText( "작성자 : " + board.getBwrite() );
		lbldate.setText( "작성일 : " + board.getBdate() );
		lblview.setText( "조회수 : " + board.getBview() );
		txttitle.setText( board.getBtitle() );
		txtcontent.setText( board.getBcontent() );
		// 만약에 게시물 작성자 와 현재로그인된 id와 동일하지 않으면
		if( ! board.getBwrite().equals( Login.member.getMid() ) ) { // !:부정
			btndelete.setVisible(false); // 버튼 숨기기
			btnupdate.setVisible(false); // false = 버튼 숨기기 true = 버튼 보이기
		}
		// 제목 과 내용을 수정 못하게 수정 금지
		txttitle.setEditable(false);
		txtcontent.setEditable(false);
	}
	
	

}























