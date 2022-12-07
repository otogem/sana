/**
 * 
 */

$(document).ready(function(){
	//수량 조작 버튼
	let quantity = $(".quantity_input").val();
	$(".plus_btn").on("click", function(){
		$(".quantity_input").val(++quantity);
	});
	
	$(".minus_btn").on("click", function(){
		if(quantity > 1){
			$(".quantity_input").val(--quantity);
		}
	});
	
	//서버로 전송할 데이터
	const form = {
			id : $("input[name='id']").val(),
			product_number : $("input[name='product_number']").val(),
			product_count : ''
	}
	
	$(".goods_detail_button").on("click", function(e){
		alert($("input[name='product_number']").val())
	});
	
	//장바구니 추가 버튼
	$(".btn_cart").on("click", function(e){
		
		console.log(form);
		
		form.product_count = $(".quantity_input").val();
		$.ajax({
			url: '/cart/add',
			type:'POST',
			data:form,
			success: function(result){
				cartAlert(result);
			}
		})
	});
	
	function cartAlert(result){
		console.log(result);
		if(result == '0'){
			alert("장바구니에 추가를 하지 못하였습니다.");
		}else if(result == '1'){
			alert("장바구니에 추가되었습니다.")
		}else if(result == '2'){
			alert("장바구니에 이미 추가되어져 있습니다.")
		}else if(result == '5'){
			alert("로그인이 필요합니다.")
		}
	}
	
	//포인트 삽입
//	let salePrice = "${detail.bookPrice - (goodsInfo.bookPrice*goodsInfo.bookDiscount)}"
//		let point = salePrice*0.05;
//		point = Math.floor(point);
//		$(".point_span").text(point);
});