<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 부트스트랩 css cdn -->  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<!-- 사용자정의 css --> <link href="/pizza1/CSS/main.css" rel="stylesheet"> 	
	<!-- 사용자정의 css --> <link href="/pizza1/CSS/admin.css" rel="stylesheet"> 	
	<!-- 폰트어썸[ 아이콘 ]  --><link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">

</head>
<body>

	<%@include file="dashboard.jsp"%>
	<div class="container">
	<form action="../event/addevent" method="post" enctype="multipart/form-data">
		<a href="/pizza1/admin/eventlist.jsp"><button type="button">뒤로가기</button></a><br>
		제목: <input type="text" name="etitle"><br>
		쿠폰번호: <input type="text" name="ecoupon"><br>
		할인율: <input type="text" name ="ediscount"><br>
		이벤트기간:<input type="date" id="datepicker1" name ="datepicker1"> ~
   		 <input type="date" id="datepicker2" name ="datepicker2"><br>
		배너이미지: <input type="file" name="bannerimg"><br>
		이벤트이미지: <input type="file" name="eventimg"><br>
			<input type="submit" value="등록">
		</form>
	</div>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		<!-- 사용자정의 js --><script src="/pizza1/js/dashboard.js" type="text/javascript"></script>
<script src="../js/event.js" type="text/javascript"></script>
</body>
</html>