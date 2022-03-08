package Day01;

import java.util.Scanner;

public class Day01_6_문제2 {
	
	
	
	public static void main(String[] args) { // m s 
		
		// 입력 -> 저장 -> 출력 
		// 1. 입력객체 선언
		Scanner scanner = new Scanner(System.in);
		// 2. 입력할 대상 안내 // 3. 입력받은 데이터 다른곳에 저장 [ 왜??? 사라짐 ] 
		System.out.print(" 작성자 : ");	String writer = scanner.next();
		System.out.print(" 내용 : ");	String content = scanner.next();
		System.out.print(" 날짜 : ");	String date = scanner.next();
		// 3. 출력
		System.out.println("-------------- 방문록 -----------------");
		System.out.println("순번\t작성자\t내용\t날짜");
		System.out.println( 1 +"\t"+ writer +"\t"+ content +"\t"+ date );
		System.out.println("-------------------------------------");
		
	} // m e 
	
	
	/*
	문제2 : 하나의 방문록 
	[입력변수]
		1. 작성자 , 내용 , 날짜 
	[출력 예]
		 *  --------------방문록--------------------
		 *  | 순번 | 작성자 | 	내용 	  | 날짜  |
		 *  |  1    | 강호동 | 안녕하세요  | 09-28 |
		 *  ----------------------------------------
	*/
}
