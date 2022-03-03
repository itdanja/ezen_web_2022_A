package Day03;

import java.util.Scanner;

public class Day03_2_문제1_문제5 { // cs
	
	public static void main(String[] args) { // ms
		
		// 입력객체 = { } 당 1번 선언 
		Scanner scanner = new Scanner(System.in);
		
		// 문제1 : 2개의 정수를 입력받아서 더 큰수 출력 
		System.out.print("정수1입력: "); 
		int 정수1 = scanner.nextInt(); // int형 변수 선언 하고 입력받은 데이터 을 정수로 가져와서 대입
		System.out.print("정수2입력: ");
		int 정수2 = scanner.nextInt();	
		
		// 제어
		if( 정수1 > 정수2 )		System.out.println(" 더 큰수 : " + 정수1);
		// 만약에 입력받은 정수1변수가 정수2변수 보다 크면 실행 아니면 다음 조건 
		else if( 정수1 < 정수2 ) 	System.out.println(" 더 큰수 : " + 정수2);
		// [다음조건] 정수1변수가 정수2 보다 작으면 실행 아니면 그외
		else 					System.out.println(" 같다 ");
		// 나머지[그외] 실행 
		
		// 문제2 : 3개의 정수를 입력받아서 가장 큰수 출력 
		System.out.print("정수1입력: ");  int 정수3 = scanner.nextInt(); // 변수명 중복x 
		System.out.print("정수2입력: ");  int 정수4 = scanner.nextInt();
		System.out.print("정수3입력: ");  int 정수5 = scanner.nextInt();
		int max = 정수3;	// 가장 큰수를 저장하는 임시 저장  // max에 첫번째 값 넣어두기 . 
		if( max < 정수4 ) {  max = 정수4;}  	// 만약에 max 보다 정수4가 더 크면 max 교체 
		if( max < 정수5 ) { max = 정수5; }		// 만약에 max 보다 정수5가 더 크면 max 교체 
		System.out.println(" 가장 큰수 : " + max );
			
		// 문제3 : 4개의 정수를 입력받아서 가장 큰수 출력 
		System.out.print("정수1입력: ");  int 정수6 = scanner.nextInt(); // 변수명 중복x 
		System.out.print("정수2입력: ");  int 정수7 = scanner.nextInt();
		System.out.print("정수3입력: ");  int 정수8 = scanner.nextInt();
		System.out.print("정수4입력: ");  int 정수9 = scanner.nextInt();
		int max2 = 정수6;
		if( max2 < 정수7 ) { max2 = 정수7; }
		if( max2 < 정수8 ) { max2 = 정수8; }
		if( max2 < 정수9 ) { max2 = 정수9; }
		System.out.println(" 가장 큰수 : " + max2 );
		
		// 문제4 : 3개의 정수를 입력받아서 오름차순 / 내림차순 
		System.out.print("정수1입력: ");  int 정수10 = scanner.nextInt(); // 변수명 중복x 
		System.out.print("정수2입력: ");  int 정수11 = scanner.nextInt();
		System.out.print("정수3입력: ");  int 정수12 = scanner.nextInt();
		
		if( 정수10 > 정수11 ) {		//  > : 오름차순   < : 내림차순
			// 교체[ 스왑 = 두개 변수에 데이터 교화방법  ]
			int temp = 정수10; 	// 임시변수 = 변수1 ;
			정수10 = 정수11;		// 변수1 = 변수2 ;
			정수11 = temp;		// 변수2 = 임시변수;
		}
		if( 정수10 > 정수12 ) { int temp = 정수10; 정수10 = 정수12; 정수12= temp; }
		if( 정수11 > 정수12 ) { int temp = 정수11; 정수11 = 정수12; 정수12 = temp; }
		System.out.printf(" 입력한 값 오름차순 : %d  %d  %d " , 정수10 , 정수11 , 정수12 );
		System.out.println(" 입력한 값 오름차순 : " + 정수10 +" "+ 정수11 +" "+ 정수12 );
		
		// 문제5 : 4개의 정수를 입력받아서 오름차순 / 내림차순 
		System.out.print("정수1입력: ");  int 정수13 = scanner.nextInt(); // 변수명 중복x 
		System.out.print("정수2입력: ");  int 정수14 = scanner.nextInt();
		System.out.print("정수3입력: ");  int 정수15 = scanner.nextInt();
		System.out.print("정수4입력: ");  int 정수16 = scanner.nextInt();
		
		// 첫번째 값 기준 으로 비교 
		if( 정수13 > 정수14 ) { int temp = 정수13 ; 정수13 = 정수14; 정수14 = temp; }
		if( 정수13 > 정수15 ) { int temp = 정수13 ; 정수13 = 정수15; 정수15 = temp; }
		if( 정수13 > 정수16 ) { int temp = 정수13 ; 정수13 = 정수16; 정수16 = temp; }
		// 두번째 값 기준 으로 비교 
		if( 정수14 > 정수15 ) { int temp = 정수14 ; 정수14 = 정수15; 정수15 = temp; }
		if( 정수14 > 정수16 ) { int temp = 정수14 ; 정수14 = 정수16; 정수16 = temp; }
		// 세번째 값 기준 으로 비교 
		if( 정수15 > 정수16 ) { int temp = 정수15 ; 정수15 = 정수16; 정수16 = temp; }
		// 네번째 값 기준 으로 비교 x 
		System.out.printf(" 오름차순 : %d %d %d %d " , 정수13 , 정수14 , 정수15 , 정수16 );
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
	}// me

}// ce






