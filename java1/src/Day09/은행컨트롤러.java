package Day09;

import java.util.Random;

public class ������Ʈ�ѷ� { // Ŭ���� 
	
	// �ش� Ŭ������ ���� ���� ��Ʈ�ѷ�
	// M : �� [ ������ ]
	// V : �� [ ����� ]
	// C : ��[M] �� ��[V] ���� ����
	
	// �信�� ��û�ϴ� ����[���] ����
		// 1. ���»��� [ C ]
	public boolean ���»���( String ��й�ȣ , String ������ , int �����ȣ) {
		// 1. �Է¹��� ���� �����´� [ �μ� ] 
			// ���¹�ȣ �ڵ����� 
			Random random = new Random(); // ���� 
			// 4�ڸ� ���� 
			int ���� = random.nextInt(10000); // 0~9999 ���� 
			String ���¹�ȣ = String.format("%04d", ����  );
							// �������� ����
								// %d ���� 
								// %4d ���� 4�ڸ� [ ���� �ڸ��� ������ ����ó�� ]
									//   15 -> 15
								// %04d ���� 4�ڸ� [ ���� �ڸ��� ������ 0 ó�� ] 
									//   15 -> 0015
			// �ߺ�üũ 
			
		// 2. ��üȭ[ �ټ��� ������ �ϳ��� ��ü�� ����� ]
			���� temp = null; // �� ��ü ����
			if( �����ȣ == 1 ) {
				temp = new ��������(���¹�ȣ , ��й�ȣ , ������ , 0 );
			}else if( �����ȣ == 2 ) {
				temp = new ��������(���¹�ȣ , ��й�ȣ , ������ , 0 );
			}else if( �����ȣ == 3 ) {
				temp = new �ϳ�����(���¹�ȣ , ��й�ȣ , ������ , 0 );
			}
		// 3. �迭�� ����
		int i = 0 ; // �ε��� 
		for( ���� temp2 : Day09_6_����������α׷�.���¸���Ʈ) {
			if( temp2 == null ) { // �ش� temp2�� �����̸� 
				Day09_6_����������α׷�.���¸���Ʈ[i] = temp; // ���� �ε����� ���� 
				return true; // true �̸� �����ߴٴ� �ǹ� 
			}
			i++; // �ε��� ����
		}
		return false;  // false �̸� �����ߴٴ� �ǹ�
	}
		// 2. �Ա� [ U ] 
	public boolean �Ա�() { return false; }
		// 3. ��� [ U ] 
	public boolean ���() { return false; }
		// 4. ��ü [ U ] 
	public boolean ��ü() { return false; }
		// 5. �����¸�� [ R ] 
	public boolean ���¸��() { return false; }
		// 6. ���� [ U ]
	public boolean ����() { return false; }
	
	
	
}
