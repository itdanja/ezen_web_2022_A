package Day10;

public class Day10_2 {
	
	public static void main(String[] args) {
		
		// �������̽� [ �߻�޼ҵ� ]
			// ���� : ������ �����Ͽ� ������ ����� ����
				// ���� �ٸ� Ŭ�����鰣�� ��ü���� �����Ѹ������� ���� 
			// �߻� : ����[O] ����[X]
				// �������̽����� �����ϰ� �� Ŭ�������� �����Ѵ�. [ ������ ] 
			// ��)  �������̽� : ����Ű , A��ư , B��ư
			// 		ö�ǰ��� Ŭ����	
					// A��ư : ���� 
					// B��ư : ��� 
			//		�౸���� Ŭ���� 
					// A��ư : ��
					// B��ư : ���
		
		// 1. �������̽� ��ü ���� 
		RemoteControl rc;
		//�������̽���  ��ü��
		// 2. �������̽��� �ڷ�����Ŭ���� �޸� �Ҵ�
		rc = new Television();
		// 3. �������̽� ���� 
		rc.turnOn(); // tv ���� �޼ҵ� 
		rc.turnOff(); // tv ���� �޼ҵ� 
		rc.setVolume(10); // tv ���� ���� �޼ҵ�
		
		System.out.println(" ������ ���� :  TV ---> ����� ��ü");
		
		// 4. �������̽��� �����Ŭ���� �޸� �Ҵ� [ ��ü ]
		rc = new Audio();
		// 5. �������̽� ���� 
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(5);
		
		// **** �͸�����ü : Ŭ�������� �߻�޼ҵ� ���� ****
		RemoteControl rc2 = new RemoteControl() {
			// �������̽��� ��ü�� = new �������̽���
			@Override
			public void turnOn() {
				System.out.println(" ������ �մϴ�.");
			}
			@Override
			public void turnOff() {
				System.out.println(" ������ ���ϴ�.");
			}
			@Override
			public void setVolume(int volume) {
				System.out.println(" ���� ���� : " + volume);
			}
		};
		
		rc2.turnOn();
		rc2.turnOff();
		rc2.setVolume(10);
		
		
		// ����Ʈ �޼ҵ� ȣ��
		rc2.setMute(true); // �������̽����� �̹� �����Ǿ��� �޼ҵ� 
		
		// ���� �޼ҵ� ȣ�� 
		RemoteControl.changeBattery(); // ��ü���� 
		
		// �޸� �Ҵ� �޴� ���
			// �޸� �Ҵ� �ؾߵǴ� ����
				// �ܺ� Ŭ����/�������̽��� �ʵ�(������),�޼ҵ�(������) ����
			// 1. new ������
			// 2. static ������ 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}







