<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
</head>
<body>
 
	<%@include file="../header.jsp"%>
		<form action="../event/addevent" method="post" enctype="multipart/form-data">
			<a href="/pizza1/event/eventlist.jsp"><button>뒤로가기</button></a><br>
		제목: <input type="text" name="etitle"><br>
		쿠폰번호: <input type="text" name="ecoupon"><br>
		할인율: <input type="text" name ="ediscount"><br>
		이벤트기간:<input type="text" id="datepicker1" name ="datepicker1"> ~
   		 <input type="text" id="datepicker2" name ="datepicker2"><br>
		배너이미지: <input type="file" name="bannerimg"><br>
		이벤트이미지: <input type="file" name="eventimg"><br>
			<input type="submit" value="등록">
		</form>
	<%@include file="../footer.jsp"%>
	
	
</body>
</html>