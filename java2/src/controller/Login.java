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
		// 1. 동영상 삽입하기
			// 1. 동영상파일 객체화
			Media media = new Media( getClass().getResource("/img/login.mp4").toString());
			// 2. 미디어플레이어 객체에 동영상 넣기 
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			// 3. 미디어뷰에 미디어플레이어 넣기 
			mediaview.setMediaPlayer(mediaPlayer);
			// 4. 미디어플레이어 시작
			mediaPlayer.play();
	}
}










