package Day12;

import java.util.Random;
import java.util.Scanner;

public class Day12_4_������ȣ�й����α׷� {
	
	// ������ȣ �й� ���α׷�
	// ���� 
		// 1. ���� 0000~9999[4�ڸ� ����] ������ ���� 10�� �����ؼ� �迭�� ���� 
		// 2. ��� ���� ��ȣ�� �迭�� ���� 
		// 3. ���ڸ� ��ȣ�� Ȧ/¦ ����
		// 4. ���� ��¥���� ��ȣ�� Ȧ�� ���� �迭�� ����  
		// 5. ���� ��¥���� ��ȣ�� ¦�� ���� �迭�� ���� 
		// 6. Ȧ������ �迭 ��� // ¦������ �迭 ���
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in); // *�Է°�ü 
		String[] carlist = new String[10]; // *���ڿ� 10�� �����Ҽ� �ִ� �迭 [ ������ȣ �ִ� 10�� ���� ���� ] 
		String[] evenlist = new String[10]; // ¦������ �迭 
		String[] oddlist = new String[10]; // Ȧ������ �迭 
		while(true) { // ���ѷ��� 
			
			// ��� ���� ��ȣ ��� 
			System.out.println(" \n*** �������� ��� ������ȣ *** ");
			for( String temp : carlist  ) {
				if( temp != null ) {
					if( Integer.parseInt(temp) % 2 == 0 ) { // ��%2==0 �������� 0�̸� ¦�� 
						System.out.print( temp+"[¦]  " );
					}else {			// ��%2 == 1 �������� 1�̸� Ȧ�� 
						System.out.print( temp+"[Ȧ]  " );
					}
				}
			}
			// Ȧ������ ��ȣ ��� 
			System.out.println(" \n*** �������� ��� Ȧ�� ���� [ ���� 2���� ]  *** ");
			for( String temp : oddlist  ) {
				if( temp != null ) { System.out.print( temp+" " ); }
			}
			
			// ¦������ ��ȣ ��� 
			System.out.println(" \n*** �������� ��� ¦�� ���� [ ���� 2���� ]   *** ");
			for( String temp : evenlist  ) {
				if( temp != null ) { System.out.print( temp+" " ); }
					
			}
			System.out.print("\n 1.��������"); int ch = scanner.nextInt();
			if( ch == 1 ) {
				// ������ȣ ���� ���� 
				Random random = new Random(); // ���� ��ü 
				int intnum = random.nextInt(10000); // 0~9999 �� ���� �߻� 
				String strnum = String.format("%04d", intnum ); // %0����d : ���ڸ�ŭ �ڸ��� [ ���� �ش� �ڸ����� ������ 0 ]
				// �迭�� ������ ã�� ������ȣ ���� 
				boolean save = false;
				for( int i = 0 ; i<carlist.length ; i++ ) {
					if( carlist[i] == null ) { carlist[i] = strnum; save=true; break; }
				}
				
				if( save == true ) {
					// ¦��Ȧ�� ���� �й� 
					if( Integer.parseInt(strnum) % 2 == 0 ) { // ��%2==0 �������� 0�̸� ¦�� 
						// ¦�������迭�� ���� 
						for( int i = 0 ; i<evenlist.length ; i++) {
							if( evenlist[i] == null ) { evenlist[i] = strnum; break; }
						}
					}else {		// ��%2 == 1 �������� 1�̸� Ȧ�� 
						for( int i = 0 ; i<oddlist.length ; i++) {
							if( oddlist[i] == null ) { oddlist[i] = strnum; break; }
						}
					}
				}
				
				// ���࿡ ������� ������ ���� 
				if( save == false )System.err.println(" ���� [ ���� �Ұ� ] ");
			}
		}
		
		
	}
	
}










