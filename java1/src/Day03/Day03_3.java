package Day03;

import java.util.Scanner;

public class Day03_3 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//����6
		// ������ �Է¹޾� ������ 90�� �̻��̸� �հ� �ƴϸ� ���հ� ��� 
		System.out.print(" ���� : "); int ���� = scanner.nextInt();
		if( ���� >= 90 ) System.out.println(" �հ�. ");
		else System.out.println(" ���հ�. ");
		
		//����7
		// ������ �Է¹޾� ������ 90�� �̻��̸� A���
		//				������ 80�� �̻��̸� B���
		//				������ 70�� �̻��̸� C���
		//				�׿� �����
		System.out.print(" ���� : "); int ����2 = scanner.nextInt();
		if( ����2 >= 90 )System.out.println("A���");
		else if( ����2 >=80 )System.out.println("B���");
		else if( ����2 >=70 )System.out.println("C���");
		else System.out.println("�����");
		
		//����8 �α���������
		// [ �Է� ] : ���̵�� ��й�ȣ�� �Է¹ޱ�
		// [ ���� ] : ȸ�����̵� admin �̰� 
		//           ��й�ȣ�� 1234 �� ��쿡�� 
		//          �α��� ���� �ƴϸ� �α��� ���� ���
		
		/* ����9
			[ �Է� ] : ����,����,���� �Է¹ޱ�
			[ ���� ]
				����� 90�� �̻��̸鼭 
					�������� 100�� �̸� '������' ���
					�������� 100�� �̸� '������' ���
					�������� 100�� �̸� '���п��' ���
				����� 80�� �̻��̸鼭 
					�������� 90�� �̸� '�������' ���
					�������� 90�� �̸� '��������' ���
					�������� 90�� �̸� '�������' ���
				�׿� ����� 
		 */
		
	}
}

