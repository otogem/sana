/**
 * 
 */

   
   
 //비밀번호 유효성 검사 시작
   $(".pw").focusout(function(){
   	var pwd1=$("#password").val();
   	var pwd2=$("#password2").val();
   	
   	if( pwd1 != '' && pwd2 == '') {
   		null;
   	}else if(pwd1 !="" || pwd2 !="") {
   		if(pwd1 == pwd2) {
   			$("#psw-success").css('display','inline-block');
   			$("#psw-fail").css('display','none');
   		}else {
   			$("#psw-success").css('display','none');
   			$("#psw-fail").css('display','inline-block');
   		}
   	}
   });

   //비밀번호 유효성 검사 끝