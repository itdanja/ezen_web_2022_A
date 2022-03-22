package Day15;

public class ThreadA extends Thread {
	// 필드
	public boolean stop = false; // 종료 플래그 
	public boolean work = true; // 작업진행여부(상태) 플래그
	
	// 병렬처리
	@Override
	public void run() {
		while( !stop ) { // stop이 false이면 무한루프
			if( work ) { // work가 true 이면 
				System.out.println(" ThreadA 작업 내용");
			}else { // work가 false 이면 
				Thread.yield(); // 다른스레드에게 양보[대기상태 변환]
			}
		} // while end 
		System.out.println("ThreadA 종료");
	} // run end 
}
