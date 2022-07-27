let fnum = $("#fnum2").val();
let mnum = $("#mnum2").val();
start()
let list;
let parentlist;

getlist();



function start(){
	//	js 에서 사용되는 웹소켓 클래스( ws:// IP번호/PORT번호/프로젝트명/서버소켓이름 )
	let mnum2 = $("#mnum2").val();
	let fnum2 = $("#fnum2").val();
	
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
function onmessage( e ){getlist();}
function getlist() {
	$.ajax({
	url : "/pizza1/alert/Getorderlist",
	data : {"fnum" : fnum},
	async :false,
	success : function(re) {
		list = re;
		parentlist = re;
		let html ='';
		for(let i=0; i< re.length; i++) {
			html += '<div class="obox" >'+
				'<div> <span>주문번호 : </span>'+re[i][0]["onum"]+'</div>';
			for( let j = 0; j<parentlist[i].length; j++) {
						html +=
			'<div>'+re[i][j]["omenunum"]+''+" "+re[i][j]["osize"]+' '+re[i][j]["oamount"]+'</div>'+
			'<div>('+re[i][j]["otopping1"]+')'+" ("+re[i][j]["otopping2"]+')</div> '
			}
			html +=
			'<div> <span>전화번호 : </span>'+re[i][0]["ophone"]+'</div> '+
					'<div> <span>요청사항 : </span>'+re[i][0]["orequest"]+'</div> '+
					'<div> <span>가격 : </span>'+re[i][0]["ototalprice"]+'</div> '+
					'<div> <span>주소 : </span>'+re[i][0]["oaddress"]+'</div> '+
						'<div> <span>날짜 : </span>'+re[i][0]["odate"]+'</div>';
						
						if(re[i][0]["ostate"] == "주문접수완료") {
				html += '<div><button id="stbtn'+re[i][0]["odetailnum"]+'" onclick ="changestate('+re[i][0]["odetailnum"]+')"disabled >'+re[i][0]["ostate"]+'</button></div>'
				
			} else {
				html += '<div><button id="stbtn'+re[i][0]["odetailnum"]+'" onclick ="changestate('+re[i][0]["odetailnum"]+')" >'+re[i][0]["ostate"]+'</button></div>'
			}
			html +=
			'</div>';
		}
		$("#orderlist").html(html)
	}
})

}

function changestate(i){
		let btn = $("#stbtn"+i)
		//console.log(btn)
		$.ajax({
			url : "/pizza1/alert/ChangeState",
			data : {"odetailnum" : i},
			async :false,
			success :  function(re) {
				//alert(list[i]["odetailnum"])
				
			
					
				getlist();
		
				
			}
		})
	}		
