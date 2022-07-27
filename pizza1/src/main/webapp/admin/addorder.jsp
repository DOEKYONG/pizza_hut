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
	<div class="container"> 
	<form  id="ordersignupform" action="../addorder" method="post">
	<div class="container1"> 
	
	<h1 style="margin-top: 50px; color: black; font-size: 40px; text-align: center;" >가맹점 등록</h1>
	<h4 style="text-align: center ; ">아래 정보를 입력하세요</h4>
	<div class="ordersignup_wrap"> <!-- 회원가입 전체 레이아웃 조절용 -->
	
	
		<div class="signup_box add"><!-- 회원가입 전체 박스 -->
		<div class="form_info">
			<div class ="lbl"><span>가맹점명</span></div>
			<div class="inputarea"><input class="info_text" type="text" id="frname" name="frname"></div>
			<span id="storenamecheck"></span>
		</div>
		<div class="form_info address">
		<div class="address_first">
			<div class ="lbl"><span>주소</span></div>
			<div class="inputarea"><input type="text" id="sample4_postcode" name="faddress1" placeholder="우편번호"></div>
			<div class="inputarea"><input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" id="addressbtn"></div>
		</div>	
			<div class="address_second">
				<div class="inputarea"><input type="text" id="sample4_roadAddress" name="faddress2" placeholder="도로명주소"></div>
				<div class="inputarea"><input type="text" id="sample4_jibunAddress" name="faddress3" placeholder="지번주소"></div>
				<span id="guide" style="color:#999;display:none"></span>
				<div class="inputarea"><input type="text" id="sample4_detailAddress" name="faddress4" placeholder="상세주소"></div>
				<span id="storeaddresscheck" style="padding-left: 100px;"></span>
			</div>
			
		</div>
		<div class="form_info">
			<div class ="lbl"><span>점주이름</span> </div>
			<div class="inputarea"><input class="info_text" type="text" id="fmname" name="mname"></div>
			<span id="fnamecheck"></span>
		</div>
		<div class="form_info">
			<div class ="lbl"><span>아이디</span></div> 
			<div class="inputarea"><input class="info_text" type="text"id="fmid" name="mid"></div>
			<span id="fidcheck"></span>
			<button type="button" id="fidck">중복체크</button>
		</div>
		<div class="form_info">
		<div class="pwf">
			<div class ="lbl"style="margin-top: 25px; " ><span>비밀번호</span></div>
			 <div class="inputarea"><input class="info_text" type="password"id="fmpassword" name="mpassword"></div>
		</div>
			
		</div>
		<div class="form_info">
		<div class="pwf">
			 <div class ="lbl"style="margin-top: 25px; "><span>비밀번호 체크</span></div>
			 <div class="inputarea"> <input class="info_text" type="password" id="fmpasswordcheck"></div>
			</div>
			<span id="fpasswordcheck"></span>
		</div>
		<div class="form_info email">
			<div class ="lbl"><span>이메일</span></div>
			 <div class="inputarea"> <input type="text" id="fmemail" name="memail" placeholder="user email"></div>
		@
		 <span><input type="text" id="fmemailaddress" name="memailaddress" ></span>
		<span><select id="femailselect">
			<option value=""> 직접입력 </option>
			<option value="naver.com"> naver.com </option>
			<option value="nate.com"> nate.com </option>
			<option value="daum.com"> daum.com </option>
		</select>
		</span>
		<button id="femailchk" type="button" >중복체크</button>
		<span id="emailcheck"></span>
		<span id="femailcheck"></span>
		</div>
		<div class="form_info">
			<div class ="lbl"><span>휴대폰*</span></div>
			<div class="inputarea"><input class="info_text" type="text"id="fmphone" name="mphone"></div>
			<span id="fphonecheck"></span>
		</div>
		<div class="birth">
		<div class="lbl"><span>생일</span></div>
		<div class="inputarea sbirth">
		<select name="yy" id="year" ></select>년
		<select name="mm" id="month" ></select>월
		<select name="dd" id="day" ></select>일
		</div>
		
		</div>
		
		
		
		
		
	</div>
	<div class="button_area1">
			<button id="btn_signup" type="button" onclick="ordersignup()">등록</button>
		</div>
	
	</div>
	

	
	</div>
	</form>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
		<script src="/pizza1/js/dateform.js" type="text/javascript"></script>
		<script src="/pizza1/js/ordersignup.js" type="text/javascript"></script>
</body>
</html>