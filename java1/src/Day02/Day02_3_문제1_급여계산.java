package Day02;

import java.util.Scanner;

public class Day02_3_문제1_급여계산 {
	
	public static void main(String[] args) {
		
		// 문제1 : 급여 계산
		/*
		 * 	[입력조건]
		 * 		기본급 , 수당
		 * 	[ 조건 ] 
		 * 		실수령액 = 기본급 + 수당 - 세금[기본급10%] 
		 * 	[출력조건] 
		 * 		실수령액 출력 
		 */
		
		// * 입력 -> 저장 -> 계산 -> 출력
		// 1. 입력 객체 만든다. [ 자료형 소문자 , 클래스명 대문자 ]
		Scanner scanner = new Scanner(System.in); // 키보드로부터 데이터를 저장하는 객체!!!!!!!!!!!!!
		
		// 2. 입력받은 값을 변수에 저장한다. [ 입력객체는 입력받을때마다 기존 데이터가 사라짐 ]
		System.out.print("기본급 입력 : ");		
		int 기본급 = scanner.nextInt(); 
												// 입력객체명.nextInt() : int형 데이터 가져오기 
														// 입력객체명.next() : 문자열 데이터 가져오기
		System.out.print("수당 입력 : "); 			
		int 수당 = scanner.nextInt();
		
		// 3. 변수를 연산(계산) 한다
		
		int 세금 = (int)(기본급*0.1); // int*double 후에 int형으로 강제변환(캐스팅) 
		int 실수령액 = 기본급 + 수당 - 세금;  		// 100% : 1   10% : 0.1
		
		// 4. 출력한다.
		System.out.println("회원님의 실수령액 : " + 실수령액 );
						// 		문자열	+	변수명( 변수내 데이터 호출 )
						//  + : 1. 연결연산자 기능 2.더하기 기능
		
		
		
		

		
		
	}

}
