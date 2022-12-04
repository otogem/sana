<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
<title>Sana</title>
	<jsp:include page="main/maincss.jsp"></jsp:include>
	<link href="../resources/css/main/home.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/resources/js/main/home.js"></script> 
	<link rel="stylesheet" href="https://unpkg.com/aos@2.3.1/dist/aos.css"> 
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script> 
</head>
<body>
<!-- 헤더 파트  -->
	<jsp:include page="main/header.jsp"></jsp:include>
	<script type="text/javascript" src="/resources/js/main/header.js"></script>
<!-- 헤더 파트 끝 -->
	<div id="wrap">
		<section id="main-section">
		<script>
		AOS.init({
			duration: 1000	
		});
		</script>
			<div class="home-ani" data-aos="fade-down" data-aos-easing="Ease in-out Quart" data-aos-anchor-placement="center-bottom">잔잔한 일상을 보내던 당신의 일상</div>
			<div class="home-ani" data-aos="fade-down" data-aos-easing="Ease in-out Quart" data-aos-anchor-placement="center-bottom">저희 SANA를 만나</div>
			<div class="home-ani" data-aos="fade-down" data-aos-easing="Ease in-out Quart" data-aos-anchor-placement="center-bottom">잔잔한 일상에 거대한 파문을 일으켜 보세요.</div>
			<div id="home-ani-main" class="home-ani" data-aos="fade-down" data-aos-easing="Ease in-out Quart" data-aos-anchor-placement="center-bottom">SANA</div>
		</section>

	<!-- footer 파트 시작 -->
		<jsp:include page="main/footer.jsp"></jsp:include>
	<!-- footer 파트 시작 -->
	</div>
</body>
</html>
