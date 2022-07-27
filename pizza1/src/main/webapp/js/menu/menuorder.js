//	js 에서 사용되는 웹소켓 클래스( ws:// IP번호/PORT번호/프로젝트명/서버소켓이름 )
	let mnum2 = $("#mnum2").val();
	let fnum2 = $("#fnum2").val();
start();
var today = new Date();

var year = today.getFullYear();
var month = ('0' + (today.getMonth() + 1)).slice(-2);
var day = ('0' + today.getDate()).slice(-2);
var hours = ('0' + today.getHours()).slice(-2); 
var minutes = ('0' + today.getMinutes()).slice(-2);
var seconds = ('0' + today.getSeconds()).slice(-2); 

var dateString = year + '-' + month  + '-' + day + " " + hours + ':' + minutes  + ':' + seconds;
//alert(dateString);



function start(){
	
	
	websocket = new WebSocket("ws://localhost:8080/pizza1/alert/"+mnum2+"/"+fnum2);
	websocket.onopen = function( e ){ onOpen(e) }
	websocket.onmessage = function( e ){ onmessage(e) }
	websocket.onclose = function( e ){ onclose(e) }
	websocket.onerror = function( e ){ onerror(e) }
}

function onclose( e ){ alert("소켓을 나갑니다.") + e;   }

function onerror( e ){ alert("서버소켓 오류 입니다." + e );  }

function onOpen( e ){
	//alert("서버소켓으로 들어갑니다~ : "+ e );
	//console.log( e );
}
function onmessage( e ){
		let msg = JSON.parse( e.data );	 // 문자열 -> json
		let from = msg["from"];	// json 키를 통한 value 호출
		let content = msg["content"];	// json 키를 통한 value 호출
		let date = msg["date"];	// json 키를 통한 value 호출
		let to = msg["to"];
		let amount = msg["amount"];
		let size = msg["size"];
		let edge = msg["edge"];
		let topping = msg["topping"];
		let address = msg["address"];
		let phone = msg["phone"];
		let request = msg["request"];
		let oonum = msg["odernum"];
		let odetailnum = msg["odetailnum"];
		let oonum2 = Number(oonum);
		let html = $("#contentbox").html();	// 기존 html 가져오기
			if(fnum2 == to){ // 소켓에있는가맹점의 fnum과 주문한곳의 fnum이 같으면
					// 목록출력(가맹점 별 알림이 달라야함)
			html +=	// 기존 html 추가 
				'<div> '+
						'	<div>	 '+
								'<div> 주문번호 : '+oonum+' </div>'+
								'<div><span> 메뉴: '+content+' </span></div>'+
								'<div><span> 수량 : '+amount+' </span></div>'+
						
								'<div><span> 주소 : '+address+' </span></div>'+
								'<div><span> 전화번호 : '+phone+' </span></div>'+
								'<div><span> 요청사항  :'+request+' </span></div>'+
								'<div><span> 주문시간 : '+date+' </span></div>'+
								'<button type = "button" class="'+oonum2+'" onclick ="changealert()">접수확인</button>'+
							'</div>'+
					'</div>';
				
			}
			if(fnum2 == to){
				alert("주문확인")
			}
		$("#contentbox").html( html ); // 추가된 html 넣어주기
}


//////////////////소켓

let pay_method;
function payment(){
	if(pay_method == null){
		alert("결제수단을 선택해주세요");
		return;
	}
	alert($("#f_address").html());
	var IMP = window.IMP; 
	IMP.init("imp35631338"); 
    IMP.request_pay({ 
	    pg: "html5_inicis",	
	    pay_method: pay_method,	// 결제방식
	    merchant_uid: "ORD20180131-0000011", // 주문번호[별도]
	    name: "PIZZA HOOT", // 결제창에 나오는 결제이름
	    amount: $("#totalp").html(),	// 결제금액
	    buyer_tel: $("#mphone").val(),
	    buyer_addr: $("#f_address").val(),
		  }, function (rsp) { // callback
		      if (rsp.success) { // 결제 성공했을때 -> 주문 완료 페이지로 이동 []
		      } else {
			sorder();
				alert("주문!");
				 // 결제 실패 했을때 -> 테스트 할시에는 이부분 활용
		      }
	  });
}

