package Day10;

import java.util.Scanner;

public class Day10_7_Ű����ũ {
	// ��� : ���� 
	// Ŭ���� : �Ե����� , ����ŷ
	// �������̽� : Ű����ũ  
	// ����ó�� : ��ǰ��� ����
	public static void main(String[] args) {
		
		Ű����ũ �Ե����� = new �Ե�����();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			�Ե�����.��ǰ���();
			int ch = scanner.nextInt();
			if( ch == -1 ) {
				�Ե�����.��ǰ�߰�();
			}
		}
		
	}
}
