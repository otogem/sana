<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
<title>category-write</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/post/write.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 헤더 파트  -->
	<jsp:include page="../main/header.jsp"></jsp:include>
	<script type="text/javascript" src="/resources/js/main/header.js"></script>
<!-- 헤더 파트 끝 -->
	
	<div id="wrap">
		<section id="main-section">
			<c:if test="${bgno lt 50 }">
			<span id="service_main_title">글쓰기 "${bgno}"</span>
			
			<form id="form" role="form" method="post">
			<table id="write-table">
				<tr><td><input type="hidden" name="id" value="${sessionScope.mbloginpost.id}"></td></tr>
				<tr><td><input type="hidden" name="name" value="${sessionScope.mbloginpost.name}"></td></tr>
				<tr><td><input type="hidden" name="bgno" value="${bgno}"></td></tr>
				<tr><td class="service_sub_font">상품이름</td></tr>
				<tr><td><input type="text" name="title" style="width:100%" class="service_sub_font"></td></tr>
				
				<tr><td class="service_sub_font">제품상세내용</td></tr>
				<tr><td><textarea id="service_sub_content" class="service_sub_font" name="content" vlaue="content" style="width:100%" rows="10" class="service_sub_font" ></textarea></td></tr>
				
				<tr><td class="service_sub_font">가격</td></tr>
				<tr><td><input type="text" name="price" style="width:50%" placeholder="가격"></td></tr>
				
				<tr><td><input type="submit" id="uploadBtn" style="cursor: pointer" value="상품 등록"></td></tr>

			</table>
			</form>
			</c:if>
		</section>
		
	<!-- footer 파트 시작 -->
		<jsp:include page="../main/footer.jsp"></jsp:include>
	<!-- footer 파트 시작 -->
	</div>
</body>
</html>