<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
  <head>
<title>Home</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/post/detail.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/resources/js/post/postAttach.js"></script>
	
</head>
<body>

	<!-- 헤더 파트  -->
		<jsp:include page="../main/header.jsp"></jsp:include>
		<script type="text/javascript" src="/resources/js/main/header.js"></script>
	<!-- 헤더 파트 끝 -->
	
	<div id="wrap">
		
		<section id="main-section">
			<div id="main-section-sub">
				<form name="goods-detail" method="POST">
					<c:choose>
					     <c:when test="${sessionScope.mbloginpost.id=='admin'}">
										<a href="/goods/modify?product_number=${detail.product_number }&category_number=${detail.category_number}" class="goods_detail_button" style="cursor: pointer">상품 수정 하러 하기</a>
							</c:when>
					 </c:choose>
					<c:choose>
					     <c:when test="${sessionScope.mbloginpost.id=='admin'}">
					 		<input class="goods_detail_button" type="submit" value="삭제 하기" style="cursor: pointer"  onclick="alert('삭제되었습니다.')" formaction="/goods/remove">
						 </c:when>
					 </c:choose>
					 
					 <input type="hidden" name="product_number" value="${detail.product_number}">
					<input type="hidden" name="category_number" value="${detail.category_number}">
					<input type="hidden" name="product_stock" value="${detail.product_stock}">	
					<input type="hidden" name="id" value="${mbloginpost.id}">
				</form>
			<div id="detail-box">
				<div>
					
					<div id="detail-main-box">
						<div><h1>위치 지정 test용</h1></div>
						<div><h2>위치 지정 test sub용</h2></div>	
					</div>
					
					<div id="detail-sub-box">												
						<div><strong>${detail.product_name }</strong>
						<span><input name="detail-price" value="${detail.product_price}" class="price">원</span><br>
						<span>
							<fmt:formatNumber value="${detail.product_discount*100}" pattern="###" />%
						</span>
						<div>
							적립 포인트 : <span class="point_span"></span>원
						</div>
						<input type="text" class="quantity_input" value="1">
						<span>
							<button class="plus_btn">+</button>
							<button class="minus_btn">-</button>
						</span>
						<div class="button_set">
							<a class="btn_cart">장바구니 담기</a>
							<a class="btn_buy">바로구매</a>
						</div>
					</div>
				
					
								첨부파일<div id="uploadResult">
									<ul>
				
									</ul>
								</div>
				</div>
			</div>
			</div>
			</section>
		
	<!-- footer 파트 시작 -->
		<jsp:include page="../main/footer.jsp"></jsp:include>
	<!-- footer 파트 시작 -->
	</div>
	<script type="text/javascript" src="/resources/js/post/postdetail.js"></script>
</body>
</html>