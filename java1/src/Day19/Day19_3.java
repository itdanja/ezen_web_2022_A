package Day19;

import java.util.HashMap;

public class Day19_3 {
	
	public static void main(String[] args) {
	
		// 1. Map 컬렉션 = json
			// * 키(객체) , 값(객체) = 엔트리
			// 키 : set컬렉션(중복불가능)	 값: list컬렉션(중복가능)
			// HashMap 클래스 
				// 1. map객체명.put( 키객체 , 값객체 ) : 엔트리(키=값) 추가
				// 2. map객체명.size() : 엔트리 개수 
				// 3. map객체명.get( 키객체 ) : 해당 키의 값 호출 
				// 4. map객체명.keySet() : map객체내 모든 키 호출 
				// 5. map객체명.values() : map객체내 모든 값 호출 
					// * 키(중복X)를 알고 있으면 값을 알수 있다.
					// for( 임시객체명 : map객체명.keySet() ){   }
				// 6. map객체명.remove( 키객체 ) : 해당 키의 엔트리 삭제 
				// 7. map.객체명.clear() : 모든 엔트리 삭제 
		
			// * List컬렉션 : 순서(인덱스) 저장 = 배열 유사
			// * Set컬렉션 : 순서없는 저장 = 중복불가능 
			// * Map컬렉션 : 키(KEY=중복X)와 값(VALUE=중복O)으로 이루어진 엔트리를 여러개 저장 [ 순서 X ] 
		
		// 1. HashMap 클래스의 객체 선언 
		HashMap<String, Integer> map = new HashMap<>();
//HashMap : 컬렉션프레임워크 map 클래스 // < 제네릭 , 제네릭 > : key , value 와 구성된 제네릭 // map : map 객체명 ( 아무거나 ) // new : 객체 생성시 메모리할당 // HashMap<>() : 생성자
		// 2. map 객체에 추가 
		map.put("신용권", 85 ); 	System.out.println(" 확인 : " + map );
			// 리스트 =  [ 객체,객체,객체  ]  // 셋트 = [ 객체,객체,객체 ]  // 맵 = { 키 = 값 }
		map.put("홍길동", 90);	System.out.println(" 확인 : " + map );
		map.put("동장군", 80);	System.out.println(" 확인 : " + map );
		// * key 는 중복불가능 [ 기존 key 없어지고 새로운 키로 대치 ]
		map.put("홍길동", 95);	System.out.println(" 확인 : " + map );
		// * value 는 중복가능 
		map.put("유재석", 95);	System.out.println(" 확인 : " + map );
		// 3. map객체명.size() : map객체내 엔트리(키=값) 개수 
		System.out.println(" map객체내 엔트리 수 : " + map.size() );
		// 4. map객체명.get( 키 ) : map객체내 키 -> 값 호출 
		System.out.println(" map객체내 값 호출 (키호출시->값호출) : " + map.get("유재석") );
		// 5. 모든 key 호출 
		System.out.println(" map객체내 모든 키 호출 : " + map.keySet() );
		// 6. 모든 value 호출
		System.out.println(" map객체내 모든 값 호출 : " + map.values() );
		// 7. 반복문 [ key 반복문 이용해서 모든 value 호출 가능 ] 
		for( String temp : map.keySet() ) {
			System.out.println( temp + " : " + map.get(temp) );
		}
		// 8. 삭제 
		map.remove("홍길동");		System.out.println(" 확인 : " + map );
		// 9. 모든 삭제 
		map.clear();  			System.out.println(" 확인 : " + map );
		
		
	}
}









