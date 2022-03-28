package Day19;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Day19_1 {
	
	public static void main(String[] args) {
		
		// 컬렉션(수집=저장)프레임워크(미리만들어진클래스)
			// * 배열의 단점을 보완 사용
			// 1. List 컬렉션
				// * 인덱스 O (저장순서)
				// 1. ArrayList 클래스 	: 싱글스레드 / 순차적 추가,삭제 느림
				// 2. Vector 클래스		: 멀티스레드( 동기화O )
				// 3. LinkedList 클래스 	: 중간에 삽입/삭제 빠름 
			// 2. Set 컬렉션
				// * 인덱스 X ( 저장순서가 없기때문에 자동으로 객체가 중복불가능 )
				// 1. HashSet 클래스 
					// 1. .add( 객체명 ) : set 객체내 객체(요소) 추가 
					// 2. .size() : set 객체내 객체(요소) 개수 
					// 3. .iterator() : set 객체 순회 메소드 
						// * Iterator<제네릭> 인터페이스명 : 순서없는 객체 순회 인터페이스 
						// * Iterator<제네릭> iterator = set.iterator();
						//		1. iterator.hasnext() : 다음 객체 존재 여부 확인 
						//		2. iterator.next() : 다음 요소 가져오기 
						// or
						// for( 임시객체명 : set객체명 ) { }
					// 4. .remove( 객체명 ) : set 객체내 객체 삭제 
					// 5. .clear() : set 객체내 객체 전체 삭제 
				
			// 3. Map
		
		// p.737
		// 1. Hashset 클래스로 객체 선언 
		HashSet<String> set = new HashSet<>(); 
// 1. HashSet : 컬렉션프레임워크 클래스 // 2. < 제네릭 > : Set 클래스 안에 들어가는 자료형// 3. set : 객체명( 아무거나 )// 4. new : 객체 생성시 메모리 할당 // 5. HashSet<제네릭:생략가능>() : 생성자 
		// 2. set객체내 객체 넣기 [ set객체명.add( 객체명 ) ; 
		set.add("java");		System.out.println(" 확인 : " + set );
		set.add("JDBC");		System.out.println(" 확인 : " + set );
		set.add("Servlet/JSP");	System.out.println(" 확인 : " + set );
		set.add("java");		System.out.println(" 확인 : " + set ); // 객체 중복 불가능
		set.add("iBATIS");		System.out.println(" 확인 : " + set );
		// 3. set객체내 객체 수  [ set객체명.size() : ]
		System.out.println(" set 안에 들어있는 객체 수 : " + set.size() );
		
		// 4 . Iterator : 저장된 객체를 한번씩 가져오는 반복자 리턴 ( 순회 )
			// * set 컬렉션 에서 사용되는 이유 : 인덱스가 없기때문에 객체를 호출하는 방법X get
		Iterator<String> iterator = set.iterator(); // set객체내 iterator() : 순회
		while( iterator.hasNext() ) { // .hasNext() : 다음 요소 존재 여부 확인 = 다음 요소가 있으면 true 없으면 false;
			String element = iterator.next(); // .next() : 다음 요소 가져오기 
			System.out.println("\t"+element);
		}
		// * for문과 컬렉션 활용 
			// for( 임시 객체명 : 컬렉션/배열 )  : 컬렉션/배열내 요소들을 한번씩 가져오는 반복자 
		for( String element : set ) {	
			System.out.println( "\t"+element );
		}
		
		// 5. set객체명.remove( 객체명 ) : set객체내 해당 객체를 삭제
		set.remove("JDBC");		System.out.println(" 확인 : " + set );
		set.remove("iBATIS");	System.out.println(" 확인 : " + set );
		
		// 6. set객체명.clear() : set객체내 모든 객체를 비우기[삭제 ]
		set.clear();  			System.out.println(" 확인3 : " + set );
		
	}

}


















