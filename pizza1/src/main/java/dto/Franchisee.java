package dto;

public class Franchisee {

	private int fnum;
	private int ordernum;
	private String faddress;
	private String fname;
	private String ordername;
	
	public Franchisee() {
		// TODO Auto-generated constructor stub
	}

	public Franchisee(int fnum, int ordernum, String faddress, String fname, String ordername) {
		super();
		this.fnum = fnum;
		this.ordernum = ordernum;
		this.faddress = faddress;
		this.fname = fname;
		this.ordername = ordername;
	}

	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	public String getFaddress() {
		return faddress;
	}

	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	@Override
	public String toString() {
		return "Franchisee [fnum=" + fnum + ", ordernum=" + ordernum + ", faddress=" + faddress + ", fname=" + fname
				+ ", ordername=" + ordername + "]";
	}

	
	
	
	
}
