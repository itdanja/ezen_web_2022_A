package dto;

public class Category {
	
	private int cno ; 
	private String cname ; 
	
	public Category() {}
	
	public Category(int cno, String cname) {
		super();
		this.cno = cno;
		this.cname = cname;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Category [cno=" + cno + ", cname=" + cname + "]";
	}
	
	
}
