package Day07;

import java.util.Scanner;

public class Member {
	// 1.필드
	int mno;		// 회원번호 [ 자동번호 , 중복x ] 
	String id;		// 아이디 [ 중복x ]
	String password;// 비밀번호
	String name;	// 이름
	String phone;	// 연락처
	
	// 2.생성자 [ 생성자명 == 클래스명 ]
		// 1. 빈생성자[기본생성자] : 메소드호출용 객체생성시
	public Member() { }
		// 2. 모든 필드를 받는 생성자 : 회원가입용 객체생성시
	public Member(int mno, String id, String password, String name, String phone) {
		this.mno = mno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	// 3.메소드
		// 1. 회원가입 메소드 [ 인수x 반환o : 가입성공TRUE / 가입실패FALSE]
	boolean 회원가입() {
		System.out.println(" ----- 회원가입 페이지 ------");
		// 1. 입력받는다 [ id , pw , name, phone ] 
		System.out.print(" 아이디 : ");	String id = Day07_5_BookApplication.scanner.next();
		System.out.print(" 비밀번호 : ");	String password = Day07_5_BookApplication.scanner.next();
		System.out.print(" 이름 : ");	String name = Day07_5_BookApplication.scanner.next();
		System.out.print(" 연락처 : ");	String phone = Day07_5_BookApplication.scanner.next();
			// * scanner 객체가 다른 클래스내 static 선언되어있음. // * 클래스명.필드명.함수명()  
			// * static 필드,메소드는 객체없이 호출가능 [ 클래스명.필드명/메소드명 ]
			// * 아이디중복체크 
			for( Member temp : Day07_5_BookApplication.members ) {
				if( temp != null && temp.id.equals(id)) { // 만약에 공백이 아니면서 배열내 id와 입력받은 id와 동일하면 
					System.out.println(" 알림]] 현재 사용중인 아이디 입니다. ");
					return false; // 함수종료 ---> 아이디가 중복되었기 떄문에 false[가입실패]
				}
			} 
			// * 회원번호 자동부여 [ 가장 최근에 가입한 회원[마지막회원]의 번호 + 1 ]
			int bno = 0; // 회원번호 저장하는 변수 
			int j = 0; // 반복횟수 [ 인덱스 ]
			for( Member temp : Day07_5_BookApplication.members ) {
				if( temp == null ) { // null 찾기 [ null 찾았을때 null-1 하면 마지막회원 ]
					if( j == 0 ) {   // 첫번째 인덱스[0번인덱스]가 null => 첫회원 => 첫회원번호 = 1 부여
						bno = 1; break; // 끝내기 
					}
					else { // 첫번째 회원이 아니면 
						bno = Day07_5_BookApplication.members[ j-1 ].mno + 1 ; // null 앞 [ 마지막회원 ]번호에 +1
						break; // 끝내기 
					}
				}
				j++; // 인덱스 증가
			}
		// 2. 4개변수 -> 객체화 -> 1개
		Member member = new Member( bno , id, password, name, phone ); // 모든 필드 받는 생성자로 객체생성
		
		// 3. 배열내 빈 공간을 찾아서 새로운 회원[객체] 넣기 
		int i = 0 ; // 반복횟수 [ 인덱스체크 ]
		for( Member temp : Day07_5_BookApplication.members ) {
			if( temp == null ) { // 빈공간이면 
				Day07_5_BookApplication.members[i] = member; // 빈 인덱스에 새로운 회원 대입
				System.out.println(" 알림)) 회원님의 회원번호 : " + bno);
				return true; // 회원가입 메소드 종료 ~~~~~~~ [ 반환 : true ]
			}
			i++; // i증가 
		}
		// 4. 가입 성공시 true 반환 실패시 false 반환 
		return false; // 회원가입 메소드 종료 ~~~~~~ [ 반환 : false ]
	}
	// 2. 로그인 메소드 [ 인수x반환o : ]
			// 로그인성공시 성공한 아이디반환 / 실패시 NULL 반환
	String 로그인() {
		System.out.println(" ----- 로그인 페이지 ------");
		// 1. 입력받기 
		System.out.print(" 아이디 : ");		String id = Day07_5_BookApplication.scanner.next();
		System.out.print(" 비밀번호 : ");	String password = Day07_5_BookApplication.scanner.next();
		// 2. 배열내 객체 id와 password가 입력한 값과 동일하면 
		for( Member temp : Day07_5_BookApplication.members ) {
			if(  temp != null && temp.id.equals(id) 
					&& temp.password.equals(password) ) {
				// * 공백이 아니면서 id와 password가 동일하면 
				return temp.id; // 성공한 id 반환
			}
		}
		// 3. 로그인 성공시 입력한 id 반환 / 실패시 null 
		return null; // 실패시 null 반환
	}
		// 3. 아이디찾기 메소드 [ 인수x반환x] : 이름 , 연락처 
	void 아이디찾기() {
		System.out.println(" ----- 아이디찾기 페이지 ------");
		// 1.입력받기 
		System.out.print(" 이름 : "); String name = Day07_5_BookApplication.scanner.next();
		System.out.print(" 연락처 : "); String phone = Day07_5_BookApplication.scanner.next();
		// 2. 입력받은 값을 배열에 찾기 
		for( Member temp : Day07_5_BookApplication.members ) {
			if( temp !=null && temp.name.equals(name) && 
					temp.phone.equals(phone) ) {
				//* 공백이 아니면서 해당 객체내 name,phone 이 입력받은 값과 동일하면 
				System.out.println(" 알림]] 회원님 아이디 : " + temp.id); // 찾은 id 안내
				return; // 동일한 값을 찾았으면 해당 메소드 종료 
			}
		}
		// 3. 찾았으면 찾은id 출력하고 못찾았으면 없음 출력 
		System.out.println(" 알림]] 동일한 회원정보가 없습니다. ");
	}
		// 4. 비밀번찾기 메소드 [ 인수x반환x ] : 아이디 , 연락처
	void 비밀번호찾기() {
		System.out.println(" ----- 비밀번호찾기 페이지 ------");
		System.out.print(" 아이디 : ");	String id = Day07_5_BookApplication.scanner.next();
		System.out.print(" 연락처 : ");	String phone = Day07_5_BookApplication.scanner.next();
		for( Member temp : Day07_5_BookApplication.members ) {
			if( temp != null && temp.id.equals(id) &&
					temp.phone.equals(phone) ) {
				System.out.println(" 알림]] 회원님 비밀번호 : " + temp.password );
				return; // 동일한 값 찾았으면 해당 메소드 종료 
			}
		}
		System.out.println(" 알림]] 동일한 회원정보가 없습니다. ");
	}
		// 5. 회원탈퇴 메소드 
		// 6. 회원수정 메소드 
	
}


















