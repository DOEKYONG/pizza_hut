let sumprice = 0; //상품 총가격 변수 선언 
let deliverypay = 0; // 배송비 변수 선언 
let totalpay = 0; // 총주문액 변수 선언 
let caddress;
let jsoncart;
let fname;
let findaddress;
let fing;
let dt;
let detailaddress;
let f_address;

$(function(){
	
	delivery();
	$("#f_address").html(f_address);
});
function cartdelete(cnum){
	alert(cnum);
	$.ajax({
		url: "/pizza1/order/cartldelete",
		data: {"cnum": cnum},
		success: function(re){
			location.reload();
		}
	});
}

let json;
$( function(){  
	$.ajax({
		url: "/pizza1/order/getcart",
		success: function(re){
			json =re
			tableview();
		}
	});
});

function tableview(){
	sumprice = 0; /*상품 총가격 */
			deliverypay = 0; // 배송비 
			totalpay = 0; // 총주문액 
			
			for( let i = 0 ; i<json.length; i++ ){
				sumprice += json[i]["totalprice"]; 
			}
			$("#total").html('<div id="total">'+sumprice+'</div>');
}


let jsonar;

window.onload = function(){
    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address_kakao").value = data.address; // 주소 넣기
                document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱
               	let address = data.address.split(' ')
                findaddress = address[0]+  " " + address[1]+  " " +address[2];
			        $.ajax({
							url: "/pizza1/order/findaddress",
							data: {"findaddress":findaddress},
							success: function(re){
								jsonar=re;
								let tr ="";
								if(jsonar==""){
									tr='<div><div class="nonedelivery"> 배달 가능한 매장이 존재하지않습니다.</div></div>'
								}
								else{
									dt=1;
									for(let i=0; i<jsonar.length; i++){
										let faddress = jsonar[i]["faddress"].split("_");
										if(jsonar[i]["otime"]=="1"){
										tr+=
												
										        	'<div id="findstore" class="row findstore" onclick="addstore('+jsonar[i]["fnum"]+')">'+
										        	'<div class="col-md-4">'+jsonar[i]["fname"]+'</div><div class="col-md-8">'+faddress[1]+" "+faddress[3]+'</div>'+
	        										'	</div>';
	        							}
	        							else{
										tr+=
												
										        	'<div id="findstore" class="row findstore" onclick="endstore()">'+
										        	'<div class="col-md-4">'+jsonar[i]["fname"]+'</div><div class="col-md-8">'+faddress[1]+" "+faddress[3]+'</div>'+
	        										'	</div>';
	}
									}
								}
								$("#tableresult").html(tr);
							}
						});
            }
        }).open();
        
        
        
    });
}

function endstore(){
	alert("영업시간이 종료되었습니다.");
}

function addstore(fnum){
	detailaddress = $("#detailaddress").val();
	if(detailaddress==""){alert("상세주소를 입력해주세요");}
	else{
		
		$("#total").text();
		location.href="/pizza1/menu/menuorder.jsp";
		f_address = findaddress+" "+detailaddress;
		
		if(dt==2){
			f_address="";
		}
		alert(f_address);
		localStorage.setItem('f_address', f_address);
		localStorage.setItem('dt', dt);
		localStorage.setItem('fnum', fnum);
	}
}


function delivery(){
	$("#tableresult").html("");
	$("#table").html(
			'<tr>'+
        	'		<td class="delivery" id="delivery" onclick="delivery()">배달</td><td  id="takeout"  class="delivery" onclick="takeout()">포장</td>'+
        	'	</tr>'+
			'<tr id="table">'+
        	'		<th colspan="2"><input class="주소input" type="text" id="address_kakao" name="address" placeholder="도로명 혹은 지번주소를 입력해주세요" readonly></th>'+
        	'	</tr>'+
        	'	<tr class="상세주소">'+
            '		<th  colspan="2"><input class="상세주소input" id="detailaddress" type="text" name="address_detail"  placeholder="상세주소를 입력해주세요"></th>'+
        	'	</tr>'
	);
	$("#delivery").css({
		 "border-bottom": "1px solid red"
	});
	
	
}

function takeout(){
	$("#tableresult").html("");
	$("#table").html(
			'<tr>'+
        	'		<td class="delivery" id="delivery" onclick="delivery()">배달</td><td  id="takeout"  class="delivery" onclick="takeout()">포장</td>'+
        	'	</tr>'+
			'<tr id="table">'+
        	'		<th colspan="2" class="searchcontainer"><input class="포장input" type="text" id="seachstore" name="address" placeholder="지역명 혹은 매장명을 입력해주세요"><button type="button" onclick="search()" class="searchbtn"><i class="fa fa-search"></i></button></th>'+
        	'	</tr>'
	);
	$("#takeout").css({
		 "border-bottom": "1px solid red"
	});
}

function search(){
	let searchinput = $("#seachstore").val();
	 $.ajax({
							url: "/pizza1/order/findaddress2",
							data: {"findaddress":searchinput},
							success: function(re){
								jsonar=re;
								let tr ="";
								if(jsonar==""){
									tr='<div><div class="nonedelivery"> 배달 가능한 매장이 존재하지않습니다.</div></div>'
								}
								else{
									dt=2;
									for(let i=0; i<jsonar.length; i++){
										let faddress = jsonar[i]["faddress"].split("_");
										if(jsonar[i]["otime"]=="1"){
										tr+=
												
										        	'<button class="findstorebtn" type="button" onclick="addstore('+jsonar[i]["fnum"]+')">'+
										        	'<span>'+jsonar[i]["fname"]+'</span><br><span>'+faddress[1]+" "+faddress[3]+'</span>'+
	        										'</button>';
	        							}
	        							else{
										tr+=
	        										'<button class="findstorebtn" type="button" onclick="endstore())">'+
										        	'<span>'+jsonar[i]["fname"]+'</span><br><span>'+faddress[1]+" "+faddress[3]+'</span>'+
	        										'</button>';
	}
									}
								}
								$("#tableresult").html(tr);
							}
						});
}


