<%@page import="org.json.JSONArray"%>
<%@page import="dao.MenuDao"%>
<%@page import="dto.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/pizza1/CSS/menu/menutop_bar.css">
</head>
<body>

	

	<div class="wrap">
	<%
		ArrayList<Category>getcategory2 = MenuDao.getmemberDao().getcategory();
		ArrayList<Category> side2 = MenuDao.getmemberDao().getside();
		ArrayList<Category> getgetdrink2 = MenuDao.getmemberDao().getdrink();
		for(int i=0;i<1;i++){
		%>
	<div class="menu-top">
		<div class="menu-top-name">
			<a href="menulist.jsp?cnum=<%=getcategory2.get(i).getCnum()%>" class ="name" >피자</a>
			<div class="topmenu_option">
				<%
					for(Category category : getcategory2){
				%>
				<span><a href="menulist.jsp?cnum=<%=category.getCnum()%>"><%=category.getCname() %></a></span>
				<%} %>
			</div>
			
			
		</div>
		<div class="menu-top-name">
		<a href="menulist.jsp?cnum=<%=side2.get(i).getCnum()%>" class ="name">사이드</a>
		</div>
		<div class="menu-top-name">
		<a href="menulist.jsp?cnum=<%=getgetdrink2.get(i).getCnum()%>" class ="name">음료&기타</a>
		</div>
	</div>
	<%} %>
	<div id ="line"></div>
	
	
	
</div>

</body>
</html>