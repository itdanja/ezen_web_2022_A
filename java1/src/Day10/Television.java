package Day10;

public class Television implements RemoteControl , Searchable {		
		// Ŭ������ implements �������̽��� 
				// �����ϴ� 
	private int volume;
	// ctrl+�����̹� 
	@Override
	public void turnOn() {
		System.out.println("TV�� �մϴ�.");
	}
	@Override
	public void turnOff() {
		System.out.println("TV�� ���ϴ�.");
	}
	@Override
	public void setVolume(  int volume ) {
		if( volume > RemoteControl.MAX_VOLUME ) {
			// �������� �ִ�������� ũ��  ������ 10���� ����[����]
			this.volume = RemoteControl.MAX_VOLUME;
		}else if( volume<RemoteControl.MIN_VOLUME) {
			// �������� �ּҼ������� ������ ������ 0���� ����[����]
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("���� tv ���� : "+ this.volume);
	}
	@Override
	public void search(String url) {
		System.out.println( url +"�� �˻��մϴ�. ");
	}
	
	@Override // ����Ʈ �޼ҵ嵵 ������ ���� 
	public void setMute(boolean mute) {
		RemoteControl.super.setMute(mute);
	}
	
	
	
	
	
	
	

}
