package Day14;

public class Movie extends Thread {
	
	static boolean stop = true; // ����/���� ���� ����
	
	public void moviestop( boolean stop) {
		this.stop = stop;
		if( stop ) { System.out.println("�������") ; }
		else { System.out.println("��������");}
	}
	
	@Override
	public void run() {
		while( stop) {
			System.out.println(" ���� ����� ~~~");
			try { Thread.sleep(500); }catch(Exception e) {}
		}
	}

}