function sorder(){
	let orderjson = {	// 객체화 
		orderfnum : frnum  ,
		orderphone : $("#mphone").val() , 
		orderaddress : $("#f_address").html() ,
		ordertotalpay : $("#totalp").html() , 
		orderrequest : $("#textarea").val(),
		odelivery : odelivery,
		couponnum: couponnum
	}
	$.ajax({
		url : "/pizza1/order/saveorder",		
		data : { 'orderjson' : JSON.stringify(orderjson),'date':dateString } , // 객체 -> json형 변환
		async: false,
		success : function( onum ){
			//alert("num값" + onum)
			//alert("DB처리 성공")
		 ordernum = onum;
		$.ajax({
		url : "/pizza1/alert/Alert2",
		data : {"onum" : ordernum} ,
		async: false,
		success : function(re) {
			let ajson = re
			console.log(ajson[0].mnum)
			for(let i = 0; i<re.length; i++ ){
								let msg = { // js 객체화  // 객체명 = {  속성명(key) : 값(value) , 속성명(key) : 값(value)   }
		odernum : ajson[i].onum , 		// 문자전송 , 접속자명단 구분용 
		from :ajson[0].mnum , 		
		to : ajson[0].fnum , //  알림보낼곳(가맹점번호(ordernum)) => 주문db에서 빼오묜될듯?
		content : ajson[i].omenunum, 		// 채팅내용
		amount : ajson[i].oamount,
		size : ajson[i].osize,
		edge : ajson[i].oedge,
		topping : ajson[i].otopping1+","+ajson[i].otopping2 ,
		address : ajson[0].oaddress,
		phone : ajson[0].ophone,
		request : ajson[0].orequest,
		date : dateString,// 채팅 보낸 시간,
		odetailnum : ajson[i].odetailnum
	}
		websocket.send(  JSON.stringify(msg)  ); // json -> 문자열
		location.href="/pizza1/info/myorder.jsp";
			}

			
		}
	})	 
		//let testt = 29;
		

	
		}
	});
	



	
}
  
function paymethod( method ){
	$("#paymethod").val( method );
	$("#pay1").css({"color":"", "background-color":"","border":""} );
	$("#pay2").css({"color":"", "background-color":"","border":""} );
	$("#pay3").css({"color":"", "background-color":"","border":""} );
	$("#pay4").css({"color":"", "background-color":"","border":""} );
	$("#pay5").css({"color":"", "background-color":"","border":""} );
	$("."+method).css( {"color":"white", "background-color":"red","border":"none"} ); 
	pay_method = method; // 결제수단 변수에 인수 넣기
}
  
function noEvent() {    
if (event.keyCode == 116) {       
	 event.keyCode= 2;        return false;    }    
	 else if(event.ctrlKey && (event.keyCode==78 || event.keyCode == 82))    
	 {        return false;    }}document.onkeydown = noEvent;
	 
	 

   
let json;
let jsoncart;
let f_address;
let deliverypay;
let dt;
let odelivery=null;
let fnum;
let frnum;
let dc=0;
let couponnum=0;
let sumprice = 0;;
let totalp=0;
$(function(){
	
	f_address =localStorage.getItem('f_address');
	dt =localStorage.getItem('dt');
	fnum =localStorage.getItem('fnum');
	
	$("#f_address").html(f_address);
	
	
	if(dt==2){
		$("#delivery").html(0);
		odelivery="포장";
	}else{
		$("#delivery").html(3000);
		odelivery="배달";
	}
	
	getf(fnum);
	
	
	getcart();
	
	selcoupon();
	
	localStorage.clear(f_address);
	localStorage.clear(deliverypay);
	localStorage.clear(dt);
	localStorage.clear(fnum);
});


function getf(fnum){
	frnum=fnum;
	$.ajax({
		url:"/pizza1/order/getflist",
		data: {"fnum" : fnum},
		async: false,
		success: function(re){
			json=re;
			let html="";
			for(let i=0; i<json.length; i++){
				let faddress = json[i]["faddress"].split("_");
				html += '<div class ="lbl"><label>'+json[i]["fname"]+'</label></div>'+
					'<div class="inputarea ">'+
					'<div>'+faddress[1]+" "+faddress[3]+'</div>'+
					'</div>';
			}
			$("#fbox").html(html);
		}
	});
}

function getcart(){
	$.ajax({
		url: "/pizza1/order/getcart",
		async: false,
		success: function(re){
			jsoncart =re
			tableview();
		}
	});
}

function tableview(){
	let dp=parseInt($("#delivery").html());
			 let t = parseInt($("#total").text());
			for( let i = 0 ; i<jsoncart.length; i++ ){
				sumprice += jsoncart[i]["totalprice"]; 
			}
			totalp = dp+sumprice;
			$("#total").html(sumprice);
			$("#totalp").html(totalp);
}


function selcoupon(){

    $("#sel").change(function() {
		 dc = parseInt($("#sel > option:selected").val()); 
		 couponnum = $("#sel > option:selected").attr("value2"); 
		 let dp=parseInt($("#delivery").html());
		 
		 let t = parseInt($("#total").text());
		 let dcprice = (t/100)*dc;
		 $("#dcprice").html(dcprice);
		 totalp = t-(parseInt(dcprice))+dp;
		$("#totalp").html(totalp);
    });

}
	function changealert(){
		var newWindow = window.open("about:blank");
		newWindow.location.href  ="/pizza1/alert/Orderlist.jsp"
		
	}		





