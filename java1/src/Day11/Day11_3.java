package Day11;

public class Day11_3 {
	
	//p.422 ���� ������ 
		// ���� : ��� �޼ҵ忡�� try{}catch(){} ���� �ڵ� ������ -> �Ѱ����� ���� �̵�
	
	public static void main(String[] args) {
		
		try {    findclass();   }
		catch( Exception e  ) {  }
		
		try {  withdraw( 30000 );  }
		catch( Exception e ) {  System.out.println( e ); }
	}
	public static void findclass() throws Exception  {
// 		1. ���� ������ [ �޼ҵ��() throws ����Ŭ������ 
		Class clazz = Class.forName("java.lang.String2");
//      2. try ~ catch 
//		try { // ���ܰ� �߻��Ұ� ���� �ڵ�(���࿹��) Ȥ�� �Ϲݿ���[������]
//			Class clazz = Class.forName("java.lang.String2");
//						// Ŭ����ã�� �޼ҵ� 
//		}catch( Exception e) { // ���ܰ� �����ϸ� ����Ǵ� �ڵ� 
//			// Exception : ����Ŭ������ ����Ŭ���� �̹Ƿ� ��� ���ܸ� ���尡�� 
//			System.out.println( e );
//		}
	}
	// p. 444~445 : ���� ����� 
	public static void withdraw( int money ) throws Exception {
		if( 20000  < money) {
			throw new Exception("�ܰ����");
		}
	}
	
	// p.448 Ȯ�ι���
		// 1. 4 [ ���� ����� ���� ] 
		// 2. 3 [ finally {} ������ ����Ǵ� �ڵ� ]
		// 3. 4 [ throws ���� ������ vs throw ���ܸ���� ] 
		// 4. 2 
		// 5. 3 [ ��Ƽ catch ���� : �ڽ�Ŭ���� ���� --> �θ� Ŭ���� ]
		// 6. 10
		//    ���ڷ� ��ȯ�� �� ���� [  �迭�� 2a -> ������ ��ȯx [ �������ĺ�ȯ ���� �߻� ] ]  
		//	  10
		//    �ε����� �ʰ����� 
		//	  10
	
	

	
	
	
	
	
	
	
	
	
}
