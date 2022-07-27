package dto;

public class Cart {
	private int cartno ; 
	private int samount; 
	private int totalprice ; 
	private int menunum ; 
	private int sizenum ; 
	private int edgenum ; 
	private int topping1 ; 
	private int topping2; 
	private int mnum;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartno, int samount, int totalprice, int menunum, int sizenum, int edgenum, int topping1,
			int topping2, int mnum) {
		super();
		this.cartno = cartno;
		this.samount = samount;
		this.totalprice = totalprice;
		this.menunum = menunum;
		this.sizenum = sizenum;
		this.edgenum = edgenum;
		this.topping1 = topping1;
		this.topping2 = topping2;
		this.mnum = mnum;
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

	public int getMenunum() {
		return menunum;
	}

	public void setMenunum(int menunum) {
		this.menunum = menunum;
	}

	public int getSizenum() {
		return sizenum;
	}

	public void setSizenum(int sizenum) {
		this.sizenum = sizenum;
	}

	public int getEdgenum() {
		return edgenum;
	}

	public void setEdgenum(int edgenum) {
		this.edgenum = edgenum;
	}

	public int getTopping1() {
		return topping1;
	}

	public void setTopping1(int topping1) {
		this.topping1 = topping1;
	}

	public int getTopping2() {
		return topping2;
	}

	public void setTopping2(int topping2) {
		this.topping2 = topping2;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	@Override
	public String toString() {
		return "Cart [cartno=" + cartno + ", samount=" + samount + ", totalprice=" + totalprice + ", menunum=" + menunum
				+ ", sizenum=" + sizenum + ", edgenum=" + edgenum + ", topping1=" + topping1 + ", topping2=" + topping2
				+ ", mnum=" + mnum + "]";
	}

	
	
}
