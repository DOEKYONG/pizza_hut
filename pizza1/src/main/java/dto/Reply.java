package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.MemberDao;

public class Reply {
	
	private int rnum;
	private String rcontent;
	private String rdate;
	private int rindex;
	private int qnum;
	private int mnum;
	private String mid;
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public Reply(int rnum, String rcontent, String rdate, int rindex, int qnum, int mnum, String mid) {
		super();
		this.rnum = rnum;
		this.rcontent = rcontent;
if( rdate != null ) { 
			
			DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 날짜 형식 변환 설정 
			String today = dateformat.format( LocalDate.now() ) ; // 오늘날짜를 문자열 변환
			String boardday = rdate.split(" ")[0];	// 날짜만 
			String boardtime = rdate.split(" ")[1]; // 시간만 
								// db에 저장된 게시물 등록날짜의 날짜 시간 중에 split 분리후 앞에 있는 날짜만 가져오기 
			// 현재날짜와 게시물등록날짜와 동일하면 
			if( today.equals(boardday) ) { this.rdate = boardtime;}
			// 동일하지 않으면 
			else { this.rdate = boardday; }
			
		}else { this.rdate = rdate; }
		this.rindex = rindex;
		this.qnum = qnum;
		this.mnum = mnum;
		this.mid = MemberDao.getmemberDao().getmid(mnum);
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getRindex() {
		return rindex;
	}

	public void setRindex(int rindex) {
		this.rindex = rindex;
	}

	public int getQnum() {
		return qnum;
	}

	public void setQnum(int qnum) {
		this.qnum = qnum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Reply [rnum=" + rnum + ", rcontent=" + rcontent + ", rdate=" + rdate + ", rindex=" + rindex + ", qnum="
				+ qnum + ", mnum=" + mnum + ", mid=" + mid + "]";
	}

	
	
	
	

}
