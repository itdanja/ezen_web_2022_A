package Day14;

import java.awt.Toolkit;

public class Day14_4 {
	
	public static void main(String[] args) {
		
		
		// p.576 멀티스레드 개념
			// 프로세스 : 운영체제에서는 실행 중인 하나의 애플리케이션 
			// 운영체제가 프로세스에 필요한 메모리 할당 [ 자바에서 메모리 관리x 운영체제(윈도우) o ]
			// 싱글 스레드 : 코드 읽어주는 흐름 1개 = main메소드 
			// 멀티 스레드 : 코드를 읽어주는 흐름 여러개 = main메소드 외 여러개
			// 병렬 : 설계상 병렬흐름이지만 / 스레드가 하나씩 순차적(우선순위 운영체제가 할당) 처리 
				// 실행순서 : 코드1 -> 코드2 -> 코드3 -> 코드4 -> 코드5
			// Thread 클래스(새로운스레드) vs Main메소드( 메인스레드가 내장 )
				// 1. Thread 클래스
				// 2. Runnable 인터페이스
					// 1. 임의클래스에 implements Runnable
					// 2. run() 메소드 구현 한다.
					// 3. 외부에서 구현객체 생성한다.
					// 4. Thread 클래스 객체 생성시 생성자에 구현객체 넣어준다.
					// 5. thread 클래스 객체내 start() 메소드 실행
					// * .start() 메소드는 run() 메소드 호출
					// * run() 메소드는 main스레드 제외한 새로운 스레드 만들기

			/*
			 * 		코드1  	
			 * 
			 * 		코드2		코드3
			 * 
			 * 		코드4		코드5
			 * 
			 * 		(작업스레드1) (작업스레드2)
			 * 
			 */
		
		// p.581 예제1 
			// * 싱글스레드( main메소드 ) : 위에서 아래로 실행
			// 0.5초 간격으로 소리 출력
			// 0.5초 간격으로 띵 출력 
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // 소리 관련 메소드 제공 클래스
		// 소리
		for( int i = 0 ; i<5 ; i++ ) {
			toolkit.beep(); // .beep() : 소리 메소드
			try {
				Thread.sleep(500); // 현스레드(main스레드)를 0.5초간 일시정지
			}catch( Exception e ) {}
		}
		// 출력 
		for( int i = 0 ; i<5 ; i++ ) {
			System.out.println("띵");
			try {
				Thread.sleep(500); // 0.5 일시정지
			}catch( Exception e ) {}
		}
System.out.println("---------------------------------------");		
		// p.582 예제2
			// * 멀티 스레드( main스레드 , beepTask객체 )
		// 1. 인터페이스에 구현객체
		Runnable beepTask = new BeepTask(); 
		// 2. Thread 클래스 객체 생성시 생성자에 구현객체 넣기
		Thread thread = new Thread( beepTask );
		// 3. thread 객체내 start() 메소드 호출
		thread.start();
		
		// 출력
		for( int i = 0 ; i<5 ; i++ ) {
			System.out.println("띵");
			try {
				Thread.sleep(500); // 0.5 일시정지
			}catch( Exception e ) {}
		}
		
		
		
		
		
		
		
		
		
			
		
	}
}








