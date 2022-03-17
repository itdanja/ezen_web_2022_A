package Day12;

import java.io.IOException;
import java.util.Arrays;

public class Day12_3_도서검색프로그램 {
	
	public static void main(String[] args) throws IOException {
		
		// 도서 검색 프로그램
			// [조건]
			// 1. 입력받기 [ System.in.read() ]
			// 2. String 배열내 여러 도서가 저장이 되어 있는 조건
				//		String[] 도서목록 = {	
				//			"된다! 네이버 블로그&포스트",
				//			"스프링 부트 실전 활용 마스터",
				//			"Tucker의 Go 언어 프로그래밍",
				//			"혼자 공부하는 C 언어"
				//};
			// 3. 검색기능 , 수정기능 
				// 검색기능 : 특정 문자를 입력받아 도서내 포함된 문자가 있으면 모두 출력 
					// 예시) '언어' 검색 ->  "Tucker의 Go 언어 프로그래밍" / "혼자 공부하는 C 언어" -> 2개 출력
				// 수정기능 : 수정할 도서명의 일부를 입력받아 출력된 도서명중 번호를 선택후 수정기능 적용
					// 예시) '언어' 와 Language 입력 -> 선택된 도서명의 수정할 문자와 새로운 문자 입력받아 ->  수정 완료 
						// 혼자 공부하는 C 언어 ->  혼자 공부하는 C Language 
		
		
		String[] 도서목록 = {   "된다! 네이버 블로그&포스트","스프링 부트 실전 활용 마스터",
				"Tucker의 Go 언어 프로그래밍","혼자 공부하는 C 언어" };
		
		while( true ) {
			System.out.println("1.검색 2.수정");
			byte[] bytes = new byte[100];
			int count =  System.in.read(bytes); // 키보드로부터 [스트림] 바이트를 읽어오기 // 일반예외!!!! [ 예외 떠넘기기 ]
			// 읽어온 바이트개수 
			
			String ch = new String( bytes , 0 , count-2 ); // 바이트배열 --> 문자열 변환 [ -2 = \n\r 제거 ]
			
			if( ch.equals("1") ) { 
				System.out.println(" *** 검색 *** ");
				
			}else if( ch.equals("2") ) {
				System.out.println(" *** 수정 *** ");
				
			}
			
		}
		
		
		
		
		
		
	}

}
