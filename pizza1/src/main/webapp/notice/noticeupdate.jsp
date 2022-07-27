<%@page import="dao.NoticeDao"%>
<%@page import="dto.Notice"%>
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
int nnum = Integer.parseInt(request.getParameter("nnum"));
Notice notice = NoticeDao.getNoticeDao().getnotice(nnum);



%>
<div class="container1">
		<h1 style="text-align: center; margin-top:20px;">공지사항 수정</h1>
		
		
		<div class="noticewrite_wrap">
		<form  id ="form_n" action="../notice/noticeupdate?nnum=<%=notice.getNnum() %>" method="post" >
			<div class="title_area">
				<div class="notice_lbl"><span>제목</span></div> <input type="text" name ="ntitle" id="ntitle" value="<%=notice.getNtitle() %>"> 
				
				
			</div>
			<div class="content_area">
			<div class="notice_lbl"><span>내용</span></div> <textarea style="resize: none;"  name="ncontent" id="ncontent" ><%=notice.getNcontent() %></textarea>
			</div>
			<div class="btn_area1">
			
			<button type="button" id="sub"onclick="writecheck()" >수정</button>
			<a href="noticelist.jsp"><input type="button" value="취소"></a>
			
			</div>
			
			</form>
		</div>
			
		
	
	</div>




<%@include file ="../footer.jsp" %>
<script type="text/javascript" src="/pizza1/js/noticewrite.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>



</body>
</html>