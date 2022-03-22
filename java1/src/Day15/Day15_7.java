package Day15;

import java.awt.Toolkit;

public class Day15_7 {
	
	public static void main(String[] args) {
		
		
		// p601. 스레드 제어 
			// 1. Thread.sleep( 밀리초 ) : 주어진 시간동안 일시 정지
					// 시간 단위 : 밀리초( 1000/1초 )
					// 일반 예외 발생 : 일시정지상태에서 주어진 시간이 되기전에 실행대기[종료] 되었을때 미리 처리코드
			// 2. Thread.yield() : 다른 스레드에게 실행 양보 [ 대기상태 ]
			// 3. Thread.join() : 다른 스레드의 종료를 기다림 [ 다른 스레드가 끝날때까지 기다림 ]
		
		// p.602. sleep 예제 
//		Toolkit toolkit = Toolkit.getDefaultToolkit(); // 소리 관련 클래스 
//		for( int i = 0 ; i<10 ; i++ ) { // 10번 반복
//			toolkit.beep(); // 소리내기 [ 소리가 1번 작동중에 for문 끝남 ]
//			
//			try{ Thread.sleep(3000); } // 현 스레드 3초간 일시정지
//			catch( Exception e ) {}
//		}
		
		// p.604~606 yield()
		
//		ThreadA threadA = new ThreadA(); // 1. 객체 생성 
//		ThreadB threadB = new ThreadB(); // 2. 객체 생성 
//		threadA.start(); // 3. 스레드 시작
//		threadB.start();
//		
//		// 4. 스레드 3초간 일시정지
//		try { Thread.sleep(3000);}
//		catch( Exception e ) {}
//		// 5. 스레드A에 work 값 변경 [ 해당 스레드 일시정지 ]
//		threadA.work = false; // -> Thread.yield(); 
//		
//		// 4. 스레드 3초간 일시정지
//		try { Thread.sleep(3000);}
//		catch( Exception e ) {}
//		// 5. 스레드A에 work 값 변경 [ 해당 스레드 일시정지 풀기 ]
//		threadA.work = true;
//		
//		// 4. 스레드 3초간 일시정지
//		try { Thread.sleep(3000);}
//		catch( Exception e ) {}
//		// 6. 스레드A , 스레드B 종료 
//		threadA.stop = true;
//		threadB.stop = true;
//		// 7.
//		threadA.stop(); // 권장하지 않는 메소드 [ 스레드의 안정성X ] 
		
		
		// p.607 : join()
		// 1. 객체 생성 
		SumThread sumThread = new SumThread();
		// 2. 스레드 실행 
		sumThread.start();
		
		try { // 3. main스레드와 sumThread스레드 join -> 하나의 스레드
			sumThread.join(); // 일반 예외처리 발생
		}catch( Exception e ) {}
		
		// 4. 
		System.out.println(" 1~100 합 : " + sumThread.getsum() );
		// * main 스레드가 join 안했을때 : 0
			// SumThread가 더하기를 끝나기전에 main스레드 sum 출력
		// * main 스레드가 join 했을때 : 5050
			
		
	}
}





















