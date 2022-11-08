/**
 * 
 */
   //비밀번호 안맞을시 글자 띄우는 js

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
	
	//전화번호 자동 하이픈
	const autophone = (target) => {
		 target.value = target.value
		   .replace(/[^0-9]/g, '')
		  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
		}
	   
//아이디 유효성 검사시작
	const joinForm = document.joinForm;
	
	function join() {
	const id = joinForm.id;

	if(id.value == "") {
		alert("아이디를 입력하세요.");
		id.focus();
		return false;
	}
	
	if(id.value.length < 5 || id.value.length > 12) {
		alert("아이디는 5자 이상 12자 이하로 작성해주세요.");
		id.focus();
		return false;
	}
	//이곳에 아이지 중복체크 결과창 써두기

//아이디 유효성 검사끝
 
   
	const userpw = joinForm.password;
	const userpw_re = joinForm.password2;
	
   //비밀번호 유효성 검사 시작
   if(userpw.value == "") {
	   alert("비밀번호를 입력하세요.");
	   userpw.focus();
	   return false;
   }
   if(userpw.value.lenght < 8) {
	   alert("비밀번호를 8자이상 작성해주세요.");
	   userpw.focus();
	   return false;
   }
   //비밀번호 유효성 검사 끝
   
   
//비밀번호 정규식 시작
   let reg= /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[~?!@#$%^&*_-]).{8,}$/
		   
if(!reg.test(userpw.value)) {
	alert("비밀번호8자이상,숫자,대문자,소문자,특수문자를 모두 포함해주세요.");
	userpw.focus();
	return false;
}
   
if(/(\w)\1\1\1/.test(userpw.value)) {
	alert("같은 문자를 4번이상 연속해서 표현할수없습니다.");
	userpw.focus();
	return false;
}

if(userpw.value.search(" ") != -1) {
	alert("비밀번호는 공백을 포함할 수 없습니다.");
	userpw.focus();
	return false;
}

if(userpw_re.value == "") {
	alert("비밀번호를 확인 부분을 작성 해주세요");
	userpw_re.focus();
	return false;
}

if(userpw.value != userpw_re.value) {
	alert("비밀번호 확인을 다시 해주세요.");
	userpw_re.focus();
	return false;
}
//비밀번호 정규식 끝
   
//이름 정규식 시작
   const username =  joinForm.name;
   
   if(username.value == "") {
	   alert("이름를 입력하세요.");
	   username.focus();
	   return false;
   }
   if(username.value.length >30 ) {
	   alert("이름을 30글자 이하 작성해주세요.");
	   username.focus();
	   return false;
   }
 //이름 정규식 끝
   
 //닉네임 정규식 시작
   const nickname = joinForm.nickname;
   
   if(nickname.value == "") {
	   alert("닉네임을 입력하세요.");
	   nickname.focus();
	   return false;
   }
   if(nickname.value.length >10 ) {
	   alert("닉네임을 10자이하 작성해주세요.");
	   nickname.focus();
	   return false;
   }
 //닉네임 정규식 끝
   
   
 //휴대전화 정규식 시작
   let regph= /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/	   
		  
   const phone = joinForm.phone;
    if(!regph.test(phone.value)) {
		alert("올바른 휴대전화 형식이 아닙니다.");
		phone.focus();
		return false;
	}	   
 //휴대전화 정규식 끝  
   
//이메일 정규식 시작
	let regem = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	
	const email=joinForm.email;
	if(email.value=="") {
		alert("이메일을 입력해주세요.");
		return false;
	}else {
		if(!regem.test(email.value)) {
			alert("이메일 형식에 맞게 입력해주세요.");
			return false;
		}
	}
	
//이메일 정규식 끝
   
   
   
   
   
   
   
	}
   
   
   
   
   
   
   