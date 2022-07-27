<%@page import="dao.FranchiseeDao"%>
<%@page import="dao.MemberDao"%>
<%@page import="dao.MenuDao"%>
<%@page import="dto.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 폰트어썸[ 아이콘 ]  -->
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
<link rel="stylesheet" type="text/css" href="/pizza1/CSS/style.css">
</head>
<body>

	<!-- ------------------------헤더-------------------- -->

	<!-- ------------------------헤더--------------------- -->
				
	<%
		String loginid 
			= (String)session.getAttribute("login"); ///로그인세션 불러오기
			int mnum2 = MemberDao.getmemberDao().getmnum(loginid);
			int fnum2 = FranchiseeDao.getfranchiseeDao().getfnum(mnum2);
			session.setAttribute("mnum", mnum2);
			session.setAttribute("fnum", fnum2);
			System.out.print("mnum"+ mnum2);
			System.out.print("fnum2"+ fnum2);
			int 영업 = FranchiseeDao.getfranchiseeDao().getotime(fnum2);
			System.out.print(영업);
			String 영업종료 = "영업종료";
			if(영업==1){
				영업종료="영업중";
			}
	%>
			<div class="login">
			<% if( loginid == null ){ %>
			<span><a href="/pizza1/member/login.jsp">로그인</a></span> <span><a href="/pizza1/member/signup.jsp">회원가입</a></span>
			<%} %>
			<% if( loginid != null ){ %>
			<% if( loginid.equals("admin") ){ %>
			<span><a href="/pizza1/admin/menulist.jsp">관리자모드</a></span>
			<%} %>
			<span><a href="#"><%=loginid %>님 </a></span>
			 <span><a href="/pizza1/logout">로그아웃</a></span>
<%if(fnum2 != 0) { %>			
<a href="#" onclick="window.open('/pizza1/alert/alert.jsp', '알림','width=300px, height=500px'); return false">주문알림</a>
<a href = "/pizza1/alert/Orderlist.jsp">주문내역</a>
<button type="button" id="oper" onclick="opertime('<%=fnum2%>')"><%=영업종료%></button>
<%} %>
			<%} %>
			</div>
			<div class="heaer_wrap"> <!-- 헤더 전체박스 -->
				
				
				<div class="header_log"> <!-- 헤더 로고 -->
				
				<a href="/pizza1/home.jsp"><img alt="logo" src="/pizza1/img/sample_logo.png"></a>
				</div> <!-- 헤더 로고 end -->
				
				<div class="header_menu"> <!-- 헤더 메뉴 -->
				
					<div class ="test">
					
					<header style="height: 68px;">
				      <nav>
				        <ul class="clerarfix mainmenu">
						<%
		ArrayList<Category>getcategory1 = MenuDao.getmemberDao().getcategory();
		ArrayList<Category>side1 = MenuDao.getmemberDao().getside();
		ArrayList<Category>getdrink1 = MenuDao.getmemberDao().getdrink();
		if(getdrink1.size()!=0){
		for(int i=0;i<1;i++){
		%>
				          <li>
				            <a href="/pizza1/menu/menulist.jsp?cnum=<%=getcategory1.get(i).getCnum()%>">주문</a>
				            <ul class="submenu">
				              <li><a href="/pizza1/menu/menulist.jsp?cnum=<%=getcategory1.get(i).getCnum()%>">피자</a></li>
				              <li><a href="/pizza1/menu/menulist.jsp?cnum=<%=side1.get(i).getCnum()%>">사이드</a></li>
				              <li><a href="/pizza1/menu/menulist.jsp?cnum=<%=getdrink1.get(i).getCnum()%>">음료</a></li>
				            </ul>
				          </li>
				<%}}else{%>
                 <li>
				            <a href="/pizza1/menu/menulist.jsp?cnum=">주문</a>
                        <ul class="submenu">
                          <li><a href="/pizza1/menu/menulist.jsp?cnum=">피자</a></li>
                          <li><a href="/pizza1/menu/menulist.jsp?cnum=">사이드</a></li>
                          <li><a href="/pizza1/menu/menulist.jsp?cnum=">음료</a></li>
                        </ul>
                      </li>
               <%   } %>
				          <li>
				           <a href="/pizza1/event/eventlist.jsp"> 이벤트/할인</a>
				            <ul class="submenu">
				              <li><a href="/pizza1/event/eventlist.jsp">이벤트</a></li>
				        
				            </ul>
				          </li>
				
				          <li>
				            <a href="/pizza1/findstore/findstore.jsp?key=&keyword=">가맹점찾기</a>
				            <ul class="submenu">
				              <li><a href="/pizza1/findstore/findstore.jsp?key=&keyword=">매장찾기</a></li>
				              
				            </ul>
				              <li>
				            <a href="/pizza1/notice/noticelist.jsp?key=&keyword=">고객센터</a>
				            <ul class="submenu">
				              <li><a href="/pizza1/notice/noticelist.jsp?key=&keyword=">공지사항</a></li>
				              <li><a href="/pizza1/qboard/qlist.jsp?key=&keyword="">1:1문의</a></li>
				            </ul>
				          </li>
				            

				        </ul>
				      </nav>
				    </header>
				    
				    </div>

				</div> <!-- 헤더 메뉴 end -->
				
			</div> <!-- 헤더 전체박스 end -->
<!--  ------------------------헤더 end--------------------------- -->

<!-- jquery 최신 cdn --><script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/pizza1/CSS/script.js"></script>
</body>
</html>