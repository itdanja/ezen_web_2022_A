package Day07;

import java.util.Scanner;

public class Book {
	
	// 1. 필드
	String ISBN;	// ISBN [ 도서번호 = 식별용 ] 
	String bname;	// 도서명
	String bwriter;	// 작가
	boolean brental;// 도서대여여부
	String mid;		// 대여인ID
	
	// 2. 생성자
		// 1. 빈생성자[기본생성자] : 메소드호출용   ( ctrl+스페이바)
	public Book() {}
		// 2. 풀생성자[모든필드받는생성자] : 도서등록
	public Book(String iSBN, String bname, String bwriter, boolean brental, String mid) {
		ISBN = iSBN;
		this.bname = bname;
		this.bwriter = bwriter;
		this.brental = brental;
		this.mid = mid;
	}
	// 3. 메소드 
		// 1. 도서검색 메소드
	void 도서검색() { 
		System.out.println(" ------- 도서검색 페이지 -------");
	}
		// 2. 도서목록 메소드
	void 도서목록() {
		System.out.println(" ------- 도서목록 페이지 -------");
		System.out.println("ISBN\t도서명\t작가\t대여가능여부");
		for( Book temp : Day07_5_BookApplication.books) {
			if( temp != null ) { // 도서가 존재하면 
				if(  temp.brental ) // 해당도서의 도서대여여부가 true 이면 
					System.out.println( temp.ISBN +"\t"+ temp.bname +"\t" + temp.bwriter +"\t" + "대여가능");
				else // 해당도서의 도서대여여부가 false 
					System.out.println( temp.ISBN +"\t"+ temp.bname +"\t" + temp.bwriter +"\t" + "대여중");
			}
		}
	}
		// 3. 도서대여[수정] 메소드
	void 도서대여( String loginid ) {
		System.out.println(" ------- 도서대여 페이지 -------");
		System.out.println(" 도서 ISBN : ");	String isbn = Day07_5_BookApplication.scanner.next();
		
		int i = 0; // 인덱스 
		for( Book temp : Day07_5_BookApplication.books ) {
			// * 임시 객체 : 배열이름 
				// 배열내 0번인덱스 마지막인덱스 하나씩 임시 객체 대입
			
			if( temp != null && temp.ISBN.equals(isbn) ) {
				if( temp.brental ) {
					System.out.println(" 알림]] 해당 도서 대여 합니다.");
					Day07_5_BookApplication.books[i].brental = false; // 대여중으로 변경 
					Day07_5_BookApplication.books[i].mid =loginid; // 현재 로그인한 id를 대입
					return;
				}else {
					System.out.println(" 알림]] 해당 도서 대여중 상태 입니다 . [ 대여불가 ] ");
					return;
				}
			}
			i++;
		}
		System.out.println(" 알림]] 동일한 도서ISBN이 없습니다. ");
	}
		// 4. 도서반납[수정] 메소드
	void 도서반납( String loginid ) {
		System.out.println(" ------- 도서반납 페이지 -------");
		도서대여목록( loginid  );
		System.out.println(" 도서 ISBN "); String isbn = Day07_5_BookApplication.scanner.next();
		int i = 0;
		for( Book temp : Day07_5_BookApplication.books ) {
			if( temp !=null && temp.ISBN.equals(isbn) ) { // 입력한 isbn이 있으면
				if( temp.mid.equals(loginid) ) { // 대여인id 과 현재 로그인된id 동일하면 
					if( temp.brental ) { // 대여중이 아니면 
						System.out.println(" 알림]] 현재 도서가 대여중이 아닙니다. ");
					}else { // 대여중이면 
						System.out.println(" 알림]] 반납 완료 !!!! ");
						Day07_5_BookApplication.books[i].brental = true; // 대여중 -> 대여가능 변경 
						Day07_5_BookApplication.books[i].mid = null; // 대여한 사람의 id를 다시 없음변경 [ null ]
						return;
					}
				}else {
					System.out.println(" 알림]] 회원님이 대여한 도서가 아닙니다.");
				}
			}
			i++;
		}
		System.out.println(" 알림]] 동일한 도서ISBN이 없습니다. ");
	}
		// * 현재 로그인 한 회원이 대여중인 도서 목록 [ 내 도서대여 목록 ] 
	void 도서대여목록( String loginid ) {
		System.out.println(" ------- 도서목록 페이지 -------");
		System.out.println("ISBN\t도서명\t작가\t대여가능여부");
		for( Book temp : Day07_5_BookApplication.books) {
			if( temp != null && temp.mid.equals( loginid ) ) {
				// * 도서가 존재하면서 대여id 와 현재 로그인된id와 같으면
				System.out.println( temp.ISBN +"\t"+ temp.bname +"\t" + temp.bwriter +"\t" + "대여중");
			}
		}
	}
	
		// 5. 도서등록 메소드
	void 도서등록() {
		System.out.println(" ------- 도서등록 페이지 -------");
		// 1. 입력받아 
		System.out.print(" ISBN : ");	String isbn = Day07_5_BookApplication.scanner.next();
		System.out.print(" 도서명 : ");	String bname = Day07_5_BookApplication.scanner.next();
		System.out.print(" 작가 : ");	String bwriter = Day07_5_BookApplication.scanner.next();
		//*중복체크[isbn]
		for( Book temp : Day07_5_BookApplication.books ) {
			if(  temp !=null && temp.ISBN.equals(isbn) ) {
				System.out.println(" 알림]] 현재 사용중인 ISBN 입니다. [ 등록실패 ]");
				return; // 도서등록 메소드 종료 ( 등록실패 )
			}
		}
		// 2. 객체화 [ 도서대여여부 = true , 대여회원id = null ]
		Book book = new Book(isbn, bname, bwriter, true , null);
		// 3. 배열 대입[넣기]
		int i = 0; // 반복횟수 [ 인덱스 ]
		for( Book temp : Day07_5_BookApplication.books ) {
			if(temp == null ) {
				Day07_5_BookApplication.books[i]=book;
				System.out.println(" 알림]] 도서등록이 되었습니다. ");
				return; // 도서등록 메소드 종료 ( 등록성공 )
			}
			i++; // 인덱스증가
		}
	}
		// 6. 도서삭제 메소드
	void 도서삭제() {
		System.out.println(" ------- 도서삭제 페이지 -------");
	}
	
}








