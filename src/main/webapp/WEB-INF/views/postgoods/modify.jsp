<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
  <head>
<title>Home</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/post/modify.css" rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script type="text/javascript" src="/resources/js/post/postUploadAjax.js"></script>
	<script type="text/javascript" src="/resources/js/post/postUploadModify.js"></script>
	<script type="text/javascript" src="/resources/js/post/postmodify.js"></script>
</head>
<body>

	<!-- 헤더 파트  -->
		<jsp:include page="../main/header.jsp"></jsp:include>
		<script type="text/javascript" src="/resources/js/main/header.js" ></script>
	<!-- 헤더 파트 끝 -->
	
	<div id="wrap">
		<section id="main-section">
			<div id="main-section-sub">
						
			<form role="form" method="POST" action="/goods/modify">
			<table id="write-table">
				
			
				<tr><td class="service_sub_font">상품이름</td></tr>
				<tr>
					<td><input type="text" name="product_name" style="width:100%" class="service_sub_font" value="${detail.product_name }"></td>
					<td><input type="hidden" name="category_number" value="${detail.category_number}"></td>
					<td><input type="hidden" name="product_number" value="${detail.product_number}"></td>
				</tr>
				
				<tr><td class="service_sub_font">제품상세내용</td></tr>
				<tr><td><textarea id="service_sub_content" class="service_sub_font" name="product_desc" style="width:100%" rows="10" class="service_sub_font" >${detail.product_desc }</textarea></td></tr>
				
				<tr><td class="service_sub_font">가격</td></tr>
				<tr><td><input type="text" name="product_price" style="width:50%" placeholder="가격" value="${detail.product_price }"></td></tr>
				
				<tr><td class="service_sub_font">재고(수량)</td></tr>
				<tr><td><input type="text" name="product_stock" style="width:50%" placeholder="수량" value="${detail.product_stock }"></td></tr>
				
				<tr><td class="service_sub_font">할인</td></tr>
				<tr>
					<td>
						<input type="text" id="discount_interface" maxlength="2" value="<fmt:formatNumber type="number" maxFractionDigits="0" value="${detail.product_discount*100 }" />" style="width:50%">
						<input type="text" name="product_discount" value="${detail.product_discount }">
						<span class="step_val">할인 가격 : 
							<span class="span_discount"></span>
						</span>
					</td>
				</tr>
				
				<tr><td><input type="submit" id="uploadBtn" style="cursor: pointer" value="상품 수정" onclick="alert('상품 수정 완료')" formaction="/goods/modify"></td></tr>
				
			</table>
			</form>
							<div id="uploaddiv"><input type="file" name="uploadFile" multiple>첨부파일</div>			
							<div id="uploadResult">
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