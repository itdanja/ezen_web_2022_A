package Day09;

public class Computer extends Calculator {
					// ����Ŭ���� extends ����Ŭ����
	// 1. �ʵ�
	// 2. ������
	// 3. �޼ҵ� 
		// * �������̵� [ �θ�Ŭ������ �޼ҵ� ������(����) ]
		// ctrl+�����̹� 
	@Override // ��� �� �θ� ������ �ִ� �޼ҵ� ȣ�� 
	double areaCircle(double r) {
		System.out.println(" Computer ��ü�� areaCircle() ���� ");
		return Math.PI * r * r ;
	}

}
