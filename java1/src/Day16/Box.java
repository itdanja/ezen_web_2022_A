package Day16;

public class Box { // 박스클래스 
	// 필드
	private Object object; // 슈퍼클래스[최상위클래스]
	// 메소드 
	public void set( Object object ) {
		this.object = object;
	}
	public Object get() {
		return object;
	}
}
