package ������.���α׷��־������;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
//		// (2022-03-22����)���� ���� �׽�Ʈ 
//		Car car = new Car( LocalDate.of(2022, 3, 22)  , 
//				"250��7142",
//				LocalTime.of( 17, 30 , 0 ),
//				null, 
//				0 );
//		Controller.carlist.add(car);
//		
//		// 1�� �̿� ���� �׽�Ʈ 
//		Car car2 = new Car( LocalDate.of(2022, 3, 21)  , 
//				"250��7143",
//				LocalTime.of(23, 30 , 0 ),
//				null, 
//				0 );
//		Controller.carlist.add(car2);
//		
//		// 2�� �̿� ���� �׽�Ʈ 
//		Car car3 = new Car( LocalDate.of(2022, 3, 20)  , 
//				"250��7141",
//				LocalTime.of(23, 30 , 0 ),
//				null, 
//				0 );
//		Controller.carlist.add(car3);
		
		
		while( true ) {
			// 1. ��� ���� ǥ ��� 
				System.out.println("============================== ���� ��Ȳ ǥ ================================");
				// ���� ��¥�� ȣ���ϱ� ���� date Ŭ������ü���� 
				Date date = new Date();
				// ��¥ ���� ����
				SimpleDateFormat dateFormat = new SimpleDateFormat("����ð� : yyyy-MM-dd hh:mm");
				// ������ �����ؼ� ����Ѵ�.
				System.out.println( "\n\t\t\t"+ dateFormat.format(date)+"\n" );

				System.out.println("��¥\t\t������ȣ\t\t�����ð�\t\t�����ð�\t\t�ݾ�");
				
						// �迭�̳� ����Ʈ�� ��� ��ü ȣ�� �ݺ���
					for( Car temp : Controller.carlist ) {
						System.out.print( temp.get��¥() + "\t" );
						System.out.print( temp.get������ȣ() + "\t" );
						System.out.print( temp.get�����ð�().getHour() + ":" );
						System.out.print( temp.get�����ð�().getMinute() + "\t\t" );
						
						if( temp.get�����ð�() == null ) {
							System.out.print( "���� ��\t\t" );
						}else {
							System.out.print( temp.get�����ð�().getHour() + ":" );
							System.out.print( temp.get�����ð�().getMinute() + "\t\t" );
						}
						
						if( temp.get�����ð�() == null ) {
							System.out.print( "���� ��\n" );
						}else {
							DecimalFormat decimalFormat = new DecimalFormat("#,###"); // �ݾ� ��½� õ���� ���н�ǥ �������� ��ȯ�ϱ�
							System.out.print( decimalFormat.format( temp.get�ݾ�() ) + "\n" );
						}
					}
				System.out.println("\n=========================================================================");
				// 
			System.out.print("\n\t\t\t 1.���� \t  2.���� : ");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) {
				// 1. ������ȣ�� �Է¹޴´�.
					// �Է� 
				System.out.print(" �Է�) ������ȣ :  "); String ������ȣ = scanner.next();
				// 2. �Է¹��� ������ȣ�� ��Ʈ�ѳ� �޼ҵ� ���� �ѱ��.
				// 3. �޼ҵ� ��� �� ���� ��� 
				boolean ��� = Controller.����(������ȣ);
				if( ��� ) { System.out.println(" �Ϸ�) ������ ���� �Ǿ����ϴ�. ");}
				else { System.out.println(" ����) ������ ������ȣ�� �����մϴ�. "); }
			}else if( ch == 2 ){
				// 1. ������ȣ�� �Է¹޴´�.
					// �Է�
				System.out.print(" �Է�) ������ȣ :  "); String ������ȣ = scanner.next();
				// 2. �Է¹��� ������ȣ�� ��Ʈ�ѳ� �޼ҵ� ���� �ѱ��.
				// 3. �޼ҵ� ��� �� ���� ��� 
				Boolean ��� = Controller.����(������ȣ);
				if( ��� ) { System.out.println(" �Ϸ�) ������ ���� �Ǿ����ϴ�. ");}
				else { System.out.println(" ����) ������ ������ȣ�� �������� �ʽ��ϴ�. "); }
			}
			
		}
		
	} // 
} // 
