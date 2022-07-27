<%@page import="dto.Menu"%>
<%@page import="dao.MenuDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 사용자정의 css --> <link href="/pizza1/CSS/adminevent.css" rel="stylesheet"> 	
<!-- 부트스트랩 css cdn -->  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>

	<%@include file="dashboard.jsp"%>
	
	<div class="event">
		<div class="row">
			<div>
				<a href="addmenu.jsp"><button class="addmenubtn">메뉴추가</button></a>
			</div>
			<div>
				<table id="menutable" class="table">
					<tr>
						<th>메뉴번호</th>	<th>대표이미지</th> 	<th>메뉴명</th> 		<th>가격</th><th>비고</th>		
					</tr>
					<%
						ArrayList<Menu> menulist  = MenuDao.getmemberDao().getmenulist();
						for( Menu menu : menulist  ){ // 모든 제품 반복문
							
					%>
						<tr>
							<td><%=menu.getMenunum() %></td>		<td><img width="30%" src="/pizza1/admin/menuimg/<%=menu.getMenuimg()%>"></td> 	
							<td><%=menu.getMenuname() %></td> 	<td><%=menu.getMenuprice()%></td>
							
							
							<td> 
								<button class="menubtn" type="button" onclick="deletemenu(<%=menu.getMenunum() %>)">메뉴 삭제</button> 
								<a href="menuupdate.jsp?menunum=<%=menu.getMenunum() %>"><button  type="button"  class="menubtn">메뉴 수정</button></a> <br><br>
								<button  type="button"  class="menubtn" onclick="size(<%=menu.getMenunum() %>)" data-bs-toggle="modal" data-bs-target="#size">사이즈 변경</button>
								<button   type="button" class="menubtn" onclick="edge(<%=menu.getMenunum() %>)" data-bs-toggle="modal" data-bs-target="#edge" >엣지 변경</button> 
							</td>
						</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>
	
	
	<div class="modal" tabindex="-1" id="size">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">  <!-- 모달 제목 -->
	        <h5 class="modal-title"> 사이즈 추가 및 변경 </h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">  <!-- 모달 내용  -->
	       <input type="hidden" id="modelinput">
	       <table class="table">
	      		<tr id="updatesize">
	      			<th>사이즈 : <input type="text" id="sizeadd"><br>
	      				가격: <input type="text" id="sizeprice">
	      				<button type="button" onclick="sizeadd()">추가</button>
	      			</th>
	      		</tr>
	      	</table>
	      	<table class="table" id="sizelistbox">
		      		
		      </table>
	      </div>
	      <div class="modal-footer"> <!-- 모달 버튼 -->
	      
	        	<button id="modalclosebtn2" type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 재고변경 - 모달구역  -->
	<div class="modal" tabindex="-1" id="edge">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">  <!-- 모달 제목 -->
	        <h5 class="modal-title"> 엣지 추가 및 변경 </h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	    	<div class="modal-body">
    		<div  id="edgefor">
		      <form id="edgeform">
			      	<table class="table">
				      		<tr>	
				      			<th id="updateedge">
					      			<input type="hidden" id="modelinput2" name="menunum">
					      			엣지 : <input type="text" id="edgeadd" name="edgeadd"><br>
					      			가격: <input type="text" id="edgeprice" name="edgeprice"><br>
					      			이미지: <input type="file" id="edgeimg" name="edgeimg">
					      			<button type="button" onclick="ed()">추가</button>
				      			</th>
				      		</tr>
			      	</table>
			    </form>
			    </div>
				<table class="table" id="edgelistbox">
		      		
		      	</table>
		      	
	      </div>
	    </div>
	  </div>
	</div>
	
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="/pizza1/js/menu.js" type="text/javascript"></script>
</body>
</html>