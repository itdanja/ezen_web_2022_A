package Day10;

public interface �����е� {
	
	// 1. ����ʵ�
	// 2. �߻�޼ҵ� 
	public void A��ư();
	public void B��ư();
	public void C��ư();
	// 3. ����Ʈ�޼ҵ�
	default void �����е�����() {
		System.out.println(" �����е� ���� ");
	}
	// 4. �����޼ҵ� 
	static void ����() {
		System.out.println(" ������ ");
	}

}
