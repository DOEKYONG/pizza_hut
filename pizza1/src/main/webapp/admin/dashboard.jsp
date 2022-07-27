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

	<!-- marquee : 텍스트 슬라이드(전광판) // 속성 : scrollamount = "속도" -->

	
	<!-- 사이드바  -->
	<div class="container">
	<div  id="sidebar">
		<ul> <!--사이드바 목록  -->
			<li><h6> HOOT PIZZA <br> 관리자 모드 </h6></li>
			<li><a href="menulist.jsp" id="a"><button class="button" onclick="button(1)" id="1">메뉴</button></a></li>
			<li><a href="eventlist.jsp" id="b"><button class="button" onclick="button(2)" id="2">이벤트</button></a></li>
			<li><a href="franchiseelist.jsp?key=&keyword="  id="c"><button class="button" onclick="button(3)" id="3">점주</button></a></li>

			<li> <a href="/pizza1/home.jsp">홈페이지로 이동</a></li>
			<li> <a href="/pizza1/logout">로그아웃</a></li>
		</ul>
		<!-- 사이드바 열기/닫기 사용  -->
		<span class="sidebarbtn" id="sidebarbtn"> ||||</span>
	</div>
	</div>
<!------------- 페이지 전환시 페이지가 포함되는 구역------------->
	

	<!-- 부트스트랩 js cdn --><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- jquery 최신 cdn --><script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 사용자정의 js --><script src="/pizza1/js/dashboard.js" type="text/javascript"></script>
	

</body>
</html>