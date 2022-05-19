package dto;

public class Cart {
	
	private int cartno;
	private int samount ;
	private int totalprice ;
	private int sno ;
	private int mno ;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartno, int samount, int totalprice, int sno, int mno) {
		super();
		this.cartno = cartno;
		this.samount = samount;
		this.totalprice = totalprice;
		this.sno = sno;
		this.mno = mno;
	}

	public int getCartno() {
		return cartno;
	}

	public void setCartno(int cartno) {
		this.cartno = cartno;
	}

	public int getSamount() {
		return samount;
	}

	public void setSamount(int samount) {
		this.samount = samount;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "Cart [cartno=" + cartno + ", samount=" + samount + ", totalprice=" + totalprice + ", sno=" + sno
				+ ", mno=" + mno + "]";
	}
	

}
