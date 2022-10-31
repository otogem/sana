/**
 * 
 */
$(document).ready(function(){ /*탭메뉴*/
const button=() => {
	const burger = document.querySelector('.burger'); // burger class 가져오기
	const user = document.querySelector('.user>a')
	burger.addEventListener('click', ()=> { //클릭 이벤트
		burger.classList.toggle('toggle'); //toggle class가 있으면 제거,없으면 추가
		if($('.user>a').hasClass("on")) {
			$('.user>a').removeClass('on')
			$('.user>a').next().css("display","none");
		}
	});
} 

button();

	$('.user>a').off().click(function(){// 마우스를 a태그에 위치할시 div display 펼치고 뺄시 사라지는 코드
		$(this).toggleClass('on');
		
		if($(this).hasClass("on")) {
			$(this).next().css("display","block");
		}else {
			$(this).next().css("display","none");
		}

	});
	
	// 햄버거 버튼 클릭 이벤트 
	  var burger = $('.burger');

	  burger.each(function (index) {
	    var $this = $(this);

	    $this.on('click', function (e) {
	      e.preventDefault();
	      $(this).toggleClass('active-' + (index + 1));
	    })
	  });

	  var h = 0;

	  $(burger).on("click", function () {
	    if (h == 0) {
	    	$('.ham-con').on('scroll touchmove mousewheel', function(event) { //스크롤 고정
	    	  event.preventDefault();
	    	  event.stopPropagation();
	    	  return false;
	    	});
	    	
	    	$('html, body').scrollTop(0); // 버튼 클릭시 스크롤 0으로 위치이동
	    	
			  $('.ham-con').animate({ //유저 편의성 메뉴바 펼치기
				  left: '0%'
			  }, 150);
			  $(this).addClass('active-1');
			  h++;
		  } else if (h == 1) {
			  $('.ham-con').off('scroll touchmove mousewheel');
			  $('.ham-con').animate({
				  left: '-110%'
			  }, 150);
			  $(this).removeClass('active-1');
			  h--;
		  }
	  });
	  
	  $(window).resize(function (){
		  var width_size = window.innerWidth;
		  if(width_size>761) {
			  $('.burger').removeClass('toggle active-1');
			  $('.ham-con').css('left','-110%');
	  }h=0
	  });
});
