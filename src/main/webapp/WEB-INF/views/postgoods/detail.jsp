<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
<title>Home</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/post/detail.css" rel="stylesheet" type="text/css">
</head>
<body>

	<!-- 헤더 파트  -->
		<jsp:include page="../main/header.jsp"></jsp:include>
		<script type="text/javascript" src="/resources/js/main/header.js"></script>
	<!-- 헤더 파트 끝 -->
	
	<div id="wrap">
		<section id="main-section">
			
			<c:choose>
			     <c:when test="${detail.id==sessionScope.mbloginpost.id || sessionScope.mbloginpost.id=='admin'}">
								<a href="/service/modify?bno=${detail.bno }&bgno=${detail.bgno}" class="goods_detail_button" style="cursor: pointer">수정 하러 하기</a>
					</c:when>
			 </c:choose>
			<c:choose>
			     <c:when test="${detail.id==sessionScope.mbloginpost.id || sessionScope.mbloginpost.id=='admin'}">
			 		<input class="goods_detail_button" type="submit" value="삭제 하기" style="cursor: pointer"  onclick="alert('삭제되었습니다.')" formaction="/service/remove">
				 </c:when>
			 </c:choose>
			 
			
			<div id="detail-box">
				<div>
					<input type="hidden" name="bno" value="${detail.bno}">
					<input type="hidden" name="bno" value="${detail.bgno}">
					<input type="hidden" name="bno" value="${detail.cnt}">		
					<input type="hidden" name="bno" value="${detail.id}">	
					
					<div id="detail-main-box">
						<div><h1>위치 지정 test용</h1></div>
						<div><h2>위치 지정 test sub용</h2></div>	
					</div>
					
					<div id="detail-sub-box">													
						<div><strong>${detail.title }</strong></div>
						<div><p>${detail.price }원</p></div>
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