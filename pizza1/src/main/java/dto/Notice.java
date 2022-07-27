package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.FranchiseeDao;
import dao.MemberDao;


public class Notice {
	private int nnum;  
	private String ntitle; 
	private String ncontent;
	private int fnum;  
	private int mnum;
	private String ndate;
	private String fname;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	public Notice(int nnum, String ntitle, String ncontent, int fnum, int mnum, String ndate, String fname) {
		super();
		this.nnum = nnum;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.fnum = fnum;
		this.mnum = mnum;
		
if( ndate != null ) { 
			
			DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 날짜 형식 변환 설정 
			String today = dateformat.format( LocalDate.now() ) ; // 오늘날짜를 문자열 변환
			String boardday = ndate.split(" ")[0];	// 날짜만 
			String boardtime = ndate.split(" ")[1]; // 시간만 
								// db에 저장된 게시물 등록날짜의 날짜 시간 중에 split 분리후 앞에 있는 날짜만 가져오기 
			// 현재날짜와 게시물등록날짜와 동일하면 
			if( today.equals(boardday) ) { this.ndate = boardtime;}
			// 동일하지 않으면 
			else { this.ndate = boardday; }
			
		}else { this.ndate = ndate; }
		
		if(fnum != 0) {
			
			this.fname = FranchiseeDao.getfranchiseeDao().getfname(fnum);
		}else {
			this.fname = "관리자";
		}

		
		
		
	}
	public int getNnum() {
		return nnum;
	}
	public void setNnum(int nnum) {
		this.nnum = nnum;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Override
	public String toString() {
		return "Notice [nnum=" + nnum + ", ntitle=" + ntitle + ", ncontent=" + ncontent + ", fnum=" + fnum + ", mnum="
				+ mnum + ", ndate=" + ndate + ", fname=" + fname + "]";
	}
	
	
	



	
	
	

	
}
