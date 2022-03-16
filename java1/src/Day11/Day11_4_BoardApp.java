package Day11;

import java.util.Scanner;

public class Day11_4_BoardApp {
	/*
	 *  비회원제 게시판/댓글 프로그램 [ 예외처리 , 파일처리 , 리스트 ]
	 * 		// [m]게시물 클래스 
	 * 				// 제목 , 내\용 , 패스워드 , 작성자 , 작성일 , 조회수 , 댓글리스트
	 * 		// [m]댓글 클래스 
	 * 				// 내용 , 패스워드 , 작성자 , 작성일 
	 * 		// [c]컨트롤러 클래스
	 * 				// 1.목록 2.쓰기 3.보기 4.수정 5.삭제 6.댓글쓰기
	 * 				// 7.게시물저장 8.게시물불러오기 9.댓글저장 10.댓글불러오기 
	 * 		// [v]Day11_4_BoardApp 클래스 
	 * 				// 입출력 [ 입력받아 컨트롤러에게 입력받은 값 전달 ] 
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 1.입력객체
		Controller.load(); // 2. 파일[ 모든 게시물] 불러오기 
		while(true) {
			try { // 예외발생 : 사용자가 문자입력시 예외발생!!! -> catch 이동 
				// 모든 게시물 출력 
				System.out.printf("%s\t%10s\t%10s\t%10s\t%2s\t \n","번호","제목","작성자","작성일","조회수");
				int i = 0; // 리스트내 인덱스
				for( Board board : Controller.boadlist ) {
					System.out.printf("%2s\t%10s\t%10s\t%10s\t%2s\t \n", i , board.getTitle() ,
							board.getWriter() , board.getDate() , board.getViewcount() );
					i++;
				}
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
				else if( ch == 2 ) {
					// 해당 게시물 번호[인덱스] 를 입력받아 게시물정보 모두 출력
					System.out.print(" 게시물 번호 : "); int index = scanner.nextInt();
					// 해당 인덱스 출력 
					Board temp = Controller.boadlist.get(index); // 해당 인덱스의 객체를 임시 객체[ 코드 줄이기 ] 
					System.out.println(" *** 게시물 보기 *** ");
					System.out.println(" 제목 : " + temp.getTitle() );
					System.out.println(" 작성자: " + temp.getWriter() + "  작성일 : "+ temp.getDate() +"   조회수 : " + temp.getViewcount() );
					System.out.println(" 내용 : " + temp.getContent() );
					// 댓글출력 [ 추후 ]
					// 메뉴 
					System.out.print("1.뒤로가기 2.수정 3.삭제 4.댓글쓰기 선택 : "); int ch2 = scanner.nextInt();
					if( ch2 == 1 ) { }
					else if( ch2 == 2 ) { 
						System.out.print(" 현 게시물 패스워드 : ");		String password = scanner.next();
						scanner.nextLine(); // [ 일반next 다음로 nextLine 사용하게 되면 문제발생 [ 개행 취급 ] 
						System.out.print(" 변경 제목 : ");			String title = scanner.nextLine();
						System.out.print(" 변경 내용 : ");			String content = scanner.nextLine();
						boolean result =  Controller.update( index , password , title , content ); // 수정할 인덱스번호,패스워드,수정할제목,수정할내용 =>  인수 
						if( result ) System.err.println(" 알림]] 수정 성공 ");
						else System.err.println(" 알림]] 수정 실패[ 패스워가 다릅니다.] ");
					}
					else if( ch2 == 3 ) { 
						System.out.println(" 현 게시물 패스워드 : "); String password = scanner.next(); 
						boolean result =  Controller.delete( index , password); // 삭제할 인덱스번호,패스워드 => 인수
						if( result ) System.err.println(" 알림]] 삭제 성공 ");
						else System.err.println(" 알림]] 삭제 실패 ( 패스워드가 다릅니다.) ");
					}
					else if( ch2 == 4 ) { 
						Controller.replywrite(); // 인덱스번호, 댓글내용 , 댓글패스워드 ,댓글작성자  => 인수 
					}
					else { }
				}
				else {}
			}catch( Exception e ) {
				System.err.println(" 메시지]] 사용할수 없는 번호 입니다. [ 다시입력 ] ");
				scanner = new Scanner(System.in); // 다시 메모리할당[ 기존 내용물 지우기 ] 
			}
		}
	} // main end 
	
} // class end 











