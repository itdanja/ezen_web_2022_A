package Day14;

import java.awt.Toolkit;

public class BeepThread extends Thread {
					// 상속 Thread[멀티스레드 클래스]
	// *run메소드 오버라이딩
	@Override
	public void run() { // Thread에 있는 run메소드 재정의[오버라이딩]
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for( int i = 0 ; i<5 ; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			}catch( Exception e ) {}
		}
		
	}
}
