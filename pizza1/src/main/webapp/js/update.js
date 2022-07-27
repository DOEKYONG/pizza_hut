let pass = [ true , true , true];

// jquery(제이쿼리) : js 프레임워크
	// $ : 제이쿼리 ( 라이브러리 설치 : header파일 body 태그에 cdn 추가 )
// $( function() { 실행문; } ) : 문서 실행시 무조건 실행되는 함수
	// js식		id불러오기  .getElementById( id명 )
	// jquery식	id불러오기  $("#id명")
	
		// keyup(  ) : 해당 id에 키보드가 눌렸을때 [ 입력 되었을때 ]

// 입력상자 유효성 확인 체크 배열

	
$( function(){  // 문서 열리면 해당 코드가 실행 

	//////////////////////////////////////아이디 체크//////////////////////////////////////////////////////
	
	//////////////////////////////////////아이디 체크 end //////////////////////////////////////////////////////

	// 비밀번호 체크 
	$("#mpassword").keyup( function(){  // 비밀번호 입력할때마다
		// let mpassword = document.getElementById("mpassword").value;  // js식
		let mpassword = $("#mpassword").val();  // jquery 식
		let mpasswordcheck = $("#mpasswordcheck").val();
		let passswordj = /^[a-zA-Z0-9]{5,15}$/; // 정규표현식
		if( passswordj.test( mpassword ) ){ // 정규표현식 같으면
			
				// equals(x)  //  != ( o )
			
				$("#passwordcheck").html("사용 가능한 비밀번호 입니다."); pass[0] = true;
			
			 
			}
			else{
					
				$("#passwordcheck").html("영소문자 5~15 사이로 입력해주세요!"); pass[0] = false;
				
			}
		
	}); // keyup end 
	
	
	// 이름 체크
	$("#mname").focusout( function(){ 
		
		let mname = $("#mname").val(); // 해당 id의 데이터 가져오기
		let namej = /^[가-힣]{2,10}$/;	// 한글만 2~10 정규표현식
		if( namej.test(mname) ){
			$("#namecheck").html( "사용가능한 이름입니다." );		pass[1] = true;
		}else{
			$("#namecheck").html( "한글 2~10 사이만 가능합니다." );  pass[1] = false;
		}
	 }); // keyup end 
	 
	// 전화번호 체크 
	$("#mphone").focusout( function(){ 
		let mphone = $("#mphone").val();
		let phonej = /^([0-9]{2,11})([0-9]{3,4})([0-9]{3,4})$/;
		
			if( phonej.test( mphone ) ){ // 정규표현식과 같으면
			// 아이디 중복체크
				// 비동기식 통신 [ 목적 : 페이지 전환이 없이 java (Controller) 통신 ]
			// $.ajax({ 속성 = 속성값 , 속성 = 속성값 }) // jquery 에서 제공해주는 메소드 
			// 중복체크 
			$.ajax({
				url : "../phonecheck" , // 보내는 위치 [ 서블릿 경로 ]
				data : { "mphone" : mphone } , // 보내는 데이터  { "변수명" : 값 }
				success : function( result ){ // 통신 성공 했을경우 (  result = 받은 값 변수 )
					if( result == 1 ){ // 만약에 받은 데이터가 1이면
						phonecheck.innerHTML="사용중인 전화번호 입니다."; pass[2] = false;
						 
					}else{ // 만약에 받은 데이터가 1이 아니면
						$("#phonecheck").html( "사용가능한 번호 입니다." );pass[2] = true;
						
					}
				}
			});
		}else{
			$("#phonecheck").html( "01012341234 형식으로 입력해주세요." ); pass[2] = false;
		}
		
	}); // keyup end 
	
	// 이메일 체크 
	$("#emailchk").click( function(){
		let memail = $("#memail").val();
		let memailaddress = $("#memailaddress").val();
		
		if( memailaddress == ""  ){ 
			//$("#emailcheck").html("이메일 주소 입력해주세요~");  pass[5] = false;
			alert("이메일 주소 입력해주세요~");pass[3] = false;
			
		}else{
			let emailj = /^[a-zA-Z0-9]{3,20}$/;
			if( emailj.test(memail) ){
				// 이메일 중복체크 
				let email = memail+"@"+memailaddress;
				$.ajax({
					url : "../emailcheck",
					data : { "email" : email } , 
					success : function( result ){
						if( result == 1 ){
							//$("#emailcheck").html("사용중인 이메일 입니다."); pass[5] = false;
							$("memail").val("");
							alert("사용중인 이메일 입니다");pass[3] = false;
							
						}else{
							alert("사용가능한이메일입니다."); pass[3] = true;
							
						}
					}
				}); // ajax end 
				
			}else{
				//$("#emailcheck").html("이메일 형식이 아닙니다.");  pass[5] = false;
				alert("이메일 형식이 아닙니다.");pass[3] = false;
			}
		}
	});
	
	// 이메일주소 목록상자 선택시 
	$("#emailselect").change( function(){ // 목록상자내 값이 변경 되었을때 이벤트
		
		let emailselect = $("#emailselect").val();
		if( emailselect == "" ){
			$("#memailaddress").val("");
			$("#memailaddress").attr("readonly" , false); // 읽기모드 취소
		}else{
			$("#memailaddress").val(emailselect);	// val() -> value 값
			$("#memailaddress").attr("readonly" , true); // attr -> attribute 속성
		}
		
	});
	
	
}); // 문서 열리면 해당 코드가 종료 
	function passwordchange(){
	$("#passwordbox").css("display","block")
	
	$("#oldpassword").keyup(function() {
		let mid =  $("#mid").val();
		let oldpassword = $("#oldpassword").val();
		//let foldmpassword = $("#foldmpassword").val();
		
		if( oldpassword == "" ){ 
			$("#foldmpassword").html("기존비밀번호 입력해주세요~");  pass[0] = false;
		}else{
			let oldpasswordj = /^[a-zA-Z0-9]{5,15}$/;
		if( oldpasswordj.test( oldpassword ) ){ 
			$.ajax({
				url : "../oldpwcheck" , 
				data : {"mid" : mid , "oldpassword" : oldpassword } ,
				type : "POST" , 
				success : function( result ){ // 통신 성공 했을경우 (  result = 받은 값 변수 )
					if( result == 1 ){ // 만약에 받은 데이터가 1이면
					$("#foldmpassword").html("기존비밀번호와 일치합니다.");  
						pass[0] = true;
					}else{ // 만약에 받은 데이터가 1이 아니면
					$("#foldmpassword").html("기존비밀번호와 다릅니다.");  
						pass[0] = false;
						$("#oldpassword").val("");
					}
				}
			});
		}else{
			$("#foldmpassword").html("영소문자 5~15 사이로 입력해주세요!");  pass[0] = false;
			
			}
		}
		});
	 
	 
}
	// 폼 전송 메소드 
function update(){
	// pass 배열이 모두 true이면 폼 전송 
	let check = true;
	for( let i = 0 ; i<pass.length ; i++ ){
		//if( pass[i] == false && pass[0] == null ) check = true;
		//if(pass[i] == null && pass[0] == true) check = true;
		//if(pass[i]==true && pass[0] ==false) check = false;
		
		if( pass[i] == false ) check = false;
	}
	// js에서 form 전송하는 방법**
	if( check ) { document.getElementById("updateform").submit(); }
	else{ 
		alert("필수입력 사항이 입력되지 않습니다."); 
		 }
}
 


