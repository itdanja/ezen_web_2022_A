package Day13;

import java.util.Calendar;
import java.util.Scanner;

public class Day13_3_�޷� {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner( System.in);
		System.out.print(" ���� :"); int year = scanner.nextInt();
		System.out.print(" �� :");	int month = scanner.nextInt();
		
		�޷�( year , month );
		
	} // main end 
	
	//1.�޷¸޼ҵ� 
	public static void �޷�( int year , int month ) {
		
		// 1. Ķ���� Ŭ������ ���� ��¥/�ð� ��ü ȣ�� 
		Calendar calendar = Calendar.getInstance(); //��) 2022��3��18��
		// 2. ���� ���� , �� , �� ȣ�� 
			//int year = calendar.get( Calendar.YEAR);
			//int month = calendar.get( Calendar.MONTH)+1; // +1 �ϴ����� : 0:1��~11:12��
		int day = calendar.get( Calendar.DAY_OF_MONTH );
		// * �ش� ���� 1���� ����ã�� 
			// 1. ����� ���� Ķ���� ���� 
			calendar.set( year , month-1 , 1 ); // ��) 2022��3��1��
			// 2. 3��1���� ���� 
			int sweek = calendar.get( Calendar.DAY_OF_WEEK );
			// 3. 3���� ������ �� 
			int eday = calendar.getActualMaximum( Calendar.DAY_OF_MONTH );
		// 3. ��� 
		System.out.println(" ********************** "+year+"��" + month+"�� ******************");
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		
		// * ���� �� 1���� ��ġ �տ� ���� ä��� 
		for( int i = 1 ; i < sweek ; i++ ) {
						// 3��1�� = ȭ = 3 
			System.out.print("\t"); // �������
		}
		
		// 1�Ϻ��� ��������¥ ���� ��� 
		for( int i = 1 ; i<=eday ; i++ ) {
			 // i = �ϼ� ���
			System.out.print(i+"\t");
			
			// ����ϸ��� �ٹٲ�ó�� [ �����=7 ] ������ 7�������
			if( sweek % 7 == 0 ) System.out.println();
			
			 // �Ϸ羿 ���� ���� 
			sweek++;
		}
		
		// ��ư [ 1.��(������)  2.��(������) 3.�ٽð˻� ]
		
		
		
	} // �޷� �޼ҵ� end 
	
} // class end 





