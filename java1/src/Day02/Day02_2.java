package Day02;

public class Day02_2 { // c s

	public static void main(String[] args) { // m s 
		
		// ; : ���� ���� ����
		// ������ �������� ����Ҽ� ����. [ �̸��� �ߺ��Ǹ� ����(���кҰ�)]
		
		// p.40 byte : 1����Ʈ ���� +-128
		byte var1 = -128;	System.out.println( var1 );
		byte var2 = -30;	System.out.println( var2 );
		byte var3 = 30;		System.out.println( var3 );
		// byte var4 = 300;	System.out.println( var4 );
			// ���� �߻� : 128 �̻��� �����Ҽ� ����.
		byte var4 = 'j';	System.out.println( var4 );
			// ���� -> ���� ��ȯ [ �ƽ�Ű�ڵ� ��Ģ ]
		
		// p.43 char : 2����Ʈ [ 1���� ] : �����ڵ�(2����Ʈ:������ ��繮��)  vs  �ƽ�Ű�ڵ�
		char c1 = 'a';		System.out.println( c1 );
		char c2 = 97;		System.out.println( c2 );		// 10���� ǥ�� : 0~9
			// ���� -> ���� ��ȯ
		char c3 = '\u0041';	System.out.println( c3 );		// 16���� ǥ��
		char c4 = '��';		System.out.println( c4 );
		char c5 = 44032;	System.out.println( c5 );
		char c6 = '\uac00';	System.out.println( c6 );
		// ���� [ ��??? : ��ǻ�Ͱ� 2������ ����ϸ� ǥ������ ���� ---> ǥ������ �پ缺 
			// 2���� : 0 , 1   / ����(2���ڵ�)  / �뷮(1��Ʈ)
			// 8���� : 0 ~ 7
			// 10���� : 0 ~ 9 
			// 16���� : 0 ~ 9 a b c d e f 
		
		// p.44	short : 2����Ʈ ���� +-3������ 
		short num1 = 30000;	System.out.println( num1 );
		// short num2 = 40000;	System.out.println( num2 ); // ���� �߻�
		
		// p.45 int : 4����Ʈ ���� +-20�ﵵ ( ���� �⺻Ÿ�� )
		int num2 = 10;		System.out.println( num2 );	 	// 10����
		int num3 = 012;		System.out.println( num3 );  	// 8������ �տ� 0 ���̱� 
		int num4 = 0xA;		System.out.println( num4 ); 	// 16������ �տ� 0x ���̱� 
		
		// p.46 long : 8����Ʈ ���� +-20���̻� [ ������ �ڿ� L ]
		long num5 = 10000000000L;		System.out.println( num5 );
					// INT�� -> long��
		
		// p.47~48 float[ �����͵ڿ� f ] : 4����Ʈ : 8�ڸ� /  double( �Ǽ� �⺻Ÿ�� ) : 8����Ʈ : 17�ڸ�
		double num6 = 3.14;	System.out.println( num6 );
		float num7 = 3.14f;	System.out.println( num7 );
		
		double num8 = 0.1234567890123456789111111111; 	System.out.println( num8 );
		float num9 = 0.123456789012345678911111111f;	System.out.println( num9 );
		
		// p.48 boolean : 1��Ʈ [ true Ȥ�� false ] 
			// ����ġ : on , off 
		boolean bol = true;	System.out.println( bol );	
		
		// p.49 : Ÿ�Ժ�ȯ
			//			-------->>>>>-------- �ڵ�����ȯ ���� --------->>>>
			// * ũ����� : byte -> short -> int -> long -> float -> double
			//			-------<<<<<<-------- ������ ��ȯ ���� ---------<<<<<
		
			// 1. �ڵ� ����ȯ : 
				// ���� ���ڿ��� ū���ڷ� �̵� ���� 
				// ū���ڿ��� ���� ���ڷ� �̵� �Ұ� 
			byte ����Ʈ = 10;
			int ��Ʈ = ����Ʈ;	// �ڵ� ����ȯ o 
			// short ��Ʈ = ��Ʈ; // �ڵ� ����ȯ x  ���� �߻� 
		
			// 2. ���� ����ȯ ( ĳ��Ʈ )
				// ū���ڿ��� ���� ���ڷ� �̵� �����ε�... �� : ������ �ս�
				// (�������ڷ���)������
			short ��Ʈ = (short)��Ʈ;	// int�� ������ short�� ��ȯ�ϴµ� ������ �߸�
			
			
			// p.60 �������� 
				// 1. 4
				// 2. 1 4 5 [ ������ ���ڷ� �����Ҽ� ���� , �����[�̸� ������� �ܾ� ] �Ұ� ] 
				// 3. byte	short	int		long
				//			char
				//					float	double
				//	  boolean
				// 4.  Ÿ�� : int , dobule 
				//		�̸� : age , price 
				//		���ͷ�(��)  : 10 , 3.14
				// 5. : 3
				// 6. : 4    char(����) = String(���ڿ�) [ x ] 
					// �⺻�ڷ���(����Ŭ����) ����� �޸𸮴� ���� 	-> �޸��Ҵ� / new x 
					// Ŭ������ ����� �޸𸮴� ��ü 				-> �޸��Ҵ�	/ new o 
				// 7. : 3 
				// 8. : 1 [ �ڷ��� ����� �⺻Ÿ��(������ ������� int , �Ǽ����� double ���� ��ȯ  ]
					// 1. byte + byte -> int => byte [ x ] 
					// 2. int + byte -> int => int  [ �ڵ�����ȯ ] 
					// 3. int + float -> int => float  [ �ڵ�����ȯ ]  
					// 4. int + double -> int => folat  [ �ڵ�����ȯ ] 
				
			
				
			
				
			
	} // m e 
}//  c e 






