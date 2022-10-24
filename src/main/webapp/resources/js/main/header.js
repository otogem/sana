/**
 * 
 */
$(document).ready(function(){ /*탭메뉴*/
const button=() => {
	const burger = document.querySelector('.burger'); // burger class 가져오기
	burger.addEventListener('click', ()=> { //클릭 이벤트
		burger.classList.toggle('toggle'); //toggle class가 있으면 제거,없으면 추가
	});
} 

button();

	$('.user>a').hover(function(){// 마우스를 a태그에 위치할시 div display 펼치고 뺄시 사라지는 코드
		$(this).addClass('on');
		$(this).next().css("display","block");
	}, function(){
			$(this).removeClass('on');
			$(this).next().css("display","none");

	})
	
	$('.user>div').hover(function(){// 마우스를 div에 위치할시 div display 펼치고 뺄시 사라지는 코드
		$(this).prev().addClass('on');
		$(this).css("display","block");
	}, function(){
			$(this).prev().removeClass('on');
			$(this).css("display","none");

	})
	
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
			  $('.ham-con').animate({
				  left: '0%',
				  opacity: 1
			  }, 150);
			  $(this).addClass('active-1');
			  h++;
		  } else if (h == 1) {
			  $('.ham-con').animate({
				  left: '-100%',
				  opacity: 0
			  }, 150);
			  $(this).removeClass('active-1');
			  h--;
		  }
		  $(window).scroll(function() {
			  sct = $(window).scrollTop();
	      if(sct>30){
	        $('.ham-con').css({
	          opacity: 1,
	          left :'-80%'
	        }, 150);
	        $(burger).removeClass('active-1');
	        h=0;
	      }
	    });
	  });
});