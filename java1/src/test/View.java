package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class View { //����ڰ� ���� ȭ��. ������ ��Ȳ ǥ�� ���� ���� ��ư�� ������
	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
		

	//������Ȳǥ
	//����ð�
	//��¥, ������ȣ, �����ð�, �����ð�, �ݾ�
		
	
	
	//�ݺ���
	while(true) {
		
		System.out.println("==========������Ȳǥ==========");
		
		Date date = new Date(); //��¥ ��ü
		SimpleDateFormat dateFormat =
				new SimpleDateFormat("���� �ð� : yyyy-MM-dd \t hh:mm");
		//�ð� ���� M month m minuts
		
		System.out.println(dateFormat.format(date));
		System.out.println(); //�ٹٲ�
		
		System.out.println("\t��¥\t������ȣ\t�����ð�\t�����ð�\t�ݾ�\n");
		
		//ȣ��

		for(Car temp : Controller.������) {
			//�������� ȣ���Ѵ�.
			System.out.print(temp.get��¥()+"\t");
			System.out.print(temp.get������ȣ()+"\t");
			
			//�ʴ��� ����
			System.out.print(temp.get�����ð�().getHour()+":"); //�����ð�
			System.out.print(temp.get�����ð�().getMinute()+"\t"); //�����ð�

//			
//			System.out.print(temp.get�����ð�().getHour()+":"); //�����ð�
//			System.out.print(temp.get�����ð�().getMinute()+"\t"); //�����ð�
//			System.out.print(temp.get�ݾ�()+"\n");// ���
			
			
				if(temp.get�����ð�() == null) { //�����ð��� null�� �������� ����
					System.out.print("������"+"\t");
				} else { //null�� �ƴϰ� ���� ����
					System.out.print(temp.get�����ð�().getHour()+":"+temp.get�����ð�().getMinute()+"\t");
				} //�ð� ��Ÿ����
			
			//�׸��� null = ������ �� ���� ���� ���̶�� ��
				if(temp.get�����ð�() == null) { System.out.println("���� ��");
				} else { //������ ������ ���
					//õ����???
					System.out.print(temp.get�ݾ�()+"\n"); } //�ٹٲ�
				
		} //for end 
	
		System.out.println("==========================");
		
		System.out.println("\t 1.���� \t 2. ����");
		//���� �Է� �޾Ƽ� ����
		int ch = scanner.nextInt();
		
	
		if( ch == 1 ) {
			//����
			//��Ʈ�ѷ��� �Է��� ���� �̺�Ʈ�� �����´�.
			System.out.println("���� ��ȣ�� �Է��ϼ��� : ");
			String ������ȣ = scanner.next();
			
			boolean ���� = Controller.����(������ȣ);
			//�Է��� ���� ��ȣ ����

		} else if (ch == 2) {
			//����
			//������ ����(��Ʈ�ѷ��� �� �̺�Ʈ ����)
			System.out.println("���� ��ȣ�� �Է��ϼ��� : ");
			String ������ȣ = scanner.next();
			
			boolean ���� = Controller.����(������ȣ);
			
		} else { System.out.println("�ٽ� �������ּ���."); }
		
		
		//������� ���ÿ� ������
		
		
	} //while end
		
		
		
		
/////////////////////////////////////////////		
	}
}
