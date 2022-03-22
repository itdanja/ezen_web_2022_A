package Day15;

public class User2 extends Thread {
	// 필드
	private Calculator calculator;
	// 메소드 
	public void setCalculator(Calculator calculator) {
		this.setName("user2");
		this.calculator = calculator;
	}
	// 병렬처리
	@Override
	public void run() {
		calculator.setMemory(50);
	}
}
