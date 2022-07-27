package dto;

public class Event {
	private int eventnum; 
	private String eventtitle;
	private String coupon;
	private int discount; 
	private String eventstart;
	private String eventend ;
	private String bannerimg ;
	private String eventimg;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(int eventnum, String eventtitle, String coupon, int discount, String eventstart, String eventend,
			String bannerimg, String eventimg) {
		super();
		this.eventnum = eventnum;
		this.eventtitle = eventtitle;
		this.coupon = coupon;
		this.discount = discount;
		this.eventstart = eventstart;
		this.eventend = eventend;
		this.bannerimg = bannerimg;
		this.eventimg = eventimg;
	}

	public int getEventnum() {
		return eventnum;
	}

	public void setEventnum(int eventnum) {
		this.eventnum = eventnum;
	}

	public String getEventtitle() {
		return eventtitle;
	}

	public void setEventtitle(String eventtitle) {
		this.eventtitle = eventtitle;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getEventstart() {
		return eventstart;
	}

	public void setEventstart(String eventstart) {
		this.eventstart = eventstart;
	}

	public String getEventend() {
		return eventend;
	}

	public void setEventend(String eventend) {
		this.eventend = eventend;
	}

	public String getBannerimg() {
		return bannerimg;
	}

	public void setBannerimg(String bannerimg) {
		this.bannerimg = bannerimg;
	}

	public String getEventimg() {
		return eventimg;
	}

	public void setEventimg(String eventimg) {
		this.eventimg = eventimg;
	}

	@Override
	public String toString() {
		return "Event [eventnum=" + eventnum + ", eventtitle=" + eventtitle + ", coupon=" + coupon + ", discount="
				+ discount + ", eventstart=" + eventstart + ", eventend=" + eventend + ", bannerimg=" + bannerimg
				+ ", eventimg=" + eventimg + "]";
	}
	
	
	
	
}
