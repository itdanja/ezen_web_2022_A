package Day06;

import java.util.Scanner;

public class Day06_6 { // c s 
	
	// ��ȸ���� �Խ��� [ Ŭ���� ���� ]
		// 0. �Խù� ���� => Ŭ���� ���� 
			// �ʵ� : ���� , ���� , �ۼ��� , ��й�ȣ
			// ������ : ������� ����
		// 1. ùȭ�� [ ��� �Խù�(��ȣ,�ۼ���,����) ��� ]
		// 2. �޴� [ 1. �۾��� 2.�ۺ��� ]
			// 1. �۾��� [ ���� , ���� , �ۼ��� , ��й�ȣ => 4������ -> ��üȭ ]
			// 2. �ۺ��� [ �ش� �۹�ȣ�� �Է¹޾� �ش� �� ��������(��ȣ,�ۼ���,����,����) ǥ�� ]
				// �۹�ȣ�� �迭�� ����Ǵ� ���� [ �ε��� ]
				// �ۺ��� �޴� 
		// 3. �ۺ��� �޴� [ 1. ��Ϻ��� 2.���� 3.���� ]
			// 1. ������ : �ۼ��ڿ� ��й�ȣ �Է¹޾� �����ϸ� ����
			// 2. ������ : �ۼ��ڿ� ��й�ȣ �Է¹޾� �����ϸ� ����� ���븸 ���� 
	
	public static void main(String[] args) { // m s 
		
		// �غ� [ ��� {} �ȿ��� ���Ǵ� ���� ���� ]
		Scanner scanner = new Scanner(System.in); // 1. �Է°�ü
		Board[] boardlist = new Board[100]; // * Board ��ü�� 100���� �����Ҽ� �ִ� 1���� �迭 ���� 
		
		while(true) { // ���α׷� ���� ���ѷ��� [ �������� : x ]
			System.out.println("--------- Ŀ�´�Ƽ ----------");
			////////////////////////////// ��� �Խù� ��ȸ //////////////////////
			System.out.println("��ȣ\t�ۼ���\t����");
			int index = 0; // �ε��� ���� [ �迭�� ��ü �� üũ ]
			for( Board board : boardlist ) { // �迭�� ��� ��ü(�Խù�) ��� �ݺ��� 
				if( board != null ) { // ���࿡ �ش� board ��ü�� ���빰�� ������ ���
					System.out.printf("%d\t%s\t%s \n" , index , board.writer , board.title);
				}
				index++; // �ε��� ����
			}
			//////////////////////////////////////////////////////////////
			System.out.println("1.�۾��� 2.�ۺ��� ");
			int ch = scanner.nextInt();
			if( ch== 1 ) { // 1. �۾��� 
/////////////////////////////////////// �۾��� /////////////////////////////////
				// 1. 4�� ������ �Է¹޴´� 
				System.out.println("----------------- �� ���� ������ ----------------");
				System.out.print(" title : ");		String title = scanner.next();
				System.out.print(" content : ");	String content = scanner.next();
				System.out.print(" writer : ");		String writer = scanner.next();
				System.out.print(" password : ");	String password = scanner.next();
				// 2. 4�� ������ ��üȭ [ ��ü�� ���� 4�������� ��ü�� �ʵ忡 ���� ]
				Board board = new Board( title , content , writer , password ); // 4�� �ʵ带 ���� ������ ���
				// 3. �迭�� ������� ã�Ƽ� ������� ��ü ����
				int i = 0;
				for( Board temp : boardlist ) {
					if( temp == null ) { // ����� ã������ 
						boardlist[i] = board; // �ش� �ε����� ���ο� ��ü ���� 
						break; // �ѹ� ���������� �ݺ��� ���� 
					}
					i++;
				}
//////////////////////////////////////////////////////////////////////////
			}
			
			else if( ch==2 ) { // 2. �ۺ��� 
				
			}
			else {
				System.err.println(" �˸�)) �˼����� ��ȣ�Դϴ�. ");
			}
			
		} // ���α׷� while end  
		
	} // m e 
} // c e 






