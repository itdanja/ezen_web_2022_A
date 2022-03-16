package Day11;

import java.io.FileInputStream;
import java.util.Scanner;

public class Day11_2 {

	// p.422
		// 컴퓨터의 하드웨어 문제를 에러 [ 실행불가능 ]
		// 사용자의 잘못된 조작 or 개발자의 잘못된 코딩 의 에러의 예외
		// 종류 : 1.일반예외 2.실행예외
			// 일반예외 : 컴파일[실행]전에 예외 검사 [ 개발자에게 강제 예외처리 안내 (실행전) ]
			// 실행예외 : 컴파일[실행]후에 예외 검사 [ 개발자의 경험의 판단해서 예외처리 ]
		// 예외처리
			// 목적 : 에러가 발생하면 프로그램은 종료된다.! [ 안전성문제 ]
			// 만약에 에러가 발생하면 대체 코드가 실행 [ 프로그램이 종료되지 않게 ] 
		// 사용방법
		/*
		 * 	try{
		 * 		// 예외가 발생할것같은 코드 
		 * 	}catch( 예외클래스 객체명 ){
		 * 		// 만약에 예외가 발생하면 실행되는 코드 
		 * 	}
		 */
	public static void main(String[] args) {
		
		// p.423 [NullPointerException]
		try {
			String data = null;
			System.out.println( data.toString() ); // Object클래스 메소드 : toString() : 객체정보출력 
				// 실행전에는 에러 없다.. 실행후에 [ 실행예외 ] 
			// 에러가 발생하는 이유 : null은 메모리 할당이 없기때문에 객체정보출력 불가능
		} // try end 
		catch( NullPointerException 객체명 ) {
			System.out.println(" 예외발생 : "+ 객체명);
		}
		// p.424 [ ArrayIndexOutOfBoundsException ]
		try { // 예외가 발생할것 같은코드 
			String[] 배열 = new String[2]; // String 2개를 저장할수 있는 배열  
			배열[0] = "a" ; 배열[1] = "b"; 배열[2]="c";
		}catch( ArrayIndexOutOfBoundsException e ) {
					// 예외발생한 예외클래스명 객체명 = 객체에 예외 이유가 저장됨
			// 만약에 예외가 발생하면 실행되는코드
			System.out.println(" 예외발생 : " + e );
		}
		
		// p.426 [ NumberFormatException ] 
		try {
			String data1 = "100"; // 문자열
			String data2 = "a100"; // 문자열 
			int value1 = Integer.parseInt( data1 ); // "100" -> 100 
			int value2 = Integer.parseInt( data2 ); // "a100" -> X [ a는 정수로 표현불가능 ]
						// Integer.paeseInt( 문자열 ) ; 문자열 -> 정수
			// 오류 발생 이유 : 문자열내 숫자형식은 변환이 가능하지만 문자열내 문자형식 변환이 불가능
			// 오류가 발생하면 catch 이동 [ 오류 발생 이후 코드 실행x ]
			int result = value1 + value2;  
			System.out.println( data1 +"+"+data2+"="+result);
		}catch( NumberFormatException e ) {
			System.out.println(" 오류 발생 : " + e);
		}
		
		// p.428 
			String 문자열 = "유재석";	// 자바 클래스중 하나 [ 무조건 Object 상속 ]
			Object 슈퍼객체 ;			// 자바 클래스내 최상위 클래스 
			
			슈퍼객체 = 문자열;			//  자식 --> 부모 [ 가능 ] 
			문자열 = (String)슈퍼객체;			//  부모 --> 자식 [ 불가능 ]
				// 강제형변환 
				// 실행중에 형변환
		// 실행 예외처리 판단 
			// * 입출력(사용자 입장) 관련된 코드 [ 무조건 예외처리 ] 
		
	} // main end 
} // class end 













