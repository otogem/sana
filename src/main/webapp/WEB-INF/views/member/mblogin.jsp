<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
<title>Home</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/member/mblogin.css" rel="stylesheet" type="text/css">
	  <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
  <script>
  //카카오로그인
  function kakaoLogin() {

    $.ajax({
        url: '/login/getKakaoAuthUrl',
        type: 'get',
        async: false,
        dataType: 'text',
        success: function (res) {
            location.href = res;
        }
    });

  }
  document.cookie = "crossCookie=TIARA; SameSite=None; Secure";
  document.cookie = "crossCookie=Kd_lang; SameSite=None; Secure";
  document.cookie = "crossCookie=_ga; SameSite=None; Secure";
  document.cookie = "crossCookie=_kdt; SameSite=None; Secure";
  document.cookie = "crossCookie=_kadu; SameSite=None; Secure";
  </script>
  
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
				<h1 id="main-login-title">SANA Login</h1>
				<form action="/member/mblogin" method="POST" id="mbloginpost" name="loginForm" onsubmit="return join();">
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
					  <script type="text/javascript" src="/resources/js/member/mblogin.js"></script>
					<div class="main-login-line">
						  <ul>
						      <li onclick="kakaoLogin();">
						        <a href="javascript:void(0)">
						            <span> <img id="kakao-img-logn" alt="카카오톡" src="/resources/image/login/kakao_login.png"></span>
						            <span> <img id="kakao-img-logn-small" alt="카카오톡" src="/resources/image/login/kakao_login_small.png"></span>
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