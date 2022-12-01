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
			<div id="main-section-sub">
			<c:forEach items="${list }" var="support">
			<div class="category-sell-box"><a href="detail?bno=${support.bno }&support_number=1">
					<input type="test" name="support_number" value="${support.bno}">
					<input type="tset" name="category_number" value="${support.support_number}">
					<input type="tset" name="cnt" value="${support.cnt}">																	
					<div><strong>${support.title }</strong></div>
					<div><p>${support.content }</p></div>
					<div>	<fmt:parseDate value="${support.regdate}" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:formatDate pattern="yyyy-MM-dd" value="${regdate}"/></div>
					텟트
				<div id="uploadResult">
					<ul>
				
					</ul>
				</div>
				</a> 
			</div>
			</c:forEach>	
				
			<c:choose>
				<c:when test="${mbloginpost.id != null || kakaoInfo.nickname != null }">
				 	<input id="category_button" type="submit" value="상품등록하기" style="cursor: pointer" onclick="location.href='/support/write?support_number=1'";>
				 </c:when>
				 <c:otherwise>
				 <input id="category_button" type="submit" value="상품등록하기" style="cursor: pointer" onclick="alert('로그인 해주세요')";>
				 </c:otherwise>
			 </c:choose>
			 </div>
		</section>
		
	<!-- footer 파트 시작 -->
		<jsp:include page="../main/footer.jsp"></jsp:include>
	<!-- footer 파트 시작 -->
	</div>
</body>
</html>