package dto;

public class Member {

	private int mnum; 
	private String mid;
	private String mpassword;
	private String mname;
	private String memail;
	private String mphone;
	private String mbirth;
	private String mdate;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int mnum, String mid, String mpassword, String mname, String memail, String mphone, String mbirth,
			String mdate) {
		super();
		this.mnum = mnum;
		this.mid = mid;
		this.mpassword = mpassword;
		this.mname = mname;
		this.memail = memail;
		this.mphone = mphone;
		this.mbirth = mbirth;
		this.mdate = mdate;
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

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMbirth() {
		return mbirth;
	}

	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	@Override
	public String toString() {
		return "Member [mnum=" + mnum + ", mid=" + mid + ", mpassword=" + mpassword + ", mname=" + mname + ", memail="
				+ memail + ", mphone=" + mphone + ", mbirth=" + mbirth + ", mdate=" + mdate + "]";
	}

	
	
	
}
