package Day08;

public class Car {
	// 1. �ʵ�
	private int speed;		// �ܺ�Ŭ�������� ���� �Ұ��� ���� 
	private boolean stop;	
	// 2. ������
	// 3. �޼ҵ� 
	public int getSpeed() { // private �ʵ� ȣ��� ���Ǵ� �޼ҵ� 
		return speed;
	}
	public void setSpeed( int speed ) { // private �ʵ� ����� ���Ǵ� �޼ҵ�
		if( speed < 0 ) { 
			// ���࿡ �μ��� ���� ���ǵ尡 0���� ������
			this.speed = 0; // 0 �Ʒ��� ���� �Ұ����ϰ� 0 ����
			return;
		}else { // 0���� ũ�� 
			this.speed = speed; // �μ��� ���� ���ǵ� ���� 
		}
	}
	public boolean isStop() { // private �ʵ� ȣ��� ���Ǵ� �޼ҵ� 
		return stop;
	}
	
	public void setStop( boolean stop ) { // private �ʵ� ����� ���Ǵ� �޼ҵ� 
		this.stop = stop;
		this.speed = 0;
		
	}
	
	
	
	
	
	
	
	
	
}
