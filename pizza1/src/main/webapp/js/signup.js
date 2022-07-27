let pass = [ false , false , false , false , false , false ];

// jquery(제이쿼리) : js 프레임워크
	// $ : 제이쿼리 ( 라이브러리 설치 : header파일 body 태그에 cdn 추가 )
// $( function() { 실행문; } ) : 문서 실행시 무조건 실행되는 함수
	// js식		id불러오기  .getElementById( id명 )
	// jquery식	id불러오기  $("#id명")
	
		// keyup(  ) : 해당 id에 키보드가 눌렸을때 [ 입력 되었을때 ]

// 입력상자 유효성 확인 체크 배열

	
$( function(){  // 문서 열리면 해당 코드가 실행 

	$("#idck").click(function() {
		// 1. HTML 태그내 값 가져오기 
		let mid=document.getElementById("mid").value;
		// 2. HTML 태그id 가져오기
		let idcheck = document.getElementById("idcheck");
		// 정규표현식 : 특정한 규칙을 가지는 문자열의 집합 언어
		let idj = /^[a-zA-Z0-9]{5,15}$/;	// 한글을 제외한 영문+숫자 5~15 사이 문자열
			// /^ : 정규표현식 시작
			// $/ : 정규표현식 끝 
			// [a-z] : 소문자 찾음
			// [A-Z] : 대문자 찾음
			// [0-9] : 숫자 찾음
			// { 최소길이 , 최대길이 } : 문자 최소길이~최대길이 까지만 입력
				// 정규표현식.test( 변수 ) : 해당 변수가 정규표현식에 동일하면 true 다르면 false
		if( idj.test( mid ) ){ // 정규표현식과 같으면
			// 아이디 중복체크
				// 비동기식 통신 [ 목적 : 페이지 전환이 없이 java (Controller) 통신 ]
			// $.ajax({ 속성 = 속성값 , 속성 = 속성값 }) // jquery 에서 제공해주는 메소드 
			// 중복체크 
			$.ajax({
				url : "../idcheck" , // 보내는 위치 [ 서블릿 경로 ]
				data : { "mid" : mid } , // 보내는 데이터  { "변수명" : 값 }
				success : function( result ){ // 통신 성공 했을경우 (  result = 받은 값 변수 )
					if( result == 1 ){ // 만약에 받은 데이터가 1이면
						//idcheck.innerHTML="사용중인 아이디 입니다."; 
						 alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");pass[0] = false;
						 $("#mid").val("");
					}else{ // 만약에 받은 데이터가 1이 아니면
						//idcheck.innerHTML="사용가능한 아이디 입니다.";  
						 alert("사용가능");pass[0] = true;
					}
				}
			});
		}else{
			alert("영문 , 숫자 포함 5~15길이로 입력해주세요.");pass[0] = false;
			//idcheck.innerHTML = "영문 , 숫자 포함 5~15길이로 입력해주세요."; 
		}
		
	});
	//////////////////////////////////////아이디 체크//////////////////////////////////////////////////////
	
	//////////////////////////////////////아이디 체크 end //////////////////////////////////////////////////////
	
	// 비밀번호 체크 
	$("#mpassword").keyup( function(){  // 비밀번호 입력할때마다
		// let mpassword = document.getElementById("mpassword").value;  // js식
		let mpassword = $("#mpassword").val();  // jquery 식
		let mpasswordcheck = $("#mpasswordcheck").val();
		let passswordj = /^[a-zA-Z0-9]{5,15}$/; // 정규표현식
		
		if( passswordj.test( mpassword ) ){ // 정규표현식 같으면
			if( mpassword != mpasswordcheck ){ // 비밀번호 와 비밀번호체크 와 다르면
				// equals(x)  //  != ( o )
			$("#passwordcheck").html("패스워드가 서로 다릅니다.");		pass[1] = false;
			}else{
				$("#passwordcheck").html("사용 가능한 비밀번호 입니다."); pass[1] = true; pass[2] = true;
			}
		}else{ // 정규현식 다르면
			$("#passwordcheck").html("영소문자 5~15 사이로 입력해주세요!"); pass[1] = false;
		}
	}); // keyup end 
	
	// 비밀번호확인 체크 
	$("#mpasswordcheck").keyup( function(){  // 비밀번호 입력할때마다
		// let mpassword = document.getElementById("mpassword").value;  // js식
		let mpassword = $("#mpassword").val();  // jquery 식
		let mpasswordcheck = $("#mpasswordcheck").val();
		
		let passswordj = /^[a-zA-Z0-9]{5,15}$/; // 정규표현식
		
		if( passswordj.test( mpasswordcheck ) ){ // 정규표현식 같으면
			if( mpassword != mpasswordcheck ){ // 비밀번호 와 비밀번호체크 와 다르면
				// equals(x)  //  != ( o )
			$("#passwordcheck").html("패스워드가 서로 다릅니다.");		pass[2] = false;
			}else{
				$("#passwordcheck").html("사용 가능한 비밀번호 입니다.");	pass[2] = true;  pass[1] = true;
			}
		}else{ // 정규현식 다르면
			$("#passwordcheck").html("영소문자 5~15 사이로 입력해주세요!"); pass[2] = false;
		}
	}); // keyup end 
	
	// 이름 체크
	$("#mname").keyup( function(){ 
		let mname = $("#mname").val(); // 해당 id의 데이터 가져오기
		let namej = /^[가-힣]{2,10}$/;	// 한글만 2~10 정규표현식
		if( namej.test(mname) ){
			$("#namecheck").html( "사용가능한 이름입니다." );		pass[3] = true;
		}else{
			$("#namecheck").html( "한글 2~10 사이만 가능합니다." );  pass[3] = false;
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
						phonecheck.innerHTML="사용중인 전화번호 입니다."; pass[4] = false;
						 
					}else{ // 만약에 받은 데이터가 1이 아니면
						$("#phonecheck").html( "사용가능한 번호 입니다." );pass[4] = true;
						
					}
				}
			});
		}else{
			$("#phonecheck").html( "01012341234 형식으로 입력해주세요." ); pass[4] = false;
		}
		
	}); // keyup end 
	
	// 이메일 체크 
	$("#emailchk").click( function(){
		let memail = $("#memail").val();
		let memailaddress = $("#memailaddress").val();
		
		if( memailaddress == ""  ){ 
			//$("#emailcheck").html("이메일 주소 입력해주세요~");  pass[5] = false;
			alert("이메일 주소 입력해주세요~");pass[5] = false;
			
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
							alert("사용중인 이메일 입니다");pass[5] = false;
						}else{
							//$("#emailcheck").html("사용가능한 이메일 입니다."); pass[5] = true;
							alert("사용가능한 이메일 입니다");pass[5] = true;
						}
					}
				}); // ajax end 
				
			}else{
				//$("#emailcheck").html("이메일 형식이 아닙니다.");  pass[5] = false;
				alert("이메일 형식이 아닙니다.");pass[5] = false;
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
	
	// 생일선택시
	
	
	

	
	
	
}); // 문서 열리면 해당 코드가 종료 
	// 폼 전송 메소드 
function signup(){
	// pass 배열이 모두 true이면 폼 전송 
	let check = true;
	for( let i = 0 ; i<pass.length ; i++ ){
		if( pass[i] == false ) check = false;
	}
	// js에서 form 전송하는 방법**
	if( check ) document.getElementById("signupform").submit();
	else{ alert("필수입력 사항이 입력되지 않습니다."); }
}
 


