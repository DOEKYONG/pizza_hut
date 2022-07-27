

function coupon( coupon , mid){
	$.ajax({
		url : 'coupon' , 
		data : { 'coupon': coupon , 'mid': mid },		// js배열을 json형으로 변환하기 
		success: function( re ){
			if(re==1){alert("해당 쿠폰은 이미 발급되었습니다.");}
			else if(re==2){
				alert("쿠폰이 발급되었습니다.");
			}
			else{alert("오류발생");}			

		}
	});
}