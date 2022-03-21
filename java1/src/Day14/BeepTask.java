package Day14;

import java.awt.Toolkit;

public class BeepTask implements Runnable{
					// 구현하다 [ Runnable ] 
	// implements 사용시 추상메소드 꼭!!! 구현하기 
		// ctrl+스페이바
	
	@Override
	public void run() { // Runnable 인터페이스내 run메소드 구현하기
		
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // 1.객체생성
		for( int i = 0 ; i<5 ; i++ ) { // 2. 5회 반복 
			toolkit.beep(); // 소리내기 
			try {  // 일반예외가 무조건 발생->예외처리무조건 
				Thread.sleep(500); // 0.5초간 일시정지
			}catch( Exception e ) {}
			
		}
		
	}
	
	
}
