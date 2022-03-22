package Day14.팀과제_모범코드;

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
				System.out.println("메인 메뉴))");
				 //주차공간이 보임
				for(Car temp : Controller.carlist){
					if(temp != null) {						
						tower[temp.getParking()] = "["+temp.getCarNum()+"]";
					}
				}
				for(int i = 0; i < tower.length; i++) {
					 System.out.print(tower[i]);
					 if(i%4==3) {
						 if(i==3) {
							 System.out.println("1층");
						 }
						 if(i==7) {
							 System.out.println("2층");
						 }
						 if(i==11) {
							 System.out.println("3층");
						 }
					 }
				 }
				
				//메뉴
				System.out.println();
				System.out.println("1)입차 2)출차 3)매출확인 4)차량확인 5)종료");
				String ch = scanner.next();
				//차량입고 메뉴
				if(ch.equals("1") || ch.equals("입차")) {
					System.out.println("입차된 차량 번호를 입력하세요. (뒷 4자리만 입력)");
					int carNum = scanner.nextInt();
					System.out.println("차량이 주차될 위치를 입력하세요. (0 ~ 11)");
					int parkNum = scanner.nextInt();
					
					if(!tower[parkNum].equals("[    ]")) {
						System.out.println("이미 사용중인 주차공간입니다.");
					}
					else {
						DecimalFormat df = new DecimalFormat("0000"); 
						String setcarnum = df.format(carNum);
						tower[parkNum] = "["+setcarnum+"]";
						int num = con.CarIn(setcarnum,parkNum);
						
						if(num == 20) {
							System.out.println(setcarnum+" 차량이 정상 입고 되었습니다.");
						}
						else {
							System.out.println("차량이 정상입고 되지 않았습니다.");
						}
					}
				}
				//차량 출고 메뉴
				else if(ch.equals("2") || ch.equals("출차")) {

					System.out.println("출차할 차량 번호를 입력하세요. (뒷 4자리만 입력)");
					int carNum = scanner.nextInt();
					System.out.println("차량이 출차될 위치를 입력하세요. (0 ~ 11)");
					int parkNum = scanner.nextInt();
					DecimalFormat df = new DecimalFormat("0000"); 
					String setcarnum = df.format(carNum);
					boolean pass = true;
					for(Car temp : Controller.carlist) {
						if(temp != null && temp.getCarNum().equals(setcarnum)) {
							int aa = Integer.parseInt(temp.getCarNum());
							if(carNum != aa) {
								System.out.println("존재하지 않는 차량입니다.");
								pass = false;
								break;
							}
						}
						
					}
					if(tower[parkNum].equals("[    ]")) {
						System.out.println("현재 비어있는 주차공간 입니다.");
						pass = false;
					}
					if(pass) {
						con.CarOut(setcarnum);
						tower[parkNum] = "[    ]";
						
					}
					else {
						System.out.println("출차하지 못했습니다.");
					}
				
				}
				//메출확인 메뉴
				else if(ch.equals("3") || ch.equals("매출확인")) {
					
					System.out.println("날짜 검색");
					System.out.println("연도 : "); int year = scanner.nextInt();
					System.out.println("월  : "); int month = scanner.nextInt();	
					
					if(year > 2100 || month > 13 ) {
						System.out.println("연도 혹은 월입력이 잘못되었습니다.");
					}
					else {
						con.sales(year,month);
					}
					
					
				}
				//차량 확인 메뉴
				else if(ch.equals("4") || ch.equals("차량 확인")) {
					System.out.println("확인할 차량 번호를 입력하세요. (뒷 4자리만 입력)");
					String carNum = scanner.next();
					System.out.println("주자된 차량)) " + carNum);
					int result = con.CarList(carNum);
					
					if(result == 0) {
						System.out.println("요류");
					}
					else if(result == 1) {
						System.out.println("존재하지 않는 차량입니다.");
					}
				}
				else if(ch.equals("5") || ch.equals("종료")) {
					System.out.println("프로그램을 종료 합니다.");
					scanner.close();
					break;
				}
				else {
					 System.out.println("메세지)) 존재하지 않는 메뉴 입니다.");
					 
				}
				
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}

		
		
	}// m e
} // c e
