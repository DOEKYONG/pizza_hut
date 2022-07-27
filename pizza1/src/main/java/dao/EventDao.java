package dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Couponlist;
import dto.Event;
import dto.Franchisee;

public class EventDao extends Dao{

	
	public static EventDao eventDao = new EventDao();
	
	public static EventDao geteventDao() { return eventDao; } 
	
	public EventDao() {
		super(); // 부모클래스 생성자 호출 
	}

	
	public boolean addevent(Event event) {
		try {
			String sql = "insert into event(eventtitle, coupon, discount, eventstart, eventend, bannerimg, eventimg) values(?,?,?,?,?,?,?)";
			ps= con.prepareStatement(sql);
			ps.setString(1,event.getEventtitle());
			ps.setString(2,event.getCoupon());
			ps.setInt(3,event.getDiscount());
			ps.setString(4,event.getEventstart());
			ps.setString(5,event.getEventend());
			ps.setString(6,event.getBannerimg());
			ps.setString(7,event.getEventimg());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	////진행중인 이벤트 리스트
	public ArrayList<Event> geteventlist(String today) {
	
		ArrayList<Event> list = new ArrayList<Event>();
		String sql = "select * from event where '"+today+"' BETWEEN eventstart AND eventend order by eventnum desc";
		try {
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { // 1개 호출시 if // 여러개 호출시 while
				Event event = new Event( 
						rs.getInt(1) , rs.getString(2),
						rs.getString(3),rs.getInt(4),
						rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8)
						);
				list.add(event);
			}
			return list;
		}catch (Exception e) {System.out.println("제품리스트"+e);} return null; 
		
	}
	
	
	////게시물 전체갯수 출력
	public int gettotallist(String key, String keyword) {
		try {
			String sql = null;
			if(key.equals("") && keyword.equals("")) {
				sql = "select count(*) from event";
			}
			else {
				sql = "select count(*) from event where "+key+" like '%"+keyword+"%'";
			}
			ps = con.prepareStatement(sql); rs = ps.executeQuery(); 
			if( rs.next() ) return rs.getInt(1); 
		}catch (Exception e) {
		}return 0;
	}
	
	
	////끝난 이벤트리스트
	public ArrayList<Event> geteventend(String today,int startrow, int listsize,String key, String keyword) {
		ArrayList<Event> list = new ArrayList<Event>();
		String sql = null;
		if(keyword.equals("")) {
			sql = "select * from event where '"+today+"' > eventend order by eventnum desc limit "+startrow+","+listsize;;
		}
		else {
			sql = "select * from event where '"+today+"' > eventend and "+key+" like '%"+keyword+"%'  order by eventnum desc limit "+startrow+","+listsize;;
		}
		try {
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { // 1개 호출시 if // 여러개 호출시 while
				Event event = new Event( 
						rs.getInt(1) , rs.getString(2),
						rs.getString(3),rs.getInt(4),
						rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8)
						);
				list.add(event);
			}
			return list;
		}catch (Exception e) {System.out.println("제품리스트"+e);} return null; 
		
	}
	
	////예정중인 이벤트리스트
	public ArrayList<Event> geteventstart(String today) {
		
		ArrayList<Event> list = new ArrayList<Event>();
		String sql = "select * from event where '"+today+"' < eventstart order by eventnum desc";
		try {
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { // 1개 호출시 if // 여러개 호출시 while
				Event event = new Event( 
						rs.getInt(1) , rs.getString(2),
						rs.getString(3),rs.getInt(4),
						rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8)
						);
				list.add(event);
			}
			return list;
		}catch (Exception e) {System.out.println("제품리스트"+e);} return null; 
		
	}
	
	
	/////개별 이벤트 출력
	public Event getevent(int eventnum) {
		try {
		String sql = "select * from event where eventnum=?";
		ps=con.prepareStatement(sql);
		ps.setInt(1, eventnum);
		rs=ps.executeQuery();
		if(rs.next()) {
			Event event = new Event(
					rs.getInt(1) , rs.getString(2),
					rs.getString(3),rs.getInt(4),
					rs.getString(5),rs.getString(6),
					rs.getString(7),rs.getString(8)
					);
			return event;
		}
		
	}catch (Exception e) {System.out.println("이벤트출력"+e);} return null; 
	
	}
	
	public Event getevent2(int eventnum,String today) {
		System.out.println(today);
		try {
		String sql = "select * from event where eventnum=? and '"+today+"' < eventend";
		ps=con.prepareStatement(sql);
		ps.setInt(1, eventnum);
		rs=ps.executeQuery();
		if(rs.next()) {
			Event event = new Event(
					rs.getInt(1) , rs.getString(2),
					rs.getString(3),rs.getInt(4),
					rs.getString(5),rs.getString(6),
					rs.getString(7),rs.getString(8)
					);
			System.out.println(event);
			return event;
		}
		
	}catch (Exception e) {System.out.println("이벤트출력"+e);} return null; 
	
	}
	
	
	/////쿠폰 발급
	public int addcoupon(Couponlist couponlist) {
		try {
			String sql = "select * from couponlist where mnum=? and eventnum=?";
			ps= con.prepareStatement(sql);
			ps.setInt(1, couponlist.getMnum());
			ps.setInt(2, couponlist.getEventnum());
			rs= ps.executeQuery();
			if(rs.next()) {////만약 기존에 쿠폰을 발급받은 적이 있다면?
				return 1;
			}
			else {////쿠폰이 기존에 없다면?
				sql="insert into couponlist(mnum,eventnum,couponactive) values(?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, couponlist.getMnum());
				ps.setInt(2, couponlist.getEventnum());
				ps.setString(3, couponlist.getCouponactive());
				ps.executeUpdate();
				
				return 2;
			}
			
		}catch(Exception e) {System.out.println("쿠폰"+ e);
		}return 3;
	}
	
	public JSONArray getmycoupon(int mnum, String couponactive,String today){
		JSONArray jsonArray = new JSONArray();
		try {
			 String sql = "SELECT * FROM couponlist A, event B where A.eventnum=B.eventnum and A.mnum="+mnum+" and '"+today+"' < B.eventend and A.couponactive='"+couponactive+"'";
	 		
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while( rs.next() ) {
				// 결과내 하나씩 모든 레코드를 -> 하나씩 json객체 변환  
				JSONObject object = new JSONObject();
				object.put( "mnum" , rs.getInt(1) );
				object.put( "eventnum" , rs.getInt(2) );
				object.put( "couponactive" , rs.getString(3) );
				object.put( "eventnum1" , rs.getInt(4) );
				object.put( "eventtitle" , rs.getString(5) );
				object.put( "coupon" , rs.getString(6) );
				object.put( "discount" , rs.getInt(7) );
				object.put( "eventstart" , rs.getString(8));
				object.put( "eventend" , rs.getString(9));
				object.put( "bannerimg" , rs.getString(10));
				object.put( "eventimg" , rs.getString(11));
				jsonArray.put( object );
			}
			return jsonArray;
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	

	
	public ArrayList<Couponlist> getmycouponlist(int mnum, String couponactive){
		ArrayList<Couponlist> list = new ArrayList<Couponlist>();
		try {
			String sql = "select * from couponlist where mnum=? and couponactive=?";
			ps= con.prepareStatement(sql);
			ps.setInt(1, mnum);
			ps.setString(2, couponactive);
			rs= ps.executeQuery();
			while(rs.next()) {
				Couponlist couponlist = new Couponlist(
				rs.getInt(1) , rs.getInt(2),
				rs.getString(3));
				list.add(couponlist);
			}
			return list;
			
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	
	
	
	
	
	
}
