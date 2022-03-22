package Day15;

public class Day15_6 {
	
	public static void main(String[] args) {
		
		// p.597
			// 스케줄링 : 운영체제가 메모리를 프로세스에게 할당하는 방법
		// P.598~600
		// 1. statePrintThread 객체 생성자( TargetThread )
		StatePrintThread statePrintThread 
			= new StatePrintThread( new TargetThread() );
		
		statePrintThread.start();
		
		
	}

}




