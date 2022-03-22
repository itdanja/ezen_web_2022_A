package 내부평가.프로그래밍언어응용;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
//		// (2022-03-22기준)당일 차량 테스트 
//		Car car = new Car( LocalDate.of(2022, 3, 22)  , 
//				"250어7142",
//				LocalTime.of( 17, 30 , 0 ),
//				null, 
//				0 );
//		Controller.carlist.add(car);
//		
//		// 1일 이용 차량 테스트 
//		Car car2 = new Car( LocalDate.of(2022, 3, 21)  , 
//				"250어7143",
//				LocalTime.of(23, 30 , 0 ),
//				null, 
//				0 );
//		Controller.carlist.add(car2);
//		
//		// 2일 이용 차량 테스트 
//		Car car3 = new Car( LocalDate.of(2022, 3, 20)  , 
//				"250어7141",
//				LocalTime.of(23, 30 , 0 ),
//				null, 
//				0 );
//		Controller.carlist.add(car3);
		
		
		while( true ) {
			// 1. 모든 차량 표 출력 
				System.out.println("============================== 주차 현황 표 ================================");
				// 현재 날짜를 호출하기 위한 date 클래스객체생성 
				Date date = new Date();
				// 날짜 형식 설정
				SimpleDateFormat dateFormat = new SimpleDateFormat("현재시간 : yyyy-MM-dd hh:mm");
				// 설정을 적용해서 출력한다.
				System.out.println( "\n\t\t\t"+ dateFormat.format(date)+"\n" );

				System.out.println("날짜\t\t차량번호\t\t입차시간\t\t출차시간\t\t금액");
				
						// 배열이나 리스트내 모든 객체 호출 반복문
					for( Car temp : Controller.carlist ) {
						System.out.print( temp.get날짜() + "\t" );
						System.out.print( temp.get차량번호() + "\t" );
						System.out.print( temp.get입차시간().getHour() + ":" );
						System.out.print( temp.get입차시간().getMinute() + "\t\t" );
						
						if( temp.get출차시간() == null ) {
							System.out.print( "주차 중\t\t" );
						}else {
							System.out.print( temp.get출차시간().getHour() + ":" );
							System.out.print( temp.get출차시간().getMinute() + "\t\t" );
						}
						
						if( temp.get출차시간() == null ) {
							System.out.print( "정산 전\n" );
						}else {
							DecimalFormat decimalFormat = new DecimalFormat("#,###"); // 금액 출력시 천단위 구분쉼표 형식으로 변환하기
							System.out.print( decimalFormat.format( temp.get금액() ) + "\n" );
						}
					}
				System.out.println("\n=========================================================================");
				// 
			System.out.print("\n\t\t\t 1.입차 \t  2.출차 : ");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) {
				// 1. 차량번호를 입력받는다.
					// 입력 
				System.out.print(" 입력) 차량번호 :  "); String 차량번호 = scanner.next();
				// 2. 입력받은 차량번호를 컨트롤내 메소드 에게 넘긴다.
				// 3. 메소드 결과 에 따른 출력 
				boolean 결과 = Controller.입차(차량번호);
				if( 결과 ) { System.out.println(" 완료) 차량이 입차 되었습니다. ");}
				else { System.out.println(" 실패) 동일한 차량번호가 존재합니다. "); }
			}else if( ch == 2 ){
				// 1. 차량번호를 입력받는다.
					// 입력
				System.out.print(" 입력) 차량번호 :  "); String 차량번호 = scanner.next();
				// 2. 입력받은 차량번호를 컨트롤내 메소드 에게 넘긴다.
				// 3. 메소드 결과 에 따른 출력 
				Boolean 결과 = Controller.출차(차량번호);
				if( 결과 ) { System.out.println(" 완료) 차량이 출차 되었습니다. ");}
				else { System.out.println(" 실패) 동일한 차량번호가 존재하지 않습니다. "); }
			}
			
		}
		
	} // 
} // 
