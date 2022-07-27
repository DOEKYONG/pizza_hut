<%@page import="dao.EventDao"%>
<%@page import="dto.Event"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<%@include file="dashboard.jsp"%>
		<% int eventnum = Integer.parseInt(request.getParameter("enum"));
			Event event = EventDao.geteventDao().getevent(eventnum);
		%>
		
		
		<div class="container">
		<div>
			<div>
				<h3>이벤트/쿠폰</h3>
				<%@include file="eventbar.jsp"%>
			</div>
			<div>
				<div class="row">
					<div><%=event.getEventtitle() %><span><%=event.getEventstart() %>~<%=event.getEventend() %></span></div>
					<div><span>쿠폰번호</span><input type="text" value="<%=event.getCoupon()%>" disabled="disabled"><input type="submit" value="발급"></div>
					<div><img width="100%" src="/pizza1/event/upload/<%=event.getEventimg()%>"></div>
				</div>
			</div>
		</div>
	</div>
		
		

		
</body>
</html>