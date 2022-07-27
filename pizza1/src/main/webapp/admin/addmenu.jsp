<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 사용자정의 css --> <link href="/pizza1/CSS/adminevent.css" rel="stylesheet"> 	
<!-- 부트스트랩 css cdn -->  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>

	<%@include file="dashboard.jsp"%>
	
	<div class="event">
		<div class="row">
			<form id="addform">
				<div>
					<a href="menulist.jsp"><button class="d-flex justify-content-end listbtn">목록보기</button></a>
				</div>
				<div>
					<input type="text" class="menuname" id="menuname" name="menuname" placeholder="메뉴명"> 
				</div>
				<div>
					<textarea rows="10" cols="40" id="menucontent" name="menucontent" placeholder="설명"></textarea>
				</div>
				<div>
					<input type="text" id="menuprice" name="menuprice" placeholder="가격"> 
				</div>
				<div>
					카테고리: <button onclick="categorybtn()" type="button" >추가</button> 
				</div>
					<div  id="categoryinput">
					</div>
				<div>
					<div id="categorybox"> </div>
				</div>
				<div>
					<input type="file" id="menuimg" name="menuimg">
				</div>
				<div>
					<button type="button" onclick="menuadd()">메뉴 등록</button>
					<input type="reset" value="초기화">
				</div>
				<div>
					<img id="preview" width="100%">
				</div>
			</form>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="/pizza1/js/menu.js" type="text/javascript"></script>
		
	
</body>
</html>