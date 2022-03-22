package Day14.������_����ڵ�;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String[] tower = { "[    ]","[    ]","[    ]","[    ]",
	 			"[    ]","[    ]","[    ]","[    ]",
	 			"[    ]","[    ]","[    ]","[    ]",};
		Scanner scanner = new Scanner(System.in);
		Controller con = new Controller();
		Controller.inCarLoad();
		Controller.daysaleLode();
		while(true) {
			try {
				System.out.println("���� �޴�))");
				 //���������� ����
				for(Car temp : Controller.carlist){
					if(temp != null) {						
						tower[temp.getParking()] = "["+temp.getCarNum()+"]";
					}
				}
				for(int i = 0; i < tower.length; i++) {
					 System.out.print(tower[i]);
					 if(i%4==3) {
						 if(i==3) {
							 System.out.println("1��");
						 }
						 if(i==7) {
							 System.out.println("2��");
						 }
						 if(i==11) {
							 System.out.println("3��");
						 }
					 }
				 }
				
				//�޴�
				System.out.println();
				System.out.println("1)���� 2)���� 3)����Ȯ�� 4)����Ȯ�� 5)����");
				String ch = scanner.next();
				//�����԰� �޴�
				if(ch.equals("1") || ch.equals("����")) {
					System.out.println("������ ���� ��ȣ�� �Է��ϼ���. (�� 4�ڸ��� �Է�)");
					int carNum = scanner.nextInt();
					System.out.println("������ ������ ��ġ�� �Է��ϼ���. (0 ~ 11)");
					int parkNum = scanner.nextInt();
					
					if(!tower[parkNum].equals("[    ]")) {
						System.out.println("�̹� ������� ���������Դϴ�.");
					}
					else {
						DecimalFormat df = new DecimalFormat("0000"); 
						String setcarnum = df.format(carNum);
						tower[parkNum] = "["+setcarnum+"]";
						int num = con.CarIn(setcarnum,parkNum);
						
						if(num == 20) {
							System.out.println(setcarnum+" ������ ���� �԰� �Ǿ����ϴ�.");
						}
						else {
							System.out.println("������ �����԰� ���� �ʾҽ��ϴ�.");
						}
					}
				}
				//���� ��� �޴�
				else if(ch.equals("2") || ch.equals("����")) {

					System.out.println("������ ���� ��ȣ�� �Է��ϼ���. (�� 4�ڸ��� �Է�)");
					int carNum = scanner.nextInt();
					System.out.println("������ ������ ��ġ�� �Է��ϼ���. (0 ~ 11)");
					int parkNum = scanner.nextInt();
					DecimalFormat df = new DecimalFormat("0000"); 
					String setcarnum = df.format(carNum);
					boolean pass = true;
					for(Car temp : Controller.carlist) {
						if(temp != null && temp.getCarNum().equals(setcarnum)) {
							int aa = Integer.parseInt(temp.getCarNum());
							if(carNum != aa) {
								System.out.println("�������� �ʴ� �����Դϴ�.");
								pass = false;
								break;
							}
						}
						
					}
					if(tower[parkNum].equals("[    ]")) {
						System.out.println("���� ����ִ� �������� �Դϴ�.");
						pass = false;
					}
					if(pass) {
						con.CarOut(setcarnum);
						tower[parkNum] = "[    ]";
						
					}
					else {
						System.out.println("�������� ���߽��ϴ�.");
					}
				
				}
				//����Ȯ�� �޴�
				else if(ch.equals("3") || ch.equals("����Ȯ��")) {
					
					System.out.println("��¥ �˻�");
					System.out.println("���� : "); int year = scanner.nextInt();
					System.out.println("��  : "); int month = scanner.nextInt();	
					
					if(year > 2100 || month > 13 ) {
						System.out.println("���� Ȥ�� ���Է��� �߸��Ǿ����ϴ�.");
					}
					else {
						con.sales(year,month);
					}
					
					
				}
				//���� Ȯ�� �޴�
				else if(ch.equals("4") || ch.equals("���� Ȯ��")) {
					System.out.println("Ȯ���� ���� ��ȣ�� �Է��ϼ���. (�� 4�ڸ��� �Է�)");
					String carNum = scanner.next();
					System.out.println("���ڵ� ����)) " + carNum);
					int result = con.CarList(carNum);
					
					if(result == 0) {
						System.out.println("���");
					}
					else if(result == 1) {
						System.out.println("�������� �ʴ� �����Դϴ�.");
					}
				}
				else if(ch.equals("5") || ch.equals("����")) {
					System.out.println("���α׷��� ���� �մϴ�.");
					scanner.close();
					break;
				}
				else {
					 System.out.println("�޼���)) �������� �ʴ� �޴� �Դϴ�.");
					 
				}
				
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}

		
		
	}// m e
} // c e
