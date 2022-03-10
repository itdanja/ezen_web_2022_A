package Day07;

public class Day07_1 { // c s
	
	public static void main(String[] args) {
		
		// 메소드 호출(불러내는) 방법
			//1. 메소드가 존재하는 클래스의 객체 필요
			//2. 객체명.메소드명() 
				// . : 접근연산자 ( 필드나 메소드 호출시 )
		 
		
		// 1. 객체 선언
		Calculator myCalc    =  new Calculator();
		//클래스명  객체명[이름] = 메모리할당 생성자();
		
		// 2. 메소드 호출 
		myCalc.powerOn();
		
	}
	
} // c e 
