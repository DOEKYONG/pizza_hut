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
<link rel="stylesheet" type="text/css" href="/pizza1/CSS/findstore.css">
</head>
<body>

	<div class="container">
		<div class="row">
		
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
		
		
		
		<!-- --------검색------ -->
		<div class="serach_area_f">
			<form action="findstore.jsp">
			<select name="key">
					<option value="faddress"> 주소 </option> 	<!-- key = 필드명 -->
					<option value="fname"> 가맹점명 </option>
			</select>
			<input id = "inputbox" type="text" name="keyword"> 
			<input id ="sbtn" type="submit" value="검색">
			</form>
		</div>
		
		<!-- ---가맹점 출력------>
		
		<div style="overflow:auto;  width: 500px; height: 500px; margin: 0 auto;">
			<table class="table" >
				<tr>
					<th style=" width: 50px;">번호</th><th style=" width: 100px;">가맹점명</th><th>주소</th>
				</tr>
				<%
				int totalrow = FranchiseeDao.getfranchiseeDao().gettotallist(key, keyword);
				int startrow = 0;
				int listsize = totalrow;
				ArrayList<Franchisee> franchiseelist = FranchiseeDao.getfranchiseeDao().getfranchiseelist(startrow , listsize ,key,keyword);
				
				if(key.equals("") && keyword.equals("")){
					if(franchiseelist.size()<6){
						for( int i =0; i<franchiseelist.size(); i++ ){ 
							%>
					
							<tr  onClick="location.href='findstoreview.jsp?faddress=<%=franchiseelist.get(i).getFaddress()%>'">
							
								<td><%=franchiseelist.get(i).getFnum()%></td><td><%=franchiseelist.get(i).getFname()%></td><td><%=franchiseelist.get(i).getFaddress()%></td>
							
							</tr>
						<%} 
					}
					else{
					for( int i =0; i<6; i++ ){ 
					%>
			
					<tr  onClick="location.href='findstoreview.jsp?faddress=<%=franchiseelist.get(i).getFaddress()%>'">
					
						<td><%=franchiseelist.get(i).getFnum()%></td><td><%=franchiseelist.get(i).getFname()%></td><td><%=franchiseelist.get(i).getFaddress()%></td>
					
					</tr>
					<%} }
				}else{
				for( int i =0; i<franchiseelist.size(); i++ ){ 
				%>
		
				<tr  onClick="location.href='findstoreview.jsp?faddress=<%=franchiseelist.get(i).getFaddress()%>'">
				
					<td><%=franchiseelist.get(i).getFnum()%></td><td><%=franchiseelist.get(i).getFname()%></td><td><%=franchiseelist.get(i).getFaddress()%></td>
				
				</tr>
				<%} }%>
			</table>
		</div>
		</div>
	</div>
	
</body>
</html>