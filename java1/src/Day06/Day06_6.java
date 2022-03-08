package Day06;

import java.util.Scanner;

public class Day06_6 { // c s 
	
	// 비회원제 게시판 [ 클래스 버전 ]
		// 0. 게시물 설계 => 클래스 선언 
			// 필드 : 제목 , 내용 , 작성자 , 비밀번호
			// 생성자 : 사용유무 선택
		// 1. 첫화면 [ 모든 게시물(번호,작성자,제목) 출력 ]
		// 2. 메뉴 [ 1. 글쓰기 2.글보기 ]
			// 1. 글쓰기 [ 제목 , 내용 , 작성자 , 비밀번호 => 4개변수 -> 객체화 ]
			// 2. 글보기 [ 해당 글번호의 입력받아 해당 글 상세페이지(번호,작성자,제목,내용) 표시 ]
				// 글번호는 배열에 저장되는 순서 [ 인덱스 ]
				// 글보기 메뉴 
		// 3. 글보기 메뉴 [ 1. 목록보기 2.삭제 3.수정 ]
			// 1. 삭제시 : 작성자와 비밀번호 입력받아 동일하면 삭제
			// 2. 수정시 : 작성자와 비밀번호 입력받아 동일하면 제목과 내용만 수정 
	
	public static void main(String[] args) { // m s 
		
		// 준비 [ 모든 {} 안에서 사용되는 변수 선언 ]
		Scanner scanner = new Scanner(System.in); // 1. 입력객체
		Board[] boardlist = new Board[100]; // * Board 객체를 100개를 저장할수 있는 1차원 배열 선언 
		
		while(true) { // 프로그램 실행 무한루프 [ 종료조건 : x ]
			System.out.println("--------- 커뮤니티 ----------");
			////////////////////////////// 모든 게시물 조회 //////////////////////
			System.out.println("번호\t작성자\t제목");
			int index = 0; // 인덱스 변수 [ 배열내 객체 수 체크 ]
			for( Board board : boardlist ) { // 배열내 모든 객체(게시물) 출력 반복문 
				if( board != null ) { // 만약에 해당 board 객체가 내용물이 있으면 출력
					System.out.printf("%d\t%s\t%s \n" , index , board.writer , board.title);
				}
				index++; // 인덱스 증가
			}
			//////////////////////////////////////////////////////////////
			System.out.println("1.글쓰기 2.글보기 ");
			int ch = scanner.nextInt();
			if( ch== 1 ) { // 1. 글쓰기 
/////////////////////////////////////// 글쓰기 /////////////////////////////////
				// 1. 4개 변수를 입력받는다 
				System.out.println("----------------- 글 쓰기 페이지 ----------------");
				System.out.print(" title : ");		String title = scanner.next();
				System.out.print(" content : ");	String content = scanner.next();
				System.out.print(" writer : ");		String writer = scanner.next();
				System.out.print(" password : ");	String password = scanner.next();
				// 2. 4개 변수를 객체화 [ 객체를 만들어서 4개변수를 객체내 필드에 저장 ]
				Board board = new Board( title , content , writer , password ); // 4개 필드를 갖는 생성자 사용
				// 3. 배열내 빈공간을 찾아서 빈공간에 객체 대입
				int i = 0;
				for( Board temp : boardlist ) {
					if( temp == null ) { // 빈공간 찾았으면 
						boardlist[i] = board; // 해당 인덱스에 새로운 객체 저장 
						break; // 한번 저장했으면 반복문 종료 
					}
					i++;
				}
//////////////////////////////////////////////////////////////////////////
			}
			
			else if( ch==2 ) { // 2. 글보기 
				
			}
			else {
				System.err.println(" 알림)) 알수없는 번호입니다. ");
			}
			
		} // 프로그램 while end  
		
	} // m e 
} // c e 






