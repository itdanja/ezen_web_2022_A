package Day15;

public class ThreadB extends Thread {
	// �ʵ�
	public boolean stop = false; // ���� �÷��� 
	public boolean work = true; // �۾����࿩��(����) �÷���
	
	// ����ó��
	@Override
	public void run() {
		while( !stop ) { // stop�� false�̸� ���ѷ���
			if( work ) { // work�� true �̸� 
				System.out.println(" ThreadB �۾� ����");
			}else { // work�� false �̸� 
				Thread.yield(); // �ٸ������忡�� �纸
			}
		} // while end 
		System.out.println("ThreadB ����");
	} // run end 

}
