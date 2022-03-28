package Day19;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Day19_1 {
	
	public static void main(String[] args) {
		
		// �÷���(����=����)�����ӿ�ũ(�̸��������Ŭ����)
			// * �迭�� ������ ���� ���
			// 1. List �÷���
				// * �ε��� O (�������)
				// 1. ArrayList Ŭ���� 	: �̱۽����� / ������ �߰�,���� ����
				// 2. Vector Ŭ����		: ��Ƽ������( ����ȭO )
				// 3. LinkedList Ŭ���� 	: �߰��� ����/���� ���� 
			// 2. Set �÷���
				// * �ε��� X ( ��������� ���⶧���� �ڵ����� ��ü�� �ߺ��Ұ��� )
				// 1. HashSet Ŭ���� 
					// 1. .add( ��ü�� ) : set ��ü�� ��ü(���) �߰� 
					// 2. .size() : set ��ü�� ��ü(���) ���� 
					// 3. .iterator() : set ��ü ��ȸ �޼ҵ� 
						// * Iterator<���׸�> �������̽��� : �������� ��ü ��ȸ �������̽� 
						// * Iterator<���׸�> iterator = set.iterator();
						//		1. iterator.hasnext() : ���� ��ü ���� ���� Ȯ�� 
						//		2. iterator.next() : ���� ��� �������� 
						// or
						// for( �ӽð�ü�� : set��ü�� ) { }
					// 4. .remove( ��ü�� ) : set ��ü�� ��ü ���� 
					// 5. .clear() : set ��ü�� ��ü ��ü ���� 
				
			// 3. Map
		
		// p.737
		// 1. Hashset Ŭ������ ��ü ���� 
		HashSet<String> set = new HashSet<>(); 
// 1. HashSet : �÷��������ӿ�ũ Ŭ���� // 2. < ���׸� > : Set Ŭ���� �ȿ� ���� �ڷ���// 3. set : ��ü��( �ƹ��ų� )// 4. new : ��ü ������ �޸� �Ҵ� // 5. HashSet<���׸�:��������>() : ������ 
		// 2. set��ü�� ��ü �ֱ� [ set��ü��.add( ��ü�� ) ; 
		set.add("java");		System.out.println(" Ȯ�� : " + set );
		set.add("JDBC");		System.out.println(" Ȯ�� : " + set );
		set.add("Servlet/JSP");	System.out.println(" Ȯ�� : " + set );
		set.add("java");		System.out.println(" Ȯ�� : " + set ); // ��ü �ߺ� �Ұ���
		set.add("iBATIS");		System.out.println(" Ȯ�� : " + set );
		// 3. set��ü�� ��ü ��  [ set��ü��.size() : ]
		System.out.println(" set �ȿ� ����ִ� ��ü �� : " + set.size() );
		
		// 4 . Iterator : ����� ��ü�� �ѹ��� �������� �ݺ��� ���� ( ��ȸ )
			// * set �÷��� ���� ���Ǵ� ���� : �ε����� ���⶧���� ��ü�� ȣ���ϴ� ���X get
		Iterator<String> iterator = set.iterator(); // set��ü�� iterator() : ��ȸ
		while( iterator.hasNext() ) { // .hasNext() : ���� ��� ���� ���� Ȯ�� = ���� ��Ұ� ������ true ������ false;
			String element = iterator.next(); // .next() : ���� ��� �������� 
			System.out.println("\t"+element);
		}
		// * for���� �÷��� Ȱ�� 
			// for( �ӽ� ��ü�� : �÷���/�迭 )  : �÷���/�迭�� ��ҵ��� �ѹ��� �������� �ݺ��� 
		for( String element : set ) {	
			System.out.println( "\t"+element );
		}
		
		// 5. set��ü��.remove( ��ü�� ) : set��ü�� �ش� ��ü�� ����
		set.remove("JDBC");		System.out.println(" Ȯ�� : " + set );
		set.remove("iBATIS");	System.out.println(" Ȯ�� : " + set );
		
		// 6. set��ü��.clear() : set��ü�� ��� ��ü�� ����[���� ]
		set.clear();  			System.out.println(" Ȯ��3 : " + set );
		
	}

}


















