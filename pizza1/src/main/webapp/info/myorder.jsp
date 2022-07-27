<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../CSS/style2.css">
</head>
<body>
<%
int mnum = (Integer)session.getAttribute("mnum");
%>
<input type="hidden" value="<%=mnum%>" id ="mnum2">
	<%@include file="../header.jsp"%>
	<div class="container1">
	<%@include file="infomenu.jsp" %>
	<div id="test">
	
	</div>

	
	</div>
	<%@include file="../footer.jsp"%>
	<!-- jquery 최신 cdn --><script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src ="/pizza1/js/morderlist.js"></script>
</body>
</html>