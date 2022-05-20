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
				<span  id="process_active"> 03 주문결제 </span> <span> > </span>
				<span> 04 주문완료 </span>
			</div>	
				
			<div class="row my-5">
				<div class="col-sm-3 offset-3">
					<a href="/jspweb/main.jsp">
						<button class="form-control py-4"> 계속 쇼핑하기 </button>
					</a> 
				</div>
				<div class="col-sm-3">
					<button onclick="payment()" style="background-color: blue; color: white;" class="form-control py-4"> 결제하기 </button>
				</div>
			</div>
		</div>
	<!-- iamport.payment.js -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	<script type="text/javascript" src="/jspweb/js/orderpay.js"></script>
	<%@include file = "../footer.jsp" %>
</body>
</html>