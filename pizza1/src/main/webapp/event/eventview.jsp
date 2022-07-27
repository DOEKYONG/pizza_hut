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
		<%@include file="../header.jsp"%>
		
		<% int eventnum = Integer.parseInt(request.getParameter("enum"));
			Event event = EventDao.geteventDao().getevent(eventnum);
			String mid = (String)session.getAttribute("login");
		%>
		
		
		<div class="container">
		<div>
			<div>
				<h3>이벤트/쿠폰</h3>
				<%@include file="eventmenu.jsp"%>
			</div>
			<div>
				<div class="row">
					<div><%=event.getEventtitle() %><span><%=event.getEventstart() %>~<%=event.getEventend() %></span></div>
					<div><span>쿠폰번호</span><input type="text" value="<%=event.getCoupon()%>" disabled="disabled">
					<input type="button" onclick="coupon(<%=event.getEventnum() %> ,'<%=mid %>')" value="발급"></div>
					<div><img width="100%" src="/pizza1/event/upload/<%=event.getEventimg()%>"></div>
				</div>
			</div>
		</div>
	</div>
		
		

		
		
		<%@include file="../footer.jsp"%>
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
		<script src="/pizza1/js/event.js" type="text/javascript"></script>
</body>
</html>