package Day12;

import java.io.IOException;
import java.util.Arrays;

public class Day12_3_�����˻����α׷� {
	
	public static void main(String[] args) throws IOException {
		
		// ���� �˻� ���α׷�
			// [����]
			// 1. �Է¹ޱ� [ System.in.read() ]
			// 2. String �迭�� ���� ������ ������ �Ǿ� �ִ� ����
				//		String[] ������� = {	
				//			"�ȴ�! ���̹� ��α�&����Ʈ",
				//			"������ ��Ʈ ���� Ȱ�� ������",
				//			"Tucker�� Go ��� ���α׷���",
				//			"ȥ�� �����ϴ� C ���"
				//};
			// 3. �˻���� , ������� 
				// �˻���� : Ư�� ���ڸ� �Է¹޾� ������ ���Ե� ���ڰ� ������ ��� ��� 
					// ����) '���' �˻� ->  "Tucker�� Go ��� ���α׷���" / "ȥ�� �����ϴ� C ���" -> 2�� ���
				// ������� : ������ �������� �Ϻθ� �Է¹޾� ��µ� �������� ��ȣ�� ������ ������� ����
					// ����) '���' �� Language �Է� -> ���õ� �������� ������ ���ڿ� ���ο� ���� �Է¹޾� ->  ���� �Ϸ� 
						// ȥ�� �����ϴ� C ��� ->  ȥ�� �����ϴ� C Language 
		
		
		String[] ������� = {   "�ȴ�! ���̹� ��α�&����Ʈ","������ ��Ʈ ���� Ȱ�� ������",
				"Tucker�� Go ��� ���α׷���","ȥ�� �����ϴ� C ���" };
		
		while( true ) {
			System.out.println("\n\n 1.�˻� 2.����");
			byte[] bytes = new byte[100];
			int count =  System.in.read(bytes); // Ű����κ��� [��Ʈ��] ����Ʈ�� �о���� // �Ϲݿ���!!!! [ ���� ���ѱ�� ]
			// count ���� : �о�� ����Ʈ���� 
			String ch = new String( bytes , 0 , count-2 ); // ����Ʈ�迭 --> ���ڿ� ��ȯ [ -2 = \n\r ���� ]
			
			if( ch.equals("1") ) { 
				System.out.println(" *** �˻� *** ");
				System.out.println(" �˻� : "); count = System.in.read( bytes );
				String search = new String( bytes , 0 , count-2 ); // ã������ 
				
				System.out.println(" *** �˻� ��� *** ");
				for( String temp : ������� ) { // ��� �迭�� ���ڿ��� �ϳ��� �������� 
					if( temp.indexOf(search) != -1 ) { // �ش� ���ڿ��� ã�������� �ε����� �����ϸ�
						// indexOf �޼ҵ� -1 ��ȯ�Ǵ°��� ������ �ܾ ������� [ �˻�x]
						System.out.println( temp ); // �ش� ���ڿ��� ã�����ڰ� �����ϸ� ��� 
					}
				}
				
			}else if( ch.equals("2") ) {
				System.out.println(" *** ���� *** ");
				
			}
			
		}
		
		
		
		
		
		
	}

}
