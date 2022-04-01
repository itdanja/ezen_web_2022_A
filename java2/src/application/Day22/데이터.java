package application.Day22;

public class 데이터 {
	
	private int 번호;
	private String 작성자;
	private String 내용;
	
	public 데이터() {
		// TODO Auto-generated constructor stub
	}

	public 데이터(int 번호, String 작성자, String 내용) {
		super();
		this.번호 = 번호;
		this.작성자 = 작성자;
		this.내용 = 내용;
	}

	public int get번호() {
		return 번호;
	}

	public void set번호(int 번호) {
		this.번호 = 번호;
	}

	public String get작성자() {
		return 작성자;
	}

	public void set작성자(String 작성자) {
		this.작성자 = 작성자;
	}

	public String get내용() {
		return 내용;
	}

	public void set내용(String 내용) {
		this.내용 = 내용;
	}
	
	
	

}
