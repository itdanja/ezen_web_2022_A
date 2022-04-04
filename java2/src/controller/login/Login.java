package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dto.Member;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Login implements Initializable {
	// * ���� Ŭ������ �޸𸮸� ��ȯ�ϴ� ���
		// 1. ���� Ŭ������ ��ü ���� 
	public static Login instance ;
		// 2. �����ڿ��� ��ü�� this �־��ֱ� 
			// this : ����Ŭ������ �޸� [ ���ο� �޸��Ҵ� X ]
	public Login() { instance = this; }
	
	// * �α��� ������ ȸ����ü [ static ����ϴ����� : �ٸ� Ŭ�������� ȣ���ϱ� ���� ] 
	public static Member member;
	
	@FXML
	private MediaView mediaview;// fxid
	
	@FXML
	private BorderPane borderpane; //fxid
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 1. ������ �����ϱ�
			// 1. ���������� ��üȭ
			Media media = new Media( getClass().getResource("/img/login.mp4").toString());
			// 2. �̵���÷��̾� ��ü�� ������ �ֱ� 
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			// 3. �̵��信 �̵���÷��̾� �ֱ� 
			mediaview.setMediaPlayer(mediaPlayer);
			// 4. �̵���÷��̾� ����
			mediaPlayer.play();
			
			// * ������ ������� // �̵�� �������� 
			mediaPlayer.setOnEndOfMedia( new Runnable() {
				@Override
				public void run() { // ��Ƽ ������ 
					mediaPlayer.seek( Duration.ZERO);
					// �̵���� ���� ��ġ�� ó������ ������
				}
			} );
			
			
			loadpage("/view/login/loginpane.fxml");
			
	}
	
	public void loadpage( String page ) {
		try {
			Parent parent = FXMLLoader.load( getClass().getResource(page) );
			borderpane.setCenter(parent);
		}catch( Exception e ) { System.out.println("�ش� ������ �����ϴ�. "+e);}
		
		
	}
	
	
	
}










