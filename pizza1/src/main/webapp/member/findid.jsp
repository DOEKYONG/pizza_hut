<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../CSS/style2.css">
</head>
<body>

	<%@include file="../header.jsp"%>
	
	<h1 class="find_title">아이디 찾기</h1>
	<h4  class="find_content">아래 정보를 입력해주세요.</h4>
	<div class="findid_wrap"> 
	<form action="../findid" method="post" accept-charset="utf-8">	
	<div class="findid_form">
		<div class="findid_name">
			<span >이름</span> <input id="fname" name="fname" type="text">
		</div>
		<div class="findid_email">
			<span>이메일</span> <input id="femail" name="femail" type="text">
		</div>
		
		
		<div class="findid_btn_area">
		<input type="submit" id  ="btnfindid" value="아이디 찾기">
	</div>
	</div>
	</form>
	</div> 
	
	<%@include file="../footer.jsp"%>
	

</body>
</html>