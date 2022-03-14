package Day09;

public class Day09_3 {
	
	public static void main(String[] args) {
		
		// p.294~295 
			// 만일 super() 생략시 자동추가
			// super() : 부모클래스내 빈 생성자 호출 
			// super( 인수1 , 인수2 ) : 부모클래스내 [2개인수] 생성자 호출 
			// super( 인수1 , 인수2 , 인수3 ) : 부모클래스내 [ 3개인수] 생성자 호출 
			
		// 1. 서브클래스로 객체 생성
		Student student = new Student("홍길동", "123456-123456", 1);
		// 2. 서브클래스로 만든 객체로 슈퍼클래스내 멤버 접근 
		System.out.println(" name : "+student.name);
		System.out.println(" ssn : "+student.ssn );
		// 3. 
		System.out.println(" studnetNo : "+student.studnetNo);
		
		
		
	}

}
