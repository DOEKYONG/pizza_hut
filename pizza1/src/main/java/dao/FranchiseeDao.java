package dao;

import java.util.ArrayList;


import dto.Franchisee;
import dto.Member;

public class FranchiseeDao extends Dao{

public static FranchiseeDao franchiseeDao = new FranchiseeDao();
	
	public static FranchiseeDao getfranchiseeDao() { return franchiseeDao; } 
	
	public FranchiseeDao() {
		super(); // 부모클래스 생성자 호출 
	}
	
	////가맹점명 중복체크
	public boolean storenamecheck( String frname ) {
		String sql = "select * from franchisee where fname = '"+frname+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			// 동일한 가맹점명이 있으면
			if( rs.next() ) { return true; } 
		}catch (Exception e) { System.out.println( e );} 
		// 동일한 가맹점명이 존재하지 않으면
		return false;
	}
	
	///가맹점등록
	public boolean ordersignup( Franchisee franchisee) {
		try {
			String sql = "insert into franchisee(ordernum,faddress,fname)values(?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, franchisee.getOrdernum());
			ps.setString(2, franchisee.getFaddress());
			ps.setString(3, franchisee.getFname());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("sql오류" + e);
		}
		return false;
	}
	
	
	
	public boolean ordersignup2( int getfnum) {
		try {
			String sql2 = "insert into opertime(fnum,otime)values(?,?)";
			ps = con.prepareStatement(sql2);
			ps.setInt(1, getfnum);
			ps.setInt(2, 2);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("sql오류" + e);
		}
		return false;
	}
	public int ordernum( String id ) {
		String sql = "select * from member where mid = '"+id+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			// 동일한 가맹점명이 있으면
			if( rs.next() ) { return rs.getInt(1); } 
		}catch (Exception e) { System.out.println( e );} 
		// 동일한 가맹점명이 존재하지 않으면
		return 0;
	}
	
	
	////게시물 전체갯수 출력
	public int gettotallist(String key, String keyword) {
		try {
			String sql = null;
			if(key.equals("") && keyword.equals("")) {
				sql = "select count(*) from franchisee";
			}
			else {
				sql = "select count(*) from franchisee where "+key+" like '%"+keyword+"%'";
			}
			ps = con.prepareStatement(sql); rs = ps.executeQuery(); 
			if( rs.next() ) return rs.getInt(1); 
		}catch (Exception e) {
		}return 0;
	}
	
	
	public ArrayList<Franchisee> getfranchiseelist(int startrow, int listsize,String key, String keyword) {
		ArrayList<Franchisee> franchiseelist = new ArrayList<Franchisee>();
		String sql = null;
		if(key.equals("") && keyword.equals("")) {
		sql = "SELECT b.*,mid FROM franchisee as b left join member as m on ordernum = mnum order by fnum desc limit "+startrow+","+listsize;
		}
		else {
			sql = "SELECT b.*,mid FROM franchisee as b left join member as m on ordernum = mnum where "+key+" like '%"+keyword+"%' order by fnum desc limit "+startrow+","+listsize;
			System.out.println(key+keyword);
 		}
		try {
			ps= con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Franchisee franchisee = new Franchisee(
						rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5)
						);
				franchiseelist.add(franchisee);
			}
			return franchiseelist;
		}catch(Exception e) {System.out.println("sql뭐냉"+e);}
		
		return null; }
	
	
	public ArrayList<Franchisee> getfranchisee() {
		ArrayList<Franchisee> franchiseelist = new ArrayList<Franchisee>();
		String sql  = "SELECT * FROM franchisee";
			
		try {
			ps= con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Franchisee franchisee = new Franchisee(
						rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),null
						);
				franchiseelist.add(franchisee);
			}
			return franchiseelist;
		}catch(Exception e) {System.out.println("sql뭐냉"+e);}
		
		return null; }
	
	/////개별 가맹점조회
	public Franchisee  get(int fnum,int ordernum) {
		try {
			String sql = "select * from franchisee where fnum=? and ordernum=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, fnum);
			ps.setInt(2, ordernum);
			rs=ps.executeQuery();
			if(rs.next()) {
				Franchisee franchisee = new Franchisee(
						rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),null
						);
				System.out.println(franchisee.toString());
				return franchisee;
			}
		}catch(Exception e) {System.out.println("sql"+e);}return null;
	}
	
	
	///개별 가맹점주 정보조회
	public Member getmember(int ordernum) {
		try {
			String sql = "select * from member where mnum=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, ordernum);
			rs=ps.executeQuery();
			if(rs.next()) {
						Member member = new Member (
								rs.getInt(1),rs.getString(2),rs.getString(3),
								rs.getString(4),rs.getString(5),
								rs.getString(6),rs.getString(7),
								rs.getString(8)
								);
						System.out.println(member.toString());
					return member; 
			}
		}catch(Exception e) {System.out.println("sql" + e);}
		return null;
	}
	
	
	
	
	////가맹점정보수정
	public boolean update( Member member ,Franchisee franchisee) {
		try {
			if( member.getMpassword() == null ) { // 패스워드 변경이 없을때 
				String sql = "update member set mname=?, memail=?, mphone=? where mnum=?";
					ps = con.prepareStatement(sql);
					ps.setString( 1 , member.getMname() );
					ps.setString( 2 , member.getMemail() );
					ps.setString( 3 , member.getMphone() );
					ps.setInt( 4, member.getMnum() );
					ps.executeUpdate();
				String sql2 = "update franchisee set faddress=?, fname=? where fnum=?";
				ps= con.prepareStatement(sql2);
				ps.setString(1, franchisee.getFaddress());
				ps.setString(2, franchisee.getFname());
				ps.setInt(3, franchisee.getFnum());
				
			}else {	// 패스워드가 변경이 있을때 
				String sql = "update member set mname=?, mpassword=?, memail=?, mphone=? where mnum=?";
					ps = con.prepareStatement(sql);
					
					ps.setString( 1 , member.getMname() );
					ps.setString( 2 , member.getMpassword() );
					ps.setString( 3 , member.getMemail() );
					ps.setString( 4 , member.getMphone() );
					ps.setInt( 5, member.getMnum() );
					ps.executeUpdate();
				String sql2 = "update franchisee set faddress=?, fname=? where fnum=?";
					ps= con.prepareStatement(sql2);
					ps.setString(1, franchisee.getFaddress());
					ps.setString(2, franchisee.getFname());
					ps.setInt(3, franchisee.getFnum());
			}
			ps.executeUpdate();
			System.out.println("업데이트"+member.toString());
			return true;
		} catch (Exception e) {} return false;
	
	}
	
		////가맹점 삭제
	public boolean delete( int fnum ,int mnum ) {
		try {
		String sql ="delete from member where mnum = '"+mnum+"'";
		ps=con.prepareStatement(sql);
		ps.executeUpdate();
		String sql1 ="delete from franchisee where fnum = '"+fnum+"'";
		ps=con.prepareStatement(sql1);
		ps.executeUpdate();
		return true; }
		catch (Exception e) { System.out.println("가맹점삭제실패"+ e); } return false;
	}
	
	///멤버 속 점주 회원번호찾기
	public int ordernumber(int mnum) {
		try {
			String sql ="select * from franchisee where ordernum=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, mnum);
			rs=ps.executeQuery();
			if(rs.next()) {
				return mnum;
			}
			
		}catch(Exception e) {}
		return 0;
	}
	
	// 지점번호 뽑아오기
		public int getfnum(int mnum) {
			try {
				String sql ="select * from franchisee where ordernum=?";
				ps=con.prepareStatement(sql);
				ps.setInt(1, mnum);
				rs=ps.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}
				
			}catch(Exception e) {}
			return 0;
		}
	
	// 점주이름 출력 메소드 
		public String getfname( int fnum ) {
			String sql = "select fname from franchisee where fnum = "+fnum;
			try { ps=con.prepareStatement(sql); rs=ps.executeQuery(); 
				if(rs.next() ) return rs.getString( 1 ); 
			}
			catch (Exception e) {} return null;
		}
		
	// 점주이름으로 지점번호 출력
		public int getfnumfromname( String keyword) {
			String sql = "select fnum from franchisee where fname = '"+keyword+"'";
			try { ps=con.prepareStatement(sql); rs=ps.executeQuery(); 
				if(rs.next() ) return rs.getInt( 1 ); 
			}
			catch (Exception e) {} return 0;
		}
		
	public boolean opertime(int fnum, String oper) {
		System.out.println(fnum);
		try {
		String sql = "select otime from opertime where fnum="+fnum;
		String sql2 = null;
		ps=con.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next()) {
			System.out.println("rs.getInt(1)"+rs.getInt(1));
			if(rs.getInt(1)==1) {
				sql2 = "update opertime set otime=2 where fnum="+fnum;
				ps=con.prepareStatement(sql2);
				ps.executeUpdate();
				return true;
			}
			else if(rs.getInt(1)==2) {
				sql2 = "update opertime set otime=1 where fnum="+fnum;
				ps=con.prepareStatement(sql2);
				ps.executeUpdate();
				return true;
			}
		}
		}catch(Exception e) {System.out.println(e);}
		return false;
	}
	
	public int getotime(int fnum) {
		System.out.println(fnum);
		try {
			String sql = "select otime from opertime where fnum="+fnum;
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}
		catch(Exception e) {System.out.println(e);}
		return 0;
	}
		
		
}
	

