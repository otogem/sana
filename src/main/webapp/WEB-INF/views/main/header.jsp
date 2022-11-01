<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
		<div class="title"><a href="/">TEST</a></div>
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
			<li><a href="/">1번태그</a></li>
			<li><a href="/">2번태그</a></li>
			<li><a href="/">3번태그</a></li>
			<li><a href="/">4번태그</a></li>
			<li><a href="/">5번태그</a></li>
			<li><a href="/">6번태그</a></li>
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
							<li><a href="/member/mblogin">로그인</a></li>
							<li><a href="/member/mbuser">회원 가입</a></li>
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

