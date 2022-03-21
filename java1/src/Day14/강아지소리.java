package Day14;

public class 碍酒瘤家府 extends Thread  {
	// 犁沥狼
	@Override
	public void run() {
		for( int i = 0 ; i<5;i++) {
			System.out.println("港港港"+i);
			try { Thread.sleep(500); }
			catch( Exception e ) {}
		}
	}
}
