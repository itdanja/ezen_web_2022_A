package Day17;

public class Util {
	
	// �޼ҵ� 
	public static< K,V> boolean compare( Pair<K, V> p1 , Pair<K, V> p2 ) {
			// < �μ����׸� > ��ȯŸ�� �޼ҵ��( �μ�)
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p2.getValue().equals(p2.getValue());
		return keyCompare && valueCompare; 
	}
	
	// �޼ҵ�
	public static <T> Box<T> boxing(T t){
				   // ��ȯŸ��	  // ( �μ� ) 
		Box<T> box = new Box<T>();
		box.set(t);
		return box; // ��ȯ��
		
	}

}
