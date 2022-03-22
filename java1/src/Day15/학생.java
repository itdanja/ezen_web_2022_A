package Day15;

public class 학생 extends 사람 {
		// 자식클래스 상속 부모클래스
	// 필드 
	String 이름;
	// 생성자
	public 학생( String 이름 ) { 
		super( 이름 );
	}
	// 메소드
	@Override // [ 부모클래스내 동일한 메소드가 있을경우 ] 
	public void 이름호출() {
		System.out.println(" *자식클래스에서 실행 ");
		System.out.println( this.이름 );
		System.out.println( super.이름 );
		// * 상속을 받으면 현클래스에 없는 필드를
		// 부모클래스내 존재하면 사용가능 
	}
}
