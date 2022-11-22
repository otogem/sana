<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section id="home_header">
	<article class="nav">
	<!-- 햄버거 버튼 -->
		<div class="burger">
			<div class="line1"></div>
			<div class="line2"></div>
			<div class="line3"></div>
		</div>
	<!--  햄버거 버튼 끝 -->
	
	<!--  햄버거 메뉴 시작 -->
		<div class="title"><a href="/">SANA</a></div>
	 		<div class="ham-con">

            <div class="navbar-nav">
                <div class="search-con d-flex justify-content-center">
                    <input type="text" placeholder="검색어를 입력해주세요." />
                    <i class="bi bi-search"></i>
                </div>
            </div>
	<div id="ham-menu wrap">
		<div class="ham-menu mt-5">
		<ul id="home_header_center" class="ham-sub-menu">
			<li><a href="/">HOME</a></li>
			<li><a href="/goods/category?bgno=1">1category</a></li>
			<li><a href="/goods/category?bgno=2">2category</a></li>
			<li><a href="/goods/category?bgno=3">3category</a></li>
			<li><a href="/goods/category?bgno=4">4category</a></li>
			<li><a href="/goods/category?bgno=5">5category</a></li>
			<li><a href="/goods/category?bgno=6">6category</a></li>
		</ul>
		</div>
		</div>
		</div>
		<!--  햄버거 메뉴 끝 -->
		<div id="home_header_right">
			<ul>
				<li class="user fab">
					<a></a>
					<div id="home_header_user">
						<ul>
						
							<c:if test="${mbloginpost.id == null && kakaoInfo.nickname == null }">
								<li><a href="/member/mblogin">로그인</a></li>
								<li><a href="/member/mbuser">회원 가입</a></li>
							</c:if>
							
							<c:if test="${mbloginpost.id != null }">
								<li id="user-name">${sessionScope.mbloginpost.name }님</li>
								<li><a href="/member/mbout">로그아웃</a></li>
							</c:if>
							<c:if test="${kakaoInfo.nickname != null}">
								<li id="user-name">${kakaoInfo.nickname }님</li>
								<li><a href="https://kauth.kakao.com/oauth/logout?client_id=44daa6a53ff644904c893b155d273e0a&logout_redirect_uri=http://localhost:8080/logout">로그아웃</a></li>
							</c:if>
						</ul>
					</div>
				</li>
				<!-- 로그인,회원가입 나머지는 추후 추가. -->
				<li class="cart fab">
					<a></a>
				</li>
				<!-- 바로 장바구니 로 이동 -->
			</ul>	
		</div>
	</article>
</section>

