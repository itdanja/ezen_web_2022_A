package Day08;

public class Day08_1 {
	
	public static void main(String[] args) {
		
		//p.238 : static 
			// �������� 
			// �������� ������ = ���α׷� ���������� ���Ǵ� �޸�[�ʵ�]
		
		// *. Ŭ������ �ʵ�,�޼ҵ�(���) ���ٹ��
			// (static ����� �ƴҶ�) 1. ��ü ���� -> ��ü.���
				// ��ü�� �����ɶ� new �����ڷ� ��ü(�� �������) �޸� �Ҵ�
		Calculator calculator = new Calculator();
		System.out.println(" ��ü�� �̿��� ������� : " + calculator.pi );
			// (static ��� �϶� ) 1. Ŭ������.���
				// Ŭ���� �ε� �ǰ� �޼ҵ念���� static ������ �޸� �Ҵ�  
		System.out.println(" ��ü���� ������� : " + Calculator.pi );
		
		double result = 10 * 10 * Calculator.pi;
								// Ŭ������.����������
		int result2 = Calculator.plus( 10 , 5);
		int result3 = Calculator.minus(10, 5);
		
		System.out.println(" result1 : "+ result);
		System.out.println(" result2 : "+ result2);
		System.out.println(" result3 : "+ result3);
		
		
		
		
		
		
		
		
		
		
		
	}

}
