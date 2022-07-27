package dto;

public class Category {

	private int cnum ;
	private String cname;
	private String pizza ;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int cnum, String cname, String pizza) {
		super();
		this.cnum = cnum;
		this.cname = cname;
		this.pizza = pizza;
	}

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPizza() {
		return pizza;
	}

	public void setPizza(String pizza) {
		this.pizza = pizza;
	}

	@Override
	public String toString() {
		return "Category [cnum=" + cnum + ", cname=" + cname + ", pizza=" + pizza + "]";
	}
	
	
	
	
	
}
