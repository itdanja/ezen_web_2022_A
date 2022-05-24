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

	<%@include file = "../header.jsp" %>
		<div class="container">
		
			<div class="processbox">
				<span> 01 옵션선택 </span> <span> > </span>
				<span> 02 장바구니 </span> <span> > </span>
				<span  > 03 주문결제 </span> <span> > </span>
				<span id="process_active"> 04 주문완료 </span>
			</div>	
			
			<h3> 주문 완료 </h3>
			<button> 내 주문내역 </button>
		</div>
	<script type="text/javascript" src="/jspweb/js/orderpay.js"></script>
	<%@include file = "../footer.jsp" %>

</body>
</html>



