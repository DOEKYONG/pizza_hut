package dto;

public class Menu {

	private int menunum ;
	private  String menuname ;
	private  String menucontent;
	private  int menuprice ;
	private  String menuimg ;
	private  int cnum ;
	
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}


	public Menu(int menunum, String menuname, String menucontent, int menuprice, String menuimg, int cnum) {
		super();
		this.menunum = menunum;
		this.menuname = menuname;
		this.menucontent = menucontent;
		this.menuprice = menuprice;
		this.menuimg = menuimg;
		this.cnum = cnum;
	}


	public int getMenunum() {
		return menunum;
	}


	public void setMenunum(int menunum) {
		this.menunum = menunum;
	}


	public String getMenuname() {
		return menuname;
	}


	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}


	public String getMenucontent() {
		return menucontent;
	}


	public void setMenucontent(String menucontent) {
		this.menucontent = menucontent;
	}


	public int getMenuprice() {
		return menuprice;
	}


	public void setMenuprice(int menuprice) {
		this.menuprice = menuprice;
	}


	public String getMenuimg() {
		return menuimg;
	}


	public void setMenuimg(String menuimg) {
		this.menuimg = menuimg;
	}


	public int getCnum() {
		return cnum;
	}


	public void setCnum(int cnum) {
		this.cnum = cnum;
	}


	@Override
	public String toString() {
		return "Menu [menunum=" + menunum + ", menuname=" + menuname + ", menucontent=" + menucontent + ", menuprice="
				+ menuprice + ", menuimg=" + menuimg + ", cnum=" + cnum + "]";
	}
	
	
	
	
	
}
