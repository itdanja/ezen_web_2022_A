package Day05;

import java.util.Scanner;

public class Day05_3_Ȯ�ι��� {
	
	public static void main(String[] args) {
		
		// p.181
			// 1. 
			// 2. 
			// 3. 2 : ��ü �񱳽� equals �޼ҵ� ��� 
			// 4. 2 : ���̰� ������� �� ���� �Ұ�
			// 5. 3 : boolean �ʱⰪ�� false
			// 6.  3 , 5
			//		{ 1�� } , { 2�� } , { 3�� } => 3
			//		{ 78 83 93 87 88 }  => 5
			// 7.
		
		int max = 0; // �ִ� �����ϴ� ���� 
		int[] array = {1,5,3,8,2}; // ����+�ʱⰪ ���� 
		
		for( int i = 0 ; i<array.length ; i++ ) {
			// *i�� 0 ���� �迭�Ǳ��� ���� 1������ ���� �ݺ�ó��
			if( max < array[i] ) max = array[i];
			//* ���࿡ max���� i��° �ε����� ���� �� ũ�� max�� i��° �� ����
		}
		System.out.println(" max : " + max );
		
			// 8.
		int[][] array2 = { 
				{ 95 , 86 } , 
				{ 83 , 92 , 96 } ,
				{ 78 , 83 , 93 , 87 , 88 } 
		};
		
		int sum = 0;		// �հ�
		double avg = 0.0;	// ��� 
		
		// Ǯ�� 
		int count = 0;		// ������ ���� [ ĭ ���� ] 
			// 2���� �迭�� ��� ������ ȣ�� 
		for( int �� = 0 ; ��<array2.length ; ��++ ) { // * ���� 0���� �迭�� �����[3]�̸����� 1������
			for( int �� = 0 ; ��<array2[��].length ; ��++ ) { // *���� 0���� �迭�� ������[ 2 , 3 , 5 ] �̸����� 1������
				sum += array2[��][��]; // �����հ� 
			}
			count += array2[��].length;	// �������� �����հ� 
		} 
		
		avg = (double)sum / count ;
		
		System.out.println(" sum : " + sum );
		System.out.println(" avg : " + avg );
		
		// 9.
		boolean run = true; // while�� ����ġ ����
		int studentNum = 0;	// �л��� ���� 
		int[] scores = null; // ���� �迭 ���� // �޸� �Ҵ�x
		Scanner scanner = new Scanner(System.in); // �Է°�ü 
		
		// while( true ) {}
		while( run ) { // ���ѷ��� [ �������� : 5�� �Է½� ���� ] 
		
			System.out.println("-------------------------------------------");
			System.out.println("1.�л��� 2.�����Է� 3.��������Ʈ 4.�м� 5.����");
			System.out.println("-------------------------------------------");
			System.out.print("���� : ");
			
			int selectNo = scanner.nextInt();
			
			if( selectNo == 1 ) { // �л��� �Է¹ޱ� 
				System.out.print("�л���>");	studentNum = scanner.nextInt(); // �л��� �Է¹ޱ�
				scores = new int[studentNum]; // �Է¹��� �л��� ��ŭ �迭���� ����
			}
			else if( selectNo == 2 ) { // �л� ���� �Է¹ޱ�
				for( int i = 0 ; i<scores.length; i++ ) { // �迭�� ��� �ε�����ŭ �ݺ�ó��
					System.out.printf(" scores[%d] : " , i ); 
					scores[i] = scanner.nextInt(); // �Է¹޾� i��° �ε����� ���� 
				}
			}
			else if( selectNo == 3 ) { // �л� ���� ����ϱ� 
				for( int i = 0 ; i<scores.length; i++ ) { // �迭�� ��� �ε�����ŭ �ݺ�ó��
					System.out.printf(" scores[%d] : %d \n " , i , scores[i] ); // i��° �ε��� ���
				}
			}
			else if( selectNo == 4 ) {
				int �ְ����� = 0;
				int ���հ� = 0;
				double ������� = 0.0;
				
				for( int i = 0 ; i<scores.length ; i++ ) {
					
					// �ְ����� ���ϱ� 
					if( �ְ����� < scores[i] ) �ְ����� = scores[i]; // i��° �ε����� ������ ���� 
					// �����հ� 
					���հ� += scores[i];
				}
				
				// ������� ���ϱ� 
				������� =  (double)���հ� / scores.length;
				
				System.out.println("�ְ� ���� : " + �ְ����� );
				System.out.println("��� ���� : " + ������� );
			}
			else if( selectNo == 5 ) {
				run = false; // break; // �ݺ��� Ż��
			}
			
		} // while end 
		
		System.out.println(" ���α׷� ���� ");
	} // main end 
} // class end 
