package Day07;

import java.util.*;

public class Day07_5_BookApplication {
	
	// BookApplication Ŭ���� : ����� �����ڵ�
	// Book Ŭ���� : ���� ���� �ڵ� 
	// Member Ŭ���� : ȸ�� ���� �ڵ� 
	
	// * ���� �뿩 console ���α׷�[ Ŭ�������� ]
		// 1. Ŭ���� ���� 
			// 1. book
				// �ʵ� : ISBN(������ȣ) , ������ , �۰� , �����뿩���� , �뿩ȸ��
				// �޼ҵ� : 1.�����˻� 2.������� 3.�����뿩 4.�����ݳ� 5.������� 6.��������
			// 2. member
				// �ʵ� : ��ȣ,���̵�,��й�ȣ,�̸�,����ó
				// �޼ҵ� : 1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��
		// 2. ȭ�� ���� 
			// 1. �ʱ� �޴� [ 1.ȸ������ , 2.�α��� , 3.���̵�ã�� , 4.��й�ȣã��  ]
			// 2. �Ϲ�ȸ���޴� [ 1.�����˻� 2.������� 3.�����뿩 4.�����ݳ� 5.�α׾ƿ� ]
			// 3. �����ڸ޴�  [ 1.������� 2.������� 3.�������� 4.����(����) 5.�α׾ƿ�
	
	// * main �ۿ� ������ �����ϴ� ���� : ��� �޼ҵ忡�� ����ϱ� ���ؼ� 
		// ��������  :  { �������� } ��ȣ������ ����� ������ { } ���� ������
			// ���� �ٸ� { } ��ȣ ������ ���� -> �������� 
		// static  : ���α׷� ���۽� �޸� �Ҵ� / ���α׷� ����� �޸� �ʱ�ȭ
			// ���α׷� ���������� ������ ���Ǵ� �޸�[����]
	
	static Scanner scanner = new Scanner(System.in); // static : �������� ��밡�� 
	static Member[] members = new Member[1000]; // ��� Ŭ�������� ����ϴ� ȸ����� �迭
	static Book[] books = new Book[1000];
	
	// 0. �ڵ带 �о��ִ� ���� �޼ҵ� [ ������ ]
	public static void main(String[] args) { // main s
		// �޼ҵ� ȣ�� 
			// 1.����ȣ�� 
				// menu();
				// static : �޸� �켱�Ҵ� �̱⶧���� static �� �޼ҵ�,�ʵ� ������
				// main �޼ҵ� static �޼ҵ� �̱⶧���� static �޼ҵ常 ����ȣ�� ����
			// 2. �ܺ�ȣ��
				// 1. ��ü ����(�޸��Ҵ�) -> �޼ҵ� ȣ�� 
				Day07_5_BookApplication application = new Day07_5_BookApplication();
				application.menu();
				
	} // main end  
	// 1. �ʱ� �޴� �޼ҵ�
	void menu() {
		while( true) { // ���ѷ��� [ �������� ���� ]
			System.out.println("-------------- ���� �뿩 ���α׷� -------------");
			System.out.print("1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã�� : ");
			int ch = scanner.nextInt();
			Member member = new Member(); // 1~4 {}��ȣ���� ��� ����
			if( ch == 1 ) {
				
				boolean result =  member.ȸ������();// ȸ������ �޼ҵ� ȣ�� 
				if( result ) 
					System.err.println(" �˸�]] ȸ������ ���� ");
				else 
					System.err.println(" �˸�]] ȸ������ ����");
				
			} 
			else if( ch ==2 ) {
				String result = member.�α���(); // �α��� �޼ҵ� ȣ�� 
				
				if( result == null ) { // �α��ν��� 
					System.out.println(" �˸�]] ������ ȸ�������� �����ϴ�.");
				}else if( result.equals("admin")) { // ������
					// 2. ������ �޴� �޼ҵ� ȣ�� 
					System.out.println(" �˸�]] �ȳ��ϼ���~ "+result+"��");
					adminmenu(); // ���� �޼ҵ� ȣ��
				}else{ // �Ϲ� 
					// 1. �Ϲ�ȸ�� �޴� �޼ҵ� ȣ��
					System.out.println(" �˸�]] �ȳ��ϼ���~ "+result+"��");
					membermenu( result ); // �μ�1�� [ �α��� ������ id ] 
				}
			}
			else if( ch ==3 ) {
				member.���̵�ã��();// ���̵� ã�� �޼ҵ� ȣ�� 
			}
			else if( ch ==4 ) {
				member.��й�ȣã��(); // ��й�ȣ ã�� �޼ҵ� ���� 
			}
			else { System.err.println(" �˸�]] �˼� ���� ��ȣ�Դϴ�. "); } 
		}
	} // menu end 
	
	// 2. �Ϲ�ȸ�� �޴� �޼ҵ�
	void membermenu( String loginid ) { // �μ� �������� �޶� ������ �ڷ��� ���� 
		while(true) {
			System.out.println(" --------------- ȸ�� �޴� ------------------");
			System.out.print("1.�����˻� 2.������� 3.�����뿩 4.�����ݳ� 5.�α׾ƿ� ���� : ");
			int ch = scanner.nextInt();
				Book book = new Book(); // ������ڷ� ��ü => �޼ҵ� ȣ���
			if( ch == 1 ) 		{ book.�����˻�(); }
			else if( ch ==2 ) 	{ book.�������(); }
			else if( ch == 3 ) 	{ book.�����뿩( loginid ); }
			else if( ch == 4 ) 	{ book.�����ݳ�( loginid ); }
			else if( ch == 5 ) 	{ return; } // �Ϲ�ȸ���޴� �޼ҵ� ���� [ �α׾ƿ� ] 
			else { System.err.println(" �˸�]] �˼� ���� ��ȣ�Դϴ�. "); }
		}
	} // �Ϲ�ȸ�� �޴� ���� 
	// 3. ������ �޴� �޼ҵ� 
	void adminmenu() {
		while(true) {
			System.out.println(" --------------- ������ �޴� ------------------");
			System.out.print("1.������� 2.������� 3.�������� 4.�α׾ƿ� ���� : ");
			int ch = scanner.nextInt();
				Book book = new Book();
			if( ch == 1 ) 		{ book.�������(); }
			else if( ch == 2 ) 	{ book.�������(); }
			else if( ch == 3 ) 	{ book.��������(); }
			else if( ch == 4 ) 	{ return; }		// �����ڸ޴� �޼ҵ� ���� 
			else { System.err.println(" �˸�]] �˼� ���� ��ȣ�Դϴ�. "); }
		}
	}
	
	
} // class end 














