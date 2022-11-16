<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
<title>Home</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/member/mblogin.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 헤더 파트  -->
	<jsp:include page="../main/header.jsp"></jsp:include>
	<script type="text/javascript" src="/resources/js/main/header.js"></script>
<!-- 헤더 파트 끝 -->
	<div id="wrap">
		<section id="main-section">
			<div id="main-login-box">
				<div id="main-login">
				<h1 id="main-login-title">TEST Login</h1>
				<form action="/member/mblogin" method="POST" id="mbloginpost">
					<div class="main-login-line">
						<input class="main-input-box" id="id" name="id" type="text" placeholder="아이디를 입력해 주세요.">
					</div>
					<div class="main-login-line">
						<input class="main-input-box" id="password" name="password" type="password" placeholder="비밀번호를 입력해 주세요.">
					</div>
					<div class="main-login-line">
						<input id="main-login-button" type="submit" value="로그인">						
					</div>
				</form>
					<div class="main-login-line">
						<ul>
							<li>
						      <a href="https://kauth.kakao.com/oauth/authorize?client_id=44daa6a53ff644904c893b155d273e0a&redirect_uri=http://localhost:8080/member/kakaolog&response_type=code">
						          <img alt="카카오톡" src="/resources/image/login/kakao_login.png">
						      </a>
							</li>
						</ul>
					</div>
					<div class="main-login-line">
						<span>네이버 로그인</span>
					</div>
				</div>
			</div>
		</section>

	<!-- footer 파트 시작 -->
		<jsp:include page="../main/footer.jsp"></jsp:include>
	<!-- footer 파트 시작 -->
	</div>
</body>
</html>