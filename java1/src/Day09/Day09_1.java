package Day09;

import java.util.Scanner;

public class Day09_1 {
	
	// p.277 : Ȯ�ι���
		// 1. 3 [ �ϳ��� Ŭ������ ������ ��ü ���� ���� ]
		// 2. 4 [ ���ú��� { } ������ ���� ] 
		// 3. 4 [ �ݵ�ô� x ] 
		// 4. 3 [ Ŭ������ ��� ���� ���� X ]
		// 5. 1 
			// 1. ��ü�� ������x �ν��Ͻ� ������o
			// 2. // this.�����
			//    this.�ʵ��
			//    this.�޼ҵ��
			// 	  this() : �� ������ ȣ�� 
			//	  this( ������ , ������ ) : ������ 
		// 6. void : �޼ҵ尡 ����Ǹ鼭 ��ȯ���� ����!
			// 4. Override : ������ �޼ҵ带 ������
		// 7. 2
		// 8. 2 static : ���� ��� [ �����ڿ����� static ] 
			// ��ü���� Ŭ������ ���� ���� ���� <-------> new ��ü�� ���� 
		// 9.2 final : ��� [ ���� �Ұ� ]
		// 10. 4 [ �� ��Ŭ����, ���ڸ����� ���� ������ �� �ڵ� ���� ] 
		// 11. 3 default : �ش� ��Ű��   / private : �ش� Ŭ���� 
		// 12 (1) �ʵ� (2)������ (3)�޼ҵ� 
			// {} ������ ������ Ȥ�� �޼ҵ� 
			// Ŭ������� �̸��� �����ϸ� ������ 
			// Ŭ������� �̸��� �������� ������ �޼ҵ� 
		// 13
			/*
			 * String name;
			 * String id ;
			 * String password;
			 * int age;
			 */
		// 14.
			/* ������ ����� : Ŭ���� �̸� ����
			 * Member( String name  , String id ) {
			 * 	this.name = name;
			 *  this.id = id ;
			 * }
			 */
		// 15.
			/*  �Ű����� : �μ� : �޼ҵ� ȣ��� �޼ҵ�� ������ ������ 
			 * *** �α��� �޼ҵ� 
			 * boolean login( String id , String password ){
			 * 
			 * 	if( id.equals("hong") && password.equals("12345") ){
			 * 		// ���̵� hong �̸鼭 �н����尡 12345 �̸� true ��ȯ
			 * 		return true;
			 * 	}
			 *  return false;
			 * }
			 * 
			 * *** �α׾ƿ� �޼ҵ� [ ��ȯŸ�� �޼ҵ��( �μ�1 , �μ�2 ) {  }  ]
			 * void logout( String id ) {
			 * 
			 * 	System.out.print("�α׾ƿ� �Ǿ����ϴ�.");
			 * 
			 * }
			 * 
			 */
		// 16.
			/*  ��ü�� ���� �޼ҵ� ȣ�� ���� 
			 * **** ������ �̸����� �޼ҵ带 ���𰡴� [ �� ���� �ٸ� �μ�[�Ű�����] ��� ]
			 * 	void println( int x ) {   // �ܺηκ��� int�� ������ �μ��� �޾� ��� �޼ҵ� 
			 * 		System.out.println(x);
			 * 	}
			 *  void println( boolean x ) {   // �ܺηκ��� boolean�� ������ �μ��� �޾� ��� �޼ҵ� 
			 * 		System.out.println(x);
			 * 	}
			 *  void println( double x ) {   // �ܺηκ��� double�� ������ �μ��� �޾� ��� �޼ҵ� 
			 * 		System.out.println(x);
			 * 	}
			 *  void println( String x ) {   // �ܺηκ��� String�� ������ �μ��� �޾� ��� �޼ҵ� 
			 * 		System.out.println(x);
			 * 	}
			 */
		// 17
			/* **** ��ü�� �������� �ʰ� �޼ҵ带 ȣ���ϴ� ��� 
			 *  static void println( int x ) {   // �ܺηκ��� int�� ������ �μ��� �޾� ��� �޼ҵ� 
			 * 		System.out.println(x);
			 * 	}
			 *  static void println( boolean x ) {   // �ܺηκ��� boolean�� ������ �μ��� �޾� ��� �޼ҵ� 
			 * 		System.out.println(x);
			 * 	}
			 *  static void println( double x ) {   // �ܺηκ��� double�� ������ �μ��� �޾� ��� �޼ҵ� 
			 * 		System.out.println(x);
			 * 	}
			 *  static void println( String x ) {   // �ܺηκ��� String�� ������ �μ��� �޾� ��� �޼ҵ� 
			 * 		System.out.println(x);
			 * 	}
			 */
		// 18.  
		// 19. ����� ��ũ ���α׷� [ 2�� ���� ] ��ü 
	
	public static void main(String[] args) {
		
		Scanner scanner; // ��ü
		Scanner scanner2 = new Scanner(System.in); // �ν��Ͻ�ȭ
		
	}

	
	
	
}









