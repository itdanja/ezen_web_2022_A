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
	}
}






