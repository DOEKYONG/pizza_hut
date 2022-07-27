var header = document.querySelector('header'),
    nav = document.querySelector('nav');

    nav.addEventListener('mouseover' ,function() {
        header.style.height = '270px';
    });

    nav.addEventListener('mouseout' ,function() {
        header.style.height = '68px';
    });

    /*
    nav에 마우스를 올리면 header 높이가 270으로
    나가면 header 의 높이를 50으로 변경
    */
    
    
    function opertime(fnum){
	let oper = $("#oper").html();
	if(oper=="영업종료"){
		$("#oper").html("영업중");
	}
	else if(oper=="영업중"){
		$("#oper").html("영업종료");
	}
	$.ajax({
		url: "/pizza1/menu/opertime",
		data: {"oper":oper ,"fnum":fnum},
		success: function(re){
			alert(re);
		}
		
	});
}