<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
<title>category-write</title>
	<jsp:include page="../main/maincss.jsp"></jsp:include>
	<link href="../resources/css/support/supportwrite.css" rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script type="text/javascript" src="../resources/js/support/supportUploadAjax.js"></script>
</head>
<body>
<!-- 헤더 파트  -->
	<jsp:include page="../main/header.jsp"></jsp:include>
	<script type="text/javascript" src="/resources/js/main/header.js"></script>
<!-- 헤더 파트 끝 -->
	
	<div id="wrap">
		<section id="main-section">
			<div id="main-section-sub">
			<form id="form" role="form" method="post">
			<table>
				<tr><td><input type="hidden" name="id" value="${sessionScope.mbloginpost.id}"></td></tr>
				<tr><td><input type="hidden" name="name" value="${sessionScope.mbloginpost.name}"></td></tr>
				<tr><td><input type="hidden" name="support_number" value="${support_number}"></td></tr>
				<tr><td class="support_sub_font">제목</td></tr>
				<tr><td><input type="text" name="title" class="support_sub_font"></td></tr>
				
				<tr><td class="support_sub_font">내용</td></tr>
				<tr><td><textarea id="support_sub_content" class="support_sub_font" name="content" vlaue="content" cols="50" rows="10" class="service_sub_font" ></textarea></td></tr>
				
				<tr><td><input type="button" id="uploadBtn" style="cursor: pointer" value="글쓰기"></td></tr>

			</table>
			</form>
				<div id="uploaddiv"><input type="file" name="uploadFile" multiple></div>
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