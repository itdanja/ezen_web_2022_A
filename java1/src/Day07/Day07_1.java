package Day07;

public class Day07_1 { // c s
	
	public static void main(String[] args) {
		
		// p.217~218 �޼ҵ� ȣ��(�ҷ�����) ���
			//1. �޼ҵ尡 �����ϴ� Ŭ������ ��ü �ʿ�
			//2. ��ü��.�޼ҵ��() 
				// . : ���ٿ����� ( �ʵ峪 �޼ҵ� ȣ��� )
		 
		// 1. ��ü ����
		Calculator myCalc    =  new Calculator();
		//Ŭ������  ��ü��[�̸�] = �޸��Ҵ� ������();
		
		// 2. �޼ҵ� ȣ��  [ �μ��� ���� ] 
		myCalc.powerOn();
		
		// 3. �޼ҵ� ȣ��  [ �μ�2�� ]
		int result1 = myCalc.plus( 5 , 6 );
			// * plus�޼ҵ忡 5 �� 6 �����Ŀ� 
			// * 11 �̶�� ����� �޾Ƽ� ������ ���� 
		System.out.println("result1 : "+ result1);
		
		// 4. �޼ҵ� ȣ�� [ �μ�2�� ] 
		byte x = 10;
		byte y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println("result2 :"+ result2);
		
		// 5. �޼ҵ� ȣ�� [ �μ�x ] 
		myCalc.powerOff();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
} // c e 
