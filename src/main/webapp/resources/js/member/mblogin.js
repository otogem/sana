/**
 * 
 */
	const loginForm = document.loginForm;
   	
	function join() {
	const id = loginForm.id;
	const password = loginForm.password;
	
   //비밀번호 유효성 검사 시작
   if(id.value == "") {
	   alert("아이디를 입력해주세요.");
	   id.focus();
	   return false;
   }else if(password.value == "") {
	   alert("비밀번호를 입력해주세요.");
	   password.focus();
	   return false;
   }else {
       $.ajax ({
           type : "POST",
           url : "/member/logincheck",
           data : JSON.stringify ({id:id, password:password}),
           contentType : "application/json; charset=utf-8",
           async : false,
           success:function(result) {
              
              if(result == "success") {
                    check = true;   
              }
           },
           error:function() {
              alert("로그인 실패","아이디 혹은 비밀번호가 존재하지 않거나 잘못되었습니다.","error")
              check = false;
           }
        }) // ajax 끝  
   }
}