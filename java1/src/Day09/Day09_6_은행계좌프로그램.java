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
			
			������Ʈ�ѷ� ��Ʈ�� = new ������Ʈ�ѷ�(); // ��Ʈ�ѷ� �޼ҵ� ȣ��� ��ü 
			if( ���� == 1 ) {
				// �Է�
				System.out.println("+++ ���µ�� ������ +++");
				System.out.print("��й�ȣ : "); String ��й�ȣ = scanner.next();
				System.out.print("������ : "); String ������ = scanner.next();
				System.out.print("���༱�� < 1.����2.����3.�ϳ� > : "); int �����ȣ = scanner.nextInt();
				// ��Ʈ�ѷ� ���� 
				String ���¹�ȣ =  ��Ʈ��.���»���(��й�ȣ, ������, �����ȣ); // �޼ҵ� ȣ��[ �μ�3��]
				// �޼ҵ� ��ȯ ���� = ���¹�ȣ Ȥ�� null
				// �޼ҵ� ������ �޽��� ���
				if( ���¹�ȣ != null  ) { // ���¹�ȣ  �� null �ƴϸ� 
					System.out.println(" ** ���� ���� ** ");
					System.out.println(" ������ ���¹�ȣ  : " + ���¹�ȣ );
				}else { // ���¹�ȣ�� null �̸�
					System.out.println(" �˸� ]] ���µ�� ���� (�����ڿ��Թ���)");
				}
				
			}
			else if( ���� == 2 ) {
				System.out.println("+++ �Ա� ������ +++");
				System.out.print(" ���¹�ȣ : "); String ���¹�ȣ = scanner.next();
				System.out.print(" �Աݾ� : "); int �Աݾ� = scanner.nextInt();
				
				boolean result = ��Ʈ��.�Ա�( ���¹�ȣ , �Աݾ� );
				
				if( result ) {
					System.out.println(" ** �Ա� ���� **");
				}else {
					System.out.println(" �˸�]] �Ա� ���� (������ ���°� �����ϴ�.)");
				}
				
			}else if( ���� == 3 ) {
				System.out.println("+++ ��� ������ +++");
				System.out.print(" ���¹�ȣ : "); String ���¹�ȣ = scanner.next();
				System.out.print(" ��й�ȣ : "); String ��й�ȣ = scanner.next();
				System.out.print(" ��ݾ� : "); int ��ݾ� = scanner.nextInt();
				
				int result = ��Ʈ��.���( ���¹�ȣ , ��й�ȣ , ��ݾ� ); // �޼ҵ�ȣ�� : ��ü��.�޼ҵ��(�μ�1,�μ�2,�μ�3)
				
				if( result == 1 ) {
					System.out.println(" ** �ܾ� ���� **");
				}else if( result == 2 ) {
					System.out.println(" ** ��� ���� **");
				}else if( result == 3) {
					System.out.println(" ** �ùٸ� ������ �ƴմϴ�. **");
				}
				
				
			}else if( ���� == 4 ) {
				System.out.println("+++ ��ü ������ +++");
				System.out.println(" ���¹�ȣ : "); String ���¹�ȣ = scanner.next();
				System.out.println(" ��й�ȣ : "); String ��й�ȣ = scanner.next();
				System.out.println(" ��ü�ݾ� : "); int ��ü�ݾ� = scanner.nextInt();
				System.out.println(" ��ü���� : "); String �޴°��� = scanner.next();
				
				int result =  ��Ʈ��.��ü( ���¹�ȣ , ��й�ȣ , ��ü�ݾ� , �޴°��� );
				if( result == 1 ) {
					System.out.println(" ** �ܾ� ���� **");
				}else if( result == 2 ) {
					System.out.println(" ** ��ü ���� **");
				}else if( result == 3 ) {
					System.out.println(" ** �޴� ���� ������ �����ϴ�. **");
				}else if( result == 4 ) {
					System.out.println(" ** ������ ���� ������ �����ϴ�. **");
				}
				
			}else if( ���� == 5 ) {
				System.out.println("+++ �� ���¸�� ������ +++");
				System.out.println(" ������ : "); String ������ = scanner.next();
				����[] �����¸�� = ��Ʈ��.���¸��( ������ );
				
				System.out.println(" *** �˻��� ������ ���� ���¸�� *** ");
				int i = 1;
				for( ���� temp : �����¸�� ) {
					if( temp !=null ) // �������� [ �����̸� ��¿��� �߻� ] 
						System.out.println( i+"�� ���¹�ȣ : "+temp.get���¹�ȣ() );
					i++;
				}
				
				
			}else if( ���� == 6 ) {
				System.out.println("+++ ���� ������ +++");
			}else {
				System.err.println(" �˸�]] �˼����� ��ȣ�Դϴ�. ");
			}
		} // while ���α׷� end
	} // main end 
} // class end 






