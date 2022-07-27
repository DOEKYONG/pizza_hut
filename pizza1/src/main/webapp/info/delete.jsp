<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
			String mid  = (String)session.getAttribute("login");
		%>
	<%@include file="../header.jsp"%>
	<div class="container1">
	<%@include file="infomenu.jsp" %>
	
			<div class="dwrap">
			<div class="signup_box del">
				
			<div class="infodel">
				<div class="alert">
					<h2>회원탈퇴를 원하시면 </h2>
					<h2>비밀번호를 입력하세요</h2>
					
				</div>
				  
				<div class="input_darea"><input type="password" id=mpassword name="mpassword"></div>
				
				<div><button id="btncofirm"onclick="passwordcheck('<%=mid%>')">확인</button></div>
				<div id="checkmsg"> </div>
				<div class="btna"><button id="btndelete" style="display: none;" onclick="mdelete('<%=mid%>')">탈퇴승인</button></div>
				
			</div>
				
				 
			</div>
			</div>
		
			
			</div>	
				<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
				<script src="../js/info.js" type="text/javascript"></script>
				
<%@include file="../footer.jsp"%>				
</body>
</html>