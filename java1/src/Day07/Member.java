package Day07;

public class Member {
	// 1.�ʵ�
	int mno;		// ȸ����ȣ [ �ڵ���ȣ , �ߺ�x ] 
	String id;		// ���̵� [ �ߺ�x ]
	String password;// ��й�ȣ
	String name;	// �̸�
	String phone;	// ����ó
	
	// 2.������ [ �����ڸ� == Ŭ������ ]
		// 1. �������[�⺻������] : �޼ҵ�ȣ��� ��ü������
	public Member() { }
		// 2. ��� �ʵ带 �޴� ������ : ȸ�����Կ� ��ü������
	public Member(int mno, String id, String password, String name, String phone) {
		this.mno = mno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	// 3.�޼ҵ�
		// 1. ȸ������ �޼ҵ� [ �μ�x ��ȯo : ���Լ���TRUE / ���Խ���FALSE]
	boolean ȸ������() {
		System.out.println(" ----- ȸ������ ������ ------");
		
		return true;
	}
	// 2. �α��� �޼ҵ� [ �μ�x��ȯo : ]
			// �α��μ����� ������ ���̵��ȯ / ���н� NULL ��ȯ
	String �α���() {
		System.out.println(" ----- �α��� ������ ------");
		return "���̵�";
	}
		// 3. ���̵�ã�� �޼ҵ� [ �μ�x��ȯx]
	void ���̵�ã��() {
		System.out.println(" ----- ���̵�ã�� ������ ------");
	}
		// 4. ��й�ã�� �޼ҵ� [ �μ�x��ȯx ]
	void ��й�ȣã��() {
		System.out.println(" ----- ��й�ȣã�� ������ ------");
	}
		// 5. ȸ��Ż�� �޼ҵ� 
		// 6. ȸ������ �޼ҵ� 
	
}







