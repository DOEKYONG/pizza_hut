<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/pizza1/CSS/menu/menulist.css">
</head>
<body>
	
<%@include file ="../header.jsp" %>
<%@include file ="menubar.jsp" %>



	<div class="container1">
	
	<div class ="menulist_wrap">
	
	
	<ul >
		<%
		int cnum1 = Integer.parseInt(request.getParameter("cnum"));
		JSONArray json1= MenuDao.getmemberDao().getreview(cnum1);
		for(int i =0; i<json1.length();i++){
		%>
		<li>
		<%if(json1.getJSONObject(i).get("pizza").equals("true")){ %>
			<div class="menu_imgwrap">
				<div class="img_area">
					<a href="/pizza1/menu/menuview.jsp?menunum=<%=json1.getJSONObject(i).get("menunum")%>"><img id="menuimg" alt="" src="/pizza1/admin/menuimg/<%=json1.getJSONObject(i).get("menuimg")%>"></a>
				</div>
			</div>
			<div class="menu_inforwrap">
			<div class="menu_info">
				<span id="menu_title"><%=json1.getJSONObject(i).get("menuname")%></span>
			</div>
			</div>
			<div class="size">
				<span>L</span> <span><%=json1.getJSONObject(i).get("menuprice")%></span>
			</div>
			<div class="price">
			<span>포장가 </span> <span><%=json1.getJSONObject(i).get("menuprice")%></span>
			</div>
			<%}else{ %>
			<div class="menu_imgwrap">
				<div class="img_area">
					<a href="/pizza1/menu/submenuview.jsp?menunum=<%=json1.getJSONObject(i).get("menunum")%>"><img id="menuimg" alt="" src="/pizza1/admin/menuimg/<%=json1.getJSONObject(i).get("menuimg")%>"></a>
				</div>
			</div>
			<div class="menu_inforwrap">
			<div class="menu_info">
				<span id="menu_title"><%=json1.getJSONObject(i).get("menuname")%></span>
			</div>
			<div class="price">
			<span><%=json1.getJSONObject(i).get("menuprice")%></span>
			</div>
			</div>
			<%} %>
		</li>
		<%} %>
		
	</ul>
	
	
	
	
	</div>
	
	</div>
	
	
<%@include file ="../footer.jsp" %>
	
</body>
</html>