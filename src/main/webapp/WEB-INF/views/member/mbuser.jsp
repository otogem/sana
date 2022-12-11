<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
<title>Home</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/member/mbuser.css" rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<!-- 카카오 우편주소 스크립트 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	function kakaopost() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            document.querySelector("#addrnum").value = data.zonecode;
	            document.querySelector("#addr2").value =  data.address
	        }
	    }).open();
	}
	</script>
	
</head>
<body>
<!-- 헤더 파트  -->
	<jsp:include page="../main/header.jsp"></jsp:include>
	<script type="text/javascript" src="/resources/js/main/header.js"></script>
<!-- 헤더 파트 끝 -->
	<div id="wrap">
		<section id="main-section">
			<div id="main-user-box">
				<div id="main-user">
				<form name="joinForm" action="/member/mbuser" method="post" onsubmit="return join(); ">
					<div class="main-user-line">
						<label for="id">아이디<span class="req">*</span>:</label>
							<div>
	    						<input type="text" id="user-id" name="id">
	    						<input type="button" id="overID" class="sub-bt" value="중복확인">
	    					</div>
	    			</div>
	    			<div class="main-user-line">
	    				<label for="password">비밀번호<span class="req">*</span>:</label>
	    				<input type="text" id="password" class="pw" name="password">
	    			</div>
	    			<div class="main-user-line">	
	    				<label for="password2">비밀번호 확인<span class="req">*</span>:
	    				<span id="psw-success" style="display: none;">비밀번호가 일치합니다.</span>
	    				<span id="psw-fail" style="display: none;">비밀번호가 같지 않거나.<br>8글자이상 소문자,대문자,숫자,특수문자가 다들어가게 써주세요.</span></label>
	    				<input type="text" id="password2" class="pw" name="password2">
	    			</div>
	    			<div class="main-user-line">	
			        	<label for="name">이름<span class="req">*</span>:</label>
	    				<input type="text" id="name" name="name">
	    			</div>
	    			<div class="main-user-line">	
	    				<label for="nickname">닉네임<span class="req">*</span>:</label>
	    				<input type="text" id="nickname" name="nickname">
	    			</div>
	    			<div class="main-user-line">	
	    				<label for="phone">전화번호<span class="req">*</span>:</label>
	    				<input type="text" id="phone" name="phone" oninput="autophone(this)" maxlength="13">
	    			</div>
	      			<div class="main-user-line">	
	    				<label for="addr1">주소<span class="req">*</span>:</label>
	    					<div>
		    					<input type="text" id="addrnum" name="addr1" placeholder="우편번호" readonly="readonly">
		    				 	<input type="button" class="sub-bt" value="우편번호찾기" onclick="kakaopost()">
	    				 	</div>
	    				 <input type="text" id="addr2" name="addr2" placeholder="주소">
	    				 <input type="text" name="addr3" id="addr3" placeholder="상세주소를 입력해주세요.">
	    			</div>
	    			<div class="main-user-line">
	    				<label for="email">이메일<span class="req">*</span>:</label>
	    				<input type="text" id="email" name="email">
    				</div>
    	  			<div class="main-user-line">
				    	  <select class="box" id="birth-year" name="birth">
						    <option disabled selected id="year">출생 연도</option>
						  </select>
						  <select class="box" id="birth-month" name="birth">
						    <option disabled selected id="month">월</option>
						  </select>
						  <select class="box" id="birth-day" name="birth">
						    <option disabled selected id="day">일</option>
						  </select>
    				</div>
    				<div class="main-user-line">
						<button id="main-user-submit" type="submit">회원가입</button>
					</div>
					<script type="text/javascript" src="/resources/js/member/mbuser.js"></script>
					</form>
				</div>
			</div>
		</section>

	<!-- footer 파트 시작 -->
		<jsp:include page="../main/footer.jsp"></jsp:include>
	<!-- footer 파트 시작 -->
	</div>
</body>
</html>
