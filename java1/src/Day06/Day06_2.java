package Day06;

public class Day06_2 {
	
	public static void main(String[] args) {
		
		// 1. Ŭ���� ������ -> ��ü ���� 
		Car myCar = new Car(); // ��ü ���� 
			// 1. Car : ���ǵ� Ŭ������
			// 2. myCar : ��ü�̸�[ �ƹ��ų� ]
			// 3. new : �޸� �Ҵ� ������ 
			// 4. Car() : ������?????
		
		// 2. ��ü�� �ʵ� ȣ�� [ . : ���ٿ�����( ��ü�� �������) ]
		System.out.println("����ȸ�� : " + myCar.company);
			// myCar ��ü�� �ʵ� ���� 
			// ��ü�̸�.����̸�
		System.out.println("�𵨸� : " + myCar.model ); // myCar.model : model �ʵ� ȣ�� 
		System.out.println("���� : " + myCar.color ); // myCar.color : color �ʵ� ȣ�� 
		System.out.println("�ְ�ӵ� : " + myCar.maxSpeed ); // myCar.maxSpeen : maxSpeed �ʵ� ȣ�� 
		System.out.println("����ӵ� : " + myCar.speed ); // myCar.speed : speed �ʵ� ȣ�� 
		// 3. ��ü�� �ʵ� �� ���� 
		myCar.speed = 60;
			// myCar ��ä�� speed �ʵ� ȣ���ؼ� 60�̶�� ������ ���� 
		System.out.println("������ �ӵ� : " + myCar.speed );
		
		// ���ο� �ڵ��� ��ü ����
		Car yourcar = new Car();
		System.out.println(" 2�� �ڵ��� : " + yourcar.speed );
		
	}
}
