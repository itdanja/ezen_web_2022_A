package Day10;

public class 상품 {
	// 1. 필드
	private String 상품명;
	private int 재고;
	private int 가격;
	// 2. 생성자
	public 상품() {}
	public 상품(String 상품명, int 재고, int 가격) {
		super();
		this.상품명 = 상품명;
		this.재고 = 재고;
		this.가격 = 가격;
	}
	// 3. 메소드 
	public String get상품명() {
		return 상품명;
	}
	public void set상품명(String 상품명) {
		this.상품명 = 상품명;
	}
	public int get재고() {
		return 재고;
	}
	public void set재고(int 재고) {
		this.재고 = 재고;
	}
	public int get가격() {
		return 가격;
	}
	public void set가격(int 가격) {
		this.가격 = 가격;
	}
	

}
