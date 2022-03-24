package Day17;

public class 코스<T> {
	// < 제네릭이름 > : 외부로부터 들어오는 자료형 
	// 1.필드
	private String name; 
	// 문자열 변수 : 과정명
	private T[] students; 
	
	// ??? 배열 : 학생배열 -> 외부에서 들어온 자료형[매개]
	
	// 2. 생성자 [ 외부로부터 과정명과 인원수를 받아서 인원수만큼 제네릭타입으로 배열내 메모리할당 ]
	public 코스( String name , int capacity ) {
				// 과정명    ,  인원수  
		this.name = name;
		students = (T[]) new Object[capacity];
					// * 매개타입으로 new (메모리할당) 안됨
					// 1. new Object[인원수] : 인원수 만큼 object 배열 선언 
					// 2. object 배열 --->  T[] 배열로 강제형변환
					// * Object 클래스는 최상위[부모] 이기때문에 가능 		
	}
	// 3. 메소드 
		// 과정명 호출 메소드 
	public String getName() { return name;}
		// 학생배열 호출 메소드 
	public T[] getStudents() { return students; }
		// 학생배열에 객체 추가하기 [ Arraylist클래스 설계 방식 유사 ] 
	public void add( T t ) {
		for( int i = 0; i<students.length ; i++ ) {
			if( students[i] == null ) {
				students[i] = t;
				 break;
			}
		}
	}
}















