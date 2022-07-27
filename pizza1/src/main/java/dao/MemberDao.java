package dao;

import java.util.ArrayList;

import dto.AlertDto;
import dto.Member;

public class MemberDao extends Dao{

	
	public static MemberDao memberDao = new MemberDao();
	
	public static MemberDao getmemberDao() { return memberDao; } 
	
	public MemberDao() {
		super(); // 부모클래스 생성자 호출 
	}
	
	public boolean signup(Member member) {
		try {
			String sql = "insert into member(mid,mpassword,mname,memail,mphone,mbirth,mdate)values(?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMname());
			ps.setString(4, member.getMemail());
			ps.setString(5, member.getMphone());
			ps.setString(6, member.getMbirth());
			ps.setString(7, member.getMdate());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("sql오류" + e);
		}
		return false;
	}
	
	// 로그인 메소드 
		public int login( String mid , String mpassowrd ) {
			 String sql = "select * from member where mid = '"+mid+"' and mpassword = '"+mpassowrd+"'";
			
			try {
				ps = con.prepareStatement(sql); 
				
				rs = ps.executeQuery();
				if( rs.next() ) return 1;
				return 2; 
			}catch (Exception e) {} return 3;
		}
	
		//아이디찾기메소드
		public String findid(String mname, String memail) {
			try {
			String sql = "select * from member where mname=? and memail=?";
			
			ps= con.prepareStatement(sql);
			
			ps.setString(1, mname);
			ps.setString(2, memail);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return rs.getString(2);
			}
			
			}catch(Exception e) {System.out.println("아이디찾기: "+e);}
			return null;}
		
		public String findpassword(String mid, String mphone) {
			try {
			String sql = "select * from member where mid=? and mphone=?";
			
			ps= con.prepareStatement(sql);
			
			ps.setString(1, mid);
			ps.setString(2, mphone);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return rs.getString(3);
			}
			
			}catch(Exception e) {System.out.println("비밀번호찾기: "+e);}
			return null;}
		
		public boolean idcheck( String mid ) {
			String sql = "select * from member where mid = '"+mid+"'";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();	
				// 동일한 아이디가 존재하면 
				if( rs.next() ) { return true; } 
			}catch (Exception e) { System.out.println( e );} 
			// 동일한 아디디가 존재하지 않으면
			return false;
		}
		
		// 이메일 중복체크 메소드 
			public boolean emailcheck( String email ) {
				String sql = "select * from member where memail = '"+email+"'";
				try {  ps = con.prepareStatement(sql); rs= ps.executeQuery(); if( rs.next() ) return true;
				}catch (Exception e) {} return false;
			} // 테스트
			
			
			public boolean phonecheck( String mphone ) {
				String sql = "select * from member where mphone = '"+mphone+"'";
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();	
					// 동일한 번호가 존재하면 
					if( rs.next() ) { return true; } 
				}catch (Exception e) { System.out.println( e );} 
				// 동일한 번호 존재하지 않으면
				return false;
			}
			
			// 개별 회원정보 출력
			public Member getmember(String mid) {
				
				String sql ="select*from member where mid = '"+mid+"'";
				try {
					ps =con.prepareStatement(sql);
					rs = ps.executeQuery();
					if(rs.next()) {
						Member member = new Member (
								rs.getInt(1),rs.getString(2),null,
								rs.getString(4),rs.getString(5),
								rs.getString(6),rs.getString(7),
								rs.getString(8)
								);
						return member; // 검색된 객체 반환
					}
				}catch(Exception e) {} return null;
			}
			
			// 패스워드 확인 메소드 
			public boolean passwordcheck( String mid , String mpassword ) {
				
				String sql = "select * from member where mid = '"+mid+"' and mpassword = '"+mpassword+"'";
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery(); if( rs.next() ) return true;
				}catch (Exception e) { System.out.println( e );} return false;
			}
			
			// 회원 삭제 메소드 
			public boolean delete( String mid ) {
				String sql ="delete from member where mid = '"+mid+"'";
				try { ps=con.prepareStatement(sql); ps.executeUpdate(); return true; }
				catch (Exception e) { System.out.println(e); } return false;
			}
			
			// 회원수정 메소드
			public boolean update( Member member) {
				
				try {
					if( member.getMpassword() == null ) { // 패스워드 변경이 없을때 
						String sql = "update member set mname=?, memail=?, mphone=? where mnum=?";
							ps = con.prepareStatement(sql);
							ps.setString( 1 , member.getMname() );
							ps.setString( 2 , member.getMemail() );
							ps.setString( 3 , member.getMphone() );
							ps.setInt( 4, member.getMnum() );
					}else {	// 패스워드가 변경이 있을때 
						String sql = "update member set mname=?, mpassword=?, memail=?, mphone=? where mnum=?";
							ps = con.prepareStatement(sql);
							
							ps.setString( 1 , member.getMname() );
							ps.setString( 2 , member.getMpassword() );
							ps.setString( 3 , member.getMemail() );
							ps.setString( 4 , member.getMphone() );
							ps.setInt( 5, member.getMnum() );
					}
					ps.executeUpdate(); return true;
				} catch (Exception e) {} return false;
			}
			
			// 회원번호 출력 메소드
			public int getmnum(String mid) {
				String sql = "select mnum from member where mid = '"+mid+"'";
				
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					if(rs.next()) {
						return rs.getInt(1);
					}
				} catch (Exception e) {}
				return 0;
				}
			
			// 회원id 출력 메소드 
			public String getmid( int mnum ) {
				String sql = "select mid from member where mnum = "+mnum;
				try { ps=con.prepareStatement(sql); rs=ps.executeQuery(); 
					if(rs.next() ) return rs.getString( 1 ); 
				}
				catch (Exception e) {} return null;
			}
			
			// 회원 주문내역 출력
			public ArrayList<AlertDto> getorderlist(int mnum) {
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
						+ "where a.mnum = "+mnum+" order by 1 desc";
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
						//System.out.println("getorderlist" + orderlist);
					}
					return orderlist;
				} catch(Exception e) {
					System.out.println("아아아아아아아앙" + e);
				}return null;
			}
			
			
	
}
