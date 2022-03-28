package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class View { //사용자가 보는 화면. 주차장 현황 표와 입차 출차 버튼이 보여짐
	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
		

	//주차현황표
	//현재시간
	//날짜, 차량번호, 입차시간, 출차시간, 금액
		
	
	
	//반복문
	while(true) {
		
		System.out.println("==========주차현황표==========");
		
		Date date = new Date(); //날짜 객체
		SimpleDateFormat dateFormat =
				new SimpleDateFormat("현재 시간 : yyyy-MM-dd \t hh:mm");
		//시간 단위 M month m minuts
		
		System.out.println(dateFormat.format(date));
		System.out.println(); //줄바꿈
		
		System.out.println("\t날짜\t차량번호\t입차시간\t출차시간\t금액\n");
		
		//호출

		for(Car temp : Controller.주차장) {
			//주차장을 호출한다.
			System.out.print(temp.get날짜()+"\t");
			System.out.print(temp.get차량번호()+"\t");
			
			//초단위 제외
			System.out.print(temp.get입차시간().getHour()+":"); //입차시간
			System.out.print(temp.get입차시간().getMinute()+"\t"); //입차시간

//			
//			System.out.print(temp.get출차시간().getHour()+":"); //출차시간
//			System.out.print(temp.get출차시간().getMinute()+"\t"); //출차시간
//			System.out.print(temp.get금액()+"\n");// 요금
			
			
				if(temp.get출차시간() == null) { //출차시간이 null로 보여질때 대입
					System.out.print("주차중"+"\t");
				} else { //null이 아니고 뭔가 들어갈때
					System.out.print(temp.get출차시간().getHour()+":"+temp.get출차시간().getMinute()+"\t");
				} //시간 나타내기
			
			//그리고 null = 주차중 일 때는 정산 전이라는 뜻
				if(temp.get출차시간() == null) { System.out.println("정산 전");
				} else { //정산이 끝났을 경우
					//천단위???
					System.out.print(temp.get금액()+"\n"); } //줄바꿈
				
		} //for end 
	
		System.out.println("==========================");
		
		System.out.println("\t 1.입차 \t 2. 출차");
		//선택 입력 받아서 저장
		int ch = scanner.nextInt();
		
	
		if( ch == 1 ) {
			//입차
			//컨트롤러에 입력한 입차 이벤트를 가져온다.
			System.out.println("차량 번호를 입력하세요 : ");
			String 차량번호 = scanner.next();
			
			boolean 입차 = Controller.입차(차량번호);
			//입력한 차량 번호 대입

		} else if (ch == 2) {
			//출차
			//입차와 동일(컨트롤러에 다 이벤트 만듦)
			System.out.println("차량 번호를 입력하세요 : ");
			String 차량번호 = scanner.next();
			
			boolean 출차 = Controller.출차(차량번호);
			
		} else { System.out.println("다시 선택해주세요."); }
		
		
		//저장받은 선택에 따른값
		
		
	} //while end
		
		
		
		
/////////////////////////////////////////////		
	}
}
