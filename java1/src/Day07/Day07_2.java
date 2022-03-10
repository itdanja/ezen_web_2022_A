package Day07;

public class Day07_2 {
	
	public static void main(String[] args) {
		
		// p.223~224 : 리턴값이 없는 메소드 (void)
		
		// 1. 객체 선언[ 빈생성자=기본생성자]
		Car mycar = new Car();
		// 2. 메소드 호출 [ 인수1개 = 5 ]
		mycar.setGas(5);
		
		// 3. 메소드 호출 [ 인수x 반환=true혹은false]
		if( mycar.isLeftGas() ) {
			System.out.println("출발합니다");
			// 4. 메소드 호출 [ 인수x ]
			mycar.run();
		}
		
		// 5.메소드호출
		if( mycar.isLeftGas() ) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		}else {
			System.out.println("gas를 주입하세요.");
		}
		
		
		
		
		
			
		
		
		
		
		
	}
}
