package test;

import java.time.LocalDate;
import java.time.LocalTime;

public class Car {
	//모델 : Car. 1.필드(기록할 내용-저장) 2.생성자(빈 생성자, 풀 생성자) 3.메소드(게터, 세터)
		//컨트롤러를 진행할 때 필요한 입력 내용을 생성
		//날짜 차량번호 입차시간 출차시간 금액
	
	private LocalDate 날짜;
	private String 차량번호;
	private LocalTime 입차시간;
	private LocalTime 출차시간;
	private int 금액; //요금
	
	
	//빈생성자
	public Car() {}

	
	
	//풀생성자
	public Car(LocalDate 날짜, String 차량번호, LocalTime 입차시간, LocalTime 출차시간, int 금액) {
		super();
		this.날짜 = 날짜;
		this.차량번호 = 차량번호;
		this.입차시간 = 입차시간;
		this.출차시간 = 출차시간;
		this.금액 = 금액;
	}

	
	
	
	//메소드



	public LocalDate get날짜() {
		return 날짜;
	}



	public void set날짜(LocalDate 날짜) {
		this.날짜 = 날짜;
	}



	public String get차량번호() {
		return 차량번호;
	}



	public void set차량번호(String 차량번호) {
		this.차량번호 = 차량번호;
	}



	public LocalTime get입차시간() {
		return 입차시간;
	}



	public void set입차시간(LocalTime 입차시간) {
		this.입차시간 = 입차시간;
	}



	public LocalTime get출차시간() {
		return 출차시간;
	}



	public void set출차시간(LocalTime 출차시간) {
		this.출차시간 = 출차시간;
	}



	public int get금액() {
		return 금액;
	}



	public void set금액(int 금액) {
		this.금액 = 금액;
	}
	
	
	
}
