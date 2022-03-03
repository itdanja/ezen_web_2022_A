package Day03;

import java.util.Scanner;

public class Day03_6 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); // �Է°�ü
		
		// ������1 : �Է¹��� �� ��ŭ * ���
		System.out.print(" ����1) ������ : "); int s1 = scanner.nextInt();
		for( int i = 1 ; i<=s1 ; i++ ) {
			// *i�� 1���� �Է¹��� �� ���� i�� 1������ �ϸ鼭 ���๮ �ݺ�ó��
			System.out.print("*");
		}
		
		System.out.println("\n-----------------------------------------");
		
		// ������2 : �Է¹��� �� ��ŭ * ��� [ �� 5������ �ٹٲ� ó�� ]
		System.out.print(" ����2) ������ : "); int s2 = scanner.nextInt();
		for( int i = 1 ; i<=s2 ; i++ ) {
			// *i�� 1���� �Է¹��� ������ i�� 1������ �ϸ鼭 ���๮ �ݺ�ó��
			System.out.print("*");
			// 5������ �ٹٲ� -> 5������� -> ���ã�� 
			if( i%5 == 0 ) System.out.println(); // �ٹٲ�ó�� 
		}
		
		System.out.println("\n-----------------------------------------");
		
		// ������3 : �Է¹��� �� �� ��ŭ ���
		System.out.print("����3) �ټ� : "); int line3 = scanner.nextInt();
		for( int i = 1 ; i<=line3 ; i++  ) {
			// * i�� 1���� �Է¹��� �� ������ 1������
			// 1. ����� 
			for( int s = 1 ; s<=i ; s++ ) {
				System.out.print("*");
			}
			// 2. �ٹٲ�ó��
			System.out.println(); // �� �ٲ�
		}
			// ����3 ������ 
				// ����ڰ� 3�� �Է������� 
				// i = 1  i<=3 [true] -> i++
					// s = 1	s<=1 [true] -> * -> s++
					// s = 2 	s<=1 [false] -> for2 �ݺ�������
				// �ٹٲ�
				// i = 2  i<=3 [ true ] -> i++
					// s = 1	s<=2 [true] -> * -> s++
					// s = 2 	s<=2 [true] -> * -> s++
					// s = 3 	s<=2 [false] -> for2 �ݺ������� 
				// �ٹٲ�
				// i = 3  i<=3 [ true ] -> i++
					// s = 1	s<=3 [ true ] -> * -> s++
					// s = 2    s<=3 [ true ] -> * -> s++
					// s = 3 	s<=3 [ true ] -> * -> s++
					// s = 4	s<=3 [ false] -> for2 �ݺ�������
				// �ٹٲ�
				// i = 4  i<=3 [false ] for1 �ݺ�������
		
		System.out.println("\n-----------------------------------------");
		
		// ������4 : �Է¹��� �� �� ��ŭ ���
		System.out.print("����3) �ټ� : "); 
		int line4 = scanner.nextInt();
		
		for( int i = 1 ; i<=line4 ; i++ ) {
			// 1.�����
			for( int s = 1 ; s<=line4-i+1 ; s++ ) {
				System.out.print("*");
			}
			// 2.�ٹٲ�
			System.out.println();
		}
		System.out.println("\n-----------------------------------------");
		
		// ������5 : �Է¹��� �� �� ��ŭ ��� 
		System.out.print("����5) �ټ� : "); 
		int line5 = scanner.nextInt();
	
		for( int i = 1 ; i<=line5 ; i++ ) {
			//1.�������
			for( int b = 1 ; b<=line5-i ; b++ ) { 
				System.out.print(" "); // ���� => �����̹� 
			}
			//2.�����
			for( int s = 1 ; s<=i ; s++ ) {
				System.out.print("*");
			}
			//3. �ٹٲ�
			System.out.println();
		}
		
		// ������6 : �Է¹��� �� �� ��ŭ ��� 
		System.out.print("����6) �ټ� : "); 
		int line6 = scanner.nextInt();
		
		for( int i =1 ; i<=line6 ; i++ ) {
			// 1. �������
			for( int b = 1 ; b<=i-1 ; b++ ) {
				System.out.print(" ");
			}
			// 2. ����� 
			for( int s = 1 ; s<=line6-i+1; s++ ) {
				System.out.print("*");
			}
			// 3. �ٹٲ�
			System.out.println();
		}
		
		// ������7~8 : �Է¹��� �� �� ��ŭ ��� 
		System.out.print("����7) �ټ� : "); 
		int line7 = scanner.nextInt();
		
		for( int i = 1 ; i<=line7 ; i++ ) {
			// 1. �������
			for( int b= 1 ; b<=line7-i ; b++) {
				System.out.print(" ");
			}
			// 2. �����
			for( int s= 1; s<=i*2-1; s++ ) {
				System.out.print("*");
				// System.out.print(i); // ����8
			}
			// 3. �ٹٲ�
			System.out.println();
		}
		
		
	}
}
























