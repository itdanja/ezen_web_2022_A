package Day09;

public class HankookTire extends Tire {
			// ����Ŭ���� extends ����Ŭ����
	// 1. �ʵ�
	// 2. ������
	public HankookTire( String location , int maxRotation) {
		super(location, maxRotation);
		// super( �μ�1 , �μ�2) // ����Ŭ������ [�μ�2��] ������ ȣ��
	}
	// 3. �޼ҵ�
		// ctrl+�����̹�
	@Override // ����Ŭ������ �޼ҵ带 ������[����]
	public boolean roll() {
		accumulatedRotation++;
		if( accumulatedRotation < maxRotation ) {
			System.out.println(location+" �ѱ�Ÿ�̾� ���� : " 
						+ (maxRotation-accumulatedRotation));
			return true;
		}else {
			System.out.println("*** " + location+" �ѱ�Ÿ�̾� ��ũ ***");
			return false;
		}
	}
}
