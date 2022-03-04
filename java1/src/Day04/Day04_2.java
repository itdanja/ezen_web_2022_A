package Day04;

import java.util.Scanner;

public class Day04_2 {
	
	// Day01 : 입출력
	// Day02 : 변수[저장] 연산[계산]
	// Day03 : if[제어문] for[반복문]
	
	// 자판기 프로그램
		// 1. 메뉴판 [ 1.콜라(300) 2.환타(200) 3.사이다(100) 4.결제 ] 
		// 		// 1.메뉴판에서 제품선택하면 장바구니에 넣기 
		//		// 2.재고가 부족하면 알림( 재고부족 )
		// 2. 초기 재고 [ 제품 당 10개씩 ]
		// 3. 결제시 금액입력받아 결제액 만큼 차감후 잔돈 출력 
				// 1. 투입한 금액보다 구매액 이 더 크면 결제 취소 [ 금액부족 ]
	
	
	public static void main(String[] args) {
		
		// 공통변수[ 모든 괄호내에서 사용하는 변수들 ]
		Scanner scanner = new Scanner(System.in); 			// 1. 입력객체
		int 콜라재고 =10; int 환타재고 =10; 	int 사이다재고=10; // 2. 재고변수
		int 콜라구매수=0;	int 환타구매수 = 0;int 사이다구매수=0;	// 3. 장바구니 
		
		while(true) { // 프로그램 시작 [ 무한루프 ]
			System.out.println("------------- 메뉴 ------------");
			System.out.println(" 1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제 ");
			System.out.print(">>>>>> 선택 : "); int 선택 = scanner.nextInt();
			
			if( 선택 == 1 ) { // 콜라 구매
				if( 콜라재고 == 0 ) { // 콜라재고가 0이면 구매불가 
					System.err.println(" 알림)) 재고가 없습니다 .재고 준비중");
				}
				else { // 콜라재고가 있으면 구매가능 
					System.err.println(" [[ 콜라 담았습니다.]]");
					콜라구매수++; // 장바구니에 콜라 담기 
					콜라재고--;	// 콜라재고 차감
				}
			}// 콜라 구매 end 
			else if( 선택 == 2 ) { // 환타 구매 
				
			}// 환타 구매 end 
			else if( 선택 == 3 ) { // 사이다 구매 
				
			}// 사이다 구매 end 
			else if( 선택 == 4 ) { // 결제 
				
			} // 결제 end 
			else {
				System.err.println(" 알림)) 알수없는 행동입니다.");
			} 
			
		} //  while end 
	} // main end
} // class end 
