package Day12;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Day12_1 {
	
	public static void main(String[] args) throws IOException {

		// p.496  String 클래스 
			// String 문자열 클래스 
				// 1. java.lang 패키지 [ import x ] 소속
				// 2. 객체인데 자동 리터럴[ 객체가 자동 생성 ] 
		String 성명1 = new String( "유재석" ); 	System.out.println( 성명1 );
		String 성명2 = "유재석";					System.out.println( 성명2 );  // 자동 객체 생성
				// 3. 13개의 생성자 [ 문자열 , 바이트열 등 ]
				// 4. 외부[파일,네트워크 등 ]로 받은 데이터는 보통 바이트열
		
		// 바이트 -> 문자  변환 가능 이유
			// 1. 바이트 => +-127 표현 가능 
			// 2. 아스키코드 => 0 or 1 조합된 7자리 => 0101011 => 2의7승 => 128문자 표현가능 
			//  바이트 -> 아스키코드 변환 [ 영문/특수문자 1바이트 , 한글 2바이트 ]
		
			// 기계어 : 0 or 1  
			// 7자리 기계어 : 아스키코드 [ 1000001 => A ]  
			
		//p.497 예제1 
		//1. 여러개 바이트를 저장할수 있는 바이트 배열 선언 
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
					//  H   e   l   l   o 공백  j a   v  a 
					//  0   1   2   3   4  5   6 7   8  9    =>   6,4  => java 
		//2. 바이트 배열 -> 문자열 변환 [    new String( 배열명 ) ]  ;
		String str1 = new String( bytes );
		//3. 확인 
		System.out.println("바이트배열 -> 문자열 변환 : "+ str1 );
		//4. 특정 위치부터 변환 	[   new String( 배열명 , 시작인덱스 , 개수 ) ]
		String str2 = new String( bytes , 6 , 4 );
		//5. 확인
		System.out.println("바이트배열내 6번인덱스부터 4개 변환 : " + str2);
		
		//p.498 예제2
			// System.out : 시스템클래스내 출력필드
			// System.in : 시스템클래스내 입력필드 
		byte[] bytes2 = new byte[100]; // 100개 바이트를 저장할수 있는 배열 
	
		System.out.print("입력 : "); // 출력필드내 print메소드 호출 
		int readByteNo = System.in.read( bytes2 );
			// 외부통신 : 자바프로그램외 [ 키보드 , 파일 , 네트워크 등 ] 입출력 일반예외
		// 키보드 입력 ----스트림[통신:바이트]----->  컴퓨터
		// a -> 97   //   a 엔터 -> 97 , 13[\n:줄바꿈] , 10[\r:커서를앞으로]
		System.out.println("입력받은 바이트 : " + Arrays.toString(bytes2)  );
		
		String str = new String( bytes2 , 0 , readByteNo-2 );
											// 읽은바이트수 - 2 
		System.out.println("입력받은 바이트 -> 문자열 변환 : " + str);
		
		// Scanner 클래스 [ System.in 으로부터 입력받은 바이트를 객체에 저장 ] 
		Scanner scanner = new Scanner(System.in);
		// scanner 클래스 메소드 
		scanner.next(); // 바이트->문자열 변환
		scanner.nextInt(); // 바이트 -> 정수열 변환
		scanner.nextDouble(); // 바이트 -> 실수열 변환
		
	}	
}







