package Day09;

import java.util.Scanner;

public class Day09_6_����������α׷� {
	
	// ����������α׷� [ ��� ] 
		// ����[super]
		// ��������[sub] , ��������[sub] , �ϳ�����[sub]
		// �� ��� : 1.���»��� 2.�Ա� 3.��� 4.��ü 5.�����¸�� 6.���� 
	
	// ** main �ۿ��� �����ϴ� ���� 
		//* ��� Ŭ�������� ����ϱ� ���� static �迭�� ����
		// static������ ���α׷� ���۽� �޸��Ҵ� -> ���α׷� ����� �޸��ʱ�ȭ
	public static ����[] ���¸���Ʈ = new ����[100]; 
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) { // ���α׷� ���ѷ��� [ �������� x ] 
			System.out.println("----------- ���� �ý��� --------");
			System.out.print("1.���»��� 2.�Ա� 3.��� 4.��ü 5.���¸�� 6.���� ���� : ");
			int ���� = scanner.nextInt();
			// ��Ʈ�ѷ� �޼ҵ� ȣ��� ��ü 
			������Ʈ�ѷ� ��Ʈ�� = new ������Ʈ�ѷ�();
			if( ���� == 1 ) {
				// �Է�
				System.out.println("+++ ���µ�� ������ +++");
				System.out.print("��й�ȣ : "); String ��й�ȣ = scanner.next();
				System.out.print("������ : "); String ������ = scanner.next();
				System.out.print("���༱�� < 1.����2.����3.�ϳ� > : "); int �����ȣ = scanner.nextInt();
				// ��Ʈ�ѷ� ���� 
				Boolean result =  ��Ʈ��.���»���(��й�ȣ, ������, �����ȣ);
				if( result  ) { // result  �� true �̸� 
					System.out.println(" ** ���� ���� ** ");
				}else { // result �� false �̸� 
					System.out.println(" �˸� ]] ���µ�� ���� (�����ڿ��Թ���)");
				}
				
			}
			else if( ���� == 2 ) {
				System.out.println("+++ �Ա� ������ +++");
			}else if( ���� == 3 ) {
				System.out.println("+++ ��� ������ +++");
			}else if( ���� == 4 ) {
				System.out.println("+++ ��ü ������ +++");
			}else if( ���� == 5 ) {
				System.out.println("+++ ���¸�� ������ +++");
			}else if( ���� == 6 ) {
				System.out.println("+++ ���� ������ +++");
			}else {
				System.err.println(" �˸�]] �˼����� ��ȣ�Դϴ�. ");
			}
		} // while ���α׷� end
	} // main end 
} // class end 






