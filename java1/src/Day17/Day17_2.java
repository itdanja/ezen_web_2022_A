package Day17;

public class Day17_2 {

	public static void main(String[] args) {
		
		// p.661~662
		// 1. box 객체 생성  [ 제네릭 : Integer ] 
		Box<Integer> box1 = new Box<>();
		// 2. 메소드 호출후 결과값을 객체에 대입 
		box1 = Util.<Integer>boxing(100);
		// 3. 확인
		System.out.println("확인:"+ box1.get() );
		
		// p.662 ~ 663
		// 1. p1 객체를 선언하는데 생성자
		//     에 정수 '1' 과 문자열 '사과' 넣기 
		// 이유 : 제네릭< 정수 , 문자열 >
		Pair<Integer, String > p1 
		= new Pair<Integer, String>(1, "사과");
		
		// 2. P2 객체
		Pair<Integer, String> p2 
		= new Pair<Integer, String>(1, "사과");
		
		// 3. 비교메소드 호출 
		boolean result1 =
				Util.<Integer,String>compare(p1, p2);
		// 4. 결과 제어 
		if( result1 ) {
			System.out.println("*동등한 객체 ");
		}else {
			System.out.println("*동등하지 않는 객체");
		}
		
		//
		Pair< String , String > p3 = new Pair<>("user1","홍길동");
		Pair< String , String > p4 = new Pair<>("user2","홍길동");
		
		boolean result2 = Util.compare(p3, p4);
		if( result2 ) {
			System.out.println("**동등한 객체");
		}else {
			System.out.println("**동등하지 않는 객체");
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}










