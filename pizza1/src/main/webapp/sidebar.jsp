<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	<link rel="stylesheet" type="text/css" href="/pizza1/CSS/style.css">
</head>
<body>
	<!-- ------------------------ 우측 사이드 바-------------------- -->
			
			<%
		String logining 
			= (String)session.getAttribute("login"); ///로그인세션 불러오기
	%>
			
			<div class ="sidebar"> <!-- 사이드바 전체박스 -->	
				<div class ="sidebar_item" >
				<% if( logining == null ){ %>
				<a href="/pizza1/member/login.jsp">내정보 <div><i class="fas fa-user fa-lg"></i></div></a>
				<%} %>
				<% if( logining  != null ){ %>
				<a href="/pizza1/info/update.jsp">내정보 <div><i class="fas fa-user fa-lg"></i></div></a>
				<%} %>
				</div> 
				<div class ="sidebar_item" >
				<% if( logining == null ){ %>
				<a href="/pizza1/member/login.jsp">장바구니 <div><i class="fas fa-shopping-cart fa-lg"></i></div></a>
				<%} %>
				<% if( logining  != null ){ %>
				<a href="/pizza1/menu/cart.jsp">장바구니 <div><i class="fas fa-shopping-cart fa-lg"></i></div></a>
				<%} %>
				</div>
				<div class ="sidebar_item" >
				<% if( logining == null ){ %>
				<a href="/pizza1/member/login.jsp">주문내역 <div><i class="fas fa-envelope fa-lg"></i></div></a>
				<%} %>
				<% if( logining  != null ){ %>
				<a href="/pizza1/info/myorder.jsp">주문내역<div><i class="fas fa-envelope fa-lg"></i></div></a>
				<%} %>
				</div>
			</div> <!-- 사이드바 전체박스 end -->	


</body>
</html>