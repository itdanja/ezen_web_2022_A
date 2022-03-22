package Day15;

public class Day15_5 {
	
	public static void main(String[] args) {
		
		// p.591 동기화
			// 멀티스레드 사용시 동기화 선택 [ 단일스레드 사용시에는 동기화X ]
			// * 여러개 스레드 동일한 메소드 호출 
			// 동시다발적으로 하나의 메소드 호출
		
		// 예1) 동기화가 없을경우 예
			// 2개의 스레드가 동일한 메소드 호출
		// 1. 계산기 객체 생성 
		Calculator 계산기 = new Calculator();
		
		// 2. user1 객체 생성 
		User1 사람1 = new User1();
		// * 계산기 객체를 user1 설정[대입]
		사람1.setCalculator(계산기);
		사람1.start();
		
		// 3. user2 객체 생성 
		User2 사람2 = new User2();
		// * 계산기 객체를 user2 설정[대입]
		사람2.setCalculator(계산기);
		사람2.start();
		
		
	}

}
