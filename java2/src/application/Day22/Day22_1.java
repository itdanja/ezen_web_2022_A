package application.Day22;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// ������ [ javafx ó�� ��� ] (åx)

	// javafx ��� ����
		// 1. javafx ��ġ
		// 2. javafx ������Ʈ ���� 
		// 3. ������Ʈ�� javafx ���̺귯�� �߰� 
		// 4. ���̺귯�� ���� ���� / ������

public class Day22_1 extends Application {
						// Application ��� �ޱ� 
	
	// 1. �������̵� [ start : javafx ����  ] 
	@Override
	public void start(Stage ��������) throws Exception {
					// �������� �̸����ϱ�[�ƹ��ų�]
		// 1. ���������� �ۼ��� ����[FXML]�� ��ü�� �������� 
		Parent parent = FXMLLoader.load( getClass().getResource("DB�׽�Ʈ.fxml"));
		// 2. �� ��ü�� ���� ������ fxml��ü�� �־��ش�.
		Scene scene = new Scene(parent);
		// 3. �� ��ü�� ���������� ����
		��������.setScene(scene);
		// 4. �������� ����
		��������.show();
	}
	// 2. main �޼ҵ� ���� 
	public static void main(String[] args) {
		launch(args);
	}
	
}


















