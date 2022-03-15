package Day10;

public class Television implements RemoteControl , Searchable {		
		// 클래스명 implements 인터페이스명 
				// 구현하다 
	private int volume;
	// ctrl+스페이바 
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}
	@Override
	public void setVolume(  int volume ) {
		if( volume > RemoteControl.MAX_VOLUME ) {
			// 리모콘의 최대소음보다 크면  소음을 10으로 대입[제한]
			this.volume = RemoteControl.MAX_VOLUME;
		}else if( volume<RemoteControl.MIN_VOLUME) {
			// 리모콘의 최소소음보다 작으면 소음을 0으로 대입[제한]
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 tv 볼륨 : "+ this.volume);
	}
	@Override
	public void search(String url) {
		System.out.println( url +"을 검색합니다. ");
	}
	
	@Override // 디폴트 메소드도 재정의 가능 
	public void setMute(boolean mute) {
		RemoteControl.super.setMute(mute);
	}
	
	
	
	
	
	
	

}
