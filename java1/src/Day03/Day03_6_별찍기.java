package Day03;

import java.util.Scanner;

public class Day03_6_별찍기 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); // 입력객체
		
		// 별문제1 : 입력받은 수 만큼 * 출력
		System.out.print(" 문제1) 별개수 : "); int s1 = scanner.nextInt();
		for( int i = 1 ; i<=s1 ; i++ ) {
			// *i는 1부터 입력받은 수 까지 i는 1씩증가 하면서 실행문 반복처리
			System.out.print("*");
		}
		
		System.out.println("\n-----------------------------------------");
		
		// 별문제2 : 입력받은 수 만큼 * 출력 [ 단 5개마다 줄바꿈 처리 ]
		System.out.print(" 문제2) 별개수 : "); int s2 = scanner.nextInt();
		for( int i = 1 ; i<=s2 ; i++ ) {
			// *i는 1부터 입력받은 수까지 i는 1씩증가 하면서 실행문 반복처리
			System.out.print("*");
			// 5개마다 줄바꿈 -> 5배수마다 -> 배수찾기 
			if( i%5 == 0 ) System.out.println(); // 줄바꿈처리 
		}
		
		System.out.println("\n-----------------------------------------");
		
		// 별문제3 : 입력받은 줄 수 만큼 출력
		System.out.print("문제3) 줄수 : "); int line3 = scanner.nextInt();
		for( int i = 1 ; i<=line3 ; i++  ) {
			// * i는 1부터 입력받은 줄 수까지 1씩증가
			// 1. 별찍기 
			for( int s = 1 ; s<=i ; s++ ) {
				System.out.print("*");
			}
			// 2. 줄바꿈처리
			System.out.println(); // 줄 바꿈
		}
			// 문제3 순서도 
				// 사용자가 3을 입력했을때 
				// i = 1  i<=3 [true] -> i++
					// s = 1	s<=1 [true] -> * -> s++
					// s = 2 	s<=1 [false] -> for2 반복문종료
				// 줄바꿈
				// i = 2  i<=3 [ true ] -> i++
					// s = 1	s<=2 [true] -> * -> s++
					// s = 2 	s<=2 [true] -> * -> s++
					// s = 3 	s<=2 [false] -> for2 반복문종료 
				// 줄바꿈
				// i = 3  i<=3 [ true ] -> i++
					// s = 1	s<=3 [ true ] -> * -> s++
					// s = 2    s<=3 [ true ] -> * -> s++
					// s = 3 	s<=3 [ true ] -> * -> s++
					// s = 4	s<=3 [ false] -> for2 반복문종료
				// 줄바꿈
				// i = 4  i<=3 [false ] for1 반복문종료
		
		System.out.println("\n-----------------------------------------");
		
		// 별문제4 : 입력받은 줄 수 만큼 출력
		System.out.print("문제3) 줄수 : "); 
		int line4 = scanner.nextInt();
		
		for( int i = 1 ; i<=line4 ; i++ ) {
			// 1.별찍기
			for( int s = 1 ; s<=line4-i+1 ; s++ ) {
				System.out.print("*");
			}
			// 2.줄바꿈
			System.out.println();
		}
		System.out.println("\n-----------------------------------------");
		
		// 별문제5 : 입력받은 줄 수 만큼 출력 
		System.out.print("문제5) 줄수 : "); 
		int line5 = scanner.nextInt();
	
		for( int i = 1 ; i<=line5 ; i++ ) {
			//1.공백찍기
			for( int b = 1 ; b<=line5-i ; b++ ) { 
				System.out.print(" "); // 공백 => 스페이바 
			}
			//2.별찍기
			for( int s = 1 ; s<=i ; s++ ) {
				System.out.print("*");
			}
			//3. 줄바꿈
			System.out.println();
		}
		
		// 별문제6 : 입력받은 줄 수 만큼 출력 
		System.out.print("문제6) 줄수 : "); 
		int line6 = scanner.nextInt();
		
		for( int i =1 ; i<=line6 ; i++ ) {
			// 1. 공백찍기
			for( int b = 1 ; b<=i-1 ; b++ ) {
				System.out.print(" ");
			}
			// 2. 별찍기 
			for( int s = 1 ; s<=line6-i+1; s++ ) {
				System.out.print("*");
			}
			// 3. 줄바꿈
			System.out.println();
		}
		
		// 별문제7~8 : 입력받은 줄 수 만큼 출력 
		System.out.print("문제7) 줄수 : "); 
		int line7 = scanner.nextInt();
		
		for( int i = 1 ; i<=line7 ; i++ ) {
			// 1. 공백찍기
			for( int b= 1 ; b<=line7-i ; b++) {
				System.out.print(" ");
			}
			// 2. 별찍기
			for( int s= 1; s<=i*2-1; s++ ) {
				System.out.print("*");
				// System.out.print(i); // 문제8
			}
			// 3. 줄바꿈
			System.out.println();
		}
		
		// 별문제9
		System.out.print("문제9 정수 입력 : ");	int 문제9 = scanner.nextInt();
		for( int i = 1 ; i<=문제9 ; i++ ) {
			// 공백찍기
			for( int b = 1 ; b<=i-1 ; b++ ) {System.out.print(" ");}
			//별찍기
			for( int s = 1 ; s<= 문제9*2 - (i*2-1) ; s++ ) {System.out.print("*");}
			//줄바꿈
			System.out.println();
		}
		
		// 별문제10
		
		System.out.print("문제10 정수 입력 : ");	int 문제10 = scanner.nextInt();
		for( int i = 1 ; i<=문제10/2 ; i++ ) {
			// 1. 공백찍기
			for( int b= 1 ; b<=문제10/2-i ; b++) {
				System.out.print(" ");
			}
			// 2. 별찍기
			for( int s= 1; s<=i*2-1; s++ ) {
				System.out.print("*");
				// System.out.print(i); // 문제8
			}
			// 3. 줄바꿈
			System.out.println();
		}
		for( int i = 1 ; i<=문제10/2 ; i++ ) {
			// 공백찍기
			for( int b = 1 ; b<=i-1 ; b++ ) {System.out.print(" ");}
			//별찍기
			for( int s = 1 ; s<= 문제10/2*2 - (i*2-1) ; s++ ) {System.out.print("*");}
			//줄바꿈
			System.out.println();
		}
		
		// 별문제11
		System.out.print("문제11 정수 입력 : ");	int 문제11 = scanner.nextInt();
		
		for( int i = 1 ; i<=문제11 ; i++ ) { // i = 행 = 가로 
			for( int j = 1 ; j<=문제11 ; j++ ) { // j = 열 = 세로 
				if( i == j ) System.out.print("*"); // 행 = 열 동일한 경우 별찍기 
				else if( (i+j) == (문제11+1) ) System.out.print("*"); // 행 과 열의 더한값이 최대줄수+1 과 동일한 경우 별찍기
				else System.out.print(" ");
			}
			// 줄바꿈 
			System.out.println();
		}
		
		//별문제12
		
		System.out.print("문제12 정수 입력 : ");	int N = scanner.nextInt();
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
		
	      //별문제13
	      	System.out.print("문제13 정수 입력 : "); 	 int n = scanner.nextInt();
	         
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
























