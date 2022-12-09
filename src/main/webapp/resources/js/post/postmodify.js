/**
 * 
 */

	$(document).ready(function(){
		
	/* 할인율 Input 설정 */
	$("#discount_interface").on("keyup", function(){
		let userInput = $("#discount_interface");
		let discountInput = $("input[name='product_discount']");
		
		let discountRate = userInput.val();					// 사용자가 입력할 할인값
		let sendDiscountRate = discountRate / 100;					// 서버에 전송할 할인값
		let goodsPrice = $("input[name='product_price']").val(); // 원가
		let discountPrice = goodsPrice * (1 - sendDiscountRate); // 할인가격
		
		discountInput.val(sendDiscountRate);	
		discountPrice = Math.floor(discountPrice);
		$(".span_discount").html(discountPrice);
	
	});	
	
	/*상품 가격 변경시 할인율 적용JS*/
	$("input[name='product_price']").on("keyup", function(){
		
		let userInput = $("#discount_interface");
		let discountInput = $("input[name='product_discount']");
		
		let discountRate = userInput.val();					// 사용자가 입력한 할인값
		let sendDiscountRate = discountRate / 100;			// 서버에 전송할 할인값
		let goodsPrice = $("input[name='product_price']").val();			// 원가
		let discountPrice = goodsPrice * (1 - sendDiscountRate);		// 할인가격
		
		$(".span_discount").html(discountPrice);
		
	});
});