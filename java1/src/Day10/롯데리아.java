package Day10;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class 롯데리아 extends 점포 {
	// 1. 필드
	private String 점주;
	private ArrayList<상품> 상품리스트 = new ArrayList<>();
	// 2. 생성자
	public 롯데리아() {}
	
	public 롯데리아(String 점주, ArrayList<상품> 상품리스트) {
		super();
		this.점주 = 점주;
		this.상품리스트 = 상품리스트;
	}
	
	// 3. 메소드 
	@Override // 오버라이딩 [ 재정의 ] 
	public void 제품목록() {
		System.out.println(" *** 롯데리아 제품 목록 *** ");
		int i =1; // 상품 순서 번호
		for( 상품 temp : 상품리스트 ) {
			System.out.print( i +". "+temp.get상품명()+"("+temp.get가격()+")  " );
			i++; // i++
		}
		System.out.println();
	}
	@Override
	public void 상품추가() {
		// 1. 입력 
		Scanner scanner = new Scanner(System.in);
		System.out.println(" *** 롯데리아 상품추가 *** ");
		System.out.print(" 상품명 : "); String 상품명 = scanner.next();
		System.out.print(" 재고 : "); int 재고 = scanner.nextInt();
		System.out.print(" 가격 : "); int 가격 = scanner.nextInt();
		// 2. 객체 [ 여러 변수 -> 하나 객체 ] 
		상품 상품 = new 상품(상품명, 재고, 가격);
		// 3. 리스트에 저장 
		상품리스트.add(상품);
		// 4. 파일처리
		try { // 예외[오류]가 발생할것 같은 코드 묶음 ( 예상 ) 				//  파일 경로   , 이어쓰기=true[옵션]
			FileOutputStream outputStream = new FileOutputStream("D:/java/롯데리아재고.txt" , true );
			String 내보내기 = 상품명+","+재고+","+가격+"\n"; // , : 필드 구분용   \n : 제품 구분용
			outputStream.write( 내보내기.getBytes() ); // 문자열 -> 바이트열
		}catch( Exception e ) { // 예외[오류] 처리[잡기] : Exception 클래스
		}
		System.out.println("알림]] 상품 저장 완료 ~~~ ");
	}
}












