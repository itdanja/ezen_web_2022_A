package Day10;

public class Day10_2 {
	
	public static void main(String[] args) {
		
		// 인터페이스 [ 추상메소드 ]
			// 목적 : 동일한 목적하에 동일한 기능을 수행
				// 서로 다른 클래스들간의 객체들을 동일한목적으로 조작 
			// 추상 : 선언[O] 정의[X]
				// 인터페이스에서 선언하고 각 클래스들이 구현한다. [ 다형성 ] 
			// 예)  인터페이스 : 방향키 , A버튼 , B버튼
			// 		철권게임 클래스	
					// A버튼 : 공격 
					// B버튼 : 방어 
			//		축구게임 클래스 
					// A버튼 : 슛
					// B버튼 : 방어
		
		// 1. 인터페이스 객체 선언 
		RemoteControl rc;
		//인터페이스명  객체명
		// 2. 인터페이스에 텔레비전클래스 메모리 할당
		rc = new Television();
		// 3. 인터페이스 실행 
		rc.turnOn(); // tv 실행 메소드 
		rc.turnOff(); // tv 종료 메소드 
		rc.setVolume(10); // tv 소음 변경 메소드
		
		System.out.println(" 리모컨 연결 :  TV ---> 오디오 교체");
		
		// 4. 인터페이스내 오디오클래스 메모리 할당 [ 교체 ]
		rc = new Audio();
		// 5. 인터페이스 실행 
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(5);
		
		// **** 익명구현객체 : 클래스없이 추상메소드 정의 ****
		RemoteControl rc2 = new RemoteControl() {
			// 인터페이스명 객체명 = new 인터페이스명
			@Override
			public void turnOn() {
				System.out.println(" 리모콘 켭니다.");
			}
			@Override
			public void turnOff() {
				System.out.println(" 리모콘 끕니다.");
			}
			@Override
			public void setVolume(int volume) {
				System.out.println(" 현재 소음 : " + volume);
			}
		};
		
		rc2.turnOn();
		rc2.turnOff();
		rc2.setVolume(10);
		
		
		// 디폴트 메소드 호출
		rc2.setMute(true); // 인터페이스에서 이미 구현되었는 메소드 
		
		// 정적 메소드 호출 
		RemoteControl.changeBattery(); // 객체없이 
		
		// 메모리 할당 받는 방법
			// 메모리 할당 해야되는 이유
				// 외부 클래스/인터페이스내 필드(저장기능),메소드(저장기능) 사용시
			// 1. new 연산자
			// 2. static 연산자 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}







