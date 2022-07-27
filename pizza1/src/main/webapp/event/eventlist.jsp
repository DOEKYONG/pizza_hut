<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dto.Event"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.EventDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/pizza1/CSS/eventlist.css">
</head>
<body>
	<%@include file="../header.jsp"%>
		
	<div class="container">
		<div>
			<div>
			<h3>이벤트/쿠폰</h3>
			<%@include file="eventmenu.jsp"%>
			</div>
			
			<div>
				<table class="table">
					<%
						Date date = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
					String today = dateFormat.format(date);
						ArrayList <Event> list = EventDao.geteventDao().geteventlist(today);
						if( list.size() != 0 ){
					%>
						<tr>
							<td  onClick="location.href='eventview.jsp?enum=<%=list.get(0).getEventnum()%>'" colspan="2"><img width="100%" height="300px" src="/pizza1/event/upload/<%=list.get(0).getBannerimg()%>"></td>
						</tr>
					
					<%	for(int i =1; (2*i)<list.size(); i++){
					%>
						<tr>
							<td onClick="location.href='eventview.jsp?enum=<%=list.get((2*i)-1).getEventnum()%>'"><img width="100%" src="/pizza1/event/upload/<%=list.get((2*i)-1).getBannerimg() %>">
							<br><%=list.get((2*i)-1).getEventtitle()%><br><%=list.get((2*i)-1).getEventstart()%>~<%=list.get((2*i)-1).getEventend()%></td>
							</tr>
							<tr>
							<td onClick="location.href='eventview.jsp?enum=<%=list.get(2*i).getEventnum()%>'"><img width="100%" src="/pizza1/event/upload/<%=list.get(2*i).getBannerimg() %>">
							<br><%=list.get(2*i).getEventtitle()%><br><%=list.get(2*i).getEventstart()%>~<%=list.get(2*i).getEventend()%></td>
						</tr>
					<%} }%>
				</table>
			</div>
			
			
			
		</div>
	</div>
	<%@include file="../footer.jsp"%>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>