<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
  <head>
<title>category</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/post/category.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 헤더 파트  -->
	<jsp:include page="../main/header.jsp"></jsp:include>
	<script type="text/javascript" src="/resources/js/main/header.js"></script>
<!-- 헤더 파트 끝 -->
	
	<div id="wrap">
		<section id="main-section">
			<div id="category-box">
			
				<div>총:${writePost.rownum} 건</div>
			
				<div>총:${category.rownum} 건</div>
				<div id="category-box-sub">
					<c:forEach items="${list }" var="category">
						<div class="category-sell-box"><a href="category/detail?bno=${category.bno }&bgno=1">
							<input type="hidden" name="bno" value="${category.bno}">
							<input type="hidden" name="bno" value="${category.bgno}">
							<input type="hidden" name="bno" value="${category.cnt}">																
							<div><strong>${category.title }</strong></div>
							<div><p>${category.price }원</p></div>
							<div>	<fmt:parseDate value="${category.regdate}" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate pattern="yyyy-MM-dd" value="${regdate}"/></div>
							</a>
						</div>
					</c:forEach>
				</div>
				
			<c:choose>
				<c:when test="${mbloginpost.id != null || kakaoInfo.nickname != null }">
				 	<input id="category_button" type="submit" value="상품등록하기" style="cursor: pointer" onclick="location.href='/goods/write?bgno=1'";>
				 </c:when>
				 <c:otherwise>
				 <input id="category_button" type="submit" value="상품등록하기" style="cursor: pointer" onclick="alert('로그인 해주세요')";>
				 </c:otherwise>
			 </c:choose>
		 	
		 	
		 	<!-- 페이지 번호 라인  시작-->
		 	
		 	<!-- 페이지 번호 라인  끝-->
			</div>
	
		</section>
		
	<!-- footer 파트 시작 -->
		<jsp:include page="../main/footer.jsp"></jsp:include>
	<!-- footer 파트 시작 -->
	</div>
</body>
</html>