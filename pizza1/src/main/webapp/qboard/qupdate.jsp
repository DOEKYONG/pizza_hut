<%@page import="dao.QboardDao"%>
<%@page import="dto.Qboard"%>
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
int qnum = Integer.parseInt(request.getParameter("qnum"));
Qboard qboard = QboardDao.getQboardDao().getqboard(qnum);



%>
<div class="container1">
		<h1 style="text-align: center; margin-top:20px;">공지사항 수정</h1>
		
		
		<div class="noticewrite_wrap">
		<form  id ="form_n" action="../qboard/qupdate?qnum=<%=qboard.getQnum() %>" method="post" >
			<div class="title_area">
				<div class="notice_lbl"><span>제목</span></div> <input type="text" name ="qtitle" id="ntitle" value="<%=qboard.getQtitle() %>"> 
				
				
			</div>
			<div class="content_area">
			<div class="notice_lbl"><span>내용</span></div> <textarea style="resize: none;"  name="qcontent" id="ncontent" ><%=qboard.getQcontent() %></textarea>
			</div>
			<div class="btn_area1">
			
			<button type="button" id="sub"onclick="uwritecheck()" >수정</button>
			<a href="qview.jsp"><input type="button" value="취소"></a>
			
			</div>
			
			</form>
		</div>
			
		
	
	</div>




<%@include file ="../footer.jsp" %>
<script type="text/javascript" src="/pizza1/js/noticewrite.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
</body>
</html>