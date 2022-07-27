<%@page import="dto.Member"%>
<%@page import="dao.MemberDao"%>
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

	
	<%@include file="../header.jsp"%>

	<%
		String mid = (String)session.getAttribute("login");
		
		Member member = MemberDao.getmemberDao().getmember(mid);
		
	%>
	
	
	
	<form id="updateform" action="../update" method="post">
	<div class="container1">
	<%@include file="infomenu.jsp" %>
	<div class="ordersignup_wrap">
	<div class="signup_box add"> 
	<input type="hidden" name="mnum" value="<%=member.getMnum() %>">
		
		
		<div class="idform form_info" ><div class ="lbl"><span>아이디</span></div>  <div class="inputarea"><%=member.getMid()%></div> </div>
		<div class="passwordform form_info">
			<div class ="lbl"><span>비밀번호</span></div> <div class="btncpw"><button class="btn_cpw" type="button"  onclick="passwordchange()">변경하기</button></div>
		
		<div id="passwordbox" style="display: none;">
							<div class="pbi">기존 비밀번호  <input type="password" name="oldpassword"> <span id="foldmpassword"></span></div>
							<div class="pbi">새온 비밀번호  <input type="password" name="newpassword" id="mpassword"> <span id="passwordcheck"></span></div>	
						</div>
		</div>
		
		<div class="nameform form_info">
			<div class ="lbl"><span>이름</span></div>  <div class="inputarea"><input type="text" id="mname" name="mname" value="<%=member.getMname()%>">  <span id="namecheck"></span></div>
		</div>		
				
		<div class="form_info email">
		<div class ="lbl"><span>이메일</span></div>  <div class="inputarea"><input id="memail" type="text" name="memail" value="<%=member.getMemail().split("@")[0]%>"></div>
		@
		<input id="memailaddress" type="text" name="memailaddress" value="<%=member.getMemail().split("@")[1]%>">
		<select id="emailselect">
			<option value=""> 직접입력 </option>
			<option value="naver.com"> naver.com </option>
			<option value="nate.com"> nate.com </option>
			<option value="daum.com"> daum.com </option>
		</select>  
		<button id="emailchk" type="button" >중복체크</button>
		
		</div>
		
			<div class="phone_form form_info">
			<div class ="lbl"><span>전화번호</span></div>  <div class="inputarea"><input type="text" name="mphone" value="<%=member.getMphone()%>" id="mphone"><span id="phonecheck"></span></div>
			</div>
		 <div class="form_info">
		 	<div class="lbl"><span>생일</span></div>   <div class="inputarea"><%=member.getMbirth()%></div>
		 </div>
		<div class="form_info">
		<div class="lbl"><span>가입일</span></div>   <div class="inputarea"><%=member.getMdate()%></div>
		</div>
		
		
	</div>
	<div class="ubtn_area">
	<button type="button" onclick="update()">수정하기</button>
		<a href="/pizza1/info/update.jsp"><button type="button">변경취소</button></a>
	</div>
	
	</div>
	
	
	
	</div>
	
	
	</form>
	
	<%@include file="../footer.jsp"%>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="../js/update.js" type="text/javascript"></script>
		
</body>
</html>