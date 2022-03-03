package Day03;

public class Day03_7_확인문제 {
	
	public static void main(String[] args) {
		
		// p.134 확인문제
			// 1 :  if  , switch
			// 		for , while , do~while
			// 2. 2 
			// 	 break; : 가장 가까운 { } 탈출 ( switch , for , while )
			// 3.
//				int sum = 0;
//				for( int i = 0 ; i<=100; i+=3 ) {
//					 sum += i;
//				}
			// 4. ~ 
			// 5.  4x + 5y = 60   [ 해 : x와 y에 들어갈수 있는 수 찾기 ]
				for( int x = 1 ; x<=10 ; x++ ) {
					// * x는 1 부터 10까지 1씩 증가 실행 반복처리 
					for( int y = 1 ; y<=10 ; y++ ) {
						if( (4*x) + (5*y) == 60 ) {
							System.out.println(x +" "+ y);
						}
					}
				}
			// 6.
				for( int i = 1 ; i<=5 ; i++ ) {
					// i는 1부터 5까지 1씩증가하면 실행 반복처리 
					// i = 현재줄수 
					for( int s = 1 ; s<=i ; s++ ) {
						System.out.print("*"); // 별찍기 
					}
					System.out.println(); // 줄바꿈처리
				}
		
	}
}





