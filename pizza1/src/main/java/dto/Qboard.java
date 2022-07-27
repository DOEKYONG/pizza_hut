package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.MemberDao;

public class Qboard {
	
	private int qnum;
	private String qtitle;
	private String qcontent;
	private int mnum;
	private String qstate;
	private String qdate;
	private String mid;
	
	public Qboard() {
		// TODO Auto-generated constructor stub
	}

	public Qboard(int qnum, String qtitle, String qcontent, int mnum, String qstate, String qdate, String mid) {
		super();
		this.qnum = qnum;
		this.qtitle = qtitle;
		this.qcontent = qcontent;
		this.mnum = mnum;
		this.qstate = qstate;
if( qdate != null ) { 
			
			DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 날짜 형식 변환 설정 
			String today = dateformat.format( LocalDate.now() ) ; // 오늘날짜를 문자열 변환
			String boardday = qdate.split(" ")[0];	// 날짜만 
			String boardtime = qdate.split(" ")[1]; // 시간만 
								// db에 저장된 게시물 등록날짜의 날짜 시간 중에 split 분리후 앞에 있는 날짜만 가져오기 
			// 현재날짜와 게시물등록날짜와 동일하면 
			if( today.equals(boardday) ) { this.qdate = boardtime;}
			// 동일하지 않으면 
			else { this.qdate = boardday; }
			
		}else { this.qdate = qdate; }
		
		// mno를 가지고 mid출력
		this.mid = MemberDao.getmemberDao().getmid(mnum);
		
	}

	public int getQnum() {
		return qnum;
	}

	public void setQnum(int qnum) {
		this.qnum = qnum;
	}

	public String getQtitle() {
		return qtitle;
	}

	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}

	public String getQcontent() {
		return qcontent;
	}

	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getQstate() {
		return qstate;
	}

	public void setQstate(String qstate) {
		this.qstate = qstate;
	}

	public String getQdate() {
		return qdate;
	}

	public void setQdate(String qdate) {
		this.qdate = qdate;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Qboard [qnum=" + qnum + ", qtitle=" + qtitle + ", qcontent=" + qcontent + ", mnum=" + mnum + ", qstate="
				+ qstate + ", qdate=" + qdate + ", mid=" + mid + "]";
	}
	
	
	

}
