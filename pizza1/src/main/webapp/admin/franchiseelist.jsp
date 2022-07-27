<%@page import="dao.FranchiseeDao"%>
<%@page import="dto.Franchisee"%>
<%@page import="java.util.ArrayList"%>
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

	<%@include file="dashboard.jsp"%>
	
	
	
	
	<!-- -----검색처리 -->
	<%
		
		request.setCharacterEncoding("UTF-8");
		String key = request.getParameter("key");
		String keyword = request.getParameter("keyword");
		
		if(key!=null && keyword !=null){
			session.setAttribute("key", key);
			session.setAttribute("keyword", keyword);
		}else{
			key = (String)session.getAttribute("key");
			keyword = (String)session.getAttribute("keyword");
		}
		
		%>
	
	<%
	int totalrow = FranchiseeDao.getfranchiseeDao().gettotallist(key, keyword);
	int currentpage = 1;
		String pagenum = request.getParameter("pagenum");
		if( pagenum == null ){ // 만약에 페이지번호 요청이 없으면
			currentpage = 1; // 1페이지
		}else{
			currentpage = Integer.parseInt( pagenum ); 
		}
		
	int listsize = 12;	
	
	int startrow = (currentpage-1)*listsize; 
	
	int lastpage = 0;
	if( totalrow % listsize == 0 ){ 
		// 전체게시물 와 화면표시게시물수 나누기 했을때 나머지가 0이면
		lastpage = totalrow / listsize; 
	}else{
		lastpage = totalrow / listsize +1; 
		// 나머지가 있으면 나머지 게시물을 표시할 페이지 +1
	}
	
	int btnsize = 5;

	int startbtn = ( (currentpage-1) / btnsize ) * btnsize + 1 ;
				
	int endhtn = startbtn + btnsize-1;
	if( endhtn > lastpage ) endhtn = lastpage;

	
%>
	
	
	<div class="container">
		<div class="row">
			<a href="addorder.jsp"><button type="button">가맹점등록</button></a><br>
			<div>
			<form action="franchiseelist.jsp">
			<select name="key">
					<option value="faddress"> 주소 </option> 	<!-- key = 필드명 -->
					<option value="fname"> 가맹점명 </option>
			</select>
			<input type="text" name="keyword"> 
			<input type="submit" value="검색">
			</form>
		</div>
		<div>
		<table class="table">
			<tr>
				<th>번호</th><th>가맹점명</th><th>점주명</th><th>주소</th>
			</tr>
			<%
			
			ArrayList<Franchisee> franchiseelist = FranchiseeDao.getfranchiseeDao().getfranchiseelist(startrow , listsize ,key,keyword);
			for( Franchisee temp : franchiseelist ){ 
			%>
			
			<tr onClick="location.href='/pizza1/admin/franchiseeview.jsp?fnum=<%=temp.getFnum()%>&ordernum=<%=temp.getOrdernum()%>'">
			
				<td><%=temp.getFnum()%></td><td><%=temp.getFname()%></td><td><%=temp.getOrdername()%></td><td><%=temp.getFaddress()%></td>
			
			</tr>
			<%} %>
		</table>
		</div>
		<!-------------------------- 페이징 입력 구역  -------------------------- -->		
		<div class="col-md-4 offset-4 d-flex justify-content-center">	<!--  d-flex justify-content-center : 박스권 내에서 가운데 배치 -->
			 <ul class="pagination">
			
			 <!-- 이전 버튼 -->
			 <%if( currentpage == 1  ){ // 현재페이지가 1이면 0페이지로 요청 못하게 제한두기  %>
			 	<li class="page-item">  <a class="page-link pagenum" href="franchiseelist.jsp">이전</a></li>
			 <%}else{ %>
			 	<li class="page-item">  <a class="page-link pagenum" href="franchiseelist.jsp?pagenum=<%=currentpage-1%> ">이전</a></li>
			 <%} %>
			 
			 <!-- 페이징 버튼 -->
			 	<% for( int i = startbtn  ; i<=endhtn ; i++ ){ %>
			 		<li class="page-item"> 
				 		<a class="page-link pagenum" href="franchiseelist.jsp?pagenum=<%=i%>"> 
				 			<%=i %> 
				 		</a> 
			 		</li>
				<%} %>
			
			<!-- 다음 버튼 --> 
			 <%if( currentpage == lastpage  ){ // 현재페이지가 마지막페이지 이면 마지막페이지 이상으로 요청 못하게 제한두기  %>
			 	<li class="page-item"> <a class="page-link pagenum" href="franchiseelist.jsp?pagenum=<%=currentpage%> ">다음</a></li>
			 <%}else{ %>
			 	<li class="page-item"> <a class="page-link pagenum" href="franchiseelist.jsp?pagenum=<%=currentpage+1%> ">다음</a></li>
			 <%} %>
			 </ul>
		</div>
		</div>
	</div>
	
		<!-- 사용자정의 js --><script src="/jspweb/js/dashboard.js" type="text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>