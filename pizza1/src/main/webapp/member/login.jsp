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
	<h1 class="find_title">LOGIN</h1>
	<h4 class="find_content">주문하려면 로그인이 필요합니다.</h4>
	<div class="login_wrap"> <!-- 로그인 레이아웃용 div -->
	<form action="../login" method="post">		
	<div class="login_form">
		<div class="login_id">
			<span >아이디</span> <input id="lid" name="lid" type="text">
		</div>
		<div class="login_pw">
			<span>비밀번호</span> <input id="lpassword" name="lpassword" type="password">
		</div>
		<div class="findtab">
			<span><a href="findid.jsp">아이디찾기</a></span> <span style="margin-left: 15px;"><a href="findpassword.jsp">비밀번호찾기</a></span>
		</div>
		
		<div class="login_btn_area">
		<input type="submit" id  ="loginbtn" value="LOGIN">
		
	</div>
	</div>
	</form>
	
	
	
	</div> <!-- 로그인 레이아웃용 div end -->
	
	
	
	<%@include file="../footer.jsp"%>

</body>
</html>