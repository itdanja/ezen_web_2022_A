package Day09;

public class Day09_4 {
	
	public static void main(String[] args) {
		
		// p.296 ~ 297
			// @Override : ������
			// ������ �μ��� ������ �޼ҵ�� �Ұ��� -> �������̵�
			// ���� : ������ �޼ҵ带 ������[����]
		
		int r = 10; // ������ ����
		//1. ����Ŭ������ ��ü ���� 
		Calculator calculator = new Calculator();
		//2. ����Ŭ������ ���� ��ü�� �޼ҵ� ȣ�� 
		System.out.println("������ : " + calculator.areaCircle(r));
		System.out.println();
		
		//1. ����Ŭ������ ��ü ����
		Computer computer = new Computer();
		//2. ����Ŭ������ ���� ��ü�� �޼ҵ� ȣ�� 
		System.out.println("������ : "+computer.areaCircle(r));
		// * ����Ŭ������ ����Ŭ������ �޼ҵ�� �ٸ���.
		
		
	}

}
