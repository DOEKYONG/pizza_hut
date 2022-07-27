function replyview() {
    $(".qview_box2").show();
    $(".replybtn").hide();
    $("#reupdate").hide();
    $("#redelete").hide()
}

function reupdateview(rcontent) {
	$(".notice_content2").hide();
	 $(".replybtn").hide();
	$("#rewrite").hide();
	 $(".qview_box2").show();
	 $(".notice_content3").val(rcontent)
}


function rewrite(qnum) {
	let rcontent = $("#rcontent").val();
	$.ajax({
		url: "replywrite" ,
		data: { "qnum":qnum , "rcontent" : rcontent  } ,
		success : function( result ){
			if( result == 1 ){
				 alert("댓글작성 되었습니다."); // 성공 메시지 알림 
				 $("#rcontent").val(""); // 작성 input 공백으로 초기화 
				 $(".qview_box").load( location.href+" .qview_box"); // 특정 태그 새로고침
				 /* 해당 replytable 의 불러오기 = replytable */
			}
			else{ alert("답글작성이 실패했습니다."); }
		}
	});
	
}

function reupdate(rnum) {
	let rcontent = $("#rcontent").val();
	$.ajax({
		url: "replyupdate" ,
		data: { "rnum":rnum , "rcontent" : rcontent  } ,
		success : function( result ){
			if( result == 1 ){
				 alert("답글수정 완료."); // 성공 메시지 알림  
				 $(".qview_box").load( location.href+" .qview_box"); // 특정 태그 새로고침
				 /* 해당 replytable 의 불러오기 = replytable */
			}
			else{ alert("수정 실패했습니다."); }
		}
	});
	
}
function redelete(rnum,qnum) {
	
	$.ajax({
		url: "replydelete" ,
		data: { "rnum":rnum,"qnum":qnum } ,
		success : function( result ){
			if( result == 1 ){
				 alert("답글삭제 완료."); // 성공 메시지 알림  
				 $(".qview_box").load( location.href+" .qview_box"); // 특정 태그 새로고침
				 /* 해당 replytable 의 불러오기 = replytable */
			}
			else{ alert("수정 실패했습니다."); }
		}
	});
	
}

function writecheck() {
	
	let title = $("#ntitle").val()
	let content = $("#ncontent").val()
	
	if(title=="" ||content==""){
		alert("제목과 내용을 입력해주세요");
		return false;
	} else {
		$("#form_n").submit();
	}
}


