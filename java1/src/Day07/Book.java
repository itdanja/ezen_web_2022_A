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
		System.out.println("ISBN\t������\t�۰�\t�뿩���ɿ���");
		for( Book temp : Day07_5_BookApplication.books) {
			if( temp != null ) { // ������ �����ϸ� 
				if(  temp.brental ) // �ش絵���� �����뿩���ΰ� true �̸� 
					System.out.println( temp.ISBN +"\t"+ temp.bname +"\t" + temp.bwriter +"\t" + "�뿩����");
				else // �ش絵���� �����뿩���ΰ� false 
					System.out.println( temp.ISBN +"\t"+ temp.bname +"\t" + temp.bwriter +"\t" + "�뿩��");
			}
		}
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
		// 1. �Է¹޾� 
		System.out.print(" ISBN : ");	String isbn = Day07_5_BookApplication.scanner.next();
		System.out.print(" ������ : ");	String bname = Day07_5_BookApplication.scanner.next();
		System.out.print(" �۰� : ");	String bwriter = Day07_5_BookApplication.scanner.next();
		//*�ߺ�üũ[isbn]
		for( Book temp : Day07_5_BookApplication.books ) {
			if(  temp !=null && temp.ISBN.equals(isbn) ) {
				System.out.println(" �˸�]] ���� ������� ISBN �Դϴ�. [ ��Ͻ��� ]");
				return; // ������� �޼ҵ� ���� ( ��Ͻ��� )
			}
		}
		// 2. ��üȭ [ �����뿩���� = true , �뿩ȸ��id = null ]
		Book book = new Book(isbn, bname, bwriter, true , null);
		// 3. �迭 ����[�ֱ�]
		int i = 0; // �ݺ�Ƚ�� [ �ε��� ]
		for( Book temp : Day07_5_BookApplication.books ) {
			if(temp == null ) {
				Day07_5_BookApplication.books[i]=book;
				System.out.println(" �˸�]] ��������� �Ǿ����ϴ�. ");
				return; // ������� �޼ҵ� ���� ( ��ϼ��� )
			}
			i++; // �ε�������
		}
	}
		// 6. �������� �޼ҵ�
	void ��������() {
		System.out.println(" ------- �������� ������ -------");
	}
	
}








