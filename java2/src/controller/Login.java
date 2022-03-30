package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Login implements Initializable {

	@FXML
	private MediaView mediaview;// fxid
	
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
	}
}










