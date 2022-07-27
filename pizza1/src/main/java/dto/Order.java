package dto;

public class Order {

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
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(int onum, String odate, String ophone, String oaddress, int ototalprice, String odelivery, int mnum,
			int fnum, String ostate, String orequest) {
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
	@Override
	public String toString() {
		return "Order [onum=" + onum + ", odate=" + odate + ", ophone=" + ophone + ", oaddress=" + oaddress
				+ ", ototalprice=" + ototalprice + ", odelivery=" + odelivery + ", mnum=" + mnum + ", fnum=" + fnum
				+ ", ostate=" + ostate + ", orequest=" + orequest + "]";
	}
	
	
	
	
	
}
