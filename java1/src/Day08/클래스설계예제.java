package Day08;

public class 클래스설계예제 {
			// 회원클래스 
	// 1. 필드 [ private 권장 ] 
	private String id;
	private String password;
	private String name;
	private String point;
	// 2. 생성자
		// 1. *[필드0개]빈생성자[ 메소드 호출용 사용예정 ]
	public 클래스설계예제() {}
		// 2. *[필드4개]풀생성자 [ 모든 회원정보 호출시 사용예정 ]
	public 클래스설계예제(String id, String password, String name, String point) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.point = point;
	}
		// 3. [필드3개]특정 생성자 [ 회원가입시 사용예정 ]
	
	// 3. 메소드
		// private 필드 사용시 get or set 메소드
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}

	

}
