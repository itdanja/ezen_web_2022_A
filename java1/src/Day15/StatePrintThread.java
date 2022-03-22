package Day15;

public class StatePrintThread extends Thread {
	// �ʵ� 
	private Thread targetThread; // ������ ���� 
	// ������
	public StatePrintThread( Thread targetThread) { // �ܺη� ���� ���� �����尴ü�� ���� ����
		this.targetThread = targetThread;
	}
	// ����ó��
	@Override
	public void run() {
		while(true) {
			Thread.State state = targetThread.getState(); // �� ������ ���� ȣ�� 
			System.out.println(" Ÿ�� ������ ���� : " + state);
			// ������ ���� ���� 
			if( state == Thread.State.NEW ) {	// NEW : ������ �������� �� 
				targetThread.start();
			}
			if( state == Thread.State.TERMINATED ) { // TERMINATED : ������ ������� ��
				break;
			}
		}
		// 0.5�ʰ� �Ͻ�����
		try { Thread.sleep(500); } catch( Exception e ) {}
	}
	
	
	
}
