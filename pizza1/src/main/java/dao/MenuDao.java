package dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Category;
import dto.Franchisee;
import dto.Menu;
import dto.Subpizza;

public class MenuDao extends Dao{

	public static MenuDao menuDao = new MenuDao();
	
	public static MenuDao getmemberDao() { return menuDao; } 
	
	public MenuDao() {
		super(); // 부모클래스 생성자 호출 
	}
	
	public boolean csave( String cname ,String checkval) { 
		String sql = "insert into category(cname,pizza)values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cname);
			ps.setString(2, checkval);
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);} return false;
	}
	
	public ArrayList<Category> getcategorylist(){ 
		ArrayList<Category> list = new ArrayList<Category>();
		String sql = "select * from category";
		try {
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { // 1개 호출시 if // 여러개 호출시 while
				Category category = new Category( rs.getInt(1) , rs.getString(2),rs.getString(3) );
				list.add(category);
			}
			return list;
		}catch (Exception e) {} return null; 
	}
	
	
	public boolean menuadd( Menu menu ) {
		String sql = "insert into menu(menuname,menucontent,menuprice,menuimg,cnum ) "
				+ "values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , menu.getMenuname() );		ps.setString( 2 , menu.getMenucontent());
			ps.setInt( 3 , menu.getMenuprice() );	ps.setString( 4 , menu.getMenuimg() );
			ps.setInt( 5 , menu.getCnum() );ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}return false; 
	}
	
	////메뉴수정
	public boolean menuupdate( Menu menu ) {
		String sql = "update menu set menuname=?, menucontent=?, menuprice=?, menuimg=?, cnum=? where menunum="+menu.getMenunum();
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , menu.getMenuname() );		ps.setString( 2 , menu.getMenucontent());
			ps.setInt( 3 , menu.getMenuprice() );	ps.setString( 4 , menu.getMenuimg() );
			ps.setInt( 5 , menu.getCnum() );ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}return false; 
	}
	
	
	public ArrayList<Menu> getmenulist() { 
		ArrayList<Menu> menulist = new ArrayList<Menu>();
		
		String sql = "select * from menu";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Menu menu = new Menu(
						rs.getInt(1),rs.getString(2), 
						rs.getString(3), rs.getInt(4), 
						rs.getString(5), rs.getInt(6));
				menulist.add(menu);
			} return menulist;
		}catch(Exception e ) {} return null;
	}
	
	
	public boolean pizzasize( String size ,int sizeprice ,int menunum) { 
		String sql = "insert into subpizza(subsize,subprice,menunum)values(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, size);
			ps.setInt(2, sizeprice);
			ps.setInt(3, menunum);
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);} return false;
	}
	
	public boolean pizzaedge(String edge,int edgeprice,String edgeimg,int menunum) { 
		String sql = "insert into subpizza(subedge,subprice,subedgeimg,menunum)values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, edge);
			ps.setInt(2, edgeprice);
			ps.setString(3,edgeimg);
			ps.setInt(4,menunum);
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);} return false;
	}
	
	public ArrayList<Subpizza> getsubpizza(int menunum){
		ArrayList<Subpizza> subpizzalist = new ArrayList<Subpizza>();
		try {
		String sql = "select * from subpizza where menunum = "+menunum;
		ps=con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			Subpizza subpizza = new Subpizza(
					rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5),rs.getInt(6)
					);
			subpizzalist.add(subpizza);
		}
		return subpizzalist;
		}catch(Exception e) {System.out.println("뭐어"+e);}
		return null;
	}
	
	
	//사이즈수정
	public boolean sizeupdate(int subnum,String sizeup,int sizepriceup) {
		try {
			String sql = "update subpizza set subsize=?, subprice=? where subnum=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, sizeup);;
			ps.setInt(2, sizepriceup);
			ps.setInt(3, subnum);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {}
		return false;
	}
	
	///엣지수정
	public boolean edgeupdate(String edgeup,int edgeupprice,String edgeupimg,int subnum) {
		try {
			String sql = "update subpizza set subedge=?, subedgeimg=?, subprice=?  where subnum=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, edgeup);;
			ps.setString(2, edgeupimg);
			ps.setInt(3, edgeupprice);
			ps.setInt(4, subnum);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {}
		return false;
	}
	
	
	///메뉴바에 피자종류 출력
	public ArrayList<Category> getcategory(){
		try {
			ArrayList<Category> getcategory = new ArrayList<Category>();
			String sql = "select * from category where pizza='true'";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Category category = new Category(
						rs.getInt(1),rs.getString(2),rs.getString(3)
						);
				getcategory.add(category);
			}
			return getcategory;
		}catch(Exception e) {System.out.println(e);}
		
		return null;
	}
	
	public ArrayList<Category> getside(){
		try {
			ArrayList<Category> getcategory = new ArrayList<Category>();
			String sql = "select * from category where cname='사이드'";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Category category = new Category(
						rs.getInt(1),rs.getString(2),rs.getString(3)
						);
				getcategory.add(category);
			}
			return getcategory;
		}catch(Exception e) {System.out.println(e);}
		
		return null;
	}
	
	public ArrayList<Category> getdrink(){
		try {
			ArrayList<Category> getcategory = new ArrayList<Category>();
			String sql = "select * from category where cname='음료' or cname='기타'";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Category category = new Category(
						rs.getInt(1),rs.getString(2),rs.getString(3)
						);
				getcategory.add(category);
			}
			return getcategory;
		}catch(Exception e) {System.out.println(e);}
		
		return null;
	}
	
	///피자출력 json
	//SELECT * FROM jsp.menu A, jsp.category B where A.cnum=B.cnum and B.pizza='true';
	public JSONArray getreview(int cnum){
		JSONArray jsonArray = new JSONArray();
		try {
			 String sql = "SELECT * FROM menu A, category B where A.cnum=B.cnum and B.cnum="+cnum;
	 		
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while( rs.next() ) {
				// 결과내 하나씩 모든 레코드를 -> 하나씩 json객체 변환  
				JSONObject object = new JSONObject();
				object.put( "menunum" , rs.getInt(1) );
				object.put( "menuname" , rs.getString(2) );
				object.put( "menucontent" , rs.getString(3) );
				object.put( "menuprice" , rs.getInt(4) );
				object.put( "menuimg" , rs.getString(5) );
				object.put( "cnum" , rs.getInt(6) );
				object.put( "cnum" , rs.getInt(7) );
				object.put( "cname" , rs.getString(8));
				object.put( "pizza" , rs.getString(9));
				jsonArray.put( object );
			}
			return jsonArray;
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	
	public Menu getmenuview(int menunum) {
		try {
			String sql = "select * from menu where menunum="+menunum;
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				Menu menu = new Menu(
				rs.getInt(1), rs.getString(2) ,
				rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6)
						);
				return menu;
			}
		}catch(Exception e) {System.out.println("sql"+e);}return null;
	}
	
	
	///토핑가져오기
	public ArrayList<Menu> gettopping(){
		try {
			ArrayList<Menu> gettopping = new ArrayList<Menu>();
			String sql = "SELECT menunum ,menuname, menucontent,menuprice,menuimg , A.cnum FROM menu A, category B where A.cnum=B.cnum and B.cname='토핑';";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu(
						rs.getInt(1), rs.getString(2) ,
						rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6)
								);
				gettopping.add(menu);
			}
			return gettopping;
		}catch(Exception e) {System.out.println(e);}
		
		return null;
	}
	
	public Subpizza subpizza(int subnum) {
		try {
			String sql = "select * from subpizza where subnum="+subnum;
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				Subpizza subpizza = new Subpizza(
						rs.getInt(1),rs.getString(2)
						,rs.getString(3),rs.getString(4)
						,rs.getInt(5),rs.getInt(6)
						);
				return subpizza;
			}
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	
	
	
	
	///메뉴삭제
	public boolean deletemenu(int menunum) {
		try {
			String sql = "delete from menu where menunum="+menunum;
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println(e);}
		return false;
	}
	
	public boolean sizemenu(int subnum) {
		try {
			String sql = "delete from subpizza where subnum="+subnum;
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println(e);}
		return false;
	}
}
