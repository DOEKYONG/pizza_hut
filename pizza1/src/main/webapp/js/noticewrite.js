
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

function uwritecheck() {
	
	let title = $("#ntitle").val()
	let content = $("#ncontent").val()
	
	
	if(title=="" ||content==""){
		alert("제목과 내용을 입력해주세요");
		return false;
	} else {
		$("#form_n").submit();
	}
}


