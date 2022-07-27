<%@page import="dao.NoticeDao"%>
<%@page import="dto.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.FranchiseeDao"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../CSS/style2.css">
</head>
<body>



<%@include file ="../header.jsp" %>


<% 
	String mid = (String)session.getAttribute("login");
	int nnum = Integer.parseInt( request.getParameter("nnum") );
	Notice notices = NoticeDao.getNoticeDao().getnotice(nnum);
	int mnum = MemberDao.getmemberDao().getmnum(mid);
	int fnum = FranchiseeDao.getfranchiseeDao().getfnum(mnum);
	String id = MemberDao.getmemberDao().getmid(mnum);
	
%>

	<div class ="container1 nv">
	
	



		
			
			
			
			
	
	<div class="ntittle_wrap">
	
	<div class = "noticeview_box">
	
	<div class="nview_header">
	<div class="header_first"><span id="header_ntitle"> <%=notices.getNtitle() %></span> </div>
	<div class="header_second">
	<%if(notices.getFnum()==0) { %>
	<span class="header_name"> 관리자</span>
	<%} else {%> 
	<span  class="header_name"> <%=notices.getFname()%> | </span> 
	<% }%>
	<span>&nbsp;<%=notices.getNdate()%></span> 	
	</div>
	</div>
	
	<div class="notice_content">
	 <%=notices.getNcontent()%>
	</div>
	</div>
		</div>
		
		<div class="nvbtn_area">
				<button class="btn_golist" onclick = "location.href = 'noticelist.jsp' ">목록보기</button>
		
<% if( mid != null && mid.equals("admin")|| fnum !=0 && (notices.getFnum() == FranchiseeDao.getfranchiseeDao().getfnum(mnum))){%>
		
<a href="noticeupdate.jsp?nnum=<%=notices.getNnum()%>"> <button class="btn_golist">수정</button> </a>
<a href="noticedelete?nnum=<%=notices.getNnum()%>"><button class="btn_golist">삭제</button> </a>
<% }%>
		
		</div>

	
	</div>

	
<%@include file ="../footer.jsp" %>
</body>
</html>