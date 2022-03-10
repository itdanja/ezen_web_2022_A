package Day07;

public class Member {
	// 1.필드
	int mno;		// 회원번호
	String id;		// 아이디 
	String password;// 비밀번호
	String name;	// 이름
	String phone;	// 연락처
	// 2.생성자
		// 임의 
	// 3.메소드
		// 1. 회원가입 메소드 [ 인수x 반환o : 가입성공TRUE / 가입실패FALSE]
	boolean 회원가입() {
		System.out.println(" ----- 회원가입 페이지 ------");
		return true;
	}
		// 2. 로그인 메소드 [ 인수x반환o : ]
			// 로그인성공시 성공한 아이디반환 / 실패시 NULL 반환
	String 로그인() {
		System.out.println(" ----- 로그인 페이지 ------");
		return "아이디";
	}
		// 3. 아이디찾기 메소드 [ 인수x반환x]
	void 아이디찾기() {
		System.out.println(" ----- 아이디찾기 페이지 ------");
	}
		// 4. 비밀번찾기 메소드 [ 인수x반환x ]
	void 비밀번호찾기() {
		System.out.println(" ----- 비밀번호찾기 페이지 ------");
	}
		// 5. 회원탈퇴 메소드 
		// 6. 회원수정 메소드 
	
}







