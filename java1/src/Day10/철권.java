package Day10;

public class 철권 implements 게임패드 {
	// 게임 클래스에 게임패드 인터페이스 연결 
		// * 추상메소드 구현 
		// 버튼에 대한 기능 구현 
	@Override
	public void A버튼() {
		System.out.println(" 공격 ");
	}
	@Override
	public void B버튼() {
		System.out.println(" 방어 ");
	}
	@Override
	public void C버튼() {
		System.out.println(" 교체 ");
	}
	
}
