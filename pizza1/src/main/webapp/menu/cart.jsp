<%@page import="dto.Subpizza"%>
<%@page import="dto.Menu"%>
<%@page import="dao.MenuDao"%>
<%@page import="dto.Cart"%>
<%@page import="dao.OrderDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/pizza1/CSS/menu/cart.css">
</head>
<body>

<%@include file ="../header.jsp" %>

<% 	String mid = (String)session.getAttribute("login");
	int mnum = MemberDao.getmemberDao().getmnum(mid);
	ArrayList<Cart>getcarts = OrderDao.getorderDao().getcarts(mnum);
%>
<div class="container1">
	
	<div class="cart_wrap">
		<div class="cart_info">
			<h1>장바구니</h1>
		
		
		<h3>주문정보</h3>
		<div class="menu_info">
			<%for(int i=0; i<getcarts.size();i++){
				Menu menu = MenuDao.getmemberDao().getmenuview(getcarts.get(i).getMenunum());
				Menu topping1 = MenuDao.getmemberDao().getmenuview(getcarts.get(i).getTopping1());
				Menu topping2 = MenuDao.getmemberDao().getmenuview(getcarts.get(i).getTopping2());
				Subpizza size = MenuDao.getmemberDao().subpizza(getcarts.get(i).getSizenum());
				Subpizza edge= MenuDao.getmemberDao().subpizza(getcarts.get(i).getEdgenum());
				%>
			
			<div class="menu_box">
				<div class="img_area">
					<img src="/pizza1/admin/menuimg/<%=menu.getMenuimg()%>">
				</div>
				
				<div class="info_area">
					<div class="menu_name">
						<div class="name">
							<%=menu.getMenuname()%>
							<%if(size!=null){ %>
							(<%=size.getSubsize()%>) 
							<%}else{ %>
							<%} %>
						</div>
						<div class="edge">
							<%if(edge!=null){ %>
							<span class="edge_n"> 엣지 </span> <span class="option"><%=edge.getSubedge()%>(+<%=edge.getSubprice()%>원)</span>
							<%}else{ %>
							<%} %>
						</div>
						<div class="edge">
						<%if(topping2!=null){ %>
						<div> <span class="edge_n"> 토핑</span> <%=topping1.getMenuname()%>(+<%=topping1.getMenuprice()%>원) <p><%=topping2.getMenuname()%>(+<%=topping2.getMenuprice()%>원)</p>	</div>
						<%}else if(topping1!=null){ %>
						<div> <span class="edge_n"> 토핑</span> <%=topping1.getMenuname()%>(+<%=topping1.getMenuprice()%>원)</div>
						<%}else{ %>
						<%} %>
						</div>
					</div>
				</div>
				
				<div class="price">
					<span id="price"><%=getcarts.get(i).getTotalprice()%></span>원<span><button type="button" style="border: none; background-color: rgba(0,0,0,0);"onclick="cartdelete(<%=getcarts.get(i).getCartno()%>)"><i class="far fa-trash-alt"></i></button></span>
				</div>
			</div>
			<% }%>
			<div class="cart_price">
			<div class="box">
				<div class="top_area">
					<h4 class="ptitle">결제</h4>
					
					<div class="row">
						<div>총 합계금액</div> <div id="total">37,900원</div>
					</div>
					
				</div>
				<!-- modal 구동 버튼 (trigger) -->
			<button type="button" style="border: none; background-color: red;" class="btn btn-primary bottom_area" data-bs-toggle="modal" data-bs-target="#myModal">
				    <div class="">
										<h2>주문하기</h2>
					</div>
  			</button>
		
			
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
<script src="/pizza1/js/menu/cart.js" type="text/javascript"></script>
</body>
</html>