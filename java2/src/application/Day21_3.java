package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Day21_3 extends Application { // 1. Application Ŭ�����κ��� ���
	@Override
	public void start(Stage stage ) throws Exception { // 2. start �޼ҵ� ����
					   // ���������̸�
		// 1. FXML ���� �ҷ����� : �����̳�  
		Parent parent = FXMLLoader.load( getClass().getResource("test.fxml"));
			// Parent : fxml����(����������)�� ��üȭ [ 
				// FXMLLoader.load( getClass().getResource("���/fxml���ϸ�") );
		// 2. �� ��ü ���� : ���� �����̳� �ֱ� 
		Scene scene = new Scene(parent);
		// 3. ���������� �� �ֱ� 
		stage.setScene(scene);
		// 4. �������� ���� 
		stage.show();// �������� ���� 
	}
	public static void main(String[] args) { // 3. ���ν����� -> start�޼ҵ� ȣ��
		launch(args); // start �޼ҵ� ȣ�� 
	}
}
