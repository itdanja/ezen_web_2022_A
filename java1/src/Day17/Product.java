package Day17;

public class Product< 제네릭타입1 , 제네릭타입2 > {
				//  < 외부로부터 받을 자료형이름 : 아무거나 >
	// 필드
	private 제네릭타입1 kind; // Tv , Car , Integer 
	private 제네릭타입2 model; // String , String , Double

	public static <제네릭타입1> Box<제네릭타입1> boxing(제네릭타입1 kind){
// 메소드를 선언부
// 제근제한자 정적   반환타입=<제네릭타입1> Box<제네릭타입1> boxing:메소드이름( 제네릭타입 )
		
		Box<제네릭타입1> box = new Box<>();
		box.set(kind);
		
		return box;
	}
	
	// set 
	public void setKind(제네릭타입1 kind) {
		this.kind = kind;
	}
	public void setModel(제네릭타입2 model) {
		this.model = model;
	}
	// get
	public 제네릭타입2 getModel() {
		return model;
	}
	public 제네릭타입1 getKind() {
		return kind;
	}

}
