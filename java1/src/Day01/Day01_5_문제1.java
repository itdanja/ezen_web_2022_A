package Day01;

import java.util.Scanner;

public class Day01_5_문제1 { // c s 
	
	public static void main(String[] args) { // m s 
		
		// 입력 -> 저장 -> 출력 
		// 1. 입력객체 선언
		Scanner scanner = new Scanner(System.in);
		// 2. 입력할 대상 안내 // 3. 입력받은 데이터 다른곳에 저장 [ 왜??? 사라짐 ] 
		System.out.print(" 아이디 : ");	String id = scanner.next();
		System.out.print(" 비밀번호 : ");	String pw = scanner.next();
		System.out.print(" 성명 : ");	String name = scanner.next();
		System.out.print(" 이메일 : ");	String email = scanner.next();
		// 3. 출력
		System.out.println(">>>>>>>>>> 회원가입 완료 아래 정보를 확인해주세요 >>>>>>>");
		System.out.println("아이디\t비밀번호\t성명\t이메일");
		System.out.println( id +"\t"+ pw +"\t"+ name +"\t"+ email );
		
	} // m e 
} // c e 

	/*
	문제1 : 회원가입 표 작성
	[입력 예]
		1. 아이디, 비밀번호 , 성명, 이메일  입력받아 저장 
	[출력 예]
		>>>>>>>>>> 회원가입 완료 아래 정보를 확인해주세요 >>>>>>>>>
		 아이디		비밀번호		성명		이메일		
		 qwe		1234		유재석		itdanja@kakao.com
	*/
