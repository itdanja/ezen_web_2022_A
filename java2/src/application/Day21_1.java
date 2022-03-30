package application;

// javafx만 사용[ awt , swing 이전 버전 X ]
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Day21_1 extends Application {
				// extends : 상속 [ Application : JAVAFX 관련클래스 => start 메소드 제공 ] 
					// 상속받으면 슈퍼클래스내 멤버를 사용할수 있다.
	@Override
	public void start( Stage 스테이지 ) throws Exception {
		// javafx를 실행하는 메소드[ 추상 -> 구현 ]
			// start( Stage 스테이지이름 ) 
		// 1. 컨테이너 만들기  [ 여러개 컨트롤 세로로 저장 ] 
		VBox 컨테이너 = new VBox();
			// 2. 컨트롤 만들기 
			Button button = new Button();
			button.setText("닫기");
			button.setOnAction( e -> Platform.exit() ); // 값 -> 인수  람다식 ( 이름이 없는 메소드 )
		// 3. 컨테이너에 컨트롤 넣기 [ 
		컨테이너.getChildren().add(button);
		// 4. 씬 객체 만들어서 씬( 컨테이너 넣기 )
		Scene 장면 = new Scene( 컨테이너 , 500 , 500  ); // 컨테이너이름 , 가로길이  , 세로길이
		// 5. 스테이지에 씬 넣기 
		스테이지.setScene(장면);
		스테이지.show(); // 스테이지 열기 
		// * 순서 : 스테이지 -> 씬 -> 컨테이너 -> 여러개의 컨트롤(버튼,입력상자,표 등 )
	}
	
	public static void main(String[] args) { // 메인스레드
		launch(args); // start 메소드 호출 
	}
	

}
