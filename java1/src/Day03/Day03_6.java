package Day03;

import java.util.Scanner;

public class Day03_6 {
	
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
	}
}






