package Day09;

import java.util.Scanner;

public class Day09_6_은행계좌프로그램 {
	
	// 은행계좌프로그램 [ 상속 ] 
		// 은행[super]
		// 국민은행[sub] , 신한은행[sub] , 하나은행[sub]
		// 주 기능 : 1.계좌생성 2.입금 3.출금 4.이체 5.내계좌목록 6.대출 
	
	// ** main 밖에서 선언하는 이유 
		//* 모든 클래스에서 사용하기 위해 static 배열로 선언
		// static변수는 프로그램 시작시 메모리할당 -> 프로그램 종료시 메모리초기화
	public static 은행[] 계좌리스트 = new 은행[100]; 
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) { // 프로그램 무한루프 [ 종료조건 x ] 
			System.out.println("----------- 계좌 시스템 --------");
			System.out.print("1.계좌생성 2.입금 3.출금 4.이체 5.계좌목록 6.대출 선택 : ");
			int 선택 = scanner.nextInt();
			// 컨트롤러 메소드 호출용 객체 
			은행컨트롤러 컨트롤 = new 은행컨트롤러();
			if( 선택 == 1 ) {
				// 입력
				System.out.println("+++ 계좌등록 페이지 +++");
				System.out.print("비밀번호 : "); String 비밀번호 = scanner.next();
				System.out.print("계좌주 : "); String 계좌주 = scanner.next();
				System.out.print("은행선택 < 1.국민2.신한3.하나 > : "); int 은행번호 = scanner.nextInt();
				// 컨트롤러 연결 
				Boolean result =  컨트롤.계좌생성(비밀번호, 계좌주, 은행번호);
				if( result  ) { // result  가 true 이면 
					System.out.println(" ** 계좌 생성 ** ");
				}else { // result 가 false 이면 
					System.out.println(" 알림 ]] 계좌등록 실패 (관리자에게문의)");
				}
				
			}
			else if( 선택 == 2 ) {
				System.out.println("+++ 입금 페이지 +++");
			}else if( 선택 == 3 ) {
				System.out.println("+++ 출금 페이지 +++");
			}else if( 선택 == 4 ) {
				System.out.println("+++ 이체 페이지 +++");
			}else if( 선택 == 5 ) {
				System.out.println("+++ 계좌목록 페이지 +++");
			}else if( 선택 == 6 ) {
				System.out.println("+++ 대출 페이지 +++");
			}else {
				System.err.println(" 알림]] 알수없는 번호입니다. ");
			}
		} // while 프로그램 end
	} // main end 
} // class end 






