package Day04;

import java.util.Scanner;

public class Day04_1 {
	public static void main(String[] args) {
		
		// ��� : if , switch
		// �ݺ��� : for[] , while[���ѷ���]
			// 1.�ʱⰪ 2.���ǽ� 3.������ 4.���๮
			// while ����
			//		1.�ʱⰪ;
			//		while( 2.���ǽ� ) {
			//			
			//			4.���๮;
			//			3.������;
			//		}
		// for ��1)
		for( int i = 1 ; i<=10 ; i++ ) {
			//* i�� 1���� 10���ϱ��� 1�������ϸ鼭 ���๮ �ݺ�ó�� => 10������ 
			System.out.print( i + "  ");
			
		} // for end 
		
		System.out.println();
		
		// while ��1)
		int i = 1 ; // 1. �ʱⰪ 
		while( i<=10 ) { // 2. ���ǽ�
			System.out.print( i + "  "); // 4.���๮
			i++; // 3. ������ 
		} // while end 
		
		System.out.println();
		
		// for ��2) 1~100 �����հ�
		int sum = 0;
		for( int j = 1 ; j<=100 ; j++ ) {
			sum += j; // sum = sum + j
		}
		System.out.println(" for 1~100���� ������ : " + sum );
		
		// while ��2) 1~100 �����հ� 
		int j = 1; // 1. �ʱⰪ 
		int sum2 =0;
		while( j<=100 ) { // 2. ���ǽ� [ true�̸� ����o �ƴϸ� ����x]
			sum2 +=j; // 4.���๮;
			j++; // 3.������
		} // while end : j�� 101�϶� ���� 
		
		System.out.println(" while 1~100���� ������ : "+sum2);
		
		// while ��3) ���ѷ��� 
		while(true) { // ���ǽ��� true ���� // true ��� => ���ѷ���
			System.out.println("���ѷ���");
			Scanner scanner = new Scanner(System.in);
			int exit = scanner.nextInt();
			if( exit == 3 )
				break; // ���� ����� �ݺ���Ż�� [ if���� ]
		}
	}
}






