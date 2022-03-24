package Day17;

public class Util {
	
	// 메소드 
	public static< K,V> boolean compare( Pair<K, V> p1 , Pair<K, V> p2 ) {
			// < 인수제네릭 > 반환타입 메소드명( 인수)
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p2.getValue().equals(p2.getValue());
		return keyCompare && valueCompare; 
	}
	
	// 메소드
	public static <T> Box<T> boxing(T t){
				   // 반환타입	  // ( 인수 ) 
		Box<T> box = new Box<T>();
		box.set(t);
		return box; // 반환값
		
	}

}
