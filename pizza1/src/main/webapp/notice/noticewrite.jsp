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

<div class="container1">
		<h1 style="text-align: center; margin-top:20px;">공지사항 작성</h1>
		
		
		<div class="noticewrite_wrap">
		<form  id ="form_n" action="../nwrite" method="post" >
			<div class="title_area">
				<div class="notice_lbl"><span>제목</span></div> <input type="text" name ="ntitle" id="ntitle"> 
			</div>
			<div class="content_area">
			<div class="notice_lbl"><span>내용</span></div> <textarea style="resize: none;"  name="ncontent" id="ncontent" ></textarea>
			</div>
			<div class="btn_area1">
			
			<button type="button" id="sub"onclick="writecheck()" >등록</button>
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