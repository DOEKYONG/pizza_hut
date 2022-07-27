$( function category(){ 	
	getcategory();
});



function getcategory(){
	$.ajax({ 
		url : "../getcategory" , 
		success : function( re ){
			$("#categorybox").html(re);
		}
	});
};

function categorybtn(){
	// 특정태그의 HTML 넣기 
	$("#categoryinput").html(
		'<div class="row">'+
				'	<div><input type="text" id="cname"></div>'+
				'	<div><input type="checkbox" id="pizza" value="" name="pizza"> 피자 </div>'+
				'	<div><button onclick="categoryadd()" type="button">등록</button></div>'+
			'	</div>'
	)
}

function categoryadd(){
	let cname = $("#cname").val();	
    var check = $('input:checkbox[id="pizza"]').is(':checked');
	$.ajax({							
		url : "../categoryadd" , 			
		data : { "cname" : cname , "checkval" : check } ,	
		success : function( result ){	
			if( result == 1 ){  
				alert("카테고리추가"); 
				$("#categoryinput").html(" ");
				getcategory();
			}
			else{ alert("카테고리실패"); }
		}
	});
}



function menuadd(){
	var form = $("#addform")[0];
	var formData = new FormData( form ); 
	$.ajax({
		url : "../menuadd",
		type : 'POST' , 
		data : formData , 		
		contentType : false ,  
		processData : false , 
		success : function( re ){
			if( re == 1){
				alert(" 등록이 되었습니다. "); 
				form.reset(); 	
			}else{
				alert(" 등록이 실패 했습니다");
			}
		}
	});
}

function menuupdate(){
	var form = $("#updatemenu")[0];
	var formData = new FormData( form ); 
	$.ajax({
		url : "/pizza1/menu/menuupdate",
		type : 'POST' , 
		data : formData , 		
		contentType : false ,  
		processData : false , 
		success : function( re ){
			if( re == 1){
				alert(" 수정 되었습니다. "); 
				form.reset(); 	
			}else{
				alert(" 수정 실패 했습니다");
			}
		}
	});
}


$("#menuimg").change( function( e ) { 
	let reader = new FileReader();	
	reader.readAsDataURL( e.target.files[0] ); 
	reader.onload = function( e ){
		$("#preview").attr( "src" , e.target.result );
	}
});



function size( menunum ){
	$.ajax({ 
		url : '/pizza1/admin/getsize',
		data : { 'menunum' : menunum } ,
		success:function( re ){
			$('#sizelistbox').html(re);
		}
	});
	
	$("#modelinput").val(menunum);
	
}

function sizeadd(){
	let menunum =	$("#modelinput").val();
	let size = $("#sizeadd").val();
	let sizeprice = $("#sizeprice").val();
		$.ajax({
		url : "../sizeadd",
		data : { 'size' : size ,'sizeprice' : sizeprice , 'menunum' : menunum } ,	
		success : function( re ){
			if( re == 1){
				alert(" 등록이 되었습니다. "); 
				 location.reload();
			}else{
				alert(" 등록이 실패 했습니다 [ 관리자에게 문의 ] ");
			}
		}
	});
}



function edge( menunum ){
	$.ajax({ 
		url : '/pizza1/admin/getedge',
		data : { 'menunum' : menunum } ,
		success:function( re ){
			$('#edgelistbox').html(re);
		}
	});
	$("#modelinput2").val(menunum);
	
		
}

function ed(){
		var form = $("#edgeform")[0];
		var formData = new FormData( form ); 
		$.ajax({
			url : "../edgeadd",
			type : 'POST' , 
			data : formData , 		
			contentType : false ,  
			processData : false , 
			success : function( re ){
				if( re == 1){
					alert(" 등록이 되었습니다. "); 
					form.reset(); 	
				}else{
					alert(" 등록이 실패 했습니다 [ 관리자에게 문의 ] ");
				}
			}
		});
}

function sizeupdate( subnum ,subsize,subprice ){
	$("#updatesize").html(
		'<tr id="updatesize">' +
			'<td>'+
			'사이즈 : <input type="text" id="sizeup" value="'+subsize+'"><br>'+
		     '가격: <input type="text" id="sizepriceup"  value="'+subprice+'">'+
		      	'<button type="button" onclick="sizeup('+subnum+')">수정</button>'+
		     ' </td>'+
		  '</tr>'   
	);
		
}

function sizeup(subnum){
		
	let sizeup =	$("#sizeup").val();
	let sizepriceup = $("#sizepriceup").val();
		
		$.ajax({
			url : "/pizza1/menu/sizeupdate",
			data : {'subnum':subnum,'sizeup':sizeup,'sizepriceup':sizepriceup} , 		
			success : function( re ){
				if( re ){
					alert(" 수정 되었습니다. "); 
					 location.reload();
				}else{
					alert(" 수정 실패 했습니다 [ 관리자에게 문의 ] ");
				}
			}
		});
}

function updateedge( subnum ,subedge,subedgeimg,subprice ){
	$("#edgefor").html(
		'<form id="updateform">'+
		  '<table class="table">'+
				'<tr>'	+
					'<th>'+
						'<input type="hidden" name="subnum" value="'+subnum+'">'+
						'엣지 : <input type="text" id="edgeup" name="edgeup" value="'+subedge+'"><br>'+
						'가격: <input type="text" id="edgeupprice" name="edgeupprice" value="'+subprice+'"><br>'+
							'<input type="hidden" name="oldedgeupimg" value="'+subedgeimg+'">'+
						'이미지: <input type="file" id="edgeupimg" name="edgeupimg" value="'+subedgeimg+'">'+
					'<button type="button" onclick="edgeup1()">수정</button>'+
					'</th>'+
			    '</tr>'+
			' </table>'+
		'</form>'
	);
		
}


function edgeup1(){
	var form = $("#updateform")[0];
	var formData = new FormData( form ); 
		alert(form);
	alert(formData);
		$.ajax({
			url : "/pizza1/menu/edgeupdate",
			type : 'POST' , 
			data : formData , 		
			contentType : false ,  
			processData : false , 
			success : function( re ){
				if( re == 1){
					alert(" 등록이 되었습니다. "); 
					 location.reload();
				}else{
					alert(" 등록이 실패 했습니다 [ 관리자에게 문의 ] ");
				}
			}
		});
}


function deletemenu(menunum){
	$.ajax({
			url : "/pizza1/menu/menudelete",
			data : {'menunum':menunum} , 		
			success : function( re ){
				if( re==1 ){
					alert(" 삭제 되었습니다. "); 
					 location.reload();
				}else{
					alert(" 삭제 실패 했습니다 [ 관리자에게 문의 ] ");
				}
			}
		});
}


function sizedelete(subnum){
	$.ajax({
			url : "/pizza1/menu/sizedelete",
			data : {'subnum':subnum} , 		
			success : function( re ){
				if( re==1 ){
					alert(" 삭제 되었습니다. "); 
					 location.reload();
				}else{
					alert(" 삭제 실패 했습니다 [ 관리자에게 문의 ] ");
				}
			}
		});
	
}