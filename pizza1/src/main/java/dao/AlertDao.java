package dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.AlertDto;
import dto.Order;

public class AlertDao extends Dao {

	public static AlertDao alertDao = new AlertDao();
	public static AlertDao getalertDao() {return alertDao;}
	
	public AlertDao() {
		super(); 
	}

	public String getmenuname(int menunum) {
		String sql = "select menuname from menu where menunum ="+menunum;
	
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			if( rs.next() ) { return rs.getString(1); } 
		} catch (Exception e) {System.out.println("메뉴이름변환");}
		return null; 
	}
	
	public String getedgename(int subnum) {
		String sql = "SELECT subedge from subpizza where subnum ="+subnum;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			if( rs.next() ) { return rs.getString(1); } 
		} catch (Exception e) {System.out.println("엣지이름변환");}
		return null; 
	}
	
	public String getsize(int subnum) {
		String sql = "SELECT subsize from subpizza where subnum = "+subnum;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			if( rs.next() ) { return rs.getString(1); } 
		} catch (Exception e) {System.out.println("사이즈이름변환");}
		return null; 
	}
	
	
	
	public int getonum(String date) {
		String sql = "SELECT onum FROM porder where odate = '"+date+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			if( rs.next() ) { return rs.getInt(1); } 
		} catch (Exception e) {System.out.println("onum추출"+e);}
		return 0; 
	}
	
	
//	public JSONArray getalertlist(int onum) {
//		JSONArray ajsonArray = new JSONArray();
//		String sql = "SELECT a.onum "
//				+ " , a.odate  "
//				+ " , a.ophone "
//				+ " , a.oaddress "
//				+ " , a.ototalprice "
//				+ " , a.odelivery "
//				+ " , a.mnum "
//				+ " , a.fnum "
//				+ " , a.ostate "
//				+ " , a.orequest "
//				+ " , b.odetailnum "
//				+ " , b.omenunum "
//				+ " , b.oamount "
//				+ " , b.osize "
//				+ " , b.oedge "
//				+ " , b.otopping1 "
//				+ " , b.otopping2 "
//				+ "from porder as a "
//				+ "inner join orderdetail as b "
//				+ "on a.onum = b.onum "
//				+ "where a.onum ="+onum;
//		try {
//			
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				JSONObject object = new JSONObject();
//				object.put("onum", rs.getInt(1));
//				object.put("odate", rs.getString(2));
//				object.put("ophone", rs.getString(3));
//				object.put("oaddress", rs.getString(4));
//				object.put("ototalprice", rs.getInt(5));
//				object.put("odelivery", rs.getString(6));
//				object.put("mnum", rs.getInt(7));
//				object.put("fnum", rs.getInt(8));
//				object.put("ostate", rs.getString(9));
//				object.put("orequest", rs.getString(10));
//				object.put("odetailnum", rs.getInt(11));
//				object.put("omenunum",rs.getInt(12));
//				object.put("oamount", rs.getInt(13));
//				object.put("osize",rs.getInt(14));
//				object.put("oedge",rs.getInt(15));
//				object.put("otopping1",rs.getInt(16));
//				object.put("otopping2",rs.getInt(17));//
//				//String menuname = getmenuname(rs.getInt(12));
//				//object.put("omenuname",menuname );
//				System.out.println("주문번호" +rs.getInt(1));
//				System.out.println("오브젝트조회"+object.get("onum")); 
//				//System.out.println("왜 안되는거지" +rs.getInt(12));
////				object.put("oamount", rs.getInt(13));
////				object.put("osize",getsize(rs.getInt(14)) );
////				object.put("oedge", getedgename(rs.getInt(15)));
////				object.put("otopping1", getmenuname(rs.getInt(16)));
////				object.put("otopping2", getmenuname(rs.getInt(17)));
//				// 오브젝트에 타입안맞으면 안들어가는듯
//				ajsonArray.put(object);
//				System.out.println("daojson" + ajsonArray);
//			}
//			return ajsonArray;
//		} catch(Exception e) {
//			System.out.println("아아아아아아아앙" + e);
//		}return null;
//	}
	
	
	public ArrayList<AlertDto> getalertlist(int onum) {
		ArrayList<AlertDto> alertlist = new ArrayList<>();
		String sql = "SELECT a.onum "
				+ " , a.odate  "
				+ " , a.ophone "
				+ " , a.oaddress "
				+ " , a.ototalprice "
				+ " , a.odelivery "
				+ " , a.mnum "
				+ " , a.fnum "
				+ " , a.ostate "
				+ " , a.orequest "
				+ " , b.odetailnum "
				+ " , b.omenunum "
				+ " , b.oamount "
				+ " , b.osize "
				+ " , b.oedge "
				+ " , b.otopping1 "
				+ " , b.otopping2 "
				+ "from porder as a "
				+ "inner join orderdetail as b "
				+ "on a.onum = b.onum "
				+ "where a.onum ="+onum+ " order by 1 desc";;
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				AlertDto alert = new AlertDto(
						rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getInt(5),rs.getString(6),
						rs.getInt(7),rs.getInt(8),
						rs.getString(9),rs.getString(10),
						rs.getInt(11),rs.getInt(12)
						,rs.getInt(13),rs.getInt(14)
						,rs.getInt(15),rs.getInt(16),
						rs.getInt(17)
						);
			
				alertlist.add(alert);
				System.out.println("daoaarray" + alertlist);
			}
			return alertlist;
		} catch(Exception e) {
			System.out.println("아아아아아아아앙" + e);
		}return null;
	}
	
	// 주문내역 
	public ArrayList<AlertDto> getorderlist(int fnum) {
		ArrayList<AlertDto> orderlist = new ArrayList<>();
		String sql = "SELECT a.onum "
				+ " , a.odate  "
				+ " , a.ophone "
				+ " , a.oaddress "
				+ " , a.ototalprice "
				+ " , a.odelivery "
				+ " , a.mnum "
				+ " , a.fnum "
				+ " , a.ostate "
				+ " , a.orequest "
				+ " , b.odetailnum "
				+ " , b.omenunum "
				+ " , b.oamount "
				+ " , b.osize "
				+ " , b.oedge "
				+ " , b.otopping1 "
				+ " , b.otopping2 "
				+ "from porder as a "
				+ "inner join orderdetail as b "
				+ "on a.onum = b.onum "
				+ "where a.fnum = "+fnum+" order by 1 desc";
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				AlertDto alert = new AlertDto(
						rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getInt(5),rs.getString(6),
						rs.getInt(7),rs.getInt(8),
						rs.getString(9),rs.getString(10),
						rs.getInt(11),rs.getInt(12)
						,rs.getInt(13),rs.getInt(14)
						,rs.getInt(15),rs.getInt(16),
						rs.getInt(17)
						);
			
				orderlist.add(alert);
				System.out.println("getorderlist" + orderlist);
			}
			return orderlist;
		} catch(Exception e) {
			System.out.println("아아아아아아아앙" + e);
		}return null;
	}
	

	
	
	
	public void changestate(int odetailnum) {
		String sql = "update porder as a "
				+ "inner join "
				+ "orderdetail as b on a.onum = b.onum "
				+ "set a.ostate = '주문접수완료' "
				+ "where b.odetailnum = " +odetailnum;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate(); 
		}
		catch (Exception e) { System.out.println( e );}
	}
	
	public String getimg(int menunm) {
		String sql = "SELECT menuimg FROM pizza.menu where menunum="+menunm;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			if( rs.next() ) { return rs.getString(1); } 
		} catch (Exception e) {System.out.println("이미지추출");}
		return null;
	}
	
}

