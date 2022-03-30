package application;

// javafx�� ���[ awt , swing ���� ���� X ]
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Day21_1 extends Application {
				// extends : ��� [ Application : JAVAFX ����Ŭ���� => start �޼ҵ� ���� ] 
					// ��ӹ����� ����Ŭ������ ����� ����Ҽ� �ִ�.
	@Override
	public void start( Stage �������� ) throws Exception {
		// javafx�� �����ϴ� �޼ҵ�[ �߻� -> ���� ]
			// start( Stage ���������̸� ) 
		// 1. �����̳� �����  [ ������ ��Ʈ�� ���η� ���� ] 
		VBox �����̳� = new VBox();
			// 2. ��Ʈ�� ����� 
			Button button = new Button();
			button.setText("�ݱ�");
			button.setOnAction( e -> Platform.exit() ); // �� -> �μ�  ���ٽ� ( �̸��� ���� �޼ҵ� )
		// 3. �����̳ʿ� ��Ʈ�� �ֱ� [ 
		�����̳�.getChildren().add(button);
		// 4. �� ��ü ���� ��( �����̳� �ֱ� )
		Scene ��� = new Scene( �����̳� , 500 , 500  ); // �����̳��̸� , ���α���  , ���α���
		// 5. ���������� �� �ֱ� 
		��������.setScene(���);
		��������.show(); // �������� ���� 
		// * ���� : �������� -> �� -> �����̳� -> �������� ��Ʈ��(��ư,�Է»���,ǥ �� )
	}
	
	public static void main(String[] args) { // ���ν�����
		launch(args); // start �޼ҵ� ȣ�� 
	}
	

}
