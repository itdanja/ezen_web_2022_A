package Day11;

import java.util.Scanner;

public class Day11_4_BoardApp {
	/*
	 *  ��ȸ���� �Խ���/��� ���α׷� [ ����ó�� , ����ó�� , ����Ʈ ]
	 * 		// [m]�Խù� Ŭ���� 
	 * 				// ���� , ��\�� , �н����� , �ۼ��� , �ۼ��� , ��ȸ�� , ��۸���Ʈ
	 * 		// [m]��� Ŭ���� 
	 * 				// ���� , �н����� , �ۼ��� , �ۼ��� 
	 * 		// [c]��Ʈ�ѷ� Ŭ����
	 * 				// 1.��� 2.���� 3.���� 4.���� 5.���� 6.��۾���
	 * 				// 7.�Խù����� 8.�Խù��ҷ����� 9.������� 10.��ۺҷ����� 
	 * 		// [v]Day11_4_BoardApp Ŭ���� 
	 * 				// ����� [ �Է¹޾� ��Ʈ�ѷ����� �Է¹��� �� ���� ] 
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 1.�Է°�ü
		Controller.load(); // 2. ����[ ��� �Խù�] �ҷ����� 
		while(true) {
			try { // ���ܹ߻� : ����ڰ� �����Է½� ���ܹ߻�!!! -> catch �̵� 
				// ��� �Խù� ��� 
				System.out.printf("%s\t%10s\t%10s\t%10s\t%2s\t \n","��ȣ","����","�ۼ���","�ۼ���","��ȸ��");
				int i = 0; // ����Ʈ�� �ε���
				for( Board board : Controller.boadlist ) {
					System.out.printf("%2s\t%10s\t%10s\t%10s\t%2s\t \n", i , board.getTitle() ,
							board.getWriter() , board.getDate() , board.getViewcount() );
					i++;
				}
				System.out.print("1.���� 2.���� ���� : ");
				int ch = scanner.nextInt();
				if( ch == 1 ) {
					System.out.println(" *** �Խù� ��� ***");
						// nextLine() : �������� �Է°��� [ ����! : nextLine �տ� �ϴ� next �ϳ��� ���]
						// �ذ��� : �Ϲ�next �� nextLine ���̿� nextLine()
					scanner.nextLine();
					System.out.print(" ���� : ");	String ���� = scanner.nextLine();
					System.out.print(" ���� : ");	String ���� = scanner.nextLine();
					System.out.print(" �ۼ��� : ");	String �ۼ��� = scanner.next();
					System.out.print(" ��й�ȣ[����/������] : "); String ��й�ȣ = scanner.next();
					Controller.write( ���� , ���� , �ۼ��� , ��й�ȣ ); // �μ� ���� 
				}
				else if( ch == 2 ) {
					// �ش� �Խù� ��ȣ[�ε���] �� �Է¹޾� �Խù����� ��� ���
					
					// �޴� 
					System.out.print("1.�ڷΰ��� 2.���� 3.���� 4.��۾��� ���� : ");
					
				}
				else {}
			}catch( Exception e ) {
				System.err.println(" �޽���]] ��ȣ�� �Է����ּ���.");
				scanner = new Scanner(System.in); // �ٽ� �޸��Ҵ�[ ���� ���빰 ����� ] 
			}
		}
	} // main end 
	
} // class end 











