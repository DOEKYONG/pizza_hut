<%@page import="dao.FranchiseeDao"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 	
String mid 
= (String)session.getAttribute("login"); ///로그인세션 불러오기


int mnum = (Integer)session.getAttribute("mnum"); ///로그인세션 불러오기
int fnum = (Integer)session.getAttribute("fnum");

System.out.println(mnum);	
System.out.println(fnum);	
			
%>
<input type="hidden" value="<%=mnum%>" id="mnum2">
<input type="hidden" value="<%=fnum%>" id="fnum2">

	<div class="container1">
		<div class="alert_wrap">
		<h1>주문알리미</h1>
			
			<div class="box">
				
				<%if(fnum != 0) { %>
				<div id = "contentbox">
				
				</div>	
				<%} %>		
			
			</div>
			
		</div>
	
	
	</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="/pizza1/js/menu/menuorder.js" type="text/javascript"></script>


	
</body>
</html>