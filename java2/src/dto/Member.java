package dto;

public class Member { // ������ ��
	
	private int mnum; //ȸ����ȣ
	private String mid; // ���̵�
	private String mpassword; //ȸ����й�ȣ
	private String memail; // �̸���
	private String maddress; // �ּ� 
	private int mpoint;	// ����Ʈ
	private String mcince; // ������
	
	public Member() {}

	public Member(int mnum, String mid, String mpassword, String memail, String maddress, int mpoint, String mcince) {
		super();
		this.mnum = mnum;
		this.mid = mid;
		this.mpassword = mpassword;
		this.memail = memail;
		this.maddress = maddress;
		this.mpoint = mpoint;
		this.mcince = mcince;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}

	public String getMcince() {
		return mcince;
	}

	public void setMcince(String mcince) {
		this.mcince = mcince;
	}
	
}
