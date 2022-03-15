package Day10;

public class 점포 implements 키오스크 { // 슈퍼클래스

	// 1.필드
	public String 주소;
	// 2.생성자
	public 점포() {}
	// 3.메소드
	@Override
	public void 제품목록() {
		System.out.println(" *** 제품목록 *** ");
	}
	@Override
	public void 장바구니() {
		System.out.println(" *** 장바구니 *** ");
	}
	@Override
	public void 결제() {
		System.out.println(" *** 결제 *** ");
	}
	@Override
	public void 상품추가() {
		System.out.println(" *** 상품추가 *** ");
	}
	
}
