package Day19;

import java.util.HashSet;
import java.util.Scanner;

public class Day19_2 {

	public static void main(String[] args) {
		
		// �ζ� ���α׷� // set �÷��� 
		Scanner scanner = new Scanner(System.in);	// 1. �Է°�ü 
		HashSet<Integer> set = new HashSet<>();		// 2. set �÷��� HashSet Ŭ���� ��ü ���� 
		
		while( true ) {	// ���ѷ��� [ �������� : set��ü�� ��ü���� 6�̸� break ] 
			System.out.print(" 1~45 ���� ����(�ߺ��Ұ�) : ");
			int num = scanner.nextInt(); // 3. �Է¹ޱ� 
			
			if( num < 1 || num > 45 ) { // 4. 1~45 ���̰� �ƴϸ� �ٽ� �Է¹ޱ�  
				System.out.println(" �����Ҽ� ���� ��ȣ !! "); 
			}else {
				set.add(num); // 5. 1~45 ���� �̸� set��ü�� ���� 
				System.out.println(" Ȯ�� : " + set );
			}
			if( set.size() == 6 ) break; // ���࿡ set��ü�� ��ü���� 6�̸� ���� 
		}
	}
}





