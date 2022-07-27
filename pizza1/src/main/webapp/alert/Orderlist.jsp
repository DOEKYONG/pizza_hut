<%@page import="dao.MemberDao"%>
<%@page import="dao.FranchiseeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/pizza1/CSS/menu/alert.css">
</head>
<body>
<% String mid 
= (String)session.getAttribute("login"); ///로그인세션 불러오기


int mnum = (Integer)session.getAttribute("mnum"); ///로그인세션 불러오기
int fnum = (Integer)session.getAttribute("fnum");
	System.out.println("세세세세세세세세션"+fnum);
	System.out.println("세세세세세세세세션"+mnum);
%>
<input type="hidden" value="<%=fnum%>" id ="fnum2">

<input type="hidden" value="<%=mnum%>" id ="mnum2">

<div class="container1">
<h1>주문내역</h1>
	<div class="box">
		<div class="table" id="orderlist" style="text-align: center">
			
		
		</div>
	
	</div>

</div>





<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>

<script src="/pizza1/js/alert/orderlist.js" type="text/javascript"></script>


</body>
</html>