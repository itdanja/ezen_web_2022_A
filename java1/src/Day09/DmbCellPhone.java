package Day09;

public class DmbCellPhone extends CellPhone {
 // ����Ŭ������ ����Ŭ���� ���� => extends ����Ŭ���� 
	// ����Ŭ������ ����Ŭ������ ��� ��밡��
	// 1. �ʵ� 
	int channel;
	// 2. ������
	public DmbCellPhone(String model , 
			String color , 
			int channel ) {
		this.model = model; // this.�ʵ��
		this.color = color; // this.�ʵ��
		// * ���� Ŭ������ ���� �ʵ� �̹Ƿ� ����Ŭ������ ��� ȣ�� 
		this.channel = channel;
	}
	// 3. �޼ҵ� 
	void turnOnDmb() {
		System.out.println("ä�� : "+channel+"�� DMB ��� ������ �����մϴ�.");
	}
	void changeChannelDmb( int channel ) {
		this.channel = channel;
		System.out.println("ä�� : "+channel+"������ �ٲߴϴ�.");
	}
	void turnOffDmb() {
		System.out.println("DMB ��� ������ ����ϴ�.");
	}
	
}




