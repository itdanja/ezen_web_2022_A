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
		
		while( true ) { // ���ѷ��� [ �������� : 4�� ] 
			// 1. Ķ���� Ŭ������ ���� ��¥/�ð� ��ü ȣ�� 
			Calendar calendar = Calendar.getInstance(); //��) 2022��3��18��
			// 2. * �ش� ���� 1���� ����ã�� 
				calendar.set( year , month-1 , 1 ); // ��) 2022��3��1�� // 1. ����� ���� Ķ���� ���� 
				int sweek = calendar.get( Calendar.DAY_OF_WEEK ); // 2. 3��1���� ����
				int eday = calendar.getActualMaximum( Calendar.DAY_OF_MONTH ); // 3. 3���� ������ �� 
			// 3. ��� 
			System.out.println("\n\n********************** "+year+"��" + month+"�� ******************");
			System.out.println("��\t��\tȭ\t��\t��\t��\t��");
			
			// 3-1.* ���� �� 1���� ��ġ �տ� ���� ä��� 
			for( int i = 1 ; i < sweek ; i++ ) { // 3��1�� = ȭ = 3 
				System.out.print("\t"); // �������
			}
			// 3-2. 1�Ϻ��� ��������¥ ���� ��� 
			for( int i = 1 ; i<=eday ; i++ ) {
				System.out.print(i+"\t");  // i = �ϼ� ���
				if( sweek % 7 == 0 ) System.out.println(); // ����ϸ��� �ٹٲ�ó�� [ �����=7 ] ������ 7�������
				sweek++;  // �Ϸ羿 ���� ���� 
			}
			// 4. ��ư [ 1.��(������)  2.��(������) 3.�ٽð˻� 4.���� ]
			try { // ���࿡ try { } �ȿ��� ����[����]�� �߻��ϸ� catch �̵� ( ���α׷� �ٿ�x)
				System.out.print(" \n\n *[ 1.��(������)  2.��(������) 3.�ٽð˻� 4.���� ���� :  ");
				Scanner scanner = new Scanner( System.in ); int ch = scanner.nextInt();
				if( ch == 1 ) { // ������ 
					month = month -1;  // moth -=1 �� �ƹ��ų� ���[����]
					// ���࿡ ���� 0�� �Ǹ� ����1���� , �� 12 �� ���� 
					if( month == 0 ) { year -=1; month = 12; }
				}
				else if( ch == 2 ) { // ������ 
					month += 1; 
					// ���࿡ ���� 13���� �Ǹ� ����1���� , �� �ٽ� 1 �� ����
					if( month == 13 ) { year +=1; month = 1 ;  }
				}
				else if( ch == 3 ) {  // �ٽð˻� 
					System.out.print(" ���� :");  year = scanner.nextInt();
					System.out.print(" �� :");	 month = scanner.nextInt();
				}
				else if( ch == 4 ) { // ���� 
					System.out.println(" �˸� ]] �޷� ���α׷� ���� ");
					break; // ���ѷ��� ���� 
				}else { // �׿� 
					System.out.println(" �˸� ]] �˼� ���� ��ȣ�Դϴ�. ");
				}
			}catch( Exception e  ) { // ���࿡ try{ }���� ����[����] �߻��ϸ� �ش� �ڵ尡 ����
				System.out.println(" ��� ]] �������� �Է��� ���ּ��� [ �����ڿ��Թ���] ");
			}// catch end 
		}// while end 
	} // �޷� �޼ҵ� end 
} // class end 


















