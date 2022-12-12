<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
<title>category-write</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/support/supportdetail.css" rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script type="text/javascript" src="../resources/js/support/supportAttach.js"></script>
</head>
<body>
<!-- 헤더 파트  -->
	<jsp:include page="../main/header.jsp"></jsp:include>
	<script type="text/javascript" src="/resources/js/main/header.js"></script>
<!-- 헤더 파트 끝 -->
	
	<div id="wrap">
		<section id="main-section">
			<div id="main-section-sub">
			
			<form name="formsdetail" method="POST">
					<table>
						<tr>
							<td>
			<c:choose>
			     <c:when test="${detail.id==sessionScope.mbloginpost.id || sessionScope.mbloginpost.id=='admin'}">
								<a href="/support/modify?bno=${detail.bno }&bgno=${detail.support_number}" class="support_detail_button" style="cursor: pointer">수정 하러 하기</a>
					</c:when>
			 </c:choose>
			<c:choose>
			     <c:when test="${detail.id==sessionScope.mbloginpost.id || sessionScope.mbloginpost.id=='admin'}">
			 		<input class="support_detail_button" type="submit" value="삭제 하기" style="cursor: pointer"  onclick="alert('삭제되었습니다.')" formaction="/support/remove">
				 </c:when>
			 </c:choose>
							</td>
						</tr>
						<tr>
							<td class="service_sub_font">제목</td>
						</tr>
					
						<tr>
							<td><input class="service_sub_font" type="text" name="title" value="${detail.title }" readonly="readonly"></td>
							<td><input type="hidden" name="support_number" value="${detail.support_number}"></td>
							<td><input type="hidden" name="bno" value="${detail.bno}"></td>
							<td><input type="hidden" name="name" value="${detail.name}"></td>
						</tr>
						
						<tr>
							<td class="service_sub_font">내용</td>
						</tr>
						
						<tr>
							<td><textarea id="service_sub_content" class="service_sub_font" name="content" cols="50" rows="10"  readonly="readonly">${detail.content }</textarea></td>
						</tr>
						<tr>
							<td>첨부파일				
								<div id="uploadResult">
									<ul>
				
									</ul>
								</div>
							</td>
						</tr>
						
					</table>
					</form>
				</div>
		</section>
		
	<!-- footer 파트 시작 -->
		<jsp:include page="../main/footer.jsp"></jsp:include>
	<!-- footer 파트 시작 -->
	</div>
</body>
</html>