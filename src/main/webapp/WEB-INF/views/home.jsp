<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
<title>Home</title>
	<jsp:include page="main/maincss.jsp"></jsp:include>
	<link href="../resources/css/main/home.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 헤더 파트  -->
	<jsp:include page="main/header.jsp"></jsp:include>
	<script type="text/javascript" src="/resources/js/main/header.js"></script>
<!-- 헤더 파트 끝 -->
	<div id="wrap">
		<section id="main-section">
			test 용 메인 페이지<br>
			test용 메윈 페이지
			<c:if test="${mbloginpost.id != null }">
			<h1>TEST용</h1>
			${mbloginpost.id }
			${mbloginpost.password }
			
			
			
			</c:if>
			<c:if test="${mbloginpost.id == null }"> ${mbloginpost.id} 
			두번째if
			</c:if>
			<c:forEach items="${list }" var="home">
				${home.id }
				${home.password }
			</c:forEach>
			<c:if test="${sessionScope.mbloginpost.id == 'admin' }">
			<h1>이게돼네</h1>
			</c:if>
		</section>

	<!-- footer 파트 시작 -->
		<jsp:include page="main/footer.jsp"></jsp:include>
	<!-- footer 파트 시작 -->
	</div>
</body>
</html>
