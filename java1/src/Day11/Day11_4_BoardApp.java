package Day11;

import java.util.Scanner;

public class Day11_4_BoardApp {
	/*
	 *  ��ȸ���� �Խ���/��� ���α׷� [ ����ó�� , ����ó�� , ����Ʈ ]
	 * 		// [m]�Խù� Ŭ���� 
	 * 				// ���� , ���� , �н����� , �ۼ��� , �ۼ��� , ��ȸ�� , ��۸���Ʈ
	 * 		// [m]��� Ŭ���� 
	 * 				// ���� , �н����� , �ۼ��� , �ۼ��� 
	 * 		// [c]��Ʈ�ѷ� Ŭ����
	 * 				// 1.��� 2.���� 3.���� 4.���� 5.���� 6.��۾���
	 * 				// 7.�Խù����� 8.�Խù��ҷ����� 9.������� 10.��ۺҷ����� 
	 * 		// [v]Day11_4_BoardApp Ŭ���� 
	 * 				// ����� [ �Է¹޾� ��Ʈ�ѷ����� �Է¹��� �� ���� ] 
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try { // ���ܹ߻� : ����ڰ� �����Է½� ���ܹ߻�!!! -> catch �̵� 
				Controller.boardlist(); // ��ü���� �޼ҵ�ȣ���� �Ǵ����� : static�޼ҵ� �̱⶧����
				System.out.print("1.���� 2.���� ���� : ");
				int ch = scanner.nextInt();
				if( ch == 1 ) {}
				else if( ch == 2 ) {}
				else {}
			}catch( Exception e ) {
				System.err.println(" �޽���]] ��ȣ�� �Է����ּ���.");
				scanner = new Scanner(System.in); // �ٽ� �޸��Ҵ�[ ���� ���빰 ����� ] 
			}
		}
	} // main end 
	
} // class end 











