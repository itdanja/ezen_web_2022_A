package Day10;

public class Book {
	// 1.�ʵ�
	private String ������;
	private String ����;
	// 2.������
	public Book() {}
	
	public Book(String ������, String ����) {
		super();
		this.������ = ������;
		this.���� = ����;
	}
	// 3.�޼ҵ� [ get , set ] 

	public String get������() {
		return ������;
	}

	public void set������(String ������) {
		this.������ = ������;
	}

	public String get����() {
		return ����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}
	

}
