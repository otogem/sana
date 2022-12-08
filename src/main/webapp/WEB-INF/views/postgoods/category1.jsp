<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
  <head>
<title>category</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/post/category.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/resources/js/support/supportsearch.js"></script>
</head>
<body>
<!-- 헤더 파트  -->
	<jsp:include page="../main/header.jsp"></jsp:include>
	<script type="text/javascript" src="/resources/js/main/header.js"></script>
<!-- 헤더 파트 끝 -->
	
	<div id="wrap">
		<section id="main-section">
			<div id="category-box">
				
			<form id="searchForm" action="/goods/category" method="get">
				<select name="type">
					<option value="T">제목</option>
					<option value="C">내용</option>
					<option value="TC">제목+내용</option>
				</select>
					<input type="text" name="keyword">
					<input type="hidden" name="category_number" value="${paging.ppa.category_number}">
					<input type="hidden" name="pageNum" value="${paging.ppa.pageNum }" >
					<input type="hidden" name="amount" value="${paging.ppa.amount}">
					<input type="button" value="검색">
			</form>
			
				<div id="category-max-div">총:<span id="category-max-num"> ${list[0].rownum } </span> 건 </div>
				<div id="category-box-sub">
					<c:forEach items="${list }" var="category">
						<div class="category-sell-box"><a href="detail?product_number=${category.product_number }&category_number=1">
							<input type="hidden" name="product_number" value="${category.product_number}">
							<input type="hidden" name="category_number" value="${category.category_number}">
							<input type="hidden" name="cnt" value="${category.product_cnt}">
							<div><img src="/postdisplay?fileName=${category.filem}"></div>																	
							<div><strong>${category.product_name }</strong></div>
							<div><span style="text-decoration: line-through;">${category.product_price }원</span>-></div>
							<div><span>${category.product_discount }할인율</span></div>
							<div>
								<fmt:parseDate value="${category.product_date}" var="product_date" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate pattern="yyyy-MM-dd" value="${product_date}"/>
							</div>
								<div id="uploadResult">
									<ul>
				
									</ul>
								</div>
							</a> 
						</div>
					</c:forEach>
				</div>
		 	
		 	
		 <!-- 페이지 번호 라인  시작-->
		 	<table class="page_table">
				 <tr class="page_table">
			 <!-- prev(이전)이 true이면 이전버튼 화설화 -->
				<td class="page_table">
				<c:if test="${paging.prev}">
					<a href="/goods/category?category_number=${paging.ppa.category_number}&pageNum=${paging.startPage-1}&amount=${paging.ppa.amount}">이전</a>
				</c:if>
				</td>
				
				<!-- begin(1) end(10)될 동안 반복(1일 10일 될 동안 반복) -->
				<td class="page_table">
				<c:forEach begin="${paging.startPage}" end="${paging.endPage }" var="num">
					<td class="${paging.ppa.pageNum eq num ? 'on' : '' }"><a href="/goods/category?category_number=${paging.ppa.category_number}&type=${paging.ppa.type }&keyword=${paging.ppa.keyword }&pageNum=${num }&amount=${paging.ppa.amount}">${num}</a></td>
				</c:forEach>
				</td>
				
				<td class="page_table">
				<c:if test="${paging.next }">
					<a href="/goods/category?category_number=${paging.ppa.category_number}&pageNum=${paging.endPage+1}&amount=${paging.ppa.amount}">다음</a>
				</c:if>
				</td>
			<!-- next(다음)이 true이면 다음버튼 활성화 -->
			 	</tr>
			 </table>
		 <!-- 페이지 번호 라인  끝-->
		 
		 	<c:choose>
				<c:when test="${mbloginpost.id != null || kakaoInfo.nickname != null }">
				 	<input id="category_button" type="submit" value="상품등록하기" style="cursor: pointer" onclick="location.href='/goods/write?category_number=1'";>
				 </c:when>
			 </c:choose>
			 
			</div>
	
		</section>
		
	<!-- footer 파트 시작 -->
		<jsp:include page="../main/footer.jsp"></jsp:include>
	<!-- footer 파트 시작 -->
	</div>
</body>
</html>