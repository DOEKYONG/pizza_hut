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
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<link rel="stylesheet" type="text/css" href="/pizza1/CSS/findstore.css">

</head>
<body>
<%@include file="../header.jsp"%>
	
	<div class="container">
		<div>
			<%@include file="findmap.jsp"%>
		</div>
		<div>
			<%
			ArrayList<Franchisee>getfranchisee = FranchiseeDao.franchiseeDao.getfranchisee();
			if(getfranchisee!=null){
			for(int i=0; i<1; i++){
			Franchisee franchisee = FranchiseeDao.getfranchiseeDao().get(getfranchisee.get(i).getFnum(), getfranchisee.get(i).getOrdernum());
			String faddress = franchisee.getFaddress();
			String [] address = faddress.split("_");
			%>
			
			
				<input type="hidden" id="address" value="<%=address[1]%>">
				<%}} %>
				<p style="margin-top:-12px">
		    	<em class="link">
		        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
		            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
		        </a>
		    	</em>
			</p>
			<div id="map" style="width:800px;height:500px;"></div>
			
			</div>
		</div>
	<%@include file="../footer.jsp"%>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9c424c189065e3645cb11db635aea0d5&libraries=services"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="/pizza1/js/map.js"></script>
	
	
</body>
</html>