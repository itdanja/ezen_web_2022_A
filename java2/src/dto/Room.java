package dto;

public class Room {
	
	private int ronum; 
	private String roname; 
	private String roip; 
	private int mcount; // 현재 방 인원수 [ db에는 없는 필드 ]
	
	public Room() {}
	public Room(int ronum, String roname, String roip, int mcount) {
		this.ronum = ronum;
		this.roname = roname;
		this.roip = roip;
		this.mcount = mcount;
	}
	
	public int getRonum() {
		return ronum;
	}
	public void setRonum(int ronum) {
		this.ronum = ronum;
	}
	public String getRoname() {
		return roname;
	}
	public void setRoname(String roname) {
		this.roname = roname;
	}
	public String getRoip() {
		return roip;
	}
	public void setRoip(String roip) {
		this.roip = roip;
	}
	public int getMcount() {
		return mcount;
	}
	public void setMcount(int mcount) {
		this.mcount = mcount;
	}
	
	
	
	
	
}
