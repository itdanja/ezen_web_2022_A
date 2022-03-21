package Day14;

public class È£¶ûÀÌ¼Ò¸® extends Thread {
	
	@Override
	public void run() {
		for( int i = 0 ; i<5;i++) {
			System.out.println("À¸¸£··"+i);
			try { Thread.sleep(500); }
			catch( Exception e ) {}
		}
		
	}
	

}
