package Day09;

import java.util.Random;

public class 은행컨트롤러 { // 클래스 
	
	// 해당 클래스는 은행 관련 컨트롤러
	// M : 모델 [ 데이터 ]
	// V : 뷰 [ 입출력 ]
	// C : 모델[M] 과 뷰[V] 연결 역할
	
	// 뷰에서 요청하는 서비스[기능] 제공
		// 1. 계좌생성 [ C ]
	public String 계좌생성( String 비밀번호 , String 계좌주 , int 은행번호) {
		// 1. 입력받은 값을 가져온다 [ 인수 ] 
			String 계좌번호 = null ; // 선언만 [ 이유 : while 안에서 선언시 while 안에서 사용가능 ]
			while(true) { // 무한루프 [ 종료조건 : 난수가 중복이 없을경우 ] 
				// 계좌번호 자동생성 
				Random random = new Random(); // 랜덤 
				// 4자리 생성 
				int 난수 = random.nextInt(10000); // 0~9999 사이 
				계좌번호 = String.format("%04d", 난수  );  // %04d : 4자리 정수형 [ 빈칸은 0 처리 ]
				// 중복체크
				Boolean 계좌번호중복 = false; 
				for( 은행 temp2 : Day09_6_은행계좌프로그램.계좌리스트 ) {
					if( temp2 != null && temp2.get계좌번호().equals(계좌번호) ) { // 기존 배열내 계좌번호와 동일하면 
						계좌번호중복 = true;
					}
				}
				// 만일 중복이 없으면 
				if( 계좌번호중복 == false ) break; // 무한루프 종료 
			}
		// 2. 객체화[ 다수의 변수를 하나의 객체로 만들기 ]
			은행 temp = null; // 빈 객체 선언
			if( 은행번호 == 1 ) { 			temp = new 국민은행(계좌번호 , 비밀번호 , 계좌주 , 0 ); }
			else if( 은행번호 == 2 ) { 	temp = new 신한은행(계좌번호 , 비밀번호 , 계좌주 , 0 ); }
			else if( 은행번호 == 3 ) { 	temp = new 하나은행(계좌번호 , 비밀번호 , 계좌주 , 0 ); }
		// 3. 배열에 저장
		int i = 0 ; // 인덱스 
		for( 은행 temp2 : Day09_6_은행계좌프로그램.계좌리스트) {
			if( temp2 == null ) { // 해당 temp2가 공백이면 
				Day09_6_은행계좌프로그램.계좌리스트[i] = temp; // 공백 인덱스에 저장 
				return 계좌번호; // 계좌번호가 존재하면 성공했다는 의미 
			}
			i++; // 인덱스 증가
		}
		return null;  // null 이면 실패했다는 의미
	}
		// 2. 입금 [ U ] 
	public boolean 입금() { return false; }
		// 3. 출금 [ U ] 
	public boolean 출금() { return false; }
		// 4. 이체 [ U ] 
	public boolean 이체() { return false; }
		// 5. 내계좌목록 [ R ] 
	public boolean 계좌목록() { return false; }
		// 6. 대출 [ U ]
	public boolean 대출() { return false; }
	
	
	
}
