package Day08;

public class Day08_2 {
	
	public static void main(String[] args) {
		
		
		// p.245 : final
			// ������ ��.
			// ������ ����� 
			// ���Ǵ� ��� : 1. �ʵ� ����� 2.�����ڿ��� 
		// 1. ��ü ���� 
		Person p1 = new Person("123123-123123", "���");
		
		// 2. ��ü�� �ʵ� ���� 
		// p1.nation = "USA"; // final �ʵ� �̸� �����Ұ� 
		// p1.ssn ="456456-456456"; // �����Ұ� 
		p1.name = "���缮"; // final �ʵ尡 �ƴѰ�� ���� ���� 
		
		
	}

}
