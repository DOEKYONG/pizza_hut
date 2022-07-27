package dao;

import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Cart;
import dto.Franchisee;
import dto.Order;

public class OrderDao extends Dao{
	
	public static OrderDao orderDao = new OrderDao();
		
		public static OrderDao getorderDao() { return orderDao; } 
		
		public OrderDao() {
			super(); 
		}
		
		
		
		public int getsubpizzaprice(int subnum) {
			try {
			String sql = "select subprice from subpizza where subnum="+subnum;
			
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			}catch(Exception e) {System.out.println("sdds"+e);}
			return 0;
		}
		
		public int getmenuprice(int menunum) {
			try {
			String sql = "select menuprice from menu where menunum="+menunum;
			
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			}catch(Exception e) {System.out.println("sdds"+e);}
			return 0;
		}
		
		
		public JSONArray getmenu(int menunum) {
			JSONArray jsonArray = new JSONArray();
			try {
				 String sql = "SELECT * FROM menu where menunum="+menunum;
		 		
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
					jsonArray.put( object );
				}
				return jsonArray;
			}catch(Exception e) {System.out.println(e);}
			return null;
		}
		
		
		public boolean addcart(Cart cart) {
			try {
				String sql  ="insert into cart(samount,totalprice,menunum,sizenum,edgenum,topping1,topping2,mnum) values(?,?,?,?,?,?,?,?)";
				ps=con.prepareStatement(sql);
				ps.setInt(1, cart.getSamount());
				ps.setInt(2, cart.getTotalprice());
				ps.setInt(3, cart.getMenunum());
				ps.setInt(4, cart.getSizenum());
				ps.setInt(5, cart.getEdgenum());
				ps.setInt(6, cart.getTopping1());
				ps.setInt(7, cart.getTopping2());
				ps.setInt(8, cart.getMnum());
				ps.executeUpdate();
				return true;
			}catch(Exception e) {}
			return false;
		}
		
		public boolean subaddcart(int menunum,int count,int totalprice,int mnum) {
			try {
				String sql  ="insert into cart(samount,totalprice,menunum,mnum) values(?,?,?,?)";
				ps=con.prepareStatement(sql);
				ps.setInt(1, count);
				ps.setInt(2, totalprice);
				ps.setInt(3, menunum);
				ps.setInt(4, mnum);
				ps.executeUpdate();
				return true;
			}catch(Exception e) {System.out.println("???"+e);}
			return false;
		}
		
		
		
		public ArrayList<Cart> getcarts(int mnum){
			ArrayList<Cart> getcarts = new ArrayList<Cart>();
			try {
				String sql = "select * from cart where mnum="+mnum;
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()) {
					Cart cart = new Cart(
							rs.getInt(1),
							rs.getInt(2)
							,rs.getInt(3)
							,rs.getInt(4)
							,rs.getInt(5)
							,rs.getInt(6)
							,rs.getInt(7)
							,rs.getInt(8)
							,rs.getInt(9));
					getcarts.add(cart);
				}
				return getcarts;
			}catch(Exception e) {}
			return null;
		}
		
		////장바구니삭제
		public boolean cartdelete(int cnum) {
			try {
				String sql = "delete from cart where cartno="+cnum;
				ps=con.prepareStatement(sql);
				ps.executeUpdate();
				return true;
			}catch(Exception e) {System.out.println(e);}
			return false;
		}
		
		
		public JSONArray getotalprice(int mnum) {
		JSONArray jsonArray = new JSONArray();
		try {
			 String sql = "SELECT * FROM cart where mnum="+mnum;
	 		
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while( rs.next() ) {
				// 결과내 하나씩 모든 레코드를 -> 하나씩 json객체 변환  
				JSONObject object = new JSONObject();
				object.put( "cartno" , rs.getInt(1) );
				object.put( "samount" , rs.getInt(2) );
				object.put( "totalprice" , rs.getInt(3) );
				object.put( "menunum" , rs.getInt(4) );
				object.put( "sizenum" , rs.getInt(5) );
				object.put( "edgenum" , rs.getInt(6) );
				object.put( "topping1" , rs.getInt(7) );
				object.put( "topping2" , rs.getInt(8) );
				object.put( "mnum" , rs.getInt(9) );
				jsonArray.put( object );
			}
			return jsonArray;
		}catch(Exception e) {System.out.println("sss"+e);}
		return null;
	}
		
		
		public JSONArray findstore(String address) {
			JSONArray jsonArray = new JSONArray();
			try {
				String sql = "select * from franchisee A, opertime B where A.faddress LIKE '%"+address+"%' and A.fnum=B.fnum and B.otime=1";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				while( rs.next() ) {
					JSONObject object = new JSONObject();
					object.put( "fnum" , rs.getInt(1) );
					object.put( "ordernum" , rs.getInt(2) );
					object.put( "faddress" , rs.getString(3) );
					object.put( "fname" , rs.getString(4) );
					object.put( "onum" , rs.getInt(5) );
					object.put( "fnum" , rs.getInt(6) );
					object.put( "otime" , rs.getInt(7) );
					jsonArray.put( object );
				}
				return jsonArray;
			}catch(Exception e) {}
			return null;
		}
		
		public JSONArray findstore2(String address) {
			JSONArray jsonArray = new JSONArray();
			try {
				String sql = "select * from franchisee A, opertime B where A.faddress LIKE '%"+address+"%'  and A.fnum=B.fnum or  A.fname LIKE '%"+address+"%' and A.fnum=B.fnum and B.otime=1";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				while( rs.next() ) {
					JSONObject object = new JSONObject();
					object.put( "fnum" , rs.getInt(1) );
					object.put( "ordernum" , rs.getInt(2) );
					object.put( "faddress" , rs.getString(3) );
					object.put( "fname" , rs.getString(4) );
					object.put( "onum" , rs.getInt(5) );
					object.put( "fnum1" , rs.getInt(6) );
					object.put( "otime" , rs.getInt(7) );
					jsonArray.put( object );
				}
				return jsonArray;
			}catch(Exception e) {}
			return null;
		}
		
		
		//가맹점찾기
		public JSONArray getfranchisee(int fnum) {
		JSONArray jsonArray = new JSONArray();
			try {
				String sql ="select * from franchisee where fnum="+fnum;
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()) {
					JSONObject object = new JSONObject();
					object.put( "fnum" , rs.getInt(1) );
					object.put( "ordernum" , rs.getInt(2) );
					object.put( "faddress" , rs.getString(3) );
					object.put( "fname" , rs.getString(4) );
					jsonArray.put( object );
				}
				return jsonArray;
			}catch(Exception e) {System.out.println(e);}
			return null;
		}
		
		
			public boolean saveorder( Order order  ) {
			
			String sql = "insert into porder(ophone,oaddress,ototalprice,odelivery,mnum,fnum,ostate,orequest,odate) values(?,?,?,?,?,?,?,?,?)";
			try {				
				ps = con.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS );
				ps.setString( 1 , order.getOphone() );
				ps.setString( 2 , order.getOaddress() );
				ps.setInt( 3 , order.getOtotalprice() );
				ps.setString( 4 , order.getOdelivery() );
				ps.setInt( 5 , order.getMnum() );
				ps.setInt( 6 , order.getFnum() );
				ps.setString( 7 , order.getOstate() );
				ps.setString(8 , order.getOrequest() );
				ps.setString(9, order.getOdate());
				ps.executeUpdate();		
				rs = ps.getGeneratedKeys(); 
				if( rs.next() ) {
					int pk = rs.getInt(1);
					sql = "insert into orderdetail(onum,oamount,omenunum, osize,oedge,otopping1,otopping2)"
							+ "select "+pk+", samount,menunum,sizenum,edgenum,topping1,topping2 from cart where mnum = "+order.getMnum();
					ps = con.prepareStatement(sql);
					ps.executeUpdate();
					
					
					sql ="delete from cart where mnum = "+order.getMnum();
					ps = con.prepareStatement(sql);
					ps.executeUpdate();
					return true;
				}
			}catch (Exception e) {System.out.println(e);}
			
			return false;
		}
		
			///메뉴명가져오기
			public JSONArray getcartmenuname(int mnum) {
				JSONArray jsonArray = new JSONArray();
				try {
					 String sql = "SELECT * FROM cart A, menu B where A.mnum="+mnum+"  and A.mnum=B.menunum";

					ps=con.prepareStatement(sql);
					rs=ps.executeQuery();
					while( rs.next() ) {
						// 결과내 하나씩 모든 레코드를 -> 하나씩 json객체 변환  
						JSONObject object = new JSONObject();
						object.put( "cartno" , rs.getInt(1) );
						object.put( "samount" , rs.getInt(2) );
						object.put( "totalprice" , rs.getInt(3) );
						object.put( "menunum" , rs.getInt(4) );
						object.put( "sizenum" , rs.getInt(5) );
						object.put( "edgenum" , rs.getInt(6) );
						object.put( "topping1" , rs.getInt(7) );
						object.put( "topping2" , rs.getInt(8) );
						object.put( "mnum" , rs.getInt(9) );
						object.put( "menunum" , rs.getInt(10) );
						object.put( "menuname" , rs.getString(11) );
						object.put( "menucontent" , rs.getString(12) );
						object.put( "menuprice" , rs.getInt(13) );
						object.put( "menuimg" , rs.getString(14) );
						object.put( "cnum" , rs.getInt(15) );
						jsonArray.put( object );
					}
					return jsonArray;
				}catch(Exception e) {System.out.println("sss"+e);}
				return null;
			}

			//토핑1가져오기
			public JSONArray getcarttopping1(int mnum) {
				JSONArray jsonArray = new JSONArray();
				try {
					 String sql = "SELECT * FROM cart A, menu B where A.mnum="+mnum+"  and A.topping1=B.menunum";

					ps=con.prepareStatement(sql);
					rs=ps.executeQuery();
					while( rs.next() ) {
						// 결과내 하나씩 모든 레코드를 -> 하나씩 json객체 변환  
						JSONObject object = new JSONObject();
						object.put( "cartno" , rs.getInt(1) );
						object.put( "samount" , rs.getInt(2) );
						object.put( "totalprice" , rs.getInt(3) );
						object.put( "menunum" , rs.getInt(4) );
						object.put( "sizenum" , rs.getInt(5) );
						object.put( "edgenum" , rs.getInt(6) );
						object.put( "topping1" , rs.getInt(7) );
						object.put( "topping2" , rs.getInt(8) );
						object.put( "mnum" , rs.getInt(9) );
						object.put( "menunum" , rs.getInt(10) );
						object.put( "menuname" , rs.getString(11) );
						object.put( "menucontent" , rs.getString(12) );
						object.put( "menuprice" , rs.getInt(13) );
						object.put( "menuimg" , rs.getString(14) );
						object.put( "cnum" , rs.getInt(15) );
						jsonArray.put( object );
					}
					return jsonArray;
				}catch(Exception e) {System.out.println("sss"+e);}
				return null;
			}

			public JSONArray getcarttopping2(int mnum) {
				JSONArray jsonArray = new JSONArray();
				try {
					 String sql = "SELECT * FROM cart A, menu B where A.mnum="+mnum+"  and A.topping2=B.menunum";

					ps=con.prepareStatement(sql);
					rs=ps.executeQuery();
					while( rs.next() ) {
						// 결과내 하나씩 모든 레코드를 -> 하나씩 json객체 변환  
						JSONObject object = new JSONObject();
						object.put( "cartno" , rs.getInt(1) );
						object.put( "samount" , rs.getInt(2) );
						object.put( "totalprice" , rs.getInt(3) );
						object.put( "menunum" , rs.getInt(4) );
						object.put( "sizenum" , rs.getInt(5) );
						object.put( "edgenum" , rs.getInt(6) );
						object.put( "topping1" , rs.getInt(7) );
						object.put( "topping2" , rs.getInt(8) );
						object.put( "mnum" , rs.getInt(9) );
						object.put( "menunum" , rs.getInt(10) );
						object.put( "menuname" , rs.getString(11) );
						object.put( "menucontent" , rs.getString(12) );
						object.put( "menuprice" , rs.getInt(13) );
						object.put( "menuimg" , rs.getString(14) );
						object.put( "cnum" , rs.getInt(15) );
						jsonArray.put( object );
					}
					return jsonArray;
				}catch(Exception e) {System.out.println("sss"+e);}
				return null;
			}
			public JSONArray getcartsize(int mnum) {
				JSONArray jsonArray = new JSONArray();
				try {
					 String sql = "SELECT * FROM cart A, subpizza B where A.mnum="+mnum+"  and A.sizenum=B.subnum";

					ps=con.prepareStatement(sql);
					rs=ps.executeQuery();
					while( rs.next() ) {
						// 결과내 하나씩 모든 레코드를 -> 하나씩 json객체 변환  
						JSONObject object = new JSONObject();
						object.put( "cartno" , rs.getInt(1) );
						object.put( "samount" , rs.getInt(2) );
						object.put( "totalprice" , rs.getInt(3) );
						object.put( "menunum" , rs.getInt(4) );
						object.put( "sizenum" , rs.getInt(5) );
						object.put( "edgenum" , rs.getInt(6) );
						object.put( "topping1" , rs.getInt(7) );
						object.put( "topping2" , rs.getInt(8) );
						object.put( "mnum" , rs.getInt(9) );
						object.put( "subnum" , rs.getInt(10) );
						object.put( "subsize" , rs.getString(11) );
						object.put( "subedge" , rs.getString(12) );
						object.put( "subedgeimg" , rs.getString(13) );
						object.put( "subprice" , rs.getInt(14) );
						object.put( "menunum1" , rs.getInt(15) );
						jsonArray.put( object );
					}
					return jsonArray;
				}catch(Exception e) {System.out.println("sss"+e);}
				return null;
			}
			public JSONArray getcartedge(int mnum) {
				JSONArray jsonArray = new JSONArray();
				try {
					 String sql = "SELECT * FROM cart A, subpizza B where A.mnum="+mnum+"  and A.edgenum=B.subnum";

					ps=con.prepareStatement(sql);
					rs=ps.executeQuery();
					while( rs.next() ) {
						// 결과내 하나씩 모든 레코드를 -> 하나씩 json객체 변환  
						JSONObject object = new JSONObject();
						object.put( "cartno" , rs.getInt(1) );
						object.put( "samount" , rs.getInt(2) );
						object.put( "totalprice" , rs.getInt(3) );
						object.put( "menunum" , rs.getInt(4) );
						object.put( "sizenum" , rs.getInt(5) );
						object.put( "edgenum" , rs.getInt(6) );
						object.put( "topping1" , rs.getInt(7) );
						object.put( "topping2" , rs.getInt(8) );
						object.put( "mnum" , rs.getInt(9) );
						object.put( "subnum" , rs.getInt(10) );
						object.put( "subsize" , rs.getString(11) );
						object.put( "subedge" , rs.getString(12) );
						object.put( "subedgeimg" , rs.getString(13) );
						object.put( "subprice" , rs.getInt(14) );
						object.put( "menunum1" , rs.getInt(15) );
						jsonArray.put( object );
					}
					return jsonArray;
				}catch(Exception e) {System.out.println("sss"+e);}
				return null;
			}
			
			public boolean changecoupon(int couponnum,int mnum) {
				try {
					String sql = "update couponlist set couponactive='사용완료' where eventnum=? and mnum=?";
					ps=con.prepareStatement(sql);
					ps.setInt(1, couponnum);
					ps.setInt(2, mnum);
					ps.executeUpdate();
					return true;
				}catch(Exception e) {}
				return false;
			}

}
