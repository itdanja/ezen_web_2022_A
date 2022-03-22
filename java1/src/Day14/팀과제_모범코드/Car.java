package Day14.팀과제_모범코드;


public class Car {
	
	private String carNum;
	private int parking;
	private String cardate;

	
	
	public Car() {
		
	}


	
	public Car(String carNum, String cardate, int parking) {
		super();
		this.carNum = carNum;
		this.parking = parking;
		this.cardate = cardate;

	}



	public String getCardate() {
		return cardate;
	}



	public void setCardate(String cardate) {
		this.cardate = cardate;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public int getParking() {
		return parking;
	}

	public void setParking(int parking) {
		this.parking = parking;
	}

	
	
}
