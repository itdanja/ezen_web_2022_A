package Day15;

public class ThreadA extends Thread {
	// �ʵ�
	public boolean stop = false; // ���� �÷��� 
	public boolean work = true; // �۾����࿩��(����) �÷���
	
	// ����ó��
	@Override
	public void run() {
		while( !stop ) { // stop�� false�̸� ���ѷ���
			if( work ) { // work�� true �̸� 
				System.out.println(" ThreadA �۾� ����");
			}else { // work�� false �̸� 
				Thread.yield(); // �ٸ������忡�� �纸[������ ��ȯ]
			}
		} // while end 
		System.out.println("ThreadA ����");
	} // run end 
}
