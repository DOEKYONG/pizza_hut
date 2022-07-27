<%@page import="dto.Subpizza"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MenuDao"%>
<%@page import="dto.Menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/pizza1/CSS/menu/menuview.css">
</head>
<body>
<%@include file ="../header.jsp" %>
		<%@include file ="menubar.jsp" %>
<div class="container1">
	<div class="menuview_wrap">

	
	
		<div class="menu_box">
			<div class="img_area">
			
			
				<%
				int menunum3 = Integer.parseInt(request.getParameter("menunum"));
				Menu menu3= MenuDao.getmemberDao().getmenuview(menunum3);
				ArrayList<Subpizza> getsubpizza3 = MenuDao.getmemberDao().getsubpizza(menunum3);
				ArrayList<Menu> gettopping3 = MenuDao.getmemberDao().gettopping();
				%>
				
				
				<img alt="" src="/pizza1/admin/menuimg/<%=menu3.getMenuimg()%>">
					<div class="size_area">
					<ul>
					<%for(Subpizza temp: getsubpizza3){
							if(temp.getSubsize()!=null){%>
						<li>
						<input type="hidden" id="menuprice" value="<%=menu3.getMenuprice() %>" >
						
						</li>
						<%}} %>
					</ul>
				</div>
				
					<div class="count_area">
					<div class="count_area1">
						<button type="button" onclick="minus()" class="count minus">-</button>
						<input type="text" id="count" value="1" readonly="readonly">
						<button type="button" onclick="plus()" class="count plus">+</button>
					</div>	
				</div>
				
				
			
			</div>
		
			<div class="menu_ifno">
				<div class="menu_text">
					<h3><%=menu3.getMenuname()%></h3>
					<h4><%=menu3.getMenucontent()%></h4>
				</div>
			
				<div>
					<div style="display: none;">결제액: <span id="totalprice"><%=menu3.getMenuprice() %></span>원</div>
					<div>총금액: <span id="mtotal"><%=menu3.getMenuprice() %></span>원</div>
				</div>
				<div class="button_area">
					<div class="button_area1" >
						<button class="order" type="button" onclick="cart(<%=menunum3%>)">장바구니</button>
						<button class="order"  type="button" onclick="order(<%=menunum3%>)">주문하기</button>
					
					</div>
				
				
				</div>
			</div>
		
		
		
		</div>
	
	
	

	
	
	
	
	
	</div>

</div>




	<%@include file ="../footer.jsp" %>
	
	
	<div class="modal" id="myModal">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">매장찾기</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body tabletr">
        	<table class="table table-borderless" id="table">
        		
        	</table>
        	<div class="tableresult">
	        	<div class="table table-hover" id="tableresult">
	        		
	        	</div>
        	</div>
      </div>
    </div>
  </div>
</div>
		<%@include file ="../footer.jsp" %>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/pizza1/js/menu/submenuview.js"></script>
</body>
</html>