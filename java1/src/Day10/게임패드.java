package Day10;

public interface 게임패드 {
	
	// 1. 상수필드
	// 2. 추상메소드 
	public void A버튼();
	public void B버튼();
	public void C버튼();
	// 3. 디폴트메소드
	default void 게임패드종료() {
		System.out.println(" 게임패드 종료 ");
	}
	// 4. 정적메소드 
	static void 충전() {
		System.out.println(" 충전중 ");
	}

}
