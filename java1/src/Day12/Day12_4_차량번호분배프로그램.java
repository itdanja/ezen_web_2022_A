package Day12;

import java.util.Random;
import java.util.Scanner;

public class Day12_4_차량번호분배프로그램 {
	
	// 차량번호 분배 프로그램
	// 조건 
		// 1. 난수 0000~9999[4자리 문자] 사이의 난수 10개 생성해서 배열에 저장 
		// 2. 모든 차량 번호를 배열에 저장 
		// 3. 끝자리 번호로 홀/짝 구분
		// 4. 차량 끝짜리의 번호가 홀수 차량 배열에 저장  
		// 5. 차량 끝짜리의 번호가 짝수 차량 배열에 저장 
		// 6. 홀수차량 배열 출력 // 짝수차량 배열 출력
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		String[] carlist = new String[10];
		while(true) {
			
			// 모든 차량 번호 출력 
			System.out.println(" \n*** 주차중인 모든 차량번호 *** ");
			for( String temp : carlist  ) {
				if( temp != null ) System.out.print( temp+"  " );
			}
			// 홀수차량 번호 출력 
			System.out.println(" \n*** 주차중인 모든 홀수 차량 *** ");
			
			// 짝수차량 번호 출력 
			System.out.println(" \n*** 주차중인 모든 짝수 차량 *** ");
			
			System.out.print("1.차량입차"); int ch = scanner.nextInt();
			if( ch == 1 ) {
				// 차량번호 난수 생성 
				Random random = new Random(); // 랜덤 객체 
				int intnum = random.nextInt(10000); // 0~9999 중 난수 발생 
				String strnum = String.format("%04d", intnum ); // %0숫자d : 숫자만큼 자릿수 [ 만일 해당 자릿수가 없으면 0 ]
				// 배열내 공백을 찾아 차량번호 저장 
				boolean save = false;
				for( int i = 0 ; i<carlist.length ; i++ ) {
					if( carlist[i] == null ) { carlist[i] = strnum; save=true; break; }
				}
				// 만약에 빈공간이 없으면 만차 
				if( save == false )System.err.println(" 만차 [ 주차 불가 ] ");
			}
		}
		
		
	}
	
}










