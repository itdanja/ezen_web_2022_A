package Day18;

import java.util.Vector;

public class Day18_2 {
	
	
	public static void main(String[] args) {
		
		// p.730
		//		 ArrayList 		vs Vector
		//����ȭ	    X		   		 O 
		//������	 �̱۽�����(main)	  ��Ƽ������( Thread , Runnable )
		
		// Vector Ŭ���� 
		// 1. Vector ����Ʈ��ü ����
		Vector<Board> list = new Vector<>();
		// 2. ����Ʈ��ü�� �߰� 
			// 1. ����Ʈ�� ��ü �ٷ� �߰� new : ��ü �޸��Ҵ�
		list.add( new Board("����1", "����1", "�۾���1") );
			// 2. ��ü ������ ����Ʈ�� ��ü �߰� 
		Board board = new Board("����2","����2","�۾���2");
		list.add( board );
		list.add( new Board("����3", "����3", "�۾���3") );
		list.add( new Board("����4", "����4", "�۾���4") );
		list.add( new Board("����5", "����5", "�۾���5") );
		System.out.println(" Ȯ�� : " + list  );
		// 3. �˻�
		System.out.println(" ��ü �˻� : " + list.contains(board) );
		System.out.println(" ��ü �˻� ��ġ : " + list.indexOf(board) );
		// 4. ���� [ ������ �ε��� �ڷ� ��ĭ�� ���� ]
		list.remove(2); System.out.println(" 2�� �ε��� ���� �� :"+list);
		list.remove(2); System.out.println(" 2�� �ε��� ���� �� :"+list);
		// * �ݺ����̿��� ����Ʈ��ü�� ��� ��ü ��� 
		System.out.println("----------------------------");
		System.out.println("����\t����\t�ۼ���");
		for( int i = 0 ; i<list.size() ; i++ ) {
			Board temp = list.get(i); // i��° �ε����� ��ü ȣ�� 
			System.out.println( temp.����+"\t"+temp.����+"\t"+temp.�ۼ���);
		}
		// * �ݺ���2
		System.out.println("----------------------------");
		System.out.println("����\t����\t�ۼ���");
		for( Board temp : list  ) {
			System.out.println( temp.����+"\t"+temp.����+"\t"+temp.�ۼ���);
		}
		
		
	}

}











