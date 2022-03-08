package Day03;

import java.util.Scanner;

public class Day03_6_����� {
	
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
		
		// ������9
		System.out.print("����9 ���� �Է� : ");	int ����9 = scanner.nextInt();
		for( int i = 1 ; i<=����9 ; i++ ) {
			// �������
			for( int b = 1 ; b<=i-1 ; b++ ) {System.out.print(" ");}
			//�����
			for( int s = 1 ; s<= ����9*2 - (i*2-1) ; s++ ) {System.out.print("*");}
			//�ٹٲ�
			System.out.println();
		}
		
		// ������10
		
		System.out.print("����10 ���� �Է� : ");	int ����10 = scanner.nextInt();
		for( int i = 1 ; i<=����10/2 ; i++ ) {
			// 1. �������
			for( int b= 1 ; b<=����10/2-i ; b++) {
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
		for( int i = 1 ; i<=����10/2 ; i++ ) {
			// �������
			for( int b = 1 ; b<=i-1 ; b++ ) {System.out.print(" ");}
			//�����
			for( int s = 1 ; s<= ����10/2*2 - (i*2-1) ; s++ ) {System.out.print("*");}
			//�ٹٲ�
			System.out.println();
		}
		
		// ������11
		System.out.print("����11 ���� �Է� : ");	int ����11 = scanner.nextInt();
		
		for( int i = 1 ; i<=����11 ; i++ ) { // i = �� = ���� 
			for( int j = 1 ; j<=����11 ; j++ ) { // j = �� = ���� 
				if( i == j ) System.out.print("*"); // �� = �� ������ ��� ����� 
				else if( (i+j) == (����11+1) ) System.out.print("*"); // �� �� ���� ���Ѱ��� �ִ��ټ�+1 �� ������ ��� �����
				else System.out.print(" ");
			}
			// �ٹٲ� 
			System.out.println();
		}
		
		//������12
		
		System.out.print("����12 ���� �Է� : ");	int N = scanner.nextInt();
	      int col = 0;
	      int space = 2;
	      
	      for(int i=1; i<=N; i++) {
	         for(int j=0; j<i; j++)
	            System.out.print("*");
	         
	         for(int j=(i-1)*2; j<(N*2)-2; j++)
	            System.out.print(" ");
	         for(int j=0; j<i; j++)
	            System.out.print("*");
	         
	         System.out.println();
	      }
	      
	      for(int i=N; i<(N*2)-1; i++) {
	         for(int j=col; j<N-1; j++)
	            System.out.print("*");
	         
	         for(int j=0; j<space; j++)
	            System.out.print(" ");
	         
	         for(int j=col; j<N-1; j++)
	            System.out.print("*");
	         
	         System.out.println();
	         col ++;
	         space += 2;
	      }
		
	      //������13
	      	System.out.print("����13 ���� �Է� : "); 	 int n = scanner.nextInt();
	         
	        String map[] = new String[n];
	        map[0] = "  *  ";
	        map[1] = " * * ";
	        map[2] = "*****";
	         
	        for (int k = 1; 3 * (int)Math.pow(2, k) <= n; ++k) {
	        	
	        	 int bottom = 3 * (int)Math.pow(2, k);
	             int middle = bottom / 2;
	              
	             for (int i = middle; i < bottom; ++i) {
	                 map[i] = map[i - middle] + " " + map[i -middle];
	             }
	              
	             String space2 = "";
	             while (space2.length() < middle) {
	                 space2 += " ";
	             }
	             for (int i = 0; i < middle; ++i) {
	                 map[i] = space2 + map[i] + space2;
	             }
	            
	        }
	         
	        for (int i = 0; i < n; ++i) {
	            System.out.println(map[i]);
	        }
	      
	      
	}
}
























