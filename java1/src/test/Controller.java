package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Controller {  //��Ʈ�ѷ� : ���� �޼ҵ带 ���� �����ϴ� �κ��� �����
	
	
	//����
	public static ArrayList<Car> ������ = new ArrayList<Car>();
	
	
	//����
		//������ȣ�� �ް� �����ð��� ����ð��� ����
		//�����ð��� ������ ���� �������� �ϰ� �� �������� ���� ��
		//�ݾ׵� ������ �����ϰ� �� ������ ���� ������ ǥ��
	//view���� �Է� ���� ���� ��ȣ�� �����´�..
	
	public static boolean ���� (String ������ȣ) {
		//�μ�. ������ȣ�� �Է� �޴´�
		
		//�ߺ�üũ�ؼ� ������ ������ȣ�� �ִ� �� Ȯ��
		for(Car temp : ������) { //�Է� ���� ������ȣ�� ������ ����.
			if(temp.get������ȣ().equals(������ȣ)) {
				return false;	// ���� �����ϸ� ���� ��ȯ ����
			} }
		
		//���� �ð� ��������( now )
		LocalDate ��¥ = LocalDate.now();
		LocalTime �����ð� = LocalTime.now();
		//������ ���� ���� �ʰ� �Ѿ��
		
		//����ȣ, ��¥, �ð��� �ϳ��� ��� �ڵ����� �����.
		
		Car car = new Car(��¥, ������ȣ, �����ð�, null, 0);
		//���� �����ð� ���� �ʾ����Ƿ� null ����
		������.add(car);
		//�Ʊ� ���� ����Ʈ�� �ڵ��� ��ü ����
		
		return false; //boolean�� ����
	}
	
	
	//���� ����
	///////////////////////////////////////////////
	
	

	public static boolean ���� (String ������ȣ) {
		//�ٽ� �Է� ���� ���� ��ȣ�� ������ ���� �Ѵ�.
		//������ ���
		System.out.println("������������1"  );
		for(Car temp : ������ ) {
			System.out.println("������������2"+ temp.get������ȣ() + ������ȣ );
			if(temp.get������ȣ().equals(������ȣ) ) {
				//�Է� ���� ���� �Է� �Ǿ��ִ� ���� ���Ѵ�.
				System.out.println("������������3");
				//�����Ҷ����� ������Ȳǥ�� �����ð��� �����ϰ� �ݾ��� ����Ѵ�.
				
				//������ ���� �ð��� �޴´�.
				LocalTime ���� = LocalTime.now();
				
				//�ð��� ������ ����Ѵ�.
				
				int �̿�ð� =  (int) temp.get�����ð�().until(����, ChronoUnit.MINUTES);
							//add cast int
				�̿�ð� -= 30; //30�� �����̴ϱ� 30�� ������ ���� ���
				temp.set�����ð�(����); //�� �ð��� �����Ѵ�.
			//set ���� get ��������
			
			
			//�̿��� ���
				
			if(�̿�ð� < 0) {
				//�̿�ð��� 30�� �̳�(���� ����� 0�̸�)
				
				temp.set�ݾ�(0); //0���� �����ְ�
				
				} else { //0���� ũ��, 30�� �̻��̸�
					�̿�ð� = ((�̿�ð�)/10) *1000;
					temp.set�ݾ�(�̿�ð�);
				} //���� �ڸ��� �д����� ������ �����ڸ����� ���� ����� ����Ѵ�.
				

				return true; //���������� ��ȯ
				
			} // if end
			

			
		} //for end
			
		return false;
	} //��������
	
	//��������

}
