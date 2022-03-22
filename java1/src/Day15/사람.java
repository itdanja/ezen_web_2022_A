package Day15;

public class 사람 extends 직업 {
	// 필드 
	String 이름 ;
	// 생성자
	public 사람( String 이름 ) { 
		this.이름 = 이름;
	}
	// 메소드 
	public void 이름호출() {
		System.out.println(" *부모클래스에서 실행 ");
		System.out.println( this.이름 );
	}
}
