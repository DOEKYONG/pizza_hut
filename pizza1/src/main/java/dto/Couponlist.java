package dto;

public class Couponlist {
	
	int mnum;
	int eventnum  ;
	String couponactive ;
	
	public Couponlist() {
		// TODO Auto-generated constructor stub
	}

	public Couponlist(int mnum, int eventnum, String couponactive) {
		super();
		this.mnum = mnum;
		this.eventnum = eventnum;
		this.couponactive = couponactive;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public int getEventnum() {
		return eventnum;
	}

	public void setEventnum(int eventnum) {
		this.eventnum = eventnum;
	}

	public String getCouponactive() {
		return couponactive;
	}

	public void setCouponactive(String couponactive) {
		this.couponactive = couponactive;
	}
	
	
	
}
