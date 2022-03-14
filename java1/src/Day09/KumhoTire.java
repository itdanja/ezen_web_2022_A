package Day09;

public class KumhoTire extends Tire {
			// 서브클래스 extends 슈퍼클래스 
	// 1. 필드
	// 2. 생성자
	public KumhoTire( String location , int maxRotation) {
		super(location, maxRotation);
		// 슈퍼클래스내 생성자[ 코드 줄이기 ]
	}
	// 3. 메소드 
	@Override
	public boolean roll() {
		accumulatedRotation++;
		if( accumulatedRotation < maxRotation ) {
			System.out.println(location+" 금호타이어 수명 : " 
						+ (maxRotation-accumulatedRotation));
			return true;
		}else {
			System.out.println("*** " + location+" 금호타이어 펑크 ***");
			return false;
		}
	}

}
