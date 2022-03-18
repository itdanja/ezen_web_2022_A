package Day13;

import java.util.Calendar;

public class Day13_3_달력 {
	public static void main(String[] args) {
		
		// 1. 캘린더 클래스내 현재 날짜/시간 객체 호출 
		Calendar calendar = Calendar.getInstance();
		// 2. 현재 연도 , 월 , 일 호출 
		int year = calendar.get( Calendar.YEAR);
		int month = calendar.get( Calendar.MONTH)+1; // +1 하는이유 : 0:1월~11:12월
		int day = calendar.get( Calendar.DAY_OF_MONTH );
		// * 해당 월의 1일의 요일찾기 
			// 1. 사용자 정의 캘린터 설정 
			calendar.set( year , month-1 , 1 ); // 예) 3월1일
				System.out.println( "사용자가 날짜만들기 : "+ calendar.toString() );
			// 2. 3월1일의 요일 
			int sweek = calendar.get( Calendar.DAY_OF_WEEK );
				System.out.println( "요일구하기 : "+ sweek );
			// 3. 3월의 마지막 일 
			int eday = calendar.getActualMaximum( Calendar.DAY_OF_MONTH );
				System.out.println( "해당날짜의 마지막 일수 : " + eday );
		// 3. 출력 
		System.out.println(" ****** "+year+"년" + month+"월 ******");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		
		
	}
}





