package Day07;

public class Book {
	
	// 1. �ʵ�
	String ISBN;	// ISBN [ ������ȣ = �ĺ��� ] 
	String bname;	// ������
	String bwriter;	// �۰�
	boolean brental;// �����뿩����
	String mid;		// �뿩��ID
	
	// 2. ������
		// 1. �������[�⺻������] : �޼ҵ�ȣ���   ( ctrl+�����̹�)
	public Book() {}
		// 2. Ǯ������[����ʵ�޴»�����] : �������
	public Book(String iSBN, String bname, String bwriter, boolean brental, String mid) {
		ISBN = iSBN;
		this.bname = bname;
		this.bwriter = bwriter;
		this.brental = brental;
		this.mid = mid;
	}
	// 3. �޼ҵ� 
		// 1. �����˻� �޼ҵ�
	void �����˻�() { 
		System.out.println(" ------- �����˻� ������ -------");
	}
		// 2. ������� �޼ҵ�
	void �������() {
		System.out.println(" ------- ������� ������ -------");
	}
		// 3. �����뿩 �޼ҵ�
	void �����뿩() {
		System.out.println(" ------- �����뿩 ������ -------");
	}
		// 4. �����ݳ� �޼ҵ�
	void �����ݳ�() {
		System.out.println(" ------- �����ݳ� ������ -------");
	}
		// 5. ������� �޼ҵ�
	void �������() {
		System.out.println(" ------- ������� ������ -------");
	}
		// 6. �������� �޼ҵ�
	void ��������() {
		System.out.println(" ------- �������� ������ -------");
	}
	
}
