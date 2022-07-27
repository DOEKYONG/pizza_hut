package dto;

public class AlertDto {
	private int onum ;
	private String odate ;
	private String ophone ;
	private String oaddress ;
	private int ototalprice; 
	private String odelivery ;
	private int mnum ;
	private int fnum ;
	private String ostate;
	private String orequest;
	private int odetailnum; 
	private int omenunum ;
	private int oamount ; 
	private int osize ; 
	private int oedge; 
	private int otopping1 ;
	private int otopping2;
	public AlertDto() {
		// TODO Auto-generated constructor stub
	}
	public AlertDto(int onum, String odate, String ophone, String oaddress, int ototalprice, String odelivery, int mnum,
			int fnum, String ostate, String orequest, int odetailnum, int omenunum, int oamount, int osize, int oedge,
			int otopping1, int otopping2) {
		super();
		this.onum = onum;
		this.odate = odate;
		this.ophone = ophone;
		this.oaddress = oaddress;
		this.ototalprice = ototalprice;
		this.odelivery = odelivery;
		this.mnum = mnum;
		this.fnum = fnum;
		this.ostate = ostate;
		this.orequest = orequest;
		this.odetailnum = odetailnum;
		this.omenunum = omenunum;
		this.oamount = oamount;
		this.osize = osize;
		this.oedge = oedge;
		this.otopping1 = otopping1;
		this.otopping2 = otopping2;
	}
	
	public int getOnum() {
		return onum;
	}
	public void setOnum(int onum) {
		this.onum = onum;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public String getOphone() {
		return ophone;
	}
	public void setOphone(String ophone) {
		this.ophone = ophone;
	}
	public String getOaddress() {
		return oaddress;
	}
	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}
	public int getOtotalprice() {
		return ototalprice;
	}
	public void setOtotalprice(int ototalprice) {
		this.ototalprice = ototalprice;
	}
	public String getOdelivery() {
		return odelivery;
	}
	public void setOdelivery(String odelivery) {
		this.odelivery = odelivery;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public String getOstate() {
		return ostate;
	}
	public void setOstate(String ostate) {
		this.ostate = ostate;
	}
	public String getOrequest() {
		return orequest;
	}
	public void setOrequest(String orequest) {
		this.orequest = orequest;
	}
	public int getOdetailnum() {
		return odetailnum;
	}
	public void setOdetailnum(int odetailnum) {
		this.odetailnum = odetailnum;
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
		return "AlertDto [onum=" + onum + ", odate=" + odate + ", ophone=" + ophone + ", oaddress=" + oaddress
				+ ", ototalprice=" + ototalprice + ", odelivery=" + odelivery + ", mnum=" + mnum + ", fnum=" + fnum
				+ ", ostate=" + ostate + ", orequest=" + orequest + ", odetailnum=" + odetailnum + ", omenunum="
				+ omenunum + ", oamount=" + oamount + ", osize=" + osize + ", oedge=" + oedge + ", otopping1="
				+ otopping1 + ", otopping2=" + otopping2 + "]";
	}
	

}
