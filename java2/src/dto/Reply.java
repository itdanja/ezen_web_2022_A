package dto;

public class Reply {

	private int rnum;
	private String rcontent;
	private String rwrite ;
	private String rdate ;
	private int bnum ;
	
	public Reply() {}
	public Reply(int rnum, String rcontent, String rwrite, String rdate, int bnum) {
		super();
		this.rnum = rnum;
		this.rcontent = rcontent;
		this.rwrite = rwrite;
		this.rdate = rdate;
		this.bnum = bnum;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRwrite() {
		return rwrite;
	}
	public void setRwrite(String rwrite) {
		this.rwrite = rwrite;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	
	
	
	
}
