package dto;

public class Subpizza {

	private int subnum;
	private String subsize ;
	private String subedge ;
	private String subedgeimg ;
	private int subprice ;
	private int menunum ;
	
	
	public Subpizza() {
		// TODO Auto-generated constructor stub
	}


	public Subpizza(int subnum, String subsize, String subedge, String subedgeimg, int subprice, int menunum) {
		super();
		this.subnum = subnum;
		this.subsize = subsize;
		this.subedge = subedge;
		this.subedgeimg = subedgeimg;
		this.subprice = subprice;
		this.menunum = menunum;
	}


	public int getSubnum() {
		return subnum;
	}


	public void setSubnum(int subnum) {
		this.subnum = subnum;
	}


	public String getSubsize() {
		return subsize;
	}


	public void setSubsize(String subsize) {
		this.subsize = subsize;
	}


	public String getSubedge() {
		return subedge;
	}


	public void setSubedge(String subedge) {
		this.subedge = subedge;
	}


	public String getSubedgeimg() {
		return subedgeimg;
	}


	public void setSubedgeimg(String subedgeimg) {
		this.subedgeimg = subedgeimg;
	}


	public int getSubprice() {
		return subprice;
	}


	public void setSubprice(int subprice) {
		this.subprice = subprice;
	}


	public int getMenunum() {
		return menunum;
	}


	public void setMenunum(int menunum) {
		this.menunum = menunum;
	}


	@Override
	public String toString() {
		return "Subpizza [subnum=" + subnum + ", subsize=" + subsize + ", subedge=" + subedge + ", subedgeimg="
				+ subedgeimg + ", subprice=" + subprice + ", menunum=" + menunum + "]";
	}
	
	
	
	
	
	
}
