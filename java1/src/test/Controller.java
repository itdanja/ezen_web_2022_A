package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Controller {  //컨트롤러 : 각각 메소드를 만들어서 동작하는 부분을 만들기
	
	
	//저장
	public static ArrayList<Car> 주차장 = new ArrayList<Car>();
	
	
	//입차
		//차량번호를 받고 입차시간은 현재시간을 찍음
		//출차시간은 출차할 때만 나가도록 하고 그 이전에는 주차 중
		//금액도 나갈때 정산하고 그 전에는 정산 전으로 표시
	//view에서 입력 받은 차량 번호를 가져온다..
	
	public static boolean 입차 (String 차량번호) {
		//인수. 차량번호만 입력 받는다
		
		//중복체크해서 동일한 차량번호가 있는 지 확인
		for(Car temp : 주차장) { //입력 받은 차량번호를 가지고 돈다.
			if(temp.get차량번호().equals(차량번호)) {
				return false;	// 만일 동일하면 리턴 반환 종료
			} }
		
		//현재 시간 가져오기( now )
		LocalDate 날짜 = LocalDate.now();
		LocalTime 입차시간 = LocalTime.now();
		//출차는 지금 받지 않고 넘어간다
		
		//차번호, 날짜, 시간을 하나로 묶어서 자동차를 만든다.
		
		Car car = new Car(날짜, 차량번호, 입차시간, null, 0);
		//아직 출차시간 받지 않았으므로 null 대입
		주차장.add(car);
		//아까 만든 리스트에 자동차 객체 저장
		
		return false; //boolean은 리턴
	}
	
	
	//입차 종료
	///////////////////////////////////////////////
	
	

	public static boolean 출차 (String 차량번호) {
		//다시 입력 받은 차량 번호를 가지고 출차 한다.
		//입차와 비슷
		System.out.println("ㅇ하하하하하1"  );
		for(Car temp : 주차장 ) {
			System.out.println("ㅇ하하하하하2"+ temp.get차량번호() + 차량번호 );
			if(temp.get차량번호().equals(차량번호) ) {
				//입력 받은 값과 입력 되어있는 값을 비교한다.
				System.out.println("ㅇ하하하하하3");
				//출차할때에는 주차현황표에 출차시간을 대입하고 금액을 계산한다.
				
				//출차도 현재 시간을 받는다.
				LocalTime 출차 = LocalTime.now();
				
				//시간을 가지고 계산한다.
				
				int 이용시간 =  (int) temp.get입차시간().until(출차, ChronoUnit.MINUTES);
							//add cast int
				이용시간 -= 30; //30분 무료이니까 30분 제외한 다음 계산
				temp.set출차시간(출차); //뺀 시간을 저장한다.
			//set 저장 get 가져오기
			
			
			//이용요금 계산
				
			if(이용시간 < 0) {
				//이용시간이 30분 이내(위에 계산한 0이면)
				
				temp.set금액(0); //0원을 돌려주고
				
				} else { //0보다 크면, 30분 이상이면
					이용시간 = ((이용시간)/10) *1000;
					temp.set금액(이용시간);
				} //일의 자리수 분단위를 날리고 십의자리수에 따라 요금을 계산한다.
				

				return true; //성공햇으면 반환
				
			} // if end
			

			
		} //for end
			
		return false;
	} //출차종료
	
	//출차종료

}
