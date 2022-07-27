<%@page import="dao.EventDao"%>
<%@page import="dto.Event"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 사용자정의 css --> <link href="/pizza1/CSS/adminevent.css" rel="stylesheet"> 	
</head>
<body>

	<%@include file="dashboard.jsp"%>
		<div class="event">
		<div>
			<div>
			<h3>이벤트/쿠폰</h3>
			<%@include file="eventbar.jsp"%>
			<a href="addevent.jsp"><button>이벤트추가</button></a>
			</div>
			
			<div>
				<table class="table">
					<tr>
							<td>번호</td><td>제목</td><td>광고이미지</td><td>이벤트이미지</td><td>쿠폰번호</td><td>할인율</td><td>기간</td>
					</tr>
					<%
					Date date = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
					String today = dateFormat.format(date);
						ArrayList <Event> list = EventDao.geteventDao().geteventstart(today);
						for(Event e : list){
					%>				
						<tr onClick="location.href='eventview.jsp?enum=<%=e.getEventnum() %>'">
							<td><%=e.getEventnum() %></td>
							<td><%=e.getEventtitle() %></td>
							<td><img style="height: 50px;" alt="" src="/pizza1/event/upload/<%=e.getBannerimg()%>"></td>
							<td><img style="height: 50px;" alt="" src="/pizza1/event/upload/<%=e.getEventimg()%>"></td>
							<td><%=e.getCoupon() %></td>
							<td><%=e.getDiscount()%></td>
							<td><%=e.getEventstart()%>~<%=e.getEventend()%></td>
						</tr>
					<%} %>
				</table>
			</div>
			
			
			
		</div>
	</div>
</body>
</html>