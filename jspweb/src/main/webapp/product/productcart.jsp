<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/productcart.css" rel="stylesheet">

</head>
<body>
	<!-- css에서 정의되지 않은 클래스명은 모두 부트스트랩  -->
	
	<%@include file = "../header.jsp" %>
		<div class="container"> <!-- container(b) : 컨테이너  -->
			<table class="table my-5" id="carttable"> <!-- table(b) : 테이블 // my(b) : 위아래 마진(바깥여백) -->
				
			</table>
		</div>
	<script type="text/javascript" src="/jspweb/js/productcart.js"></script>
	<%@include file = "../footer.jsp" %>
	
	
	
	

</body>
</html>