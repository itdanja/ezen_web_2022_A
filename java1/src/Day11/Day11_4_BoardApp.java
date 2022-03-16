package Day11;

import java.util.Scanner;

public class Day11_4_BoardApp {
	/*
	 *  비회원제 게시판/댓글 프로그램 [ 예외처리 , 파일처리 , 리스트 ]
	 * 		// [m]게시물 클래스 
	 * 				// 제목 , 내용 , 패스워드 , 작성자 , 작성일 , 조회수 , 댓글리스트
	 * 		// [m]댓글 클래스 
	 * 				// 내용 , 패스워드 , 작성자 , 작성일 
	 * 		// [c]컨트롤러 클래스
	 * 				// 1.목록 2.쓰기 3.보기 4.수정 5.삭제 6.댓글쓰기
	 * 				// 7.게시물저장 8.게시물불러오기 9.댓글저장 10.댓글불러오기 
	 * 		// [v]Day11_4_BoardApp 클래스 
	 * 				// 입출력 [ 입력받아 컨트롤러에게 입력받은 값 전달 ] 
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try { // 예외발생 : 사용자가 문자입력시 예외발생!!! -> catch 이동 
				Controller.boardlist(); // 객체없이 메소드호출이 되는이유 : static메소드 이기때문에
				System.out.print("1.쓰기 2.보기 선택 : ");
				int ch = scanner.nextInt();
				if( ch == 1 ) {
					System.out.println(" *** 게시물 등록 ***");
						// nextLine() : 공백포함 입력가능 [ 문제! : nextLine 앞에 일단 next 하나로 취급]
						// 해결방법 : 일반next 와 nextLine 사이에 nextLine()
					scanner.nextLine();
					System.out.print(" 제목 : ");	String 제목 = scanner.nextLine();
					System.out.print(" 내용 : ");	String 내용 = scanner.nextLine();
					System.out.print(" 작성자 : ");	String 작성자 = scanner.next();
					System.out.print(" 비밀번호[수정/삭제시] : "); String 비밀번호 = scanner.next();
					Controller.write( 제목 , 내용 , 작성자 , 비밀번호 ); // 인수 전달 
				}
				else if( ch == 2 ) {}
				else {}
			}catch( Exception e ) {
				System.err.println(" 메시지]] 번호로 입력해주세요.");
				scanner = new Scanner(System.in); // 다시 메모리할당[ 기존 내용물 지우기 ] 
			}
		}
	} // main end 
	
} // class end 











