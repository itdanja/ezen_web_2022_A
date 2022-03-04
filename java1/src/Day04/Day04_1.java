package Day04;

import java.util.Scanner;

public class Day04_1 {
	public static void main(String[] args) {
		
		// 제어문 : if , switch
		// 반복문 : for[] , while[무한루프]
			// 1.초기값 2.조건식 3.증감식 4.실행문
			// while 형태
			//		1.초기값;
			//		while( 2.조건식 ) {
			//			
			//			4.실행문;
			//			3.증감식;
			//		}
		// for 예1)
		for( int i = 1 ; i<=10 ; i++ ) {
			//* i는 1부터 10이하까지 1씩증가하면서 실행문 반복처리 => 10번실행 
			System.out.print( i + "  ");
			
		} // for end 
		
		System.out.println();
		
		// while 예1)
		int i = 1 ; // 1. 초기값 
		while( i<=10 ) { // 2. 조건식
			System.out.print( i + "  "); // 4.실행문
			i++; // 3. 증감식 
		} // while end 
		
		System.out.println();
		
		// for 예2) 1~100 누적합계
		int sum = 0;
		for( int j = 1 ; j<=100 ; j++ ) {
			sum += j; // sum = sum + j
		}
		System.out.println(" for 1~100까지 누적합 : " + sum );
		
		// while 예2) 1~100 누적합계 
		int j = 1; // 1. 초기값 
		int sum2 =0;
		while( j<=100 ) { // 2. 조건식 [ true이면 실행o 아니면 실행x]
			sum2 +=j; // 4.실행문;
			j++; // 3.증감식
		} // while end : j가 101일때 종료 
		
		System.out.println(" while 1~100까지 누적합 : "+sum2);
		
		// while 예3) 무한루프 
		while(true) { // 조건식이 true 실행 // true 상수 => 무한루프
			System.out.println("무한루프");
			Scanner scanner = new Scanner(System.in);
			int exit = scanner.nextInt();
			if( exit == 3 )
				break; // 가장 가까운 반복문탈출 [ if제외 ]
		}
	}
}






