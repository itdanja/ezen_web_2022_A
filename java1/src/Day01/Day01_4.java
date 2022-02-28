package Day01;

import java.util.Scanner; // import : 가져오다

public class Day01_4 { // c s 
	
	public static void main(String[] args) { // m s 
		
		// 예제1 : 한명의 이름, 1교시 , 2교시 , 3교시 출석여부를 입력받아 출력
							// 입력 -> 저장 -> 출력
		
		// 1. 입력객체 선언  [ 한번만 선언 ] 
		Scanner 입력객체 = new Scanner(System.in);
		// 2. 입력받을 데이터 안내
		System.out.print(" 이름 : ");
		// 3. 입력받은 데이터 가져오기 -> 다른곳(String:문자열)에 저장 
		String 이름 = 입력객체.next();
			//   =  : 대입( 오른쪽값이 왼쪽 저장[대입] )
			//   안내 출력						// 입력받아 다른 객체로 저장 
		System.out.print("1교시 : ");		String 교시1 = 입력객체.next();
		System.out.print("2교시 : ");		String 교시2 = 입력객체.next();
		System.out.print("3교시 : ");		String 교시3 = 입력객체.next();
		// 4. 출력
		System.out.println("\t\t[[출석부]]");
		System.out.println("--------------------------------------");
		System.out.println("이름\t1교시\t2교시\t3교시\t비고");
		// System.out.println( 이름 +"\t"+ 교시1 +"\t"+교시2+"\t"+교시3  ); // 위에서 선언된 이름은 " "문자처리 X
						// 변수[객체] + "문자열"
		System.out.printf("%s\t%s\t%s\t%s\t%s\n" , 이름 , 교시1 , 교시2 , 교시3 , " ");
		System.out.println("--------------------------------------");
	
	} // m e 
} // c e 





