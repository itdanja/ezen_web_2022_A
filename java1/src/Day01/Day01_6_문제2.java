package Day01;

import java.util.Scanner;

public class Day01_6_����2 {
	
	
	
	public static void main(String[] args) { // m s 
		
		// �Է� -> ���� -> ��� 
		// 1. �Է°�ü ����
		Scanner scanner = new Scanner(System.in);
		// 2. �Է��� ��� �ȳ� // 3. �Է¹��� ������ �ٸ����� ���� [ ��??? ����� ] 
		System.out.print(" �ۼ��� : ");	String writer = scanner.next();
		System.out.print(" ���� : ");	String content = scanner.next();
		System.out.print(" ��¥ : ");	String date = scanner.next();
		// 3. ���
		System.out.println("-------------- �湮�� -----------------");
		System.out.println("����\t�ۼ���\t����\t��¥");
		System.out.println( 1 +"\t"+ writer +"\t"+ content +"\t"+ date );
		System.out.println("-------------------------------------");
		
	} // m e 
	
	
	/*
	����2 : �ϳ��� �湮�� 
	[�Էº���]
		1. �ۼ��� , ���� , ��¥ 
	[��� ��]
		 *  --------------�湮��--------------------
		 *  | ���� | �ۼ��� | 	���� 	  | ��¥  |
		 *  |  1    | ��ȣ�� | �ȳ��ϼ���  | 09-28 |
		 *  ----------------------------------------
	*/
}
