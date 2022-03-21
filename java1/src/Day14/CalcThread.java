package Day14;

public class CalcThread extends Thread {
	
	// 생성자 
	public CalcThread( String name ) {
		setName(name); // 인수로 받은 데이터로 스레드이름 정하기 
	}
	
	// 멀티스레드 구현  [ 오버라이딩]
	@Override
	public void run() {
		
		for( int i =0; i<2000000000 ; i++) {
						// 2억 반복 처리 [ 스레드 실행간 차이 ]
		}
		
		System.out.println( "현재 실행중인 스레드명 : "
							+ getName() );
	}
}
