package Day03;

import java.util.Scanner;

public class Day03_3 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//문제6
		// 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 
		System.out.print(" 점수 : "); int 점수 = scanner.nextInt();
		if( 점수 >= 90 ) System.out.println(" 합격. ");
		else System.out.println(" 불합격. ");
		
		//문제7
		// 점수를 입력받아 점수가 90점 이상이면 A등급
		//				점수가 80점 이상이면 B등급
		//				점수가 70점 이상이면 C등급
		//				그외 재시험
		System.out.print(" 점수 : "); int 점수2 = scanner.nextInt();
		if( 점수2 >= 90 )System.out.println("A등급");
		else if( 점수2 >=80 )System.out.println("B등급");
		else if( 점수2 >=70 )System.out.println("C등급");
		else System.out.println("재시험");
		
		//문제8 로그인페이지
		// [ 입력 ] : 아이디와 비밀번호를 입력받기
		// [ 조건 ] : 회원아이디가 admin 이고 
		//           비밀번호가 1234 일 경우에는 
		//          로그인 성공 아니면 로그인 실패 출력
		
		/* 문제9
			[ 입력 ] : 국어,영어,수학 입력받기
			[ 조건 ]
				평균이 90점 이상이면서 
					국어점수 100점 이면 '국어우수' 출력
					영어점수 100점 이면 '영어우수' 출력
					수학점수 100점 이면 '수학우수' 출력
				평균이 80점 이상이면서 
					국어점수 90점 이면 '국어장려' 출력
					영어점수 90점 이면 '영어정려' 출력
					수학점수 90점 이면 '수학장려' 출력
				그외 재시험 
		 */
		
	}
}

