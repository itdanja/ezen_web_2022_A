package Day14.팀과제_모범코드;

public class DaySale {

	
	private int todaymoney;
	private String savedate;
	
	public DaySale() {
		
	}

	public DaySale(int todaymoney, String savedate) {
		
		this.todaymoney = todaymoney;
		this.savedate = savedate;
	}

	public int getTodaymoney() {
		return todaymoney;
	}

	public void setTodaymoney(int todaymoney) {
		this.todaymoney = todaymoney;
	}

	public String getSavedate() {
		return savedate;
	}

	public void setSavedate(String savedate) {
		this.savedate = savedate;
	}
	
	
	
}
