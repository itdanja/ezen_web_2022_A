package Day13;

import java.util.Calendar;

public class Day13_3_�޷� {
	public static void main(String[] args) {
		
		// 1. Ķ���� Ŭ������ ���� ��¥/�ð� ��ü ȣ�� 
		Calendar calendar = Calendar.getInstance();
		// 2. ���� ���� , �� , �� ȣ�� 
		int year = calendar.get( Calendar.YEAR);
		int month = calendar.get( Calendar.MONTH)+1; // +1 �ϴ����� : 0:1��~11:12��
		int day = calendar.get( Calendar.DAY_OF_MONTH );
		// * �ش� ���� 1���� ����ã�� 
			// 1. ����� ���� Ķ���� ���� 
			calendar.set( year , month-1 , 1 ); // ��) 3��1��
				System.out.println( "����ڰ� ��¥����� : "+ calendar.toString() );
			// 2. 3��1���� ���� 
			int sweek = calendar.get( Calendar.DAY_OF_WEEK );
				System.out.println( "���ϱ��ϱ� : "+ sweek );
			// 3. 3���� ������ �� 
			int eday = calendar.getActualMaximum( Calendar.DAY_OF_MONTH );
				System.out.println( "�ش糯¥�� ������ �ϼ� : " + eday );
		// 3. ��� 
		System.out.println(" ****** "+year+"��" + month+"�� ******");
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		
		
		
	}
}





