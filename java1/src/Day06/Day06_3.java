package Day06;

import java.util.Scanner;

public class Day06_3 {
	
	// ȸ���� ���α׷� [ Ŭ���� ���� ] 
	
		// 0. ȸ�� ���� => ȸ�� Ŭ���� ����� 
			// 1. �ʵ� 
				// 1. ���̵� 2.��й�ȣ 3.�̸� 4.��ȭ��ȣ
		// 1. �ʱ�޴� [ 1. ȸ������ 2. �α��� 3.���̵�ã�� , 4.��й�ȣã�� ]
			// 1. ȸ�����Խ� �Է¹޾� ���� 
			// 2. �α��ν� ���̵�� ��й�ȣ�� �����ϸ� �α���ó�� 
			// 3. ���̵�ã��� �̸��� ��ȭ��ȣ�� �����ϸ� ���̵� ��� 
			// 4. ��й�ȣã��� ���̵�� ��ȭ��ȣ�� �����ϸ� ��й�ȣ ��� 
	
	public static void main(String[] args) { // main start 
		
		// ���� �����ϴ� ���� : main�޼ҵ� �������� ����ϱ� ���ؼ�
		Scanner scanner = new Scanner(System.in);
		Member[] memberlist = new Member[100];
		// Member Ŭ������ ������� ��ü(id,pw,name,phone) 100�� �����Ҽ� �ִ� �迭 ���� 
		
		while(true) { // ���α׷� ���� ���ѷ��� [ ��������:x ]
			
			System.out.println("---------- ȸ����[Ŭ��������]-------");
			System.out.println("1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã�� ");
			System.out.print(" ���� : "); int ch = scanner.nextInt();

			if( ch == 1 ) {  // ȸ������ 
				// 1. id, password , name , phone �Է¹ޱ� => ����4��
				System.out.println("------------ ȸ������ ������ -----------");
				System.out.println(" ���̵� : ");		String id = scanner.next();
				System.out.println(" ��й�ȣ : "); 	String password = scanner.next();
				System.out.println(" �̸� : ");  		String name = scanner.next();
				System.out.println(" ����ó : "); 	String phone = scanner.next();
				
				// 2. ��ü ���� 
				Member member = new Member();
				
				// 3. �Է¹��� ����4���� ��ü�� �ʵ忡 �����ϱ� 
				member.id = id;
				// ��ü�� �ʵ� = �Է¹����� 
				member.password = password;
				member.name = name;
				member.phone = phone;
				
				// 4. ������ ��ü�� �����ϴ� �迭�� ����
					// 1. ���� �ε��� ã�� [ ������ �ƴϸ� ����ȸ���� ���� ]
				int i = 0; // �ε��� ��ġ ����;
				for( Member temp  : memberlist ) { 
					// * memberlist �迭�� member ��ü �ϳ��� �����ͼ� temp ���� �ݺ� 
					// 2. ���鿡 �ε����� ��ü ���� 
					if( temp == null ) { // ���࿡ �ش� ��ü�� �����̸� 
						memberlist[i] = member;  // �ش� �ε����� ���� ������� ��ü ���� 
						System.err.println(" �˸�)) ȸ������ ���� ");
						break; // for ������ [ �ȳ����� ��� ���鿡 ������ ��ü ����Ǳ⶧���� ]
					}
					i++; // �ε��� ����
				} // for �� end 
				
			} // ȸ������ END 
			else if( ch==2 ) { // �α��� 
				
				// 1. �Է¹ޱ� 
				System.out.println("-------------- �α��� ������ ----------------");
				System.out.println(" ���̵� : ");	 	String loginid = scanner.next();
				System.out.println(" ��й�ȣ : "); 	String loginpassword = scanner.next();
				
				// 2. ���� �迭[ ȸ������Ʈ ] �� �Է¹��� ���� �� 
				boolean logincheck = false; // true : �α��μ���  false:�α��ν��� ���� ���� ���� 
				for( Member temp : memberlist ) {
					//* memberlist�� 0�� �ε������� �� �ε������� �ϳ��� temp�� ���� 
					if( temp !=null && temp.id.equals(loginid) && 
							temp.password.equals(loginpassword) ) {
						// * ��ü�� null �϶��� equals �Ұ� [ null �ƴ� ���¿����� equals ���� ]
						System.err.println(" �˸�)) �α��� ����");
						logincheck = true; // �α��� �����ߴٴ� ǥ�� ����� 
					}
				} // for end 
				// 3. �α��� ���� ���� 
				if( logincheck == false ) { // �α��μ����ÿ��� �Ʒ� �ڵ� ����Ұ� 
					System.err.println(" �˸�)) ������ ȸ�������� �����ϴ�.");
				}
				
			} // �α��� END 
			else if( ch==3 ) {}// ���̵�ã��
			else if( ch==4 ) {} // ��й�ȣã�� 
			else { System.err.println(" �˸�)) �˼����� ��ȣ�Դϴ�."); } // �׿�
			
		} // ���α׷� ���� while end 
	} // main end 
} //  class end 




