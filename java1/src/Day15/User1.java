package Day15;

public class User1 extends Thread {
	// �ʵ�
	private Calculator calculator;
	// �޼ҵ� 
	public void setCalculator( Calculator calculator) {
		this.setName("user1");
		this.calculator = calculator;
	}
	// ����ó�� 
	@Override
	public void run() {
		calculator.setMemory(100);
	}
	
}
