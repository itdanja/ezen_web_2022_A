package Day15;

public class Day15_6 {
	
	public static void main(String[] args) {
		
		// p.597
			// �����ٸ� : �ü���� �޸𸮸� ���μ������� �Ҵ��ϴ� ���
		// P.598~600
		// 1. statePrintThread ��ü ������( TargetThread )
		StatePrintThread statePrintThread 
			= new StatePrintThread( new TargetThread() );
		
		statePrintThread.start();
		
		
	}

}




