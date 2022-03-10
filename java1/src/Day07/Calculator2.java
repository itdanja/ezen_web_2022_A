package Day07;

public class Calculator2 {
	//1.필드
	//2.생성자
	//3.메소드
		// 1. 실행메소드
	void execute() { // 인수x반환x
		double result = avg( 7 , 10); // 내부에서 메소드호출
		println("실행결과 : " + result );
	}
		// 2. 평균메소드
	double avg( int x , int y ) { // 인수o반환o
		double sum = plus( x , y);
		double result = sum / 2 ; return result;
	}
		// 3. 더하기메소드
	int plus( int x , int y ) { // 인수o반환o
		int result = x+y; return result;
	}
		// 4. 결과출력메소드 
	void println( String message ) { //인수o반환x
		System.out.println( message );
	}
}
