<%@page import="dto.Subpizza"%>
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
				int menunum4 = Integer.parseInt(request.getParameter("menunum"));
				Menu menu4= MenuDao.getmemberDao().getmenuview(menunum4);
				ArrayList<Subpizza> getsubpizza4 = MenuDao.getmemberDao().getsubpizza(menunum4);
				ArrayList<Menu> gettopping4 = MenuDao.getmemberDao().gettopping();
				%>
				
				
				<img alt="" src="/pizza1/admin/menuimg/<%=menu4.getMenuimg()%>">
					<div class="size_area">
					<ul>
					<%for(Subpizza temp: getsubpizza4){
							if(temp.getSubsize()!=null){%>
						<li>
						<input type="hidden" id="menuprice" value="<%=menu4.getMenuprice() %>" >
							<div class="sizebox">
								<div>
									<input type="radio" name="size" value="<%=temp.getSubnum()%>">
								</div>
								<div class="size_info">
							<span id="size"><%=temp.getSubsize()%></span>
							<div><span id="sizeprice"><%=temp.getSubprice()+menu4.getMenuprice()%></span>원</div>
							</div>
							</div>
						
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
					<h3><%=menu4.getMenuname()%></h3>
					<h4><%=menu4.getMenucontent()%></h4>
				</div>
			
				<div class="edge_area">
					<h3 class="edge_title">엣지</h3>
					<ul>
					<%for(Subpizza temp: getsubpizza4){ 
					if(temp.getSubedge()!=null){%>
						<li>
							<div class="imgrb">
								<div><img  src="/pizza1/admin/menuimg/<%=temp.getSubedgeimg()%>"></div>
								<p><%=temp.getSubedge()%></p>
								+<%=temp.getSubprice()%>원
								<input id="edge" class="edge" type = "radio" name="edge"  value ="<%=temp.getSubnum()%>"  >
							</div>
						</li>
						<%}} %>
					</ul>
				
				</div>
				
				<div class="edge_area">
				<h3 class="edge_title">토핑</h3>
					<ul>
					<%for(Menu temp: gettopping4){ %>
						<li>
							<div class="imgrb">
								<div><img  src="/pizza1/admin/menuimg/<%=temp.getMenuimg()%>"></div>
								<p><%=temp.getMenuname()%></p>
								<p>+<%=temp.getMenuprice()%>원</p>
								<input id="topping<%=temp.getMenunum() %>" onclick="topping(<%=temp.getMenunum()%>)" class="edge" type="checkbox" name="topping"  value = "<%=temp.getMenuprice()%>" >
							</div>
						</li>
					<%} %>
					</ul>
				
				</div>
				<div>
					<div style="display: none;">결제액: <span id="totalprice">0</span>원</div>
					<div>총금액: <span id="mtotal">0</span>원</div>
				</div>
				<div class="button_area">
					<div class="button_area1" >
						<button class="order" type="button" onclick="cart(<%=menunum4%>)">장바구니</button>
						<button class="order"  type="button" onclick="order(<%=menunum4%>)">주문하기</button>
					
					</div>
				
				
				</div>
			</div>
		
		
		
		</div>
	
	
	

	
	
	
	
	
	</div>

</div>
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
	<script type="text/javascript" src="/pizza1/js/menu/menuview.js"></script>

</body>
</html>