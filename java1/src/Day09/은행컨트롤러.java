package Day09;

import java.util.Random;

public class 은행컨트롤러 { // 클래스 
	
	// 해당 클래스는 은행 관련 컨트롤러
	// M : 모델 [ 데이터 ]
	// V : 뷰 [ 입출력 ]
	// C : 모델[M] 과 뷰[V] 연결 역할
	
	// 뷰에서 요청하는 서비스[기능] 제공
		// 1. 계좌생성 [ C ]
	public boolean 계좌생성( String 비밀번호 , String 계좌주 , int 은행번호) {
		// 1. 입력받은 값을 가져온다 [ 인수 ] 
			// 계좌번호 자동생성 
			Random random = new Random(); // 랜덤 
			// 4자리 생성 
			int 난수 = random.nextInt(10000); // 0~9999 사이 
			String 계좌번호 = String.format("%04d", 난수  );
							// 문자형식 변경
								// %d 정수 
								// %4d 정수 4자리 [ 만일 자릿수 없으면 공백처리 ]
									//   15 -> 15
								// %04d 정수 4자리 [ 만일 자릿수 없으면 0 처리 ] 
									//   15 -> 0015
			// 중복체크 
			
		// 2. 객체화[ 다수의 변수를 하나의 객체로 만들기 ]
			은행 temp = null; // 빈 객체 선언
			if( 은행번호 == 1 ) {
				temp = new 국민은행(계좌번호 , 비밀번호 , 계좌주 , 0 );
			}else if( 은행번호 == 2 ) {
				temp = new 신한은행(계좌번호 , 비밀번호 , 계좌주 , 0 );
			}else if( 은행번호 == 3 ) {
				temp = new 하나은행(계좌번호 , 비밀번호 , 계좌주 , 0 );
			}
		// 3. 배열에 저장
		int i = 0 ; // 인덱스 
		for( 은행 temp2 : Day09_6_은행계좌프로그램.계좌리스트) {
			if( temp2 == null ) { // 해당 temp2가 공백이면 
				Day09_6_은행계좌프로그램.계좌리스트[i] = temp; // 공백 인덱스에 저장 
				return true; // true 이면 성공했다는 의미 
			}
			i++; // 인덱스 증가
		}
		return false;  // false 이면 실패했다는 의미
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
