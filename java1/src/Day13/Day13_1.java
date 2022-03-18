package Day13;

import java.util.Random;

public class Day13_1 {

	public static void main(String[] args) {
		
		// p.534 : Math Ŭ���� (java.lang��Ű��) [ ���� ���� �޼ҵ� ���� ] ��ü���� ��밡�� 
		// 1. Math.abs(��) : �ش� ���� ���밪 
		System.out.println(" ���밪 : " + Math.abs(-5) );
		System.out.println(" ���밪 : " + Math.abs(-3.14) );
		// 2. Math.ceil(��) : ����� ������ �ø�
		System.out.println(" �ø��� : " + Math.ceil(5.3) ); // �Ҽ��� ù°�ڸ����� �ø�
		System.out.println(" �ø��� : " + Math.ceil(-5.3) ); // -5
		// 3. Math.floor(��) : ����� ������ ����
		System.out.println(" ������ : " + Math.floor(5.3) );
		System.out.println(" ������ : " + Math.floor(-5.3) ); // -6
		// 4. Math.max(��1 , ��2) : �� �� �� �� �� ū�� 
		System.out.println(" �ִ� : " + Math.max( 5 , 9) ); // 9
		System.out.println(" �ִ� : " + Math.max( 5.3 , 2.5 )); // 5.3
		// 5. Math.min(��1 , ��2) : �� �� �� �� �� ������ 
		System.out.println(" �ּڰ� : " + Math.min( 5 , 9 )); // 5
		System.out.println(" �ּڰ� : " + Math.min( 5.3 , 2.5 )); // 2.5
		// 6. Math.random() : 0~1 ������ (double)�� ���� �߻�
		System.out.println(" ���� : " + Math.random() ); // 0~1 ������ ���� �߻� 
		// 7. Math.rint( �� ) : ����� ������ �Ǽ������� �ݿø� 
		System.out.println(" ����� ������ �Ǽ��� : "+Math.rint(5.3) ); // �ݿø�[5�̻� �ø�]
		System.out.println(" ����� ������ �Ǽ��� : "+Math.rint(5.7) ); // 
		// 8. Math.round( �� ) : ����� ������ ���������� �ݿø� 
		System.out.println(" ����� ������ ������ : "+Math.round(5.3) );
		System.out.println(" ����� ������ ������ : "+Math.round(5.7) );
		// 9. Ư�� �Ҽ��� ��ġ���� �ݿø� [ round( ):�Ҽ��� ù°�ڸ����� �ݿø� ]
		double value = 12.3456; // �Ҽ� ��°�ڸ����� �ݿø�
		double temp1 = value * 100; // 12.3456*100 -> 1234.56
		long temp2 = Math.round(temp1); // 1234.56 �ݿø� => 1235
		double v16 = temp2/100.0;
					// temp2/100 -> long/int -> �⺻������ : int
					// temp2/100.0-> long/double -> �⺻�Ǽ��� : double
		System.out.println( " v16 : " + v16 );
		
		//10.p.536 : �ֻ��� [ 1~6]
		System.out.println("0~1������ �Ǽ��� : "+ Math.random() ); // 0~1
		System.out.println( Math.random()*6 ); // 0~1 * 6  -> 0~6
		System.out.println( Math.random()*6 +1 ); // 0~6 +1 -> 1~7
		int num = (int)(Math.random()*6 )+1;
				// (�⺻�ڷ���) ��/����   = ��������ȯ( ū����->�������� : �����ͼս� )
				// double -> int ��������ȯ�� => �Ҽ��� �߸�
		System.out.println( "1~6������ ���� : " + num );
		//////////////////////////////////////////////////
		Random random = new Random();
		System.out.println("1~6������ ���� : "+  (random.nextInt(6)+1) );  // 0~5 + 1 => 1~6
		
		
		
		
		
		
		
		
	}
}
