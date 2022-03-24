package Day17;

public class 사람<T> {
	// 필드
	private String name;
	private int age;
	// 생성자
		// 1. 빈생성자
	public 사람() {}
		// 2. 이름을 받는 생성자
	public 사람( String name ) { this.name = name;}
	
	// 메소드 [ get , set ]  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}


