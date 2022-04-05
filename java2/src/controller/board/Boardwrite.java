package controller.board;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import controller.home.Home;
import controller.login.Login;
import dao.BoardDao;
import dto.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Boardwrite implements Initializable {
	
    @FXML
    private Button btnwrite;

    @FXML
    private TextField txttitle;

    @FXML
    private TextArea txtcontent;

    @FXML
    private Button btnback;

    @FXML
    void back(ActionEvent event) {
    	Home.home.loadpage("/view/board/board.fxml");
    }

    @FXML
    void write(ActionEvent event) { //  �Խù� ��� ��ư�� �������� �̺�Ʈ 
    	// 1. ��Ʈ�ѿ� �Էµ� ������ ��������
    	String title = txttitle.getText(); // �ش� fxid��ü���� �Էµ� ���빰 ��������
    	String content = txtcontent.getText();
    		// * �ۼ��� : ���� �α��ε� ��ü�� login Ŭ������ member��ü�� ����Ǿ� ����
    	String write = Login.member.getMid();
    	
    	// 2. ��üȭ [ ��ȣ(����=�ڵ�) , ���� , ���� , �ۼ��� , �ۼ���(����=�ڵ�) , ��ȸ��(����=�ڵ�) ]
    	Board board = new Board( 0 , title , content , write , null , 0);
    	// 3. db����
    		// 1. new ��ü�� �̿��� �޼ҵ� ȣ�� 
	//    	BoardDao boardDao = new BoardDao();
	//    	boardDao.write(board);
    		// 2. Ŭ������ static ���� ȣ���� �޼ҵ� ȣ�� 
    	boolean result =  BoardDao.boardDao.write(board);
    	if( result ) {
    		// �޽���
    		Alert alert = new Alert( AlertType.INFORMATION );
    			alert.setHeaderText("�Խñ��� �ۼ� �Ǿ����ϴ�.");
    		alert.showAndWait();
    		// ������ ��ȯ
    		Home.home.loadpage("/view/board/board.fxml");
    	}else {
    		// �޽���
    		Alert alert = new Alert( AlertType.INFORMATION );
    			alert.setHeaderText("�Խñ� �ۼ� ����[�����ڿ��Թ���]");
    		alert.showAndWait();
    	}
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
