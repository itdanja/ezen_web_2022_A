package Day10;

public class Book {
	// 1.필드
	private String 도서명;
	private String 저자;
	// 2.생성자
	public Book() {}
	
	public Book(String 도서명, String 저자) {
		super();
		this.도서명 = 도서명;
		this.저자 = 저자;
	}
	// 3.메소드 [ get , set ] 

	public String get도서명() {
		return 도서명;
	}

	public void set도서명(String 도서명) {
		this.도서명 = 도서명;
	}

	public String get저자() {
		return 저자;
	}

	public void set저자(String 저자) {
		this.저자 = 저자;
	}
	

}
