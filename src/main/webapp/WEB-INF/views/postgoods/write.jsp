<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
<title>category-write</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/post/write.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/resources/js/post/postUploadAjax.js"></script>
</head>
<body>
<!-- 헤더 파트  -->
	<jsp:include page="../main/header.jsp"></jsp:include>
	<script type="text/javascript" src="/resources/js/main/header.js"></script>
<!-- 헤더 파트 끝 -->
	
	<div id="wrap">
		<section id="main-section">
					<div id="main-section-sub">
			<span id="service_main_title">글쓰기 "${category_number}"</span>
			
			<form id="form" role="form" method="post">
			<table id="write-table">
				<tr><td><input type="hidden" name="category_number" value="${category_number}"></td></tr>
				<tr><td class="service_sub_font">상품이름</td></tr>
				<tr><td><input type="text" name="product_name" style="width:100%" class="service_sub_font"></td></tr>
				
				<tr><td class="service_sub_font">제품상세내용</td></tr>
				<tr><td><textarea id="service_sub_content" class="service_sub_font" name="product_desc" style="width:100%" rows="10" class="service_sub_font" ></textarea></td></tr>
				
				<tr><td class="service_sub_font">가격</td></tr>
				<tr><td><input type="text" name="product_price" style="width:50%" placeholder="가격"></td></tr>
				
				<tr><td class="service_sub_font">재고(수량)</td></tr>
				<tr><td><input type="text" name="product_stock" style="width:50%" placeholder="재고"></td></tr>
				
				<tr><td class="service_sub_font">할인</td></tr>
				<tr><td><input type="text" name="product_discount" style="width:50%" placeholder="할인률"></td></tr>
				
				<tr><td><input type="submit" id="uploadBtn" style="cursor: pointer" value="상품 등록"></td></tr>
				
				
			</table>
			</form>
					<div id="uploaddiv"><input type="file" name="uploadFile" multiple></div>
					<div id="uploadResult">상품이미지
								<ul>
							
								</ul>
						</div>
					</div>
		</section>
		
	<!-- footer 파트 시작 -->
		<jsp:include page="../main/footer.jsp"></jsp:include>
	<!-- footer 파트 시작 -->
	</div>
</body>
</html>