package Day14.������_����ڵ�;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Controller {
	
	Car car = new Car();
	Main main = new Main();
	
	public static ArrayList<Car> carlist = new ArrayList<>();
	public static ArrayList<DaySale> salelist = new ArrayList<>();
	
	Date carInTime  = new Date();
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat cardate = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
	String date = cardate.format(carInTime);
	
	
	
	public int CarIn(String CarNum,int parkNum) {

		//���� ����  
		Car saveCar = new Car(CarNum, date , parkNum);

		carlist.add(saveCar);
			
		inCarSave();
		
		String[] date_print = date.split("-");

		System.out.println("������¥ : " + date_print[1] + "��" + date_print[2] + "��");
		System.out.println("�����ð� : " + date_print[3] + "��" + date_print[4] + "��");
			
		return 20;

	}
	
	public static void inCarSave() {

		try {
		FileOutputStream outputStream = new FileOutputStream("D:/inCarSave.txt");
		// 2. ���Ͽ� �ۼ��� ���� [ ���پ� ]
		for(Car temp : carlist) {
			String contents = temp.getCarNum() +","+temp.getCardate()+","+temp.getParking()+"\n";
			outputStream.write(contents.getBytes());
			}
		}
		catch(Exception e) {
		}
	}
	
	// �Խù� �ҷ�����
	public static void inCarLoad() {
		
		try {
			FileInputStream inputStream = new FileInputStream("D:/inCarSave.txt");
			byte[] bytes = new byte[1024]; // 1 . ����Ʈ �迭 ����
			inputStream.read(bytes); // 2. ��� ����Ʈ�� �о�ͼ� ����Ʈ���� ���� 
			String file = new String(bytes); // 3. ����Ʈ�� ���ڿ��� ��ȯ
			String[]list = file.split("\n"); // 4. ���ڿ� �ڸ���
			int i = 0;
			for(String temp : list) {
				if( i+1 == list.length ) {
					break; 
				}
				String[] filed = temp.split(",");// 5. ���ڿ� �ڸ��� 
				Car temp2 = new Car(filed[0], filed[1],Integer.parseInt(filed[2]));
				carlist.add(temp2);
				i++;
			}
			
		}
		catch(Exception e) {
		}
		
	}
	
	public static void daysaleSave() {

		try {
		FileOutputStream outputStream = new FileOutputStream("D:/saleList.txt");
		// 2. ���Ͽ� �ۼ��� ���� [ ���پ� ]
		for(DaySale temp : salelist) {
			String contents = temp.getTodaymoney()+","+temp.getSavedate()+"\n";
			outputStream.write(contents.getBytes());
			}
		}
		catch(Exception e) {
		}
	}
	
	// �Խù� �ҷ�����
	public static void daysaleLode() {
		
		try {
			FileInputStream inputStream = new FileInputStream("D:/saleList.txt");
			byte[] bytes = new byte[1024]; // 1 . ����Ʈ �迭 ����
			inputStream.read(bytes); // 2. ��� ����Ʈ�� �о�ͼ� ����Ʈ���� ���� 
			String file = new String(bytes); // 3. ����Ʈ�� ���ڿ��� ��ȯ
			String[]list = file.split("\n"); // 4. ���ڿ� �ڸ���
			int i = 0;
			for(String temp : list) {
				if( i+1 == list.length ) {
					break; 
				}
				String[] filed = temp.split(",");// 5. ���ڿ� �ڸ��� 
				DaySale temp2 = new DaySale(Integer.parseInt(filed[0]),filed[1]);
				salelist.add(temp2);
				i++;
			}
			
		}
		catch(Exception e) {
		}
		
	}
	
	public void CarOut(String CarNum)  {

		for(int i = 0; i <carlist.size(); i++) {
			
			if(carlist.get(i).getCarNum().equals(CarNum)) {
				
				String[] now_date = date.split("-");
				
				String[] car_date = carlist.get(i).getCardate().split("-");
				
				System.out.println("������¥ : " + now_date[1] + "��" + now_date[2] + "��");
				System.out.println("�����ð� : " + now_date[3] + "��" + now_date[4] + "��");
				
				int now_day  = Integer.parseInt(now_date[2]);
				int now_hour = Integer.parseInt(now_date[3]);
				int now_min = Integer.parseInt(now_date[4]);
				
				int car_day  = Integer.parseInt(car_date[2]);
				int car_hour = Integer.parseInt(car_date[3]);
				int car_min = Integer.parseInt(car_date[4]);
				
				int now_all_min = ((now_hour*60)+now_min);
				int car_all_min = ((car_hour*60)+car_min);
				
				int total_time = now_all_min - car_all_min;
				
				int money = 0;
				
				if(now_day == car_day) {
					if(total_time < 30) {
						System.out.println("ȸ�� �����Դϴ�.");
					}
					else if(total_time >= 30 && total_time < 480) {
						int todaypay = ((((now_all_min - car_all_min)-30)/10)*1000);
						money = todaypay;
						DecimalFormat df = new DecimalFormat("#,##0��");
						System.out.print("�����Ͻ� �ݾ���  ");
						System.out.println( df.format( todaypay ) );
						
					}
					else if(total_time >=480) {
						int todaypay = 50000;;
						money = todaypay;
						System.out.println(total_time);
						DecimalFormat df = new DecimalFormat("#,##0��");
						System.out.print("�����Ͻ� �ݾ���  ");
						System.out.println( df.format( todaypay ) );
					
					}
				}
				else if(now_day > car_day){
					System.out.println(now_day);
					System.out.println(car_day);
					int todaypay = ((now_day - car_day)*50000);
					money = todaypay;
					DecimalFormat df = new DecimalFormat("#,##0��");
					System.out.println("�����Ͻ� �ݾ���");
					System.out.println( df.format( todaypay ) );

					
				}
				DaySale saveday = new DaySale(money, date);
				salelist.add(saveday);
				carlist.remove(i);
			}
		}
		Controller.daysaleSave();
		Controller.inCarSave();
		return ;
	}
	
	public int CarList(String CarNum) {
		
		for(Car temp : carlist) {
			if(temp != null) {
				
				if(temp.getCarNum().equals(CarNum)) {
					String[] car_date = temp.getCardate().split("-");
					if(temp.getParking() < 4) {
						System.out.println("������ "+CarNum+" ������ 1�� " + temp.getParking()+ "�� �ڸ��� ���� �Ǿ��ֽ��ϴ�.");
						System.out.println("������¥ : " + car_date[1] + "��" + car_date[2] + "��");
						System.out.println("�����ð� : " + car_date[3] + "��" + car_date[4] + "��");
						return 2;
					}
					else if(temp.getParking() > 3 && temp.getParking() < 8) {
						System.out.println("������ "+CarNum+" ������ 2�� " + temp.getParking()+ "�� �ڸ��� ���� �Ǿ��ֽ��ϴ�.");
						System.out.println("������¥ : " + car_date[1] + "��" + car_date[2] + "��");
						System.out.println("�����ð� : " + car_date[3] + "��" + car_date[4] + "��");
						return 2;
					}
					else {
						System.out.println("������ "+CarNum+" ������ 3�� " + temp.getParking()+ "�� �ڸ��� ���� �Ǿ��ֽ��ϴ�.");
						System.out.println("������¥ : " + car_date[1] + "��" + car_date[2] + "��");
						System.out.println("�����ð� : " + car_date[3] + "��" + car_date[4] + "��");
						return 2;
					}
				}
				else {
					return 1;
				}
				
			}
		}
		return 0;
	}
	
	
	
	public void sales(int year,int month) {
		
		DecimalFormat ny = new DecimalFormat("0000"); 
		String A = ny.format(year);
		DecimalFormat nm = new DecimalFormat("00"); 
		String B = nm.format(month);
		String no = "���� ����";
		calendar.set(year, month-1,1); 
		int start_week = calendar.get(Calendar.DAY_OF_WEEK) ;
		int end_day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int total_day_money = 0;
		boolean aaa = true;
		System.out.println("--------------------------------------------------------");
		System.out.println(year + "�� "+ month+"���� ������Ȳ");
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		for(int i =0; i < salelist.size(); i++) {
			String[] saved_date = salelist.get(i).getSavedate().split("-");
			if(saved_date[0].equals(A) && saved_date[1].equals(B)) {
				total_day_money += salelist.get(i).getTodaymoney();
			}
			
		}	
		for(int i =1; i < start_week; i++ ) {
				System.out.print("\t");
			}
		for(int j = 1; j <= end_day; j++) {
			DecimalFormat aa = new DecimalFormat("00��"); 
			String a = aa.format(j);
			System.out.print(a+"\t");
			if(start_week%7 == 0) {
				System.out.println();
			}
			start_week++;
		}
		System.out.println();
		System.out.println();
		System.out.println("���ͳ���))");
		for(DaySale temp : salelist) {
			String[] saved_date = temp.getSavedate().split("-");
			int save_day = Integer.parseInt(saved_date[2]);
			
			if(temp.getTodaymoney() > 0) {
				DecimalFormat df = new DecimalFormat("#,##0��");
				if(saved_date[0].equals(A) && saved_date[1].equals(B)) {
					System.out.println(save_day+"�� "+df.format(temp.getTodaymoney() ));
				}
				
			}
			else {
				aaa = false;
			}
		}


		System.out.println();
		
		System.out.println(month+"�� ���հ�: " +total_day_money + "��");
		total_day_money = 0;
		System.out.println();
		System.out.println("--------------------------------------------------------");
	}
}
