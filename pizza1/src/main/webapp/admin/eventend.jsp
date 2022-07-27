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

</head>
<body>

		<!-- -----검색처리 -->
	<%
		
		request.setCharacterEncoding("UTF-8");
		String key = "eventtitle";
		String keyword = request.getParameter("keyword");
		
		if(key!=null && keyword !=null){
			session.setAttribute("keyword", keyword);
		}else{
			keyword = (String)session.getAttribute("keyword");
		}
		
		%>
	
	<%
	int totalrow = EventDao.geteventDao().gettotallist(key, keyword);
	int currentpage = 1;
		String pagenum = request.getParameter("pagenum");
		if( pagenum == null ){ // 만약에 페이지번호 요청이 없으면
			currentpage = 1; // 1페이지
		}else{
			currentpage = Integer.parseInt( pagenum ); 
		}
		
	int listsize = 12;	
	
	int startrow = (currentpage-1)*listsize; 
	
	int lastpage = 0;
	if( totalrow % listsize == 0 ){ 
		// 전체게시물 와 화면표시게시물수 나누기 했을때 나머지가 0이면
		lastpage = totalrow / listsize; 
	}else{
		lastpage = totalrow / listsize +1; 
		// 나머지가 있으면 나머지 게시물을 표시할 페이지 +1
	}
	
	int btnsize = 5;

	int startbtn = ( (currentpage-1) / btnsize ) * btnsize + 1 ;
				
	int endhtn = startbtn + btnsize-1;
	if( endhtn > lastpage ) endhtn = lastpage;

	
%>

	<%@include file="dashboard.jsp"%>
	<div class="event">
		<div>
			<div>
			<h3>이벤트/쿠폰</h3>
			<%@include file="eventbar.jsp"%>
			<a href="addevent.jsp"><button>이벤트추가</button></a>
			</div>
			<form action="eventend.jsp">
				<div>
					<input type="text" name="keyword"> 
					<input type="submit" value="검색">
				</div>
			</form>
			<div>
				<table class="table">
					<tr>
							<td>번호</td><td>제목</td><td>광고이미지</td><td>이벤트이미지</td><td>쿠폰번호</td><td>할인율</td><td>기간</td>
					</tr>
					<%
					Date date = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
					String today = dateFormat.format(date);
						ArrayList <Event> list = EventDao.geteventDao().geteventend(today, startrow, listsize, key, keyword);
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