<%@page import="dto.Menu"%>
<%@page import="dao.MenuDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 css cdn -->  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>

	<%@include file="dashboard.jsp"%>
	
	<%
			int menunum = Integer.parseInt(request.getParameter("menunum"));
			Menu menu =  MenuDao.getmemberDao().getmenuview(menunum);
		%>
	
	<div class="container">
		<div class="row">
			<form id="updatemenu">
				<div>
					<a href="menulist.jsp"><button>목록보기</button></a>
				</div>
				<div>
					<input type="hidden" id="menunum" name="menunum" value="<%=menu.getMenunum() %>">
					<input type="text" id="menuname" name="menuname" value="<%=menu.getMenuname()%>"> 
				</div>
				<div>
					<textarea rows="10" cols="40" id="menucontent" name="menucontent"><%=menu.getMenuname()%></textarea>
				</div>
				<div>
					<input type="text" placeholder="가격" id="menuprice" name="menuprice" value="<%=menu.getMenuprice()%>"> 
				</div>
				<div>
					카테고리: <button onclick="categorybtn()" type="button" >추가</button> 
				</div>
					<div  id="categoryinput">
					</div>
				<div>
					<div id="categorybox"> </div>
				</div>
				<div>
					<input type="hidden" id="oldmenuimg" name="oldmenuimg" value="<%=menu.getMenuimg() %>">
					<input type="file" id="menuimg" name="menuimg" value="<%=menu.getMenuimg() %>">
				</div>
				<div>
					<button type="button" onclick="menuupdate()">메뉴 등록</button>
					<input type="reset" value="초기화">
				</div>
				<div>
					<img id="preview" width="100%">
				</div>
			</form>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="/pizza1/js/menu.js" type="text/javascript"></script>
		
	
</body>
</html>