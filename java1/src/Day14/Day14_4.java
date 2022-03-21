package Day14;

import java.awt.Toolkit;

public class Day14_4 {
	
	public static void main(String[] args) {
		
		
		// p.576 ��Ƽ������ ����
			// ���μ��� : �ü�������� ���� ���� �ϳ��� ���ø����̼� 
			// �ü���� ���μ����� �ʿ��� �޸� �Ҵ� [ �ڹٿ��� �޸� ����x �ü��(������) o ]
			// �̱� ������ : �ڵ� �о��ִ� �帧 1�� = main�޼ҵ� 
			// ��Ƽ ������ : �ڵ带 �о��ִ� �帧 ������ = main�޼ҵ� �� ������
			// ���� : ����� �����帧������ / �����尡 �ϳ��� ������(�켱���� �ü���� �Ҵ�) ó�� 
				// ������� : �ڵ�1 -> �ڵ�2 -> �ڵ�3 -> �ڵ�4 -> �ڵ�5
			// Thread Ŭ����(���ο����) vs Main�޼ҵ�( ���ν����尡 ���� )
				// 1. Thread Ŭ����
				// 2. Runnable �������̽�
					// 1. ����Ŭ������ implements Runnable
					// 2. run() �޼ҵ� ���� �Ѵ�.
					// 3. �ܺο��� ������ü �����Ѵ�.
					// 4. Thread Ŭ���� ��ü ������ �����ڿ� ������ü �־��ش�.
					// 5. thread Ŭ���� ��ü�� start() �޼ҵ� ����
					// * .start() �޼ҵ�� run() �޼ҵ� ȣ��
					// * run() �޼ҵ�� main������ ������ ���ο� ������ �����

			/*
			 * 		�ڵ�1  	
			 * 
			 * 		�ڵ�2		�ڵ�3
			 * 
			 * 		�ڵ�4		�ڵ�5
			 * 
			 * 		(�۾�������1) (�۾�������2)
			 * 
			 */
		
		// p.581 ����1 
			// * �̱۽�����( main�޼ҵ� ) : ������ �Ʒ��� ����
			// 0.5�� �������� �Ҹ� ���
			// 0.5�� �������� �� ��� 
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // �Ҹ� ���� �޼ҵ� ���� Ŭ����
		// �Ҹ�
		for( int i = 0 ; i<5 ; i++ ) {
			toolkit.beep(); // .beep() : �Ҹ� �޼ҵ�
			try {
				Thread.sleep(500); // ��������(main������)�� 0.5�ʰ� �Ͻ�����
			}catch( Exception e ) {}
		}
		// ��� 
		for( int i = 0 ; i<5 ; i++ ) {
			System.out.println("��");
			try {
				Thread.sleep(500); // 0.5 �Ͻ�����
			}catch( Exception e ) {}
		}
System.out.println("---------------------------------------");		
		// p.582 ����2
			// * ��Ƽ ������( main������ , beepTask��ü )
		// 1. �������̽��� ������ü
		Runnable beepTask = new BeepTask(); 
		// 2. Thread Ŭ���� ��ü ������ �����ڿ� ������ü �ֱ�
		Thread thread = new Thread( beepTask );
		// 3. thread ��ü�� start() �޼ҵ� ȣ��
		thread.start();
		
		// ���
		for( int i = 0 ; i<5 ; i++ ) {
			System.out.println("��");
			try {
				Thread.sleep(500); // 0.5 �Ͻ�����
			}catch( Exception e ) {}
		}
		
		
		
		
		
		
		
		
		
			
		
	}
}








