<%@page import="dto.Member"%>
<%@page import="dao.FranchiseeDao"%>
<%@page import="dto.Franchisee"%>
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
	<%
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		int ordernum = Integer.parseInt(request.getParameter("ordernum"));
		Franchisee franchisee = FranchiseeDao.getfranchiseeDao().get(fnum,ordernum);
		Member member = FranchiseeDao.getfranchiseeDao().getmember(ordernum);
		String [] address = franchisee.getFaddress().split("_");
		String address1 = address[0];
		String address2 = address[1];
		String address3 = address[2];
		String address4 = address[3];
	%>
	
	<div class="container">
	<form id="ordersignupform" action="../orderupdate" method="post">
	<a href="/pizza1/admin/franchiseelist.jsp">목록보기</a><br>
		<input type="hidden" name="fnum" value="<%=fnum%>">
		가맹점번호 : <%=member.getMnum()%> <br>
		<div class="form_info">
			<span>가맹점명*</span> <input class="info_text" type="text" id="frname" name="frname" value="<%=franchisee.getFname()%>">
			<span id="storenamecheck"></span>
		</div>
		<div class="form_info">
			<span>주소*</span>
			<input type="text" id="sample4_postcode" name="faddress1" value="<%=address1%>">
			<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" id="sample4_roadAddress" name="faddress2" value="<%=address2%>">
			<input type="text" id="sample4_jibunAddress" name="faddress3" value="<%=address3%>">
			<span id="guide" style="color:#999;display:none"></span>
			<input type="text" id="sample4_detailAddress" name="faddress4" value="<%=address4%>">
			<span id="storeaddresscheck"></span>
		</div>
		<input type="hidden" name="mnum" value="<%=member.getMnum() %>">
		<input type="hidden" id="mid" name="mid" value="<%=member.getMid() %>">
		회원번호 : <%=member.getMnum()%> <br>
		아이디 : <%=member.getMid()%> <br>
		비밀번호 : <button type="button" onclick="passwordchange()">변경하기</button> <br>
		
		<div id="passwordbox" style="display: none;">
							기존 비밀번호 : <input type="password" id="oldpassword" name="oldpassword"><span id="foldmpassword"></span><br>
							새로운 비밀번호 : <input type="password" id="newpassword" name="newpassword">
							<span id="fmpassword"></span>
						</div>
						
		이름 : <input type="text" name="mname" id="fmname" value="<%=member.getMname()%>"><span id="fnamecheck"></span>  <br>
		이메일 : <div class="form_info">
		<input type="text" id="fmemail" name="memail" value="<%=member.getMemail().split("@")[0]%>">
		@
		<input type="text" id="fmemailaddress" name="memailaddress" value="<%=member.getMemail().split("@")[1]%>" >
		<select id="femailselect">
			<option value=""> 직접입력 </option>
			<option value="naver.com"> naver.com </option>
			<option value="nate.com"> nate.com </option>
			<option value="daum.com"> daum.com </option>
		</select>
		<span id="femailcheck"></span>
		</div><br>
		전화번호 : <input class="info_text" type="text"id="fmphone" name="mphone" value="<%=member.getMphone()%>">
			<span id="fphonecheck"></span> <br>
		생일 : <%=member.getMbirth()%><br> 
		가입일 : <%=member.getMdate()%><br>
		
		
		
		<input type="button" name="view" value="수정" onclick="orderupdate()">
		<input type="button" name="view" value="삭제" onclick="fdelete(<%=member.getMnum()%>,<%=fnum%>)">
	
	</form>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="../js/orderupdate.js" type="text/javascript"></script>
	
</body>
</html>