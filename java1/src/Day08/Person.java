package Day08;

public class Person {
	
	// static + final : ��ü���� ���α׷� ���������� ���Ǵ� *��� 
	static final double pi = 3.14;
	// static : ��ü���� ���α׷� ���������� ���Ǵ� *���� 
	static double pi2 = 3.14;
	// final : ��ü������ ���Ǵ� *��� 
	final double pu3 = 3.14;
	
	// 1. �ʵ�
	final String nation = "Korea"; // final ������
	final String ssn; // final ������ 
	String name;
	// 2. ������[ ��ü �ʱ�ȭ ]
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	// 3. �޼ҵ� 

}
