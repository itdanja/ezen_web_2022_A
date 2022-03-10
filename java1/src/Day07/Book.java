package Day07;

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
	}
		// 3. 도서대여 메소드
	void 도서대여() {
		System.out.println(" ------- 도서대여 페이지 -------");
	}
		// 4. 도서반납 메소드
	void 도서반납() {
		System.out.println(" ------- 도서반납 페이지 -------");
	}
		// 5. 도서등록 메소드
	void 도서등록() {
		System.out.println(" ------- 도서등록 페이지 -------");
	}
		// 6. 도서삭제 메소드
	void 도서삭제() {
		System.out.println(" ------- 도서삭제 페이지 -------");
	}
	
}
