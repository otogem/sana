<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
<title>사나 고객센터</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/support/supportmain.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/resources/js/support/supportsearch.js"></script>
</head>
<body>
<!-- 헤더 파트  -->
	<jsp:include page="../main/header.jsp"></jsp:include>
	<script type="text/javascript" src="/resources/js/main/header.js"></script>
<!-- 헤더 파트 끝 -->
	
	<div id="wrap">
		<section id="main-section">
			<div id="main-section-sub">

			<form id="searchForm" action="/support/user" method="get">
				<select name="type">
					<option value="T">제목</option>
					<option value="C">내용</option>
					<option value="TC">제목+내용</option>
				</select>
					<input type="text" name="keyword">
					<input type="hidden" name="support_number" value="${paging.spa.support_number}">
					<input type="hidden" name="pageNum" value="${paging.spa.pageNum }" >
					<input type="hidden" name="amount" value="${paging.spa.amount}">
					<input type="button" value="검색">
			</form>
			
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
				
				<table class="page_table">
				 <tr class="page_table">
			 <!-- prev(이전)이 true이면 이전버튼 화설화 -->
				<td class="page_table">
				<c:if test="${paging.prev}">
					<a href="/support/user?support_number=${paging.spa.support_number}&pageNum=${paging.startPage-1}&amount=${paging.spa.amount}">이전</a>
				</c:if>
				</td>
				
				<!-- begin(1) end(10)될 동안 반복(1일 10일 될 동안 반복) -->
				<td class="page_table">
				<c:forEach begin="${paging.startPage}" end="${paging.endPage }" var="num">
					<td class="${paging.spa.pageNum eq num ? 'on' : '' }"><a href="/support/user?support_number=${paging.spa.support_number}&type=${paging.spa.type }&keyword=${paging.spa.keyword }&pageNum=${num }&amount=${paging.spa.amount}">${num}</a></td>
				</c:forEach>
				</td>
				
				<td class="page_table">
				<c:if test="${paging.next }">
					<a href="/support/user?support_number=${paging.spa.support_number}&pageNum=${paging.endPage+1}&amount=${paging.spa.amount}">다음</a>
				</c:if>
				</td>
			<!-- next(다음)이 true이면 다음버튼 활성화 -->
			 	</tr>
			 </table>
				
			<c:choose>
				<c:when test="${mbloginpost.id != null || kakaoInfo.nickname != null }">
				 	<input id="support_button" type="submit" value="상품등록하기" style="cursor: pointer" onclick="location.href='/support/write?support_number=1'";>
				 </c:when>
				 <c:otherwise>
				 <input id="support_button" type="submit" value="상품등록하기" style="cursor: pointer" onclick="alert('로그인 해주세요')";>
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