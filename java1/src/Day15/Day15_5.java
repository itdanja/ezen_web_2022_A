package Day15;

public class Day15_5 {
	
	public static void main(String[] args) {
		
		// p.591 ����ȭ
			// ��Ƽ������ ���� ����ȭ ���� [ ���Ͻ����� ���ÿ��� ����ȭX ]
			// * ������ ������ ������ �޼ҵ� ȣ�� 
			// ���ôٹ������� �ϳ��� �޼ҵ� ȣ��
		
		// ��1) ����ȭ�� ������� ��
			// 2���� �����尡 ������ �޼ҵ� ȣ��
		// 1. ���� ��ü ���� 
		Calculator ���� = new Calculator();
		
		// 2. user1 ��ü ���� 
		User1 ���1 = new User1();
		// * ���� ��ü�� user1 ����[����]
		���1.setCalculator(����);
		���1.start();
		
		// 3. user2 ��ü ���� 
		User2 ���2 = new User2();
		// * ���� ��ü�� user2 ����[����]
		���2.setCalculator(����);
		���2.start();
		
		
	}

}
