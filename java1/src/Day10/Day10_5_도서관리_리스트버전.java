package Day10;

import java.util.ArrayList;
import java.util.Scanner;

public class Day10_5_��������_����Ʈ���� {
	
	public static void main(String[] args) {
		
		// 1. ����Ʈ[��ü] ���� 
		ArrayList< Book > booklist = new ArrayList<>();
	//  ����ƮŬ����< ����Ʈ�ȿ� ������ Ŭ���� >
		// < Ŭ���� > : �ش� Ŭ������ ���� ��ü�� ����Ʈ�� ����  // ���̴� ���� [ �⺻ : 10 ]
		Scanner scanner = new Scanner(System.in); // �Է°�ü 
		while(true) {
			System.out.print("1.���2.���3.����4.���� ���� : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) {
				// 1. ���� �Է¹ޱ� 
				System.out.print("������ : "); 	String ������ = scanner.next();
				System.out.print("���� : "); 		String ���� = scanner.next();
				// 2. ��üȭ[ ������ ���� ---> 1�� ��ü ]
				Book book = new Book(������, ����);
				// 3. �迭���� [ ������ ã�Ƽ� ] vs ����Ʈ[ ����ã��x ]
				booklist.add(book); // ����Ʈ�� ���� 
				// ????? : .add( ��ü�� ) // ������ �ε����� �ڵ������� ��ü�� �߰� 
			}
			if( ch == 2 ) {
				// 1.�迭[ null ���� ]  vs ����Ʈ
				System.out.println("������\t����");
				for( Book book : booklist ) {
					System.out.println(book.get������() +"\t"+book.get����());
				}
			}
			if( ch == 3 ) {}
			if( ch == 4 ) {}
		}
	}
}




