<%@page import="org.json.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dto.Event"%>
<%@page import="dao.MemberDao"%>
<%@page import="dao.EventDao"%>
<%@page import="dto.Couponlist"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/pizza1/CSS/mycoupon.css">
</head>
<body>

	<%
		String id = (String)session.getAttribute("login");
		int mnum = MemberDao.getmemberDao().getmnum(id);
		String couponactive = "사용전";
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		String today = dateFormat.format(date);
		JSONArray jsonArray = EventDao.geteventDao().getmycoupon(mnum, couponactive,today);
		
	%>

	<%@include file="../header.jsp"%>
	
	
	
	<div class="container container1">
	<%@include file="infomenu.jsp" %>
		<ul class="couponlist_wrap">
		<%if(jsonArray.length()==0){
			%>
			<li>
				<div>존재하는 쿠폰이 없습니다.</div>
			</li>
		<%	
		}else{
		for(int i =0; i<jsonArray.length(); i++){
		%>
			<li >
				<div class="couponbox">
					<span class="coupon">[쿠폰] <%=jsonArray.getJSONObject(i).get("eventtitle") %></span>
					 <span class="discount"><%=jsonArray.getJSONObject(i).get("discount")%>% 할인</span>
					 <span class="end">~<%=jsonArray.getJSONObject(i).get("eventend")%></span>
				</div>
			</li>
			<%} }%>
		</ul>
	</div>
	
	<%@include file="../footer.jsp"%>
	
</body>
</html>