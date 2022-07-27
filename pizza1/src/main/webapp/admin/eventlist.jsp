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
<!-- 부트스트랩 css cdn -->  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<!-- 사용자정의 css --> <link href="/pizza1/CSS/main.css" rel="stylesheet"> 	
	<!-- 사용자정의 css --> <link href="/pizza1/CSS/admin.css" rel="stylesheet"> 	
	<!-- 폰트어썸[ 아이콘 ]  --><link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">


</head>
<body>
	<%@include file="dashboard.jsp"%>
	
		<div class="event">
		<div>
			<div>
			<h3>이벤트/쿠폰</h3>
			<%@include file="eventbar.jsp"%>
			<a href="addevent.jsp"><button class="d-flex justify-content-end eventbtn">이벤트추가</button></a>
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
						ArrayList <Event> list = EventDao.geteventDao().geteventlist(today);
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
	
		<!-- 부트스트랩 js cdn --><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- jquery 최신 cdn --><script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 사용자정의 js --><script src="/pizza1/js/dashboard.js" type="text/javascript"></script>
</body>
</html>