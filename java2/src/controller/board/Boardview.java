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
    	
    	// 1. ��� �޽��� �˸�
    	// 2. Ȯ�� ��ư ��������
    	// 3. ���� ó��
    	
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Board board = controller.board.Board.board; // board��Ʈ�ѳ� ���̺��� ���õ� ��ü ȣ�� 
		
		// �� ��Ʈ�ѿ� ���õ� board�� ������ �����ϱ� 
		lblwrite.setText( "�ۼ��� : " + board.getBwrite() );
		lbldate.setText( "�ۼ��� : " + board.getBdate() );
		lblview.setText( "��ȸ�� : " + board.getBview() );
		txttitle.setText( board.getBtitle() );
		txtcontent.setText( board.getBcontent() );
		// ���࿡ �Խù� �ۼ��� �� ����α��ε� id�� �������� ������
		if( ! board.getBwrite().equals( Login.member.getMid() ) ) { // !:����
			btndelete.setVisible(false); // ��ư �����
			btnupdate.setVisible(false); // false = ��ư ����� true = ��ư ���̱�
		}
		// ���� �� ������ ���� ���ϰ� ���� ����
		txttitle.setEditable(false);
		txtcontent.setEditable(false);
	}
	
	

}























