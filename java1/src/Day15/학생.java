package Day15;

public class �л� extends ��� {
		// �ڽ�Ŭ���� ��� �θ�Ŭ����
	// �ʵ� 
	String �̸�;
	// ������
	public �л�( String �̸� ) { 
		super( �̸� );
	}
	// �޼ҵ�
	@Override // [ �θ�Ŭ������ ������ �޼ҵ尡 ������� ] 
	public void �̸�ȣ��() {
		System.out.println(" *�ڽ�Ŭ�������� ���� ");
		System.out.println( this.�̸� );
		System.out.println( super.�̸� );
		// * ����� ������ ��Ŭ������ ���� �ʵ带
		// �θ�Ŭ������ �����ϸ� ��밡�� 
	}
}
