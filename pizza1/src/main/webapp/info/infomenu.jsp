<%@page import="dao.FranchiseeDao"%>
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

	<%
		String login 
			= (String)session.getAttribute("login"); // 세션 호출 ( 기본타입 = Odject )
		int result5 = FranchiseeDao.getfranchiseeDao().ordernum(login);
		int findorder = FranchiseeDao.getfranchiseeDao().ordernumber(result5);
			
	%>
	<% if( login.equals("admin") ){ %>
				<div class ="infomenu_wrap">
		<div class="adminmenu">
		<a href="franchiseelist.jsp?key=&keyword="><span>가맹점관리</span></a>
		<a href="adminmoney.jsp"><span>매출</span></a>
		</div>
		
		<div class="infomenu_items">	
			<span><a href="update.jsp">정보수정</a></span>
			<span><a href="myorder.jsp">주문내역</a></span>
			<span><a href="mycoupon.jsp">쿠폰함</a></span>
			<span><a href="delete.jsp">회원탈퇴</a></span>
			</div>
		</div>
		<%} else if( findorder!=0  ){ ///점주메뉴 %>
		<div class ="infomenu_wrap">
		
			<div class="infomenu_items">
			<span><a href="myorder.jsp">주문내역</a></span>
			<span><a href="mycoupon.jsp">쿠폰함</a></span>
			</div>
			</div>
			<!-- 점주일경우<a href="">주문등록</a><a href="">매출</a>  -->
		<%} else if( findorder==0 ){ //일반회원메뉴 %>
		<div class ="infomenu_wrap">
			<div class="infomenu_items">	
			<span><a href="update.jsp">정보수정</a></span>
			<span><a href="myorder.jsp">주문내역</a></span>
			<span><a href="mycoupon.jsp">쿠폰함</a></span>
			<span><a href="delete.jsp">회원탈퇴</a></span>
			</div>
			</div>
		
		<%}%>
		
	
	
</body>
</html>