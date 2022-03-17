package Day12;

public class Day12_2 {
	
	public static void main(String[] args) {
		
		// String 메소드 
		// p.499 charAt() : 문자열에서 특정문자 추출 
		String ssn = "010624-1230123"; // 주민등록번호
		char sex = ssn.charAt(7); // 7번인덱스의 문자를 추출
		
		switch( sex ) { // switch 제어문 [ switch( 검사대상 ) ]
			case '1' : // sex 변수의 값이 문자 1 이면 
			case '3' : System.out.println("남자"); break; // sex 변수의 값이 문자 2 이면 
			case '2' : // sex 변수의 값이 문자 3 이면 
			case '4' : System.out.println("여자"); break; // sex 변수의 값이 문자 4 이면 
		}
System.out.println("---------------------------------");
		// p.501 equals() : 문자열 비교 
			// 기본자료형 사용하는 변수는 연산자 사용가능 [ == ] 
			// String 클래스 사용하는 객체는 == 연산자 사용불가능 [ equals ]
		
		// 자바 메모리 [ JVM ]
			// 스택 메모리 : 지역변수 
			// 힙 메모리 : 객체
			// 메소드 메모리 

		// 1. 문자열 선언
		String strVar1 = new String("신민철");
		String strVar2 = "신민철"; // 객체는 new연산자가 필수이지만 String 클래스만 자동 객체생성
		// 2. 문자열 비교 
		if( strVar1 == strVar2 ) { // 문자열 == 불가능 [ == 힙 주소 비교 ]
			System.out.println("같은 String 객체를 참조");
		}else {
			System.out.println("다른 String 객체를 참조");
		}
		//3. 
		if( strVar1.equals(strVar2) ) { // [ equals 힙 내용물 비교 ]
			System.out.println("*같은 문자열을 가짐 ");
		}else {
			System.out.println("*다른 문자열을 가짐 ");
		}
System.out.println("-------------------------------------");		
		// p.502 .getBytes() : 문자열 -> 바이트열 변환
		String str = "안녕하세요"; // 영문1바이트 한글2바이트 
		// 문자열 -> 바이트열 변환 
		byte[] bytes1 = str.getBytes(); 
		System.out.println("영문1byte 한글2byte : "+  bytes1.length ); // 배열명.length : 배열길이 필드 
		// 바이트열 -> 문자열 변환 
		String str1 = new String( bytes1 );
		System.out.println("바이트열 -> 문자열 : "+str1);
		try {
			// 1. 인코딩타입 [ 인코딩/디코딩 : 변환 방식 ] 
			// 1. EUC-KR [ 한글/영문 : 한글 2바이트 ] 
			byte[] bytes2 = str.getBytes("EUC-KR");// 일반예외 발생 
			System.out.println(" EUC-KR 길이 :  "+ bytes2.length );
			String str2 = new String( bytes2 , "EUC-KR");
			System.out.println("바이트열 -> 문자열 : " + str2);
			
			// 2. UTF-8 [ 전세계용어 : 한글 3바이트 ] 
			byte[] bytes3 = str.getBytes("UTF-8");// 일반예외 발생 
			System.out.println(" EUC-KR 길이 :  "+ bytes3.length );
			String str3 = new String( bytes3 , "UTF-8");
			System.out.println("바이트열 -> 문자열 : " + str3);
			
		}
		catch( Exception  e ) {}

System.out.println("----------------------------------");
		// P.504 indexOf() : 문자 위치[인덱스] 찾기
		String subject ="자바 프로그래밍";
		// 문자열내 특정문자열 위치[인덱스] 찾기
		int location = subject.indexOf("프로그래밍");
		System.out.println( location ); // 3번인덱스에서 프로그래밍 찾기 성공 
		
		// 문자열내 특정문자열 위치[인덱스] 찾기 / 만약에 없으면 -1[없다]
		if( subject.indexOf("자바") != -1 ) { // 인덱스는 0번 시작 [ -1는 인덱스가 없다 ]
			System.out.println("자바와 관련 책 ");
		}else {
			System.out.println("자바와 관련 없는 책 ");
		}
System.out.println("----------------------------------");
		// p.505 length() : 문자열 길이 
		String ssn2 = "7306241230123";
		int length = ssn2.length(); // 문자열내 글자수 [ 길이 구하기 ] 
		if( length == 13 ) { // 만약에 문자열내 13글자 이면 
			System.out.println("주민번호 자리수가 맞습니다.");
		}else {
			System.out.println("주민번호 자리수가 틀립니다.");
		}
System.out.println("----------------------------------");
		// p.506 replace( "기존문자" , "새로운문자" ) : 문자열 대치[변경]
		String oldStr = "자바는 객체지향언어 입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "JAVA");
						// 문자열.replace("기존문자","새로운문자") 
		System.out.println(" 기존문자열 : " + oldStr );
		System.out.println(" 새로운문자열 : " + newStr );
System.out.println("----------------------------------");		
		// p.507 substring() : 인덱스기준 vs split() : 문자기준 [ 문자열 자르기 ]  
		String ssn3 = "880815-1234567";
		String firstNum = ssn3.substring(0,6); // 시작인덱스 , 마지막인덱스전 
		System.out.println(" 확인 : " + firstNum );
		String secondNum = ssn3.substring(7); // 인덱스  [ ~ 마지막인덱스 ] 
		System.out.println(" 확인 : " + secondNum );
		// split
			// "880815-1234567"  "-" 기준 자르기 2조각 -> 배열반환 
			// [0] : 880815  [1] : 1234567
		System.out.println(" 앞부분 : " + ssn3.split("-")[0] );
		System.out.println(" 뒷부분 : " + ssn3.split("-")[1] );
System.out.println("----------------------------------");
		// p.508 
			// 영문문자열.toLowerCase() -> 영문 [ 소문자로 변환 ]
			// 영문문자열.toUpperCase() -> 영문 [ 대문자로 변환 ]
		// p.509
			// 문자열.trim() : 앞뒤 공백제거
		// p.510 valueOf() : 기본타입[int,double 등] -> 문자열 변환 
		String str2 = String.valueOf(10); // int형 10 -> String 10 으로 변환
		String str3 = String.valueOf(10.5);// double형 10.5 -> String 10.5으로 변환
		String str4 = String.valueOf(true);//boolean형 true -> String true
		String str5 = 10+""; // int형을 String변수에 저장 [불가능]
		
		System.out.println( str2 + 10 ); // 문자 + 문자 : 연결 
		System.out.println( str3 + 10 );
		// if( str4 ) 오류 : str5에는 boolean 형이 아닌 문자형 true 저장
		
		
	}
}






























