package Day09;

public class Tire { // Ŭ���� ���� 
	// 1. �ʵ�
	public int maxRotation; // �ִ� ȸ����[ ȸ�����ɼ� ]
	public int accumulatedRotation; // ���� ȸ���� 
	public String location; // Ÿ�̾� ��ġ
	// 2. ������ [ ��ü ������ �ʱⰪ(ó����) ]
	public Tire( String location , int maxRotation ) {
				//  Ÿ�̾���ġ , �ִ�ȸ���� 
		this.location = location; // �ܺηκ��� ���޹��� �μ��� ���κ����� ���� 
		this.maxRotation = maxRotation;
	}
	// 3. �޼ҵ� 
	public boolean roll() { // Ÿ�̾� ȸ�� ���� �޼ҵ�
		accumulatedRotation++; // ���� ȸ������ 1 ����  // Ÿ�̾� ȸ��
		if( accumulatedRotation < maxRotation ) {
			// ���࿡ ����ȸ������ �ִ�ȸ�������� ������ [ ���� ���� ] 
			System.out.println(location+" Tire ���� : " + (maxRotation-accumulatedRotation)+"ȸ");
			return true;
		}else { // �ƴϸ� [ ���� ���� ] 
			System.out.println("*** "+location+" Tire ��ũ ***");
			return false;
		}
	}
	
	
}
