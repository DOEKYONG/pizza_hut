<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dao.FranchiseeDao"%>
<%@page import="dto.Event"%>
<%@page import="dao.EventDao"%>
<%@page import="dto.Couponlist"%>
<%@page import="dto.Subpizza"%>
<%@page import="dao.MenuDao"%>
<%@page import="dto.Menu"%>
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
<link rel="stylesheet" type="text/css" href="/pizza1/CSS/menu/menuorder.css">
<link rel="stylesheet" type="text/css" href="/pizza1/CSS/menu/cart.css">

</head>
<body>
<%@include file ="../header.jsp" %>
  <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	
	<% 	String mid = (String)session.getAttribute("login");
	int mnum = MemberDao.getmemberDao().getmnum(mid);

	
	int fnum = (Integer)session.getAttribute("fnum");
	ArrayList<Cart>getcarts = OrderDao.getorderDao().getcarts(mnum);
	
%>
<input type="hidden" value="<%=mnum%>" id="mnum2">
<input type="hidden" value="<%=fnum%>" id="fnum2">
	<div class="container1">
		<div class="menuorder_wrap">
			<div class="order_info">
			<h1>결제 페이지</h1>
			<div class="deco">
				<h2>배달정보</h2>
			</div>
				
		
		<div class="form_phone">
			<div class ="lbl"><label>휴대폰</label></div>
			<div class="inputarea"> <input class="info_text" type="text"id="mphone" name="mphone"></div>
			
		</div>
		
			
		<div class="form_phone ">
			<div class ="lbl"><label>주소</label></div>
		<div class="inputarea">
				<div id="f_address">경기 안산시 상록구 성포동 592-2 현대1차 상가</div>
			</div>
			
		</div>
		
		
		
		<div class="box_info" id="fbox">
		
			<div class ="lbl"><label>안산 성포점</label></div>
			<div class="inputarea">
				<div>경기 안산시 상록구 성포동 592-2 현대1차 상가</div>
			</div>
		</div>
		
		<div class="form_phone address">
		<div class ="lbl"><label>배달요청사항</label></div>
		<div class="inputarea"> <input class="info_text" id="textarea"></div>
		</div>
		
		<div class="deco">
				<h2>주문내역</h2>
			</div>
		<%for(int i=0; i<getcarts.size();i++){
				Menu menu = MenuDao.getmemberDao().getmenuview(getcarts.get(i).getMenunum());
				Menu topping1 = MenuDao.getmemberDao().getmenuview(getcarts.get(i).getTopping1());
				Menu topping2 = MenuDao.getmemberDao().getmenuview(getcarts.get(i).getTopping2());
				Subpizza size = MenuDao.getmemberDao().subpizza(getcarts.get(i).getSizenum());
				Subpizza edge= MenuDao.getmemberDao().subpizza(getcarts.get(i).getEdgenum());
				%>
		<div  id="carttable">
		<div class="menu_boxorder">
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
					<span id="totalprice"><%=getcarts.get(i).getTotalprice()%></span><span>원</span>
				</div>
				
				
			</div>
		</div>	
			<%} %>
			<div class="cuppon_wrap">
			
			<div class ="lbl"><label>쿠폰</label></div>
			<div class="inputarea"> 
				<select class="cuuponsel" id="sel" name="sel">
				<%ArrayList<Couponlist>mycoupon = EventDao.geteventDao().getmycouponlist(mnum, "사용전");%>
				<option>선택없음</option>
					<%Date date= new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
					String today=dateFormat.format(date);
					System.out.print(today);
					if(mycoupon!=null){
					for(Couponlist couponlist: mycoupon){
						Event event= EventDao.geteventDao().getevent2(couponlist.getEventnum(),today);
						if(event!=null){
					
					%>
					<option value="<%=event.getDiscount()%>" value2="<%=couponlist.getEventnum()%>"><%=event.getDiscount()%>% 할인(~<%=event.getEventend()%>)</option>
				<%}}}else{ %>
					
				<%} %>
				</select>
			</div>
			
			
			</div>
			
			<div class="pay_wrap"> 
			<div class="deco">
				<h2>결제수단</h2>
			</div>
				
				<div class="payb_area">
								<button onclick="paymethod('samsung')" id="pay1" class="samsung"> 삼성페이 </button>
								<button onclick="paymethod('card')" id="pay2"  class="card"> 카드 </button>
								<button onclick="paymethod('trans')" id="pay3"  class="trans"> 계좌이체 </button>
								<button onclick="paymethod('vbank')" id="pay4"  class="vbank"> 무통장 </button>
								<button onclick="paymethod('phone')" id="pay5"  class="phone"> 핸드폰 </button>
							</div>
				
				
			
			</div>
			
			<div class="deco">
				<h2>결제금액</h2>
			</div>
			<div class="price_area">
						<div>
							<p>총금액</p>
							<p><span id="total">37,900</span>원</p>
						</div>
						
						<div><p>-</p></div>
					
					<div>
						<p>할인금액</p>
						<p><span id="dcprice">0</span>원</p>
					</div>
					
					<div><p>+</p></div>
					
					<div>
							<p>배달비</p>
							<p><span id="delivery">0</span>원</p>
						</div>
				
			
			
			</div>
			<div class="bottom_area" onclick="payment()">
					<h2><span id="totalp">0</span>원 결제 </h2>
				
				</div>		
			
			</div>
		
		</div>
	
	
	
	</div>
	<%@include file ="../footer.jsp" %>
<script src="/pizza1/js/menu/menuorder.js" type="text/javascript"></script>
</body>
</html>