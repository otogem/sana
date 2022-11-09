/**
 * 
 */

	//아아디 중복체크 검사 시작
	$("#overID").click(function(){
		$("#main-user-submit").attr("type","button");
		const id = $("#user-id").val();
		$.ajax({
			type:"get",
			async:false,
			url:"http://localhost:8080/member/idCheck",
			data:{id: id},
			success: function(data){
				console.log(id)
				if(data == 1) {
					alert("이미사용중인 ID입니다.");
				}else {
					alert("사용가능한 ID 입니다.")
					$("#main-user-submit").attr("type","submit");
				}
			}
		})
	})
	
	//아아디 중복체크 검사 끝
	
   //비밀번호 안맞을시 글자 띄우는 js

	$(".pw").focusout(function(){
		 var pwd1=$("#password").val();
		 var pwd2=$("#password2").val();
		   	
   	if( pwd1 != '' && pwd2 == '') {
   		null;
   	}else if(pwd1 !="" || pwd2 !="") {
   		if(pwd1 == pwd2 && pwd1.length > 7) {
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
	
	//생년월일 생성용 js-년도
	const birthYear = document.querySelector('#birth-year')
			
	isYearOptionExisted = false;
	birthYear.addEventListener('focus', function(){
		//year 목록 생성되지 않았을 때 (최초 클릭 시)
		if(!isYearOptionExisted) {
			isYearOptionExisted=true
			for(var i = 1900; i <=2022; i++) {
				const YearOption = document.createElement('option')
				YearOption.setAttribute('value', i)
				YearOption.innerText = i+"년"
				//birthYear 의 자식 요소로 추가
				this.appendChild(YearOption);
			}
		}
	});
	
	//생년월일 생성용 js-월
	const birthMonth = document.querySelector('#birth-month')
			
	isMonthOptionExisted = false;
	birthMonth.addEventListener('focus', function(){
		//year 목록 생성되지 않았을 때 (최초 클릭 시)
		if(!isMonthOptionExisted) {
			isMonthOptionExisted=true
			for(var i = 1; i <=12; i++) {
				const MonthOption = document.createElement('option')
				MonthOption.setAttribute('value', i)
				MonthOption.innerText = i+"월"
				//birthYear 의 자식 요소로 추가
				this.appendChild(MonthOption);
			}
		}
	});
	
	//생년월일 생성용 js-일
	const birthDay = document.querySelector('#birth-day')
			
	isDayOptionExisted = false;
	birthDay.addEventListener('focus', function(){
		//year 목록 생성되지 않았을 때 (최초 클릭 시)
		if(!isDayOptionExisted) {
			isDayOptionExisted=true
			for(var i = 1; i <=31; i++) {
				const DayOption = document.createElement('option')
				DayOption.setAttribute('value', i)
				DayOption.innerText = i+"일"
				//birthYear 의 자식 요소로 추가
				this.appendChild(DayOption);
			}
		}
	});
	
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
   
  //주소 정규식 시작
    
    const addr1 = joinForm.addr1;
    const addr2 = joinForm.addr2;
    const addr3 = joinForm.addr3;
    
    if(addr1.value == "") {
    	alert("우편번호찾기를 해주세요.");
    	return false;
    }else if(addr2.value == "") {
    	alert("주소를 적어주세요.");
    	return false;
    }else if(addr3.value == "") {
    	alert("상세 주소를 적어주세요.")
    	return false;
    }
    
    
    
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
   
   //생일 정규식 시작
	
	var year=$("#birth-year option:selected").val()
	var month=$("#birth-month option:selected").val()
	var day=$("#birth-day option:selected").val()
	
	if(year=="출생 연도") {
		alert("연도를 선택해주세요.");
		return false;
	}else if(month=="월"){
		alert("월을 선택해주세요.")
		return false;
	}else if(day=="일") {
		alert("일을 선택해주세요.")
		return false;
	}
	  //생일 정규식 끝
   
   
   
   
	}
   
   
   
   
   
   
   