

package Day01;

public class Day01_2 { // c s
	// 1. 출력 
		// 1. print() : 출력만
		// 2. println() : 출력후 줄바꿈 포함
		// 3. printf() : 출력에 꾸미기
			// 형식문자
				// %s : 문자열 들어가는 자리 
				// %d : 정수 들어가는 자리 
				// %f : 실수 들어가는 자리
	
			// 제어문자 [ \ : 엔터위에 원화기호 ]
				// \n : 줄바꿈
				// \t : 들여쓰기[5칸]
				// \\ : \
				// \" : "
	
	// 1. System : 시스템 클래스 [ 입출력 관련 만들어진 코드 제공 ] 
	// 2. out : 출력 스트림
	// 3. print() : 출력함수 
	// 4. ;	: 한줄 코드 끝알림
	// * 시스템클래스내 out 이라는 출력스트림을 통해 print 함수를 사용해서
	//    console에 원하는 대로 출력할수 있다.
	public static void main(String[] args) { // m s 
		
		// 1. 기본출력 
		System.out.print("하고싶은말");	// ; : 코드 단위 종료
		System.out.print("java 1일차");	// 문자처리 " " 처리 
		System.out.print(123);			// 숫자 " " 처리 X
			// * 미리 만들어진 단어[ 예약어 ] 를 제외한 모든 문자는 " " 처리 
		// 2. 자동완성 ( syso + ctrl+스페이바 )
		System.out.println("자바는 객체지향이다.");
		System.out.println("jdk8");
		System.out.println(123);
		
		// 3. 형식출력 
		System.out.printf( "%s" , "하고싶은말");
		System.out.printf( "java %d일차" , 1 );
		System.out.printf( "%d" , 123);
		
		// 예제1 [ print ] 
		System.out.println("\n\t\t[[출석부]]");
		System.out.println("-------------------------------------------");
		System.out.println("이름\t1교시\t2교시\t3교시\t비고");
		System.out.println("강호동\t출석\t결석\t출석");
		System.out.println("유재석\t출석\t결석\t출석");
		System.out.println("-------------------------------------------");
		
		// 예제2 [ 예제1 -> printf ] 
		System.out.printf("\n\t\t%s" , "[[출석부]]\n" );
		System.out.printf("--------------------------------------------\n");
		System.out.printf("%s\t%s\t%s\t%s\t%s \n" ,"이름","1교시","2교시","3교시","비고");
		System.out.printf("%s\t%s\t%s\t%s\t%s \n" ,"강호동","출석","결석","출석"," ");
		System.out.printf("%s\t%s\t%s\t%s\t%s \n" ,"유재석","출석","결석","출석"," ");
		System.out.printf("--------------------------------------------\n");
		
		// 문제1 : 고양이
		System.out.println("\\    /\\");
		System.out.println(" )  ( ')");
		System.out.println("(  /  )");
		System.out.println(" \\(__)|"); // | : shift + \

		 // 문제2 : 강아지 
		System.out.println("|\\_/|");		// \ 출력시 -> \\
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");// " 출력시 -> \"
		System.out.println("|\"^\"`");
		System.out.println("||_/=\\\\__|");
		
		
		/*		\    /\
				 )  ( ')
				(  /  )
				 \(__)|
		*/ 

		/*
				|\_/|
				|q p|   /}
				( 0 )"""\
				|"^"`    |
				||_/=\\__|
		*/	
		
		
	} // m e 


} // c e 










