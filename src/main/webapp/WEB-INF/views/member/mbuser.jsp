<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
<title>Home</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
		<link href="../resources/css/member/mbuser.css" rel="stylesheet" type="text/css">
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
				<form action="/member/mbuser" method="post">
					<div class="main-user-line">
						<label for="id">아이디<span class="req">*</span>:</label>
	    				<input type="text" id="id" name="id">
	    			</div>
	    			<div class="main-user-line">
	    				<label for="password">비밀번호<span class="req">*</span>:</label>
	    				<input type="text" id="password" name="password">
	    			</div>
	    			<div class="main-user-line">	
	    				<label for="password">비밀번호 확인<span class="req">*</span>:</label>
	    				<input type="text" id="password" name="password">
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
	    				<input type="text" id="phone" name="phone">
	    			</div>
	    			<div class="main-user-line">
	    				<label for="email">이메일<span class="req">*</span>:</label>
	    				<input type="text" id="email" name="email">
    				</div>
    				<div class="main-user-line">
						<input id="main-user-submit" type="submit" valuse="회원가입">
					</div>
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
