
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Reply"%>
<%@page import="dao.MemberDao"%>
<%@page import="dto.Qboard"%>
<%@page import="dao.QboardDao"%>
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
	int qnum = Integer.parseInt( request.getParameter("qnum") );
	int rnum = QboardDao.getQboardDao().getrunm(qnum);
	Qboard qboards = QboardDao.getQboardDao().getqboard(qnum);
	int mnum = MemberDao.getmemberDao().getmnum(mid);
	String id = MemberDao.getmemberDao().getmid(mnum);
	Reply replys = QboardDao.getQboardDao().getqreply(rnum);
	int rindex = QboardDao.getQboardDao().getrunm1(qnum);
	
	
%>


<div class ="container1 nv">
<h1>문의 상세</h1>
	<div class="ntittle_wrap">
		<div class = "qview_box">
			<div class="nview_header">
			<div class="header_first"><span id="header_ntitle"> <%=qboards.getQtitle()%></span> </div>
			<div class="header_second"><span  class="header_name"> <%=qboards.getMid()%> | </span> <span>&nbsp;<%=qboards.getQdate()%></span></div>
			</div>
			
			<div class="notice_content1">
			 <%=qboards.getQcontent()%>
			</div>
			<%if(rindex ==0 && mid !=null && mid.equals("admin")) { %>
			<button class="btn replybtn" onclick="replyview()">답변작성</button>
			<%}%>
			<!-- 답글출력창 -->
			
		
			
			<%if(rindex == 0) {%>
			
			<%}else{ %>
			<div class="notice_content2">
			 	<%=replys.getRcontent() %>
			 	<div class="nview_header">
			<div class="header_second"><span  class="header_name"> 답변자 : 관리자 | </span> <span>&nbsp;답변일 : <%=qboards.getQdate()%></span></div>
			</div>
			</div>
			<%if(mid !=null && mid.equals("admin")){  %>
			<button class="btn replybtn" onclick="reupdateview('<%=replys.getRcontent()%>')">수정</button>
			<%} %>
			 	<%} %>
			
			
			<!-- 답글 입력창 -->
		<div class = "qview_box2" style="display: none">
		<textarea class="notice_content3" style="resize: none;"  name="rcontent" id="rcontent" ></textarea>
		<button id="rewrite" onclick="rewrite(<%=qnum%>);">등록</button>
		<button id="reupdate" onclick="reupdate(<%=rnum%>)">수정하기</button>
		<button id="redelete" onclick="redelete(<%=rnum%>,<%=qnum%>)">삭제하기</button>
		</div>
		</div>
		
		
	</div>
<%if (qboards.getMnum() == MemberDao.getmemberDao().getmnum(mid)) { %>
<div class="nvbtn_area">
<a href="qupdate.jsp?qnum=<%=qboards.getQnum()%>"> <button class="btn_golist">수정</button> </a>
<a href="qdelete?qnum=<%=qboards.getQnum()%>"><button class="btn_golist">삭제</button> </a>

<%} %>
<a href="qlist.jsp"><button class="btn_golist">목록보기</button></a>
</div>

	
</div>
<%@include file ="../footer.jsp" %>
 <script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../js/qboard.js"></script>

</body>
</html>