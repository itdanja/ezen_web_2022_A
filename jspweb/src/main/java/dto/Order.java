package dto;

public class Order {
	
	private int  orderno;
	private String orderdate;
	private String ordername;
	private String orderphone ;
	private String orderaddress; 
	private int ordertotalpay;
	private int orderactive;
	private String orderrequest ;
	private int orderdeliverno ;
	private int mno;
	
	public Order() {}
	
	

	public Order(int orderno, String orderdate, String ordername, String orderphone, String orderaddress,
			int ordertotalpay, int orderactive, String orderrequest, int orderdeliverno, int mno) {
		super();
		this.orderno = orderno;
		this.orderdate = orderdate;
		this.ordername = ordername;
		this.orderphone = orderphone;
		this.orderaddress = orderaddress;
		this.ordertotalpay = ordertotalpay;
		this.orderactive = orderactive;
		this.orderrequest = orderrequest;
		this.orderdeliverno = orderdeliverno;
		this.mno = mno;
	}



	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getOrderphone() {
		return orderphone;
	}

	public void setOrderphone(String orderphone) {
		this.orderphone = orderphone;
	}

	public String getOrderaddress() {
		return orderaddress;
	}

	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}

	public int getOrdertotalpay() {
		return ordertotalpay;
	}

	public void setOrdertotalpay(int ordertotalpay) {
		this.ordertotalpay = ordertotalpay;
	}

	public int getOrderactive() {
		return orderactive;
	}

	public void setOrderactive(int orderactive) {
		this.orderactive = orderactive;
	}

	public String getOrderrequest() {
		return orderrequest;
	}

	public void setOrderrequest(String orderrequest) {
		this.orderrequest = orderrequest;
	}

	public int getOrderdeliverno() {
		return orderdeliverno;
	}

	public void setOrderdeliverno(int orderdeliverno) {
		this.orderdeliverno = orderdeliverno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "Order [orderno=" + orderno + ", orderdate=" + orderdate + ", ordername=" + ordername + ", orderphone="
				+ orderphone + ", orderaddress=" + orderaddress + ", ordertotalpay=" + ordertotalpay + ", orderactive="
				+ orderactive + ", orderrequest=" + orderrequest + ", orderdeliverno=" + orderdeliverno + ", mno=" + mno
				+ "]";
	}
	
}
