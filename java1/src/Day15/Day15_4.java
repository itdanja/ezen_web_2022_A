package Day15;

public class Day15_4 {
	
	public static void main(String[] args) {
		
		// 12�� : ������ : �ڵ带 �о��ִ� ���� 
			// �ڵ� -> ���� -> ���μ���[���α׷�]
			// ���� : ����ó��
				// main�޼ҵ忡 main������ ����
			// �����
				// 1. Thread Ŭ����
				// 2. Runnable �������̽� 
			// run �޼ҵ� : ��Ƽ�������� �����ڵ� 
		
		// ��1) Thread Ŭ������ �̿��� ����ó�� ��ü �����
		���� m1 = new ����();
		m1.start(); // run�޼ҵ� ���� -> ������ ����
		
		// ��2) Runnable �������̽��� �̿��� ����ó�� ��ü �����
		ä�� c1 = new ä��();
		//c1.start(); // Runnable�� start() �޼ҵ带 ������ ���� ���� .
		Thread thread = new Thread( c1 );
		thread.start();
						
		while( true ) { // main������ ������
			System.out.println("*���α׷� �۵���*");
			try {
				Thread.sleep(500); // 0.5�ʰ� �Ͻ�����
			}catch( Exception e ) {}
		}
	
		
	}

}
















