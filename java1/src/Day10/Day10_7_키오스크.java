package Day10;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Day10_7_키오스크 {
	// 상속 : 점포 
	// 클래스 : 롯데리아 , 버거킹
	// 인터페이스 : 키오스크  
	// 파일처리 : 제품재고 관리
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); // 입력객체 
		ArrayList<상품> 상품리스트 = new ArrayList<>(); // 리스트선언
		//* 파일입력
		try { // try { } 안에 예외[오류] 발생할것 하는 코드 넣기 ( 예상 )
			FileInputStream inputStream = new FileInputStream("D:/java/롯데리아재고.txt"); // 1. 파일 입력객체 ( 파일경로)
			// ** 파일 읽어오기 [  파일 ---> 스트림(바이트열) ---> 자바 ]
			// 1. 바이트배열 선언 
			byte[] bytes = new byte[1024]; // bit -> byte -> kb -> mb -> gb
			// 2. 읽어와서 배열 저장 
			inputStream.read( bytes );
			// 3. // 바이트열 -> 문자열
			String 파일내용 = new String( bytes );
			 	// [ , : 필드 구분  \n : 객체(상품 구분 )
			String[] 상품목록 = 파일내용.split("\n"); // String 자르기 메소드   split("기준") ;
			
			for( String temp : 상품목록 ) {
				String[] 필드목록 = temp.split(","); //  3조각 
				상품 상품 = new 상품( 필드목록[0] , 
						Integer.parseInt( 필드목록[1])  ,
						Integer.parseInt( 필드목록[2]) );
				// 문자열 --> 정수형 변환 [  Integer.parseInt("문자열") ] // 가격이랑 재고 정수형이기때문에
				// 리스트 저장 
				상품리스트.add(상품);
			}
		}catch( Exception e ) { // catch : 예외 잡기 -> Exception 클래스의 객체에 저장 
		}
		// 점주가 유재석인 롯데리아 키오스크 객체 생성 
		키오스크 롯데리아 = new 롯데리아("유재석" , 상품리스트 );
		
		while(true) {
			롯데리아.제품목록();
			int ch = scanner.nextInt();
			if( ch == -1 ) {
				롯데리아.상품추가();
			}else {
			}
		}
		
	}
}
