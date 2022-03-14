package Day09;

public class Student extends People {
			// 서브클래스 extends 슈퍼클래스
	// 1. 필드
	public int studnetNo; // 학생번호
	// 2. 생성자
	public Student( String name , 
			String ssn , 
			int studentNo ) {
		// 부모클래스내 멤버 필드 초기화[값넣기]
		// 1. 필드에 접근
			// this.name = name;
			// this.ssn = ssn;
		// 2. 생성자에 접근
		super(name, ssn);
		this.studnetNo = studentNo;
	}
	// 3. 메소드 

}
