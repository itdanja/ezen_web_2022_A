package ������.���α׷��־������;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Controller {
	
	// 1. �迭 ��� 
	//public static Car[] carlist = new Car[100];
	// 2. ����Ʈ ���
	public static ArrayList<Car> carlist = new ArrayList<>(); 

	// ���� �޼ҵ� 
	public static boolean ����( String ������ȣ ) {
		// ���� �ڵ� �ۼ� 
			// 1. �Է¹��� ������ȣ(�μ�) �����´�.
			// * ������ȣ �ߺ�üũ
			for( Car temp : carlist ) {
				if( temp.get������ȣ().equals(������ȣ) ) {
					return false; // �� �޼ҵ� ��ȯ[����]
				}
			}
			// 2. ������¥(���糯¥) �� ���Ѵ�( ????? : )
			LocalDate ��¥ = LocalDate.now(); 
			// 3. �����ð�(����ð�) �� ���Ѵ�( ????? : )
			LocalTime �����ð� = LocalTime.now();
			// * �����ð� , �ݾ��� ������ x 
			
			// 4. ������ȣ,������¥,�����ð� => 3������ -> 1��üȭ
			Car car = new Car( ��¥, ������ȣ, �����ð�, null, 0);
			// 5. ������ü�� �迭�̳� ����Ʈ �� ���� 
			carlist.add(car);
			
		return false;
	}
	// ���� �޼ҵ� 
	public static boolean ����( String ������ȣ ) {
		// ���� �ڵ� �ۼ�
			// 1. �Է¹��� ������ȣ(�μ�) �����´�.
			// 2. �迭 or ����Ʈ�� ������ ������ȣ�� ã�Ƽ� 
			for( Car temp : carlist ) {
				
				if( temp.get������ȣ().equals(������ȣ) ) { // Ư�� ������ �Է¹��� ������ȣ�� ������
					
					// 3. �����ð�(����ð�) �� ���Ѵ� (????? : )
					LocalTime �����ð� = LocalTime.now();
					// 4. ��� [ �����ð� - �����ð� => (��-30)/10 *1000  ]
					int �̿�ð��� =  (int)( temp.get�����ð�().until(�����ð�, ChronoUnit.MINUTES )  )  ;
					�̿�ð��� -= 30; // 30���� ���� 
					// 5. (����)ã�� ��ü�� ��ð��� �ݾ��� �����Ѵ�.
					temp.set�����ð�(�����ð�);
					
						// *** �������� �������� ���������� üũ
						LocalDate ������ = LocalDate.now(); // �����ϸ� ���Ѵ� . 
						int �̿��� = (int)(temp.get��¥().until(������ , ChronoUnit.DAYS)); // �����ϰ� ������ ���̸� ���Ѵ�. 
						
						if( �̿��� == 0 ) { // ���� �̸�  
							if( �̿�ð��� < 0 ) { // 30���̳� �̿� ������
								temp.set�ݾ�(0);				
							}else { // 30���̻� �̿� ������ 
								�̿�ð��� = ( (�̿�ð���) / 10 ) *1000;
								temp.set�ݾ�( �̿�ð��� );
							}
							
						}else { // �Ϸ� �̻� ���̰� �������

							int �ϴ����� = �̿��� * 24 * 60; // �Ϸ� -> �� -> 1440��
							int �ϴ����ݾ� = (�ϴ�����/10)*1000; // �Ϸ� -> �Ϸ� �ִ� 144,000�� 
						
							if( �̿�ð��� < 0 ) { // �����̸�
								�̿�ð��� = ( (�̿�ð���) / 10 ) *1000; // �� -> �ݾ� ��ȯ 
								temp.set�ݾ�( �ϴ����ݾ� + �̿�ð��� - 1000  ); // �Ϸ�ݾ� + �ݾ�
							}else { // ����̸� 
								�̿�ð��� = ( (�̿�ð���) / 10 ) *1000; // �� -> �ݾ� ��ȯ 
								temp.set�ݾ�( �ϴ����ݾ� + �̿�ð��� + 1000 ); // �Ϸ�ݾ� + �ݾ�
							}
						}
					return true; // ���� ���� 
				}
			}
		return false;
	}
	
}





















