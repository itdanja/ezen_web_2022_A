package Day09;

public class Car { // Ŭ���� ���� 
	
	// 1. �ʵ� [ ���� , ��ü , �������� ]
	Tire frontLeftTire = new Tire("�տ���", 6);
	Tire frontRightTire = new Tire("�տ�����", 2);
	Tire backLeftTire = new Tire("�ڿ���", 3);
	Tire backRightTire = new Tire("�ڿ�����", 4);
//Ŭ������ ��ü�� = new ������( Ÿ�̾���ġ , Ÿ�̾���� );
	
	// 2. ������
	// 3. �޼ҵ�
	int run() { // �ڵ��� ȸ�� [ ��� Ÿ�̾ü�� 1ȸ�� ȸ�� ] �޼ҵ�  
		System.out.println(" �ڵ����� �޸��ϴ�. ");
		if( frontLeftTire.roll() == false ) { stop(); return 1; } // ����=1 [ �տ���Ÿ�̾� ��ũ ]
		// Ÿ�̾ ȸ���� �ߴµ� ����� false �̸� ��ũ
		// true �̸� ���� ����.
		if( frontRightTire.roll() == false ) {stop(); return 2; } // ����=2 [ �տ�����Ÿ�̾� ��ũ ]
		if( backLeftTire.roll() == false ) {stop(); return 3; } // ���� = 3 [ �ڿ���Ÿ�̾� ��ũ ]
		if( backRightTire.roll() == false ) { stop(); return 4; } // ����= 4 [ �ڿ�����Ÿ�̾� ��ũ ] 
		return 0; // ������ 0�̸� ��ũX 
	}
	//
	void stop() {
		System.out.println("[�ڵ����� ����ϴ�.]");
	}

}
