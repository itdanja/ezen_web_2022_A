package Day09;

public class ���� {
	
	// 1. �ʵ�
	private String ���¹�ȣ;	// ���¹�ȣ[�ߺ�x=�ĺ�]
	private String ��й�ȣ;	// ��й�ȣ
	private String ������;	// ������ 
	private int ���ݾ�;	// ���ݾ� 
	// 2. ������
		// 1. �� ������
	public ����() {} 
		// 2. ����ʵ� ������
	public ����(String ���¹�ȣ, String ��й�ȣ, String ������, int ���ݾ�) {
		super();
		this.���¹�ȣ = ���¹�ȣ;
		this.��й�ȣ = ��й�ȣ;
		this.������ = ������;
		this.���ݾ� = ���ݾ�;
	}
	// 3. �޼ҵ� //get , set �޼ҵ� [ �ʵ尡 private �ΰ��]
	public String get���¹�ȣ() {
		return ���¹�ȣ;
	}
	public void set���¹�ȣ(String ���¹�ȣ) {
		this.���¹�ȣ = ���¹�ȣ;
	}
	public String get��й�ȣ() {
		return ��й�ȣ;
	}
	public void set��й�ȣ(String ��й�ȣ) {
		this.��й�ȣ = ��й�ȣ;
	}
	public String get������() {
		return ������;
	}
	public void set������(String ������) {
		this.������ = ������;
	}
	public int get���ݾ�() {
		return ���ݾ�;
	}
	public void set���ݾ�(int ���ݾ�) {
		this.���ݾ� = ���ݾ�;
	}

	

}
