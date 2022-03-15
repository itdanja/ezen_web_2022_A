package Day10;

import java.util.Scanner;

public class Day10_7_키오스크 {
	// 상속 : 점포 
	// 클래스 : 롯데리아 , 버거킹
	// 인터페이스 : 키오스크  
	// 파일처리 : 제품재고 관리
	public static void main(String[] args) {
		
		키오스크 롯데리아 = new 롯데리아();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			롯데리아.제품목록();
			int ch = scanner.nextInt();
			if( ch == -1 ) {
				롯데리아.상품추가();
			}
		}
		
	}
}
