package Day09;

public class 은행 {
	
	// 1. 필드
	private String 계좌번호;	// 계좌번호[중복x=식별]
	private String 비밀번호;	// 비밀번호
	private String 계좌주;	// 계좌주 
	private int 예금액;	// 예금액 
	// 2. 생성자
		// 1. 빈 생성자
	public 은행() {} 
		// 2. 모든필드 생성자
	public 은행(String 계좌번호, String 비밀번호, String 계좌주, int 예금액) {
		super();
		this.계좌번호 = 계좌번호;
		this.비밀번호 = 비밀번호;
		this.계좌주 = 계좌주;
		this.예금액 = 예금액;
	}
	// 3. 메소드 //get , set 메소드 [ 필드가 private 인경우]
	public String get계좌번호() {
		return 계좌번호;
	}
	public void set계좌번호(String 계좌번호) {
		this.계좌번호 = 계좌번호;
	}
	public String get비밀번호() {
		return 비밀번호;
	}
	public void set비밀번호(String 비밀번호) {
		this.비밀번호 = 비밀번호;
	}
	public String get계좌주() {
		return 계좌주;
	}
	public void set계좌주(String 계좌주) {
		this.계좌주 = 계좌주;
	}
	public int get예금액() {
		return 예금액;
	}
	public void set예금액(int 예금액) {
		this.예금액 = 예금액;
	}

	

}
