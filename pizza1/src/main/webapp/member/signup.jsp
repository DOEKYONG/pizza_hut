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
	<form  id="signupform" action="../signup" method="post">

	<div class=" container1"> 
		<h1 style="margin-top: 50px; color: black; font-size: 40px; text-align: center;">회원가입</h1>
	<h4 style="text-align: center ; ">아래 정보를 입력하세요</h4>
	<div class="signup_wrap"> <!-- 회원가입 전체 레이아웃 조절용 -->
	
	
		<div class="signup_box"><!-- 회원가입 전체 박스 -->
		<div class="form_info">
			<div class ="lbl"><span>이름</span></div>
			<div class="inputarea"><input class="info_text" type="text" id="mname" name="mname"></div>
			 
			<span id="namecheck"></span>
		</div>
		<div class="form_info">
			<div class ="lbl"><span>아이디</span></div> 
			<div class="inputarea"><input class="info_text" type="text"id="mid" name="mid"></div>
			<button type="button" id="idck" style="flex-shrink: 0">중복체크</button>
			<span id="idcheck" style="flex-shrink: 0"></span>
		</div>
		
		<div class="form_info">
		<div class="pwf">
			<div class ="lbl" style="margin-top: 25px; "><span>비밀번호</span></div>
			<div class="inputarea"><input class="info_text" type="password"id="mpassword" name="mpassword"> </div>
			</div>
			
		</div>
		<div class="form_info">
		<div class="pwf">
			<div class ="lbl" style="margin-top: 25px; "><span>비밀번호 체크</span></div>
			<div class="inputarea"><input class="info_text" type="password" id="mpasswordcheck"></div>
			</div>
			<span id="passwordcheck" style="margin-left:20px;"></span>
		</div>
		
		<div class="form_info email">
			<div class ="lbl"><span >이메일 : </span></div>
			<div class="inputarea"> <input type="text" id="memail" name="memail" placeholder="user email"> </div>
		@
		<span><input type="text" id="memailaddress" name="memailaddress" ></span>
		<span><select id="emailselect">
			<option value=""> 직접입력 </option>
			<option value="naver.com"> naver.com </option>
			<option value="nate.com"> nate.com </option>
			<option value="daum.com"> daum.com </option>
		</select>
		</span>
		<button id="emailchk" type="button" >중복체크</button>
		<span id="emailcheck"></span>
		</div>
		<div class="form_info">
			<div class ="lbl"><span>휴대폰</span></div>
			<div class="inputarea"> <input class="info_text" type="text"id="mphone" name="mphone"></div>
			<span id="phonecheck"></span>
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
		
			<button id="btn_signup"  type="button" onclick="signup()">회원가입</button>
			
		</div>
	
	
	
	
		

	</div>
	
	</div>
	</form>
	<%@include file="../footer.jsp"%>
	 <script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
		<script src="/pizza1/js/dateform.js" type="text/javascript"></script>
		<script src="/pizza1/js/signup.js" type="text/javascript"></script>
</body>
</html>