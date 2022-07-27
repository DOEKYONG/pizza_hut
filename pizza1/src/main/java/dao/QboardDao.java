package dao;

import java.util.ArrayList;

import dto.Qboard;
import dto.Reply;

public class QboardDao extends Dao {

	public static QboardDao qboardDao = new QboardDao();
	
	public static QboardDao getQboardDao() {return qboardDao;}
	
	public QboardDao() {
		super();
	}
	
	// 문의 작성
	public boolean qwrite(String qtitle, String qcontent, int mnum) {
		String sql  = "insert into qboard(qtitle,qcontent,mnum)values(?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, qtitle);
			ps.setString(2, qcontent);
			ps.setInt(3, mnum);
			
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {System.out.println("문의작성오류" + e);}
		return false;
	}
	
	// 문의 리스트 출력 메소드
	public ArrayList<Qboard> getqboardlist(int startrow,int listsize,String key , String keyword) {
		ArrayList<Qboard> qboardlist = new ArrayList<Qboard>();
		String sql = null;
		
		if(key.equals("mid")) { key = "mnum"; keyword = MemberDao.getmemberDao().getmnum(keyword)+"";}
		if( key.equals("") && keyword.equals("") ) { //검색이 없을경우 
			sql = "select * from qboard order by qnum desc limit "+startrow+","+listsize; /* limit 시작 인덱스 , 표시 개수 */
		}else {
			sql ="select * from qboard where "+key+" like '%"+keyword+"%' order by qnum desc limit "+startrow+","+listsize;
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Qboard qboard = new Qboard(
						rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getInt(4),rs.getString(5),rs.getString(6),
						null);
				qboardlist.add(qboard);
			}
			return qboardlist;
			
		} catch (Exception e) {System.out.println("문의출력오류"+e);}
		return null;
	}
	
	// 게시물 전체 개수출력 메소드
	public int gettotalrow(String key, String keyword) {
		String sql = null;
		if( key.equals("mid") ) { key = "mnum"; keyword = MemberDao.getmemberDao().getmnum(keyword)+""; }
		System.out.println("keyword : " +keyword);
		System.out.println("key : " +key);
		if(key.equals("")  && keyword.equals("")) {
			sql = "select count(*) from qboard";
		}else {
			sql = "select count(*) from qboard where "+key+" like '%"+keyword+"%'";
		}
		try {ps = con.prepareStatement(sql); rs = ps.executeQuery(); if(rs.next()) return rs.getInt(1);}
		catch(Exception e) {System.out.println("문의전체개수 출력 오류 " + e);} return 0;
	}
	
	// 문의 개별 출력 메소드
	public Qboard getqboard(int qnum) {
		String sql = "select*from qboard where qnum="+qnum;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Qboard qboard = new Qboard(rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getInt(4),rs.getString(5),rs.getString(6),
						null);
				return qboard;
			}
		} catch (Exception e) {System.out.println("문의 개별 출력 오류" +e);}
		return null;
	}
	// 문의 삭제 메소드
	public boolean qboarddelete( int qnum) {
		String sql = "delete from qboard where qnum="+qnum;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("문의삭제 오류" +e);}
		return false;
	}
	// 문의 수정 메소드
	public boolean qboardupdate(Qboard qboard) {
		String sql = "update qboard set qtitle=? , qcontent=? where qnum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, qboard.getQtitle());
			ps.setString(2, qboard.getQcontent());
			ps.setInt(3, qboard.getQnum());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {System.out.println("문의수정 오류" + e);}
		return false;
	}
	
	// 답글 작성 메소드
	public boolean rwrite(Reply reply ) {
		String sql = "insert into reply(rcontent,rindex,qnum,mnum)values(?,?,?,?)";
		
		
		// 답글이 달리면 qboard 에 있는 qstate의 값을 변경 sql 2개사용??
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setInt(2, reply.getRindex());
			ps.setInt(3, reply.getQnum());
			ps.setInt(4, reply.getMnum());
			ps.executeUpdate(); 
			
			String sql2 = "update qboard set qstate= '답변완료' where qnum="+reply.getQnum();
			Qboard qboard = QboardDao.getQboardDao().getqboard(reply.getQnum());
			ps= con.prepareStatement(sql2);
			ps.executeUpdate();
			return true;
			
			
		} catch (Exception e) {System.out.println("댓글작성 오류"+ e);}
		
		return false;
	}
		
		// 답글 삭제 메소드 		[ 인수 : 삭제할 댓글 번호 ] 
			public boolean replydelete( int rnum,int qnum) { 
				String sql ="delete from reply "
						+ "where rnum = "+rnum;
				
				try { 
					ps = con.prepareStatement(sql); 
					ps.executeUpdate();
					String sql2 = "update qboard set qstate= '답변대기중' where qnum="+qnum;
					ps=con.prepareStatement(sql2);
					ps.executeUpdate();
					return true;
				}
				catch( Exception e ) {} return false;
			}
		
		// 8. 댓글 출력 메소드 		[ 인수 : 현재 게시물번호 ]
			public ArrayList<Reply> replylist( int qnum ) { 
				ArrayList<Reply> replylist = new ArrayList<Reply>();
				String sql = "select * from reply where qnum = "+qnum+" and rindex = 0"; // rindex = 0  : 댓글만 출력 [ 대댓글 제외 ] 
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery(); 
					while( rs.next() ) { 
						Reply reply = new Reply( 
								rs.getInt(1) , rs.getString(2) , 
								rs.getString(3) , rs.getInt(4) , 
								rs.getInt(5), rs.getInt(6), null);
						replylist.add(reply);
					}
					return replylist;
				}catch (Exception e) { System.out.println( "댓글출력오류" + e); } return null; 
			}
			
			// 답글 개별 출력 메소드
			public Reply getqreply(int rnum) {
				String sql = "select*from reply where rnum="+rnum;
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					if(rs.next()) {
						Reply replys = new Reply(rs.getInt(1),rs.getString(2),rs.getString(3),
								rs.getInt(4),rs.getInt(5),rs.getInt(6),
								null);
						return replys;
					}
				} catch (Exception e) {System.out.println("문의 개별 출력 오류" +e);}
				return null;
			}
			
			
			
			// 9. 댓글 수정 메소드 		[ 인수 : 수정할 댓글 번호 ]

			public boolean replyupdate(int rnum, String rcontent) {
						try {
							String sql = "update reply set rcontent=? where rnum=?";
							ps = con.prepareStatement(sql);
							ps.setString( 1 , rcontent );
							ps.setInt( 2 , rnum );
							ps.executeUpdate();
							return true;
						}catch(Exception e) {}
						
						return false; }
			
			// qnum으로 rnum 가져오기
			public int getrunm(int qnum) {
				String sql = "select rnum from reply where qnum="+qnum;
				try {
					ps = con.prepareStatement(sql); rs=ps.executeQuery();
					if(rs.next()) return rs.getInt(1);
				} catch (Exception e) {System.out.println("번호오류"+e);}return 0;
			}
			
			public int getrindex(int rnum) {
				String sql = "select rindex from reply where rnum="+rnum;
				try {
					ps = con.prepareStatement(sql); rs=ps.executeQuery();
					if(rs.next()) return rs.getInt(1);
				} catch (Exception e) {System.out.println("번호오류"+e);}return 0;
			}
	
			public int getrunm1(int qnum) {
				String sql = "select rindex from reply where qnum="+qnum;
				try {
					ps = con.prepareStatement(sql); rs=ps.executeQuery();
					if(rs.next()) return rs.getInt(1);
				} catch (Exception e) {System.out.println("번호오류"+e);}return 0;
			}
			
	
}
