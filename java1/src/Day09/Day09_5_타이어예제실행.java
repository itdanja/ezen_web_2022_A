package Day09;

public class Day09_5_타이어예제실행 {
	
	public static void main(String[] args) {
		
		// 1. 객체 생성 [ 자동차 1대 생성 ]
		Car mycar = new Car();
			// 클래스 내 타이어객체가 4개 -> mycar 포함
		// 2. 메소드 호출
		for( int i =1 ; i<=5 ; i++) {
			
			int problemLocation =  mycar.run(); // 자동차 회전메소드 호출=>5번
			
			switch( problemLocation ) {
			 	case 1:
			 		System.out.println(" 앞왼쪽 한국타이어 교체");
			 		mycar.frontLeftTire = new HankookTire("앞왼쪽", 15);
			 		// 슈퍼클래스 객체명 = new 서브클래스() ;
			 		// 상속을 받으면 가능 !!!!!!!!
			 		break;// switch 탈출 
			 	case 2:
			 		System.out.println(" 앞오른쪽 금호타이어 교체");
			 		mycar.frontRightTire = new KumhoTire("앞오른쪽", 13);
			 		break;
			 	case 3: 
			 		System.out.println(" 뒤왼쪽 한국타이어 교체");
			 		mycar.backLeftTire = new HankookTire("뒤왼쪽",14);
			 		break;
			 	case 4:
			 		System.out.println(" 뒤오른쪽 금호타이어 교체");
			 		mycar.backRightTire = new KumhoTire("뒤오른쪽", 17);
			 		break;
			}
			System.out.println("-----------------------");
			
		}
		
		
	}

}
