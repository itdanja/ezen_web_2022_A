package Day13;

import java.util.Random;

public class Day13_1 {

	public static void main(String[] args) {
		
		// p.534 : Math 클래스 (java.lang패키지) [ 수학 관련 메소드 제공 ] 객체없이 사용가능 
		// 1. Math.abs(수) : 해당 수의 절대값 
		System.out.println(" 절대값 : " + Math.abs(-5) );
		System.out.println(" 절대값 : " + Math.abs(-3.14) );
		// 2. Math.ceil(수) : 가까운 정수로 올림
		System.out.println(" 올림값 : " + Math.ceil(5.3) ); // 소수점 첫째자리에서 올림
		System.out.println(" 올림값 : " + Math.ceil(-5.3) ); // -5
		// 3. Math.floor(수) : 가까운 정수로 내림
		System.out.println(" 버림값 : " + Math.floor(5.3) );
		System.out.println(" 버림값 : " + Math.floor(-5.3) ); // -6
		// 4. Math.max(수1 , 수2) : 두 수 중 의 더 큰수 
		System.out.println(" 최댓값 : " + Math.max( 5 , 9) ); // 9
		System.out.println(" 최댓값 : " + Math.max( 5.3 , 2.5 )); // 5.3
		// 5. Math.min(수1 , 수2) : 두 수 중 의 더 작은수 
		System.out.println(" 최솟값 : " + Math.min( 5 , 9 )); // 5
		System.out.println(" 최솟값 : " + Math.min( 5.3 , 2.5 )); // 2.5
		// 6. Math.random() : 0~1 사이의 (double)형 난수 발생
		System.out.println(" 난수 : " + Math.random() ); // 0~1 사이의 난수 발생 
		// 7. Math.rint( 수 ) : 가까운 정수의 실수값으로 반올림 
		System.out.println(" 가까운 정수의 실수값 : "+Math.rint(5.3) ); // 반올림[5이상 올림]
		System.out.println(" 가까운 정수의 실수값 : "+Math.rint(5.7) ); // 
		// 8. Math.round( 수 ) : 가까운 정수의 정수값으로 반올림 
		System.out.println(" 가까운 정수의 정수값 : "+Math.round(5.3) );
		System.out.println(" 가까운 정수의 정수값 : "+Math.round(5.7) );
		// 9. 특정 소수점 위치에서 반올림 [ round( ):소수점 첫째자리에서 반올림 ]
		double value = 12.3456; // 소수 셋째자리에서 반올림
		double temp1 = value * 100; // 12.3456*100 -> 1234.56
		long temp2 = Math.round(temp1); // 1234.56 반올림 => 1235
		double v16 = temp2/100.0;
					// temp2/100 -> long/int -> 기본정수형 : int
					// temp2/100.0-> long/double -> 기본실수형 : double
		System.out.println( " v16 : " + v16 );
		
		//10.p.536 : 주사위 [ 1~6]
		System.out.println("0~1사이의 실수형 : "+ Math.random() ); // 0~1
		System.out.println( Math.random()*6 ); // 0~1 * 6  -> 0~6
		System.out.println( Math.random()*6 +1 ); // 0~6 +1 -> 1~7
		int num = (int)(Math.random()*6 )+1;
				// (기본자료형) 값/변수   = 강제형변환( 큰상자->작은상자 : 데이터손실 )
				// double -> int 강제형변환시 => 소수점 잘림
		System.out.println( "1~6사이의 난수 : " + num );
		//////////////////////////////////////////////////
		Random random = new Random();
		System.out.println("1~6사이의 난수 : "+  (random.nextInt(6)+1) );  // 0~5 + 1 => 1~6
		
		
		
		
		
		
		
		
	}
}
