package Day15;

public class ���� extends Thread {
	@Override
	public void run() {
		// ����ó�� ���� 
		while( true ) { // ����Ŭ������ �����尡 ������
			System.out.println("**���ǽ�����**");
			try {
				Thread.sleep(500); // 0.5�ʰ� �Ͻ�����
			}catch( Exception e ) {}
		}
	}
}
