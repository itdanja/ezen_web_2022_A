package Day03;

public class Day03_7_Ȯ�ι��� {
	
	public static void main(String[] args) {
		
		// p.134 Ȯ�ι���
			// 1 :  if  , switch
			// 		for , while , do~while
			// 2. 2 
			// 	 break; : ���� ����� { } Ż�� ( switch , for , while )
			// 3.
//				int sum = 0;
//				for( int i = 0 ; i<=100; i+=3 ) {
//					 sum += i;
//				}
			// 4. ~ 
			// 5.  4x + 5y = 60   [ �� : x�� y�� ���� �ִ� �� ã�� ]
				for( int x = 1 ; x<=10 ; x++ ) {
					// * x�� 1 ���� 10���� 1�� ���� ���� �ݺ�ó�� 
					for( int y = 1 ; y<=10 ; y++ ) {
						if( (4*x) + (5*y) == 60 ) {
							System.out.println(x +" "+ y);
						}
					}
				}
			// 6.
				for( int i = 1 ; i<=5 ; i++ ) {
					// i�� 1���� 5���� 1�������ϸ� ���� �ݺ�ó�� 
					// i = �����ټ� 
					for( int s = 1 ; s<=i ; s++ ) {
						System.out.print("*"); // ����� 
					}
					System.out.println(); // �ٹٲ�ó��
				}
		
	}
}





