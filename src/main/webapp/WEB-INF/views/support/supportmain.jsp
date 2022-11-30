<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
<title>category-write</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/support/supportmain.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 헤더 파트  -->
	<jsp:include page="../main/header.jsp"></jsp:include>
	<script type="text/javascript" src="/resources/js/main/header.js"></script>
<!-- 헤더 파트 끝 -->
	
	<div id="wrap">
		<section id="main-section">
			고객센터
			
			<c:choose>
				<c:when test="${mbloginpost.id != null || kakaoInfo.nickname != null }">
				 	<input id="category_button" type="submit" value="상품등록하기" style="cursor: pointer" onclick="location.href='/support/write?support_number=1'";>
				 </c:when>
				 <c:otherwise>
				 <input id="category_button" type="submit" value="상품등록하기" style="cursor: pointer" onclick="alert('로그인 해주세요')";>
				 </c:otherwise>
			 </c:choose>
		</section>
		
	<!-- footer 파트 시작 -->
		<jsp:include page="../main/footer.jsp"></jsp:include>
	<!-- footer 파트 시작 -->
	</div>
</body>
</html>