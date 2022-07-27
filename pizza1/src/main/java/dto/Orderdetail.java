package dto;

public class Orderdetail {
	
	private int odetailnum; 
	private int onum ; 
	private int omenunum ;
	private int oamount ; 
	private int osize ; 
	private int oedge; 
	private int otopping1 ;
	private int otopping2;
	
	public Orderdetail() {
		// TODO Auto-generated constructor stub
	}
	
	public Orderdetail(int odetailnum, int onum, int omenunum, int oamount, int osize, int oedge, int otopping1,
			int otopping2) {
		super();
		this.odetailnum = odetailnum;
		this.onum = onum;
		this.omenunum = omenunum;
		this.oamount = oamount;
		this.osize = osize;
		this.oedge = oedge;
		this.otopping1 = otopping1;
		this.otopping2 = otopping2;
	}

	public int getOdetailnum() {
		return odetailnum;
	}

	public void setOdetailnum(int odetailnum) {
		this.odetailnum = odetailnum;
	}

	public int getOnum() {
		return onum;
	}

	public void setOnum(int onum) {
		this.onum = onum;
	}

	public int getOmenunum() {
		return omenunum;
	}

	public void setOmenunum(int omenunum) {
		this.omenunum = omenunum;
	}

	public int getOamount() {
		return oamount;
	}

	public void setOamount(int oamount) {
		this.oamount = oamount;
	}

	public int getOsize() {
		return osize;
	}

	public void setOsize(int osize) {
		this.osize = osize;
	}

	public int getOedge() {
		return oedge;
	}

	public void setOedge(int oedge) {
		this.oedge = oedge;
	}

	public int getOtopping1() {
		return otopping1;
	}

	public void setOtopping1(int otopping1) {
		this.otopping1 = otopping1;
	}

	public int getOtopping2() {
		return otopping2;
	}

	public void setOtopping2(int otopping2) {
		this.otopping2 = otopping2;
	}

	@Override
	public String toString() {
		return "Orderdetail [odetailnum=" + odetailnum + ", onum=" + onum + ", omenunum=" + omenunum + ", oamount="
				+ oamount + ", osize=" + osize + ", oedge=" + oedge + ", otopping1=" + otopping1 + ", otopping2="
				+ otopping2 + "]";
	}
	
	

}
