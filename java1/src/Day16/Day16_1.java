package Day16;

public class Day16_1 {
	
	public static void main(String[] args) {
		
		// ���׸� 
		
		// p.656 �����׸� ��1)
		
		//1. Box ��ü ����
		Box box = new Box();
		//2. ��ü�� �޼ҵ� ȣ��[ �μ� : String ] : Object ���� 
		box.set("ȫ�浿");
		//3. ��ü�� �޼ҵ� ȣ��[ ��ȯ : Object ]
		String name = (String)box.get();
		
		//4.
		box.set( new Apple() ); // [ �μ� : Apple ] : Object 
		Apple apple = (Apple)box.get();
		
			// �ڽİ�ü -> �θ�ü [ �ڵ�����ȯ ]
			// �θ�ü -> �ڽİ�ü [ �ڵ�X ����O ]
		
		
		
	}

}












