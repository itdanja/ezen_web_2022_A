package Day01;

import java.util.Scanner;

public class Day01_5_����1 { // c s 
	
	public static void main(String[] args) { // m s 
		
		// �Է� -> ���� -> ��� 
		// 1. �Է°�ü ����
		Scanner scanner = new Scanner(System.in);
		// 2. �Է��� ��� �ȳ� // 3. �Է¹��� ������ �ٸ����� ���� [ ��??? ����� ] 
		System.out.print(" ���̵� : ");	String id = scanner.next();
		System.out.print(" ��й�ȣ : ");	String pw = scanner.next();
		System.out.print(" ���� : ");	String name = scanner.next();
		System.out.print(" �̸��� : ");	String email = scanner.next();
		// 3. ���
		System.out.println(">>>>>>>>>> ȸ������ �Ϸ� �Ʒ� ������ Ȯ�����ּ��� >>>>>>>");
		System.out.println("���̵�\t��й�ȣ\t����\t�̸���");
		System.out.println( id +"\t"+ pw +"\t"+ name +"\t"+ email );
		
	} // m e 
} // c e 

	/*
	����1 : ȸ������ ǥ �ۼ�
	[�Է� ��]
		1. ���̵�, ��й�ȣ , ����, �̸���  �Է¹޾� ���� 
	[��� ��]
		>>>>>>>>>> ȸ������ �Ϸ� �Ʒ� ������ Ȯ�����ּ��� >>>>>>>>>
		 ���̵�		��й�ȣ		����		�̸���		
		 qwe		1234		���缮		itdanja@kakao.com
	*/
