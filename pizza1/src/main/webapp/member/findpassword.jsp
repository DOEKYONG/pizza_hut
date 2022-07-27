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

<%@include file="../header.jsp"%>

<h1 class="find_title">비밀번호 찾기</h1>
	<h4 class="find_content">아래 정보를 입력해주세요.</h4>
	<div class="findpw_wrap"> <!-- 로그인 레이아웃용 div -->
	<form action="../findpassword" method="post">		
	<div class="findpw_form">
		<div class="findpw_id">
			<span >아이디</span> <input id="fid" name="fid" type="text">
		</div>
		<div class="findpw_phone">
			<span>전화번호</span> <input id="fphone" name="fphone" type="text">
		</div>
		
		
		<div class="findpw_btn_area">
		<input type="submit" id  ="btnfindpassword" value="비밀번호 찾기">
	</div>
	</div>
	</form>
	</div> <!-- 로그인 레이아웃용 div end -->




<%@include file="../footer.jsp"%>

</body>
</html>