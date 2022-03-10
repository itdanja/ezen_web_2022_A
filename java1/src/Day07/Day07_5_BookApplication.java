package Day07;

import java.util.Scanner;

public class Day07_5_BookApplication {
	
	// BookApplication 클래스 : 입출력 관련코드
	// Book 클래스 : 도서 관련 코드 
	// Member 클래스 : 회원 관련 코드 
	
	// * 도서 대여 console 프로그램[ 클래스버전 ]
		// 1. 클래스 설계 
			// 1. book
				// 필드 : ISBN(도서번호) , 도서명 , 작가 , 도서대여여부 , 대여회원
				// 메소드 : 1.도서검색 2.도서목록 3.도서대여 4.도서반납 5.도서등록 6.도서삭제
			// 2. member
				// 필드 : 번호,아이디,비밀번호,이름,연락처
				// 메소드 : 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
		// 2. 화면 설계 
			// 1. 초기 메뉴 [ 1.회원가입 , 2.로그인 , 3.아이디찾기 , 4.비밀번호찾기  ]
			// 2. 일반회원메뉴 [ 1.도서검색 2.도서목록 3.도서대여 4.도서반납 5.로그아웃 ]
			// 3. 관리자메뉴  [ 1.도서등록 2.도서목록 3.도서삭제 4.순위(도전) 5.로그아웃
	
	
	// * main 밖에 변수를 선언하는 이유 : 모든 메소드에서 사용하기 위해서 
		// 지역변수  :  { 변수선언 } 괄호내에서 선언된 변수는 { } 밖을 못나감
			// 서로 다른 { } 괄호 내에서 사용시 -> 전역변수 
		// static  : 프로그램 시작시 메모리 할당 / 프로그램 종료시 메모리 초기화
			// 프로그램 전반적으로 모든곳에 사용되는 메모리[변수]
	
	static Scanner scanner = new Scanner(System.in);
	
	// 0. 코드를 읽어주는 시작 메소드 [ 스레드 ]
	public static void main(String[] args) { // main s
		// 메소드 호출 
			// 1.내부호출 
				// menu();
				// static : 메모리 우선할당 이기때문에 static 외 메소드,필드 못읽음
				// main 메소드 static 메소드 이기때문에 static 메소드만 내부호출 가능
			// 2. 외부호출
				// 1. 객체 생성(메모리할당) -> 메소드 호출 
				Day07_5_BookApplication application = new Day07_5_BookApplication();
				application.menu();
				
	} // main end  
	// 1. 초기 메뉴 메소드
	void menu() {
		while( true) { // 무한루프 [ 종료조건 없음 ]
			System.out.println("-------------- 도서 대여 프로그램 -------------");
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 : ");
			int ch = scanner.nextInt();
			Member member = new Member(); // 1~4 {}괄호에서 사용 가능
			if( ch == 1 ) {
				member.회원가입();// 회원가입 메소드 호출 
			} 
			else if( ch ==2 ) {
				member.로그인(); // 로그인 메소드 호출 
					// 1. 일반회원 메뉴 메소드 호출 
					// 2. 관리자 메뉴 메소드 호출 
			}
			else if( ch ==3 ) {
				member.아이디찾기();// 아이디 찾기 메소드 호출 
			}
			else if( ch ==4 ) {
				member.비밀번호찾기(); // 비밀번호 찾기 메소드 소출 
			}
			else {
				System.err.println(" 알림]] 알수 없는 번호입니다. ");
			} 
		}
	} // menu end 
	
	// 2. 일반회원 메뉴 메소드
	void membermeuu() {
		
	}
	// 3. 관리자 메뉴 메소드 
	void adminmenu() {
		
	}
	
	
} // class end 














