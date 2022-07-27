start();


function start(){
	//	js 에서 사용되는 웹소켓 클래스( ws:// IP번호/PORT번호/프로젝트명/서버소켓이름 )
	let mnum = $("#mnum").val();
	let fnum = $("#fnum").val();
	
	websocket = new WebSocket("ws://localhost:8080/pizza1/alert/"+mnum+"/"+fnum);
	websocket.onopen = function( e ){ onOpen(e) }
	websocket.onmessage = function( e ){ onmessage(e) }
	websocket.onclose = function( e ){ onclose(e) }
	websocket.onerror = function( e ){ onerror(e) }
}

function onclose( e ){ alert("소켓을 나갑니다.") + e;   }

function onerror( e ){ alert("서버소켓 오류 입니다." + e );  }

function onOpen( e ){
	alert("서버소켓으로 들어갑니다~ : "+ e );
	//console.log( e );
}
function onmessage( e ){
	// e : 메소드 이벤트 실행정보가 담겨있는 객체
		// e.data : 메시지 내용이 담겨있는 필드 
			
		let msg = JSON.parse( e.data );	 // 문자열 -> json
		console.log(e.data)
	
		let from = msg["from"];	// json 키를 통한 value 호출
		let content = msg["content"];	// json 키를 통한 value 호출
		let date = msg["date"];	// json 키를 통한 value 호출
		let to = msg["to"];
	
		console.log(msg)
		console.log(fnum.value)
		console.log(to);
		
		let html = $("#contentbox").html();	// 기존 html 가져오기
	
			if(fnum.value == to){ // 소켓에있는가맹점의 fnum과 주문한곳의 fnum이 같으면
					// 목록출력(가맹점 별 알림이 달라야함)
			html +=	// 기존 html 추가 
				'<div> '+
						'	<div>	 '+
								'<div> '+from+' </div>'+
								'<span> '+content+' </span>'+
								'<span> '+date+' </span>'+
								'<button>상태변경</button>'+
							'</div>'+
					'</div>';
				
			}
			if(fnum.value == to){
				alert("주문")
			}
		$("#contentbox").html( html ); // 추가된 html 넣어주기
}

function send( mnum ){
	
	let content = $("#menu_title").html();
	
	
	// json 형식으로 통신
	let msg = { // js 객체화  // 객체명 = {  속성명(key) : 값(value) , 속성명(key) : 값(value)   }
		type : "1" , 		// 문자전송 , 접속자명단 구분용 
		from : mnum , 		// 보내는사람 명 
		to : 21, //  알림보낼곳(가맹점번호(ordernum)) => 주문db에서 빼오묜될듯?
		content : content, 		// 채팅내용
		date : new Date().toLocaleTimeString()// 채팅 보낸 시간
		
	}
	

	// json 통신할때 json모양의 문자열 변환
		// JSON -> 문자열  :  JSON.stringify
		// 문자열 -> JSON  :  JSON.parse( ) 
		
		websocket.send(  JSON.stringify(msg)  ); // json -> 문자열
		
	
		

		

	}
	
	
