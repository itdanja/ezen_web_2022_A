package Day07;

public class Day07_1 { // c s
	
	public static void main(String[] args) {
		
		// p.217~218 메소드 호출(불러내는) 방법
			//1. 메소드가 존재하는 클래스의 객체 필요
			//2. 객체명.메소드명() 
				// . : 접근연산자 ( 필드나 메소드 호출시 )
		 
		// 1. 객체 선언
		Calculator myCalc    =  new Calculator();
		//클래스명  객체명[이름] = 메모리할당 생성자();
		
		// 2. 메소드 호출  [ 인수가 없다 ] 
		myCalc.powerOn();
		
		// 3. 메소드 호출  [ 인수2개 ]
		int result1 = myCalc.plus( 5 , 6 );
			// * plus메소드에 5 와 6 전달후에 
			// * 11 이라는 결과값 받아서 변수에 저장 
		System.out.println("result1 : "+ result1);
		
		// 4. 메소드 호출 [ 인수2개 ] 
		byte x = 10;
		byte y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println("result2 :"+ result2);
		
		// 5. 메소드 호출 [ 인수x ] 
		myCalc.powerOff();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
} // c e 
