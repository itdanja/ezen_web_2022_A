package Day10;

public class Child extends Parent {
				// extends ����Ŭ���� 
	private String name;
	public Child() {
		this("ȫ�浿"); // 
		System.out.println("�ڽ� ������� ����");
	}
	public Child( String name) {
		this.name = name;
		System.out.println("�ڽ� [1���μ�] ������ ����");
	}
	
}
