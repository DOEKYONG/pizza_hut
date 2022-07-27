<%@page import="java.util.ArrayList"%>
<%@page import="dao.NoticeDao"%>
<%@page import="dto.Notice"%>
<%@page import="dao.FranchiseeDao"%>
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
	<%@include file ="../header.jsp" %>
	
	
	<div class="container1">
		
<!-------------------------------- 검색처리 처리 ------------------------------------>
<%
			request.setCharacterEncoding("UTF-8");
			String key = request.getParameter("key");
			String keyword = request.getParameter("keyword");
			
			// 세션을 이용한 검색처리 저장
			
			
			// 검색이 있을경우
			if(key != null && keyword != null) {
				session.setAttribute("key", key); // 세션 설정 [ 세션명, 세션데이터 ]
				session.setAttribute("keyword", keyword);
			}else { // 검색이 없을때
				key = (String)session.getAttribute("key"); // 세션 호출 [ 세션명 -> 세션데이터 ]
				keyword = (String)session.getAttribute("keyword");
			}
			
			// 검색이 없을경우
			
			
		
%>
		
		
<!----------------------------------페이징 계산 처리------------------------------------ -->
<%

	// 1. 게시물 전체 개수
	int totalrow =  NoticeDao.getNoticeDao().gettotalrow(key,keyword);
	
	
	// 1. 현재 페이지 번호
	int currentpage =1;
	//요청받은 페이지 번호
	String pagenum = request.getParameter("pagenum");
		// 만약에 페이지 번호 요청이 없으면
		if(pagenum == null || pagenum.equals("0")) {currentpage = 1;}
		else{currentpage = Integer.parseInt(pagenum);} // 요청된 페이지번호 -> 정수형변환 -> 현재페이지 설정

	// 3. 페이지당 게시물을 표시할 개수
	int listsize =5;
	// 4. 페이지당 게시물의 시작번호
	int startrow = (currentpage-1)*5;
	
	int lastpage;  //
	if(totalrow%listsize == 0) {
		lastpage =totalrow / listsize;
	}else {
		lastpage = totalrow / listsize +1;
	}
	// 6-2 페이징 표시 개수
	int btnsize= 5;
	// 6.페이징버튼 시작번호
		int startbtn = ((currentpage-1)/btnsize) *btnsize +1 ;
	// 7. 페이징버튼 끝번호
	int endbtn = startbtn + btnsize-1;
	if(endbtn > lastpage) endbtn = lastpage;
	
	// 1. 모든게시물 호출
	ArrayList<Notice> noticelist = NoticeDao.getNoticeDao().getnoticelist(startrow,listsize,key,keyword);

%>
			<div class="list_wrap">
			<h1 >공지사항</h1>
	<%
			String mid = (String)session.getAttribute("login");
			
			int mnum = MemberDao.getmemberDao().getmnum(mid);
			int fnum = FranchiseeDao.getfranchiseeDao().getfnum(mnum);
			%>
			
		
			
			<table class="table">
			<tr>
				<th>번호</th><th >제목</th><th >작성자</th><th>작성일</th>
			</tr>
			<%
				// 1. 모든 게시물  호출 
				
				for( Notice temp : noticelist ){
			%>
			<tr onclick="location.href='noticeview.jsp?nnum=<%=temp.getNnum()%>'" style="cursor: pointer">
					<td> <%=temp.getNnum() %></td>
					<td> <%=temp.getNtitle() %></td>
					<%if (temp.getFnum() == 0){ %>
						<td>관리자</td>
						<% } else {
						%><td> <%=temp.getFname() %> </td>
						<%} %>
						<td> <%=temp.getNdate()%> </td>
					
					
				</tr>
			<%
				}
			%>
		</table>

	
<!---------------------------------------------- 페이징 입력 구역 ---------------------------->
			<div class="page_area">
				<ul class="page">
				<%if(currentpage == 1) { %>
				<li class="page_itme"><a class="page_link pagenum" href="noticelist.jsp">이전</a></li>
				<%} else{%>
				<li class="page_itme"><a class="page_link pagenum" href="noticelist.jsp?pagenum=<%=currentpage-1%>">이전</a></li>
				<%} %>
				<%for( int i= startbtn; i<=endbtn; i++) { %>
				<li class="page_itme"><a class="page_link pagenum" href="noticelist.jsp?pagenum=<%=i%>"><%=i%></a></li>
				<%} %>
				<%if(currentpage==lastpage) { %>
				<li class="page_itme"><a class="page_link pagenum" href="noticelist.jsp?pagenum=<%=currentpage%>">다음</a></li>
				<%}else { %>
				<li class="page_itme"><a class="page_link pagenum" href="noticelist.jsp?pagenum=<%=currentpage+1%>">다음</a></li>
				<%} %>
				
				
			
			</ul>
			</div>
<!----------------------------------------- 검색 입력 구역 ----------------------------------->
			<div class="search_area">
			<form action="noticelist.jsp?pagenum=<%=currentpage %>" class="search_area">
				<div class="search_area_1"> <!-- 키 선택 -->
					<select class="form_select" name="key">
						<option value="ntitle">제목</option>
						<option value="ncontent">내용</option>
						<option value="fname">작성자</option>
					</select>
					<input type="text" class="serach_input" name="keyword"> <!-- 키워드입력창 -->
					<input type="submit" class="search_button" value="검색">
				</div>
				
				
			</form>
			
			</div>
	
			
			
		
			</div>
			
			<div class="btn_area_list">
				<% if( mid != null && mid.equals("admin")|| fnum != 0){%>
					<button class ="total_list" onclick = "location.href = 'noticewrite.jsp' ">글쓰기</button>
				<%}%> 
			<button class ="total_list" onclick = "location.href = 'noticelist.jsp?key=&keyword=' ">전체글</button>
			</div>
		</div>
		
			
	
	<%@include file ="../footer.jsp" %>
	
		
		

</body>
</html>