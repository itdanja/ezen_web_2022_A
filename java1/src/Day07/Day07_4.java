package Day07;

public class Day07_4 {
	
	//p.229 : �ܺ�ȣ�� 
	public static void main(String[] args) {
		
		// 1. ***** ��ü ���� ******
		Car2 myCar = new Car2();
		// 2. �ڵ��� �õ� �ɱ� �޼ҵ� ȣ�� 
		myCar.keyTurnOn();//�μ�x��ȯx
		// 3. �ڵ��� ���� �޼ҵ� ȣ�� 
		myCar.run(); // �μ�x��ȯx 
		// 4. ���� ���ǵ� Ȯ�� �޼ҵ� ȣ�� 
		int speed = myCar.getSpeed(); // �μ�x��ȯo
		System.out.println("���� �ӵ� : "+speed+"km/h");
		
		
	}
	

}
