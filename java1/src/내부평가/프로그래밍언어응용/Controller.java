package 내부평가.프로그래밍언어응용;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Controller {
	
	// 1. 배열 경우 
	//public static Car[] carlist = new Car[100];
	// 2. 리스트 경우
	public static ArrayList<Car> carlist = new ArrayList<>(); 

	// 입차 메소드 
	public static boolean 입차( String 차량번호 ) {
		// 입차 코드 작성 
			// 1. 입력받은 차량번호(인수) 가져온다.
			// * 차량번호 중복체크
			for( Car temp : carlist ) {
				if( temp.get차량번호().equals(차량번호) ) {
					return false; // 현 메소드 반환[종료]
				}
			}
			// 2. 입차날짜(현재날짜) 을 구한다( ????? : )
			LocalDate 날짜 = LocalDate.now(); 
			// 3. 입차시간(현재시간) 을 구한다( ????? : )
			LocalTime 입차시간 = LocalTime.now();
			// * 출차시간 , 금액은 출차시 x 
			
			// 4. 차량번호,입차날짜,입차시간 => 3개변수 -> 1객체화
			Car car = new Car( 날짜, 차량번호, 입차시간, null, 0);
			// 5. 차량객체를 배열이나 리스트 에 저장 
			carlist.add(car);
			
		return false;
	}
	// 출차 메소드 
	public static boolean 출차( String 차량번호 ) {
		// 출차 코드 작성
			// 1. 입력받은 차량번호(인수) 가져온다.
			// 2. 배열 or 리스트내 동일한 차량번호를 찾아서 
			for( Car temp : carlist ) {
				
				if( temp.get차량번호().equals(차량번호) ) { // 특정 차량이 입력받은 차량번호와 같으면
					
					// 3. 출차시간(현재시간) 을 구한다 (????? : )
					LocalTime 출차시간 = LocalTime.now();
					// 4. 계산 [ 출차시간 - 입차시간 => (분-30)/10 *1000  ]
					int 이용시간분 =  (int)( temp.get입차시간().until(출차시간, ChronoUnit.MINUTES )  )  ;
					이용시간분 -= 30; // 30분은 무료 
					// 5. (수정)찾은 객체내 출시간과 금액을 대입한다.
					temp.set출차시간(출차시간);
					
						// *** 출차일이 당일인지 다음날인지 체크
						LocalDate 출차일 = LocalDate.now(); // 출차일를 구한다 . 
						int 이용일 = (int)(temp.get날짜().until(출차일 , ChronoUnit.DAYS)); // 입차일과 출차일 차이를 구한다. 
						
						if( 이용일 == 0 ) { // 당일 이면  
							if( 이용시간분 < 0 ) { // 30분이내 이용 했으면
								temp.set금액(0);				
							}else { // 30분이상 이용 했으면 
								이용시간분 = ( (이용시간분) / 10 ) *1000;
								temp.set금액( 이용시간분 );
							}
							
						}else { // 하루 이상 차이가 있을경우

							int 일단위분 = 이용일 * 24 * 60; // 하루 -> 분 -> 1440분
							int 일단위금액 = (일단위분/10)*1000; // 하루 -> 하루 최대 144,000원 
						
							if( 이용시간분 < 0 ) { // 음수이면
								이용시간분 = ( (이용시간분) / 10 ) *1000; // 분 -> 금액 변환 
								temp.set금액( 일단위금액 + 이용시간분 - 1000  ); // 하루금액 + 금액
							}else { // 양수이면 
								이용시간분 = ( (이용시간분) / 10 ) *1000; // 분 -> 금액 변환 
								temp.set금액( 일단위금액 + 이용시간분 + 1000 ); // 하루금액 + 금액
							}
						}
					return true; // 출차 성공 
				}
			}
		return false;
	}
	
}





















