package dao;

import java.util.ArrayList;

import dto.Notice;

public class NoticeDao extends Dao {
	
	public static NoticeDao noticeDao = new NoticeDao();
	
	public static NoticeDao getNoticeDao() {return noticeDao;}
	
	public NoticeDao()  {
		super();
	}
	
	// 공지 작성 메소드
	public boolean nwrite(String ntitle, String ncontent,int fnum) {
		
		String sql = "insert into notice1(ntitle,ncontent,fnum)values(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ntitle);
			ps.setString(2, ncontent);
			ps.setInt(3, fnum);
			
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {System.out.println("공지쓰기 오류" +e);}
	
		return false;
	}
	
	// 공지 리스트 출력 메소드
	public ArrayList<Notice> getnoticelist(int startrow,int listsize,String key , String keyword){
		ArrayList<Notice> noticelist = new ArrayList<Notice>();
		
		String sql = null;
		if(key.equals("fname")) {key ="fnum"; keyword =FranchiseeDao.getfranchiseeDao().getfnumfromname(keyword)+"";}
		if(key.equals("")  && keyword.equals("")) {
			 sql = "select*from notice1 order by nno desc limit "+startrow+","+listsize;
		} else {
			sql ="select * from notice1 where "+key+" like '%"+keyword+"%' "
					+ "order by nno desc limit "+startrow+","+listsize;
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Notice notice = new Notice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 0, rs.getString(5), null);
				noticelist.add(notice);
			}return noticelist;
		} catch (Exception e) {System.out.println("공지사항 출력오류" +e);}return null;
	}
	
	// 게시물 전체 개수출력 메소드
	public int gettotalrow(String key, String keyword) {
		
		String sql = null;
		if(key.equals("fname")) {key ="fnum"; keyword =FranchiseeDao.getfranchiseeDao().getfnumfromname(keyword)+"";}
		System.out.println("keyword : " +keyword);
		System.out.println("key : " +key);
		if(key.equals("")  && keyword.equals("")) {
			sql = "select count(*) from notice1";
		}else {
			sql = "select count(*) from notice1 where "+key+" like '%"+keyword+"%'";
		}
		try {ps = con.prepareStatement(sql); rs = ps.executeQuery(); if(rs.next()) return rs.getInt(1);}
		catch(Exception e) {System.out.println("전체게시물개수 출력 오류 " + e);} return 0;
	}
	
	// 공지 개별 출력 메소드
	public Notice getnotice(int nnum) {
		String sql = "select * from notice1 where nno="+nnum;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Notice notice = new Notice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 0, rs.getString(5), null
						);
				return notice;
			}
			
		} catch (Exception e) {System.out.println("공지 개별 출력 오류" +e);} return null;
	}
	// 공지 삭제 메소드
	public boolean noticedelete(int nnum) {
		String sql = "delete from notice1 where nno="+nnum;
		try {
			ps = con.prepareStatement(sql); ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println("공지 삭제 오류"+ e);}
		
		return false;
	}
	
	// 공지 수정 메소드
	public boolean noticeupdate(Notice notice) {
		String sql = "update notice1 set ntitle=?, ncontent=? where nno=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, notice.getNtitle());
			ps.setString(2, notice.getNcontent());
			ps.setInt(3, notice.getNnum());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("공지사항 수정 오류" +e);}
		
		return false;
	}
	

}
