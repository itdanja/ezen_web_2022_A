package Day14;

public class CalcThread extends Thread {
	
	// ������ 
	public CalcThread( String name ) {
		setName(name); // �μ��� ���� �����ͷ� �������̸� ���ϱ� 
	}
	
	// ��Ƽ������ ����  [ �������̵�]
	@Override
	public void run() {
		
		for( int i =0; i<2000000000 ; i++) {
						// 2�� �ݺ� ó�� [ ������ ���ణ ���� ]
		}
		
		System.out.println( "���� �������� ������� : "
							+ getName() );
	}
}
