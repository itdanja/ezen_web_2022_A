package Day11;

public class Day11_3 {
	
	//p.422 예외 던지기 
		// 목적 : 모든 메소드에서 try{}catch(){} 사용시 코드 복잡함 -> 한곳으로 예외 이동
	
	public static void main(String[] args) {
		
		try {    findclass();   }
		catch( Exception e  ) {  }
		
		try {  withdraw( 30000 );  }
		catch( Exception e ) {  System.out.println( e ); }
	}
	public static void findclass() throws Exception  {
// 		1. 예외 던지기 [ 메소드명() throws 예외클래스명 
		Class clazz = Class.forName("java.lang.String2");
//      2. try ~ catch 
//		try { // 예외가 발생할것 같은 코드(실행예외) 혹은 일반예외[무조건]
//			Class clazz = Class.forName("java.lang.String2");
//						// 클래스찾기 메소드 
//		}catch( Exception e) { // 예외가 발행하면 실행되는 코드 
//			// Exception : 예외클래스중 슈퍼클래스 이므로 모든 예외를 저장가능 
//			System.out.println( e );
//		}
	}
	// p. 444~445 : 예외 만들기 
	public static void withdraw( int money ) throws Exception {
		if( 20000  < money) {
			throw new Exception("잔고부족");
		}
	}
	
	// p.448 확인문제
		// 1. 4 [ 예외 만들기 가능 ] 
		// 2. 3 [ finally {} 무조건 실행되는 코드 ]
		// 3. 4 [ throws 예외 던지기 vs throw 예외만들기 ] 
		// 4. 2 
		// 5. 3 [ 멀티 catch 순서 : 자식클래스 먼저 --> 부모 클래스 ]
		// 6. 10
		//    숫자로 변환할 수 없음 [  배열내 2a -> 정수형 변환x [ 숫자형식변환 오류 발생 ] ]  
		//	  10
		//    인덱스를 초과했음 
		//	  10
	
	

	
	
	
	
	
	
	
	
	
}
