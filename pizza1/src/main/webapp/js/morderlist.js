let mnum =$("#mnum2").val()
let parentlist;
getlist()
function  getlist(){
	$.ajax({
	url: "/pizza1/info/morderlist",
	data: {"mnum":mnum},
		success: function(re){
			console.log(re)
			parentlist = re
			let html ="";
			for(let i=0; i< re.length; i++) {
					html+=
						'<div class= orderbox>'+		
					'<div class="oimg_area">'+
			'<img src="/pizza1/admin/menuimg/'+re[i][0]["img"]+'" width="55%;">'+
			'</div>'+
			'<div class="oinfo">'+
			'<div>'
				for(let j = 0; j<parentlist[i].length; j++) {//
					html +=
					'<div class="menu_area">'+re[i][j]["omenunum"]+''+" "+re[i][j]["osize"]+'</div>'+
				'<div class="topping_area">'+re[i][j]["otopping1"]+''+" "+re[i][j]["otopping2"]+'</div>'
				}
				html +=
				
				'<div class="odetail_area">'+re[i][0]["oaddress"]+'</div>'+
				'<div class="odetail_area">'+re[i][0]["ophone"]+'</div>'+
				'<div class="odetail_area">'+re[i][0]["orequest"]+'</div>'+
					'<div class="odetail_area">'+re[i][0]["odate"]+'</div>'+
			'</div>'+
		'</div>'+
		'<div class="state_area">'+
			'<div>'+re[i][0]["ostate"]+'</div>'+
			'<div>'+re[i][0]["odelivery"]+'</div>'+
		'</div>'+
	'</div>'
			}
			$("#test").html(html)
		}
		
	
})
}
